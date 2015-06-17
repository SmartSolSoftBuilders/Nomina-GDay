var indexOpt=1;

//*****************************************************
//Function que valida los elementos que son requeridos*
//*****************************************************


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
	
	$("#actualizarPatronaForm").validate({
		rules: {
			nombrePatrona: "required",
			razonSocial: "required",
			rfc: "required",
			folioMerc: "required",
			calle: "required",
			colonia: "required",
			numExt: "required",
			numInt: "required",
			cp: "required",
			municipio: "required",
			telContacto: "required",
			selectMult: "required",
			numActaConst: "required",
			numNotaria: "required",
			fecha: "required",
			notario: "required",
			ciudad: "required",
			estado: "required",
			numeroPoderesNot: "required",
			notariaPoderesNot: "required",
			notarioPoderesNot: "required",
			numeroPoderesNotLab: "required",
			notariaPoderesNotLab: "required",
			notarioPoderesNotLab: "required",
			selectMultAccionista: "required",
			selectMultRepresentantes: "required",
			selectMultRepresentantesLegLab: "required",
		},        
		messages: {
			nombrePatrona: "Ingrese el nombre de la Patrona",
			razonSocial: "Ingrese el nombre de la Raz&oacute;n Social",
			rfc:"Ingrese un rfc",
			folioMerc:"Ingrese el Folio Mercantil",
			selectMult:"Seleccione por lo menos un Domicilio Virtual",
			calle:"Ingrese una Calle",
			colonia:"Ingrese una Colonia",
			numExt:"Ingrese un N&uacute;mero Exterior",
			numInt:"Ingrese una N&uacute;mero Interior",
			cp: "Ingrese un CP",
			municipio: "Ingrese un Municipio",
			telContacto: "Ingrese un Tel&egrave;fono de Contacto",
			numActaConst: "Ingrese un N&uacute;mero de Acta Constitutiva",
			numNotaria: "Ingrese un N&uacute;mero de Notaria",
			fecha: "Ingrese una Fecha",
			notario: "Ingrese un Nombre de Notario",
			ciudad: "Ingrese una Ciudad",
			estado: "Ingrese un Estado",
			numeroPoderesNot: "Ingrese un N&uacute;mero Notarial",
			notariaPoderesNot: "Ingrese una Notaria",
			notarioPoderesNot: "Ingrese un Notario",
			numeroPoderesNotLab: "Ingrese un N&uacute;mero de Poder Notarial",
			notariaPoderesNotLab: "Ingrese una Notaria de Poder Notarial",
			notarioPoderesNotLab: "Ingrese una Notario de Poder Notarial",
			selectMultAccionista: "Ingrese un Accionista",
			selectMultRepresentantes: "Ingrese un Poder Notarial Pleitos y Cobranzas",
			selectMultRepresentantesLegLab: "Ingrese un Representante Legal Laboral"
			
		},

		submitHandler: function(form) {
		    form.submit();
		}

		});
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
	console.log(data.numInteriorFiscalPatrona);
	console.log(data.actaNotarioPatrona);
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
	console.log("bjr");
	console.log(data.poderesNotarialesPleitosCobranzas.length);
	console.log(data.poderesNotarialesLaborales.length);
	
	for (i=0;i<data.poderesNotarialesPleitosCobranzas.length;i++){														  
		document.getElementById("numeroPoderesNot").value=data.poderesNotarialesPleitosCobranzas[i].numero;
		document.getElementById("notariaPoderesNot").value=data.poderesNotarialesPleitosCobranzas[i].notaria;
		document.getElementById("notarioPoderesNot").value=data.poderesNotarialesPleitosCobranzas[i].notario;
		addRow("tablaPodNotPleitos",1);
	}
	console.log("VALORES:"+i);
	for (i=0;i<data.poderesNotarialesLaborales.length;i++){														  
		document.getElementById("numeroPoderesNotLab").value=data.poderesNotarialesLaborales[i].numero;
		document.getElementById("notariaPoderesNotLab").value=data.poderesNotarialesLaborales[i].notaria;
		document.getElementById("notarioPoderesNotLab").value=data.poderesNotarialesLaborales[i].notario;
		addRow("tablaPodNotLab",2); 
	}

}

