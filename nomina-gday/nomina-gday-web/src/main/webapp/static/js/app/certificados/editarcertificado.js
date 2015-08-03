var idAfiliado=0;
var idCertificadoAfiliado=0;

$(document).ready(function() {
		$( "#fechavigencia" ).datepicker();
		idCertificadoAfiliado=getParameter('id');				
		$("#idafiliado").val(idCertificadoAfiliado);
		if (idCertificadoAfiliado==null || idCertificadoAfiliado == 0){
			alert("ERROR! No se tiene el Afiliado del certificado!");
			top.frames['mainFrame'].location="../afiliados/mantenimiento.jsp";
		}					
		//Se obtiene los datos del certificado, si no existe, se muestra el formulario
		if (idCertificadoAfiliado!=0){	
			$.ajax({
				data: {												 
					"afiliado.idAfiliado" :idCertificadoAfiliado
				},
				async: false,
				type:  'post',
				url:   '../../mvc/certificadoafiliado/getcertificadobyidcer',
				dataType:  'json',
				beforeSend: function () {
					$("#resultado").html("Procesando, espere por favor...");
				},
				success:  function (response) {
					//	$("#resultado").html("");									
					//oTable = $('#tablaEscuelas').dataTable();											
					setDataCertificado(response);
					idCertificadoAfiliado=$("#idcertificadoafiliado").val();
				}				
			});
		}						
				
		
		//Se crean los diálogos
		$( "#divAviso" ).dialog({
			autoOpen: false,
			resizable:false,
		    height: 220,
		    width: 220,
		    modal: true,
		    buttons: {
		    	Cerrar: function() {
		    		$( this ).dialog( "close" );		    						    		
		        }		       	
		    }
		});		

	});


function guardarCertificadoAprob(){	 	
	//if ($('*',window.parent.mainFrame.document.formCertificado).validationEngine('validate') == true){
	$.ajax({
		data: {
			"idCertificadoAfiliado" : idCertificadoAfiliado,
			"numeroCertificadoAfiliado" : $("#numerocertificado").val(),
			"estadoCertificadoAfiliado" : $("#estado").val(),
			"fechaInicioVigenciaCertificadoAfiliado" : $("#fechavigencia").val(),
			"sumaAseguradaCertificadoAfiliado" :$("#sumaasegurada").val(),
			"afiliado.idAfiliado" : $("#idafiliado").val()
		},
		dataType:'json',
		url:   '../../mvc/certificadoafiliado/guardarcertaprob',
		type:  'post',		
		beforeSend: function () {
			//$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {																	
			//$("#resultado").html("");						
			$( "#divAvisoMensaje" ).html("El Certificado se modificó correctamente");
			$( "#divAviso" ).dialog('open');
			$("#beneficiarios").show();
			$("#asegurados").show();
		}		,	
		error: function (response) {																	
			alert(response);
		}		
	});
	//}	
} 



function setDataCertificado(datos){
	var data=eval(datos);
	if (datos.idCertificadoAfiliado!=0){		
		$("#numerocertificado").val(data.numeroCertificadoAfiliado);
		$("#estado").val(data.estadoCertificadoAfiliado);
		$("#fechavigencia").val(data.fechaInicioVigenciaCertificadoAfiliado);
		$("#sumaasegurada").val("250000");
		$("#sumaasegurada2").val("50000");
		$("#sumaasegurada3").val("300000");
		//$("#idafiliado").val(idAfiliado);
		//alert(data.afiliado.idAfiliado);
		$("#idcertificadoafiliado").val(data.idCertificadoAfiliado);
		$("#divLabelCertificado").html("Certificado:"+data.idCertificadoAfiliado);
	}
	else{
		$("#divLabelCertificado").html("Este afiliado aún no tiene certificado. Llene de alta los siguientes datos para crear el Certificado:");
	}
}


function getParameter(parameter){
	// Obtiene la cadena completa de URL
	var url = location.href;
	/* Obtiene la posicion donde se encuentra el signo ?, 
	ahi es donde empiezan los parametros */
	var index = url.indexOf("?");
	/* Obtiene la posicion donde termina el nombre del parametro
	e inicia el signo = */
	index = url.indexOf(parameter,index) + parameter.length;
	/* Verifica que efectivamente el valor en la posicion actual 
	es el signo = */ 
	if (url.charAt(index) == "="){
	// Obtiene el valor del parametro
	var result = url.indexOf("&",index);
	if (result == -1){result=url.length;};
	// Despliega el valor del parametro
	return url.substring(index + 1,result);
	}
} 
