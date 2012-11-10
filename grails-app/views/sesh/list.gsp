
<%@ page import="flip.Sesh" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'sesh.label', default: 'Sesh')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-sesh" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-sesh" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="complete" title="${message(code: 'sesh.complete.label', default: 'Complete')}" />
					
						<th><g:message code="sesh.game.label" default="Game" /></th>
					
						<g:sortableColumn property="pos" title="${message(code: 'sesh.pos.label', default: 'Pos')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${seshInstanceList}" status="i" var="seshInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${seshInstance.id}">${fieldValue(bean: seshInstance, field: "complete")}</g:link></td>
					
						<td>${fieldValue(bean: seshInstance, field: "game")}</td>
					
						<td>${fieldValue(bean: seshInstance, field: "pos")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${seshInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
