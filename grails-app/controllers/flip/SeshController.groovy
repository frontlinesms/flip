package flip

class SeshController {
	def scaffold = true

	def start() {
		redirect(action: 'nxt')
	}

	def nxt() {
		def seshInstance = // TODO
		if(params.lastPos) {
			seshInstance.addToAnsas(new Ansa(card: seshInstance.cards[params.lastPos], correct: params.lastAnsa == "true"))
			seshInstance.pos += 1
		}
		else
			seshInstance.post = 0
		seshInstance.save(failOnError: true)
		[card: seshInstance.nextCard()]
	}

}
