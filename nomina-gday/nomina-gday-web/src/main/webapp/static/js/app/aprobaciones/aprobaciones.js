var oTableAfiliadosAprobaciones;
$(document).ready(function() {
	oTableAfiliadosAprobaciones=$('#tablaAfiliadosAprobaciones').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/afiliado/afiliadosaprobaciones',
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
				
	/* Add a click handler to the rows - this could be used as a callback */
	$("#tableAfiliadosAprobaciones tbody").click(function(event) {
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
	openFrame("afiliados/detalleafiliado.jsp?id="+id);
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
		        data[count].idAfiliado,				
				data[count].nombreAfiliado,
				data[count].appPaternoAfiliado,
				data[count].appMaternoAfiliado,
				"24-01-2013"
			] 
		);				
	}
}

