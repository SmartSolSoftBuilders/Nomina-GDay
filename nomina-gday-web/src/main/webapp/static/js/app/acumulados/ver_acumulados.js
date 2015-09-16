$(document).ready(function() {	
	$.ajax({
	sync:true,
	dataType:'json',
	url:   '../../mvc/acumulado/getdatoscombo',
	type:  'post',		
	beforeSend: function () {	
		$("#obtenerAcumBtn").hide();
		$("#divLoadingNoms").show();
	},
	success:  function (response) {
		console.log ("NOMINA");
		console.log (response[0]);		
		var result=response[0];
		var options = '<option value="0">Seleccione...</option>';
		$("#periodo").append(options);
		for (var i = 0; i < result.length; i++) {
			options += '<option value="' + result[i].idNomina + '">' + result[i].nombreCorto +'</option>';
		}
		$("#nomina").append(options);
		
		var result=response[2];
		var options = '<option value="0">Seleccione...</option>';
		//$("#grupo").append(options);
		for (var i = 0; i < result.length; i++) {
			options += '<option value="' + result[i].idGrupo + '">' + result[i].nombre +'</option>';
		}
		$("#grupo").append(options);
		
		var result=response[3];
		var options = '<option value="0">Seleccione...</option>';
		//$("#patrona").append(options);
		for (var i = 0; i < result.length; i++) {
			options += '<option value="' + result[i].idPatrona + '">' + result[i].nombreCortoPatrona +'</option>';
		}
		$("#patrona").append(options);
		
		var result=response[4];
		var options = '<option value="0">Seleccione...</option>';		
		//$("#tipoCalendario").append(options);
		for (var i = 0; i < result.length; i++) {
			options += '<option value="' + result[i].idCalendario + '">' + result[i].tipoCalendario +'</option>';
		}
		$("#tipoCalendario").append(options);
		
		$("#obtenerAcumBtn").show();
		$("#divLoadingNoms").hide();
	},	
	error: function (response) {
		$("#obtenerAcumBtn").hide();
		$("#divLoadingNoms").show();
		$("#resultadoGuardar").html("Error");
	}		
	});		
});
function obtenerNssCurp(){
	$.ajax({
		sync:true,
		data:{idNomina:$("#nomina").val()},
		dataType:'json',
		url:   '../../mvc/acumulado/getdatoscombonsscurp',
		type:  'post',		
		beforeSend: function () {	
			$("#obtenerAcumBtn").hide();
			$("#divLoadingNoms").show();
		},
		success:  function (response) {
			console.log ("NOMINA");
			console.log (response[0]);					
			var result=response[0];
			var options = '<option value="">Seleccione...</option>';
			//$("#nss").append(options);
			for (var i = 0; i < result.length; i++) {
				options += '<option value="' + result[i]+ '">' + result[i]+'</option>';
			}
			$("#nss").empty();
			$("#nss").append(options);
			
			var result=response[1];
			var options = '<option value="">Seleccione...</option>';		
			//$("#curp").append(options);
			for (var i = 0; i < result.length; i++) {
				options += '<option value="' + result[i] + '">' + result[i] +'</option>';
			}
			$("#curp").empty();
			$("#curp").append(options);
			
			$("#obtenerAcumBtn").show();
			$("#divLoadingNoms").hide();
		},	
		error: function (response) {
			$("#obtenerAcumBtn").hide();
			$("#divLoadingNoms").show();
			$("#resultadoGuardar").html("Error");
		}		
		});
}

//*******************************************************************************
//Function que obtiene los datos de la BD que se agregan a los combos del SELECT
//*******************************************************************************


function obtenerAcumuladosVal(){
	var id1=$("#nomina").val();
	var id2=$("#mesPago").val();
	var id3=$("#anioPago").val();	
	var id4=$("#periodo").val();
	console.log(id1+id2+id3+id4);
	ajax_download2(id1,id2,id3,id4);
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
			var options = '<option value="">Seleccione...</option>';				
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

function ajax_download2(id1,id2,id3,id4) {	
	var input_name="id1";		
	var input_name2="id2";		
	var input_name3="id3";	
	var input_name4="id4";
	var url="../../mvc/acumulado/obteneracumuladoval";	
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
                  id1 +"'/>" +
                  "<input type=hidden name='" + input_name2 + "' value='" +
                  id2 +"'/>" +
                  "<input type=hidden name='" + input_name3 + "' value='" +
                  id3 +"'/>" +
                  "<input type=hidden name='" + input_name4 + "' value='" +
                  id4 +"'/></form>" +
                  "</body></html>";
    iframe_doc.open();
    iframe_doc.write(iframe_html);
    $(iframe_doc).find('form').submit();
}
