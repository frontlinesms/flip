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
				<div id='score'>
				    <div id='score-chart'>
				    </div>
				    <h4>score: ${sesh.correctPercentage}%</h4>
				</div>
				<span id="game-rating">Rating : ${sesh.game.rating as Integer}</span><br>
				Rate the Deck:
				<g:each in="${(1..5)}" var="rate">
					<g:remoteLink controller="sesh" action="rateGame" params="${[id: sesh.id, rating:rate]}" onSuccess="updateRating(data)">${rate}</g:remoteLink>
				</g:each>
			</div>
			<g:link action="restart" params="${[id:sesh.id]}">Try again!</g:link>
			<g:if test="${totalCorrect!=total}">
  	  			<g:link action="restart" params="${[incorrectOnly:true, id:sesh.id]}">Redo failed cards!</g:link>
			</g:if>
		</div>
	</body>
</html>
<r:script>
function updateRating(data){
	$('#game-rating').text(data);
}
$(document).ready(function(){
	var scores = [['a', ${totalCorrect}], ['b', ${total - totalCorrect}]];

    var score_plot = $.jqplot('score-chart', [scores], {
        seriesDefaults: {
            renderer:$.jqplot.DonutRenderer,
            rendererOptions: {
                startAngle: -90,
            },
            lineWidth: 1.5,
            shadow: false,
        },
        seriesColors:['#7b990e', '#b5e611'],
        grid: {
            'background': 'transparent',
            'borderWidth': 0,
            'shadow': false,
        },
    });		
});
</r:script>

