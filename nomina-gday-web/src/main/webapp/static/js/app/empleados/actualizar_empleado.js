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

var idEmpleado=getParameter("id");
console.log("EMPLEADO")
console.log(idEmpleado);
obtenerEmpleado(idEmpleado);

//Valida los elementos del Formulario
$(document).ready(function() {
	$("#actualizarEmpleadoForm").validate({
		rules: {
			numeroControl: {"required":true,"maxlength": 8},
			nss : {"required":true,"maxlength": 35},
			curp : {"required":true,"maxlength": 18},
			paterno : {"required":true,"maxlength": 50},
			materno : {"required":true,"maxlength": 50},
			nombre : {"required":true,"maxlength": 60},
			rfc :  {"required":true,"maxlength": 20},
			fechaNacimiento : {"required":true},
			edad : {"required":true,"number": true},
			sexo : {"required":true,"maxlength": 30},
			nacionalidad : {"required":true,"maxlength": 40},
			correoElectronico : {"required":true,"maxlength": 100},
			fechaIngreso : {"required":true},
			calle : {"required":true,"maxlength": 200},
			numExt : {"required":true,"maxlength": 50},
			numInt : {"required":true,"maxlength": 50},
			colonia : {"required":true,"maxlength": 120},
			codPostal : {"required":true,"number":true},
			municipioDel : {"required":true,"maxlength": 50},
			entFederativa : {"required":true,"maxlength": 80},
			numCuenta : {"required":true,"maxlength": 40},
			documentoMigratorio:{			
				required: function (element) {							
					if($("#extranjero").is(':checked')){ if ($("#documentoMigratorio").val()=="")	return true;}	                
	                else	                
	                    return false;	                
				}				
			},
			fechaVigenciaDocMig:{			
				required: function (element) {							
					if($("#extranjero").is(':checked')){ if ($("#fechaVigenciaDocMig").val()=="")	return true;}	                
	                else	                
	                    return false;	                
				}
			},
			numCredito:{			
				required: function (element) {							
					if($("#datosInfonavit").is(':checked')){ if ($("#numCredito").val()=="")	return true;}	                
	                else	                
	                    return false;	                
				},
				number: true
			},
			descuentoVsmg:{
				required: function (element) {							
					if($("#datosInfonavit").is(':checked')){ if ($("#descuentoVsmg").val()=="")	return true;}	                
	                else	                
	                    return false;	                
				},
				number: true
			},
			descuento:{
				required: function (element) {							
					if($("#datosInfonavit").is(':checked')){ if ($("#descuento").val()=="")	return true;}	                
	                else	                
	                    return false;	                
				},
				number: true
			},
			importe:{
				required: function (element) {							
					if($("#datosInfonavit").is(':checked')){ if ($("#importe").val()=="")	return true;}	                
	                else	                
	                    return false;	                
				},
				number: true
			},
			numPagos:{			
				required: function (element) {							
					if($("#fonacot").is(':checked')){ if ($("#numPagos").val()=="")	return true;}	                
	                else	                
	                    return false;	                
				},
				number: true
			},
			importeFonacot:{			
				required: function (element) {							
					if($("#fonacot").is(':checked')){ if ($("#importeFonacot").val()=="")	return true;}	                
	                else	                
	                    return false;	                
				},
				number: true
			},
			importeAlimenticio:{			
				required: function (element) {							
					if($("#pensionAlimenticia").is(':checked')){ if ($("#importeAlimenticio").val()=="")	return true;}	                
	                else	                
	                    return false;	                
				},
				number: true
			},
			porcentajeAlimenticio:{			
				required: function (element) {							
					if($("#pensionAlimenticia").is(':checked')){ if ($("#porcentajeAlimenticio").val()=="")	return true;}	                
	                else	                
	                    return false;	                
				},
				number: true				
			},
			nombreAcreedor:{			
				required: function (element) {							
					if($("#pensionAlimenticia").is(':checked')){ if ($("#nombreAcreedor").val()=="")	return true;}	                
	                else	                
	                    return false;	                
				},
				maxlength: 100
			},
			//pensionAlimenticia: importeAlimenticio,	porcentajeAlimenticio,nombreAcreedor,observaciones
			observaciones:{			
				required: function (element) {							
					if($("#pensionAlimenticia").is(':checked')){ if ($("#observaciones").val()=="")	return true;}	                
	                else	                
	                    return false;	                
				},
				maxlength: 100
			}						
			
		},        
		messages: {
			numeroControl: "Campo Requerido. M&aacute;ximo 8",
			nss : "Campo Requerido. M&aacute;ximo 35",
			curp : "Campo Requerido. M&aacute;ximo 18",
			paterno : "Campo Requerido. M&aacute;ximo 50",
			materno : "Campo Requerido. M&aacute;ximo 50",
			nombre : "Campo Requerido. M&aacute;ximo 60",
			rfc :  "Campo Requerido. M&aacute;ximo 20",
			fechaNacimiento : "Seleccione una Fecha de Nacimiento",
			edad : "Ingrese la Edad, solo n&uacute;meros",
			sexo : "Campo requerido",
			nacionalidad : "Campo Requerido. M&aacute;ximo 40",
			correoElectronico : "Campo Requerido. M&aacute;ximo 100",
			fechaIngreso : "Ingrese la Fecha de Ingreso",
			calle : "Campo Requerido. M&aacute;ximo 200",
			numExt : "Ingrese un No.Exterior",
			numInt : "Ingrese un No.Interior",
			colonia : "Campo Requerido. M&aacute;ximo 120",
			codPostal : "Campo Requerido, solo n&uacute;meros",
			municipioDel : "Campo Requerido. M&aacute;ximo 50",
			entFederativa : "Campo Requerido. M&aacute;ximo 80",
			numCuenta : "Campo Requerido. M&aacute;ximo 40",			
			descuentoVsmg : "Ingrese el Descuento, solo n&uacute;meros",
			descuento : "Ingrese un porcentaje, solo n&uacute;meros ",
			importe : "Ingrese un Importe, solo n&uacute;meros",
			numPagos : "Ingrese el No.Pagos, solo n&uacute;meros",
			numCredito: "Requerido, solo n&uacute;meros",
			importeFonacot : "Ingrese el Importe de Fonacot, solo n&uacute;meros",
			importeAlimenticio : "Ingrese el Importe Alimenticio, solo n&uacute;meros",
			porcentajeAlimenticio : "Ingrese el porcentaje Alimenticio, solo n&uacute;meros",					
			nombreAcreedor:"Campo requerido, m&aacute;ximo 100",
			observaciones:"Campo requerido,m&aacute;ximo 100"			
				
		},
		submitHandler: function(form) {
			form.submit();
		}
	});
	
	$("#actualizarNominaEmpleadoForm").validate({
		rules: {
			fechaingresoformnomina: "required",
			fechaNacimiento : "required",
			sueldomensualformnomina : {"required":true,"number": true},
			sueldodiarioformnomina : {"required":true,"number": true},
			sueldodiariointformnomina : {"required":true,"number": true},
			numtrabajadorclienteoformnomina : {"required":true,"maxlength": 30},
			nombreotropatronformnomina : {			
				required: function (element) {							
					if($("#otropatronformnomina").val()=="SI"){ 
						if ($("#nombreotropatronformnomina").val()=="")	
							return true;
						}	                
		               else	                
		                   return false;	                
					},
				maxlength: 100
			},
			rfcnformnomina : {
				required: function (element) {							
				if($("#otropatronformnomina").val()=="SI"){ 
					if ($("#rfcnformnomina").val()=="")	
						return true;
					}	                
	               else	                
	                   return false;	                
				},
			maxlength: 100
			},			
			calleformnomina:{"required":true,"maxlength": 30},
			numextformnomina : {"required":true,"maxlength": 20},
			numintformnomina : {"required":true,"maxlength": 20},
			cpformnomina : {"required":true,"maxlength": 10},
			coloniaformnomina : {"required":true,"maxlength": 25},
			mundelformnomina : {"required":true,"maxlength": 25},
			nombreotropatronformnomina : {			
				required: function (element) {							
					if($("#otropatronformnomina").val()=="SI"){ 
						if ($("#nombreotropatronformnomina").val()=="")	
							return true;
						}	                
		               else	                
		                   return false;	                
					},
				maxlength: 100
			},
			rfcnformnomina : {
				required: function (element) {							
				if($("#otropatronformnomina").val()=="SI"){ 
					if ($("#rfcnformnomina").val()=="")	
						return true;
					}	                
	               else	                
	                   return false;	                
				},
			maxlength: 100
			},			
			suministrosformnomina : "required",			
			puestosformnomina : "required",
			serviciosformnomina : "required",
			tiposalarioformnomina : "required",
			areaformnomina : "required",		
		},        
		messages: {
			fechaingresoformnomina: "Ingrese una fecha de Ingreso",
			sueldomensualformnomina : "Ingrese el sueldo Mensual, solo n&uacute;meros",
			sueldodiarioformnomina : "Ingrese el sueldo Diario, solo n&uacute;meros ",
			sueldodiariointformnomina : "Ingrese el Sueldo Diario Integrado, solo n&uacute;meros",
			numtrabajadorclienteoformnomina : "Ingrese un Numero de Trabajador Cliente. M&aacute;ximo 30",
			nombreotropatronformnomina : "Ingrese el nombre de otro patron. M&aacute;ximo 80",
			rfcnformnomina : "Ingrese el RFC. M&aacute;ximo 13",
			calleformnomina : "Ingrese el nombre de la Calle. M&aacute;ximo 13",
			numextformnomina : "Ingrese el numero Exterior. M&aacute;ximo 20",
			numintformnomina : "Ingrese el numero Interior. M&aacute;ximo 20",
			cpformnomina : "Ingrese el CP. M&aacute;ximo 10",
			coloniaformnomina : "Ingrese la Colonia.M&aacute;ximo 25",
			mundelformnomina : "Ingrese el Municipio.M&aacute;ximo 25",
		},
		
		
		submitHandler: function(form) {
			form.submit();
		}
	});
	$("#bajaNominaEmpleadoForm").validate({
		rules: {
			fechabajaTmpformnomina: "required",
			loteimssbajaformnomina: "required",
		    
					
		},        
		messages: {
			fechabajaTmpformnomina: "Ingrese una fecha de Baja",
			loteimssbajaformnomina: "Ingrese un lote movimiento baja IMSS",
		},
		
		submitHandler: function(form) {
			form.submit();
		}
	});
});//Cierra la validacion del formulario


