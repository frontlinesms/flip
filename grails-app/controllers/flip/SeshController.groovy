package flip

class SeshController {
	def scaffold = true

	def start() {
		redirect(action: 'nxt', params: params)
	}

	def restart() {
		def sesh = Sesh.get(params.id)
		def cards
		if (params.incorrectOnly)
			cards = sesh.incorrectCards()
		else 
			cards = sesh.game.deck.cards
		println cards
		def newSesh = new Sesh(game: sesh.game, complete:false, cards: cards).save(failOnError:true, flush:true)
		redirect(action: 'nxt', params:[id: newSesh.id])
	}

	def nxt() {
		println "params::: ${params}"
		def seshInstance = Sesh.get(params.id)
		println "sesh Instance is $seshInstance"
		if (params.lastPos) {
			seshInstance.addToAnsas(new Ansa(card: seshInstance.getCardAt(params.lastPos as int), correct: params.lastAnsa))
			seshInstance.pos = seshInstance.pos + 1
		}
		else
			seshInstance.pos = 0
		seshInstance.save(failOnError: true)
		if(seshInstance.detectCompletion())
			redirect(action: 'stats', params:[id: seshInstance.id])
		else
			render view:"play", model:[card: seshInstance.nextCard(), sesh: seshInstance]
	}

	def stats() {
		def seshInstance = Sesh.get(params.id)
		def total = seshInstance ? seshInstance.ansas.size() : null
		def totalCorrect = seshInstance?.correctCount()
		render(view:"stats.gsp", model: [sesh: seshInstance, total: total, totalCorrect: totalCorrect])
	}
}
