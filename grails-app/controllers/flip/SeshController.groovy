package flip

class SeshController {
	def springSecurityService
	def scaffold = true

	def start() {
		redirect(action:'nxt', params:params)
	}

	def restart() {
		def sesh = Sesh.get(params.id)
		def user = springSecurityService.currentUser

		def cards
		if (params.incorrectOnly) {
			cards = sesh.incorrectCards()
		} else {
			cards = sesh.game.cards
		}
		def newSesh = new Sesh(game:sesh.game, complete:false, cards:cards).save(failOnError:true, flush:true)
		redirect(action:'nxt', params:[id:newSesh.id])
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
		if(seshInstance.detectCompletion()) {
			seshInstance.complete = true
			seshInstance.save(failOnError:true)
			redirect(action: 'stats', params:[id: seshInstance.id])
		}
		else
			render view:"play", model:[card: seshInstance.nextCard(), sesh: seshInstance]
	}

	def stats() {
		def seshInstance = Sesh.get(params.id)
		def total = seshInstance ? seshInstance.ansas.size() : null
		def totalCorrect = seshInstance?.correctCount()
		render(view:"stats.gsp", model: [sesh: seshInstance, total: total, totalCorrect: totalCorrect])
	}

	def rateGame() {
		if(params.rating) {
			println "#### Params ## $params.rating"
			def sesh = Sesh.get(params.id)
			sesh.game.rate(params.rating as Integer)
			sesh.refresh()
			println "### $sesh.game.rating"
			render text:"Rate : ${Math.floor(sesh.game.rating + 0.5f)}"
		}
	}
}

