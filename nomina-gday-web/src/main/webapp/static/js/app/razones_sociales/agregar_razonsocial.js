var indexOpt=1;
$( document ).ready(function() {
 
    // Setup form validation on the #register-form element
    $("#agregarRazonSocialForm").validate({    
        // Specify the validation rules
        rules: {
        	nombreRazonSocial: {"required":true,"maxlength": 120},
        	rfc:  {"required":true,"maxlength": 13},
           	nombreCorto:  {"required":true,"maxlength": 100},
        	codCliente:  {"required":true,"maxlength": 20},
        	grupo:  {"required":true},
        	referenciante:  {"required":true},
        	comision: "required",
        	selectMult: "required",
        	objetoSocial:  {"required":true,"maxlength": 256},
        	actaConst:  {"required":true},
        	fechaActaConst:  {"required":true},
        	fechaIniOper:  {"required":true},
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
        	regPublicoPropiedad: "required",
        	fechaRegPublicoPropiedad: "required",
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
        	referenciante: "Ingrese por lo menos un referenciante",
        	comision: "Ingrese una comision",
        	selectMult: "Seleccione el grupo",
        	objetoSocial: "Campo requerido, m&aacute;ximo valor:256",
        	actaConst: "Campo requerido",
        	fechaActaConst: "Ingrese una fecha de Acta Constitutiva",
        	fechaIniOper: "Ingrese una Fecha de Inicio de Operaci&oacute;n",
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
        	regPublicoPropiedad: "Ingrese el registro p&uacute;blico de la propiedad",
        	fechaRegPublicoPropiedad: "Ingrese una fecha de registro p&uacute;blico de la propiedad",
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

function seleccionarGrupo (id,txt){
	$("#grupo").val(txt);
	$("#grupoIdSel").val(id);
	$("#divGrupos").dialog("close");
}

function agregarReferenciante(){
	var x = document.getElementById("selectMult");
	var option = document.createElement("option");
	option.id=indexOpt++;
	option.text = $("#referenciante").val();
	x.add(option);
}		
function quitarReferenciante(){
	var id=$("#selectMult").find('option:selected').attr("id");
	$("#selectMult").find("option[id='"+id+"']").remove();  
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
			//setData(response);
		}
	});
	$("#divGrupos").dialog(({show: "slide", modal: true, width:700, height:600,
		autoOpen: true}));
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
function guardarRazonSocial() {
	if ($("#agregarRazonSocialForm").valid()){
	console.log ("OK"+$("#nombreRazonSocial").val());
		$
			.ajax({
				data : {
					"nombreRazonSocial" : $("#nombreRazonSocial").val(),
					"nombreCortoRazonS" : $("#nombreCorto").val(),
					"rfc" : $("#rfc").val(),
					"codCliente" : $("#codCliente").val(),
					"grupo.idGrupo" : $("#grupoIdSel").val(),
					"comision" : $("#comision").val(),
					"objetoSocial" : $("#objetoSocial").val(),
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
					"regPublicoPropiedad" : $("#regPublicoPropiedad").val(),					
					"fechaRegPublicoPropiedad" : $("#fechaRegPublicoPropiedad").val(),					
					"contactoUnoNombre" : $("#nombreContUno").val(),
					"contactoUnoTelefono" : $("#telefonoContUno").val(),
					"contactoUnoCorreo" : $("#correoContUno").val(),
					"contactoDosNombre" : $("#nombreContDos").val(),
					"contactoDosTelefono" : $("#telefonoContDos").val(),
					"contactoDosCorreo" : $("#correoContDos").val(),
					"contactoTresNombre" : $("#nombreContTres").val(),
					"contactoTresTelefono" : $("#telefonoContTres").val(),
					"contactoTresCorreo" : $("#correoContTres").val(),
					"jsonString": getReferenciantes(),
				},
				
				dataType : 'json',
				url : '../../mvc/razonsocial/guardarrazonsocial',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {
					mensajeRedireccion("RAZON SOCIAL CREADA CORRECTAMENTE","../razones_sociales/razones_sociales.jsp");
				},
				error : function(response) {
					mensaje("IMPOSIBLE GUARDAR LA RAZON SOCIAL. CONTACTE CON EL ADMINISTRADOR.");
				}
			});
		}

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
		mensaje('INGRESE UN RFC CON FORMATO: XXXX000000X00');
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
	
