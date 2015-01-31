//*********************************************************************************
//Obtener el idEmpleado por parametros en la url, que se manda desde el controller*
//*********************************************************************************
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

//manda el parametro idEmpleado y llama a la function obtenerEmpleado()
var idEmpleado=getParameter("id");
console.log("EMPLEADO!")
console.log(idEmpleado);
obtenerEmpleado(idEmpleado);

//*******************************************************************************
//Function que obtiene la nomina por idNomina y llama a la function 
//muestraDatos()
//*******************************************************************************
function obtenerEmpleado(idEmpleado){
	$.ajax({
		data: {
			"idEmpleado" : idEmpleado
	},
	dataType:'json',
	url:   '../../mvc/empleado/obtenerempleadobyid',
	type:  'post',		
	beforeSend: function () {	
	},
	success:  function (response) {
		console.log(response)
		muestraDatosEmpleado(response);	
		},	
	error: function (response) {																	
		$("#resultadoGuardar").html("Error");
		}		
	});		
}


//**************************************************************************
//Function que obtiene los datos registrados del Empleado para modificarlos* 
//**************************************************************************
function muestraDatosEmpleado(datos){
	var data=eval(datos);
	$("#numeroControl").val(data.noControl);
	$("#nss").val(data.nss);
	$("#curp").val(data.curp);
	$("#paterno").val(data.apellidoPaterno);
	$("#materno").val(data.apellidoMaterno);
	$("#nombre").val(data.nombre);
	$("#rfc").val(data.rfc);
	$("#fechaNacimiento").val(data.fechaNacimiento);
	$("#edad").val(data.edad);
	$("#sexo").val(data.sexo);
	$("#paisOrigen").val(data.paisOrigen);
	$("#nacionalidad").val(data.nacionalidad);
	$("#estadoCivil").val(data.estadoCivil);
	$("#correoElectronico").val(data.correoElectronico);
	$("#fechaIngreso").val(data.fechaIngresoReal);
	$("#listaNegra").val(data.listaNegra);
	$("#calle").val(data.calle);
	$("#numExt").val(data.numExterior);
	$("#numInt").val(data.numInterior);
	$("#colonia").val(data.colonia);
	$("#codPostal").val(data.codigoPostal);
	$("#municipioDel").val(data.municipioDel);
	$("#estado").val(data.entFederativa);
	$("#indentificacionOficial").val(data.docIfe);
	$("#actaNacimiento").val(data.docActNan);
	$("#curpDoc").val(data.docCurp);
	$("#rfcDoc").val(data.docRfc);
	$("#comprobanteDom").val(data.docComprobante);
	$("#comprobanteEst").val(data.docCompEst);
	$("#correoElec").val(data.docCorreo);
	$("#cuentaClave").val(data.docClabe);
	$("#preafiliacionImss").val(data.docPreafiliacion);
	$("#numCuenta").val(data.cuenta);
	$("#banco").val(data.banco);
	$("#tipoPago").val(data.tipoPago);
	$("#numCredito").val(data.noCredInfonavit);
	$("#descuentoVsmg").val(data.descInfonavitVsmg);
	$("#descuento").val(data.desInfonavitPorc);
	$("#importe").val(data.descInfonavitImp);
	$("#numPagos").val(data.descFonacotNum);
	$("#importeFonacot").val(data.descFonacotPago);
	$("#importeAlimenticio").val(data.pensionAlimImp);
	$("#porcentajeAlimenticio").val(data.pensionAlimPorc);
	$("#nombreAcreedor").val(data.pensionAlimAcred);
	$("#observaciones").val(data.pensionAlimObs);

}