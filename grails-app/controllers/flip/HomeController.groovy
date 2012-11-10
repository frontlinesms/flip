package flip

class HomeController{
	def index(){
		def dataModel = [tags: Deck.allTags, popularTags: Deck.allTags]
		render view:'/home/index', model:dataModel
	}
}