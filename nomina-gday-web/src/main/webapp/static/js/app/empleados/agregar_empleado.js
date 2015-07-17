var nominasAsignadas = new Array();


//Valida los elementos del Formulario
$(document).ready(function() {
	$("#agregarEmpleadoForm").validate({

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
			descuentoVsmg : {"number":true},
			descuento : {"number":true},
			importe : {"number":true},
			numPagos : {"number":true},
			importeFonacot : {"number":true},
			importeAlimenticio : {"number":true},
			porcentajeAlimenticio : {"number":true}				
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
			importeFonacot : "Ingrese el Importe de Fonacot, solo n&uacute;meros",
			importeAlimenticio : "Ingrese el Importe Alimenticio, solo n&uacute;meros",
			porcentajeAlimenticio : "Ingrese el porcentaje Alimenticio, solo n&uacute;meros",					
		},
		
		submitHandler: function(form) {
			form.submit();
		}
	});
	
	$("#agregarNominaEmpleadoForm").validate({
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
			$("#area").append(options)
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
			$("#puestos").append(options)
			console.log ("puestos");				

		}	
	
	});
});//Cierra la validacion del formulario





function guardarEmpleado() {	
	if ($("#agregarEmpleadoForm").valid()){	

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
					guardarNominasEmpleado(response);					
				},
				error : function(response) {
					$("#resultadoGuardar").html();
				}
			});
	}
}

function cancelar(){
	top.frames['main'].location="../empleados/empleados.jsp"; 	
}

function guardarNominasEmpleado(idEmpleado){
	console.log("EMPLEADO GUARDADO:"+idEmpleado);
	console.log("Nominas a guardar:");
	console.log(nominasAsignadas);
	for (var i=0; i<nominasAsignadas.length; i++){

		$.ajax({
			data : {
				"nomina.idNomina":nominasAsignadas[i][0],
				"empleado.idEmpleado":idEmpleado,
				"fechaIngreso":nominasAsignadas[i][1],
				"estatus":nominasAsignadas[i][2],
				"tipoSalario":nominasAsignadas[i][3],
				"fechaBaja":nominasAsignadas[i][4],
				"loteMovImssAlta":nominasAsignadas[i][5],
				"fechaVencimiento":nominasAsignadas[i][6],
				"sueldoMensual":nominasAsignadas[i][7],
				"sueldoDiario":nominasAsignadas[i][8],
				"sueldoDiarioInt":nominasAsignadas[i][9],
				"loteMovImssAlta":nominasAsignadas[i][10],
				"plazaTrabajo":nominasAsignadas[i][11],
				"numeroTrabajadorCliente":nominasAsignadas[i][12],
				"otroPatron":nominasAsignadas[i][13],
				"nombreOtroPatron":nominasAsignadas[i][14],
				"rfcOtroPatron":nominasAsignadas[i][15],
				"calle":nominasAsignadas[i][16],
				"numExterior":nominasAsignadas[i][17],
				"numInterior":nominasAsignadas[i][18],
				"codigoPostal":nominasAsignadas[i][19],
				"colonia":nominasAsignadas[i][20],
				"municipioDel":nominasAsignadas[i][21],
				"entFederativa":nominasAsignadas[i][22],
				"suministros":nominasAsignadas[i][23],
				"actividades":nominasAsignadas[i][24],
				"area.idArea":1,
				"proceso.idProceso":1,
				"departamento.idDepartamento":1,
				"puesto.idPuesto":1							
				},
			sync: true,
			dataType : 'json',
			url : '../../mvc/empleado/guardarempleadonomina',
			type : 'post',
			beforeSend : function() {
			},
			success : function(response) {
				console.log("EMPLEADO CREADO CORRECTAMENTE.");
			},
			error : function(response) {
				$("#resultadoGuardar").html();
			}
		});
	}
	mensajeRedireccion("EMPLEADO CREADO CORRECTAMENTE.","../empleados/empleados.jsp");

	//mensaje("EMPLEADO CREADO CORRECTAMENTE.");
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
			$("#area").append(options)
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
			$("#puestos").append(options)
			console.log ("puestos");		
		$("#tablaFormNominas").dialog(({show: "slide",  					stack: false,
			draggable: false,resizable: false,modal: true, width:960, height:900,
					autoOpen: true}));	
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

function agregarObjetoJS(){
	if ($("#agregarNominaEmpleadoForm").valid()){	
	var nominaAsignada=new Array();
	//Asignamos cada valor del formulario de nomina-empleado
	nominaAsignada.push($("#idnominaformnomina").val());	
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
        if ( ahora_mes < mes ){
            edad--;
        }
        if ((mes == ahora_mes) && (ahora_dia < dia)){
            edad--;
        }
        if (edad > 1900){
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

//Habilitar elementos por checkbox

function habilitarInfonavit()
{
	console.log($("#datosInfonavit").val())
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
	console.log($("#fonacot").val())
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
	console.log($("#pensionAlimenticia").val())
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
