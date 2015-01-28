//Valida los elementos del Formulario
$(document).ready(function() {
	$("#agregarGrupoForm").validate({
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


//**********************************************
//Function que guarda todos los datos del Grupo*
//**********************************************
function guardarGrupo() {
	if ($("#agregarGrupoForm").valid()){	
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
}


function cancelar(){
	top.frames['main'].location="../grupos/grupos.jsp"; 	
}
