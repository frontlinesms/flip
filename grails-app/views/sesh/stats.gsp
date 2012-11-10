<%@ page import="flip.Sesh" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'sesh.label', default: 'Sesh')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="stats">
			<h2>You rock (or not) you got ${totalCorrect} out of ${total}</h2>
		</div>
		<div id="controls">
			<div>
				Rate the Deck: 
				<g:each in="${(1..5)}" var="rate">
					<g:remoteLink controller="deck" action="rateDeck" params="${[id: seshInstance.id, rating:rate]}">${rate}</g:remoteLink>
				</g:each>
			</div>
			<g:link action="restart" params="${[id: seshInstance.id]}">Try again!</g:link>
		</div>
	</body>
</html>
