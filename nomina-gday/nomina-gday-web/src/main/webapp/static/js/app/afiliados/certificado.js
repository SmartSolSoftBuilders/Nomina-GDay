var idAfiliado=0;
var idCertificadoAfiliado=0;

$(document).ready(function() {	
		idAfiliado=getParameter('id');				
		$("#idafiliado").val(idAfiliado);
		if (idAfiliado==null || idAfiliado == 0){
			alert("ERROR! No se tiene el Afiliado del certificado!");
			top.frames['mainFrame'].location="../afiliados/mantenimiento.jsp";
		}		
		oTable2=$('#tablaBeneficiario').dataTable({
				"bFilter": false,
				"bInfo": false,
				"bLengthChange": false				
			});		
		oTable3=$('#tablaAsegurado').dataTable({
			"bFilter": false,
			"bInfo": false,
			"bLengthChange": false				
		});		
		//Se obtiene los datos del certificado, si no existe, se muestra el formulario
		if (idAfiliado!=0){	
			$.ajax({
				data: {												 
					"afiliado.idAfiliado" :idAfiliado
				},
				async: false,
				type:  'post',
				url:   '../../mvc/certificadoafiliado/getcertificado',
				dataType:  'json',
				beforeSend: function () {
					$("#resultado").html("Procesando, espere por favor...");
				},
				success:  function (response) {
					//	$("#resultado").html("");									
					//oTable = $('#tablaEscuelas').dataTable();											
					setDataCertificado(response);
					idCertificadoAfiliado=$("#idcertificadoafiliado").val();
					$("#instrucciones").html("<H3>Para editar los beneficiarios y afiliados del certificado, vaya a la sección POLIZA COLECTIVA del menú de la izquierda y seleccione 'Mantenimiento de Certificados' y seleccione el certificado: "+idCertificadoAfiliado);
				}				
			});
		}						
				
		if (idCertificadoAfiliado!=0){	
			$.ajax({
				data: {
					"idBeneficiario":idCertificadoAfiliado					
				},
				async: false,
				type:  'post',
				url:   '../../mvc/certificadoafiliado/getbeneficiarios',
				dataType:  'json',
				beforeSend: function () {
					$("#resultado").html("Procesando, espere por favor...");
				},
				success:  function (response) {
					//	$("#resultado").html("");									
					//oTable = $('#tablaEscuelas').dataTable();											
					setDataBeneficiarios(response);
				}				
			});
		}
		if (idCertificadoAfiliado!=0){	
			$.ajax({
				data: {
					"idAseguradoBeneficioAdicional":idCertificadoAfiliado					
				},
				async: false,
				type:  'post',
				url:   '../../mvc/certificadoafiliado/getasegurados',
				dataType:  'json',
				beforeSend: function () {					
				},
				success:  function (response) {
					//alert(response);
					setDataAseguradosBeneficio(response);
				}
			});
		}
		
		$("#beneficiarios").hide();
		$("#asegurados").hide();
		
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

		$( "#divBeneficiario" ).dialog({
			autoOpen: false,
			resizable:false,
		    height: 420,
		    width: 650,
		    modal: true,
		    buttons: {
		    	Agregar: function() {
		    		agregarBeneficiarioAJAX( $("#idcertificadoafiliado").val());
		    		$( this ).dialog( "close" );		    			
		    			$('#tablaBeneficiario').dataTable().fnAddData( [				
		    		         $("#nombrebeneficiario").val(),
		    		         $("#appbeneficiario").val(),
		    		         $("#apmbeneficiario").val(),
		    		         $("#parentescobeneficiario").val(),
		    		         $("#fechanacimientobeneficiario").val(),		    		         
		    		         $("#edadbeneficiario").val()
		    		       ] 
		    		  );			    			
		    		}
		        },
		       	close: function() {
		       		//var anSelected = fnGetSelected( oTable );				    		
		    		//$("#escuela").val(anSelected[0].cells[1].innerText);
		    		//$("#idescuela").val(anSelected[0].cells[0].innerText);
		       	}
		});
		/* Add a click handler to the rows - this could be used as a callback */
		$("#tablaBeneficiario tbody").click(function(event) {
			$(oTable2.fnSettings().aoData).each(function (){
				$(this.nTr).removeClass('row_selected');
			});
			$(event.target.parentNode).addClass('row_selected');
		});
		
		$("#tablaBeneficiario tbody").click(function(event) {
			$(oTable2.fnSettings().aoData).each(function (){
				$(this.nTr).removeClass('row_selected');
			});
			$(event.target.parentNode).addClass('row_selected');					
		});
						
		$( "#divAsegurado" ).dialog({
			autoOpen: false,
		    height: 420,
		    width: 650,
		    modal: true,
		    buttons: {
		    	Agregar: function() {		    			    		
		    		//if ($('*',window.parent.mainFrame.document.formAsegurado).validationEngine('validate') == true){
		    		agregarAseguradoBeneficioAdicionalAJAX( $("#idcertificadoafiliado").val());
		    			$( this ).dialog( "close" );
		    				$('#tablaAsegurado').dataTable().fnAddData( [				
                                  $("#nombreasegurado").val(),
                                  $("#appasegurado").val(),
                                  $("#apmasegurado").val(),
                                  $("#parentescoasegurado").val(),
                                  $("#fechanacimientoasegurado").val(),		    		         
                                  $("#edadasegurado").val()
                                  ] 
		    				);
		    			}
		    		//}
		        },
		        Cerrar: function() {
	    			$( this ).dialog( "close" );
		        },
		       	close: function() {
		       		//var anSelected = fnGetSelected( oTable );				    		
		    		//$("#escuela").val(anSelected[0].cells[1].innerText);
		    		//$("#idescuela").val(anSelected[0].cells[0].innerText);
		       	}
		});
		/* Add a click handler to the rows - this could be used as a callback */
		$("#tablaAsegurado tbody").click(function(event) {
			$(oTable3.fnSettings().aoData).each(function (){
				$(this.nTr).removeClass('row_selected');
			});
			$(event.target.parentNode).addClass('row_selected');
		});
		
		$("#tablaAsegurado tbody").click(function(event) {
			$(oTable3.fnSettings().aoData).each(function (){
				$(this.nTr).removeClass('row_selected');
			});
			$(event.target.parentNode).addClass('row_selected');					
		});

	});

