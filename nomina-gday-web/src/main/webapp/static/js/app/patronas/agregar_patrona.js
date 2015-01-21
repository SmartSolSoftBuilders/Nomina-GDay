//*******************************************************************************
//Function que obtiene los datos de la BD que se agregan a los combos del SELECT*
//*******************************************************************************
$(document).ready(function() {
	$.ajax({
		sync:true,
		dataType:'json',
		url:   '../../mvc/patrona/getdatoscombo',
		type:  'post',		
		beforeSend: function () {	
		},
		success:  function (response) {
			console.log (response[0]);
			var options = "";
			var result=response[0];
			 for (var i = 0; i < result.length; i++) {
			    	options += '<option value="' + result[i].idTipoRegimen + '">' + result[i].tipoRegimen +'</option>';
			    }
			$("#tipoReg").append(options)
			console.log ("TipoRegimen");
			console.log (response[1]);	

		}	
	});
});


//******************************************************
//Function que guarda los datos de la Patrona en la BD *
//******************************************************
function guardarPatrona() {
		$
			.ajax({
				data : {
					"nombreCortoPatrona" : $("#nombrePatrona").val(),
					"razonSocialPatrona" : $("#razonSocial").val(),
					"rfcPatrona" : $("#rfc").val(),
					"folioMercantilPatrona" : $("#folioMerc").val(),
					"esIntermediariaPatrona" : $("#intermediaria").val(),
					"tipoRegimenPatrona" : $("#tipoReg").val(),
					"calleFiscalPatrona" : $("#calle").val(),
					"coloniaFiscalPatrona" : $("#colonia").val(),
					"numExteriorFiscalPatrona" : $("#numExt").val(),
					"numInteriorFiscalPatrona" : $("#numInt").val(),
					"cpFiscalPatrona" : $("#cp").val(),
					"municipioFiscalPatrona" : $("#municipio").val(),
					"estadoFiscalPatrona" : $("#entidadFed").val(),
					"fiscalNumPagoPatrona" : $("#nombreCorto").val(),
					"telContactoPatrona" : $("#telContacto").val(),
					"actaNumeroPatrona" : $("#numActaConst").val(),
					"actaNotariaPatrona" : $("#numNotaria").val(),
					"actaFechaPatrona" : $("#fecha").val(),
					"actaNotarioPatrona" : $("#notario").val(),
					"actaCiudadPatrona" : $("#ciudad").val(),
					"actaEstadoPatrona" : $("#estado").val(),
				},
				
				dataType : 'json',
				url : '../../mvc/patrona/guardarpatrona',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {
					$("#resultadoGuardar").html(alert("Patrona creada correctamente"));
					console.log("response")
					console.log($("#telContacto").val());
				},
				error : function(response) {
					$("#resultadoGuardar").html();
				}
			});
		}
