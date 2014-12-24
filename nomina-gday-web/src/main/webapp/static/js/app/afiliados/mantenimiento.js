$(document).ready(function() {
	oTableAfiliados=$('#tablaAfiliados').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/afiliado/afiliadosall',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
      	$( "#progressbar" ).progressbar({
		      value: 75
		    });	
        $( "#demo" ).hide();
		},
		success:  function (response) {
			//$("#resultado").html("");									
			//oTable = $('#tablaEscuelas').dataTable();	
			$( "#progressbar" ).progressbar({
				value: 100
		    });
			$( "#progressbar" ).hide();	
			$( "#demo" ).show();
			$('#tablaAfiliados').dataTable().fnAddData(response);
			//setData(response);
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
	if (anSelected[0].cells[8].innerText=="NO")
		openFrame("afiliados/certificado.jsp?id="+id);
	else
		alert("Un Inversionista no cuenta con Certificado");
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
		$( "#progressbar" ).progressbar({
		      value: ((count+1)*100)/data.length
		    });		
		console.log(data[count].famAhorro);
		if (data[count].famAhorro==true)
			data[count].famAhorro="SI";
		else
			data[count].famAhorro="NO";	
		 $('#tablaAfiliados').dataTable().fnAddData( [
		        data[count].idAfiliado,
				data[count].rfcAfiliado,
				data[count].nombreAfiliado,
				data[count].appPaternoAfiliado,
				data[count].appMaternoAfiliado,
				data[count].inversionista,
				data[count].famAhorro,
				data[count].credifam="NO",
				data[count].inversionista
			] 
		);				
	}
  $( "#progressbar" ).hide();
}