function agregarAseguradoBeneficioAdicionalAJAX(id){
	$.ajax({
		data: {							
			"nombreAseguradoBeneficioAdicional":$("#nombreasegurado").val(),
		    "appAseguradoBeneficioAdicional":$("#appasegurado").val(),
		    "apmAseguradoBeneficioAdicional":$("#apmasegurado").val(),
		    "parentescoBeneficiario":$("#parentescoasegurado").val(),
		    "fechaNacimientoAseguradoBeneficioAdicional":$("#fechanacimientoasegurado").val(),		    		         
		    "edadAseguradoBeneficioAdicional":$("#edadasegurado").val(),		    
			"certificadoAfiliado.idCertificadoAfiliado" :id
		},
		dataType:'json',
		url:   '../../mvc/certificadoafiliado/guardarasegurado',
		type:  'post',		
		beforeSend: function () {
			//$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {																	
			$( "#divAvisoMensaje" ).html("El Asegurado se agregó correctamente");
			$( "#divAviso" ).dialog('open');		
		},	
		error: function (response) {																	
			alert(response);
		}		
	});
}

function agregarBeneficiarioAJAX(id){	
	$.ajax({
		data: {			
			"nombreBeneficiario":$("#nombrebeneficiario").val(),
		    "appBeneficiario":$("#appbeneficiario").val(),
		    "apmBeneficiario":$("#apmbeneficiario").val(),
		    "parentescoBeneficiario":$("#parentescobeneficiario").val(),
		    "fechaNacimientoBeneficiario":$("#fechanacimientobeneficiario").val(),		    		         
		    "edadBeneficiario":$("#edadbeneficiario").val(),
		    "revocableBeneficiario":"1", 
		    "irrevocableBeneficiario":"1",
			"certificadoAfiliado.idCertificadoAfiliado" :id
		},
		dataType:'json',
		url:   '../../mvc/certificadoafiliado/guardarbeneficiario',
		type:  'post',		
		beforeSend: function () {
			//$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {																	
			$( "#divAvisoMensaje" ).html("El Beneficiario se agregó correctamente");
			$( "#divAviso" ).dialog('open');		
		},	
		error: function (response) {																	
			alert(response);
		}		
	});
}

