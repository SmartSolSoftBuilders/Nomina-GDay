$(document).ready(function() {
	oTableCotizaciones=$('#tablaCotizaciones').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/credifam/getCotizacionesPendientes',
		//dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
      	$( "#progressbar" ).progressbar({
		      value: 75
		    });	
        $( "#demo" ).hide();
		},
		success:  function (response) {
			//$("#resultado").html("");									
			//oTable = $('#tablaEscuelas').dataTable();	
			$( "#progressbar" ).progressbar({
				value: 100
		    });
			$( "#progressbar" ).hide();	
			$( "#demo" ).show();
			$('#tablaCotizaciones').dataTable().fnAddData(response);
			//setData(response);
		}			
	});			
	
	/* Add a click handler to the rows - this could be used as a callback 
	$("#tablaCotizaciones tbody").click(function(event) {
		$(oTableCotizaciones.fnSettings().aoData).each(function (){
		$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
		});
				
	$("#tablaCotizaciones tbody").click(function(event) {
		$(oTableCotizaciones.fnSettings().aoData).each(function (){
		$(this.nTr).removeClass('row_selected');
		});
	$(event.target.parentNode).addClass('row_selected');					
		});												*/
	
});

function establecerEstatus(idCotizacion,estatus){
	if(confirm("¿Seguro que deseas colocar el estatus de: "+estatus+"?")){		
	$.ajax({
		data:{"idCotizacion":idCotizacion,"estatus":estatus},
		sync: true,
		type:  'post',
		url:   '../../mvc/credifam/setEstatusCotizacion',
		//dataType:  'json',
		success:  function (response) {
			alert("Estatus actualizado Correctamente");
			top.frames['mainFrame'].location="cotizaciones_pendientes.jsp"; 
			},
		error: function(response){
			alert("error!");
		}
		});	
	}
}


//Metodo que descarga el reporte en PDF
function ajax_download(data) {
	var url="../../mvc/credifam/htmlToPdf2";
	var inputname="";
	input_name="txt";
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
                  "<input type=hidden name='txt' value='" +
                106 +"'/></form>" +
                  "</body></html>";

    iframe_doc.open();
    iframe_doc.write(iframe_html);
    $(iframe_doc).find('form').submit();
}