//*******************************************************************************
//Function que obtiene los datos de la BD que se agregan a los combos del SELECT
//*******************************************************************************
$(document).ready(function() {
	$.ajax({
		sync:true,
		dataType:'json',
		url:   '../../mvc/nomina/getdatoscombo',
		type:  'post',		
		beforeSend: function () {	
		},
		success:  function (response) {
			console.log (response[0]);
			var options = "";
			var result=response[0];
			 for (var i = 0; i < result.length; i++) {
			    	options += '<option value="' + result[i].idEjecutivo + '">' + result[i].nombreEjecutivo + ' '+ result[i].paternoEjecutivo + ' '+ result[i].maternoEjecutivo +'</option>';
			    }
			 $("#ejecutivo").append(options)
			console.log ("Esquema");
			console.log (response[1]);
				var options = "";
				var result=response[1];
				 for (var i = 0; i < result.length; i++) {
				    	options += '<option value="' + result[i].idEsquema + '">' + result[i].nombreEsquema +'</option>';
				    }
				 $("#esquema").append(options)
				
			},	
		error: function (response) {																	
			$("#resultadoGuardar").html("Error");
			}		
	});		
	
	
});

//*******************************************************************************
//Function que guarda todos los datos de la Nomina
//*******************************************************************************
var sumaPorcentaje=0;

function obtenerPMaximo(){
	return 100-sumaPorcentaje;
}
function obtenerIdsAgregadosRZ(){
	var retArr=new Array(2);
	var ids="";
	var ids2="";
	var coma="";
	$("#selectMult option").each(function()
			{
			console.log("VALOR"+$(this).attr("id"));
			ids=ids+coma+$(this).attr("id");		
			var porcentaje=document.getElementById("porcentaje"+$(this).attr("id")).value;
			ids2=ids2+coma+porcentaje;
			coma=","
			});
	console.log(ids);
	console.log(ids2);

	retArr[0]=ids;
	retArr[1]=ids2;
	return retArr;
}
function seleccionarPatrona(id,nombre){
	$("#patrona").val(nombre);
	$("#idPatrona").val(nombre);
	$("#divSeleccionPatrona").dialog("close");
}
function showPatronas(){
	oTablePatronas=$('#tablaPatronas').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/patrona/getpatronas',
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
			oTablePatronas.fnClearTable();
			oTablePatronas.fnAddData(response);
		}
	});	
	$("#divSeleccionPatrona").dialog(({show: "slide", modal: true, width:900, height:600,
		autoOpen: true}));
}
function showRazonesSociales(){
	if (sumaPorcentaje<100){
	oTableRZ=$('#tablaRazonesSociales').dataTable();
	var ids=obtenerIdsAgregadosRZ();
	$.ajax({
		sync: true,
		data: {porcentaje:obtenerPMaximo(),id:ids[0],id2:ids[1]}, 
		type:  'post',
		url:   '../../mvc/razonsocial/getrazonessociales_nomina',
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
			oTableRZ.fnClearTable();
			oTableRZ.fnAddData(response);
		}
	});	
	$("#divSeleccionRazonSocial").dialog(({show: "slide", modal: true, width:900, height:600,
		autoOpen: true}));
	}
	else{
		alert("Se ha alcanzado el máximo de porcentajes!");
	}
}
function agregarRZ(id,nombre){
	var porcentaje=document.getElementById("porcentaje"+id).value;
	if ((parseInt(sumaPorcentaje)+parseInt(porcentaje))>100){
		alert("La suma de porcentajes de Razones Sociales es mayor que 100");
	}
	else{
		$("#divSeleccionRazonSocial").dialog("close");
	var x = document.getElementById("selectMult");
	var option = document.createElement("option");
	option.id=id;
	option.text = nombre+"----"+porcentaje+"%";
	x.add(option);	
	console.log("Agregar RZ-Nomina");
	var porcentaje=document.getElementById("porcentaje"+id).value;
	sumaPorcentaje=parseInt(sumaPorcentaje)+parseInt(porcentaje);
	var nombrePrcTxt="#porcentaje"+id;
	console.log($(nombrePrcTxt).val());
	console.log("SUMA:"+sumaPorcentaje)
	}
}

function quitarRazonSocial(){	
	var id=$("#selectMult").find('option:selected').attr("id");
	var porcentaje=document.getElementById("porcentaje"+id).value;
	console.log(sumaPorcentaje);
	console.log(porcentaje);
	$("#selectMult").find("option[id='"+id+"']").remove();	
	sumaPorcentaje=parseInt(sumaPorcentaje)-parseInt(porcentaje);
}

function guardarNomina() {
		$
			.ajax({
				data : {
					"nombreCorto" : $("#nombreNomina").val(),
					"razonSocial" : $("#razonSocial").val(),
					"patrona.nombreCorto" : $("#patrona").val(),
					"ejecutivo.nombreEjecutivo" : $("#ejecutivo").val(),
					"esquema.nombreEsquema" : $("#esquema").val(),
					"provisionAguinaldo" : $("#provisionAguinaldo").val(),
					"provisionVacaciones" : $("#provisionVacaciones").val(),
					"provisionPrimaVacacional" : $("#provisionPrimaVac").val(),
					"porcPrimaVacacional" : $("#porcPrimaVacacional").val(),
					"fondoAhorro" : $("#fondoDeAhorro").val(),
					"ivaExento" : $("#ivaExcento").val(),
					"comisionCostSocial" : $("#comisionCostoSocial").val(),
					"tipoPago" : $("#tipoPago").val(),
					"claseRiesgo" : $("#claseRiesgo").val(),
					"registroPatronal" : $("#registroPatronal").val(),
					"periodicidad" : $("#periodicidad").val(),
					"tipoCalendario.tipoCalendario" : $("#tipoCalendario").val(),
					"facturaSubsidio" : $("#factSub").val(),
					"reconoceAntiguedad" : $("#reconoceAntihuedad").val(),
					"fechaContrato" : $("#fechaContrato").val(),
					},
				
				dataType : 'json',
				url : '../../mvc/nomina/guardarnomina',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {
					$("#resultadoGuardar")
							.html(alert("La nomina se guard\u00f3 correctamente"));
				},
				error : function(response) {
					$("#resultadoGuardar").html();
				}
			});
		}