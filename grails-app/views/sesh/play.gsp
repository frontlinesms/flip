<%@ page import="flip.Sesh" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'sesh.label', default: 'Sesh')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="game">
			<div id="current_card">
				<span id="card_a">${card.a}</span>
				<span id="card_b" style="display:none">${card.b}</span>
			</div>
			<div id="quest_controls">
				<a href="#" id="flip_button">flip</a>
			</div>
			<div id="ans_controls" style="display:none">
				<g:link controller="sesh" action="nxt" params="${[lastAnsa:true, lastPos:sesh.pos, seshId:sesh.id]}">:-)</g:link>
				<g:link controller="sesh" action="nxt" params="${[lastAnsa:false, lastPos:sesh.pos, seshId:sesh.id]}">:-(</g:link>
			</div>
			<div id="debug">
				${sesh.ansas}
			</div>
		</div>
	</body>
</html>
<r:script>
$(function() { 
	$("#flip_button").live("click", function() {
		$("#card_a").hide();
		$("#quest_controls").hide();
		$("#card_b").show();
		$("#ans_controls").show();
	})
});
</r:script>