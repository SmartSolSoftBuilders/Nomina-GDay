var oTableEscuelasMod;
var idAfiliado=getParameter('id');
	
$(document).ready(function() {
	oTableEscuelasMod=$('#tablaEscuelas').dataTable();
	$( "#divEscuela" ).dialog({
		autoOpen: false,
	    height: 400,
	    width: 550,
	    modal: true,
	    buttons: {
	    	Aceptar: function() {
	       		var anSelected = fnGetSelected( oTableEscuelasMod );				    		
	    		$("#escuela").val(anSelected[0].cells[1].innerText);
	    		$("#idescuela").val(anSelected[0].cells[0].innerText);
	    		$( this ).dialog( "close" );	    		
	    	}   	
	         
	    }
	});				
	
	/* Add a click handler to the rows - this could be used as a callback */
	$("#tablaEscuelas tbody").click(function(event) {
		$(oTableEscuelasMod.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
	});
	
	$("#tablaEscuelas tbody").click(function(event) {
		$(oTableEscuelasMod.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');					
	});
	getAfiliado(idAfiliado);
});

function getAfiliado(idAfiliado){
	$.ajax({
		data: {
			"idAfiliado" : idAfiliado
	},
	dataType:'json',
	url:   '../../mvc/afiliado/obtenerafiliadobyid',
	type:  'post',		
	beforeSend: function () {	
	},
	success:  function (response) {
		procesaDatosAfiliado(response);			
		},	
	error: function (response) {																	
		$("#resultadoGuardar").html("Error al agregar al afiliado!");
		}		
	});		
}

function procesaDatosAfiliado(datos){
	var data=eval(datos);	
	$("#nombre").val(data.nombreAfiliado);
	$("#nacionalidad").val(data.nacionalidadAfiliado);
	$("#app").val(data.appPaternoAfiliado);
	$("#apm").val(data.appMaternoAfiliado);
	$("#estadocivil").val(data.estadoCivilAfiliado);
	$("#rfc").val(data.rfcAfiliado);
	$("#fechanacimiento").val(data.fechaNacimientoAfiliado);
	$("#domicilio").val(data.direccionAfiliado);
	$("#colonia").val(data.coliniaAfiliado);
	$("#cp").val(data.cpAfiliado);
	$("#entidad").val(data.entidadAfiliado);
	$("#puesto").val(data.puestoAfiliado);
	$("#antiguedad").val(data.antiguedadAfiliado);
	$("#telparticular").val(data.telParticularAfiliado);
	$("#telcelular").val(data.telCelularAfiliado);
	$("#compania").val(data.companiatelAfiliado);
	$("#email").val(data.emailAfiliado);
	$("#municipio").val(data.municipioAfiliado);
	$("#escuela").val(data.escuelaAfiliado);
}

function guardarAfiliado(){		 
	if ($("#formModificaAfiliado").validationEngine('validate') == true){
		$.ajax({
			data: {
			"idAfiliado" : idAfiliado,
			"nombreAfiliado" : $("#nombre").val(),
			"nacionalidad" : $("#nacionalidad").val(),
			"appPaternoAfiliado" : $("#app").val(),
			"appMaternoAfiliado" : $("#apm").val(),
			"estadoCivilAfiliado" : $("#estadocivil").val(),
			"rfcAfiliado" : $("#rfc").val(),
			"fechaNacimientoAfiliado" : $("#fechanacimiento").val(),
			"direccionAfiliado" : $("#domicilio").val(),
			"coliniaAfiliado" : $("#colonia").val(),
			"cpAfiliado" : $("#cp").val(),			
			"entidadAfiliado" : $("#entidad").val(),
			"puestoAfiliado" : $("#puesto").val(),
			"antiguedadAfiliado" : $("#antiguedad").val(),
			"telParticularAfiliado" : $("#telparticular").val(),
			"telCelularAfiliado" :$("#telcelular").val(),
			"companiatelAfiliado" :$("#compania").val(),
			"emailAfiliado" :$("#email").val(),
			"municipioAfiliado" :$("#municipio").val(),
			"escuelaAfiliado" :$("#escuela").val()
		},
		dataType:'json',
		url:   '../../mvc/afiliado/modificaafiliado ',
		type:  'post',		
		beforeSend: function () {
			
		},
		success:  function (response) {																	
			$("#resultadoGuardar").html("Se actualiz&oacute; el afiliado en forma correcta!");
			$("#botonguardar").hide();
			
		}		,	
		error: function (response) {																	
			$("#resultadoGuardar").html("Error al agregar al afiliado!");
		}		
	});		
	}
} 

function procederCertificado(){
	top.frames['mainFrame'].location="../afiliados/certificado.jsp";	
}
function showEscuela(){
    $( "#divEscuela" ).dialog( "open" );
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/afiliado/escuelas',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {								
			getData(response);
		}			
	});			
}			
function getData(data){
	var count=0;	
	for (count=0;count<data.length;count ++){	
		 $('#tablaEscuelas').dataTable().fnAddData( [				
				data[count].idEscuela,
				data[count].nombreEscuela,
			] 
		);				
	}
}


function fnGetSelected( oTableLocal ){
	var aReturn = new Array();
	var aTrs = oTableLocal.fnGetNodes();				
	for ( var i=0 ; i<aTrs.length ; i++ ){
		if ( $(aTrs[i]).hasClass('row_selected') ){
			aReturn.push( aTrs[i] );
		}
	}				
	return aReturn;
}

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
