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
			<g:link action="start" params="">Try again! [DOESN'T WORK!]</g:link>
			<g:if test="${totalCorrect != total}">
    			<g:link action="restart" params="${[incorrectOnly: true, id: sesh.id]}">Redo failed cards!</g:link>
			</g:if>
		</div>
	</body>
</html>