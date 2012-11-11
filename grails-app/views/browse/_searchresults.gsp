<g:if test="${searchResult?.results}">
    <div> What you searched for : ${searchString}</div>
    <ul>
    	<g:each in="${matchedDecks}" var="result">
            <li class="deck-item">
                <g:link controller="browse" action="playDeck" params="${[id:result.id]}">${result.name}</g:link>
            </li>
    	</g:each>
    </ul>

    Page:
    <g:set var="totalPages" value="${Math.ceil(searchResult.total / searchResult.max)}" />
    <g:if test="${totalPages == 1}">
        <span class="currentStep">1</span>
    </g:if>
    <g:else>
        <g:paginate controller="searchable" action="index" params="[q: params.q]" total="${searchResult.total}" prev="&lt; previous" next="next &gt;"/>
    </g:else>
</g:if>