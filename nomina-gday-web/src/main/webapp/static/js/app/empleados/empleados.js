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

//**************************************************
//Function que llama al Formulario Agregar Empleado*
//**************************************************
function showAgregarEmpleado(){
	top.frames['main'].location="../empleados/agregar_empleado.jsp"; 	
}


function showEditarEmpleado(id){
	top.frames['main'].location="../empleados/actualizar_empleado.jsp?id="+id; 	
}

function altaMasivaDeEmpleado(){
	top.frames['main'].location="../carga/carga.jsp"; 	
}