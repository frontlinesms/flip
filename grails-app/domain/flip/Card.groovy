package flip
import org.grails.taggable.*

class Card implements Taggable{
	String a
	String b

	String toString() { "CARD[$a/$b]" }
}
