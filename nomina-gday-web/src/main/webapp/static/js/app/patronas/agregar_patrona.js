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


//**************************************************************************************
//Function que Agrega y Quita REPRESENTANTES LEGALES PLEITOS Y COBRANZAS del SelectMult*
//**************************************************************************************
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


//**************************************************************************************
//Function que Agrega y Quita REPRESENTANTES LEGALES LABORALES del SelectMult*
//**************************************************************************************
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

////////////////////////////ARMAR JSON\\\\\\\\\\\\\\\\\\\\\\\\\\\\

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


//******************************************************************************
//Function que genera el json de los REPRESENTANTES LEGALES PLEITOS Y COBRANZAS*
//******************************************************************************
function getPodNot(){
	var jsonString ="{\"poderesNot\":[";
	var renglonJson="";
	var index=0;
	var numReng=parseInt(document.getElementById("podNotNum").value);
	console.log(numReng);

	for (i=1;i<=numReng;i++){  
		var numero=document.getElementById("num"+i).value;
		var notaria=document.getElementById("not"+i).value;
		var notario=document.getElementById("notario"+i).value;
		renglonJson=renglonJson+"{ \"idpodNotNum\":"+(i)+", \"numero\": \""+numero+"\" " + ", \"notaria\": \""+notaria+"\" " +", \"notario\": \""+notario+"\" "+"}";
		jsonString=jsonString+renglonJson;
		renglonJson=",";
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
	for (i=1;i<=numReng;i++){  
		var numero=document.getElementById("num2"+i).value;
		var notaria=document.getElementById("not2"+i).value;
		var notario=document.getElementById("notario2"+i).value;
		renglonJson=renglonJson+"{ \"idpodNotLabNum\":"+(i)+", \"numero\": \""+numero+"\" " + ", \"notaria\": \""+notaria+"\" " +", \"notario\": \""+notario+"\" "+"}";
		jsonString=jsonString+renglonJson;
		renglonJson=",";
	}	
	jsonString=jsonString+"]}";
	console.log("STRING PODNOTLAB");
	console.log(jsonString);
	return jsonString;
}
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


//********************************************************************
//Function que genera el json de los REPRESENTANTES LEGALES LABORALES*
//********************************************************************
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

//******************************************************
//Function que guarda los datos de la Patrona en la BD *
//******************************************************
function guardarPatrona() {
	console.log(getDomVirtuales());
	console.log(getAccionistas());
	console.log(getRepresentantesLegalesPleitosCobranzas());
	console.log(getRepresentantesLegalesLaborales());
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
					"jsonStringDomicilio": getDomVirtuales(),
					"jsonStringAccionistas": getAccionistas(),
					"jsonStringRepresentantesPleitos": getRepresentantesLegalesPleitosCobranzas(),
					"jsonStringRepresentantesLegales": getRepresentantesLegalesLaborales(),
					"jsonStringPodNot":getPodNot(),
					"jsonStringPodNotLab":getPodNotLab()			
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
    var rowCount = table.rows.length;
    for(var i=0; i<rowCount; i++) {
        var row = table.rows[i];
    if (tabla==1){
  		row.cells[0].childNodes[0].id="num"+parseInt(i+1);
  		row.cells[1].childNodes[0].id="not"+parseInt(i+1);
  		row.cells[2].childNodes[0].id="notario"+parseInt(i+1);
					
	}
	if (tabla==2){
  		row.cells[0].childNodes[0].id="num2"+parseInt(i+1);
  		row.cells[1].childNodes[0].id="not2"+parseInt(i+1);
  		row.cells[2].childNodes[0].id="notario2"+parseInt(i+1);
		
	}
    console.log("lista");
	console.log(row.cells[0].childNodes[0].id);

    }
    }catch(e) {

         alert(e);

    }

}

