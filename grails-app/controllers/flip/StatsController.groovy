package flip

class StatsController {
	def springSecurityService
	def statsService

	// TODO enable URL mapping rule for s2 to disable access to this controller unless logged in
	def index() {
println "StatsController.index()"
		def user = springSecurityService.currentUser
		def recent = statsService.getRecentGames(user)
		def favourites = statsService.getFavouriteGames(user)
		def incompletes = statsService.getIncompleteGames(user)
		def model = [recentGames:recent, favouriteGames:favourites, incompleteGames:incompletes]
println "StatsController.index() : model=$model"
		return model
	}
}

