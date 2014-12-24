var oTableAfiliadosAprobaciones;
var oTableAfiliadosAprobacionesBeneficiarios;

$(document).ready(function() {
	oTableAfiliadosAprobaciones=$('#tablaAfiliadosAprobaciones').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/certificadoafiliado/getcertificadosaprob',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {
			//$("#resultado").html("");									
			//oTable = $('#tablaEscuelas').dataTable();		
			setData(response);
		}			
	});
	
	oTableAfiliadosAprobacionesBeneficiarios=$('#tablaAfiliadosAprobacionesBeneficiarios').dataTable();
		$.ajax({
			sync: true,
			type:  'post',
			url:   '../../mvc/certificadoafiliado/getbeneficiariosmod',
			dataType:  'json',
			beforeSend: function () {
				$("#resultado").html("Procesando, espere por favor...");
			},
			success:  function (response) {
				//$("#resultado").html("");									
				//oTable = $('#tablaEscuelas').dataTable();		
				setDataBeneficiarios(response);
			}			
		});


	$( "#divAfiliados" ).dialog({
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
	$("#tablaAfiliadosAprobaciones tbody").click(function(event) {
		$(oTableAfiliadosAprobaciones.fnSettings().aoData).each(function (){
		$(this.nTr).removeClass('row_selected');
		});
	$(event.target.parentNode).addClass('row_selected');
		});
				
	$("#tablaAfiliadosAprobaciones tbody").click(function(event) {
		$(oTableAfiliadosAprobaciones.fnSettings().aoData).each(function (){
		$(this.nTr).removeClass('row_selected');
		});
	$(event.target.parentNode).addClass('row_selected');					
		});
	
	/* Add a click handler to the rows - this could be used as a callback */
	$("#tablaAfiliadosAprobacionesBeneficiarios tbody").click(function(event) {
		$(oTableAfiliadosAprobacionesBeneficiarios.fnSettings().aoData).each(function (){
		$(this.nTr).removeClass('row_selected');
		});
	$(event.target.parentNode).addClass('row_selected');
		});
				
	$("#tablaAfiliadosAprobacionesBeneficiarios tbody").click(function(event) {
		$(oTableAfiliadosAprobacionesBeneficiarios.fnSettings().aoData).each(function (){
		$(this.nTr).removeClass('row_selected');
		});
	$(event.target.parentNode).addClass('row_selected');					
		});
	
});

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

function verDetalle(){
	var anSelected = fnGetSelected( oTableAfiliadosAprobaciones );	
	var id=anSelected[0].cells[0].innerText;
	openFrame("certificados/detallecertificado.jsp?id="+id);
} 

function verDetalleBeneficiarios(){
	var anSelected = fnGetSelected( oTableAfiliadosAprobacionesBeneficiarios );	
	var id=anSelected[0].cells[0].innerText;
	openFrame("certificados/detallebeneficiario.jsp?id="+id);
} 

function editarAfiliado(){
	var anSelected = fnGetSelected( oTableAfiliados );	
	var id=anSelected[0].cells[0].innerText;
	openFrame("afiliados/modificaafiliado.jsp?id="+id);
}

function openFrame(url){
	top.frames['mainFrame'].location="../"+url; 
}

function setData(data){
	var count=0;	
	for (count=0;count<data.length;count ++){	
		 $('#tablaAfiliadosAprobaciones').dataTable().fnAddData( [
		        data[count].idCertificadoAfiliado,				
				data[count].numeroCertificadoAfiliado,
				"24-01-2013",
				data[count].estadoCertificadoAfiliado,
				data[count].sumaAseguradaCertificadoAfiliado					
			] 
		);				
	}
}

function setDataBeneficiarios(data){
	var count=0;	
	for (count=0;count<data.length;count ++){				
		 $('#tablaAfiliadosAprobacionesBeneficiarios').dataTable().fnAddData( [
		        data[count].idBeneficiario,
		        data[count].nombreBeneficiario,				
				data[count].appBeneficiario,
				data[count].apmBeneficiario,				
				data[count].parentescoBeneficiario,
				data[count].certificadoAfiliado,
				"123312"					
			] 
		);				
	}
}


function aprobarCambiosCert(){
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/certificadoafiliado/aprobarcambios',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {
			//$("#resultado").html("");									
			//oTable = $('#tablaEscuelas').dataTable();		
			setData(response);
		}			
	});				
}