package flip

class Sesh {
	Game game
	static hasMany = [cards: Card, ansas: Ansa]
    List cards
    List ansas
    int pos
    boolean complete

    def nextCard() {
    	return cards[pos]
    }
}
