<g:if test="${searchResult?.results}">
    <div> Search String : ${searchString}</div>
	<g:each in="${searchResult.results}" var="result">
        <g:if test="${result instanceof flip.Deck}">
            <div>
                <g:link controller="browse" action="playDeck" params="${[id:result.id]}">${result.name}</g:link>
            </div>
        </g:if>
	</g:each>

    Page:
    <g:set var="totalPages" value="${Math.ceil(searchResult.total / searchResult.max)}" />
    <g:if test="${totalPages == 1}">
        <span class="currentStep">1</span>
    </g:if>
    <g:else>
        <g:paginate controller="searchable" action="index" params="[q: params.q]" total="${searchResult.total}" prev="&lt; previous" next="next &gt;"/>
    </g:else>
</g:if>