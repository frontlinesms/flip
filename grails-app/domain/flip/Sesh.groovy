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

    def getCardAt(pos) {
    	return cards[pos]
    }
}
