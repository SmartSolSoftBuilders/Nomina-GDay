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
        	nombreNomina: "required"
        	//selectMult: "required"
            /*email: {
                required: true,
                email: true
            },*/
        },        
        messages: {
        	nombreNomina: "Ingrese el nombre de la N&oacute;mina",
        	selectMult:"Seleccione por lo menos un grupo y su porcentaje"
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
	$("#patronaIdSel").val(data.patrona.idPatrona);
	$("#ejecutivo").val(data.ejecutivo.idEjecutivo);
	$("#esquema").val(data.esquema.idEsquema);
	if (data.provisionAguinaldo){
		
		$("#provisionAguinaldo").attr("checked",true);
	}
	if (data.provisionVacaciones){
		
		$("#provisionVacaciones").attr("checked",true);
	}
	
	if (data.provisionPrimaVacacional){
		$("#provisionPrimaVac").attr("checked",true);
	}	
	$("#porcPrimaVacacional").val(data.porcPrimaVacacional);
	
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
	$("#tipoCalendario").val(data.tipoCalendario.tipoCalendario);
	$("#tipoCalendarioIdSel").val(data.tipoCalendario.idTipoCalendario);
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


//*******************************************************************************
//Function que actualiza la Nomina con los datos modificados 
//*******************************************************************************
function actualizarNomina() {
	console.log(nominaIdSel);
			$
			.ajax({
				data : {
					"nombreCorto" : $("#nombreNomina").val(),
					"idNomina" : $("#nominaIdSel").val(),
					"patrona.nombreCorto" : $("#patrona").val(),
					"ejecutivo.nombreEjecutivo" : $("#ejecutivo").val(),
					"esquema.nombreEsquema" : $("#esquema").val(),
					"provisionAguinaldo" : $("#provisionAguinaldo").val(),
					"provisionVacaciones" : $("#provisionVacaciones").val(),
					"provisionPrimaVac" : $("#provisionPrimaVac").val(),
					"porcPrimaVacacional" : $("#porcPrimaVacacional").val(),
					"fondoDeAhorro" : $("#fondoDeAhorro").val(),
					"ivaExcento" : $("#ivaExcento").val(),
					"comisionCostoSocial" : $("#comisionCostoSocial").val(),
					"tipoPago" : $("#tipoPago").val(),
					"claseRiesgo" : $("#claseRiesgo").val(),
					"registroPatronal" : $("#registroPatronal").val(),
					"periodicidad" : $("#periodicidad").val(),
					"tipoCalendario.tipoCalendario" : $("#tipoCalendario").val(),
					"fechaContrato" : $("#fechaContrato").val(),
				},
				
				dataType : 'json',
				url : '../../mvc/nomina/modificanomina',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {
					console.log("Actualizando");
					console.log(response);
					$("#resultadoGuardar")
							.html(alert("La actualizaci\u00f3n de Nomina se realiz\u00f3 correctamente"));
				},
				error : function(response) {
					console.log(response);
					$("#resultadoGuardar").html();
				}
			});
		}

function cancelar(){
	top.frames['main'].location="../nominas/nominas.jsp"; 	
}