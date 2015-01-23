var indexOpt=1;

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
	
	for (i=0;i<data.domVirtuales.length;i++){
		console.log(data.domVirtuales[i].domVirtual);
		var x = document.getElementById("selectMult");
		var option = document.createElement("option");
		option.id = (i+1);
		option.text = data.domVirtuales[i].domVirtual;
		x.add(option); 
	}
	
	for (i=0;i<data.accionistas.length;i++){
		console.log(data.accionistas[i].nombreAccionista);
		var x = document.getElementById("selectMultAccionista");
		var option = document.createElement("option");
		option.id = (i+1);
		option.text = data.accionistas[i].nombreAccionista;
		x.add(option); 
	}

	for (i=0;i<data.representantesLegalesPleitosCobranzas.length;i++){
		console.log(data.representantesLegalesPleitosCobranzas[i].nombreRepLegPleiCob);
		var x = document.getElementById("selectMultRepresentantes");
		var option = document.createElement("option");
		option.id = (i+1);
		option.text = data.representantesLegalesPleitosCobranzas[i].nombreRepLegPleiCob;
		x.add(option); 
	}

	for (i=0;i<data.representantesLegalesLaborales.length;i++){
		console.log(data.representantesLegalesLaborales[i].nombreRepLegLab);
		var x = document.getElementById("selectMultRepresentantesLegLab");
		var option = document.createElement("option");
		option.id = (i+1);
		option.text = data.representantesLegalesLaborales[i].nombreRepLegLab;
		x.add(option); 
	}
	
	
}

//Armar el json de DomVirtuales
function getDomVirtuales(){
		var jsonString ="{\"domVirtuales\":[";
		var renglonJson="";
		var index=0;
		$('select#selectMult').find('option').each(function() {
			console.log($(this));
			console.log($(this).val());
			console.log($(this)[0].innerHTML);
			var txt=$(this).text(); var id=$(this).attr('value');
			renglonJson=renglonJson+"{ \"idDomVirtual\":"+(index++)+", \"domVirtual\": \""+txt+"\" }";
			jsonString=jsonString+renglonJson;
			renglonJson=",";

		});
		jsonString=jsonString+"]}";
		console.log("JSON STRING");
		console.log(jsonString);
		
		return jsonString;
	}
	function quitarDomVirtual(){
		var id=$("#selectMult").find('option:selected').attr("id");
		$("#selectMult").find("option[id='"+id+"']").remove();  
}
	
function agregarDomVirtual(){
		var x = document.getElementById("selectMult");
		var option = document.createElement("option");
		option.text = $("#domicilio").val();
		x.add(option);
}

//Armar el json de Accionista
function getAccionistas(){
	var jsonString ="{\"accionistas\":[";
	var renglonJson="";
	var index=0;
	$('select#selectMultAccionista').find('option').each(function() {
		console.log($(this));
		console.log($(this).val());
		console.log($(this)[0].innerHTML);
		var txt=$(this).text(); var id=$(this).attr('value');
		renglonJson=renglonJson+"{ \"idAccionista\":"+(index++)+", \"nombreAccionista\": \""+txt+"\" }";
		jsonString=jsonString+renglonJson;
		renglonJson=",";

	});
	jsonString=jsonString+"]}";
	console.log("JSON STRING");
	console.log(jsonString);
	
	return jsonString;
}

function agregarAccionista(){
	var x = document.getElementById("selectMultAccionista");
	var option = document.createElement("option");
	option.id=indexOpt++;
	option.text = $("#nombreAccionista").val();
	x.add(option);
}		
function quitarAccionista(){
	var id=$("#selectMultAccionista").find('option:selected').attr("id");
	$("#selectMultAccionista").find("option[id='"+id+"']").remove();  
}

//Armar el json de REPRESENTANTES LEGALES PLEITOS Y COBRANZAS
function getRepresentantesLegalesPleitosCobranzas(){
	var jsonString ="{\"representantesLegalesPleitosCobranzas\":[";
	var renglonJson="";
	var index=0;
	$('select#selectMultRepresentantes').find('option').each(function() {
		console.log($(this));
		console.log($(this).val());
		console.log($(this)[0].innerHTML);
		var txt=$(this).text(); var id=$(this).attr('value');
		renglonJson=renglonJson+"{ \"idRepLegPleiCob\":"+(index++)+", \"nombreRepLegPleiCob\": \""+txt+"\" }";
		jsonString=jsonString+renglonJson;
		renglonJson=",";

	});
	jsonString=jsonString+"]}";
	console.log("JSON STRING");
	console.log(jsonString);
	
	return jsonString;
}

function agregarRepresentantes(){
	var x = document.getElementById("selectMultRepresentantes");
	var option = document.createElement("option");
	option.id=indexOpt++;
	option.text = $("#nombreRepresentantes").val();
	x.add(option);
}		
function quitarRepresentantes(){
	var id=$("#selectMultRepresentantes").find('option:selected').attr("id");
	$("#selectMultRepresentantes").find("option[id='"+id+"']").remove();  
}

//Armar el json de REPRESENTANTES LEGALES LABORALES
function getRepresentantesLegalesLaborales(){
	var jsonString ="{\"representantesLegalesLaborales\":[";
	var renglonJson="";
	var index=0;
	$('select#selectMultRepresentantesLegLab').find('option').each(function() {
		console.log($(this));
		console.log($(this).val());
		console.log($(this)[0].innerHTML);
		var txt=$(this).text(); var id=$(this).attr('value');
		renglonJson=renglonJson+"{ \"idRepLegLab\":"+(index++)+", \"nombreRepLegLab\": \""+txt+"\" }";
		jsonString=jsonString+renglonJson;
		renglonJson=",";

	});
	jsonString=jsonString+"]}";
	console.log("JSON STRING");
	console.log(jsonString);
	
	return jsonString;
}

function agregarRepresentantesLegLab(){
	var x = document.getElementById("selectMultRepresentantesLegLab");
	var option = document.createElement("option");
	option.id=indexOpt++;
	option.text = $("#nombreRepresentantesLegLab").val();
	x.add(option);
}		
function quitarRepresentantesLegLab(){
	var id=$("#selectMultRepresentantesLegLab").find('option:selected').attr("id");
	$("#selectMultRepresentantesLegLab").find("option[id='"+id+"']").remove();  
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
/*					"tipoRegimenPatrona" : $("#tipoReg").val(),*/
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
					"jsonStringDomicilio": getDomVirtuales(),
					"jsonStringAccionistas": getAccionistas(),
					"jsonStringRepresentantesPleitos": getRepresentantesLegalesPleitosCobranzas(),
					"jsonStringRepresentantesLegales": getRepresentantesLegalesLaborales()

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

