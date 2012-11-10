package flip

class SeshController {
	def scaffold = true

	def start() {
		redirect(action: 'nxt')
	}

	def nxt() {
		def seshInstance = Sesh.get(params.seshId)
		if (params.lastPos) {
			seshInstance.addToAnsas(new Ansa(card: seshInstance.cards[params.lastPos], correct: params.lastAnsa == "true"))
			seshInstance.pos += 1
		}
		else
			seshInstance.post = 0
		seshInstance.save(failOnError: true)
		[card: seshInstance.nextCard()]
	}

	def stats() {
		def seshInstance = Sesh.get(params.id)
		def total = seshInstance ? seshInstance.ansas.count() : null
		def totalCorrect = seshInstance ? seshInstance.ansas.findAllByCorrect(true).count() : null
		render(view:"stats.gsp", model: [seshInstance: seshInstance, total: total, totalCorrect: totalCorrect])
	}
}
