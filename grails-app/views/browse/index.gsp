<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Browse | FlippMe</title>
	</head>
	<body>
		<div>
			<div id="search-form-container">
				<g:render template="/browse/searchform"/>
			</div>
			<div id="tag-navigation-bar">
				<g:link controller="browse">All Tags</g:link>
				<g:each in="${allTagKeys}" var="key">
					<g:link controller="browse" action="tagsFor" params="${[key:key]}">${key.toUpperCase()}</g:link>
				</g:each>
			</div>
			<div>
				<g:render template="/browse/searchresults"/>
			</div>
			<div id="tag-dictionary">
				<g:if test="${tagKeyHeader}">
					<p>Tags starting with : ${tagKeyHeader}</p>
				</g:if>
				<g:if test="${tagMap}">
					<g:each in="${tagMap}" var="tag">
					<span id="tag-title">${tag.key}</span>
						<div id="dic-letter">
								<g:each in="${tag.value}" var="t">
									<span class="tag-value">
										<g:link controller="browse" action="decks" params="${[tag:t]}">${t}</g:link>
									</span>
								</g:each>
						</div>
					</g:each>
				</g:if>
			</div>

			<div>
				<g:if test="${decks}">
					<p>Decks tagged : ${selectedTag}</p>
					<ul>
						<g:each in="${decks}" var="deck">
							<li class="deck-item">
								<g:link controller="browse" action="playDeck" params="${[id:deck.id]}">${deck.name}</g:link>
							</li>
						</g:each>
					</ul>
				</g:if>
			</div>
		</div>
	</body>
</html>