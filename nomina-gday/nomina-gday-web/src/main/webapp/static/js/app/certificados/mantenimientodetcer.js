$(document).ready(function() {	
	oTableCertificadosDet=$('#tablaCertificadosDet').dataTable();
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
			//setDataCertificados(response);
			oTableCertificadosDet=$('#tablaCertificadosDet').dataTable().fnAddData(response);
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
	$("#tablaCertificadosDet tbody").click(function(event) {
		$(oTableCertificadosDet.fnSettings().aoData).each(function (){
		$(this.nTr).removeClass('row_selected');
		});
	$(event.target.parentNode).addClass('row_selected');
		});
				
	$("#tablaCertificadosDet tbody").click(function(event) {
		$(oTableCertificadosDet.fnSettings().aoData).each(function (){
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

function corregirContenidoCertificado(){
	var anSelected = fnGetSelected( oTableCertificadosDet );	
	var id=anSelected[0].cells[0].innerText;
	openFrame("certificados/contenidocertificado.jsp?id="+id);
}

function openFrame(url){
	top.frames['mainFrame'].location="../"+url; 
}

function setDataCertificados(data){
	var count=0;	
	//console.log(data);
	//console.log(data[0][1]);
	for (count=0;count<data.length;count ++){	
		 $('#tablaCertificadosDet').dataTable().fnAddData( [		        
		        //data[count].idCertificadoAfiliado,
				//data[count].numeroCertificadoAfiliado,
				//data[count].fechaInicioVigenciaCertificadoAfiliado,
				//data[count].estadoCertificadoAfiliado,
				//data[count].sumaAseguradaCertificadoAfiliado,				
				//1
		        data[count][0],
		        data[count][1],
		        data[count][2],
		        data[count][3],
		        data[count][4],
		        data[count][5]
			] 
		);				
	}
}

