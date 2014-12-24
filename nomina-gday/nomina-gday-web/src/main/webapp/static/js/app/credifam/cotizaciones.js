$(document).ready(function() {
	oTableCotizaciones=$('#tablaCotizaciones').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/credifam/getCotizacionesByAfiliado',
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
			$('#tablaCotizaciones').dataTable().fnAddData(response);
			//setData(response);
		}			
	});			

});

