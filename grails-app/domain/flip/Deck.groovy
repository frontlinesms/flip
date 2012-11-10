package flip
import org.grails.taggable.*

class Deck implements Taggable{
	String name
	static hasMany = [cards:Card]
	String toString() { "DECK[$name]" }
	def rating = 0
	def voteCount = 0
}
