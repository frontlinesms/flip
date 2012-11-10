package flip

class Sesh {
	Game game
	static hasMany = [cards: Card, ansas: Ansa]
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
        println "pos is $pos and size is ${cards.size()}"
        return pos >= (cards.size())
    }

    def correctCount() {
    	return ansas.findAll { it.correct }.size()
    }
}
