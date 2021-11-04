/**
 * 
 */

$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(state, status){
			$('#idEdit').val(state.id);
			$('#ddlCountryEdit').val(state.countryid);
			$('#capitalEdit').val(state.capipal);
			$('#codeEdit').val(state.code);
			$('#nameEdit').val(state.name);
			$('#detailsEdit').val(state.details);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(state, status){
			$('#idDetails').val(state.id);
			$('#ddlCountryDetails').val(state.countryid);			
			$('#nameDetails').val(state.name);
			$('#detailsDetails').val(state.details);
			$('#lastModifiedByDetails').val(state.lastModifiedBy);
			//$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();		
	});	
});