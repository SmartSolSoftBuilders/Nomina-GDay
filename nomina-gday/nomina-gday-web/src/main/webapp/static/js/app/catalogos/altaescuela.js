$(document).ready(function() {
	//Se cargan los combos
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/catalogos/tipoescuelas',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {
			//$("#resultado").html("");									
			//oTable = $('#tablaEscuelas').dataTable();
			$("#tipoescuelacombo").append("<option value='0'>Seleccione...</option>");
			 $.each(response, function(i,item2){
	                $("#tipoescuelacombo").append("<option value='"+item2.idTipoEscuela+"'>"+item2.descripcionTipoEscuela+"</option>");
	         });			
		}			
	});
	//Se llenan los combos
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/catalogos/municipios',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {
			//$("#resultado").html("");									
			//oTable = $('#tablaEscuelas').dataTable();
			$("#municipiocombo").append("<option value='0'>Seleccione...</option>");
			 $.each(response, function(i,item2){
	                $("#municipiocombo").append("<option value='"+item2.nombreMunicipio+"'>"+item2.nombreMunicipio+"</option>");
	         });			
		}			
	});					
});

function agregarEscuela(){	
	$.ajax({
		data:{	    							
			"nombreEscuela":$("#nombreescuela").val(),		
			"tipoEscuela.idTipoEscuela":$("#tipoescuelacombo").val(), 
			"direccionEscuela":$("#direccionescuela").val(),
			"coloniaEscuela":$("#coloniaescuela").val(),
			"cpEscuela":$("#cpescuela").val(),
			"municipioEscuela":$("#municipiocombo").val(),
			"entidadEscuela":$("#entidadescuela").val(),
			"ciudadEscuela":$("#ciudadescuela").val(),
			"turnoEscuela":$("#turnoescuela").val()
		},
		sync: true,
		type:  'post',
		url:   '../../mvc/catalogos/guardarescuela',
		dataType:  'json',
		beforeSend: function () {	    					    				
		},
		success:  function (response) {
			//$("#resultado").html("");									
			//oTable = $('#tablaEscuelas').dataTable();
			top.frames['mainFrame'].location="../catalogos/mant_escuelas.jsp";	    				
			}			
		});
}