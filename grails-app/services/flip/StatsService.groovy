package flip

class StatsService {
	def getRecentGames(user) {
		def values = Sesh.findAllByUser(user, [max:3, sort:'lastUpdated', order:'desc']).collect { s ->
			[s.game.name, s.lastUpdated, s.complete? s.correctPercentage: null, s.complete? [view:o(s), playagain:o(s.game)]: [continue:o(s)]]
		}
		/* [
			keys:['name', 'played', 'score'],
			values:[
				['Amharic Alphabet', new Date(), 97, [view:['sesh',1], playagain:['game',1]]],
				['Cyrillic Alphabet', new Date()-1, null, [continue:['sesh',2]]],
				['Amharic Alphabet', new Date()-7, 77, [view:['sesh',4], playagain:['game',1]]],
			]
		]*/
		[
			keys:['name', 'played', 'score'],
			values:values
		]
	}

	def getFavouriteGames(user) {
		[
			keys:['name', 'playcount', 'lastscore'],
			/* values:[
				['Amharic Alphabet', 6, 97, [playagain:['game',1]]],
				['Cyrillic Alphabet', 4, 67, [playagain:['game',2]]],
				['Mister Men', 1, 7, [playagain:['game',4]]],
			] */
			values:[
				['Amharic Alphabet', 6, 97, [playagain:['game',1]]],
				['Cyrillic Alphabet', 4, 67, [playagain:['game',2]]],
				['Mister Men', 1, 7, [playagain:['game',4]]],
			]
		]
	}

	def getIncompleteGames(user) {
		[
			keys:['name', 'started', 'progress'],
			values:[
				['Cyrillic Alphabet', 2356654L, 67, false],
				['Cyrillic Alphabet', , 55654656L, 32, false],
				['Mister Men', 56789433L, 7, false],
			]
		]
	}

	private def o(o) {
		String d = o instanceof Sesh? 'sesh': o instanceof Game? 'game': null
		if(!d) throw new IllegalArgumentException()
		[d, o.id]
	}
}

