package flip
import org.grails.taggable.*

class Deck implements Taggable{
	String name
	static hasMany = [cards:Card]
	def rating = 0
	def voteCount = 0
}
