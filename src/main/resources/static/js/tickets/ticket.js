$(function() {
	$('.remove-button').click(function() {
	  $(this).closest('.number-group-table-row').hide();
	});
	
	$('.add-button').click(function() {
		$('.number-group-table-row:hidden').first().show();
	});
	
	$('.powerplay-checkbox').click(function() {
		calculate($(this));
	});
	
	$('#ticket-form').submit(function() {
		$('.number-group-table-row:hidden').remove();
	});
});

function calculate(checkbox) {
	
	if (checkbox.is (':checked'))
	{
		alert('calculate');
	}
	
}
