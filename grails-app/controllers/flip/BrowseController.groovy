package flip

import org.compass.core.engine.SearchEngineQueryParseException

class BrowseController {
	def searchableService
	def springSecurityService

	def index(){
		render model:[tagMap: splitIntoAlphabet(Deck.allTags).sort(), allTagKeys:('a'..'z')], view:'/browse/index'
	}

	def tagsFor(){
		render model:[tagMap: splitIntoAlphabet(Deck.allTags).find{ it.key == params.key }, allTagKeys:('a'..'z'), tagKeyHeader:params.key], view:'/browse/index'
	}

	def decks(){
		def dataModel = [allTagKeys:('a'..'z'), decks:Deck.findAllByTag(params.tag), selectedTag:params.tag]
		render model:dataModel, view:'/browse/index'
	}

    def search(){
        def dataModel
        if (!params.q?.trim()) {
            render model:[allTagKeys:('a'..'z')], view:'/browse/index'
        }
        try {
            render model:[allTagKeys:('a'..'z'), searchResult: searchableService.search(params.q, params), searchString:params.q], view:'/browse/index'
        } catch (SearchEngineQueryParseException ex) {
            render model:[parseException: true], view:'/browse/index'
        }
    }

    def playDeck(){
    	def deck = Deck.get(params.id)
    	def game = Game.findByDeck(deck)?:new Game(deck:deck).save(failOnError:true)
    	def sesh = new Sesh(game:game, user:springSecurityService.currentUser, cards:game.cards).save(failOnError:true)
    	redirect controller: "sesh", action: "start", params:[id:sesh.id]
    }
    
	private splitIntoAlphabet(tags){
	    def data = [:]
	    tags.each {tag->
	        if(data[tag.substring(0,1)]){
	            data[tag.substring(0,1)] << tag
	        } else {
	            data[tag.substring(0,1)] = []
	            data[tag.substring(0,1)] << tag
	        }
	    }
	    data
	}
}