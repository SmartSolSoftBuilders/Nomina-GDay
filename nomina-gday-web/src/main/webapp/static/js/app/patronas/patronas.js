$(document).ready(function() {
	oTablePatronas=$('#tablaPatrona').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/patrona/getpatronas',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
      	$( "#progressbar" ).progressbar({
		      value: 75
		    });	
        $( "#demo" ).hide();
		},
		success:  function (response) {
			console.log(response);
			$( "#demo" ).show();
			$( "#progressbar" ).hide();
			$('#tablaPatrona').dataTable().fnAddData(response);
			//setData(response);
		}		,
		error:  function (response) {
			console.log(response);
			alert(response);
		}
	});			

});

function showEditarPatrona(idPatrona){
	top.frames['main'].location="../patronas/actualizar_patrona.jsp?id="+idPatrona; 
}
