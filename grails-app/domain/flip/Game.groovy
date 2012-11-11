package flip

class Game {
	Deck deck
	Double rating = 0.0
	int voteCount

	def rate(rate){
		this.rating = (((this.rating * this.voteCount) + (rate as Integer)) / (this.voteCount + 1))
		this.voteCount = this.voteCount + 1
		this.save(failOnError:true)
	}
	def getCards() {
		return deck.cards
	}
}

