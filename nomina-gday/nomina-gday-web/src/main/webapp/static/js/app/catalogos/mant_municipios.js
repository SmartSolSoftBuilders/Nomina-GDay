$(document).ready(function() {
	oTableMunicipios=$('#tablaMunicipios').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/catalogos/municipios',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {
			//$("#resultado").html("");									
			//oTable = $('#tablaEscuelas').dataTable();		
			setDataMunicipios(response);
		}			
	});			

	$( "#divMunicipios" ).dialog({
		autoOpen: false,
	    height: 300,
	    width: 350,
	    modal: true,
	    buttons: {
	    	Guardar: function() {	    		
	    			$.ajax({
	    			data:{
	    				idMunicipio:$("#idmunicipio").val(),
	    				nombreMunicipio:$("#nombremunicipio").val()
	    			},
	    			sync: true,
	    			type:  'post',
	    			url:   '../../mvc/catalogos/actualizarmunicipio',
	    			dataType:  'json',
	    			beforeSend: function () {	    				
	    				$( this ).dialog( "close" );
	    			},
	    			success:  function (response) {
	    				//$("#resultado").html("");									
	    				//oTable = $('#tablaEscuelas').dataTable();
	    				top.frames['mainFrame'].location="../catalogos/mant_municipios.jsp";
	    				$( this ).dialog( "close" );
	    				}			
	    			});				    				    
	    		}
	        },
	       	close: function() {	       		
	       	}
	});				
				
	/* Add a click handler to the rows - this could be used as a callback */
	$("#tablaMunicipios tbody").click(function(event) {
		$(oTableMunicipios.fnSettings().aoData).each(function (){
		$(this.nTr).removeClass('row_selected');
		});
	$(event.target.parentNode).addClass('row_selected');
		});
				
	$("#tablaMunicipios tbody").click(function(event) {
		$(oTableMunicipios.fnSettings().aoData).each(function (){
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

function corregirDatosMunicipios(){
	var anSelected = fnGetSelected( oTableMunicipios );		
	$("#divMunicipios").dialog( "open" );
	$("#idmunicipio").val(anSelected[0].cells[0].innerText);
	$("#nombremunicipio").val(anSelected[0].cells[1].innerText);
	
	//openFrame("certificados/editarcertificado.jsp?id="+id);
}

function openFrame(url){
	top.frames['mainFrame'].location="../"+url; 
}

function setDataMunicipios(data){
	var count=0;	
	for (count=0;count<data.length;count ++){	
		 $('#tablaMunicipios').dataTable().fnAddData( [		        
		        data[count].idMunicipio,							
				data[count].nombreMunicipio			
			] 
		);				
	}
}

