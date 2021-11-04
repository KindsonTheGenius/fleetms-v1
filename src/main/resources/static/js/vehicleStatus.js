
$('document').ready(function(){
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
			
		var href = $(this).attr('href');
		
		$.get(href, function(vehicleStatus, status){
			$('#idEdit').val(vehicleStatus.id);
			$('#descriptionEdit').val(vehicleStatus.description);
			$('#detailsEdit').val(vehicleStatus.details);
		});					
		$('#editModal').modal();
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleStatus, status){
			$('#idDetails').val(vehicleStatus.id);
			$('#descriptionDetails').val(vehicleStatus.description);
			$('#detailsDetails').val(vehicleStatus.details);
			$('#lastModifiedByDetails').val(vehicleStatus.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehicleStatus.lastModifiedDate.substr(0,19).replace("T", " "));
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