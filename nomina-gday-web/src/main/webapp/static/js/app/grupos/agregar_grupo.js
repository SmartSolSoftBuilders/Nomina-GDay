function guardarGrupo() {
		$
			.ajax({
				data : {
					"nombre" : $("#nombre").val(),
					"nombreCorto" : $("#nombreCorto").val(),
				},
				
				dataType : 'json',
				url : '../../mvc/grupo/guardargrupo',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {
					mensajeRedireccion("Grupo creado correctamente","../grupos/grupos.jsp");
				},
				error : function(response) {
					mensaje("Imposible guardar el grupo. Contacte al administrador.");
				}
			});
		}


function cancelar(){
	top.frames['main'].location="../grupos/grupos.jsp"; 	
}
