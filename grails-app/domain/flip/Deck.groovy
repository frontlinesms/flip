package flip
import org.grails.taggable.*

class Deck implements Taggable{
	static searchable = true
	String name
	static hasMany = [cards:Card]
	static belongsTo = [user: User]
	static constraints = {
		user(nullable: true)
	}
	String toString() { "DECK[$name]" }
}