function getPodNot(){
	var jsonString ="{\"poderesNotLabPleiCob\":[";
	var renglonJson="";
	var index=0;
	var numReng=parseInt(document.getElementById("podNotNum").value);
	console.log(numReng);
	var table = document.getElementById("tablaPodNotPleitos");
	for (i=0;i<=numReng;i++){       
		var row = table.rows[i];
		if (row.cells[0].childNodes[0].id!=null && row.cells[0].childNodes[0].id!="undefined"){
			console.log("ID:"+row.cells[0].childNodes[0].id);
			console.log("ID:"+row.cells[1].childNodes[0].id);
		var numero=document.getElementById(row.cells[0].childNodes[0].id).value;
		var notaria=document.getElementById(row.cells[1].childNodes[0].id).value;
		var notario=document.getElementById(row.cells[2].childNodes[0].id).value;
		renglonJson=renglonJson+"{ \"idPoderesNotLabPleiCob\":"+(i+1)+", \"numero\": \""+numero+"\" " + ", \"notaria\": \""+notaria+"\" " +", \"notario\": \""+notario+"\" "+"}";
		jsonString=jsonString+renglonJson;
		renglonJson=",";
		}
	}
	jsonString=jsonString+"]}";
	console.log("STRING PODNOT");
	console.log(jsonString);
	return jsonString;
}
function getPodNotLab(){
	var jsonString ="{\"poderesNotLab\":[";
	var renglonJson="";
	var index=0;
	var numReng=parseInt(document.getElementById("podNotLabNum").value);
	console.log(numReng);
	var table = document.getElementById("tablaPodNotLab");
	for (i=0;i<=numReng;i++){  
		var row = table.rows[i];
		console.log("ID:::"+row.cells[0].childNodes[0].id);
		if (row.cells[0].childNodes[0].id!=null && row.cells[0].childNodes[0].id!="undefined"){
		var numero=document.getElementById(row.cells[0].childNodes[0].id).value;
		var notaria=document.getElementById(row.cells[1].childNodes[0].id).value;
		var notario=document.getElementById(row.cells[2].childNodes[0].id).value;
		renglonJson=renglonJson+"{ \"idPodNotLab\":"+(i+1)+", \"numero\": \""+numero+"\" " + ", \"notaria\": \""+notaria+"\" " +", \"notario\": \""+notario+"\" "+"}";
		jsonString=jsonString+renglonJson;
		renglonJson=",";
		}
	}	
	jsonString=jsonString+"]}";
	console.log("STRING PODNOTLAB");
	console.log(jsonString);
	return jsonString;
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
		var theSelect = document.getElementById('selectMult');
		if (theSelect.options.length>0)
			var lastValue = theSelect.options[theSelect.options.length - 1].value;
		else
			lastValue=0;
		var x = document.getElementById("selectMult");
		var option = document.createElement("option");
		option.id = lastValue+1;
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
	if ($("#actualizarPatronaForm").valid()){
		console.log($("#numInt").val());
		console.log($("#tipoReg").val());
		var esInt=false;
		if($("#intermediaria").is(':checked')) {  
	        esInt=true;  
	    } 
		console.log($("#intermediaria").val());
			$.ajax({
				data : {
					"idPatrona" : $("#idPatrona").val(),
					"nombreCortoPatrona" : $("#nombrePatrona").val(),
					"razonSocialPatrona" : $("#razonSocial").val(),
					"rfcPatrona" : $("#rfc").val(),
					"folioMercantilPatrona" : $("#folioMerc").val(),
					"esIntermediariaPatrona" : esInt,
					"tipoRegimen.idTipoRegimen" : $("#tipoReg").val(),
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
					"jsonStringRepresentantesLegales": getRepresentantesLegalesLaborales(),
					"jsonStringPodNot":getPodNot(),
					"jsonStringPodNotLab":getPodNotLab()			
				},
				
				dataType : 'json',
				url : '../../mvc/patrona/modificapatrona',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {
					mensajeRedireccion("PATRONA ACTUALIZADA CORRECTAMENTE.","../patronas/patronas.jsp");
				},
				error : function(response) {
					console.log(response);
					$("#resultadoGuardar").html();
				}
			});
		}
	}

