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

$(document).ready(function() {
	var idRazonSocial=getParameter("id");
	console.log(idRazonSocial);
	obtenerRazonSocial(idRazonSocial);
    // Setup form validation on the #register-form element
    $("#editarRazonSocialForm").validate({
    
        // Specify the validation rules
        rules: {
        	nombreRazonSocial: "required",
        	rfc: "required",
        	nombreCorto: "required",
        	codCliente: "required",
        	grupo: "required",
        	selectMult: "required",
        	comision: "required",
        	selectMult: "required",
        	objetoSocial: "required",
        	actaConst: "required",
        	fechaActaConst: "required",
        	fechaIniOper: "required",
        	aPaterno: "required",
        	aMaterno: "required",
        	nombres: "required",
        	calle: "required",
        	numeroExt: "required",
        	numeroInt: "required",
        	colonia: "required",
        	codPostal: "required",
        	municipio: "required",
        	estado: "required",
        	regPublicoPropiedad: "required",
        	fechaRegPublicoPropiedad: "required",
        	nombreContUno: "required",
        	correoContUno: "required",
        	telefonoContUno: "required",
        	nombreContDos: "required",
        	telefonoContDos: "required",
        	correoContDos: "required",
        },
        
        // Specify the validation error messages
        messages: {
        	nombreRazonSocial: "Ingrese el nombre de la Raz&oacute;n Social",
        	rfc: "Ingrese el rfc",
        	nombreCorto: "Ingrese el nombre corto de la Raz&oacute;n Social",
        	codCliente: "Ingrese el c&oacute;digo del cliente",
        	grupo: "Ingrese el grupo",
        	comision: "Ingrese una comision",
        	selectMult: "Ingrese por lo menos un referenciante",
        	objetoSocial: "Ingrese un Objeto Social",
        	actaConst: "Ingrese un Acta Constitutiva",
        	fechaActaConst: "Ingrese una fecha de Acta Constitutiva",
        	fechaIniOper: "Ingrese una Fecha de Inicio de Operaci&oacute;n",
        	aPaterno: "Ingrese el Apellido Paterno del Representante Legal",
        	aMaterno: "Ingrese el Apellido Materno del Representante Legal",
        	nombres: "Ingrese el Nombre del Representante Legal",
        	calle: "Ingrese el nombre de la Calle del Representante Legal",
        	numeroExt: "Ingrese el n&uacute; exterior del Representante Legal",
        	numeroInt: "Ingrese el n&uacute; interior del Representante Legal",
        	colonia: "Ingrese la colonia del Representante Legal",
        	codPostal: "Ingrese el c&oacute;digo postal del Representante Legal",
        	municipio: "Ingrese el municipio del Representante Legal",
        	estado: "Ingrese el estado del Representante Legal",
        	regPublicoPropiedad: "Ingrese el registro p&uacute;blico de la propiedad",
        	fechaRegPublicoPropiedad: "Ingrese una fecha de registro p&uacute;blico de la propiedad",
        	nombreContUno: "Ingrese el nombre del Contacto",
        	correoContUno: "Ingrese el correo del Contacto",
        	telefonoContUno: "Ingrese el telefono del Contacto",
        	nombreContDos: "Ingrese el nombre del Contacto",
        	telefonoContDos: "Ingrese el telefono del Contacto",
        	correoContDos: "Ingrese el correo del Contacto",
        },
        
        submitHandler: function(form) {
            form.submit();
        }
    });

	
});

function obtenerRazonSocial(idRazonSocial){
	console.log ("Obtener Razon Social por id"+ idRazonSocial);
	$.ajax({
		data: {
			"idRazonSocial" : idRazonSocial
	},
	dataType:'json',
	url:   '../../mvc/razonsocial/obtenerrazonsocialbyid',
	type:  'post',		
	beforeSend: function () {	
	},
	success:  function (response) {
		muestraDatosRazonSocial(response);	
		console.log ("success");
		console.log (response);
		},	
	error: function (response) {																	
		$("#resultadoGuardar").html("Error");
		}		
	});		
	
	//$("#divGrupos").dialog({close: function(event, ui) { window.location.reload(); }});
}

