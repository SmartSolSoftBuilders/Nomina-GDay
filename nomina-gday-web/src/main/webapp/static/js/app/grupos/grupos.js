//*************************************************************************
//Function que muestra los datos de los Grupos registrados en un dataTable*
//*************************************************************************
$(document).ready(function() {
	oTableGrupos=$('#tablaGrupo').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/grupo/getgruposaeditar',
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
			$('#tablaGrupo').dataTable().fnAddData(response);
		}	
	});			

});

//*****************************************************
//Function que llama al Formulario Agregar Grupo desde*
//*****************************************************
function showAgregarGrupo(){
	top.frames['main'].location="../grupos/agregar_grupo.jsp"; 	
}


function obtenerGrupo(id){	
	top.frames['main'].location="../grupos/actualizar_grupo.jsp?id="+id;
}