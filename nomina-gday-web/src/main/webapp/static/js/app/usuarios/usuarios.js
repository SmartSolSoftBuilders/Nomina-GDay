//Function que muestra todas las razones sociales en un data table
$(document).ready(function() {
	oTableUsuarios=$('#tablaUsuario').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/usuario/getusuarios',
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
			$('#tablaUsuario').dataTable().fnAddData(response);
			//setData(response);
		}		,
		error:  function (response) {
			alert(response);
		}
	});			

});

//*************************************************
//Function que llama al Formulario Agregar Usuario*
//*************************************************
function showAgregarUsuario(){
	top.frames['main'].location="../usuarios/agregar_usuario.jsp"; 	
}

//****************************************
//Function que llama al Formulario Editar*
//****************************************
function showEditarUsuario(idUsuario, username){
	//http:/../usuarios/actualizar_usuario.jsp?id=1&nick=ADMIN1
	top.frames['main'].location="../usuarios/actualizar_usuario.jsp?id="+idUsuario +"&nick=ADMIN1"; 	
}

