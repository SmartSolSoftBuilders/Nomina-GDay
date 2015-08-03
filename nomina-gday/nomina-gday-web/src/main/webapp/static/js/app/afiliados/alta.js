var oTable;

$(document).ready(function() {
	oTable=$('#tablaEscuelas').dataTable();
	$( "#divEscuela" ).dialog({
		autoOpen: false,		
	    height: 400,
	    width: 550,
	    modal: true,
	    buttons: {	    	
	       	Aceptar: function() {
	       		var anSelected = fnGetSelected( oTable );				    		
	    		$("#escuela").val(anSelected[0].cells[1].innerText);
	    		$("#idescuela").val(anSelected[0].cells[0].innerText);
	    	   	$( this ).dialog( "close" );		    	
	       	}
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
			$("#municipio").append("<option value='0'>Seleccione...</option>");
			 $.each(response, function(i,item2){
	                $("#municipio").append("<option value='"+item2.nombreMunicipio+"'>"+item2.nombreMunicipio+"</option>");
	         });			
		}			
	});
	
	/* Add a click handler to the rows - this could be used as a callback */
	$("#tablaEscuelas tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
	});
	
	$("#tablaEscuelas tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');					
	});												
});

function guardarAfiliado(){
	var esInversionista=false;
	if ($("#esinversionista").val()==1)
		esInversionista=true;
	if ($("#formAltaAfiliado").validationEngine('validate') == true){
		$.ajax({
			data: {
			"nombreAfiliado" : $("#nombre").val(),
			"nacionalidad" : $("#nacionalidad").val(),
			"appPaternoAfiliado" : $("#app").val(),
			"appMaternoAfiliado" : $("#apm").val(),
			"estadoCivilAfiliado" : $("#estadocivil").val(),
			"rfcAfiliado" : $("#rfc").val(),
			"fechaNacimientoAfiliado" : $("#fechanacimiento").val(),
			"direccionAfiliado" : $("#domicilio").val(),
			"coliniaAfiliado" : $("#colonia").val(),
			"cpAfiliado" : $("#cp").val(),			
			"entidadAfiliado" : $("#entidad").val(),
			"puestoAfiliado" : $("#puesto").val(),
			"antiguedadAfiliado" : $("#antiguedad").val(),
			"telParticularAfiliado" : $("#telparticular").val(),
			"telCelularAfiliado" :$("#telcelular").val(),
			"companiatelAfiliado" :$("#compania").val(),
			"nacionalidadAfiliado" :$("#nacionalidad").val(),
			"estadoCivilAfiliado" :$("#estadocivil").val(),
			"emailAfiliado" :$("#email").val(),
			"municipioAfiliado" :$("#municipio").val(),
			"escuelaAfiliado" :$("#escuela").val(),
			"inversionista" : esInversionista
			},
			dataType:'json',
			url:   '../../mvc/afiliado/guardar ',
			type:  'post',		
			beforeSend: function () {
				$("#guardarAfiliadoAlta").hide();
			},
			success:  function (response) {
				if (!esInversionista)
					$("#resultadoGuardar").html("Se agregó el afiliado en forma correcta!<a href='#' onclick='procederCertificado()'>Generar Certificado</a>");
				else
					$("#resultadoGuardar").html("Se agregó el afiliado en forma correcta!");
			}		,	
			error: function (response) {																	
				$("#resultadoGuardar").html("Error al agregar al afiliado!");
			}		
		});		
	}
} 

function procederCertificado(){
	top.frames['mainFrame'].location="../afiliados/certificado.jsp";	
}

function showEscuela(){
    $( "#divEscuela" ).dialog( "open" );
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/afiliado/escuelas',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {								
			getData(response);
		}			
	});			
}			
function getData(data){
	var count=0;	
	for (count=0;count<data.length;count ++){	
		 $('#tablaEscuelas').dataTable().fnAddData( [				
				data[count].idEscuela,
				data[count].nombreEscuela,
			] 
		);				
	}
}

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