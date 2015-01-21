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
	//manda el parametro idNomina y llama a la function obtenerNomina()
	var idPatrona=getParameter("id");
	console.log("PATRONAS!")
	console.log(idPatrona);
	obtenerPatrona(idPatrona);
	
    	
});

//*******************************************************************************
//Function que obtiene la nomina por idNomina y llama a la function 
//muestraDatos()
//*******************************************************************************
function obtenerPatrona(idPatrona){
	$.ajax({
		data: {
			"idPatrona" : idPatrona
	},
	dataType:'json',
	url:   '../../mvc/patrona/obtenerpatronabyid',
	type:  'post',		
	beforeSend: function () {	
	},
	success:  function (response) {
		muestraDatosPatrona(response);	
		},	
	error: function (response) {																	
		$("#resultadoGuardar").html("Error");
		console.log(response)

		}		
	});
	
};

//*******************************************************************************
//Function que obtiene los datos registrados de la Patrona para modificarlos 
//*******************************************************************************
function muestraDatosPatrona(datos){
	var data=eval(datos);
	$("#idPatrona").val(data.idPatrona);
	$("#nombrePatrona").val(data.nombreCortoPatrona);
	$("#razonSocial").val(data.razonSocialPatrona);
	$("#rfc").val(data.rfcPatrona);
	$("#folioMerc").val(data.folioMercantilPatrona);
	if (data.esIntermediariaPatrona){
		
		$("#intermediaria").attr("checked",true);
	}
	$("#calle").val(data.calleFiscalPatrona);
	$("#colonia").val(data.coloniaFiscalPatrona);
	$("#numExt").val(data.numExteriorFiscalPatrona);
	$("#numInt").val(data.numInteriorFiscalPatrona);
	$("#cp").val(data.cpFiscalPatrona);
	$("#municipio").val(data.municipioFiscalPatrona);
	$("#entidadFed").val(data.estadoFiscalPatrona);
	$("#telContacto").val(data.telContactoPatrona);
	$("#numActaConst").val(data.actaNumeroPatrona);
	$("#numNotaria").val(data.actaNotariaPatrona);
	$("#fecha").val(data.actaFechaPatrona);
	$("#notario").val(data.actaNotarioPatrona);
	$("#ciudad").val(data.actaCiudadPatrona);
	$("#estado").val(data.actaEstadoPatrona);
}



//*******************************************************************************
//Function que actualiza la Nomina con los datos modificados 
//*******************************************************************************
function actualizarPatrona() {
			$
			.ajax({
				data : {
					"idPatrona" : $("#idPatrona").val(),
					"nombreCortoPatrona" : $("#nombrePatrona").val(),
					"razonSocialPatrona" : $("#razonSocial").val(),
					"rfcPatrona" : $("#rfc").val(),
					"folioMercantilPatrona" : $("#folioMerc").val(),
					"esIntermediariaPatrona" : $("#intermediaria").val(),
					"calleFiscalPatrona" : $("#calle").val(),
					"coloniaFiscalPatrona" : $("#colonia").val(),
					"numExteriorFiscalPatrona" : $("#numExt").val(),
					"numInteriorFiscalPatrona" : $("#numInt").val(),
					"cpFiscalPatrona" : $("#cp").val(),
					"municipioFiscalPatrona" : $("#municipio").val(),
					"estadoFiscalPatrona" : $("#entidadFed").val(),
					"telContactoPatrona" : $("#telContacto").val(),
					"actaNumeroPatrona" : $("#numActaConst").val(),
					"actaNotariaPatrona" : $("#numNotaria").val(),
					"actaFechaPatrona" : $("#fecha").val(),
					"actaNotarioPatrona" : $("#notario").val(),
					"actaCiudadPatrona" : $("#ciudad").val(),
					"actaEstadoPatrona" : $("#estado").val(),
				},
				
				dataType : 'json',
				url : '../../mvc/patrona/modificapatrona',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {
					console.log("Actualizando");
					console.log(response);
					$("#resultadoGuardar")
							.html(alert("Patrona actualizada orrectamente"));
				},
				error : function(response) {
					console.log(response);
					$("#resultadoGuardar").html();
				}
			});
		}

