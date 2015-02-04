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
		agregarObjetoJS();
	}
}
function agregarObjetoJS(){
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
    element2.value="ACTIVO";
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

function guardarCambiosNominaEmpleado(){
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
		url:   '../../mvc/empleado/guardareditarempleadonomina',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
	  	$( "#progressbar" ).progressbar({
		      value: 75
		    });	
	    $( "#demo" ).hide();
		},
		success:  function (data) {
			mensaje("CAMBIOS REALIZADOS CON EXITO");
			console.log(data);
		},
		error:  function (response) {
			console.log(response);
			alert(response);
		}
	});				
}