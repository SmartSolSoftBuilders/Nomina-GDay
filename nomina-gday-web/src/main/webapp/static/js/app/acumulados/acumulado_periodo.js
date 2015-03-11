$(document).ready(function() {
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
			var options = "";
			var result=response[0];
			 for (var i = 0; i < result.length; i++) {
			    	options += '<option value="' + result[i].idNomina + '">' + result[i].nombreCorto +'</option>';
			    }
		$("#nomina").append(options)
		
		console.log ("PERIODO");
		console.log (response[1]);
			var options = "";
			var result=response[1];
			 for (var i = 0; i < result.length; i++) {
			    	options += '<option value="' + result[i].idPeriodo + '">' + result[i].fechaInicialPago +'</option>';
			    }
		$("#periodo").append(options)
		},	
	error: function (response) {																	
		$("#resultadoGuardar").html("Error");
		}		
});		
});

//*******************************************************************************
//Function que obtiene los datos de la BD que se agregan a los combos del SELECT
//*******************************************************************************
function obtenerAcumulados(){
	var idNomina=($('#nomina').find(":selected").val())
	var idPeriodo=($('#periodo').find(":selected").val())
	console.log(idNomina)
	console.log(idPeriodo)
	//Sección validaciones
	oTablaPlantillas=$('#tablaPlantillas').dataTable();
	$.ajax({
		data:{
			"nomina.idNomina": idNomina,
			"periodo.idPeriodo": idPeriodo
			
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
			$("#demo").show();
			$("#progressbar").hide();
			oTablaPlantillas.fnClearTable();
			oTablaPlantillas.fnAddData(response);
			$('#idNomina').val(idNomina);
			$('#idPeriodo').val(idPeriodo);
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