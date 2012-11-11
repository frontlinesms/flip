<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Home</title>
	</head>
	<body>
		<div id="intro">
			<div id="next_button"></div>
			<div class="card"><p>Pick a topic and get learning!</p></div>
			<div class="card"><p>Our range of user-submitted cards covers a wide range of topics</p></div>
			<div class="card"><p>We keep track of your progress in your selected range of topics</p></div>
			<div class="card"><p>FlippMe lets you learn by viewing and sharing flash cards</p></div>
			<div class="card"><p>Weclome to FlippMe, flashcards from the future</p></div>
		</div>
		<div id="home_buttons">
			<button id="browse">Browse</button>
			<button id="sneak-peek">Sneak Peek</button>
		</div>
		<div display:"none">
			<div>
				<h2>Categories</h2>
				<g:each in="${tags}" var="t">
					<span class="tag-value">
						<g:link controller="browse" action="decks" params="${[tag:t]}">${t}</g:link>
					</span>
				</g:each>
			</div>
			<div>
				<h2>Popular</h2>
				<g:each in="${popularTags}" var="t">
					<span class="tag-value">
						<g:link controller="browse" action="decks" params="${[tag:t]}">${t}</g:link>
					</span>
				</g:each>
			</div>
		</div>
	</body>
	<r:script>
$(function() {
	$('.card').each(function() {
		var rand_no = Math.random();
		rand_no = Math.floor(10 - (rand_no * 20));
		console.log(rand_no);
		$(this).css('-moz-transform', 'scale(1) rotate('+ rand_no +'deg) translateX(0px) translateY(0px) skewX(0deg) skewY(0deg)');
		$(this).css('-webkit-transform', 'scale(1) rotate('+ rand_no +'deg) translateX(0px) translateY(0px) skewX(0deg) skewY(0deg)');
		$(this).css('-o-transform', 'scale(1) rotate('+ rand_no +'deg) translateX(0px) translateY(0px) skewX(0deg) skewY(0deg)');
		$(this).css('-ms-transform', 'scale(1) rotate('+ rand_no +'deg) translateX(0px) translateY(0px) skewX(0deg) skewY(0deg)');
		$(this).css('transform', 'scale(1) rotate('+ rand_no +'deg) translateX(0px) translateY(0px) skewX(0deg) skewY(0deg)');
	});
	$("#next_button").live("click", function(){
		$("#intro").children(':last').animate({
			left: "30%",
			opacity: 0.0,
		}, 200, 'linear',
	    function() {
	      $("#intro").children(':last').remove();
	    } );
	});
	$("#browse").live("click", function() { window.location = "browse"; })
	$("#sneak-peek").live("click", function() { window.location = "game/splash/1"; })
})
</r:script>
</html>
