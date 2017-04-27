/* 
 * Funciones basicas para la web
 */
//Funcion principal
$('document').ready(function(){
    
    console.log("DOM inicializado");
    $("#pagoEfectivo").hide();
    $("#pagoTarjeta").hide();
    $("#pagoPayPal").hide();

    $('.datePicker').datepicker({
        format: 'dd/mm/yyyy'
    }).on('changeDate', function(e) {
        // Revalidate the date field
        $('#eventForm').formValidation('revalidateField', 'date');
    });
    $('input[type=radio][name=formaPago]').change(function() {
        if (this.value == '0') {
            $("#pagoEfectivo").hide();
            $("#pagoTarjeta").hide();
            $("#pagoPayPal").show();
        }
        else if (this.value == '1') {
            $("#pagoEfectivo").hide();
            $("#pagoTarjeta").show();
            $("#pagoPayPal").hide();
        }
        else if (this.value == '2') {
            $("#pagoEfectivo").show();
            $("#pagoTarjeta").hide();
            $("#pagoPayPal").hide();
        }
    });
    $("#btnNuevousuario").on("click",function(){
        var codigo=$("codNuevoUsuario").val();
        if(codigo==="" || codigo===undefined || codigo===null)
            alert("Codigo no valido");
    });
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
      $('#tablaPedidosPc').DataTable({
          "paging": true,
          "lengthChange": true,
          "searching": true,
          "ordering": true,
          "info": true,
          "autoWidth": false
        });
      $('#tablaTratamiento').DataTable({
          "paging": true,
          "lengthChange": true,
          "searching": true,
          "ordering": true,
          "info": true,
          "autoWidth": false
        });
      $('#tablaAltaFarmacias').DataTable({
          "paging": true,
          "lengthChange": true,
          "searching": true,
          "ordering": true,
          "info": true,
          "autoWidth": false
        });
      $('#tablaAltaMedicos').DataTable({
          "paging": true,
          "lengthChange": true,
          "searching": true,
          "ordering": true,
          "info": true,
          "autoWidth": false
        });
      $('#tablaMedicamento').DataTable({
          "paging": true,
          "lengthChange": true,
          "searching": true,
          "ordering": true,
          "info": true,
          "autoWidth": false
        });
});


