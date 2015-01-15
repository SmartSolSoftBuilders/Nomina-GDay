//*******************************************************************************
//Obtener el idNomina por parametros en la url, que se manda desde el controller
//*******************************************************************************
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
	$.ajax({
		sync:true,
		dataType:'json',
		url:   '../../mvc/nomina/getdatoscombo',
		type:  'post',		
		beforeSend: function () {	
		},
		success:  function (response) {
			var options = "";
			var result=response[0];
			 for (var i = 0; i < result.length; i++) {
			    	options += '<option value="' + result[i].idEjecutivo + '">' + result[i].nombreEjecutivo + ' '+ result[i].paternoEjecutivo + ' '+ result[i].maternoEjecutivo +'</option>';
			    }
			 $("#ejecutivo").append(options)
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
	
	//manda el parametro idNomina y llama a la function obtenerNomina()
	var idNomina=getParameter("id");
	console.log(idNomina);
	obtenerNomina(idNomina);
	
});

//*******************************************************************************
//Function que obtiene la nomina por idNomina y llama a la function 
//muestraDatos()
//*******************************************************************************
function obtenerNomina(idNomina){
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
		},	
	error: function (response) {																	
		$("#resultadoGuardar").html("Error");
		}		
	});		
}

//*******************************************************************************
//Function que obtiene los datos registrados de la Nomina para modificarlos 
//*******************************************************************************
function muestraDatosNomina(datos){
	var data=eval(datos);
	$("#nombreNomina").val(data.nombreCorto);
	$("#nominaIdSel").val(data.idNomina);
	$("#patrona").val(data.patrona.nombreCorto);
	$("#patronaIdSel").val(data.patrona.idPatrona);
	$("#ejecutivo").val(data.ejecutivo.idEjecutivo);
	$("#esquema").val(data.esquema.idEsquema);
	if (data.provisionAguinaldo){
		
		$("#provisionAguinaldo").attr("checked",true);
	}
	if (data.provisionVacaciones){
		
		$("#provisionVacaciones").attr("checked",true);
	}
	
	if (data.provisionPrimaVacacional){
		$("#provisionPrimaVac").attr("checked",true);
	}	
	$("#porcPrimaVacacional").val(data.porcPrimaVacacional);
	
	if (data.fondoAhorro){
		
		$("#fondoDeAhorro").attr("checked",true);
	}	
	if (data.ivaExento){
		
		$("#ivaExcento").attr("checked",true);
	}	
	if (data.comisionCostSocial){
		
		$("#comisionCostoSocial").attr("checked",true);
	}	
	if (data.facturaSubsidio){
		
		$("#factSub").attr("checked",true);
	}	
	if (data.reconoceAntiguedad){
		
		$("#reconoceAntihuedad").attr("checked",true);
	}	
	$("#tipoPago").val(data.tipoPago);
	$("#claseRiesgo").val(data.claseRiesgo);
	$("#registroPatronal").val(data.registroPatronal);
	$("#periodicidad").val(data.periodicidad);
	$("#tipoCalendario").val(data.tipoCalendario.tipoCalendario);
	$("#tipoCalendarioIdSel").val(data.tipoCalendario.idTipoCalendario);

}

//*******************************************************************************
//Function que actualiza la Nomina con los datos modificados 
//*******************************************************************************
function actualizarNomina() {
	console.log(nominaIdSel);
			$
			.ajax({
				data : {
					"nombreCorto" : $("#nombreNomina").val(),
					"idNomina" : $("#nominaIdSel").val(),
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
					console.log(response);
					$("#resultadoGuardar").html();
				}
			});
		}
