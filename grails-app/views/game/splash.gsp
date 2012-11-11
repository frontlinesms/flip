<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'game.label', default: 'Game')}" />
		<title>Start a new game</title>
	</head>
		<div class='container thirteen columns offset-by-four island'>
	            <div class='flashcard row eight columns'>
			<p>
				${gameInstance.name}<br/>
				<small>(
					<g:link controller="browse" action="playDeck" id="${gameInstance.id}">
						Start!
					</g:link>)
				</small><br/>
				<small><small>Tags:</small></small>
				<g:each in="${gameInstance.deck.tags}" var="tag">
					<small><small><g:link controller="browse" action="decks" params="${[tag:tag]}">${tag}</g:link></small></small>
				</g:each>
			</p>
	            </div>
	            <div class='row eight columns buttons'>
		</div>
	    </div>
	</body>
</html>

