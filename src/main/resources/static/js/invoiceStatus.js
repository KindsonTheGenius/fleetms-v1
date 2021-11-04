
$('document').ready(function(){
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
			
		var href = $(this).attr('href');
		
		$.get(href, function(invoiceStatus, status){
			$('#idEdit').val(invoiceStatus.id);
			$('#descriptionEdit').val(invoiceStatus.description);
			$('#detailsEdit').val(invoiceStatus.details);
		});					
		$('#editModal').modal();
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(invoiceStatus, status){
			$('#idDetails').val(invoiceStatus.id);
			$('#descriptionDetails').val(invoiceStatus.description);
			$('#detailsDetails').val(invoiceStatus.details);
			$('#lastModifiedByDetails').val(invoiceStatus.lastModifiedBy);
			$('#lastModifiedDateDetails').val(invoiceStatus.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('table #deleteButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeleteButton').attr('href', href);
		
		$('#deleteModal').modal();
	});
		
});