var oTable;
var idAfiliado=getParameter('id');
var inversionistaAfiliado=getParameter('id2');

$(document).ready(function() {
	oTableCuentaFAM=$('#tablaCuentaFAM').dataTable();
	/*$.ajax({		
		sync: true,
		type:  'post',
		data:{"afiliado.idAfiliado":idAfiliado},
		url:   '../../mvc/famahorro/getmovscuentafam',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {
			//$("#resultado").html("");									
			//oTable = $('#tablaEscuelas').dataTable();		
			setData(response);
		}			
	});*/
	if (inversionistaAfiliado==0){
		$.ajax({		
		sync: true,
		type:  'post',
		data:{"idAfiliado":idAfiliado},
		url:   '../../mvc/afiliado/obtenercuentasfamahorroshow',
		dataType:  'json',
		beforeSend: function () {			
			$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (data) {
			console.log("Se obtienen datos fam ahorro");
			console.log(data);
			for (count=0;count<data.length;count ++){		
				 $('#cuentasfam').append('<option value='+data[count].idCuentaFamAhorro+'>'+data[count].idCuentaFamAhorro+'</option>');		
			}	
			/*$("#divcuenta").html("CUENTA:"+response.idCuentaFamAhorro
			 * +"<br>Fecha Apertura:"+response.fechaApertura);
			$("#hidfechaapertura").val(response.fechaApertura);
			$("#divsaldo").html("SALDO:"+response.saldo);*/
		},
		error:  function (response) {
			console.log(response);			
		}
	});
	}
	else
		$("#movFamAhorroDiv").hide();
	$.ajax({		
		sync: true,
		type:  'post',
		data:{"afiliado.idAfiliado":idAfiliado},
		url:   '../../mvc/famahorro/getcuentasinvbyidafiliado',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {
			setDataInv(response);
		}			
	});
	$( "#divRegistroMov" ).dialog({
		autoOpen: false,
	    height: 200,
	    width: 400,
	    modal: true,
	    buttons: {
	    	Aceptar: function() {
	    		guardarMov();
	    		//top.frames['mainFrame'].location="../famahorro/movimientos.jsp?id="+idAfiliado;
	    		$( this ).dialog( "close" );	    		
    		},
	    	Cancel: function() {
	    		$( this ).dialog( "close" );
		    		}
	        },
	       	close: function() {
	       		//var anSelected = fnGetSelected( oTableCuentaFAM );				    		
	    		//$("#escuela").val(anSelected[0].cells[1].innerText);	    		
	       	}
	});
	$( "#divRegistroMovInv" ).dialog({
		autoOpen: false,
	    height: 200,
	    width: 400,
	    modal: true,
	    buttons: {
	    	Aceptar: function() {
	    		guardarMovInv();
	    		$( this ).dialog( "close" );
    		},
	    	Cancel: function() {
	    		$( this ).dialog( "close" );
		    		}
	        },
	       	close: function() {
	       		var anSelected = fnGetSelected( oTableCuentaFAM );				    		
	    		//$("#escuela").val(anSelected[0].cells[1].innerText);	    		
	       	}
	});
				
	/* Add a click handler to the rows - this could be used as a callback */
	$("#tablaCuentaFAM tbody").click(function(event) {
		$(oTableCuentaFAM.fnSettings().aoData).each(function (){
		$(this.nTr).removeClass('row_selected');
		});
	$(event.target.parentNode).addClass('row_selected');
		});
				
	$("#tablaCuentaFAM tbody").click(function(event) {
		$(oTableCuentaFAM.fnSettings().aoData).each(function (){
		$(this.nTr).removeClass('row_selected');
		});
	$(event.target.parentNode).addClass('row_selected');					
		});												
	});

function fnGetSelected( oTableLocal ){
	var aReturn = new Array();
	if (oTableLocal!=null){
		var aTrs = oTableLocal.fnGetNodes();				
		for ( var i=0 ; i<aTrs.length ; i++ ){
			if ( $(aTrs[i]).hasClass('row_selected') ){
				aReturn.push( aTrs[i] );
			}
		}	
	}
	return aReturn;
}

function guardarMov(){
	var validar=true;
	if ($("#tipomovimiento").val()=="RETIRO"){
		var fechaApertura=$("#hidfechaapertura").val();
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1;	
		var yyyy = today.getFullYear();
		if(dd<10){
			dd='0'+dd
		} 
		if(mm<10){
			mm='0'+mm
		} 
		today = yyyy+'-'+mm+'-'+dd;
		//alert(today);
		//alert(fechaApertura);	
		fechaApertura=suma6Meses(fechaApertura);
		if (Date.parse(today)<Date.parse(fechaApertura)){
			validar=false;
		}		
	}
	if (!validar){
		alert("No es posible realizar el retiro. La fecha de antiguedad de la cuenta es menor a 6 meses");		
	}
	else{		
		var dataFam = {"idMovimientoFamAhorro":$("#cuentasfam").val(),
		"tipoMovimientoFamAhorro":$("#tipomovimiento").val(),
		"montoMovimientoFamAhorro":$("#monto").val(),
		"documentoRefMovimientoFamAhorro":$("#documentoref").val()
		};
		$.ajax({			
			data: dataFam,			
			dataType:'json',
			url:   '../../mvc/famahorro/guardarmovimiento',
			type:  'post',		
			beforeSend: function () {		
				console.log("GuardarMovimiento");
				console.log(dataFam);
			},
			success:  function (response) {	
				alert("Agregado en forma correcta!");
				getCuentasFam();
				//$("#resultadoGuardar").html("Se agregó el afiliado en forma correcta!<a href='#' onclick='procederCertificado()'>Generar Certificado</a>");			
			},	
			error: function (response) {
				console.log(response);
				//alert("ERROR!");getCuentasFam();				
			}		
		});	
	}
}

function guardarMovInv(){
	var idCuentaInv=$('#cuentasinv').val();
	if (idCuentaInv!=""){
		$.ajax({
		data: {
			"idMovimientoFamAhorroInversion":idCuentaInv,
			"tipoMovimientoFamAhorro":$("#tipomovimientoinv").val(),
			"montoMovimientoFamAhorro":$("#montoinv").val(),
			"documentoRefMovimientoFamAhorro":$("#documentorefinv").val()
		},
		dataType:'json',
		url:   '../../mvc/famahorro/guardarmovinv',
		type:  'post',		
		beforeSend: function () {			
		},
		success:  function (response) {	
			alert("Agregado en forma correcta!");
			getCuentasInv();
			//$("#resultadoGuardar").html("Se agregó el afiliado en forma correcta!<a href='#' onclick='procederCertificado()'>Generar Certificado</a>");			
		}		,	
		error: function (response) {
			alert("ERROR!")			
		}		
	});	
	}
}

function procesaDatosAfiliado2(datos){
	var data=eval(datos);		
	$("#saldo").val(data.saldo);
	$("#fechacontrato").val(data.fechaApertura);
	$("#asalariado").val(data.asalariado);
	$("#actividadempresarial").val(data.actividadEmpresarial);
	$("#sinactividadempresarial").val(data.actividadEconomica);
	$("#estatuslaboral").val(data.estatusLaboral);
	$("#montoapertura").val(data.montoApertura);
	$("#porcentajeahorro").val(data.porcentajeAhorro);											
	$("#frecuenciadepositos").val(data.frecuenciaDepositos);
	$("#frecuenciaretiros").val(data.frecuenciaRetiros);
	$("#procedenciarecursos").val(data.procedenciaNegocio);		
	$("#apppersonaauto").val(data.benefOperadorCuentaFamAhorro.apellidoPaternoBenefCuentaFamAhorro);
	$("#apmpersonaauto").val(data.benefOperadorCuentaFamAhorro.apellidoMaternoBenefCuentaFamAhorro);
	$("#nombrepersonaauto").val(data.benefOperadorCuentaFamAhorro.nombreBenefCuentaFamAhorro);
	$("#rfcpersonaauto").val(data.benefOperadorCuentaFamAhorro.rfcBenefCuentaFamAhorro);
	$("#residenciapersonaauto").val(data.benefOperadorCuentaFamAhorro.paisResidenciaBenefCuentaFamAhorro);
	$("#estadocivilpersonaauto").val(data.benefOperadorCuentaFamAhorro.estadoCivilBenefCuentaFamAhorro);
	$("#fechanacimientopersonaauto").val(data.benefOperadorCuentaFamAhorro.fechaNacimientoBenefCuentaFamAhorro);
	$("#parentescopersonauto").val(data.benefOperadorCuentaFamAhorro.parentescoBenefCuentaFamAhorro);
	$("#nacionalidadpersonaauto").val(data.benefOperadorCuentaFamAhorro.nacionalidadBenefCuentaFamAhorro);	
}

function procesaDatosAfiliado(datos){
	var data=eval(datos);	
	$("#nombre").val(data.nombreAfiliado);		
	$("#nacionalidad").val(data.nacionalidadAfiliado);
	$("#app").val(data.appPaternoAfiliado);
	$("#apm").val(data.appMaternoAfiliado);
	$("#estadocivil").val(data.estadoCivilAfiliado);
	$("#rfc").val(data.rfcAfiliado);
	$("#fechanacimiento").val(data.fechaNacimientoAfiliado);
	$("#domicilio").val(data.direccionAfiliado);
	$("#colonia").val(data.coliniaAfiliado);
	$("#cp").val(data.cpAfiliado);
	$("#entidad").val(data.entidadAfiliado);
	$("#puesto").val(data.puestoAfiliado);
	$("#antiguedad").val(data.antiguedadAfiliado);
	$("#telparticular").val(data.telParticularAfiliado);
	$("#telcelular").val(data.telCelularAfiliado);
	$("#compania").val(data.companiatelAfiliado);
	$("#email").val(data.emailAfiliado);
	$("#municipio").val(data.municipioAfiliado);
	$("#escuela").val(data.escuelaAfiliado);
}



function guardarContrato(){
	$.ajax({
		data: {
			"afiliado.idAfiliado":idAfiliado,
			"saldo":$("#montoapertura").val(),
			"fechaApertura":$("#fechacontrato").val(),
			"asalariado":$("#asalariado").val(),
			"actividadEmpresarial":$("#actividadempresarial").val(),
			"actividadEconomica":$("#sinactividadempresarial").val(),
			"estatusLaboral":$("#estatuslaboral").val(),
			"montoApertura":$("#montoapertura").val(),
			"porcentajeAhorro":$("#porcentajeahorro").val(),											
			"frecuenciaDepositos":$("#frecuenciadepositos").val(),
			"frecuenciaRetiros":$("#frecuenciaretiros").val(),
			"procedenciaNegocio":$("#procedenciarecursos").val(),
			"benefOperadorCuentaFamAhorro.operadorBenefCuentaFamAhorro":false,
			"benefOperadorCuentaFamAhorro.apellidoPaternoBenefCuentaFamAhorro":$("#apppersonaauto").val(),
			"benefOperadorCuentaFamAhorro.apellidoMaternoBenefCuentaFamAhorro":$("#apmpersonaauto").val(),
			"benefOperadorCuentaFamAhorro.nombreBenefCuentaFamAhorro":$("#nombrepersonaauto").val(),
			"benefOperadorCuentaFamAhorro.rfcBenefCuentaFamAhorro":$("#rfcpersonaauto").val(),
			"benefOperadorCuentaFamAhorro.paisResidenciaBenefCuentaFamAhorro":$("#residenciapersonaauto").val(),
			"benefOperadorCuentaFamAhorro.estadoCivilBenefCuentaFamAhorro":$("#estadocivilpersonaauto").val(),
			"benefOperadorCuentaFamAhorro.fechaNacimientoBenefCuentaFamAhorro":$("#fechanacimientopersonaauto").val(),
			"benefOperadorCuentaFamAhorro.parentescoBenefCuentaFamAhorro":$("#parentescopersonauto").val(),
			"benefOperadorCuentaFamAhorro.nacionalidadBenefCuentaFamAhorro":$("#nacionalidadpersonaauto").val()		
		},
		dataType:'json',
		url:   '../../mvc/famahorro/guardar',
		type:  'post',		
		beforeSend: function () {			
		},
		success:  function (response) {	
			alert("Agregado en forma correcta!");
			//$("#resultadoGuardar").html("Se agregó el afiliado en forma correcta!<a href='#' onclick='procederCertificado()'>Generar Certificado</a>");			
		}		,	
		error: function (response) {
			alert("ERROR!")			
		}		
	});		
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

function setData(data){
	var count=0;			
	for (count=0;count<data.length;count ++){		
		 $('#tablaCuentaFAM').dataTable().fnAddData( [
		      data[count].idMovimientoFamAhorro,
		      data[count].tipoMovimientoFamAhorro,
		      data[count].montoMovimientoFamAhorro,
		      data[count].documentoRefMovimientoFamAhorro,		      				
		      data[count].fechaMovimientoFamAhorro
			] 
		);
	}	
}

function setDataInv(data){
	var count=0;			
	for (count=0;count<data.length;count ++){		
		 $('#cuentasinv').append('<option value='+data[count].idCuentaFamAhorroInversion+'>'+data[count].idCuentaFamAhorroInversion+'</option>');		
	}	
}
function registrarMovimiento(){
	$( "#divRegistroMov" ).dialog( "open" );
}
function registrarMovimientoInv(){
	$( "#divRegistroMovInv" ).dialog( "open" );
}

function getCuentasInv(){
	oTableCuentaFAMInv=$('#tablaCuentaFAMInv').dataTable();
	var idCuentaInv=$('#cuentasinv').val();
	$.ajax({		
		sync: true,
		type:  'post',
		data:{"idCuentaFamAhorroInversion":idCuentaInv},
		url:   '../../mvc/famahorro/getmovscuentafaminv',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {			
			setDataMovsInv(response);
		}			
	});
}

function getCuentasFam(){
	oTableCuentaFAM=$('#tablaCuentaFAM').dataTable();
	var idCuentaFam=$('#cuentasfam').val();	
	$.ajax({		
		sync: true,
		type:  'post',
		data:{"idCuentaFamAhorro":idCuentaFam},
		url:   '../../mvc/famahorro/getmovscuentafamahorrobyid',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {					
			setDataMovs(response);			
		},
		error:  function (response) {
			alert("ERROR!"+response)
		}
	});
}

function setDataMovsInv(data2){
	var count=0;	
	oTableCuentaFAMInv=$('#tablaCuentaFAMInv').dataTable().fnClearTable();
	for (count=0;count<data2.length;count ++){		
		 $('#tablaCuentaFAMInv').dataTable().fnAddData( [
		      data2[count].idMovimientoFamAhorroInversion,
		      data2[count].tipoMovimientoFamAhorro,
		      data2[count].montoMovimientoFamAhorro,
		      data2[count].documentoRefMovimientoFamAhorro,		      				
		      data2[count].fechaMovimientoFamAhorro
			]  
		);
	}
}

function setDataMovs(data2){
	var count=0;	
	//alert(data2.length);
	oTableCuentaFAM=$('#tablaCuentaFAM').dataTable().fnClearTable();
	for (count=0;count<data2.length;count ++){		
		 $('#tablaCuentaFAM').dataTable().fnAddData( [
		      data2[count].idMovimientoFamAhorro,
		      data2[count].tipoMovimientoFamAhorro,
		      "$"+parseFloat(data2[count].montoMovimientoFamAhorro),
		      data2[count].documentoRefMovimientoFamAhorro,		      				
		      data2[count].fechaMovimientoFamAhorro
			]  
		);
	}
	$.ajax({		
		sync: true,
		type:  'post',
		data:{"idCuentaFamAhorro":$('#cuentasfam').val(),
			  "afiliado.idAfiliado":idAfiliado
			},
		url:   '../../mvc/famahorro/getfamahorrobyidfamahorro',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
		},
		success:  function (response) {					
			$("#divcuenta").html("CUENTA:"+response.idCuentaFamAhorro+"<br>Fecha Apertura:"+response.fechaApertura);
			//$("#hidfechaapertura").val(response.fechaApertura);
			$("#divsaldo").html("SALDO:"+response.saldo);			
		},
		error:  function (response) {
			alert("ERROR!"+response)
		}
	});
}


function fechaPosterior(fechaActual,fechaIni){
    //cambiarian lo que hay dentro del getElement... por los elementos que contienen las fechas a validar
    // la fecha debe tener el formato siguiente dd/mm/yyyy
    var fechaInicio = fechaIni;
    var fechaFin = fechaActual;
    var anio = parseInt(fechaInicio.value.substring(6,10));
    var mes = fechaInicio.value.substring(3,5);
    var dia = fechaInicio.value.substring(0,2);
    var c_anio = parseInt(fechaFin.value.substring(6,10));
    var c_mes = fechaFin.value.substring(3,5);
    var c_dia = fechaFin.value.substring(0,2);
    if(c_anio > anio)
        return(true);
    else{
        if (c_anio == anio){
            if(c_mes > mes)
                return(true);
            if(c_mes == mes)
                if(c_dia >= dia)
                    return(true);
                else
                    return(false);
            else
                return(false);
        }else
            return(false);
    }
}

function suma6Meses(fechaAntig){
	var sumarDias=parseInt(180);

	var fecha=fechaAntig;
	
	fecha=fecha.replace("-", "/").replace("-", "/");    
	
	fecha= new Date(fecha);
	fecha.setDate(fecha.getDate()+sumarDias);
	
	var anio=fecha.getFullYear();
	var mes= fecha.getMonth()+1;
	var dia= fecha.getDate();
	
	if(mes.toString().length<2){
	  mes="0".concat(mes);        
	}    
	
	if(dia.toString().length<2){
	  dia="0".concat(dia);        
	}
	return (anio+"-"+mes+"-"+dia);
}