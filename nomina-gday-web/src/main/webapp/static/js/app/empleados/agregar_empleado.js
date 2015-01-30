function guardarEmpleado() {
		
		$
			.ajax({
				data : {
					"noControl" : $("#numeroControl").val(),
					"nss" : $("#nss").val(),
					"curp" : $("#idPatrona").val(),
					"apellidoPaterno" : $("#paterno").val(),
					"apellidoMaterno" : $("#materno").val(),
					"nombre" : $("#nombre").val(),
					"rfc" : $("#rfc").val(),
					"fechaNacimiento" : $("#fechaNacimiento").val(),
					"edad" : $("#edad").val(),
					"sexo" : $("#sexo").val(),
					"paisOrigen" : $("#paisOrigen").val(),
					"nacionalidad" : $("#nacionalidad").val(),
					"estadoCivil" : $("#estadoCivil").val(),
					"correoElectronico" : $("#correoElectronico").val(),
					"fechaIngresoReal" : $("#fechaIngreso").val(),
					"listaNegra" : $("#listaNegra").val(),
					"calle" : $("#calle").val(),
					"numExterior" : $("#numExt").val(),
					"numInterior" : $("#numInt").val(),
					"colonia" : $("#colonia").val(),
					"codigoPostal" : $("#codPostal").val(),
					"municipioDel" : $("#municipioDel").val(),
					"entFederativa" :$("#estado").val(),
					"docActNan" : $("#actaNacimiento").val(),
					"docCurp" : $("#curpDoc").val(),
					"docRfc" : $("#rfcDoc").val(),
					"docComprobante" : $("#comprobanteDom").val(),
					"docCompEst" : $("#comprobanteEst").val(),
					"docCorreo" : $("#correoElec").val(),
					"docClabe" : $("#cuentaClave").val(),
					"docPreafiliacion" : $("#preafiliacionImss").val(),
					"cuenta" : $("#numCuenta").val(),
					"banco" : $("#banco").val(),
					"tipoPago" : $("#tipoPago").val(),
					"noCredInfonavit" : $("#numCredito").val(),
					"descInfonavitVsmg" : $("#descuentoVsmg").val(),
					"desInfonavitPorc" : $("#descuento").val(),
					"descInfonavitImp" : $("#importe").val(),
					"descFonacotNum" : $("#numPagos").val(),
					"descFonacotPago" : $("#importeFonacot").val(),
					"pensionAlimImp" : $("#importeAlimenticio").val(),
					"pensionAlimPorc" : $("#porcentajeAlimenticio").val(),
					"pensionAlimAcred" : $("#nombreAcreedor").val(),
					"pensionAlimObs" : $("#observaciones").val()
					},
				
				dataType : 'json',
				url : '../../mvc/empleado/guardarempleado',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {
					mensajeRedireccion("EMPLEADO CREADO CORRECTAMENTE.","../empleados/empleados.jsp");
				},
				error : function(response) {
					$("#resultadoGuardar").html();
				}
			});
}