/*
 * Funciones basicas para la web
 */
//Funcion principal
$(function () {
    console.log("DOM inicializado");
    $('[data-modal-show-on-error="true"]').each(function () {
        $(this).modal('show');
    });

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
      $('#tablaAltaFarmaceuticos').DataTable({
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
      
      $('#comboComunidades').on('change', function (e) {
    	  var andalucia =["Almería", "Granada","Córdoba","Jaén","Sevilla","Málaga","Cádiz","Huelva"];
    	  var aragon=["Huesca","Zaragoza", "Teruel"];
    	  var asturias=["Asturias"];
    	  var baleares=["Baleares"];
    	  var canarias=["Santa Cruz de Tenerife","Las Palmas"];
    	  var cantabria=["Santander"];
    	  var castillaMancha=["Toledo"," Ciudad Real"," Cuenca"," Guadalajara "," Albacete"];
    	  var castillaLeon=["León","Palencia","Salamanca","Burgos","Zamora","Valladolid","Soria","Segovia","Ávila"];
    	  var catalunya=["Barcelona","Tarragona","Lérida ","Gerona"];
    	  var extremadura=["Cáceres ","Badajoz"];
    	  var galicia=["La Coruña"," Lugo"," Orense ","Pontevedra"];
    	  var rioja=["La Rioja"];
    	  var madrid=["Madrid"];
    	  var navarra=["Navarra"];
    	  var paisVasco=["Álava"," Guipúzcoa ","Vizcaya"];
    	  var murcia=["Murcia"];
    	  var valencia=["Castellón"," Valencia ","Alicante"];
    	  var ceuta=["Ceuta"];
    	  var melilla=["Melilla"];
    	  var optionSelected = $("option:selected", this);
    	  var valueSelected = this.value;  
    	  var select = document.getElementById('comboProvincia');
    	  while (select.firstChild) {
    		    select.removeChild(select.firstChild);
    		}
    	  switch (valueSelected) {
			case "Andalucia":	
				var myobject=andalucia;
				for(index in myobject) {
				    select.options[select.options.length] = new Option(myobject[index], myobject[index]);
				}
				break;
			case "Aragon":	
				var myobject=aragon;
				for(index in myobject) {
				    select.options[select.options.length] = new Option(myobject[index], myobject[index]);
				}
				break;
			case "Canarias":	
				var myobject=canarias;
				for(index in myobject) {
				    select.options[select.options.length] = new Option(myobject[index], myobject[index]);
				}
				break;
			case "Cantabria":	
				var myobject=cantabria;
				for(index in myobject) {
				    select.options[select.options.length] = new Option(myobject[index], myobject[index]);
				}
				break;
			case "Castilla y Leon":	
				var myobject=castillaLeon;
				for(index in myobject) {
				    select.options[select.options.length] = new Option(myobject[index], myobject[index]);
				}
				break;
			case "Castilla-La Mancha":	
				var myobject=castillaMancha;
				for(index in myobject) {
				    select.options[select.options.length] = new Option(myobject[index], myobject[index]);
				}
				break;
			case "Catalunya":	
				var myobject=catalunya;
				for(index in myobject) {
				    select.options[select.options.length] = new Option(myobject[index], myobject[index]);
				}
				break;
			case "Ceuta":	
				var myobject=ceuta;
				for(index in myobject) {
				    select.options[select.options.length] = new Option(myobject[index], myobject[index]);
				}
				break;
			case "Comunidad Valenciana":	
				var myobject=valencia;
				for(index in myobject) {
				    select.options[select.options.length] = new Option(myobject[index], myobject[index]);
				}
				break;
			case "Comunidad de Madrid":	
				var myobject=madrid;
				for(index in myobject) {
				    select.options[select.options.length] = new Option(myobject[index], myobject[index]);
				}
				break;
			case "Extremadura":	
				var myobject=extremadura;
				for(index in myobject) {
				    select.options[select.options.length] = new Option(myobject[index], myobject[index]);
				}
				break;
			case "Galicia":	
				var myobject=galicia;
				for(index in myobject) {
				    select.options[select.options.length] = new Option(myobject[index], myobject[index]);
				}
				break;
			case "Islas Baleares":	
				var myobject=baleares;
				for(index in myobject) {
				    select.options[select.options.length] = new Option(myobject[index], myobject[index]);
				}
				break;
			case "La Rioja":	
				var myobject=rioja;
				for(index in myobject) {
				    select.options[select.options.length] = new Option(myobject[index], myobject[index]);
				}
				break;
			case "Melilla":	
				var myobject=melilla;
				for(index in myobject) {
				    select.options[select.options.length] = new Option(myobject[index], myobject[index]);
				}
				break;
			case "Navarra":	
				var myobject=navarra;
				for(index in myobject) {
				    select.options[select.options.length] = new Option(myobject[index], myobject[index]);
				}
				break;
			case "Pais Vasco":	
				var myobject=paisVasco;
				for(index in myobject) {
				    select.options[select.options.length] = new Option(myobject[index], myobject[index]);
				}
				break;
			case "Principado de Asturias":	
				var myobject=asturias;
				for(index in myobject) {
				    select.options[select.options.length] = new Option(myobject[index], myobject[index]);
				}
				break;
			case "Region de Murcia":	
				var myobject=murcia;
				for(index in myobject) {
				    select.options[select.options.length] = new Option(myobject[index], myobject[index]);
				}
				break;
			default:
				break;
		}
    	});
});
/*

 * Funciones basicas para la web
 */
//Funcion principal
$(function () {
    console.log("DOM inicializado");

    $('[data-modal-show-on-error="true"]').modal('show');

    $('[data-collapse-show-on-error="true"]').collapse('show');

    $('[data-ui-back]').on('click', function (e) {
    	e.preventDefault();
    	history.back()
    });

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
      $('#tablaAltaFarmaceuticos').DataTable({
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

/*

 * Funciones basicas para la web
 */
//Funcion principal
$(function () {
    console.log("DOM inicializado");

    $('[data-modal-show-on-error="true"]').modal('show');

    $('[data-collapse-show-on-error="true"]').collapse('show');

    $('[data-ui-back]').on('click', function (e) {
    	e.preventDefault();
    	history.back()
    });

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
      $('#tablaAltaFarmaceuticos').DataTable({
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
