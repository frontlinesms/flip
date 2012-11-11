package flip

class Sesh {
	Game game
	static hasMany = [cards: Card, ansas: Ansa]
	static belongsTo = [user: User]

	static constraints = {
		user(nullable: true)
	}

	Date dateCreated
	Date lastUpdated
	List cards
	List ansas
	int pos = 0
	boolean complete

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

	def getCorrectPercentage() {
		if(!complete) throw new IllegalStateException()
		def ansaCount = ansas.size()
		if(!ansaCount) return 100
		return (correctCount * 100 / ansaCount) as Integer
	}
}

