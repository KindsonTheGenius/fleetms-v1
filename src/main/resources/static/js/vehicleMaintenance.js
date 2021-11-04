/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleMaintenance, status){
			$('#idEdit').val(vehicleMaintenance.id);
			$('#priceEdit').val(vehicleMaintenance.price);
			$('#remarksEdit').val(vehicleMaintenance.remarks);
			$('#ddlSupplierEdit').val(vehicleMaintenance.supplierid);
			$('#ddlVehicleEdit').val(vehicleMaintenance.vehicleid);
			
			//Create a date variable and extract only the date part of the fiedl
			var startDate = vehicleMaintenance.startDate.substr(0,10);
			var endDate = vehicleMaintenance.endDate.substr(0,10);
			
			$('#startDateEdit').val(startDate);
			$('#endDateEdit').val(endDate);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleMaintenance, status){
			$('#idDetails').val(vehicleMaintenance.id);
			$('#priceDetails').val(vehicleMaintenance.price);
			$('#remarksDetails').val(vehicleMaintenance.remarks);
			$('#ddlSupplierDetails').val(vehicleMaintenance.supplierid);
			$('#ddlVehicleDetails').val(vehicleMaintenance.vehicleid);
			
			var startDate = vehicleMaintenance.startDate.substr(0,10);
			var endDate = vehicleMaintenance.endDate.substr(0,10);
			
			$('#startDateDetails').val(startDate);
			$('#endDateDetails').val(endDate);
			$('#lastModifiedByDetails').val(vehicleMaintenance.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehicleMaintenance.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #confirmDeleteButton').attr('href', href);
		$('#deleteModal').modal();		
	});	
});