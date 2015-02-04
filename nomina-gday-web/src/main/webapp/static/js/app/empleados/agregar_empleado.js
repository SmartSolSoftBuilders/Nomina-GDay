var nominasAsignadas = new Array();

function guardarEmpleado() {	
		$
			.ajax({
				data : {
					"noControl" : $("#numeroControl").val(),
					"nss" : $("#nss").val(),
					"curp" : $("#curp").val(),
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
				sync: true,
				dataType : 'json',
				url : '../../mvc/empleado/guardarempleado',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {
					//guardarNominasEmpleado();
					//mensajeRedireccion("EMPLEADO CREADO CORRECTAMENTE.","../empleados/empleados.jsp");
					mensaje("EMPLEADO CREADO CORRECTAMENTE.");
				},
				error : function(response) {
					$("#resultadoGuardar").html();
				}
			});
}

function cancelar(){
	top.frames['main'].location="../empleados/empleados.jsp"; 	
}

function guardarNominasEmpleado(){
	console.log("Nominas a guardar:");
	console.log(nominasAsignadas);
	for (var i=0; i<nominasAsignadas.length; i++){
		
	}
	
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
}

function hideNominaForm(){
	$("#tablaFormNominas").dialog("close");	
	$("#divSeleccionNominaParaEmpleado").dialog("open");	
}

function closeAllModal(){
	$("#tablaFormNominas").dialog("close");	
	$("#divSeleccionNominaParaEmpleado").dialog("close");	
}

function agregarObjetoJS(){
	var nominaAsignada=new Array();
	//Asignamos cada valor del formulario de nomina-empleado
	nominaAsignada.push($("#idnominaformnomina").val());
	nominaAsignada.push($("#estatusformnomina").val());
	nominaAsignada.push($("#fechaingresoformnomina").val());
	nominaAsignada.push($("#estatusformnomina").val());
	nominaAsignada.push($("#tiposalarioformnomina").val());
	nominaAsignada.push($("#fechabajaformnomina").val());
	nominaAsignada.push($("#tipocontratoformnomina").val());
	nominaAsignada.push($("#fechavencimientoformnomina").val());
	nominaAsignada.push($("#sueldomensualformnomina").val());
	nominaAsignada.push($("#sueldodiarioformnomina").val());
	nominaAsignada.push($("#sueldodiariointformnomina").val());
	nominaAsignada.push($("#loteimssformnomina").val());
	nominaAsignada.push($("#plazatrabajoformnomina").val());
	nominaAsignada.push($("#numtrabajadorclienteoformnomina").val());
	nominaAsignada.push($("#otropatronformnomina").val());
	nominaAsignada.push($("#nombreotropatronformnomina").val());
	nominaAsignada.push($("#rfcnformnomina").val());
	nominaAsignada.push($("#calleformnomina").val());
	nominaAsignada.push($("#numextformnomina").val());
	nominaAsignada.push($("#numintformnomina").val());
	nominaAsignada.push($("#cpformnomina").val());
	nominaAsignada.push($("#coloniaformnomina").val());
	nominaAsignada.push($("#mundelformnomina").val());
	nominaAsignada.push($("#estadoformnomina").val());
	nominaAsignada.push($("#suministrosformnomina").val());
	nominaAsignada.push($("#actividadesformnomina").val());
	nominaAsignada.push($("#puestosformnomina").val());
	nominaAsignada.push($("#serviciosformnomina").val());
	nominaAsignada.push($("#areaformnomina").val());
	nominasAsignadas.push(nominaAsignada);
	console.log("Arreglo NOMINAS ASIGNADAS");
	console.log(nominasAsignadas);
    var nomina = document.getElementById("nombrenominaformnomina").value;
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
    element1.id=nomina;    
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
	closeAllModal();
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
