//*******************************************************************************
//Function que obtiene los datos de la BD que se agregan a los combos del SELECT
//*******************************************************************************
$(document).ready(function() {
	//Sección validaciones
	 $("#agregarNominaForm").validate({
        rules: {
        	nombreNomina: "required",
        	patrona: "required",
        	intermediaria: "required",
        	porcPrimaVacacional: {"required":true,"number": true},
        	registroPatronal: "required",
        	fechaContrato: "required",   
        	selectMult:{

                    required: function () {
                        if ($("#selectMult").val()=="") {
                            return false;
                        } else {
                            return true;
                        }
                    }
                
            }
        	//selectMult: "required"
            /*email: {
                required: true,
                email: true
            },*/
        },        
        messages: {
        	nombreNomina: "Ingrese el nombre de la N&oacute;mina",
        	patrona:"Ingrese el nombre de la Patrona",
        	intermediaria:"Ingrese el nombre de la Intermediaria",
        	porcPrimaVacacional:"Ingrese un porcentaje Vacacional (solo numeros)",
        	registroPatronal:"Ingrese un registro Patronal",
        	fechaContrato:"Ingrese una Fecha",
        	
        },
        
        submitHandler: function(form) {
            form.submit();
        }
    });

	$.ajax({
		sync:true,
		dataType:'json',
		url:   '../../mvc/nomina/getdatoscombo',
		type:  'post',		
		beforeSend: function () {	
		},
		success:  function (response) {
			console.log (response[0]);
			console.log ("Ejecutivo");
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
			
				var options = "";
				var result=response[2];
				 for (var i = 0; i < result.length; i++) {
				    	options += '<option value="' + result[i].idCalendario + '">' + result[i].siglas +'</option>';
				    }
		    $("#tipoCalendario").append(options)
		    
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
function obtenerIdsAgregadosRZ2(){
	var retArr=new Array(2);
	var ids="";
	var ids2="";
	var coma="";
	$("#selectMult option").each(function()
			{
			console.log("VALOR"+$(this).attr("id"));
			var porcentaje=document.getElementById("porcentaje"+$(this).attr("id")).value;
			ids=ids+coma+$(this).attr("id")+":"+porcentaje;				
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
	$("#idPatrona").val(id);
	$("#divSeleccionPatrona").dialog("close");
}
function seleccionarPatronaIntermediaria(id,nombre){
	$("#intermediaria").val(nombre);
	$("#idIntermediaria").val(id);
	$("#divSeleccionPatronaIntermediaria").dialog("close");
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
function showPatronasIntermediarias(){
	oTablePatronasIntermediarias=$('#tablaPatronasIntermediarias').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/patrona/getpatronasintermediarias',
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
			oTablePatronasIntermediarias.fnClearTable();
			oTablePatronasIntermediarias.fnAddData(response);
		}
	});	
	$("#divSeleccionPatronaIntermediaria").dialog(({show: "slide", modal: true, width:900, height:600,
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
	var ids=obtenerIdsAgregadosRZ2();
	console.log("tipoCalendario");
	console.log($("#tipoCalendario").val());
	if ($("#agregarNominaForm").valid()){		
		$
			.ajax({
				data : {
					"nombreCorto" : $("#nombreNomina").val(),
					"razonSocial" : $("#razonSocial").val(),
					"patrona.idPatrona" : $("#idPatrona").val(),
					"intermediaria.idPatrona" : $("#idIntermediaria").val(),
					"ejecutivo.idEjecutivo" : $("#ejecutivo").val(),
					"esquema.idEsquema" : $("#esquema").val(),
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
					"tipoCalendario.idCalendario" : $("#tipoCalendario").val(),
					"facturaSubsidio" : $("#factSub").val(),
					"reconoceAntiguedad" : $("#reconoceAntihuedad").val(),
					"fechaContrato" : $("#fechaContrato").val(),
					"jsonValue" : ids[0]
					},
				
				dataType : 'json',
				url : '../../mvc/nomina/guardarnomina',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {
					mensajeRedireccion("Nomina agregada correctamente.","../nominas/nominas.jsp");
				},
				error : function(response) {
					$("#resultadoGuardar").html();
				}
			});
	}
}



function cancelar(){
	top.frames['main'].location="../hojas_trabajo/nominas.jsp"; 	
}

function showEditarPatrona(idPatrona){
	top.frames['main'].location="../patronas/actualizar_patrona.jsp?id="+idPatrona; 
}

function guardarPatrona(){
	top.frames['main'].location="../patronas/agregar_patrona.jsp"; 	
}