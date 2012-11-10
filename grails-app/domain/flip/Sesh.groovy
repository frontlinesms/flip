package flip

class Sesh {
	Game game
	static hasMany = [cards: Card, ansas: Ansa]
    static constraints = {
    	game(nullable:false)
    	cards(nullable:false)
    }
    List cards
    int pos
    boolean complete

    def nextCard() {
    	return cards[pos]
    }
}
