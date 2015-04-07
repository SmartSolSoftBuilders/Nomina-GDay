//**************************************************************************
//Function que muestra los datos de las Nominas registradas en un dataTable*
//**************************************************************************
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


//***********************************
//Function obtenerEmpleadoByIdNomina*
//***********************************
function obtenerEmpleadoByIdNomina(idNominaB){
	oTableEmpleados=$('#tablaEmpleados').dataTable();
	document.getElementById("idNomina").value=idNominaB;
	$.ajax({
		sync: true,
		data:{idNomina:idNominaB},
		type:  'post',
		url:   '../../mvc/empleado/getempleadosbyidnomina',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
			$( "#progressbar" ).progressbar({
				value: 75
			});	
			$( "#demo" ).hide();
		},
		success:  function (response) {
			console.log(idNominaB);
			$( "#demo" ).show();
			$( "#progressbar" ).hide();
			oTableEmpleados.fnClearTable();

			oTableEmpleados.dataTable().fnAddData(response);
			$("#divSeleccionNominaPorEmpleado").dialog(({show: "slide", modal: true, width:700, height:600,
				autoOpen: true}));
			//setData(response);
		}		,
		error:  function (response) {
			console.log(response);
			alert(response);
		}
	});			
	
}

//**********************************************
//Function que descargar la Nomina por Empleado*
//**********************************************
function ajax_download(idNomina) {	
	var input_name="id1";
	var id1=document.getElementById("idNomina").value;	
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

//****************************************
//Function que llama al Formulario Editar*
//****************************************
function showEditarNomina(idNomina){
	top.frames['main'].location="../nominas/actualizar_nomina.jsp?id="+idNomina; 	
}

//*****************************************
//Function que llama al Formulario Agregar*
//*****************************************
function showAgregarNomina(){
	top.frames['main'].location="../nominas/agregar_nomina.jsp"; 	
}

function showEditarEmpleado(id){
	top.frames['main'].location="../empleados/actualizar_empleado.jsp?id="+id; 	
}