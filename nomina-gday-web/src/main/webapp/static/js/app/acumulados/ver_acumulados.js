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

function ajax_download2(id1,id2,id3) {	
	var input_name="id1";		
	var input_name2="id2";		
	var input_name3="id3";	
	var url="../../mvc/acumulado/obteneracumuladoval";
	console.log(id1+id2+id3);
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
                  id3 +"'/></form>" +
                  "</body></html>";
    iframe_doc.open();
    iframe_doc.write(iframe_html);
    $(iframe_doc).find('form').submit();
}

function obtenerAcumuladosVal(){
	var id1=$("#nomina").val();
	var id2=$("#anio").val();
	var id3=$("#periodo").val();	
	console.log(id1+id2+id3);
	ajax_download2(id1,id2,id3);
} 
