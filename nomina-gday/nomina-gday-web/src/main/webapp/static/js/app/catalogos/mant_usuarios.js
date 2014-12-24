var oTableUsuarios;
$(document).ready(function() {
	oTableUsuarios=$('#tablaUsuarios').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/catalogos/usuarios',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {
			//$("#resultado").html("");
			//oTable = $('#tablaEscuelas').dataTable();
			setDataUsuarios(response);
		}			
	});			

	$( "#divUsuarios" ).dialog({
		autoOpen: false,
	    height: 300,
	    width: 350,
	    modal: true,
	    buttons: {
	    	Guardar: function() {    		
	    			$.ajax({
	    				data:{
	    					username:$("#changeusuario").val(),
	    					password:$("#changepasswordusuario").val(),
	    					nombre:$("#changeactivousuario").val()
	    				},
	    				sync: true,
	    				type:  'post',
	    				url:   '../../mvc/catalogos/actualizarusuario',
	    				dataType:  'json',
	    				beforeSend: function () {	    				
	    				},
	    				success:  function (response) {
	    					if (response==true)
	    						alert("Se actualizó correctamente al usuario");
	    					top.frames['mainFrame'].location="../catalogos/mant_usuarios.jsp";	    				
	    				}
	    			});				    				    
	    		}
	        }
	});				
				
	/* Add a click handler to the rows - this could be used as a callback */
	$("#tablaUsuarios tbody").click(function(event) {
		$(oTableUsuarios.fnSettings().aoData).each(function (){
		$(this.nTr).removeClass('row_selected');
		});
	$(event.target.parentNode).addClass('row_selected');
		});
				
	$("#tablaUsuarios tbody").click(function(event) {
		$(oTableUsuarios.fnSettings().aoData).each(function (){
		$(this.nTr).removeClass('row_selected');
		});
	$(event.target.parentNode).addClass('row_selected');					
		});												
	});

function fnGetSelected( oTableLocal ){
	var aReturn = new Array();
	var aTrs = oTableLocal.fnGetNodes();				
	for ( var i=0 ; i<aTrs.length ; i++ ){
		if ( $(aTrs[i]).hasClass('row_selected') ){
			aReturn.push( aTrs[i] );
		}
	}				
	return aReturn;
}

function corregirDatosUsuarios(){
	var anSelected = fnGetSelected( oTableUsuarios );		
	$("#divUsuarios").dialog( "open" );
	$("#nombreUsuario").html(anSelected[0].cells[0].innerText);	
	$("#changeusuario").val(anSelected[0].cells[0].innerText);
	$("#changepasswordusuario").val(anSelected[0].cells[1].innerText);		
	//openFrame("certificados/editarcertificado.jsp?id="+id);
}

function openFrame(url){
	top.frames['mainFrame'].location="../"+url; 
}

function setDataUsuarios(data){
	var count=0;	
	for (count=0;count<data.length;count ++){	
		 $('#tablaUsuarios').dataTable().fnAddData( [		        
		        data[count].username,							
				data[count].password,
				data[count].nombre,							
				data[count].activo
			] 
		);				
	}
}

