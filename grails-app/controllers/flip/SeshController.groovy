package flip

class SeshController {
	def scaffold = true

	def start() {
		redirect(action: 'nxt', params: params)
	}

	def nxt() {
		println "params::: ${params}"
		def seshInstance = Sesh.get(params.seshId)
		println "sesh Instance is $seshInstance"
		if (params.lastPos) {
			//seshInstance.addToAnsas(new Ansa(card: seshInstance.getCardAt(params.lastPos), correct: params.lastAnsa == "true"))
			// TODO: uncomment and fix above when stats are needed
			seshInstance.pos = seshInstance.pos + 1
		}
		else
			seshInstance.pos = 0
		seshInstance.save(failOnError: true)
		render view:"play", model:[card: seshInstance.nextCard(), sesh: seshInstance]
	}

}
