$(function() {
	$('.remove-button').click(function() {
	  $(this).closest('.number-group-table-row').hide();
	});
	
	$('.add-button').click(function() {
		$('.number-group-table-row:hidden').first().show();
	});
	
	$('#ticket-form').submit(function() {
		$('.number-group-table-row:hidden').remove();
	});
});