var oTable;
var idAfiliado=getParameter('id');
	
$(document).ready(function() {
	oTable=$('#tablaEscuelas').dataTable();
	$( "#divEscuela" ).dialog({
		autoOpen: false,
	    height: 400,
	    width: 1050,
	    modal: true,
	    buttons: {
	    	Cancel: function() {
	    		$( this ).dialog( "close" );
	    		}
	        },
	       	close: function() {
	       		var anSelected = fnGetSelected( oTable );				    		
	    		$("#escuela").val(anSelected[0].cells[1].innerText);
	    		$("#idescuela").val(anSelected[0].cells[0].innerText);
	       	}
	});				
	
	/* Add a click handler to the rows - this could be used as a callback */
	$("#tablaEscuelas tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
	});
	
	$("#tablaEscuelas tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');					
	});
	getAfiliado(idAfiliado);
	getAfiliadoActual(idAfiliado);
});

function getAfiliado(idAfiliado){
	$.ajax({
		data: {
			"idAfiliado" : idAfiliado
	},
	async: false,
	dataType:'json',
	url:   '../../mvc/afiliado/obtenerafiliadomodbyid',
	type:  'post',		
	beforeSend: function () {
		
	},
	success:  function (response) {
		procesaDatosAfiliado(response);			
	}		,	
	error: function (response) {																	
		$("#resultadoGuardar").html("Error al agregar al afiliado!");
	}		
	});	
	
}

function getAfiliadoActual(idAfiliado){
	$.ajax({
		data: {
			"idAfiliado" : idAfiliado,		
	},
	async: false,
	dataType:'json',
	url:   '../../mvc/afiliado/obtenerafiliadobyid',
	type:  'post',		
	beforeSend: function () {
		
	},
	success:  function (response) {
		procesaDatosAfiliadoActual(response);			
	}		,	
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

function procesaDatosAfiliadoActual(datos){
	var data=eval(datos);
	//alert(data.nombreAfiliado);
	$("#nombreactual").html(data.nombreAfiliado);
	$("#nacionalidadactual").html(data.nacionalidadAfiliado);
	$("#appactual").html(data.appPaternoAfiliado);
	$("#apmactual").html(data.appMaternoAfiliado);
	$("#estadocivilactual").html(data.estadoCivilAfiliado);
	$("#rfcactual").html(data.rfcAfiliado);
	$("#fechanacimientoactual").val(data.fechaNacimientoAfiliado);
	$("#domicilioactual").html(data.direccionAfiliado);
	$("#coloniaactual").html(data.coliniaAfiliado);
	$("#cpactual").html(data.cpAfiliado);
	$("#entidadactual").html(data.entidadAfiliado);
	$("#puestoactual").html(data.puestoAfiliado);
	$("#antiguedadactual").html(data.antiguedadAfiliado);
	$("#telparticularactual").html(data.telParticularAfiliado);
	$("#telcelularactual").html(data.telCelularAfiliado);
	$("#companiaactual").html(data.companiatelAfiliado);
	$("#emailactual").html(data.emailAfiliado);
	$("#municipioactual").html(data.municipioAfiliado);
	$("#escuelaactual").html(data.escuelaAfiliado);
}

function denegar(){		 
//	if ($('*',window.parent.mainFrame.document.formAfiliado).validationEngine('validate') == true){
		$.ajax({
			data: {
			"idAfiliado" : idAfiliado,
		},
		dataType:'json',
		url:   '../../mvc/afiliado/denegaraprobacion ',
		type:  'post',		
		beforeSend: function () {
			
		},
		success:  function (response) {																	
			$("#resultadoGuardar").html("Se Deneg&oacute; correctamente la solicitud");			
		}		,	
		error: function (response) {																	
			$("#resultadoGuardar").html("Error al agregar al afiliado!");
		}		
	});		
	//}
}

function aprobar(){		 
//	if ($('*',window.parent.mainFrame.document.formAfiliado).validationEngine('validate') == true){
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
		url:   '../../mvc/afiliado/aprobarmodafiliado ',
		type:  'post',		
		beforeSend: function () {
			
		},
		success:  function (response) {																	
			$("#resultadoGuardar").html("Se Aplicaron los cambios de datos del Afiliado!");			
		}		,	
		error: function (response) {																	
			$("#resultadoGuardar").html("Error al agregar al afiliado!");
		}		
	});		
	//}
}

function guardarAfiliado(){		 
//	if ($('*',window.parent.mainFrame.document.formAfiliado).validationEngine('validate') == true){
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
			$("#resultadoGuardar").html("Se actualiz&oacute; el afiliado en forma correcta!<a href='#' onclick='procederCertificado()'>Generar Certificado</a>");			
		}		,	
		error: function (response) {																	
			$("#resultadoGuardar").html("Error al agregar al afiliado!");
		}		
	});		
	//}
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
