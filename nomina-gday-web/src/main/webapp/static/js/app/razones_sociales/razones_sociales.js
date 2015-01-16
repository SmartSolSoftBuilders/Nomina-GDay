//Function que muestra todas las razones sociales en un data table
$(document).ready(function() {
	oTableRazonesSociales=$('#tablaRazonSocial').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/razonsocial/getrazonessociales',
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
			$('#tablaRazonSocial').dataTable().fnAddData(response);
			//setData(response);
		}		,
		error:  function (response) {
			alert(response);
		}
	});			

});

//Function que me llevan a un jsp por id o por ruta
function showEditarRazonSocial(idRazonSocial){
	top.frames['main'].location="../razones_sociales/actualizar_razonsocial.jsp?id="+idRazonSocial; 	
}

function showAgregarRazonSocial(){
	top.frames['main'].location="../razones_sociales/agregar_razonsocial.jsp"; 	
}

function showNominasPorRazonSocial(idRazonSocial){
	top.frames['main'].location="../razones_sociales/razones_sociales.jsp?id="+idRazonSocial; 	
}

function obtenerIdNomina(idNomina){
	console.log ("Obtener Nominas por idNomina"+ idNomina);
	$.ajax({
		data: {
			"idNomina" : idNomina
	},
	dataType:'json',
	url:   '../../mvc/razonsocial/getnominasbyidrazonsocial',
	type:  'post',		
	beforeSend: function () {	
	},
	success:  function (response) {
		muestraDatosRazonSocial(response);	
		console.log ("success");
		console.log (response);
		},	
	error: function (response) {																	
		$("#resultadoGuardar").html("Error");
		}		
	});		
	
}

//Function que muestra las nominas por razon social
function showNominasPorRazonSocial(id){	
	$('#tablaNominasPorRazonSocial').dataTable().fnClearTable();
	oTableNominas=$('#tablaNominasPorRazonSocial').dataTable();
	$.ajax({
		data : {idRazonSocial : id},
		sync: true,
		type:  'post',
		url:   '../../mvc/razonsocial/getnominasbyidrazonsocial',
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
			$('#tablaNominasPorRazonSocial').dataTable().fnAddData(response);
			//setData(response);
		}		,
		error:  function (response) {
			console.log(response);
			alert(response);
		}
	});			
	$("#divNominas").dialog(({show: "slide", modal: true, width:700, height:600,
		autoOpen: true}));
	}