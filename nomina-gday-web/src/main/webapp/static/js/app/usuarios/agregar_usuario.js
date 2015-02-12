//**********************************************
//Function que guarda todos los datos del Grupo*
//**********************************************
function agregarUsuario() {
	if ($("#agregarUsuarioForm").valid()){	
		$
			.ajax({
				data : {
					"nombre" : $("#nombre").val(),
					"username" : $("#nick").val(),
					"activo" : $("#estatus").val(),
					"password" : $("#password").val(),
				},
				
				dataType : 'json',
				url : '../../mvc/usuario/guardarusuario',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {
					mensajeRedireccion("USUARIO CREADO CORRECTAMENTE","../usuarios/usuarios.jsp");
				},
				error : function(response) {
					mensaje("IMPOSIBLE GUARDAR EL USUARIO. CONTACTE CON EL ADMINISTRADOR.");
				}
			});
		}
}


function cancelar(){
	top.frames['main'].location="../usuarios/usuarios.jsp"; 	
}
