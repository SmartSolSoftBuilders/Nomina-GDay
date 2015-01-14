function guardarNomina() {
		$
			.ajax({
				data : {
					"nombreCorto" : $("#nombreNomina").val(),
					"razonSocial" : $("#razonSocial").val(),
					"patrona" : $("#patrona").val(),
					"ejecutivo" : $("#ejecutivo").val(),
					"esquema" : $("#esquema").val(),
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
