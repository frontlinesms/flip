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
		def newSesh = new Sesh(game:sesh.game, complete:false, cards:sesh.game.cards, user:user).save(failOnError:true, flush:true)
		redirect(action:'nxt', params:[id:newSesh.id])
	}

	def nxt() {
		def seshInstance = Sesh.get(params.id)
		if (params.lastPos) {
			seshInstance.addToAnsas(new Ansa(card: seshInstance.getCardAt(params.lastPos as int), correct: params.lastAnsa))
			seshInstance.pos = seshInstance.pos + 1
		}
		else
			seshInstance.pos = 0
		seshInstance.save(failOnError: true)
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
		render(view:"stats.gsp", model: [seshInstance: seshInstance, total: total, totalCorrect: totalCorrect])
	}
}
