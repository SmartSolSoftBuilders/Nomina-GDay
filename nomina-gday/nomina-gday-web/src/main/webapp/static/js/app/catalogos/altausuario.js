$(document).ready(function() {
	$("#divRegister").hide();
});

function buscarUsuario(){
	$.ajax({
		data:{			
			username:$("#buscanombreusuario").val()
		},
		sync: true,
		type:  'post',
		url:   '../../mvc/catalogos/buscarusuario',
		dataType:  'json',
		beforeSend: function () {						
		},
		success:  function (response) {
			//top.frames['mainFrame'].location="../catalogos/mant_municipios.jsp";
			if (response.length>0)
				alert("El empleado ya tiene asignado un nombre de usuario!")
			else{
				$("#divRegister").show();
				$("#nombreusuario").val($("#buscanombreusuario").val());
				}
			},
		error: function(e){
			alert("error"+e);
		}
		});
}

function guardarUsuario(){	
	$.ajax({
		data:{			
			username:$("#nombreusuario").val(),
			password:$("#passwordusuario").val(),
			nombre:$("#nombreuser").val()			
		},
		sync: true,
		type:  'post',
		url:   '../../mvc/catalogos/guardarusuario',
		dataType:  'json',
		beforeSend: function () {						
		},
		success:  function () {
			top.frames['mainFrame'].location="../catalogos/mant_usuarios.jsp";			
			},
		error: function(e){
			alert("error"+e);
		}
		});
}