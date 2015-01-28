//*************************************************************************
//Function que muestra los datos de los Grupos registrados en un dataTable*
//*************************************************************************
$(document).ready(function() {
	oTableEmpleados=$('#tablaEmpleado').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/empleado/getempleados',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
      	$( "#progressbar" ).progressbar({
		      value: 75
		    });	
        $( "#demo" ).hide();
		},
		success:  function (response) {
			$( "#demo" ).show();
			$( "#progressbar" ).hide();
			$('#tablaEmpleado').dataTable().fnAddData(response);
		}	
	});			

});


