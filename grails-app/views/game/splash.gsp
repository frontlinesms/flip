<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'game.label', default: 'Game')}" />
		<title>Start a new game</title>
	</head>
	<body>
		<h1>${gameInstance.name}</h1>
		<g:link controller="browse" action="playDeck" id="${gameInstance.id}">
			Start!
		</g:link>
	</body>
</html>

