var idAfiliado=0;
var idCertificadoAfiliado=0;
var oTable2;		
var oTable3;

$(document).ready(function() {
		$( "#fechanacimientobeneficiario" ).datepicker({ dateFormat: "yy-mm-dd" });
		$( "#modfechanacimientobeneficiario" ).datepicker({ dateFormat: "yy-mm-dd" });
		$( "#fechanacimientoasegurado" ).datepicker({ dateFormat: "yy-mm-dd" });
		$( "#modfechanacimientoasegurado" ).datepicker({ dateFormat: "yy-mm-dd" });
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
					"idCertificado":idAfiliado,
					"afiliado.idAfiliado" :idAfiliado
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
				
		if (idCertificadoAfiliado!=0){	
			getBeneficiariosAJAX();
		}
		if (idCertificadoAfiliado!=0){	
			getAseguradosBeneficioAdicionalAJAX();
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

		$( "#divBeneficiario" ).dialog({
			autoOpen: false,
			resizable:false,
		    height: 420,
		    width: 650,
		    modal: true,
		    buttons: {
		    	Agregar: function() {
		    		if (validaPorcentajes($("#porcentajebeneficiario").val(),$("#hidsumaporc").val(),0)){
		    			agregarBeneficiarioModAJAX( $("#idcertificadoafiliado").val());		    			
		    			getBeneficiariosAJAX();
		    		}
		    		$( this ).dialog( "close" );		    		
		        }
		    },
		    close: function() {
		       	}
		});
		$( "#divModBeneficiario" ).dialog({
			autoOpen: false,
			resizable:false,
		    height: 420,
		    width: 650,
		    modal: true,
		    buttons: {
		    	Modificar: function() {
		    		var anSelected = fnGetSelected( oTable2 );
		    		var porBenfamod=anSelected[0].cells[8].innerText;		    		
		    		if (validaPorcentajes($("#modporcentajebeneficiario").val(),$("#modhidsumaporc").val(),parseFloat(porBenfamod))){
		    			modificarBeneficiarioAJAX( $("#idcertificadoafiliado").val());
		    			getBeneficiariosAJAX();
		    		}
		    		$( this ).dialog( "close" );
		    		}
		        },
		       	close: function() {
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
		    		agregarAseguradoBeneficioAdicionalModAJAX( $("#idcertificadoafiliado").val());
		    		getAseguradosBeneficioAdicionalAJAX();
	    			$( this ).dialog( "close" );
		    	},
		        Cancelar: function() {
	    			$( this ).dialog( "close" );
		        }
		    },	
		    close: function() {
		    }
		});
		$( "#divModAsegurado" ).dialog({
			autoOpen: false,
		    height: 420,
		    width: 650,
		    modal: true,
		    buttons: {
		    	Guardar: function() {		    			    		
		    		//if ($('*',window.parent.mainFrame.document.formAsegurado).validationEngine('validate') == true){
		    		actualizarAseguradoBeneficioAdicionalModAJAX( $("#idcertificadoafiliado").val());
		    		getAseguradosBeneficioAdicionalAJAX();
	    			$( this ).dialog( "close" );
		    	},
		        Cancelar: function() {
	    			$( this ).dialog( "close" );
		        }
		    },	
		    close: function() {
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

function actualizarAseguradoBeneficioAdicionalModAJAX(id){	
	$.ajax({
		data: {							
			"idAseguradoBeneficioAdicional":$("#modidasegurado").val(),
			"nombreAseguradoBeneficioAdicional":$("#modnombreasegurado").val(),
		    "appAseguradoBeneficioAdicional":$("#modappasegurado").val(),
		    "apmAseguradoBeneficioAdicional":$("#modapmasegurado").val(),
		    "parentescoAseguradoBeneficioAdicional":$("#modparentescoasegurado").val(),
		    "fechaNacimientoAseguradoBeneficioAdicional":$("#modfechanacimientoasegurado").val(),		    		         
		    "edadAseguradoBeneficioAdicional":$("#modedadasegurado").val()			
		},
		dataType:'json',
		url:   '../../mvc/certificadoafiliado/actualizarasegurado',
		type:  'post',		
		beforeSend: function () {
			//$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {																	
			$( "#divAvisoMensaje" ).html("El Asegurado se actualizó correctamente");			
			$( "#divAviso" ).dialog('open');		
		},	
		error: function (response) {																	
			alert(response);
		}		
	});
}


function agregarAseguradoBeneficioAdicionalModAJAX(id){	
	$.ajax({
		data: {							
			"nombreAseguradoBeneficioAdicional":$("#nombreasegurado").val(),
		    "appAseguradoBeneficioAdicional":$("#appasegurado").val(),
		    "apmAseguradoBeneficioAdicional":$("#apmasegurado").val(),
		    "parentescoAseguradoBeneficioAdicional":$("#parentescoasegurado").val(),
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

function modificarBeneficiarioAJAX(id){
	$.ajax({
		data: {			
			"idBeneficiario":$("#modidbeneficiario").val(),
			"nombreBeneficiario":$("#modnombrebeneficiario").val(),
		    "appBeneficiario":$("#modappbeneficiario").val(),
		    "apmBeneficiario":$("#modapmbeneficiario").val(),
		    "parentescoBeneficiario":$("#modparentescobeneficiario").val(),
		    "fechaNacimientoBeneficiario":$("#modfechanacimientobeneficiario").val(),		    		         
		    "edadBeneficiario":$("#modedadbeneficiario").val(),
		    "revocableBeneficiario":$("#modrevocable").val(), 
		    "irrevocableBeneficiario":$("#modirrevocable").val(),
		    "porcentajeBeneficiario":$("#modporcentajebeneficiario").val(),
		    "porcentajeBeneficiarioDos":$("#modporcentajebeneficiario2").val(),
			"certificadoAfiliado.idCertificadoAfiliado" :id
		},
		dataType:'json',
		url:   '../../mvc/certificadoafiliado/actualizarbeneficiariomod',
		type:  'post',		
		beforeSend: function () {
			//$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {																	
			$( "#divAvisoMensaje" ).html("El Beneficiario se agregó correctamente");
			getBeneficiariosAJAX();
			$( "#divAviso" ).dialog('open');		
		},	
		error: function (response) {																	
			alert(response);
		}		
	});	
}

function agregarBeneficiarioModAJAX(id){	
	$.ajax({
		data: {			
			"nombreBeneficiario":$("#nombrebeneficiario").val(),
		    "appBeneficiario":$("#appbeneficiario").val(),
		    "apmBeneficiario":$("#apmbeneficiario").val(),
		    "parentescoBeneficiario":$("#parentescobeneficiario").val(),
		    "fechaNacimientoBeneficiario":$("#fechanacimientobeneficiario").val(),		    		         
		    "edadBeneficiario":$("#edadbeneficiario").val(),
		    "revocableBeneficiario":$("#revocable").val(), 
		    "irrevocableBeneficiario":$("#irrevocable").val(),
		    "porcentajeBeneficiario":$("#porcentajebeneficiario").val(),
		    "porcentajeBeneficiarioDos":$("#porcentajebeneficiario2").val(),
			"certificadoAfiliado.idCertificadoAfiliado" :id
		},
		dataType:'json',
		url:   '../../mvc/certificadoafiliado/guardarbeneficiariomod',
		type:  'post',		
		beforeSend: function () {
			//$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {																	
			$( "#divAvisoMensaje" ).html("El Beneficiario se agregó correctamente");
			getBeneficiariosAJAX();
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
			$("#beneficiarios").show();
			$("#asegurados").show();
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

function eliminarBeneficiario(){
	var anSelected = fnGetSelected( oTable2 );
	idBeneficiario=anSelected[0].cells[9].innerText;
	if (confirm("Eliminar Beneficiario?"+idBeneficiario)==true){
		eliminarBeneficiarioModAJAX(idBeneficiario);
		getBeneficiariosAJAX();
	}		
}

function eliminarAsegurado(){
	var anSelected = fnGetSelected( oTable3 );
	idAsegurado=anSelected[0].cells[6].innerText;
	if (confirm("Eliminar Asegurado?"+idAsegurado)==true){
		eliminarAseguradoModAJAX(idAsegurado);
		getBeneficiariosAJAX();
	}		
}

function eliminarAseguradoModAJAX(idAsegurado){
	$.ajax({
		data: {						
		    "idAseguradoBeneficioAdicional":idAsegurado,			
		},
		dataType:'json',
		url:   '../../mvc/certificadoafiliado/eliminaraseguradomod',
		type:  'post',		
		beforeSend: function () {
			//$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {																	
			$( "#divAvisoMensaje" ).html("El Asegurado se eliminó correctamente");			
			getAseguradosBeneficioAdicionalAJAX();
			$( "#divAviso" ).dialog('open');		
		},	
		error: function (response) {																	
			alert(response);
		}		
	});
}
function eliminarBeneficiarioModAJAX(id){	
	$.ajax({
		data: {						
		    "idBeneficiario":id,			
		},
		dataType:'json',
		url:   '../../mvc/certificadoafiliado/eliminarbeneficiariomod',
		type:  'post',		
		beforeSend: function () {
			//$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {																	
			$( "#divAvisoMensaje" ).html("El Beneficiario se eliminó correctamente");
			getBeneficiariosAJAX();			
			$( "#divAviso" ).dialog('open');		
		},	
		error: function (response) {																	
			alert(response);
		}		
	});
}


function modificarBeneficiario(){
	$( "#divModBeneficiario" ).dialog( "open" );
	var anSelected = fnGetSelected( oTable2 );	
	$("#modnombrebeneficiario").val(anSelected[0].cells[0].innerText);
	$("#modappbeneficiario").val(anSelected[0].cells[1].innerText);
	$("#modapmbeneficiario").val(anSelected[0].cells[2].innerText);
	selectOptionByText($("#modparentescobeneficiario"),anSelected[0].cells[3].innerText);	
	$("#modfechanacimientobeneficiario").val(anSelected[0].cells[4].innerText);	
	$("#modedadbeneficiario").val(anSelected[0].cells[5].innerText);	
	$("#modporcentajebeneficiario").val(anSelected[0].cells[8].innerText);
	$("#modporcentajebeneficiario2").val(anSelected[0].cells[10].innerText);
	$("#modidbeneficiario").val(anSelected[0].cells[9].innerText);		
}

function modificarAsegurado(){
	$( "#divModAsegurado" ).dialog( "open" );
	var anSelected = fnGetSelected( oTable3 );	
	$("#modnombreasegurado").val(anSelected[0].cells[0].innerText);
	$("#modappasegurado").val(anSelected[0].cells[1].innerText);
	$("#modapmasegurado").val(anSelected[0].cells[2].innerText);
	selectOptionByText($("#modparentescoasegurado"),anSelected[0].cells[3].innerText);	
	$("#modfechanacimientoasegurado").val(anSelected[0].cells[4].innerText);	
	$("#modedadasegurado").val(anSelected[0].cells[5].innerText);		
	$("#modidasegurado").val(anSelected[0].cells[6].innerText);		
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
		$("#numerocertificado").val(data.numeroCertificadoAfiliado);
		$("#estado").val(data.estadoCertificadoAfiliado);
		$("#fechavigencia").val(data.fechaInicioVigenciaCertificadoAfiliado);
		$("#sumaasegurada").val("250000");
		$("#sumaasegurada2").val("50000");
		$("#sumaasegurada3").val("300000");
		$("#idafiliado").val(idAfiliado);
		$("#idcertificadoafiliado").val(data.idCertificadoAfiliado);
		$("#divLabelCertificado").html("<h1>Certificado:"+data.idCertificadoAfiliado+"</h1>");
	}
	else{
		$("#divLabelCertificado").html("Este afiliado aún no tiene certificado. Llene de alta los siguientes datos para crear el Certificado:");
		$("#beneficiarios").hide();
		$("#asegurados").hide();
	}
}

function setDataBeneficiarios(data){	
	var count=0;
	var sumaporcentajes=0;
	for (count=0;count<data.length;count ++){
		sumaporcentajes=sumaporcentajes+parseFloat(data[count].porcentajeBeneficiario);
		if (data[count].revocableBeneficiario==0)
			data[count].revocableBeneficiario="NO"
		else
			data[count].revocableBeneficiario="SI"
		if (data[count].irrevocableBeneficiario==0)
			data[count].irrevocableBeneficiario="NO"
		else
			data[count].irrevocableBeneficiario="SI"
		$('#tablaBeneficiario').dataTable().fnAddData( [				
		       data[count].nombreBeneficiario,		       
		       data[count].appBeneficiario,
		       data[count].apmBeneficiario,
		       data[count].parentescoBeneficiario,
		       data[count].fechaNacimientoBeneficiario,
		       data[count].edadBeneficiario,
		       data[count].revocableBeneficiario,
		       data[count].irrevocableBeneficiario,
		       data[count].porcentajeBeneficiario,
		       data[count].idBeneficiario,
		       data[count].porcentajeBeneficiarioDos
		  ] 
		);
	}
	$("#divsumaporcentajes").html(sumaporcentajes+"%");
	$("#moddivsumaporcentajes").html(sumaporcentajes+"%");
	$("#hidsumaporc").val(sumaporcentajes);	
	$("#modhidsumaporc").val(sumaporcentajes);
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
		       data[count].edadAseguradoBeneficioAdicional,
		       data[count].idAseguradoBeneficioAdicional
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

function getBeneficiariosAJAX(){
	oTable2.fnClearTable();
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
			setDataBeneficiarios(response);
		}				
	});
}

function getAseguradosBeneficioAdicionalAJAX(){	
	oTable3.fnClearTable();
	$.ajax({
		data: {
			"idAseguradoBeneficioAdicional":idCertificadoAfiliado					
		},
		async: false,
		type:  'post',
		url:   '../../mvc/certificadoafiliado/getasegurados2',
		dataType:  'json',
		beforeSend: function () {					
			$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {
			//alert(response);
			setDataAseguradosBeneficio(response);
		}
	});
}


function selectOptionByText(selectElement, targetText) {
    var $selectElement, $options, $targetOption;

    $selectElement = jQuery(selectElement);
    $options = $selectElement.find('option');
    $targetOption = $options.filter(
        function () {return jQuery(this).text() == targetText}
    );

    // We use `.prop` if it's available (which it should be for any jQuery versions above
    // and including 1.6), and fall back on `.attr` (which was used for changing DOM
    // properties in pre-1.6) otherwise.
    if (jQuery().prop) {
        $targetOption.prop('selected', true);
    } 
    else {
        $targetOption.attr('selected', 'true');
    }
}

function validaPorcentajes(val,val2,valorrenglon){	
	var porcentajebeneficiarioActual=parseFloat(val2);
	if (val=="")
		var porcentajebeneficiarioEvaluar=0;
	else
		var porcentajebeneficiarioEvaluar=parseFloat(val);	
	if (porcentajebeneficiarioEvaluar<=0){
		alert("Error: El porcentaje asignado debe ser mayor a 0%!")
		return false;
	}
	if ((porcentajebeneficiarioActual-valorrenglon)+porcentajebeneficiarioEvaluar>100){
		alert("Error: La suma de porcentajes asignado a los beneficiarios no puede ser mayor que 100%!")
		return false;
	}
	
	return true;
}	