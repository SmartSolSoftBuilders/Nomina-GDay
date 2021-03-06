$(document).ready(function() {
	oTableAfiliados=$('#tablaAfiliados').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/famahorro/afiliadosall',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {
			//$("#resultado").html("");									
			//oTable = $('#tablaEscuelas').dataTable();		
			//setData(response);
			$('#tablaAfiliados').dataTable().fnAddData(response);
			
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
	$("#tablaAfiliados tbody").click(function(event) {
		$(oTableAfiliados.fnSettings().aoData).each(function (){
		$(this.nTr).removeClass('row_selected');
		});
	$(event.target.parentNode).addClass('row_selected');
		});
				
	$("#tablaAfiliados tbody").click(function(event) {
		$(oTableAfiliados.fnSettings().aoData).each(function (){
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

function modificarCertificado(){
	var anSelected = fnGetSelected( oTableAfiliados );	
	var id=anSelected[0].cells[0].innerText;
	openFrame("afiliados/certificado.jsp?id="+id);
}

function crearCuentaFamAhorro(){
	var anSelected = fnGetSelected( oTableAfiliados );	
	var id=anSelected[0].cells[0].innerText;
	var cuentaFamAhorro=anSelected[0].cells[7].innerText;
	if (cuentaFamAhorro=="SI"){
		alert("El afiliado es Inversionista, no puede tener cuenta FAMAhorro!");		
	}
	else	
		openFrame("famahorro/altafamahorro.jsp?id="+id);	
}

function crearCuentaInversion(){
	var anSelected = fnGetSelected( oTableAfiliados );	
	var id=anSelected[0].cells[0].innerText;	
	openFrame("famahorro/altafamahorroinv.jsp?id="+id);
}

function openFrame(url){
	top.frames['mainFrame'].location="../"+url; 
}

function setData(data){
	var count=0;	
	for (count=0;count<data.length;count ++){
		if(data[count].famAhorro==false)
			data[count].famAhorro='NO';
		else
			data[count].famAhorro='SI';
		if(data[count].inversionista==false)
			data[count].inversionista='NO';
		else
			data[count].inversionista='SI';
		if (i==2)
			alert(data[count].inversionista);
		 $('#tablaAfiliados').dataTable().fnAddData( [
		        data[count].idAfiliado,
				data[count].rfcAfiliado,
				data[count].nombreAfiliado,
				data[count].appPaternoAfiliado,
				data[count].appMaternoAfiliado,				
				data[count].famAhorro,				
				data[count].crediFam,
				data[count].inversionista
			] 
		);				
	}
}

