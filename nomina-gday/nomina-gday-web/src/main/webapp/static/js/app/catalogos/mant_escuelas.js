var oTableEscuelas;
$(document).ready(function() {
	oTableEscuelas=$('#tablaEscuelas').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/catalogos/escuelas',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {
			//$("#resultado").html("");									
			//oTable = $('#tablaEscuelas').dataTable();		
			setDataEscuelas(response);
		}			
	});
	//Se cargan los combos
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/catalogos/tipoescuelas',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {
			//$("#resultado").html("");									
			//oTable = $('#tablaEscuelas').dataTable();
			$("#tipoescuelacombo").append("<option value='0'>Seleccione...</option>");
			 $.each(response, function(i,item2){
	                $("#tipoescuelacombo").append("<option value='"+item2.idTipoEscuela+"'>"+item2.descripcionTipoEscuela+"</option>");
	         });			
		}			
	});
	//Se llenan los combos
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
			$("#municipiocombo").append("<option value='0'>Seleccione...</option>");
			 $.each(response, function(i,item2){
	                $("#municipiocombo").append("<option value='"+item2.nombreMunicipio+"'>"+item2.nombreMunicipio+"</option>");
	         });			
		}			
	});
				

	$( "#divEscuelas" ).dialog({
		autoOpen: false,
	    height: 400,
	    width: 550,
	    modal: true,
	    buttons: {
	    	Guardar: function() {	    		
	    			$.ajax({
	    			data:{	    				
	    				"idEscuela":$("#idescuela").val(),
	    				"nombreEscuela":$("#nombreescuela").val(),		
	    				"tipoEscuela.idTipoEscuela":$("#tipoescuelacombo").val(), 
	    				"direccionEscuela":$("#direccionescuela").val(),
	    				"coloniaEscuela":$("#coloniaescuela").val(),
	    				"cpEscuela":$("#cpescuela").val(),
	    				"municipioEscuela":$("#municipiocombo").val(),
	    				"entidadEscuela":$("#entidadescuela").val(),
	    				"ciudadEscuela":$("#ciudadescuela").val(),
	    				"turnoEscuela":$("#turnoescuela").val()
	    			},
	    			sync: true,
	    			type:  'post',
	    			url:   '../../mvc/catalogos/actualizarescuela',
	    			dataType:  'json',
	    			beforeSend: function () {	    					    				
	    			},
	    			success:  function (response) {
	    				//$("#resultado").html("");									
	    				//oTable = $('#tablaEscuelas').dataTable();
	    				top.frames['mainFrame'].location="../catalogos/mant_escuelas.jsp";	    				
	    				}			
	    			});				    				    
	    		}
	        },
	       	close: function() {	       		
	       	}
	});				
				
	/* Add a click handler to the rows - this could be used as a callback */
	$("#tablaEscuelas tbody").click(function(event) {
		$(oTableEscuelas.fnSettings().aoData).each(function (){
		$(this.nTr).removeClass('row_selected');
		});
	$(event.target.parentNode).addClass('row_selected');
		});
				
	$("#tablaEscuelas tbody").click(function(event) {
		$(oTableEscuelas.fnSettings().aoData).each(function (){
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

function selectOptionByText(selectElement, targetText) {
    var $selectElement, $options, $targetOption;

    $selectElement = jQuery(selectElement);
    $options = $selectElement.find('option');
    $targetOption = $options.filter(
        function () {return jQuery(this).text() == targetText}
    );

    // We use `.prop` if it's available (which it should be for any jQuery versions above
    // and including 1.6), and fall back on `.attr` (which was used for changing DOM
    // properties in pre-1.6) otherwise.
    if (jQuery().prop) {
        $targetOption.prop('selected', true);
    } 
    else {
        $targetOption.attr('selected', 'true');
    }
}

function corregirDatosEscuelas(){
	var anSelected = fnGetSelected( oTableEscuelas );		
	$("#divEscuelas").dialog( "open" );
	$("#idescuela").val(anSelected[0].cells[0].innerText);
	$("#nombreescuela").val(anSelected[0].cells[1].innerText);		
	selectOptionByText($("#tipoescuelacombo"),anSelected[0].cells[2].innerText); 
	$("#direccionescuela").val(anSelected[0].cells[3].innerText);
	$("#coloniaescuela").val(anSelected[0].cells[4].innerText);
	$("#cpescuela").val(anSelected[0].cells[5].innerText);
	selectOptionByText($("#municipiocombo"),anSelected[0].cells[6].innerText);
	$("#entidadescuela").val(anSelected[0].cells[7].innerText);
	$("#ciudadescuela").val(anSelected[0].cells[8].innerText);
	selectOptionByText($("#turnoescuela"),anSelected[0].cells[9].innerText);	
	//openFrame("certificados/editarcertificado.jsp?id="+id);
}

function openFrame(url){
	top.frames['mainFrame'].location="../"+url; 
}

function setDataEscuelas(data){
	var count=0;	
	for (count=0;count<data.length;count ++){		
		 $('#tablaEscuelas').dataTable().fnAddData( [		        
		        data[count].idEscuela,							
				data[count].nombreEscuela,
				data[count].tipoEscuela.descripcionTipoEscuela,
				data[count].direccionEscuela,
				data[count].coloniaEscuela,
				data[count].cpEscuela,
				data[count].municipioEscuela,
				data[count].entidadEscuela,
				data[count].ciudadEscuela,
				data[count].turnoEscuela							
			] 
		);				
	}
}

