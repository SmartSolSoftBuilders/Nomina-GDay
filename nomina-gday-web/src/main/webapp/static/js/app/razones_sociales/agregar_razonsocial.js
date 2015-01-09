function seleccionarGrupo (id,txt){
	$("#grupo").val(txt);
	$("#grupoIdSel").val(id);
	$("#grupo").val().prop( "disabled", false);
	$("#nombreRazonSocial").prop( "disabled", false);
	$("#rfc").prop( "disabled", false);
	$("#nombreCorto").prop( "disabled", false);
	$("#codCliente").prop( "disabled", false);					
	$("#grupo").prop( "disabled", false);
	$("#comision").prop( "disabled", false);
	$("#objetoSocial").prop( "disabled", false);
	$("#actaConst").prop( "disabled", false);					
	$("#fechaActaConst").prop( "disabled", false);					
	$("#fechaIniOper").prop( "disabled", false);					
	$("#aPaterno").prop( "disabled", false);					
	$("#aMaterno").prop( "disabled", false);					
	$("#nombres").prop( "disabled", false);					
	$("#calle").prop( "disabled", false);					
	$("#numeroExt").prop( "disabled", false);					
	$("#numeroInt").prop( "disabled", false);
	$("#colonia").prop( "disabled", false);	
	$("#codPostal").prop( "disabled", false);					
	$("#municipio").prop( "disabled", false);					
	$("#estado").prop( "disabled", false);					
	$("#nombreContUno").prop( "disabled", false);
	$("#telefonoContUno").prop( "disabled", false);
	$("#correoContUno").prop( "disabled", false);
	$("#nombreContDos").prop( "disabled", false);
	$("#telefonoContDos").prop( "disabled", false);
	$("#correoContDos").prop( "disabled", false);
	$("#nombreContTres").prop( "disabled", false);
	$("#telefonoContTres").prop( "disabled", false);
	$("#correoContTres").prop( "disabled", false);	
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
		url:   'mvc/grupo/getgrupos',
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
		$("#divGrupos").dialog();
		$("#grupo").prop( "disabled", true);
		$("#nombreRazonSocial").prop( "disabled", true);
		$("#rfc").prop( "disabled", true);
		$("#nombreCorto").prop( "disabled", true);
		$("#codCliente").prop( "disabled", true);					
		$("#grupo").prop( "disabled", true);
		$("#comision").prop( "disabled", true);
		$("#objetoSocial").prop( "disabled", true);
		$("#actaConst").prop( "disabled", true);					
		$("#fechaActaConst").prop( "disabled", true);					
		$("#fechaIniOper").prop( "disabled", true);					
		$("#aPaterno").prop( "disabled", true);					
		$("#aMaterno").prop( "disabled", true);					
		$("#nombres").prop( "disabled", true);					
		$("#calle").prop( "disabled", true);					
		$("#numeroExt").prop( "disabled", true);					
		$("#numeroInt").prop( "disabled", true);
		$("#colonia").prop( "disabled", true);	
		$("#codPostal").prop( "disabled", true);					
		$("#municipio").prop( "disabled", true);					
		$("#estado").prop( "disabled", true);					
		$("#nombreContUno").prop( "disabled", true);
		$("#telefonoContUno").prop( "disabled", true);
		$("#correoContUno").prop( "disabled", true);
		$("#nombreContDos").prop( "disabled", true);
		$("#telefonoContDos").prop( "disabled", true);
		$("#correoContDos").prop( "disabled", true);
		$("#nombreContTres").prop( "disabled", true);
		$("#telefonoContTres").prop( "disabled", true);
		$("#correoContTres").prop( "disabled", true);

	}
function guardarRazonSocial() {
	console.log ($("#nombreRazonSocial").val());
		$
			.ajax({
				data : {
					"nombreRazonSocial" : $("#nombreRazonSocial").val(),
					"rfc" : $("#rfc").val(),
					"nombreCortoRazonS" : $("#nombreCorto").val(),
					"codCliente" : $("#codCliente").val(),					
					"grupo.idGrupo" : $("#grupo").val(),
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
					"contactoUnoNombre" : $("#nombreContUno").val(),
					"contactoUnoTelefono" : $("#telefonoContUno").val(),
					"contactoUnoCorreo" : $("#correoContUno").val(),
					"contactoDosNombre" : $("#nombreContDos").val(),
					"contactoDosTelefono" : $("#telefonoContDos").val(),
					"contactoDosCorreo" : $("#correoContDos").val(),
					"contactoTresNombre" : $("#nombreContTres").val(),
					"contactoTresTelefono" : $("#telefonoContTres").val(),
					"contactoTresCorreo" : $("#correoContTres").val(),
				},
				
				dataType : 'json',
				url : 'mvc/razonsocial/guardarrazonsocial',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {
					$("#resultadoGuardar")
							.html(alert("La cotizaci\u00f3n se guard\u00f3 correctamente"));
				},
				error : function(response) {
					$("#resultadoGuardar").html();
				}
			});
		}

