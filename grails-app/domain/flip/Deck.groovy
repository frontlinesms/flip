package flip

class Deck {
	String name
	static hasMany = [cards:Card]

	String toString() { "DECK[$name]" }
}