function muestraDatosRazonSocial(datos){
	console.log ("success");
	console.log (datos);
	var data=eval(datos);
	$("#razonSocialIdSel").val(data.idRazonSocial);
	$("#nombreRazonSocial").val(data.nombreRazonSocial);
	$("#rfc").val(data.rfc);
	$("#nombreCorto").val(data.nombreCortoRazonS);
	$("#codCliente").val(data.codCliente);
	$("#grupo").val(data.grupo.nombre);
	$("#grupoIdSel").val(data.grupo.idGrupo);
	$("#comision").val(data.comision);
	$("#actaConst").val(data.actConstitutiva);
	$("#fechaActaConst").val(data.fechaActConstitutiva);
	$("#fechaIniOper").val(data.fechaInicioOperacion);
	$("#aPaterno").val(data.paternoRepresentante);
	$("#aMaterno").val(data.maternoRepresentante);
	$("#nombres").val(data.nombresRepresentante);
	$("#calle").val(data.calleFiscal);
	$("#numeroExt").val(data.numExteriorFiscal);
	$("#numeroInt").val(data.numInteriorFiscal);
	$("#colonia").val(data.coloniaFiscal);
	$("#codPostal").val(data.cpFiscal);
	$("#municipio").val(data.municipioFiscal);
	$("#estado").val(data.estadoFiscal);
	$("#nombreContUno").val(data.contactoUnoNombre);
	$("#telefonoContUno").val(data.contactoUnoTelefono);
	$("#correoContUno").val(data.contactoUnoCorreo);
	$("#nombreContDos").val(data.contactoDosNombre);
	$("#telefonoContDos").val(data.contactoDosTelefono);
	$("#correoContDos").val(data.contactoDosCorreo);
	$("#nombreContTres").val(data.contactoTresNombre);
	$("#telefonoContTres").val(data.contactoTresTelefono);
	$("#correoContTres").val(data.contactoTresCorreo);
	$("#objetoSocial").val(data.objetoSocial);
	$("#regPublicoPropiedad").val(data.regPublicoPropiedad);
	$("#fechaRegPublicoPropiedad").val(data.fechaRegPublicoPropiedad);
	console.log(data.referenciantes);
	for (i=0;i<data.referenciantes.length;i++){
		console.log(data.referenciantes[i].nombreReferenciante);
		var x = document.getElementById("selectMult");
		var option = document.createElement("option");
		option.id = (i+1);
		option.text = data.referenciantes[i].nombreReferenciante;
		x.add(option);  
	}

}
function getReferenciantes(){
	var jsonString ="{\"referenciantes\":[";
	var renglonJson="";
	var index=0;
	$('select#selectMult').find('option').each(function() {
		console.log($(this));
		console.log($(this).val());
		console.log($(this)[0].innerHTML);
		var txt=$(this).text(); var id=$(this).attr('value');
		renglonJson=renglonJson+"{ \"idReferenciante\":"+(index++)+", \"nombreReferenciante\": \""+txt+"\" }";
		jsonString=jsonString+renglonJson;
		renglonJson=",";

	});
	jsonString=jsonString+"]}";
	console.log("JSON STRING");
	console.log(jsonString);
	
	return jsonString;
}
function quitarReferenciante(){
	var id=$("#selectMult").find('option:selected').attr("id");
	$("#selectMult").find("option[id='"+id+"']").remove();  
}		

