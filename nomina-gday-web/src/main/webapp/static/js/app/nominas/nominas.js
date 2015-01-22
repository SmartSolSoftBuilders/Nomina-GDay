$(document).ready(function() {
	oTableNominas=$('#tablaNomina').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/nomina/getnominas',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
      	$( "#progressbar" ).progressbar({
		      value: 75
		    });	
        $( "#demo" ).hide();
		},
		success:  function (response) {
			console.log(response);
			$( "#demo" ).show();
			$( "#progressbar" ).hide();
			$('#tablaNomina').dataTable().fnAddData(response);
			//setData(response);
		}		,
		error:  function (response) {
			console.log(response);
			alert(response);
		}
	});			

});

function ajax_download(idNomina) {	
	var input_name="id1";
	var id1=idNomina;	
	var url="../../mvc/reportes/obtenernominaempleados";
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

function showEditarNomina(idNomina){
	top.frames['main'].location="../nominas/actualizar_nomina.jsp?id="+idNomina; 	
}

function showAgregarNomina(){
	top.frames['main'].location="../nominas/agregar_nomina.jsp"; 	
}

