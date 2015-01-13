$(document).ready(function() {
	oTableRazonesSociales=$('#tablaRazonSocial').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/razonsocial/getrazonessociales',
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
			$('#tablaRazonSocial').dataTable().fnAddData(response);
			//setData(response);
		}		,
		error:  function (response) {
			alert(response);
		}
	});			

});

function showEditarRazonSocial(idRazonSocial){
	top.frames['main'].location="../razones_sociales/actualizar_razonsocial.jsp?id="+idRazonSocial; 	
}