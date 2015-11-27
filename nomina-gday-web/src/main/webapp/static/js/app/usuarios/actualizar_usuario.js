var idUsuario=getParameter("id");
var username=getParameter("nick");
//console.log("USUARIOS!")
//console.log(idUsuario);
//console.log(username);

//Valida los elementos del Formulario
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
			var idRol=($('#rol').find(":selected").val())
			console.log("idRol")
			console.log(idRol)
			obtenerUsuario(idUsuario, username);
			},	
		error: function (response) {																	
			$("#resultadoGuardar").html("Error");
			}		
	});
	
	$("#actualizarUsuarioForm").validate({
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
//Obtener el idNomina por parametros en la url, que se manda desde el controller
//*******************************************************************************

function getParameter(parameter){
	// Obtiene la cadena completa de URL
	var url = location.href;
	/* Obtiene la posicion donde se encuentra el signo ?, 
	ahi es donde empiezan los parametros */
	var index = url.indexOf("?");
	/* Obtiene la posicion donde termina el nombre del parametro
	e inicia el signo = */
	index = url.indexOf(parameter,index) + parameter.length;
	/* Verifica que efectivamente el valor en la posicion actual 
	es el signo = */ 
	if (url.charAt(index) == "="){
	// Obtiene el valor del parametro
	var result = url.indexOf("&",index);
	if (result == -1){result=url.length;};
	// Despliega el valor del parametro
	return url.substring(index + 1,result);
	}
} 


//*******************************************************************************
//Function que obtiene la nomina por idNomina y llama a la function 
//muestraDatos()
//*******************************************************************************
function obtenerUsuario(idUsuario, username){
	//console.log("OBTENER DATOS");
	//console.log(idUsuario);
	//console.log(username);
	$.ajax({
		sync:true,
		data: {
			"id" : idUsuario,
			"username" : username,
	},
	dataType:'json',
	url:   '../../mvc/usuario/obtenerusuarioconrolesbyid',
	type:  'post',		
	beforeSend: function () {	
	},
	success:  function (response) {
		//console.log("RESPONSE")
		//console.log(response)
		muestraDatosUsuario(response);	
		},	
	error: function (response) {																	
		$("#resultadoGuardar").html("Error");
		//console.log("RESPONSE ERROR")
		//console.log(response)
		}		
	});		
}

//*******************************************************************
//Function que obtiene todos los datos del Ejecutivo por idEjecutivo*
//*******************************************************************
function obtenerEjecutivo(idEjecutivo){
	$.ajax({
		data: {
			"idEjecutivo" : idEjecutivo
	},
	dataType:'json',
	url:   '../../mvc/usuario/obtenerejecutivobyid',
	type:  'post',		
	beforeSend: function () {	
	},
	success:  function (response) {
		muestraDatosGrupo(response);	
		},	
	error: function (response) {																	
		$("#resultadoGuardar").html("Error");
		}		
	});		
	
}

//*******************************************************************************
//Function que obtiene los datos registrados de la Nomina para modificarlos 
//*******************************************************************************
function muestraDatosUsuario(datos){
	console.log("datos");
	var data=eval(datos);
	$("#nombre").val(data.nombre);
	$("#app").val(data.apellidoP);
	$("#apm").val(data.apellidoM);
	$("#nick").val(data.username);
	$("#estatus").val(data.activo);
	$("#password").val(data.password);
	console.log(data)
	$("#rol").val(data.rol);
	$("#idUsuario").val(data.id);
	$("#idEjecutivo").val(data.idEjecutivo);
}

//*******************************************************************************
//Function que obtiene los datos de la BD que se agregan a los combos del SELECT
//*******************************************************************************


//*************************************************
//Function que actualiza todos los datos del Grupo*
//*************************************************
function actualizarUsuario() {
	//console.log("ROL Y ID");
	//console.log($("#rol").val());
	//console.log($("#idUsuario").val());
	console.log("idRol");
	var idRol=($('#rol').find(":selected").val())
	console.log(idRol)
	if ($("#actualizarUsuarioForm").valid()){	
		$
			.ajax({
				data : {
					"idEjecutivo" : $("#idEjecutivo").val(),
					"nombre" : $("#nombre").val(),
					"apellidoP" : $("#app").val(),
					"apellidoM" : $("#apm").val(),
					"username" : $("#nick").val(),
					"activo" : $("#estatus").val(),
					"password" : $("#password").val(),
					"rol" : $("#rol").val(),
					"id" : $("#idUsuario").val(),
				},
				
				dataType : 'json',
				url : '../../mvc/usuario/modificarusuario',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {
					mensajeRedireccion("USUARIO ACTUALIZADO CORRECTAMENTE","../usuarios/usuarios.jsp");


				},
				error : function(response) {
					mensaje("IMPOSIBLE ACTUALIZAR EL USUARIO. CONTACTE CON EL ADMINISTRADOR.");
				}
			});
		}
}

function cancelar(){
	top.frames['main'].location="../usuarios/usuarios.jsp"; 	
}
