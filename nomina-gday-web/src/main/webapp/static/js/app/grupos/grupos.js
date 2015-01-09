$(document).ready(function() {
	oTableGrupos=$('#tablaGrupo').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   'mvc/grupo/getgrupos',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
      	$( "#progressbar" ).progressbar({
		      value: 75
		    });	
        $( "#demo" ).hide();
		},
		success:  function (response) {
			$( "#demo" ).show();
			$( "#progressbar" ).hide();
			$('#tablaGrupo').dataTable().fnAddData(response);
			//setData(response);
		}	
	});			

});