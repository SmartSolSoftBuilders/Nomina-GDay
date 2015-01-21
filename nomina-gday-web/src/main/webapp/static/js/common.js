function mensaje(mensaje){	
	$("#mensaje").append(mensaje);
	$("#mensaje").dialog({
		show: "slide", modal: true, width:500, height:200,	
		  buttons: [
		    {
		      text: "Aceptar",
		      click: function() {
		        $( this ).dialog( "close" );
		      }
		    }
		  ]
	});
}

function mensajeRedireccion(mensaje,url){	
	$("#mensaje").append(mensaje);
	$("#mensaje").dialog({
		show: "slide", modal: true,  resizable: false,
        draggable: false, width:500, height:200,	
		  buttons: [
		    {
		      text: "Aceptar",
		      click: function() {
		        $( this ).dialog( "close" );
		        top.frames['main'].location=url;
		      }
		    }
		  ]
	});
}