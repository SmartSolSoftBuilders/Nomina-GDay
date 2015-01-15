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
	
	
});

//*******************************************************************************
//Function que guarda todos los datos de la Nomina
//*******************************************************************************
function guardarNomina() {
		$
			.ajax({
				data : {
					"nombreCorto" : $("#nombreNomina").val(),
					"razonSocial" : $("#razonSocial").val(),
					"patrona.nombreCorto" : $("#patrona").val(),
					"ejecutivo.nombreEjecutivo" : $("#ejecutivo").val(),
					"esquema.nombreEsquema" : $("#esquema").val(),
					"provisionAguinaldo" : $("#provisionAguinaldo").val(),
					"provisionVacaciones" : $("#provisionVacaciones").val(),
					"provisionPrimaVacacional" : $("#provisionPrimaVac").val(),
					"porcPrimaVacacional" : $("#porcPrimaVacacional").val(),
					"fondoAhorro" : $("#fondoDeAhorro").val(),
					"ivaExento" : $("#ivaExcento").val(),
					"comisionCostSocial" : $("#comisionCostoSocial").val(),
					"tipoPago" : $("#tipoPago").val(),
					"claseRiesgo" : $("#claseRiesgo").val(),
					"registroPatronal" : $("#registroPatronal").val(),
					"periodicidad" : $("#periodicidad").val(),
					"tipoCalendario.tipoCalendario" : $("#tipoCalendario").val(),
					"facturaSubsidio" : $("#factSub").val(),
					"reconoceAntiguedad" : $("#reconoceAntihuedad").val(),
					},
				
				dataType : 'json',
				url : '../../mvc/nomina/guardarnomina',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {
					$("#resultadoGuardar")
							.html(alert("La nomina se guard\u00f3 correctamente"));
				},
				error : function(response) {
					$("#resultadoGuardar").html();
				}
			});
		}


