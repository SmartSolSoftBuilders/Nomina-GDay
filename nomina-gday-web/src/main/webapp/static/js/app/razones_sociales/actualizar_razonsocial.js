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
            /*email: {
                required: true,
                email: true
            },*/
        },
        
        // Specify the validation error messages
        messages: {
            nombreRazonSocial: "Ingrese el nombre de la Razón Social",
            rfc:"Ingrese el campo RFC"
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
	$("#grupo").val(data.grupo.idGrupo);
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
					console.log("Actualizando");
					console.log(response);
					$("#resultadoGuardar")
							.html(alert("La actualizaci\u00f3n de Raz\u00f3n Social se realiz\u00f3 correctamente"));
				},
				error : function(response) {
					$("#resultadoGuardar").html();
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

function cancelar(){
	top.frames['main'].location="../razones_sociales/razones_sociales.jsp"; 	
}
	
