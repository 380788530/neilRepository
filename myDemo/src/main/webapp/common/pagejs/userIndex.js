$(document).ready(function() {
    $('#example').DataTable( {
        "ajax": $("#basePath").val()+"demoController/userData"
    } );
} );