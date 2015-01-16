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

function muestraDatosGrupo(datos){
	var data=eval(datos);	
	$("#nombre").val(data.nombre);
	$("#nombreCorto").val(data.nombreCorto);
	$("#grupoIdSel").val(data.idGrupo);

}

function actualizarGrupo() {
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