function addRow(tableID,tabla) {
	if (tabla==1){
		var num=document.getElementById("numeroPoderesNot").value;
		var not=document.getElementById("notariaPoderesNot").value;
		var notario=document.getElementById("notarioPoderesNot").value;
	    var table = document.getElementById(tableID);
	    var rowCount = table.rows.length;
	    var row = table.insertRow(rowCount);
	    console.log(rowCount);
	    var indice=rowCount;
	    var cell1 = row.insertCell(0);
	    var att = document.createAttribute("readonly");
	    var element1 = document.createElement("input");
	    element1.type = "text";
	    element1.value=num;
	    element1.id="num"+(indice);    
	    element1.setAttributeNode(att);
	    cell1.appendChild(element1);
	    var cell2 = row.insertCell(1);
	    var element2 = document.createElement("input");
	    element2.type = "text";
	    element2.value=not;
	    element2.id="not"+(indice);
	    var att2 = document.createAttribute("readonly");
	    element2.setAttributeNode(att2);
	    cell2.appendChild(element2);
	    var cell3 = row.insertCell(2);
	    var element3 = document.createElement("input");
	    element3.type = "text";
	    element3.value=notario;
	    element3.id="notario"+(indice);
	    var att3 = document.createAttribute("readonly");
	    element3.setAttributeNode(att3);
	    cell3.appendChild(element3);
	    var cell4 = row.insertCell(3);	    
	    var element4 = document.createElement("input");
        element4.type = "checkbox";
        cell4.appendChild(element4);
		document.getElementById("podNotNum").value=parseInt(document.getElementById("podNotNum").value)+1;			
	}
	if (tabla==2){
		var num=document.getElementById("numeroPoderesNotLab").value;
		var not=document.getElementById("notariaPoderesNotLab").value;
		var notario=document.getElementById("notarioPoderesNotLab").value;
	    var table = document.getElementById(tableID);
	    var rowCount = table.rows.length;
	    var row = table.insertRow(rowCount);
	    console.log(rowCount);
	    var indice=rowCount;
	    var cell1 = row.insertCell(0);
	    var att = document.createAttribute("readonly");
	    var element1 = document.createElement("input");
	    element1.type = "text";
	    element1.value=num;
	    element1.id="num2"+(indice);    
	    element1.setAttributeNode(att);
	    cell1.appendChild(element1);
	    var cell2 = row.insertCell(1);
	    var element2 = document.createElement("input");
	    element2.type = "text";
	    element2.value=not;
	    element2.id="not2"+(indice);
	    var att2 = document.createAttribute("readonly");
	    element2.setAttributeNode(att2);
	    cell2.appendChild(element2);
	    var cell3 = row.insertCell(2);
	    var element3 = document.createElement("input");
	    element3.type = "text";
	    element3.value=notario;
	    element3.id="notario2"+(indice);
	    var att3 = document.createAttribute("readonly");
	    element3.setAttributeNode(att3);
	    cell3.appendChild(element3);
	    var cell4 = row.insertCell(3);	    
	    var element4 = document.createElement("input");
        element4.type = "checkbox";
        cell4.appendChild(element4);
		document.getElementById("podNotLabNum").value=parseInt(document.getElementById("podNotLabNum").value)+1;			
	}
}



function deleteRow(tableID,tabla) {
    try {
    var table = document.getElementById(tableID);
    var rowCount = table.rows.length;
    for(var i=0; i<rowCount; i++) {
         var row = table.rows[i];
         var chkbox = row.cells[3].childNodes[0];
         console.log("anterior");
         console.log(row.cells[0].childNodes[0].id);
         if(null != chkbox && true == chkbox.checked) {
              table.deleteRow(i);
              rowCount--;
              i--;
              if (tabla==1){
            		
          		if (parseInt(document.getElementById("podNotNum").value)>0)
          			document.getElementById("podNotNum").value=parseInt(document.getElementById("podNotNum").value)-1;			
          	}
          	if (tabla==2){
            		
          		if (parseInt(document.getElementById("podNotLabNum").value)>0)
          				document.getElementById("podNotLabNum").value=parseInt(document.getElementById("podNotLabNum").value)-1;
          	}
         }
      }    
    }
    catch(e) {
         alert(e);
    }
}

function cancelar(){
	top.frames['main'].location="../patronas/patronas.jsp"; 	
}
