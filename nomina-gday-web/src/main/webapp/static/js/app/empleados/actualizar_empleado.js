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
			numeroControl: "required",
			nss : "required",
			curp : "required",
			paterno : "required",
			materno : "required",
			nombre : "required",
			rfc :  "required",
			fechaNacimiento : "required",
			edad : "required",
			sexo : "required",
			nacionalidad : "required",
			correoElectronico : "required",
			fechaIngreso : "required",
			calle : "required",
			numExt : "required",
			numInt : "required",
			colonia : "required",
			codPostal : "required",
			municipioDel : "required",
			entFederativa : "required",
			numCuenta : "required",
			numCredito : "required",
			descuentoVsmg : "required",
			descuento : "required",
			importe : "required",
			numPagos : "required",
			importeFonacot : "required",
			importeAlimenticio : "required",
			porcentajeAlimenticio : "required",
			nombreAcreedor : "required",
			observaciones : "required",		
		},        
		messages: {
			numeroControl: "Ingrese el No.Control",
			nss : "Ingrese el NSS",
			curp : "Ingrese el CURP",
			paterno : "Ingrese el Apellido Paterno",
			materno : "Ingrese el Apellido Materno",
			nombre : "Ingrese el Nombre del Empleado",
			rfc :  "Ingrese el RFC",
			fechaNacimiento : "Seleccione una Fecha de Nacimiento",
			edad : "Ingrese la Edad",
			sexo : "Ingrese el sexo del Empleado",
			nacionalidad : "Ingrese la Nacionalidad",
			correoElectronico : "Ingrese el Correo Electronico",
			fechaIngreso : "Ingrese la Fecha de Ingreso",
			calle : "Ingrese una calle",
			numExt : "Ingrese un No.Exterior",
			numInt : "Ingrese un No.Interior",
			colonia : "Ingrese una Colonia",
			codPostal : "Ingrese un Codigo Postal",
			municipioDel : "Ingrese un Municipio",
			entFederativa : "Ingrese un Estado",
			numCuenta : "Ingrese un No.Cuenta",
			numCredito : "Ingrese un No.Credito",
			descuentoVsmg : "Ingrese el Descuento",
			descuento : "Ingrese un porcentaje",
			importe : "Ingrese un Importe",
			numPagos : "Ingrese el No.Pagos",
			importeFonacot : "Ingrese el Importe de Fonacot",
			importeAlimenticio : "Ingrese el Importe Alimenticio",
			porcentajeAlimenticio : "Ingrese el porcentaje Alimenticio",
			nombreAcreedor : "Ingrese el nombre del Acreedor",
			observaciones : "Ingrese observaciones",			
		},
		
		submitHandler: function(form) {
			form.submit();
		}
	});
	
	$("#actualizarNominaEmpleadoForm").validate({
		rules: {
			fechaingresoformnomina: "required",
			fechaNacimiento : "required",
			sueldomensualformnomina : "required",
			sueldodiarioformnomina : "required",
			sueldodiariointformnomina : "required",
			numtrabajadorclienteoformnomina : "required",
			nombreotropatronformnomina : "required",
			rfcnformnomina : "required",
			calleformnomina:"required",
			numextformnomina : "required",
			numintformnomina : "required",
			cpformnomina : "required",
			coloniaformnomina : "required",
			mundelformnomina : "required",
			suministrosformnomina : "required",
			actividadesformnomina : "required",
			puestosformnomina : "required",
			serviciosformnomina : "required",
			tiposalarioformnomina : "required",
			areaformnomina : "required",		
		},        
		messages: {
			fechaingresoformnomina: "Ingrese una fecha de Ingreso",
			sueldomensualformnomina : "Ingrese el sueldo Mensual",
			sueldodiarioformnomina : "Ingrese el sueldo Diario",
			sueldodiariointformnomina : "Ingrese el Sueldo Diario Integrado",
			numtrabajadorclienteoformnomina : "Ingrese un Numero de Trabajador Cliente",
			nombreotropatronformnomina : "Ingrese el nombre de otro patron",
			rfcnformnomina : "Ingrese el RFC",
			calleformnomina : "Ingrese el nombre de la Calle",
			numextformnomina : "Ingrese el numero Exterior",
			numintformnomina : "Ingrese el numero Interior",
			cpformnomina : "Ingrese el Codigo Postel",
			coloniaformnomina : "Ingrese la Colonia",
			mundelformnomina : "Ingrese el Municipio",
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
	obtenerNominasAsignadasAEmpleado(data.idEmpleado);
}


//****************************************************
//Function que actualiza todos los datos del Empleado*
//****************************************************
function actualizarEmpleado() {
	console.log($("#idEmpleado").val());
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
					"fechaNacimiento":$("#fechaNacimiento").val(),
					"edad":$("#edad").val(),
					"sexo":$("#sexo").val(),
					"paisOrigen":$("#paisOrigen").val(),
					"nacionalidad":$("#nacionalidad").val(),
					"estadoCivil":$("#estadoCivil").val(),
					"correoElectronico":$("#correoElectronico").val(),
					"fechaIngresoReal":$("#fechaIngreso").val(),
					"listaNegra":$("#listaNegra").val(),
					"calle":$("#calle").val(),
					"numExterior":$("#numExt").val(),
					"numInterior":$("#numInt").val(),
					"colonia":$("#colonia").val(),
					"codigoPostal":$("#codPostal").val(),
					"municipioDel":$("#municipioDel").val(),
					"entFederativa":$("#estado").val(),
					"docIfe":$("#indentificacionOficial").val(),
					"docActNan":$("#actaNacimiento").val(),
					"docCurp":$("#curpDoc").val(),
					"docRfc":$("#rfcDoc").val(),
					"docComprobante":$("#comprobanteDom").val(),
					"docCompEst":$("#comprobanteEst").val(),
					"docCorreo":$("#correoElec").val(),
					"docClabe":$("#cuentaClave").val(),
					"docPreafiliacion":$("#preafiliacionImss").val(),
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
	$("#tablaFormNominas").dialog(({show: "slide",  					stack: false,
		draggable: false,resizable: false,modal: true, width:960, height:900,
		autoOpen: true}));
	$("#buttonAgregar").show();
	$("#buttonGuardar").hide();
}

function showEditarNominaForm(idNomina,nombre){
	document.getElementById("idnominaformnomina").value=idNomina;
	document.getElementById("nombrenominaformnomina").value=nombre;
	$("#tablaFormNominas").dialog(({show: "slide",  					stack: false,
		draggable: false,resizable: false,modal: true, width:960, height:900,
		autoOpen: true}));
	$.ajax({
		sync: true,
		data:{
			"nomina.idNomina":idNomina,
			"empleado.idEmpleado":$("#idEmpleado").val()
		},
		type:  'post',
		url:   '../../mvc/empleado/getnominasempbyid',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
	  	$( "#progressbar" ).progressbar({
		      value: 75
		    });	
	    $( "#demo" ).hide();
		},
		success:  function (data) {
			console.log(data);
			$("#fechaingresoformnomina").val(data.fechaIngreso);
			$("#estatusformnomina").val(data.estatus);
			$("#tiposalarioformnomina").val(data.tipoSalario);
			$("#fechabajaformnomina").val(data.fechaBaja);
			$("#tipocontratoformnomina").val(data.loteMovImssAlta);
			$("#fechavencimientoformnomina").val(data.fechaVencimiento);
			$("#sueldomensualformnomina").val(data.sueldoMensual);
			$("#sueldodiarioformnomina").val(data.sueldoDiario);
			$("#sueldodiariointformnomina").val(data.sueldoDiarioInt);
			$("#loteimssformnomina").val(data.loteMovImssAlta);
			$("#plazatrabajoformnomina").val(data.plazaTrabajo);
			$("#numtrabajadorclienteoformnomina").val(data.numeroTrabajadorCliente);
			$("#otropatronformnomina").val(data.otroPatron);
			$("#nombreotropatronformnomina").val(data.nombreOtroPatron);
			$("#rfcnformnomina").val(data.rfcOtroPatron);
			$("#calleformnomina").val(data.calle);
			$("#numextformnomina").val(data.numExterior);
			$("#numintformnomina").val(data.numInterior);
			$("#cpformnomina").val(data.codigoPostal);
			$("#coloniaformnomina").val(data.colonia);
			$("#mundelformnomina").val(data.municipioDel);
			$("#estadoformnomina").val(data.entFederativa);
			$("#suministrosformnomina").val(data.suministros);
			$("#actividadesformnomina").val(data.actividades);
			$("#puestosformnomina").val(data.puestos);
			$("#serviciosformnomina").val(data.servicios);
			//$("#areaformnomina").val(data.area.idArea);
			$("#buttonAgregar").hide();
			$("#buttonGuardar").show();
		},
		error:  function (response) {
			console.log(response);
			alert(response);
		}
	});			

}

function shoBajaNominaForm(){
	$("#tablaBajaFormNominas").dialog(({show: "slide", stack: false,
		draggable: false,resizable: false,modal: true, width:960, height:900,
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
				"sueldoDiarioInt":$("#sueldodiariointformnomina").val(),
				"loteMovImssAlta":$("#loteimssformnomina").val(),
				"plazaTrabajo":$("#plazatrabajoformnomina").val(),
				"numeroTrabajadorCliente":$("#numtrabajadorclienteoformnomina").val(),
				"otroPatron":$("#otropatronformnomina").val(),
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
				"actividades":$("#actividadesformnomina").val(),
				"puestos":$("#puestosformnomina").val(),
				"servicios":$("#serviciosformnomina").val()
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
			mensajeRedireccion("EMPLEADO CREADO CORRECTAMENTE.","../empleados/actualizar_empleado.jsp?id="+$("#idEmpleado").val());
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
	console.log(fechaNac);
	if (curp.charAt(10)=="H")
		sexo="MASCULINO";
	else
		sexo="FEMENINO";
	$("#estado").val(lugarNac);
	$("#fechaNacimiento").val(fechaNac);
	$("#edad").val(edad);
	$("#sexo").val(sexo);
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

function habilitaMontoFiniquito(){
    var opcion = $("#aplicafiniquitoformnomina").val();
    if(opcion == 'NO') 
    	$('#montofiniquitoformnomina').attr("disabled", true);    
    else  $("#montofiniquitoformnomina").attr("disabled",false);
}