//Valida los elementos del Formulario
$(document).ready(function() {
	$("#agregarGrupoForm").validate({
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
					mensajeRedireccion("GRUPO CREADO CORRECTAMENTE","../grupos/grupos.jsp");
				},
				error : function(response) {
					mensaje("IMPOSIBLE GUARDAR EL GRUPO. CONTACTE CON EL ADMINISTRADOR.");
				}
			});
		}
}


function cancelar(){
	top.frames['main'].location="../grupos/grupos.jsp"; 	
}
