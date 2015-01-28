var indexOpt=1;
$( document ).ready(function() {
 
    // Setup form validation on the #register-form element
    $("#agregarRazonSocialForm").validate({
    
        // Specify the validation rules
        rules: {
        	nombreRazonSocial: "required",
        	rfc: "required",
        	nombreCorto: "required",
        	codCliente: "required",
        	grupo: "required",
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
        	nombreRazonSocial: "Ingrese el nombre de la Raz&oacute; Social",
        	rfc: "Ingrese el rfc",
        	nombreCorto: "Ingrese el nombre corto de la Raz&oacute;n Social",
        	codCliente: "Ingrese el c&oacute;digo del cliente",
        	grupo: "Ingrese el grupo",
        	comision: "Ingrese una comision",
        	selectMult: "Seleccione el grupo",
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
					$("#resultadoGuardar")
							.html(alert("La cotizaci\u00f3n se guard\u00f3 correctamente"));
					top.frames['main'].location="../razones_sociales/razones_sociales.jsp";

				},
				error : function(response) {
					$("#resultadoGuardar").html();
				}
			});
		}

	}	

function cancelar(){
	top.frames['main'].location="../razones_sociales/razones_sociales.jsp"; 	
}
	
