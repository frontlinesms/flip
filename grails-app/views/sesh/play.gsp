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
			<div class='container thirteen columns offset-by-four island'>
	            <div class='flashcard row eight columns'>
	                <p class='clue'>
	                    ${card.a.cardHtml}
	                </p>
	                <p class='answer'>
	                    ${card.b.cardHtml}
	                </p>
	            </div>
	            <br class='clear'/>
	            <div class='row eight columns buttons'>
	                <a class='button-std flipper' href='#' id="flip_button">Flip</a>
					<div id="ans_controls" style="display:none" class='choosers'>
						<g:link href='#' class="next_right button-std chooser correct" controller="sesh" action="nxt" params="${[lastAnsa:true, lastPos:sesh.pos, id:sesh.id]}">Hit</g:link>
						<g:link href='#' class="next_wrong button-std chooser incorrect" controller="sesh" action="nxt" params="${[lastAnsa:false, lastPos:sesh.pos, id:sesh.id]}">Miss</g:link>
					</div>
	            </div>
	        </div>
			<div id="debug">
				You can use 'F' to flip, 'J' for :-) and 'K' for :-(
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
	});
	$(document).bind('keypress', 'f', function() { $("#flip_button").trigger("click") } );
	$(document).bind('keypress', 'j', function() {
		if($("#ans_controls").css('display') != 'none')
			window.location = $(".next_right").attr('href'); 
	});
	$(document).bind('keypress', 'k', function() {
		if($("#ans_controls").css('display') != 'none')
			window.location = $(".next_wrong").attr('href');
	});
});
</r:script>
