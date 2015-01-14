function seleccionarGrupo (id,txt){
	$("#grupo").val(txt);
	$("#grupoIdSel").val(id);
	$("#divGrupos").dialog("close");
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
	$("#divGrupos").dialog(({show: "slide", modal: true, width:700, height:600,
		autoOpen: true}));
	}
function getReferenciantes(){
	var jsonString ="{\"referenciantes\":[";
	var renglonJson="";
	$('select#selectMult').find('option').each(function() {
		console.log($(this));
		console.log($(this).val());
		console.log($(this)[0].innerHTML);
		var txt=$(this).text(); var id=$(this).attr('value');
		renglonJson=renglonJson+"{ \"idReferenciante\":"+id+", \"nombreReferenciante\": \""+txt+"\" }";
		jsonString=jsonString+renglonJson;
		renglonJson=",";

	});
	jsonString=jsonString+"]}";
	console.log("JSON STRING");
	console.log(jsonString);
	
	return jsonString;
}
function guardarRazonSocial() {
	console.log ("OK"+$("#nombreRazonSocial").val());
 //
	
//	console.log(JSON.stringify(referenciantesTmp)); 
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
					console.log("response");
					console.log(response);
					$("#resultadoGuardar")
							.html(alert("La cotizaci\u00f3n se guard\u00f3 correctamente"));
				},
				error : function(response) {
					console.log("response");
					console.log(response);
					$("#resultadoGuardar").html();
				}
			});
		}


		
		