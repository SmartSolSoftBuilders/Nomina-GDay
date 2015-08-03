$(document).ready(function() {
	
});

function agregarMunicipio(){	
	$.ajax({
		data:{			
			nombreMunicipio:$("#nombremunicipio").val()
		},
		sync: true,
		type:  'post',
		url:   '../../mvc/catalogos/agregarmunicipio',
		dataType:  'json',
		beforeSend: function () {						
		},
		success:  function () {
			top.frames['mainFrame'].location="../catalogos/mant_municipios.jsp";			
			},
		error: function(e){
			alert("error"+e);
		}
		});
}