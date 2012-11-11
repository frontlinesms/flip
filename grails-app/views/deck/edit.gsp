<%@ page import="flip.Deck" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'deck.label', default: 'Deck')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="edit_deck">
			<g:form name="save" action='save' >
				<input type="hidden" name="id" value="${deck?.id}"/>
				<input type="hidden" name="card_ids_to_delete" id="card_ids_to_delete" value=""/>
				Name your Deck: <g:textField name="name" value="${deck?.name}"/>
				<a id="add_card">new card</a>
				<table id="edit_cards">
					<thead>
						<th>Question</th>
						<th colspan="2">Answer</th>
					</thead>
					<tbody id="card_list">
						<g:each in="${deck?.cards}" var="card" status="i">
							<tr class="edit_card">
								<input type="hidden" name="card_id" value="${card.id}"/>
								<td><g:textField name="card_a" value="${card.a}"></g:textField></td>
								<td><g:textField name="card_b" value="${card.b}"></g:textField></td>
								<td><a class="drop_card">X</a></td>
							</tr>
						</g:each>
					</tbody>
				</table>
				<input type="submit" value="save"/>
			</g:form>
		</div>
		the deck is ${deck}
	</body>
	<r:script>
		$(function() {
			$("#add_card").live("click", function() { 
				// add new field
				$("#card_list").append('<tr class="edit_card"><input type="hidden" name="card_id" value=""><td><input type="text" name="card_a" value="" ></td><td><input type="text" name="card_b" value=""></td><td><a class="drop_card">X</a></td></tr>');
			});
			$(".drop_card").live("click", function() { 
				// drop field
				console.log('dropp');
				$("#card_ids_to_delete").val($("#card_ids_to_delete").val() + $(this).parents('tr').find('input[name="card_id"]').val() +",");
				$(this).parents('tr').remove();
			});
		});
	</r:script>
</html>
