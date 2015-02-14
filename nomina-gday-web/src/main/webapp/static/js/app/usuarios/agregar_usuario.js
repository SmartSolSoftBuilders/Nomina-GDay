//Valida los elementos del Formulario
$(document).ready(function() {
	$("#agregarUsuarioForm").validate({
		rules: {
			nombre: "required",
			nick: "required",
			password: "required",
			
		},        
		messages: {
			nombre: "Ingrese el nombre",
			nick: "Ingrese un nick",
			password: "Ingrese un password",
		},
		
		submitHandler: function(form) {
			form.submit();
		}
	});
});//Cierra la validacion del formulario	

//*******************************************************************************
//Function que obtiene los datos de la BD que se agregan a los combos del SELECT
//*******************************************************************************
$(document).ready(function() {
	$.ajax({
		sync:true,
		dataType:'json',
		url:   '../../mvc/usuario/getdatoscombo',
		type:  'post',		
		beforeSend: function () {	
		},
		success:  function (response) {
			console.log (response[0]);
			console.log ("Rol Usuario");
			var options = "";
			var result=response[0];
			 for (var i = 0; i < result.length; i++) {
			    	options += '<option value="' + result[i].rol + '">' + result[i].rol + '</option>';
			    }
			$("#rol").append(options)		    
			},	
		error: function (response) {																	
			$("#resultadoGuardar").html("Error");
			}		
	});			
});

//**********************************************
//Function que guarda todos los datos del Grupo*
//**********************************************
function agregarUsuario() {
	console.log("nombreRol");
	console.log($("#rol").val());
	if ($("#agregarUsuarioForm").valid()){	
		
		$
			.ajax({
				data : {
					"nombre" : $("#nombre").val(),
					"username" : $("#nick").val(),
					"activo" : $("#estatus").val(),
					"password" : $("#password").val(),
					"rol" : $("#rol").val(),
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
