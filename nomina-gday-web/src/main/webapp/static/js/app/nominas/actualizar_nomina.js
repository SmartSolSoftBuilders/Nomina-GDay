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

$(document).ready(function() {
	$.ajax({
		sync:true,
		dataType:'json',
		url:   '../../mvc/nomina/getdatoscombo',
		type:  'post',		
		beforeSend: function () {	
		},
		success:  function (response) {
			console.log (response[0]);
			var options = "";
			var result=response[0];
			 for (var i = 0; i < result.length; i++) {
			    	options += '<option value="' + result[i].idEjecutivo + '">' + result[i].nombreEjecutivo + ' '+ result[i].paternoEjecutivo + ' '+ result[i].maternoEjecutivo +'</option>';
			    }
			 $("#ejecutivo").append(options)
			console.log ("Esquema");
			console.log (response[1]);
				var options = "";
				var result=response[1];
				 for (var i = 0; i < result.length; i++) {
				    	options += '<option value="' + result[i].idEsquema + '">' + result[i].nombreEsquema +'</option>';
				    }
				 $("#esquema").append(options)
				
			},	
		error: function (response) {																	
			$("#resultadoGuardar").html("Error");
			}		
	});		
	
	var idNomina=getParameter("id");
	console.log(idNomina);
	obtenerNomina(idNomina);
	
});

function obtenerNomina(idNomina){
	console.log ("Obtener Nomina por id"+ idNomina);
	$.ajax({
		data: {
			"idNomina" : idNomina
	},
	dataType:'json',
	url:   '../../mvc/nomina/obtenernominabyid',
	type:  'post',		
	beforeSend: function () {	
	},
	success:  function (response) {
		muestraDatosNomina(response);	
		console.log ("success");
		console.log (response);
		},	
	error: function (response) {																	
		$("#resultadoGuardar").html("Error");
		}		
	});		
	
	//$("#divGrupos").dialog({close: function(event, ui) { window.location.reload(); }});
}

function muestraDatosNomina(datos){
	console.log ("success");
	console.log (datos);
	var data=eval(datos);
	console.log (data.ejecutivo.nombreEjecutivo);
	console.log (data.esquema.nombreEsquema);
	$("#nombreNomina").val(data.nombreCorto);
	$("#patrona").val(data.patrona.nombreCorto);
	$("#patronaIdSel").val(data.patrona.idPatrona);
	$("#ejecutivo").val(data.ejecutivo.idEjecutivo);
	$("#esquema").val(data.esquema.idEsquema);
	$("#provisionAguinaldo").val(data.provisionAguinaldo);
	$("#provisionVacaciones").val(data.provisionVacaciones);
	$("#provisionPrimaVacacional").val(data.provisionPrimaVac);
	$("#porcPrimaVacacional").val(data.porcPrimaVacacional);
	$("#fondoDeAhorro").val(data.fondoDeAhorro);
	$("#ivaExcento").val(data.ivaExcento);
	$("#comisionCostoSocial").val(data.comisionCostoSocial);
	$("#tipoPago").val(data.tipoPago);
	$("#claseRiesgo").val(data.claseRiesgo);
	$("#registroPatronal").val(data.registroPatronal);
	$("#periodicidad").val(data.periodicidad);
	$("#tipoCalendario").val(data.tipoCalendario.tipoCalendario);
	$("#tipoCalendarioIdSel").val(data.tipoCalendario.idTipoCalendario);

}

function actualizarNomina() {
			$
			.ajax({
				data : {
					"nombreCorto" : $("#nombreNomina").val(),
					"patrona.nombreCorto" : $("#patrona").val(),
					"ejecutivo.nombreEjecutivo" : $("#ejecutivo").val(),
					"esquema.nombreEsquema" : $("#esquema").val(),
					"provisionAguinaldo" : $("#provisionAguinaldo").val(),
					"provisionVacaciones" : $("#provisionVacaciones").val(),
					"provisionPrimaVac" : $("#provisionPrimaVac").val(),
					"porcPrimaVacacional" : $("#porcPrimaVacacional").val(),
					"fondoDeAhorro" : $("#fondoDeAhorro").val(),
					"ivaExcento" : $("#ivaExcento").val(),
					"comisionCostoSocial" : $("#comisionCostoSocial").val(),
					"tipoPago" : $("#tipoPago").val(),
					"claseRiesgo" : $("#claseRiesgo").val(),
					"registroPatronal" : $("#registroPatronal").val(),
					"periodicidad" : $("#periodicidad").val(),
					"tipoCalendario.tipoCalendario" : $("#tipoCalendario").val(),
				},
				
				dataType : 'json',
				url : '../../mvc/nomina/modificanomina',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {
					console.log("Actualizando");
					console.log(response);
					$("#resultadoGuardar")
							.html(alert("La actualizaci\u00f3n de Nomina se realiz\u00f3 correctamente"));
				},
				error : function(response) {
					$("#resultadoGuardar").html();
				}
			});
		}
