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
			//setData(response);
		}
	});
		$("#divGrupos").dialog();
	}
function guardarRazonSocial() {
	console.log ($("#nombreRazonSocial").val());
		$
			.ajax({
				data : {
					"nombreRazonSocial" : $("#nombreRazonSocial").val(),
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
				url : '../../mvc/razonsocial/guardarrazonsocial',
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

