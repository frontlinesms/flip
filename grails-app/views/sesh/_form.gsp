<%@ page import="flip.Sesh" %>



<div class="fieldcontain ${hasErrors(bean: seshInstance, field: 'user', 'error')} ">
	<label for="user">
		<g:message code="sesh.user.label" default="User" />
		
	</label>
	<g:select id="user" name="user.id" from="${flip.User.list()}" optionKey="id" value="${seshInstance?.user?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: seshInstance, field: 'ansas', 'error')} ">
	<label for="ansas">
		<g:message code="sesh.ansas.label" default="Ansas" />
		
	</label>
	<g:select name="ansas" from="${flip.Ansa.list()}" multiple="multiple" optionKey="id" size="5" value="${seshInstance?.ansas*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: seshInstance, field: 'cards', 'error')} ">
	<label for="cards">
		<g:message code="sesh.cards.label" default="Cards" />
		
	</label>
	<g:select name="cards" from="${flip.Card.list()}" multiple="multiple" optionKey="id" size="5" value="${seshInstance?.cards*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: seshInstance, field: 'complete', 'error')} ">
	<label for="complete">
		<g:message code="sesh.complete.label" default="Complete" />
		
	</label>
	<g:checkBox name="complete" value="${seshInstance?.complete}" />
</div>

<div class="fieldcontain ${hasErrors(bean: seshInstance, field: 'game', 'error')} required">
	<label for="game">
		<g:message code="sesh.game.label" default="Game" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="game" name="game.id" from="${flip.Game.list()}" optionKey="id" required="" value="${seshInstance?.game?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: seshInstance, field: 'pos', 'error')} required">
	<label for="pos">
		<g:message code="sesh.pos.label" default="Pos" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="pos" required="" value="${fieldValue(bean: seshInstance, field: 'pos')}"/>
</div>