//*******************************************************************************
//Function que obtiene la nomina por idNomina y llama a la function 
//muestraDatos()
//*******************************************************************************
function obtenerEmpleado(idEmpleado){
	$.ajax({
		data: {
			"idEmpleado" : idEmpleado
	},
	sync:true,
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
		console.log(respone)
		$("#resultadoGuardar").html("Error");
		}		
	});		
}

function obtenerNominasAsignadasAEmpleado(idEmpleado){
	$.ajax({
		data: {
			"idEmpleado" : idEmpleado
	},
	sync:true,
	dataType:'json',
	url:   '../../mvc/nomina/obtenernominasbyempleado',
	type:  'post',		
	beforeSend: function () {	
	},
	success:  function (response) {
			console.log("NOMINAS DEL EMPLEADO:");
			console.log(response);
			setDataNominasEmpleado(response);
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
	console.log("DAtos empleados")
	console.log(datos)
	$("#idEmpleado").val(data.idEmpleado),
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
	
	if (data.docIfe==true)
		$("#indentificacionOficial").prop('checked', true);
	if (data.docActNan==true)
		$("#actaNacimiento").prop('checked', true);
	if (data.docCurp==true)
		$("#curpDoc").prop('checked', true);
	if (data.docRfc==true)
		$("#rfcDoc").prop('checked', true);	
	if (data.docComprobante==true)
		$("#comprobanteDom").prop('checked', true);
	if (data.docCompEst==true)
		$("#comprobanteEst").prop('checked', true);
	if (data.docCorreo==true)
		$("#correoElec").prop('checked', true);
	if (data.docClabe==true)
		$("#cuentaClave").prop('checked', true);
	if (data.docPreafiliacion==true)
		$("#preafiliacionImss").prop('checked', true);	
	
	if (data.cuenta!="")
		$('#datosInfonavit').prop('checked',true);
	if (data.descFonacotNum!="")
		$('#pensionAlimenticia').prop('checked',true);
	if (data.pensionAlimImp!="")
		$('#fonacot').prop('checked',true);
	if (data.listaNegra==true)
		$('#listaNegra').prop('checked',true);
	
	if (data.documentoMigratorio!=null && data.documentoMigratorio!='')
		$('#extranjero').prop('checked',true);
	if (data.reconoceAntiguedad==true)
		$('#reconoceAntiguedad').prop('checked',true);
	
	$("#documentoMigratorio").val(data.documentoMigratorio);
	$("#fechaVigenciaDocMig").val(data.fechaVigenciaDocumentoMigratorio);
	$("#reconoceAntiguedad").val(data.reconoceAntiguedad);
	
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
	habilitarExtranjero();
	obtenerNominasAsignadasAEmpleado(data.idEmpleado);
}


//****************************************************
//Function que actualiza todos los datos del Empleado*
//****************************************************
function actualizarEmpleado() {
	var tmp1=false;
	var tmp2=false;
	var tmp3=false;
	var tmp4=false;
	var tmp5=false;
	var tmp6=false;
	var tmp7=false;
	var tmp8=false;
	var tmp9=false;
	var tmp10=false;
	
	if ($("#indentificacionOficial").prop('checked'))
		tmp1=true;
	if ($("#actaNacimiento").prop('checked'))
		tmp2=true;
	if ($("#curpDoc").prop('checked'))
		tmp3=true;
	if ($("#rfcDoc").prop('checked'))
		tmp4=true;
	if ($("#comprobanteDom").prop('checked'))
		tmp5=true;
	if ($("#comprobanteEst").prop('checked'))
		tmp6=true;
	if ($("#correoElec").prop('checked'))
		tmp7=true;
	if ($("#cuentaClave").prop('checked'))
		tmp8=true;
	if ($("#preafiliacionImss").prop('checked'))
		tmp9=true;
	if ($("#listaNegra").prop('checked'))
		tmp10=true;
				
	if ($("#actualizarEmpleadoForm").valid()){	
		$
			.ajax({
				data : {
					"idEmpleado" : $("#idEmpleado").val(),
					"noControl" : $("#numeroControl").val(),
					"nss":$("#nss").val(),
					"curp":$("#curp").val(),
					"apellidoPaterno":$("#paterno").val(),
					"apellidoMaterno":$("#materno").val(),
					"nombre":$("#nombre").val(),
					"rfc":$("#rfc").val(),
					"documentoMigratorio":$("#documentoMigratorio").val(),
					"fechaVigenciaDocumentoMigratorio":$("#fechaVigenciaDocMig").val(),
					"reconoceAntiguedad":$("#reconoceAntiguedad").prop('checked'),
					"fechaNacimiento":$("#fechaNacimiento").val(),
					"edad":$("#edad").val(),
					"sexo":$("#sexo").val(),
					"paisOrigen":$("#paisOrigen").val(),
					"nacionalidad":$("#nacionalidad").val(),
					"estadoCivil":$("#estadoCivil").val(),
					"correoElectronico":$("#correoElectronico").val(),
					"fechaIngresoReal":$("#fechaIngreso").val(),
					"listaNegra":tmp10,
					"calle":$("#calle").val(),
					"numExterior":$("#numExt").val(),
					"numInterior":$("#numInt").val(),
					"colonia":$("#colonia").val(),
					"codigoPostal":$("#codPostal").val(),
					"municipioDel":$("#municipioDel").val(),
					"entFederativa":$("#estado").val(),
					"docIfe":tmp1,
					"docActNan":tmp2,
					"docCurp":tmp3,
					"docRfc":tmp4,
					"docComprobante":tmp5,
					"docCompEst":tmp6,
					"docCorreo":tmp7,
					"docClabe":tmp8,
					"docPreafiliacion":tmp9,
					"cuenta":$("#numCuenta").val(),
					"banco":$("#banco").val(),
					"tipoPago":$("#tipoPago").val(),
					"noCredInfonavit":$("#numCredito").val(),
					"descInfonavitVsmg":$("#descuentoVsmg").val(),
					"desInfonavitPorc":$("#descuento").val(),
					"descInfonavitImp":$("#importe").val(),
					"descFonacotNum":$("#numPagos").val(),
					"descFonacotPago":$("#importeFonacot").val(),
					"pensionAlimImp":$("#importeAlimenticio").val(),
					"pensionAlimPorc":$("#porcentajeAlimenticio").val(),
					"pensionAlimAcred":$("#nombreAcreedor").val(),
					"pensionAlimObs":$("#observaciones").val(),
				},
				
				dataType : 'json',
				url : '../../mvc/empleado/modificaempleado',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {
					mensajeRedireccion("EMPLEADO ACTUALIZADO CORRECTAMENTE","../empleados/empleados.jsp");


				},
				error : function(response) {
					mensaje("IMPOSIBLE ACTUALIZAR EL EMPLEADO. CONTACTE CON EL ADMINISTRADOR.");
				}
			});
	}
}

function showEditarEmpleado(idEmpleado){
	top.frames['main'].location="../empleados/actualizar_empleado.jsp?id="+idEmpleado; 
}

function cancelar(){
	top.frames['main'].location="../empleados/empleados.jsp"; 	
}

//LOGICA PARA AGREGAR EMPLEADOS
function agregarNominaAEmpleado(){
oTableNominas=$('#tablaNominas').dataTable();
$.ajax({
	sync: true,
	type:  'post',
	url:   '../../mvc/nomina/getnominasemp',
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
		$('#tablaNominas').dataTable().fnAddData(response);
		$("#divSeleccionNominaParaEmpleado").dialog(({show: "slide",
				modal: true, width:900, height:900,
			autoOpen: true}));
	}		,
	error:  function (response) {
		console.log(response);
		alert(response);
	}
});			
}

function showNominaForm(idNomina,nombre){
	document.getElementById("idnominaformnomina").value=idNomina;
	document.getElementById("nombrenominaformnomina").value=nombre;
	$("#divSeleccionNominaParaEmpleado").dialog("close");
	$.ajax({
		sync:true,
		dataType:'json',
		url:   '../../mvc/empleado/getdatoscombo',
		type:  'post',		
		beforeSend: function () {	
		},
		success:  function (response) {
			console.log (response[0]);
			var options = "";
			var result=response[0];
			 for (var i = 0; i < result.length; i++) {
			    	options += '<option value="' + result[i].idArea + '">' + result[i].descripcion +'</option>';
			    }
			$("#areaformnomina").append(options)
			console.log ("area");
			
			console.log (response[1]);	
			var options = "";
			var result=response[1];
			for (var i = 0; i < result.length; i++) {
				options += '<option value="' + result[i].idProceso + '">' + result[i].descripcion +'</option>';
			}
			$("#proceso").append(options)
			console.log ("proceso");

			console.log (response[2]);	
			var options = "";
			var result=response[2];
			for (var i = 0; i < result.length; i++) {
				options += '<option value="' + result[i].idDepartamento + '">' + result[i].descripcion +'</option>';
			}
			$("#departamento").append(options)
			console.log ("departamento");

			console.log (response[3]);	
			var options = "";
			var result=response[3];
			for (var i = 0; i < result.length; i++) {
				options += '<option value="' + result[i].idPuesto + '">' + result[i].descripcion +'</option>';
			}
			$("#puestosformnomina").append(options)
			console.log ("puestos");		
			$("#tablaFormNominas").dialog(({show: "slide",  					stack: false,
				draggable: false,resizable: false,modal: true, width:960, height:900,
				autoOpen: true}));			
			$("#buttonAgregar").show();
			$("#buttonGuardar").hide();
	}
	});	
}
 
function showEditarNominaForm(idNomina,nombre){
	document.getElementById("idnominaformnomina").value=idNomina;
	document.getElementById("nombrenominaformnomina").value=nombre;
	//alert(idNomina+"---->"+$("#idEmpleado").val())
	$.ajax({
		sync:true,
		dataType:'json',
		url:   '../../mvc/empleado/getdatoscombo',
		type:  'post',		
		beforeSend: function () {	
		},
		success:  function (response) {
			console.log (response[0]);
			var options = "";
			var result=response[0];
			 for (var i = 0; i < result.length; i++) {
			    	options += '<option value="' + result[i].idArea + '">' + result[i].descripcion +'</option>';
			    }
			$("#areaformnomina").append(options)
			console.log ("area");
			
			console.log (response[1]);	
			var options = "";
			var result=response[1];
			for (var i = 0; i < result.length; i++) {
				options += '<option value="' + result[i].idProceso + '">' + result[i].descripcion +'</option>';
			}
			$("#proceso").append(options)
			console.log ("proceso");

			console.log (response[2]);	
			var options = "";
			var result=response[2];
			for (var i = 0; i < result.length; i++) {
				options += '<option value="' + result[i].idDepartamento + '">' + result[i].descripcion +'</option>';
			}
			$("#departamento").append(options)
			console.log ("departamento");

			console.log (response[3]);	
			var options = "";
			var result=response[3];
			for (var i = 0; i < result.length; i++) {
				options += '<option value="' + result[i].idPuesto + '">' + result[i].descripcion +'</option>';
			}
			$("#puestosformnomina").append(options)
			console.log ("puestos");				

		}	
	
	});
	$.ajax({		
		data:{
			"nomina.idNomina":idNomina,
			"empleado.idEmpleado":$("#idEmpleado").val()
		},
		sync: true,
		dataType:  'json',
		url: '../../mvc/empleado/getnominasempbyid2',
		type: 'post',		
		beforeSend: function () {			
		},
		success:  function (data) {
			console.log(data);
			$("#tablaFormNominas").dialog(({show: "slide", stack: false,
				draggable: false,resizable: false,modal: true, width:960, height:900,
				autoOpen: true}));
			$("#fechaingresoformnomina").val(data[0]);
			$("#estatusformnomina").val(data[1]);
			$("#tiposalarioformnomina").val(data[2]);
			$("#fechabajaformnomina").val(data[3]);
			$("#tipocontratoformnomina").val(data[4]);
			console.log($("#fechavencimientoformnomina").val())
			console.log($("#fechaingresoformnomina").val())
			
			$("#fechavencimientoformnomina").val(data[5]);
			colocarAvisoFechaVencimiento($("#fechaingresoformnomina").val(),$("#fechavencimientoformnomina").val())
			
			$("#sueldomensualformnomina").val(data[6]);
			$("#sueldodiarioformnomina").val(data[7]);
			$("#sueldodiariointformnomina").val(data[8]);
			$("#loteimssformnomina").val(data[9]);
			$("#plazatrabajoformnomina").val(data[10]);
			$("#numtrabajadorclienteoformnomina").val(data[11]);			
			console.log("OTRO PATR")
			console.log(data[12])
			if (data[12]==true)
				$("#otropatronformnomina").val("SI");
			else
				$("#otropatronformnomina").val("NO");
			$("#nombreotropatronformnomina").val(data[13]);
			$("#rfcnformnomina").val(data[14]);
			$("#calleformnomina").val(data[15]);
			$("#numextformnomina").val(data[16]);
			$("#numintformnomina").val(data[17]);
			$("#cpformnomina").val(data[18]);
			$("#coloniaformnomina").val(data[19]);
			$("#mundelformnomina").val(data[20]);
			$("#estadoformnomina").val(data[21]);
			$("#suministrosformnomina").val(data[22]);
			//$("#actividadesformnomina").val(data.actividades);
			$("#puestosformnomina").val(data[23]);
			$("#areaformnomina").val(data[24]);
			$("#departamento").val(data[25]);
			console.log("proc"+data[27])
			$("#proceso").val(data[27]);
			$("#serviciosformnomina").val(data[27]);
								
			$("#buttonAgregar").hide();
			$("#buttonGuardar").show();			
		},
		error:  function (response) {
			console.log("ERROR gETT"+response);
			alert(response);
		}
	});			

}

function shoBajaNominaForm(){
	$("#tablaBajaFormNominas").dialog(({show: "slide", stack: false,
		draggable: false,resizable: false,modal: true, width:780, height:900,
		autoOpen: true}));	
}


function hideNominaForm(){
	$("#tablaFormNominas").dialog("close");	
	$("#divSeleccionNominaParaEmpleado").dialog("open");	
}

function closeAllModal(){
	$("#tablaFormNominas").dialog("close");	
	$("#divSeleccionNominaParaEmpleado").dialog("close");	
}

function setDataNominasEmpleado(data){
	for (var i=0;i<data.length;i++){
		document.getElementById("nombrenominaformnomina").value=data[i].nombreCorto;
		document.getElementById("idnominaformnomina").value=data[i].idNomina;
		document.getElementById("statnominaformnomina").value=data[i].tipoPago;
		console.log(data[i]);
		agregarObjetoJS();
	}
}
function agregarObjetoJS(){
	if ($("#actualizarNominaEmpleadoForm").valid()){	

	var nomina = document.getElementById("nombrenominaformnomina").value;
	var idnomina =document.getElementById("idnominaformnomina").value;
	var table = document.getElementById("tablanominasasignadas");
	
    var rowCount = table.rows.length;
	var row = table.insertRow(rowCount);
    console.log(rowCount);
    var indice=rowCount;
    var cell1 = row.insertCell(0);
    var att = document.createAttribute("readonly");
    var element1 = document.createElement("input");
    element1.type = "text";
    element1.value=nomina;
    element1.id=idnomina;    
    element1.setAttributeNode(att);
    cell1.appendChild(element1);
    var cell2 = row.insertCell(1);
    var element2 = document.createElement("input");
    element2.type = "text";
    element2.value=		document.getElementById("statnominaformnomina").value;
    var att2 = document.createAttribute("readonly");
    element2.setAttributeNode(att2);
    cell2.appendChild(element2);
    var cell4 = row.insertCell(2);	    
    var element4 = document.createElement("input");
    element4.type = "checkbox";
    cell4.appendChild(element4);
	document.getElementById("nominasNum").value=parseInt(document.getElementById("nominasNum").value)+1;
	//closeAllModal();
	}
}	

function eliminarObjetoJS () {
	if (confirm ("Seguro que desea eliminar el elemento?:")){
    try {
    var table = document.getElementById("tablanominasasignadas");
    var rowCount = table.rows.length;
    for(var i=0; i<rowCount; i++) {
         var row = table.rows[i];
         console.log("ID NOMINA ELIMINADO");   
         var chkbox = row.cells[2].childNodes[0];
         console.log(row.cells[0].childNodes[0].id);
         if(null != chkbox && true == chkbox.checked) {
              table.deleteRow(i);
              rowCount--;
              i--;
            var idNominaEliminar=row.cells[0].childNodes[0].id;
          	if (parseInt(document.getElementById("nominasNum").value)>0)
          		document.getElementById("nominasNum").value=parseInt(document.getElementById("nominasNum").value)-1;			
         }
    }
    //Eliminando del arreglo JS
    for (var i=0; i<nominasAsignadas.length;i++){
    	console.log("Revisando");
    	console.log(nominasAsignadas[i]);
    	console.log(idNominaEliminar);
        if (nominasAsignadas[i][0]==idNominaEliminar){
        	console.log("eliminando!");
        	delete nominasAsignadas[i];
        	break;
        }
    }  
    console.log("El arreglo queda así:");
	console.log(nominasAsignadas);
	
    }
    catch(e) {

         alert(e);

    }
   }
}


function editarObjetoJS () {
    try {
    var table = document.getElementById("tablanominasasignadas");
    var rowCount = table.rows.length;
    var idSel=0;
    for(var i=0; i<rowCount; i++) {
         var row = table.rows[i];
         console.log("ID NOMINA ELIMINADO");   
         var chkbox = row.cells[2].childNodes[0];
         console.log(row.cells[0].childNodes[0].id);
         if(null != chkbox && true == chkbox.checked) {
              idSel=row.cells[0].childNodes[0].id;
         }
    }
    console.log("Editando:"+idSel);    
	showEditarNominaForm(idSel,'');
    }
    catch(e) {

         alert(e);

    }

}

function guardarCambiosNominaEmpleado(url){
console.log(url);
var otroPatronTmp=false;
if ($("#otropatronformnomina").val()=="SI")
	otroPatronTmp=true;
if ($("#actualizarNominaEmpleadoForm").valid()){	
	$.ajax({
		sync: true,
		data:{
				"nomina.idNomina":document.getElementById("idnominaformnomina").value,
				"empleado.idEmpleado":$("#idEmpleado").val(),
				"fechaIngreso":$("#fechaingresoformnomina").val(),
				"estatus":$("#estatusformnomina").val(),
				"tipoSalario":$("#tiposalarioformnomina").val(),
				"fechaBaja":$("#fechabajaformnomina").val(),
				"tipoContrato":$("#tipocontratoformnomina").val(),
				"fechaVencimiento":$("#fechavencimientoformnomina").val(),
				"sueldoMensual":$("#sueldomensualformnomina").val(),
				"sueldoDiario":$("#sueldodiarioformnomina").val(),
				"salarioDiarioInt":$("#sueldodiariointformnomina").val(),
				"loteMovImssAlta":$("#loteimssformnomina").val(),
				"plazaTrabajo":$("#plazatrabajoformnomina").val(),
				"numeroTrabajadorCliente":$("#numtrabajadorclienteoformnomina").val(),
				"otroPatron":otroPatronTmp,
				"nombreOtroPatron":$("#nombreotropatronformnomina").val(),
				"rfcOtroPatron":$("#rfcnformnomina").val(),
				"calle":$("#calleformnomina").val(),
				"numExterior":$("#numextformnomina").val(),
				"numInterior":$("#numintformnomina").val(),
				"codigoPostal":$("#cpformnomina").val(),
				"colonia":$("#coloniaformnomina").val(),
				"municipioDel":$("#mundelformnomina").val(),
				"entFederativa":$("#estadoformnomina").val(),
				"suministros":$("#suministrosformnomina").val(),
				
				//"servicios":$("#serviciosformnomina").val()
				"area.idArea":$("#areaformnomina").val(),
				"proceso.idProceso":$("#proceso").val(),
				"departamento.idDepartamento":$("#departamento").val(),
				"puesto.idPuesto":$("#puestosformnomina").val()
		},
		type:  'post',
		url:   url,
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
	  	$( "#progressbar" ).progressbar({
		      value: 75
		    });	
	    $( "#demo" ).hide();
		},
		success:  function (data) {
			mensajeRedireccion("EMPLEADO ACTUALIZADO CORRECTAMENTE.","../empleados/actualizar_empleado.jsp?id="+$("#idEmpleado").val());
		//	mensajeRedireccion("CAMBIOS REALIZADOS CON EXITO");
			console.log(data);
		},
		error:  function (response) {
			console.log(response);
			alert(response);
		}
	});	
  }
	
}

function darBajaNominaEmpleado(){
	if ($("#bajaNominaEmpleadoForm").valid()){	
	if (confirm ("Seguro que desea dar de baja al empleado de la nómina?")){
		$.ajax({
			sync: true,
			data:{
					"nomina.idNomina":document.getElementById("idnominaformnomina").value,
					"empleado.idEmpleado":$("#idEmpleado").val(),
					"fechaBaja":$("#fechabajaTmpformnomina").val(),					
					"loteMovImssBaja":$("#loteimssbajaformnomina").val(),			
					"aplicaFiniquito":$("#aplicafiniquitoformnomina").val(),
					"montoFiniquito":$("#montofiniquitoformnomina").val()
			},
			type:  'post',
			url:    '../../mvc/empleado/bajaempleadonomina',
			dataType:  'json',
			beforeSend: function () {
				$("#resultado").html("Procesando, espere por favor...");
		  	$( "#progressbar" ).progressbar({
			      value: 75
			    });	
		    $( "#demo" ).hide();
			},
			success:  function (data) {
				mensajeRedireccion("EMPLEADO DADO DE BAJA CORRECTAMENTE.","../empleados/actualizar_empleado.jsp?id="+$("#idEmpleado").val());
			//	mensajeRedireccion("CAMBIOS REALIZADOS CON EXITO");
				console.log(data);
			},
			error:  function (response) {
				console.log(response);
				alert(response);
			}
		});			
	}
  }
}


function setFieldsCurp(){
	var curp = $("#curp").val();
	console.log("curp:"+curp);
	//var fechaNac = curp.charAt(8)+curp.charAt(9)+"/"+curp.charAt(6)+curp.charAt(7)+"/19"+curp.charAt(4)+curp.charAt(5); 
	var fechaNac= "19"+curp.charAt(4)+curp.charAt(5)+"-"+curp.charAt(6)+curp.charAt(7)+"-"+curp.charAt(8)+curp.charAt(9); 	
	var fechaNacValidate = "19"+curp.charAt(4)+curp.charAt(5)+"/"+curp.charAt(6)+curp.charAt(7)+"/"+curp.charAt(8)+curp.charAt(9); 	
	var lugarNac = obtenerLugarNacimiento(curp.charAt(11)+curp.charAt(12));
	var edad = obtenerEdad(fechaNacValidate);  
	var sexo = "";
	var rfcTmp=curp.substr(0,10);

	console.log(fechaNac);
	if (curp.charAt(10)=="H")
		sexo="MASCULINO";
	else
		sexo="FEMENINO";
	$("#estado").val(lugarNac);
	$("#fechaNacimiento").val(fechaNac);
	$("#edad").val(edad);
	$("#sexo").val(sexo);
	$("#rfc").val(rfcTmp);

}

function obtenerLugarNacimiento(vals){
	if (vals=="DF")
		return "DISTRITO FEDERAL";
	return "";
}

function obtenerEdad(fechaNac){
	var fecha=fechaNac;
    if(validate_fecha(fecha)==true)
    {
        // Si la fecha es correcta, calculamos la edad
        var values=fecha.split("/");
        var dia = values[2];
        var mes = values[1];
        var ano = values[0];

        // cogemos los valores actuales
        var fecha_hoy = new Date();
        var ahora_ano = fecha_hoy.getYear();
        var ahora_mes = fecha_hoy.getMonth()+1;
        var ahora_dia = fecha_hoy.getDate();
        
        // realizamos el calculo
        var edad = (ahora_ano + 1900) - ano;
        if ( ahora_mes < mes )
        {
            edad--;
        }
        if ((mes == ahora_mes) && (ahora_dia < dia))
        {
            edad--;
        }
        if (edad > 1900)
        {
            edad -= 1900;
        }

        // calculamos los meses
        var meses=0;
        if(ahora_mes>mes)
            meses=ahora_mes-mes;
        if(ahora_mes<mes)
            meses=12-(mes-ahora_mes);
        if(ahora_mes==mes && dia>ahora_dia)
            meses=11;

        // calculamos los dias
        var dias=0;
        if(ahora_dia>dia)
            dias=ahora_dia-dia;
        if(ahora_dia<dia)
        {
            ultimoDiaMes=new Date(ahora_ano, ahora_mes, 0);
            dias=ultimoDiaMes.getDate()-(dia-ahora_dia);
        }
  
    }else{
        alert("La fecha "+fecha+" es incorrecta");
    }	
    return edad;
}

function isValidDate(day,month,year)
{
    var dteDate;
    
    // En javascript, el mes empieza en la posicion 0 y termina en la 11 
    //   siendo 0 el mes de enero
    // Por esta razon, tenemos que restar 1 al mes
    month=month-1;
    // Establecemos un objeto Data con los valore recibidos
    // Los parametros son: año, mes, dia, hora, minuto y segundos
    // getDate(); devuelve el dia como un entero entre 1 y 31
    // getDay(); devuelve un num del 0 al 6 indicando siel dia es lunes,
    //   martes, miercoles ...
    // getHours(); Devuelve la hora
    // getMinutes(); Devuelve los minutos
    // getMonth(); devuelve el mes como un numero de 0 a 11
    // getTime(); Devuelve el tiempo transcurrido en milisegundos desde el 1
    //   de enero de 1970 hasta el momento definido en el objeto date
    // setTime(); Establece una fecha pasandole en milisegundos el valor de esta.
    // getYear(); devuelve el año
    // getFullYear(); devuelve el año
    dteDate=new Date(year,month,day);
    
    //Devuelva true o false...
    return ((day==dteDate.getDate()) && (month==dteDate.getMonth()) && (year==dteDate.getFullYear()));
}
function validate_fecha(fecha)
{
    var patron=new RegExp("^(19|20)+([0-9]{2})([/])([0-9]{1,2})([/])([0-9]{1,2})$");

    if(fecha.search(patron)==0)
    {
        var values=fecha.split("/");
        if(isValidDate(values[2],values[1],values[0]))
        {
            return true;
        }
    }
    return false;
}


//Habilitar finiquito segun ¿APLICA FINIQUITO?
function habilitarExtranjero(){
	if($('#extranjero').prop('checked'))
	{
		// habilitamos
		console.log("ON")
		$("#documentoMigratorio").prop("disabled",false);
		$("#fechaVigenciaDocMig").prop("disabled",false);		
	}else {
		// deshabilitamos
		console.log("Off")
		$("#documentoMigratorio").prop("disabled",true);
		$("#fechaVigenciaDocMig").prop("disabled",true);
	}
}


function habilitaMontoFiniquito(){
    var opcion = $("#aplicafiniquitoformnomina").val();
    if(opcion == 'NO') 
    	$('#montofiniquitoformnomina').attr("disabled", true);    
    else  $("#montofiniquitoformnomina").attr("disabled",false);
}

function habilitarInfonavit()
{
	if($('#datosInfonavit').prop('checked'))
	{
		// habilitamos
		console.log("ON")
		$("#numCredito").prop("disabled",false);
		$("#descuentoVsmg").prop("disabled",false);
		$("#descuento").prop("disabled",false);
		$("#importe").prop("disabled",false);
	}else {
		// deshabilitamos
		console.log("Off")
		$("#numCredito").prop("disabled",true);
		$("#descuentoVsmg").prop("disabled",true);
		$("#descuento").prop("disabled",true);
		$("#importe").prop("disabled",true);
	}
}
function habilitarFonacot()
{	
	if($('#fonacot').prop('checked'))
	{
		// habilitamos
		console.log("ON")
		$("#numPagos").prop("disabled",false);
		$("#importeFonacot").prop("disabled",false);
	}else {
		// deshabilitamos
		console.log("Off")
		$("#numPagos").prop("disabled",true);
		$("#importeFonacot").prop("disabled",true);
	
	}
}
function habilitarPensionAlim()
{	
	if($('#pensionAlimenticia').prop('checked'))
	{
		// habilitamos
		console.log("ON")	
		$("#importeAlimenticio").prop("disabled",false);
		$("#porcentajeAlimenticio").prop("disabled",false);
		$("#nombreAcreedor").prop("disabled",false);
		$("#observaciones").prop("disabled",false);
		
	}else {
		// deshabilitamos
		console.log("Off")
		$("#importeAlimenticio").prop("disabled",true);
		$("#porcentajeAlimenticio").prop("disabled",true);
		$("#nombreAcreedor").prop("disabled",true);
		$("#observaciones").prop("disabled",true);
		
	}
}

function colocarAvisoFechaVencimiento(fechaInicio, fechaVencimiento){
	console.log(fechaInicio.substring(0,4)+"/"+fechaInicio.substring(5,7)+"/"+fechaInicio.substring(8,10))
	console.log(fechaVencimiento.substring(0,4)+"/"+fechaVencimiento.substring(5,7)+"/"+fechaVencimiento.substring(8,10))
	//        0123-56-78
	//formato 2016-02-01	
	if (fechaInicio=="")
		return false;
	if (fechaVencimiento==""){
		return false;
	}	
	var f1 = new Date(fechaInicio.substring(0,4), fechaInicio.substring(5,7), fechaInicio.substring(8,10));
	var f2 = new Date(fechaVencimiento.substring(0,4), fechaVencimiento.substring(5,7), fechaVencimiento.substring(8,10));
	f1.setHours(0,0,0,0);
	f2.setHours(0,0,0,0);
	if (f1.getTime() == f2.getTime()){
		$("#fechavencimientoformnomina").attr('title','CONTRATO INDEFINIDO');
	    //alert("Son la misma fecha");
	}
}