//Valida los elementos del Formulario
$(document).ready(function() {
	$("#agregarGrupoForm").validate({
		rules: {
			nombre: {"required":true,"maxlength":25},
			nombreCorto: {
				required:true,
				maxlength: 15
				}
		},        
		messages: {
			nombre: "Campo requerido. M\u00e1ximo 25",
			nombreCorto:{
				required:"Campo requerido",
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
					if (response==false)
						mensaje("IMPOSIBLE GUARDAR EL GRUPO. EL NOMBRE CORTO YA EXISTE!.");
					else
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
