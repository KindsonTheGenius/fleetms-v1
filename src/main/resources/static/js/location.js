
$('document').ready(function(){
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
			
		var href = $(this).attr('href');
		
		$.get(href, function(location, status){
			$('#idEdit').val(location.id);
			$('#cityEdit').val(location.city);
			$('#addressEdit').val(location.address);
			$('#ddlStateEdit').val(location.stateid);
			$('#ddlCountryEdit').val(location.countryid);
			$('#descriptionEdit').val(location.description);
			$('#detailsEdit').val(location.details);
		});					
		$('#editModal').modal();
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(location, status){
			$('#idDetails').val(location.id);
			$('#descriptionDetails').val(location.description);
			$('#detailsDetails').val(location.details);
			$('#cityDetails').val(location.city);
			$('#addressDetails').val(location.address);
			$('#ddlStateDetails').val(location.stateid);
			$('#ddlCountryDetails').val(location.countryid);
			$('#lastModifiedByDetails').val(location.lastModifiedBy);
			$('#lastModifiedDateDetails').val(location.lastModifiedDate.substr(0,19).replace("T", " "));
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