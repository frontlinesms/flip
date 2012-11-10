package flip

class DeckController {
	def scaffold = true

	def rateDeck(){
		if(params.rating){
			def deck = Deck.get(params.deckId)
			deck.rating = ((deck.rating * deck.voteCount) + params.rating) / (deck.voteCount + 1)
			deck.voteCount += 1
			deck.save(failOnError:true)
		}
	}
}
