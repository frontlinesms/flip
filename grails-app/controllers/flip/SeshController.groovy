package flip

class SeshController {
	def scaffold = true

	def start() {
		redirect(action: 'nxt', params: params)
	}

	def restart() {
		def newSesh = new Sesh(game: Sesh.get(params.id).game, complete:false, cards: Sesh.get(params.id).game.deck.cards).save(failOnError:true, flush:true)
		redirect(action: 'nxt', params:[id: newSesh.id])
	}

	def nxt() {
		def seshInstance = Sesh.get(params.id)
		if (params.lastPos) {
			def ansa = seshInstance.ansas.find { it.card ==  seshInstance.getCardAt(params.lastPos as int)}
			if (ansa)
				ansa.correct = params.lastAnsa
			else
				seshInstance.addToAnsas(new Ansa(card: seshInstance.getCardAt(params.lastPos as int), correct: params.lastAnsa))
			seshInstance.pos = seshInstance.pos + 1
			seshInstance.save(failOnError: true)
		}
		if(seshInstance.detectCompletion())
			redirect(action: 'stats', params:[id: seshInstance.id])
		else
			render view:"play", model:[card: seshInstance.nextCard(), sesh: seshInstance]
	}

	def stats() {
		def seshInstance = Sesh.get(params.id)
		def total = seshInstance ? seshInstance.ansas.size() : null
		def totalCorrect = seshInstance?.correctCount()
		render(view:"stats.gsp", model: [seshInstance: seshInstance, total: total, totalCorrect: totalCorrect])
	}
}
