function login(){
	var user = $("#user");
	var password=$("#password").val();	
	/*$.ajax({
		sync: true,
		data:  {"user":password,"password":password},
		url:   'j_spring_security_check ',
		type:  'post',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {																	
			$("#divlogin").hide();
			$("#divok").show();
		}			
	});*/			
	$("#divlogin").hide();
	$("#divok").show();
} 
