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
        if (this.value == 'p') {
            $("#pagoEfectivo").hide();
            $("#pagoTarjeta").hide();
            $("#pagoPayPal").show();
        }
        else if (this.value == 't') {
            $("#pagoEfectivo").hide();
            $("#pagoTarjeta").show();
            $("#pagoPayPal").hide();
        }
        else if (this.value == 'e') {
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
});


