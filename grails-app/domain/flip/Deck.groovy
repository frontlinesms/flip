package flip
import org.grails.taggable.*

class Deck implements Taggable{
	static searchable = true
	String name
	static hasMany = [cards:Card]

	int rating
	int voteCount

	String toString() { "DECK[$name]" }
}
