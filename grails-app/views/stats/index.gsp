<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Stats</title>
	</head>
	<body>
		<h1>Statistics for <sec:loggedInUserInfo field="username"/></h1>
		
		<flip:dataTable id="recent" data="${recentGames}"/>
		<flip:dataTable id="favourite" data="${favouriteGames}"/>
		<flip:dataTable id="incomplete" data="${incompleteGames}"/>
	</body>
</html>

