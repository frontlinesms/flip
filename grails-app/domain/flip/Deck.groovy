package flip

class Deck {
	String name
	static hasMany = [cards:Card]
    static constraints = {
    	name(nullable:false)
    }
}
