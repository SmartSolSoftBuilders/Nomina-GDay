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

var idGpo=getParameter("id");

//Valida los elementos del Formulario
$(document).ready(function() {
	$("#actualizarGrupoForm").validate({
		rules: {
			nombre: "required",
			nombreCorto: {
				required:true,
				maxlength: 14
				}
		},        
		messages: {
			nombre: "Ingrese el nombre del Grupo",
			nombreCorto:{
				required:"Ingrese el nombre corto del Grupo",
				maxlength: "El m\u00e1ximo de caracteres es 15"
				}
		},
		
		submitHandler: function(form) {
			form.submit();
		}
	});
	obtenerGrupo(idGpo);
});//Cierra la validacion del formulario	

//***********************************************************
//Function que obtiene todos los datos del Grupo por idGrupo*
//***********************************************************
function obtenerGrupo(idGrupo){
	$.ajax({
		data: {
			"idGrupo" : idGrupo
	},
	dataType:'json',
	url:   '../../mvc/grupo/obtenergrupobyid',
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
	
	$("#divGrupos").dialog({close: function(event, ui) { window.location.reload(); }});
}

//***********************************************
//Function que muestra todos los datos del Grupo*
//***********************************************
function muestraDatosGrupo(datos){
	var data=eval(datos);	
	$("#nombre").val(data.nombre);
	$("#nombreCorto").val(data.nombreCorto);
	$("#grupoIdSel").val(data.idGrupo);

}


//*************************************************
//Function que actualiza todos los datos del Grupo*
//*************************************************
function actualizarGrupo() {
	if ($("#actualizarGrupoForm").valid()){	
		$
			.ajax({
				data : {
					"idGrupo" : idGpo,
					"nombre" : $("#nombre").val(),
					"nombreCorto" : $("#nombreCorto").val(),
				},
				
				dataType : 'json',
				url : '../../mvc/grupo/modificagrupo',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {
					mensajeRedireccion("GRUPO ACTUALIZADO CORRECTAMENTE","../grupos/grupos.jsp");
				},
				error : function(response) {
					mensaje("IMPOSIBLE ACTUALIZAR EL GRUPO. CONTACTE CON EL ADMINISTRADOR.");
				}
			});
		}
}
