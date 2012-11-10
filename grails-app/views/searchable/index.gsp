<g:form name="search" url="[action:'index',controller:'searchable']">
	<g:textField name="q" value="${searchString}"/>
	<g:submitButton name="search-button" value="Search"/>
</g:form>
<div> Search String : ${searchString}</div>
${searchResult}
<g:if test="${searchResult?.results}">
	<g:each in="${searchResult.results}" var="result">
		<div>
			<g:link controller="deck" action="show" id="${result.id}">${result.name}</g:link>
		</div>
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