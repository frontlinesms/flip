<%@ page import="flip.Deck" %>

<div class="fieldcontain ${hasErrors(bean: deckInstance, field: 'cards', 'error')} ">
	<label for="cards">
		<g:message code="deck.cards.label" default="Cards" />
		
	</label>
	<g:select name="cards" from="${flip.Card.list()}" multiple="multiple" optionKey="id" size="5" value="${deckInstance?.cards*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean:deckInstance, field:'cards', 'error')}">
	<label for="cards">
		<g:message code="deck.cards.file.label" default="Card File (CSV, XLS etc.)" />
		
	</label>
	<input type="file" maxlength="100000" name="cardFile"/>
</div>

<div class="fieldcontain ${hasErrors(bean: deckInstance, field: 'tags', 'error')} ">
	<label for="tags">
		<g:message code="deck.tags.label" default="Tags" />
	</label>
	<g:textField name="tags" value="${deckInstance?.tags.join(',')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: deckInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="deck.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${deckInstance?.name}"/>
</div>

