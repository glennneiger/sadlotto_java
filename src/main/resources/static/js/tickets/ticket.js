$(function() {
	$('.remove-button').click(function() {
	  $(this).closest('.number-group-table-row').hide();
	  calculate();
	});
	
	$('.add-button').click(function() {
		$('.number-group-table-row:hidden').first().show();
		calculate();
	});	
	
	$('.participating-checkbox').click(function() {
		var checkbox = $(this);
		var tableRow = checkbox.closest('.transaction-table-row');
		
		if (!checkbox.is(':checked'))
		{
			tableRow.addClass('table-secondary');
			//tableRow.find('*').attr('disabled', true);
		}
		else
		{
			tableRow.removeClass('table-secondary');
			//tableRow.find('*').attr('disabled', false);
		}
		
		calculate();
	});
	
	$('.powerplay-checkbox').click(function() {
		calculate();
	});
	
	$('#ticket-form').submit(function() {
		$('.number-group-table-row:hidden').remove();
	});
	
	$('#purchase-user').change(function() {
		var userId = $(this).prop('value');
		var transactionRows = $('.transaction-table-row');
		var totalCost = $('#total-cost').val();
		
		
		
		transactionRows.each(function() {
			var row = $(this);
			
			var isPurchaser = userId == row.prop('id') ? true : false;
			var checkbox = row.find('input[type=checkbox]');
			var type = row.find('td').find('select');
		
			if (isPurchaser)
			{
				
				checkbox.attr('checked', 'true');
				checkbox.attr('disabled', 'true');
				type.val('1')
			}
			else
			{
				checkbox.attr('disabled', false);
				type.val('2');
			}
			
		});
	});
	
	calculate();
});

function calculate() {
	
	var totalCost = 0;
	//get sum of ticket cost
	var numberGroupRows = $('.number-group-table-row:visible');
	
	numberGroupRows.each(function(){
		var $tds = $(this).find('td'),        
        isPowerPlay = $tds.find('input[type=checkbox]').prop('checked'),
        costInput = $tds.eq(7).find('input'),
		cost = 0;
		
		if(isPowerPlay)
		{
			cost = 3;
		}
		else
		{
			cost = 2;
		}
		
		costInput.attr('value', cost);
		totalCost += cost;
		
	});
	
	$('#total-cost').attr('value', totalCost);
	
}
