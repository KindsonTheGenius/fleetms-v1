
$('document').ready(function(){

    $('table #editButton').on('click',function(event){
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(role, status){
            $('#idEdit').val(role.id);
            $('#descriptionEdit').val(role.description);
            $('#detailsEdit').val(role.details);
        });
        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click',function(event) {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(role, status){
            $('#idDetails').val(role.id);
            $('#descriptionDetails').val(role.description);
            $('#detailsDetails').val(role.details);
            $('#lastModifiedByDetails').val(role.lastModifiedBy);
            $('#lastModifiedDateDetails').val(role.lastModifiedDate.substr(0,19).replace("T", " "));
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