function actualizarRazonSocial() {
	if ($("#editarRazonSocialForm").valid()){
			$
			.ajax({
				data : {
					"idRazonSocial" : $("#razonSocialIdSel").val(),
					"grupo.idGrupo" : $("#grupoIdSel").val(),
					"nombreRazonSocial" : $("#nombreRazonSocial").val(),
					"rfc" : $("#rfc").val(),
					"nombreCortoRazonS" : $("#nombreCorto").val(),
					"codCliente" : $("#codCliente").val(),
					"comision" : $("#comision").val(),
					"actConstitutiva" : $("#actaConst").val(),
					"fechaActConstitutiva" : $("#fechaActaConst").val(),
					"fechaInicioOperacion" : $("#fechaIniOper").val(),
					"paternoRepresentante" : $("#aPaterno").val(),
					"maternoRepresentante" : $("#aMaterno").val(),
					"nombresRepresentante" : $("#nombres").val(),
					"calleFiscal" : $("#calle").val(),
					"numExteriorFiscal" : $("#numeroExt").val(),
					"numInteriorFiscal" : $("#numeroInt").val(),
					"coloniaFiscal" : $("#colonia").val(),
					"cpFiscal" : $("#codPostal").val(),
					"municipioFiscal" : $("#municipio").val(),
					"estadoFiscal" : $("#estado").val(),
					"contactoUnoNombre" : $("#nombreContUno").val(),
					"contactoUnoTelefono" : $("#telefonoContUno").val(),
					"contactoUnoCorreo" : $("#correoContUno").val(),
					"contactoDosNombre" : $("#nombreContDos").val(),
					"contactoDosTelefono" : $("#telefonoContDos").val(),
					"contactoDosCorreo" : $("#correoContDos").val(),
					"contactoTresNombre" : $("#nombreContTres").val(),
					"contactoTresTelefono" : $("#telefonoContTres").val(),
					"contactoTresCorreo" : $("#correoContTres").val(),
					"objetoSocial" : $("#objetoSocial").val(),					
					"jsonString": getReferenciantes()
				
				},
				
				dataType : 'json',
				url : '../../mvc/razonsocial/modificarazonsocial',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {				
					/*$("#resultadoGuardar")
							.html(alert("La actualizaci\u00f3n de Raz\u00f3n Social se realiz\u00f3 correctamente"));
					top.frames['main'].location="../razones_sociales/razones_sociales.jsp";*/
					mensajeRedireccion("RAZON SOCIAL ACTUALIZADA CORRECTAMENTE.","../razones_sociales/razones_sociales.jsp");


				},
				error : function(response) {
					mensaje("IMPOSIBLE ACTUALIZAR LA RAZON SOCIAL. CONTACTE CON EL ADMINISTRADOR.");

				}
			});
	}
}

function seleccionarGrupo (id,txt){
	$("#grupo").val(txt);
	$("#grupoIdSel").val(id);
}

function agregarReferenciante(){
	var x = document.getElementById("selectMult");
	var option = document.createElement("option");
	option.text = $("#referenciante").val();
	x.add(option);
}		


function showGrupos(){	
	oTableGrupos=$('#tablaGrupo').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/grupo/getgrupos',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
      	$( "#progressbar" ).progressbar({
		      value: 75
		    });	
        $( "#demo" ).hide();
		},
		success:  function (response) {
			$("#demo").show();
			$("#progressbar").hide();
			$('#tablaGrupo').dataTable().fnAddData(response);
		}
	});
		$("#divGrupos").dialog();
	}


function validaRfc(rfc) {
	var strCorrecta;
	strCorrecta = rfc;	
	if (rfc.length == 12){
	var valid = '^(([A-Z]|[a-z]){3})([0-9]{6})((([A-Z]|[a-z]|[0-9]){3}))';
	}else{
	var valid = '^(([A-Z]|[a-z]|\s){1})(([A-Z]|[a-z]){3})([0-9]{6})((([A-Z]|[a-z]|[0-9]){3}))';
	}
	var validRfc=new RegExp(valid);
	var matchArray=strCorrecta.match(validRfc);
	if (matchArray==null) {
		alert('INGRESE UN RFC CON FORMATO: XXXX000000X00');

		return false;
	}
	else
	{
		return true;
	}
	
	
}


function cancelar(){
	top.frames['main'].location="../razones_sociales/razones_sociales.jsp"; 	
}
	
