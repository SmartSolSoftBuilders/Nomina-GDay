$(document).ready(function() {
	oTableNominas=$('#tablaNomina').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/nomina/getnominas',
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
			$('#tablaNomina').dataTable().fnAddData(response);
			//setData(response);
		}		,
		error:  function (response) {
			console.log(response);
			alert(response);
		}
	});			

});

function showEditarNomina(idNomina){
	top.frames['main'].location="../nominas/actualizar_nomina.jsp?id="+idNomina; 	
}
