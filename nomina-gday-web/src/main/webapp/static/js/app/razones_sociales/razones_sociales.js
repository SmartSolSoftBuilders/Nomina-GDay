$(document).ready(function() {
	oTableRazonesSociales=$('#tablaRazonSocial').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   'mvc/consultarrazonsocial/getrazonessociales',
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


function guardarGrupo() {
	console.log ($("#nombre").val());
	console.log ($("#nombreCorto").val());
		$
			.ajax({
				data : {
					"nombre" : $("#nombre").val(),
					"nombreCorto" : $("#nombreCorto").val(),
				},
				
				dataType : 'json',
				url : 'mvc/grupo/guardargrupo',
				type : 'post',
				beforeSend : function() {
				},
				success : function(response) {
					$("#resultadoGuardar")
							.html(alert("La cotizaci\u00f3n se guard\u00f3 correctamente"));
				},
				error : function(response) {
					$("#resultadoGuardar").html();
				}
			});
		}



