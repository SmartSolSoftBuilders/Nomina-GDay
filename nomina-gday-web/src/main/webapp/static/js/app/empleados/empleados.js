//*************************************************************************
//Function que muestra los datos de los Grupos registrados en un dataTable*
//*************************************************************************
$(document).ready(function() {
	oTableEmpleados=$('#tablaEmpleado').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/empleado/getempleados',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
      	$( "#progressbar" ).progressbar({
		      value: 75
		    });	
        $( "#demo" ).hide();
		},
		success:  function (response) {
			$( "#demo" ).show();
			$( "#progressbar" ).hide();
			$('#tablaEmpleado').dataTable().fnAddData(response);
		}	
	});			

});

//**************************************************
//Function que llama al Formulario Agregar Empleado*
//**************************************************
function showAgregarEmpleado(){
	top.frames['main'].location="../empleados/agregar_empleado.jsp"; 	
}


function showEditarEmpleado(id){
	top.frames['main'].location="../empleados/actualizar_empleado.jsp?id="+id; 	
}

function altaMasivaDeEmpleado(){
	top.frames['main'].location="../carga/carga.jsp"; 	
}

function bajaMasivaDeEmpleado(){
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/carga/revertir',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
      	$( "#progressbar" ).progressbar({
		      value: 75
		    });	
        $( "#demo" ).hide();
		},
		success:  function (response) {
			mensaje("CARGA REVERTIDA");
		}	
	});		
}

function ajax_downloadEmp(idNomina) {	
	var input_name="id1";
	//var id1=document.getElementById("idNomina").value;
	var id1=1;
	var url="../../mvc/reportes/obtenerempleados";
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
