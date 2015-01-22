var indexOpt=1;

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


//*****************************************************************
//Function que Agrega y Quita Domicilios Virtuales, del SelectMult*
//*****************************************************************
function agregarDomVirtual(){
	var x = document.getElementById("selectMult");
	var option = document.createElement("option");
	option.id=indexOpt++;
	option.text = $("#domicilio").val();
	x.add(option);
}		
function quitarDomVirtual(){
	var id=$("#selectMult").find('option:selected').attr("id");
	$("#selectMult").find("option[id='"+id+"']").remove();  
}		

//*******************************************************
//Function que Agrega y Quita Accionistas del SelectMult*
//*******************************************************
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


//*******************************************************
//Function que genera el json de los Domicilios Virtuales*
//*******************************************************
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


//***********************************************
//Function que genera el json de los Accionistas*
//***********************************************
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
					"jsonString": getDomVirtuales(),
					"jsonString": getAccionistas(),
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



