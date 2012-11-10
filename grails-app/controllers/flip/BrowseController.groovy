package flip

class BrowseController {
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