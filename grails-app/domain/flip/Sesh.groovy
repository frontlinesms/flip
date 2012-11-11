package flip

class Sesh {
	Game game
	static hasMany = [cards: Card, ansas: Ansa]
	static belongsTo = [user: User]

	static constraints = {
		user(nullable: true)
	}
	List cards
	List ansas
	int pos = 0
	boolean complete = false

	def nextCard() {
		return cards[pos]
	}

	def getCardAt(int pos) {
		return cards[pos]
	}

	def detectCompletion() {
		return pos >= (cards.size())
	}

	def getCorrectCount() {
		return ansas.findAll { it.correct }.size()
	}

    def incorrectCards() {
        return ansas.findAll { !it.correct }.card
    }
    
    def correctCount() {
    	return ansas.findAll { it.correct }.size()
    }
}

