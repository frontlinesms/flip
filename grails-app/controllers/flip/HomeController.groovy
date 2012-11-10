package flip

class HomeController{
	def index(){
		def dataModel = [tags:['Maths','Medicine','Language', 'Chinese', 'Eglish'], popularTags:['Maths','Arabic']]
		render view:'/home/index', model:dataModel
	}
}