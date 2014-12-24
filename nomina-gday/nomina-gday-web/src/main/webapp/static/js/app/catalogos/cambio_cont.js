var oTableUsuarios;
$(document).ready(function() {
	$( "#mensajeCambioCont" ).dialog({
		autoOpen: false,		
	    height: 300,
	    width: 300,
	    modal: true,
	    buttons: {	    	
	       	Aceptar: function() {	       		
	    	   	$( this ).dialog( "close" );		    	
	       	}
	    }
	});

});

function openFrame(url){
	top.frames['mainFrame'].location="../"+url; 
}

function cambiaCont(){
	if ($("#newcontrasenia").val()!=$("#recontrasenia").val()){
		alert("Las contraseñas no coinciden!");		
	}
	else{			
	$.ajax({
		data: {
			username:$("#contrasenia").val(),
			password:$("#newcontrasenia").val(),
			nombre:$("#recontrasenia").val()
			
		},
		dataType:'json',
		url:   '../../mvc/catalogos/cambiacont',
		type:  'post',		
		beforeSend: function () {			
		},
		success:  function (response) {
			if (response==false)
				$("#mensajeCambioCont").html("La contraseña anterior no es correcta!");
			else
				$("#mensajeCambioCont").html("Se modificó el password correctamente!");
			$( "#mensajeCambioCont" ).dialog( "open" );
		}		,	
		error: function (response) {																	
			$("#resultadoGuardar").html("Error al agregar al afiliado!");
		}		
	});
	}
}