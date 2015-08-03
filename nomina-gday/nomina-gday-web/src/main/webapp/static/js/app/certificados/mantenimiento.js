$(document).ready(function() {
	oTableCertificados=$('#tablaCertificados').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/certificadoafiliado/getcertificadosall',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) { 
			//$("#resultado").html("");									
			//oTable = $('#tablaEscuelas').dataTable();					
			$('#tablaCertificados').dataTable().fnAddData(response);;
		}			
	});			

	$( "#divCertificados" ).dialog({
		autoOpen: false,
	    height: 400,
	    width: 1050,
	    modal: true,
	    buttons: {
	    	Cancel: function() {
	    		$( this ).dialog( "close" );
		    		}
	        },
	       	close: function() {	       		
	       	}
	});				
				
	/* Add a click handler to the rows - this could be used as a callback */
	$("#tablaCertificados tbody").click(function(event) {
		$(oTableCertificados.fnSettings().aoData).each(function (){
		$(this.nTr).removeClass('row_selected');
		});
	$(event.target.parentNode).addClass('row_selected');
		});
				
	$("#tablaCertificados tbody").click(function(event) {
		$(oTableCertificados.fnSettings().aoData).each(function (){
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

function corregirDatosCertificado(){
	var anSelected = fnGetSelected( oTableCertificados );	
	var id=anSelected[0].cells[0].innerText;
	openFrame("certificados/editarcertificado.jsp?id="+id);
}

function openFrame(url){
	top.frames['mainFrame'].location="../"+url; 
}

function setDataCertificados(data){
	var count=0;	
	for (count=0;count<data.length;count ++){	
		 $('#tablaCertificados').dataTable().fnAddData( [
		        
		        data[count].idCertificadoAfiliado,
				data[count].numeroCertificadoAfiliado,
				data[count].fechaInicioVigenciaCertificadoAfiliado,
				data[count].estadoCertificadoAfiliado,
				data[count].sumaAseguradaCertificadoAfiliado,				
				data[count].afiliado.idAfiliado
			] 
		);				
	}
}

