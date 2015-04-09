$(document).ready(function() {	
	$("#ficheroDiv").hide();
	$("#botonSubmit").hide();
	
	$.ajax({
	sync:true,
	dataType:'json',
	url:   '../../mvc/acumulado/getdatoscombo',
	type:  'post',		
	beforeSend: function () {	
	},
	success:  function (response) {
		console.log ("NOMINA");
		console.log (response[0]);
			var options = '<option value="0">Seleccione...</option>';
			var result=response[0];
			 for (var i = 0; i < result.length; i++) {
			    	options += '<option value="' + result[i].idNomina + '">' + result[i].nombreCorto + '   ('+result[i].tipoCalendario.tipoCalendario+')'+ '</option>';
			    }
		$("#nomina").append(options);			
		},	
	error: function (response) {																	
		$("#resultadoGuardar").html("Error");
		}		
});		
});

function loading2(){
	$("#divLoading2").dialog(({show: "slide", dialogClass: 'noTitleStuff' , modal: true, width:700, height:200,
		autoOpen: true}));
}
//*******************************************************************************
//Function que obtiene los datos de la BD que se agregan a los combos del SELECT
//*******************************************************************************
function obtenerAcumulados(){
	/*$("#imgLoading").hide();
	$("#imgLoading2").hide();
	$("#ficheroDiv").hide();
	$("#botonSubmit").hide();
	$("#imgLoading2").show();*/
	$("#divLoading").dialog(({show: "slide", dialogClass: 'noTitleStuff' , modal: true, width:700, height:200,
		autoOpen: true}));
	$(".ui-dialog-titlebar").hide();

	var idNomina=($('#nomina').find(":selected").val());
	var idPeriodo=($('#periodo').find(":selected").val());
	var mesPag=($('#mesPago').find(":selected").val());
	var anioPag=($('#anioPago').find(":selected").val());
	
	console.log(idNomina)
	console.log(idPeriodo)
	//Sección validaciones
	oTablaPlantillas=$('#tablaPlantillas').dataTable();
	$.ajax({
		data:{
			"nomina.idNomina": idNomina,
			"numeroPeriodo": idPeriodo,
			"mesPago":mesPag,
			"anioPago":anioPag			
		},
		sync: true,
		type:  'post',
		url:   '../../mvc/acumulado/getacumulados',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
			
      	$( "#progressbar" ).progressbar({
		      value: 75
		    });	
        $( "#demo" ).hide();
		}, 
		success:  function (response) {
			$("#divLoading").dialog("close");
			$("#demo").show();
			//$("#progressbar").hide();			
			oTablaPlantillas.fnClearTable();
			oTablaPlantillas.fnAddData(response);
			$('#idNomina').val(idNomina);
			$('#idPeriodo').val(idPeriodo);
			$('#mesPagoHid').val(mesPag);
			$('#anioPagoHid').val(anioPag);			
			$("#ficheroDiv").show();					
		}
	});	
	
}


function ajax_download(id) {	
	var input_name="id1";
	var id1=id;	
	var url="../../mvc/acumulado/obteneracumulado";
    var $iframe,
        iframe_doc,
        iframe_html;

    if (($iframe = $('#download_iframe')).length === 0) {
        $iframe = $("<iframe id='download_iframe'" +
                    " style='display: none' src='about:blank'></iframe>"
                   ).appendTo("body");
    }

    iframe_doc = $iframe[0].contentWindow || $iframe[0].contentDocument;
    if (iframe_doc.document) {
        iframe_doc = iframe_doc.document;
    }

    iframe_html = "<html><head></head><body><form method='POST' action='" +
                  url +"'>" +
                  "<input type=hidden name='" + input_name + "' value='" +
                  id1 +"'/></form>" +
                  "</body></html>";
    iframe_doc.open();
    iframe_doc.write(iframe_html);
    $(iframe_doc).find('form').submit();
}

function showVerDatos(idNomina){
	top.frames['main'].location="../acumulados/ver_acumulados.jsp?id="+idNomina;
}


function obtenerPeriodos(){	
	var idNomina=$("#nomina").val();
	console.log(idNomina);
	$.ajax({
		sync:true,
		data:{"idNomina":idNomina},
		dataType:'json',
		url:   '../../mvc/nomina/obtenernominabyid',
		type:  'post',		
		beforeSend: function () {	
		},
		success:  function (response) {
			console.log ("NOMINA");
			console.log (response);
			//$("#tipoCalendarioDiv").html(response.tipoCalendario.tipoCalendario);		
			var limite=0;
			if (response.tipoCalendario.siglas=='D')
				limite=1;
			if (response.tipoCalendario.siglas=='S')
				limite=53;
			if (response.tipoCalendario.siglas=='C')
				limite=27;
			if (response.tipoCalendario.siglas=='Q')
				limite=25;
			if (response.tipoCalendario.siglas=='M')
				limite=12;
			$("#periodo").empty();
			var options = '<option value="0">Seleccione...</option>';				
				 for (var i = 1; i <= limite; i++) {
				    	options += '<option value="'+ i + '">' + i +'</option>';
				    }
				 options += '<option value="13">AGUINALDO</option>';
			$("#periodo").append(options);			
			},	
		error: function (response) {																	
			$("#resultadoGuardar").html("Error");
			}		
	});
}

function eliminarAcumulado(idAcumulado){	
	if (confirm("Seguro que desea eliminar el acumulado? Se eliminarán los datos acumulados!")){
	$.ajax({
		sync:true,
		data:{"idAcumuladoPeriodo":idAcumulado},
		dataType:'json',
		url:   '../../mvc/acumulado/eliminaracumuladoPeriodo',
		type:  'post',		
		beforeSend: function () {	
		},
		success:  function (response) {
			mensaje("Se eliminó correctamente el acumulado!");			
		},	
		error: function (response) {																	
			$("#resultadoGuardar").html("Error");
			}		
	});	
	}	
}