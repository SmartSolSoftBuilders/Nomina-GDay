var idRazonSocial=0;
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
	idRazonSocial=getParameter("id");
	console.log(idRazonSocial);
	obtenerRazonSocial(idRazonSocial);
    // Setup form validation on the #register-form element
    $("#editarRazonSocialForm").validate({
    
        // Specify the validation rules
    	rules: {
        	nombreRazonSocial: {"required":true,"maxlength": 120},
        	rfc:  {"required":true,"maxlength": 13},
           	nombreCorto:  {"required":true,"maxlength": 100},
        	codCliente:  {"required":true,"maxlength": 20},
        	grupo:  {"required":true},
        	selectMult:  {"required":true},
        	comision: "required",
        	selectMult: "required",
        	objetoSocial:  {"required":true,"maxlength": 256},
        	actaConst:  {"required":true},
        	fechaActaConst:  {"required":true,"date": true},
        	fechaIniOper:  {"required":true,"date": true},
        	aPaterno:  {"required":true,"maxlength": 25},
        	aMaterno:  {"required":true,"maxlength": 25},
        	nombres:  {"required":true,"maxlength": 60},
        	calle:  {"required":true,"maxlength": 60},
        	numeroExt:  {"required":true,"maxlength": 20},
        	numeroInt:  {"required":true,"maxlength": 20},
        	colonia:  {"required":true,"maxlength": 60},
        	codPostal:  {"required":true},
        	municipio:  {"required":true,"maxlength": 80},
        	estado:  {"required":true,"maxlength": 20},
        	//regPublicoPropiedad: "required",
        	fechaRegPublicoPropiedad: {"required":true,"date": true},
        	nombreContUno:  {"required":true,"maxlength": 100},
        	correoContUno:  {"required":true,"maxlength": 60},
        	telefonoContUno:  {"required":true,"maxlength": 30},
        	nombreContDos:  {"required":true,"maxlength": 100},
        	telefonoContDos:  {"required":true,"maxlength": 30},
        	correoContDos:  {"required":true,"maxlength": 60}        	         
        },
        
        // Specify the validation error messages
        messages: {
        	nombreRazonSocial: "Campo requerido, m&aacute;ximo valor:120",
        	rfc: "Ingrese un rfc con formato XXXX000000X00",
        	nombreCorto: "Campo requerido, m&aacute;ximo valor:100",
        	codCliente: "Campo requerido, m&aacute;ximo valor:20",
        	grupo: "Ingrese el grupo",
        	//referenciante: "Ingrese por lo menos un referenciante",
        	comision: "Ingrese una comision",
        	selectMult: "Ingrese el referenciante",
        	objetoSocial: "Campo requerido, m&aacute;ximo valor:256",
        	actaConst: "Campo requerido",
        	fechaActaConst: "Ingrese una fecha de Acta Constitutiva en el formato correcto",
        	fechaIniOper: "Ingrese una Fecha de Inicio de Operaci&oacute;n en el formato correcto",
        	aPaterno: "Campo requerido, m&aacute;ximo valor:25",
        	aMaterno: "Campo requerido, m&aacute;ximo valor:25",
        	nombres: "Campo requerido, m&aacute;ximo valor:60",
        	calle: "Campo requerido, m&aacute;ximo valor:60",
        	numeroExt: "Campo requerido, m&aacute;ximo valor:20",
        	numeroInt: "Campo requerido, m&aacute;ximo valor:20",
        	colonia: "Campo requerido, m&aacute;ximo valor:60",
        	codPostal: "Campo requerido",
        	municipio: "Campo requerido, m&aacute;ximo valor:80",
        	estado: "Campo requerido, m&aacute;ximo valor:20",
        	//regPublicoPropiedad: "Ingrese el registro p&uacute;blico de la propiedad",
        	//fechaRegPublicoPropiedad: "Ingrese una fecha de registro p&uacute;blico de la propiedad",
        	nombreContUno: "Campo requerido, m&aacute;ximo valor:100",
        	correoContUno: "Campo requerido, m&aacute;ximo valor:60",
        	telefonoContUno: "Campo requerido, m&aacute;ximo valor:30",
        	nombreContDos: "Campo requerido, m&aacute;ximo valor:100",
        	telefonoContDos: "Campo requerido, m&aacute;ximo valor:60",
        	correoContDos: "Campo requerido, m&aacute;ximo valor:30"        	
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
	console.log("EDITANDO")
	console.log("EDIT:"+$("#razonSocialIdSel").val())
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
					"fechaRegPublicoPropiedad" : $("#fechaRegPublicoPropiedad").val(),
					"regPublicoPropiedad" : $("#regPublicoPropiedad").val(),
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
	
