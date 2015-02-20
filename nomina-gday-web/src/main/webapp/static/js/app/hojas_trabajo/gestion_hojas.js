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
		data:{"idNomina":idNom},
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

