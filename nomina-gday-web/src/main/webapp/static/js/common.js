function mensaje(mensaje){	
	$("#mensaje").append(mensaje);
	$("#mensaje").dialog({
		show: "slide", modal: true, width:500, height:500,	
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