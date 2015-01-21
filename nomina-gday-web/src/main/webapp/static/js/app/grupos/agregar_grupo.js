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
					mensaje("Grupo creado correctamente");
					//top.frames['main'].location="../grupos/grupos.jsp";
				},
				error : function(response) {
					$("#resultadoGuardar").html();
				}
			});
		}


function cancelar(){
	top.frames['main'].location="../grupos/grupos.jsp"; 	
}
