//***************************************************************
//Function que muestra los datos de las Patronas en un dataTable*
//***************************************************************
$(document).ready(function() {
	oTablePatronas=$('#tablaPatrona').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/patrona/getpatronasaeditar',
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

//********************************************************************
//Redirecciona al jsp EditarPatrona mandando como parametro idPatrona*
//********************************************************************
function showEditarPatrona(idPatrona){
	top.frames['main'].location="../patronas/actualizar_patrona.jsp?id="+idPatrona; 
}

//***********************************
//Redirecciona al jsp GuardarPatrona*
//***********************************
function showAgregarPatrona(){
	top.frames['main'].location="../patronas/agregar_patrona.jsp"; 
}
