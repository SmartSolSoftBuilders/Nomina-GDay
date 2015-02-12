//*************************************************
//Function que actualiza todos los datos del Grupo*
//*************************************************
function actualizarUsuario() {
	if ($("#actualizarUsuarioForm").valid()){	
		$
			.ajax({
				data : {
					"nombre" : $("#nombre").val(),
					"username" : $("#nick").val(),
					"activo" : $("#estatus").val(),
					"password" : $("#password").val(),
				},
				
				dataType : 'json',
				url : '../../mvc/usuario/modificarusuario',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {
					mensajeRedireccion("GRUPO ACTUALIZADO CORRECTAMENTE","../usuarios/usuarios.jsp");


				},
				error : function(response) {
					mensaje("IMPOSIBLE ACTUALIZAR EL GRUPO. CONTACTE CON EL ADMINISTRADOR.");
				}
			});
		}
}

function cancelar(){
	top.frames['main'].location="../usuarios/usuarios.jsp"; 	
}