function guardarCertificado(){	 
	//if ($('*',window.parent.mainFrame.document.formCertificado).validationEngine('validate') == true){
	$.ajax({
		data: {
			"numeroCertificadoAfiliado" : $("#numerocertificado").val(),
			"estadoCertificadoAfiliado" : $("#estado").val(),
			"fechaInicioVigenciaCertificadoAfiliado" : $("#fechavigencia").val(),
			"sumaAseguradaCertificadoAfiliado" :$("#sumaasegurada").val(),
			"afiliado.idAfiliado" : $("#idafiliado").val()
		},
		dataType:'json',
		url:   '../../mvc/certificadoafiliado/guardar',
		type:  'post',		
		beforeSend: function () {
			//$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {																	
			//$("#resultado").html("");						
			$( "#divAvisoMensaje" ).html("El Certificado se agregó correctamente");
			$( "#divAviso" ).dialog('open');
			$("#instrucciones").html("PARA EDITAR BENEFICIARIOS Y ASEGURADOS VAYA A LA SECCIÓN DEL MENÚ DE LA IZQUIERDA:<BR>POLIZA COLECTIVA->MANTENIMIENTO DE CERTIFICADOS");
			//$("#beneficiarios").show();
			//$("#asegurados").show();
		}		,	
		error: function (response) {																	
			alert(response);
		}		
	});
	//}	
} 

function agregarAsegurado(){	
	$( "#divAsegurado" ).dialog( "open" );			
}

function agregarBeneficiario(){
    $( "#divBeneficiario" ).dialog( "open" );			
}

function modificarBeneficiario(){
	$( "#divBeneficiario" ).dialog( "open" );
	var anSelected = fnGetSelected( oTable2 );	
	$("#nombrebeneficiario").val(anSelected[0].cells[0].innerText);	
	$("#appbeneficiario").val(anSelected[0].cells[1].innerText);
	$("#apmbeneficiario").val(anSelected[0].cells[2].innerText);
}
function getData(data){
	var count=0;	
	for (count=0;count<data.length;count ++){	
		 $('#tablaEscuelas').dataTable().fnAddData( [				
				data[count].idEscuela,
				data[count].nombreEscuela,
			] 
		);				
	}
}

function fnGetSelected( oTableLocal ){
	var aReturn = new Array();
	var aTrs = oTableLocal.fnGetNodes();				
	for ( var i=0 ; i<aTrs.length ; i++ ){
		if ( $(aTrs[i]).hasClass('row_selected') ){
			aReturn.push( aTrs[i] );
		}
	}				
	return aReturn;
}

function setDataCertificado(datos){
	var data=eval(datos);
	if (datos.idCertificadoAfiliado!=0){		
		$("#numerocertificado").val(data.numeroCertificadoAfiliado),
		$("#estado").val(data.estadoCertificadoAfiliado),
		$("#fechavigencia").val(data.fechaVigenciaCertificadoAfiliado),
		$("#sumaasegurada").val(data.sumaAseguradaCertificadoAfiliado),
		$("#idafiliado").val(idAfiliado);
		$("#idcertificadoafiliado").val(data.idCertificadoAfiliado);
		$("#divLabelCertificado").html("Certificado:"+data.idCertificadoAfiliado);
	}
	else{
		$("#divLabelCertificado").html("Este afiliado aún no tiene certificado. Llene los siguientes datos para crear el Certificado:");
		$("#beneficiarios").hide();
		$("#asegurados").hide();
	}
}

function setDataBeneficiarios(data){	
	var count=0;	
	for (count=0;count<data.length;count ++){	
		$('#tablaBeneficiario').dataTable().fnAddData( [				
		       data[count].nombreBeneficiario,		       
		       data[count].appBeneficiario,
		       data[count].apmBeneficiario,
		       data[count].parentescoBeneficiario,
		       data[count].fechaNacimientoBeneficiario,
		       data[count].edadBeneficiario
		  ] 
		);
	}
}

function setDataAseguradosBeneficio(data){	
	var count=0;		
	if (data.length>0){
		for (count=0;count<data.length;count ++){	
			$('#tablaAsegurado').dataTable().fnAddData( [				
		       data[count].nombreAseguradoBeneficioAdicional,		       
		       data[count].appAseguradoBeneficioAdicional,
		       data[count].apmAseguradoBeneficioAdicional,
		       data[count].parentescoAseguradoBeneficioAdicional,
		       data[count].fechaNacimientoAseguradoBeneficioAdicional,
		       data[count].edadAseguradoBeneficioAdicional
		       ] 
			);
		}
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
