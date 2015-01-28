//Valida los elementos del Formulario
$(document).ready(function() {
	$("#actualizarGrupoForm").validate({
		rules: {
			nombre: "required",
			nombreCorto: "required",
		},        
		messages: {
			nombre: "Ingrese el nombre del Grupo",
			nombreCorto:"Ingrese el nombre corto del Grupo",
		},
		
		submitHandler: function(form) {
			form.submit();
		}
	});
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
					"idGrupo" : $("#grupoIdSel").val(),
					"nombre" : $("#nombre").val(),
					"nombreCorto" : $("#nombreCorto").val(),
				},
				
				dataType : 'json',
				url : '../../mvc/grupo/modificagrupo',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {
					$("#resultadoGuardar")
							.html(alert("La actualizaci\u00f3n de Grupo se guard\u00f3 correctamente"));
					top.frames['main'].location="../grupos/grupos.jsp";

				},
				error : function(response) {
					$("#resultadoGuardar").html();
				}
			});
		}
}
