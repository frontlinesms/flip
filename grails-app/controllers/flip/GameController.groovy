package flip

class GameController {
	def scaffold = true

	def splash() {
		[gameInstance:Game.get(params.id)]
	}
}

