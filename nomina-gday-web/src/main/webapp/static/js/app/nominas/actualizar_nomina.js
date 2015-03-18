//*******************************************************************************
//Obtener el idNomina por parametros en la url, que se manda desde el controller
//*******************************************************************************
var sumaPorcentaje=0;

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

//*******************************************************************************
//Function que obtiene los datos de la BD que se agregan a los combos del SELECT
//*******************************************************************************
$(document).ready(function() {
	//Sección validaciones
    $("#actualizarNominaForm").validate({
    	rules: {
    		nombreNomina: "required",
        	patrona: "required",
        	intermediaria: "required",
        	porcPrimaVacacional: "required",
        	registroPatronal: "required",
        	fechaContrato: "required",
        	selectMult: "required",
        },         
        messages: {
        	nombreNomina: "Ingrese el nombre de la N&oacute;mina",
        	patrona:"Ingrese el nombre de la Patrona",
        	intermediaria:"Ingrese el nombre de la Intermediaria",
        	porcPrimaVacacional:"Ingrese un porcentaje Vacacional",
        	registroPatronal:"Ingrese un registro Patronal",
        	fechaContrato:"Ingrese una Fecha",
        	selectMult:"Ingrese una Raz&oacute;n Social",
        	
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
			var options = "";
			var result=response[0];
			 for (var i = 0; i < result.length; i++) {
			    	options += '<option value="' + result[i].idEjecutivo + '">' + result[i].nombreEjecutivo + ' '+ result[i].paternoEjecutivo + ' '+ result[i].maternoEjecutivo +'</option>';
			    }
			 $("#ejecutivo").append(options);
				var options = "";
				var result=response[1];
				 for (var i = 0; i < result.length; i++) {
				    	options += '<option value="' + result[i].idEsquema + '">' + result[i].nombreEsquema +'</option>';
				    }
				 $("#esquema").append(options)
				 console.log ("Tipo Calendario");
					console.log (response[2]);
						var options = "";
						var result=response[2];
						 for (var i = 0; i < result.length; i++) {
						    	options += '<option value="' + result[i].idTipoCalendario + '">' + result[i].siglas +'</option>';
						    }
				    $("#tipoCalendario").append(options)	 
				    console.log ("Tipo Calendario");
				    console.log (response[2]);
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
	
	//manda el parametro idNomina y llama a la function obtenerNomina()
	var idNomina=getParameter("id");
	console.log("NOMINAS!")
	console.log(idNomina);
	obtenerNomina(idNomina);
	
});

//*******************************************************************************
//Function que obtiene la nomina por idNomina y llama a la function 
//muestraDatos()
//*******************************************************************************
function obtenerNomina(idNomina){
	$.ajax({
		data: {
			"idNomina" : idNomina
	},
	dataType:'json',
	url:   '../../mvc/nomina/obtenernominabyid',
	type:  'post',		
	beforeSend: function () {	
	},
	success:  function (response) {
		console.log(response)
		muestraDatosNomina(response);	
		},	
	error: function (response) {																	
		$("#resultadoGuardar").html("Error");
		}		
	});		
}

//*******************************************************************************
//Function que obtiene los datos registrados de la Nomina para modificarlos 
//*******************************************************************************
function muestraDatosNomina(datos){
	var data=eval(datos);
	$("#nombreNomina").val(data.nombreCorto);
	$("#nominaIdSel").val(data.idNomina);
	$("#patrona").val(data.patrona.nombreCortoPatrona);
	$("#idPatrona").val(data.patrona.idPatrona);
	$("#intermediaria").val(data.intermediaria.nombreCortoPatrona);
	$("#idIntermediaria").val(data.intermediaria.idPatrona);
	$("#fechaContrato").val(data.fechaContrato);
	$("#patronaIdSel").val(data.patrona.idPatrona);
	$("#ejecutivo").val(data.ejecutivo.idEjecutivo);
	$("#esquema").val(data.esquema.idEsquema);
	$("#porcPrimaVacacional").val(data.porcPrimaVacacional);
	if (data.provisionAguinaldo){
		
		$("#provisionAguinaldo").attr("checked",true);
	}
	if (data.provisionVacaciones){
		
		$("#provisionVacaciones").attr("checked",true);
	}
	
	if (data.provisionPrimaVacacional){
		
		$("#provisionPrimaVac").attr("checked",true);
	}	
	if (data.fondoAhorro){
		
		$("#fondoDeAhorro").attr("checked",true);
	}
	if (data.ivaExento){
		
		$("#ivaExcento").attr("checked",true);
	}	
	if (data.comisionCostSocial){
		
		$("#comisionCostoSocial").attr("checked",true);
	}	
	if (data.facturaSubsidio){
		
		$("#factSub").attr("checked",true);
	}	
	if (data.reconoceAntiguedad){
		
		$("#reconoceAntihuedad").attr("checked",true);
	}	
	$("#tipoPago").val(data.tipoPago);
	$("#claseRiesgo").val(data.claseRiesgo);
	$("#registroPatronal").val(data.registroPatronal);
	$("#periodicidad").val(data.periodicidad);
	$("#tipoCalendario").val(data.tipoCalendario.idCalendario);
	//alert(data.razonesSociales.length)
	var valorT=0;
	for (i=0;i<data.razonesSociales.length;i++){
		console.log(data.razonesSociales[i].nombreRazonSocial);
		var formTmp = document.getElementById("actualizarNominaForm");
		var x = document.getElementById("selectMult");
		var option = document.createElement("option");
		option.id = data.razonesSociales[i].idRazonSocial;
		option.text = data.razonesSociales[i].nombreRazonSocial + "----" + data.razonesSociales[i].comision+"%";
		x.add(option);  
		var name="porcentaje"+option.id;
		document.getElementById("tmpTxtBox").innerHTML="<input type='hidden' id='"+name+"' value='"+data.razonesSociales[i].comision+"'/>";		
		valorT=valorT+parseInt(data.razonesSociales[i].comision);
	}
	sumaPorcentaje=valorT;

}


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


//*******************************************************************************
//Function que actualiza la Nomina con los datos modificados 
//*******************************************************************************
function actualizarNomina() {
	var ids=obtenerIdsAgregadosRZ2();
	console.log("EJECUTIVO"+$("#ejecutivo").val())
	var aguinald=false;
	if($("#provisionAguinaldo").is(':checked')) {  
        aguinald=true;  
    }
	var provisionVacacionesTmp=false;
	if($("#provisionVacaciones").is(':checked')) {  
		provisionVacacionesTmp=true;  
    }	
	var provisionPrimaVacTmp=false;
	if($("#provisionPrimaVac").is(':checked')) {  
		provisionPrimaVacTmp=true;  
    }	
	var fondoDeAhorro=false;
	if($("#fondoDeAhorro").is(':checked')) {  
		fondoDeAhorro=true;  
    }	
	var ivaExento=false;
	if($("#ivaExcento").is(':checked')) {  
		ivaExento=true;  
    }	
	
	var comisionCostoSocialTmp=false;
	if($("#comisionCostoSocial").is(':checked')) {  
		comisionCostoSocialTmp=true;  
    }
	var facturaSubsidioTmp = false;
	if($("#factSub").is(':checked')) {  
		facturaSubsidioTmp=true;  
    }	

	if ($("#actualizarNominaForm").valid()){
			$.ajax({
				data : {
					"nombreCorto" : $("#nombreNomina").val(),
					"idNomina" : $("#nominaIdSel").val(),
					"patrona.idPatrona" : $("#idPatrona").val(),
					"intermediaria.idPatrona" : $("#idIntermediaria").val(),
					"ejecutivo.idEjecutivo" : $("#ejecutivo").val(),
					"esquema.nombreEsquema" : $("#esquema").val(),
					"provisionAguinaldo" : aguinald,
					"provisionVacaciones" : provisionVacacionesTmp,
					"provisionPrimaVacacional" : provisionPrimaVacTmp,
					"porcPrimaVacacional" : $("#porcPrimaVacacional").val(),
					"fondoAhorro" : fondoDeAhorro,					
					"comisionCostSocial" : comisionCostoSocialTmp,
					"facturaSubsidio" : facturaSubsidioTmp,
					"ivaExento" : ivaExento,
					"reconoceAntiguedad" : $("#reconoceAntihuedad").val(),
					"comisionCostSocial" : $("#comisionCostoSocial").val(),
					"tipoPago" : $("#tipoPago").val(),
					"claseRiesgo" : $("#claseRiesgo").val(),
					"registroPatronal" : $("#registroPatronal").val(),
					"periodicidad" : $("#periodicidad").val(),
					"tipoCalendario.idCalendario" : $("#tipoCalendario").val(),
					"fechaContrato" : $("#fechaContrato").val(),
					"jsonValue" : ids[0]
				},
				
				dataType : 'json',
				url : '../../mvc/nomina/modificanomina',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {					
					mensajeRedireccion("Nomina actualizada correctamente.","../nominas/nominas.jsp");

				},
				error : function(response) {
					console.log(response);
					$("#resultadoGuardar").html();
				}
			});
			}
		}

function cancelar(){
	top.frames['main'].location="../nominas/nominas.jsp"; 	
}

function showEditarPatrona(idPatrona){
	top.frames['main'].location="../patronas/actualizar_patrona.jsp?id="+idPatrona; 
}

function guardarPatrona(){
	top.frames['main'].location="../patronas/agregar_patrona.jsp"; 	
}