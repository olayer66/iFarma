<!DOCTYPE html>
<html lang="es">
<head>
    
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 
    <title>iFarma - Farmacia</title>
     <!-- Para Datatables (cambiar el stylesheet) -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs-3.3.7/jq-2.2.4/dt-1.10.13/af-2.1.3/b-1.2.4/kt-2.2.0/sc-1.4.2/se-1.2.0/datatables.min.css"/>
    <script type="text/javascript" src="https://cdn.datatables.net/v/bs-3.3.7/jq-2.2.4/dt-1.10.13/af-2.1.3/b-1.2.4/kt-2.2.0/sc-1.4.2/se-1.2.0/datatables.min.js"></script>
   

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet"> 
    <!-- Custom CSS -->
    <link href="css/3-col-portfolio.css" rel="stylesheet">




    
    <script>
        $(function () {
          $('#tablaStock').DataTable({
            "paging": true,
            "lengthChange": true,
            "searching": true,
            "ordering": true,
            "info": true,
            "autoWidth": false
          });
          $('#tablaPedidos').DataTable({
            "paging": true,
            "lengthChange": true,
            "searching": true,
            "ordering": true,
            "info": true,
            "autoWidth": false
          });
        });
    </script>
</head>