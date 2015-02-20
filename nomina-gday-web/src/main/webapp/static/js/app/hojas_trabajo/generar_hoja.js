//*******************************************************************************
//Obtener el idNomina por parametros en la url, que se manda desde el controller
//*******************************************************************************
var sumaPorcentaje=0;

function getParameter(parameter){
	// Obtiene la cadena completa de URL
	var url = location.href;
	/* Obtiene la posicion donde se encuentra el signo ?, 
	ahi es donde empiezan los parametros */
	var index = url.indexOf("?");
	/* Obtiene la posicion donde termina el nombre del parametro
	e inicia el signo = */
	index = url.indexOf(parameter,index) + parameter.length;
	/* Verifica que efectivamente el valor en la posicion actual 
	es el signo = */ 
	if (url.charAt(index) == "="){
	// Obtiene el valor del parametro
	var result = url.indexOf("&",index);
	if (result == -1){result=url.length;};
	// Despliega el valor del parametro
	return url.substring(index + 1,result);
	}
} 

//*******************************************************************************
//Function que obtiene los datos de la BD que se agregan a los combos del SELECT
//*******************************************************************************
$(document).ready(function() {
	
	var idNom=getParameter("id");
	console.log("nomina:"+idNom);
	$("#idNomSubirArchivo").val(idNom);
	//Sección validaciones
	oTablaPlantillas=$('#tablaPlantillas').dataTable();
	$.ajax({
		data:{"idNomina":0},
		sync: true,
		type:  'post',
		url:   '../../mvc/hoja/gethojas_nomina',
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
		}
	});	
	
});

function eliminarHojaTrabajo(idHoja){
	if (confirm ("Desea eliminar la hoja de trabajo?:")+idHoja){
		$.ajax({
			data:{"idHojaTrabajo":idHoja},
			sync: true,
			type:  'post',
			url:   '../../mvc/hoja/eliminarhojatrabajo',
			dataType:  'json',
			beforeSend: function () {
				$("#resultado").html("Procesando, espere por favor...");
	      	$( "#progressbar" ).progressbar({
			      value: 75
			    });	
	        $( "#demo" ).hide();
			}, 
			success:  function (response) {
				mensaje("Eliminado correctamente");
			}
		});
	}
}

function activarHojaTrabajo(idHoja){
	var idNom=getParameter("id");
	if (confirm ("Desea activar la hoja de trabajo?:")+idHoja){
		$.ajax({
			data:{
				"idHojaTrabajo":idHoja,
				"nomina.idNomina":idNom
				},
			sync: true,
			type:  'post',
			url:   '../../mvc/hoja/activarhojatrabajo',
			dataType:  'json',
			beforeSend: function () {
				$("#resultado").html("Procesando, espere por favor...");
	      	$( "#progressbar" ).progressbar({
			      value: 75
			    });	
	        $( "#demo" ).hide();
			}, 
			success:  function (response) {
				mensaje("Activado correctamente");
			}
		});
	}	
}

function cancelar(){
	top.frames['main'].location="../nominas/nominas.jsp"; 	
}

function showHojasTrabajoNomina (idNomina){
	top.frames['main'].location="../hojas_trabajo/gestion_hojas.jsp?id="+idNomina; 
}

function guardarPatrona(){
	top.frames['main'].location="../patronas/agregar_patrona.jsp"; 	
}

function generarHojaTrabajo(idHojaTrabajo){
	$("#hojaTrabajoHid").val(idHojaTrabajo);
	ajax_download();
} 

function ajax_download() {	
	var input_name="id1";
	var id1=document.getElementById("hojaTrabajoHid").value;	
	var url="../../mvc/hoja/generarHojaTrabajo";
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
