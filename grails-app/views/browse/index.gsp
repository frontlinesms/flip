<div>
	<g:render template="/browse/searchform"/>
</div>
<div>
	<g:link controller="browse">All Tags</g:link>
	<g:each in="${allTagKeys}" var="key">
		<g:link controller="browse" action="tagsFor" params="${[key:key]}">${key.toUpperCase()}</g:link>
	</g:each>
</div>
<div>
	<g:render template="/browse/searchresults"/>
</div>
<div>
	<g:if test="${tagKeyHeader}">
		<p>Tags starting with : ${tagKeyHeader}</p>
	</g:if>
	<g:if test="${tagMap}">
		<g:each in="${tagMap}" var="tag">
			<h3>${tag.key}</h3>
			<p>
				<g:each in="${tag.value}" var="t">
					<g:link controller="browse" action="decks" params="${[tag:t]}">${t}</g:link>
				</g:each>
			</p>
		</g:each>
	</g:if>
</div>

<div>
	<g:if test="${decks}">
		<p>Decks tagged : ${selectedTag}</p>
		<g:each in="${decks}" var="deck">
			<g:link controller="sesh" action="start" params="${[id:deck.id]}">${deck.name}</g:link>
		</g:each>
	</g:if>
</div>