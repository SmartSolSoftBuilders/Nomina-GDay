var oTable;
var idAfiliado=getParameter('id');
var idAfiliado2=getParameter('id2');
var montosColl= new Array();
$(document).ready(function() {
	$.ajax({
		data: {
			"idAfiliado" : idAfiliado
		},
		sync: true,
		dataType:'json',
		url:   '../../mvc/afiliado/obtenerafiliadobyid',
		type:  'post',		
		beforeSend: function () {	
		},
		success:  function (response) {
			procesaDatosAfiliado(response);			
		},	
		error: function (response) {																	
			$("#resultadoGuardar").html("Error al agregar al afiliado!");
		}		
	});
	//Se obtienen los datos de FamAhorro
	$.ajax({
		data: {
			"idCuentaFamAhorro" : idAfiliado2,
			"afiliado.idAfiliado" : idAfiliado
		},
		sync: true,
		dataType:'json',
		url:   '../../mvc/famahorro/getfamahorrobyidafiliadoall',
		type:  'post',		
		beforeSend: function () {	
		},
		success:  function (response) {			
			procesaDatosAfiliado2(response);			
		},	
		error: function (response) {																	
			$("#resultadoGuardar").html("Error al agregar al afiliado!");
		}		
	});
	
});


function showMontosDescuentosCuentaFamAhorro(){	
	var htmlVal="";
	htmlVal="<table border='1'><tr><td>Monto</td><td>Fecha</td></tr>";	
	for (i=0;i<montosColl.length; i++){
		htmlVal=htmlVal+"<tr><td>$"+montosColl[i].monto+"</td><td>"+Date(montosColl[i].fechaRegistro,"MM/DD/YYYY")+"</td></tr>";
	}
	if (montosColl.length>0)
		htmlVal=htmlVal+"</table>";	
	$("#contentMovsDesc").html(htmlVal);
	
	$("#divMontosDescuentos").dialog({
			autoOpen: true,		
		    height: 400,
		    width: 200,
		    modal: true
	});
	
}

function guardarMonto(){
	//alert (idAfiliado2);
	//alert(	$("#montodescuento").val());
	if ($("#montodescuento").val()!=""){
	$.ajax({
		data: {
			"idMontoDescuentoCuentaFam":idAfiliado2,
			"monto":$("#montodescuento").val(),			
		},
		dataType:'json',
		url:   '../../mvc/famahorro/actualizarmontodescuentofam',
		type:  'post',		
		beforeSend: function () {
			//$("#guardarContratoModFamAhorro").hide();
		},
		success:  function (response) {	
			//$("#guardarContratoModFamAhorro").show();
			alert("Actualizado en forma correcta!");
			top.frames['mainFrame'].location="../../views/famahorro/showafiliadosmod.jsp";
			//$("#resultadoGuardar").html("Se agregó el afiliado en forma correcta!<a href='#' onclick='procederCertificado()'>Generar Certificado</a>");			
		}		,	
		error: function (response) {
			alert("ERROR!");
		}		
	});		
	}
	else
		alert("Debe ingresar un valor!");
}
function cambiarMonto(){	
	$("#montoDescuentoDiv").html("<input value='' class='validate[required] text-input' type='text' name='montodescuento' id='montodescuento' /><a href='#' onclick='guardarMonto()'>Guardar</a>");
}
function procesaDatosAfiliado2(datos){
	var data=eval(datos[0]);		
//	alert(data.montosDescuentoCuentaFam);
	montosColl=data.montosDescuentoCuentaFam;
	if (data.montosDescuentoCuentaFam!=""){	
		$("#montoDescuentoDiv").html("$"+data.montosDescuentoCuentaFam[0].monto+" 		<a href='#' onclick='cambiarMonto()'>Cambiar</a>");
	}
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
	$("#idpersonaauto").val(data.benefOperadorCuentaFamAhorro.idBenefCuentaFamAhorro);
	$("#apppersonaauto").val(data.benefOperadorCuentaFamAhorro.apellidoPaternoBenefCuentaFamAhorro);
	$("#apmpersonaauto").val(data.benefOperadorCuentaFamAhorro.apellidoMaternoBenefCuentaFamAhorro);
	$("#nombrepersonaauto").val(data.benefOperadorCuentaFamAhorro.nombreBenefCuentaFamAhorro);
	$("#rfcpersonaauto").val(data.benefOperadorCuentaFamAhorro.rfcBenefCuentaFamAhorro);
	$("#residenciapersonaauto").val(data.benefOperadorCuentaFamAhorro.paisResidenciaBenefCuentaFamAhorro);
	$("#estadocivilpersonaauto").val(data.benefOperadorCuentaFamAhorro.estadoCivilBenefCuentaFamAhorro);
	$("#fechanacimientopersonaauto").val(data.benefOperadorCuentaFamAhorro.fechaNacimientoBenefCuentaFamAhorro);
	$("#parentescopersonauto").val(data.benefOperadorCuentaFamAhorro.parentescoBenefCuentaFamAhorro);
	$("#nacionalidadpersonaauto").val(data.benefOperadorCuentaFamAhorro.nacionalidadBenefCuentaFamAhorro);
	//Beneficiario1
	data=eval(datos[1]);
	if (datos[1]!=null){
		console.log(data);
		$("#idbenef1").val(data.idBenefCuentaFamAhorro);
		$("#nombrebenef1").val(data.nombreBenefCuentaFamAhorro);
		$("#appbenef1").val(data.apellidoPaternoBenefCuentaFamAhorro);
		$("#apmbenef1").val(data.apellidoMaternoBenefCuentaFamAhorro);
		$("#rfcbenef1").val(data.rfcBenefCuentaFamAhorro);
		$("#nacionalidadbenef1").val(data.nacionalidadBenefCuentaFamAhorro);
		$("#residenciabenef1").val(data.paisResidenciaBenefCuentaFamAhorro);
		$("#estadocivilbenef1").val(data.estadoCivilBenefCuentaFamAhorro);
		$("#fechanacimientobenef1").val(data.fechaNacimientoBenefCuentaFamAhorro);
		$("#parentescobenef1").val(data.parentescoBenefCuentaFamAhorro);
		$("#porcentajeBenefCuentaFamAhorro1").val(data.porcentajeBenefCuentaFamAhorro);
	}
	//Beneficiario2
	if (datos[2]!=null){
		data=eval(datos[2]);		
		console.log(data);
		$("#idbenef2").val(data.idBenefCuentaFamAhorro);
		$("#nombrebenef2").val(data.nombreBenefCuentaFamAhorro);
		$("#appbenef2").val(data.apellidoPaternoBenefCuentaFamAhorro);
		$("#apmbenef2").val(data.apellidoMaternoBenefCuentaFamAhorro);
		$("#rfcbenef2").val(data.rfcBenefCuentaFamAhorro);
		$("#nacionalidadbenef2").val(data.nacionalidadBenefCuentaFamAhorro);
		$("#residenciabenef2").val(data.paisResidenciaBenefCuentaFamAhorro);
		$("#estadocivilbenef2").val(data.estadoCivilBenefCuentaFamAhorro);
		$("#fechanacimientobenef2").val(data.fechaNacimientoBenefCuentaFamAhorro);
		$("#parentescobenef2").val(data.parentescoBenefCuentaFamAhorro);
		$("#porcentajeBenefCuentaFamAhorro2").val(data.porcentajeBenefCuentaFamAhorro);
	}
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
			"benefOperadorCuentaFamAhorro.idBenefCuentaFamAhorro":$("#idpersonaauto").val(),
			"benefOperadorCuentaFamAhorro.operadorBenefCuentaFamAhorro":true,
			"benefOperadorCuentaFamAhorro.apellidoPaternoBenefCuentaFamAhorro":$("#apppersonaauto").val(),
			"benefOperadorCuentaFamAhorro.apellidoMaternoBenefCuentaFamAhorro":$("#apmpersonaauto").val(),
			"benefOperadorCuentaFamAhorro.nombreBenefCuentaFamAhorro":$("#nombrepersonaauto").val(),
			"benefOperadorCuentaFamAhorro.rfcBenefCuentaFamAhorro":$("#rfcpersonaauto").val(),
			"benefOperadorCuentaFamAhorro.paisResidenciaBenefCuentaFamAhorro":$("#residenciapersonaauto").val(),
			"benefOperadorCuentaFamAhorro.estadoCivilBenefCuentaFamAhorro":$("#estadocivilpersonaauto").val(),
			"benefOperadorCuentaFamAhorro.fechaNacimientoBenefCuentaFamAhorro":$("#fechanacimientopersonaauto").val(),
			"benefOperadorCuentaFamAhorro.parentescoBenefCuentaFamAhorro":$("#parentescopersonauto").val(),
			"benefOperadorCuentaFamAhorro.nacionalidadBenefCuentaFamAhorro":$("#nacionalidadpersonaauto").val(),
			//Beneficiario1
			"benef1CuentaFamAhorro.idBenefCuentaFamAhorro":$("#idbenef1").val(),
			"benef1CuentaFamAhorro.operadorBenefCuentaFamAhorro":false,
			"benef1CuentaFamAhorro.apellidoPaternoBenefCuentaFamAhorro":$("#appbenef1").val(),
			"benef1CuentaFamAhorro.apellidoMaternoBenefCuentaFamAhorro":$("#apmbenef1").val(),
			"benef1CuentaFamAhorro.nombreBenefCuentaFamAhorro":$("#nombrebenef1").val(),
			"benef1CuentaFamAhorro.rfcBenefCuentaFamAhorro":$("#rfcbenef1").val(),
			"benef1CuentaFamAhorro.paisResidenciaBenefCuentaFamAhorro":$("#residenciabenef1").val(),
			"benef1CuentaFamAhorro.estadoCivilBenefCuentaFamAhorro":$("#estadocivilbenef1").val(),
			"benef1CuentaFamAhorro.fechaNacimientoBenefCuentaFamAhorro":$("#fechanacimientobenef1").val(),
			"benef1CuentaFamAhorro.parentescoBenefCuentaFamAhorro":$("#parentescobenef1").val(),
			"benef1CuentaFamAhorro.nacionalidadBenefCuentaFamAhorro":$("#nacionalidadbenef1").val(),
			"benef1CuentaFamAhorro.porcentajeBenefCuentaFamAhorro":$("#porcentajeBenefCuentaFamAhorro1").val(),			
			//Beneficiario2
			"benef2CuentaFamAhorro.idBenefCuentaFamAhorro":$("#idbenef2").val(),
			"benef2CuentaFamAhorro.operadorBenefCuentaFamAhorro":false,
			"benef2CuentaFamAhorro.apellidoPaternoBenefCuentaFamAhorro":$("#appbenef2").val(),
			"benef2CuentaFamAhorro.apellidoMaternoBenefCuentaFamAhorro":$("#apmbenef2").val(),
			"benef2CuentaFamAhorro.nombreBenefCuentaFamAhorro":$("#nombrebenef2").val(),
			"benef2CuentaFamAhorro.rfcBenefCuentaFamAhorro":$("#rfcbenef2").val(),
			"benef2CuentaFamAhorro.paisResidenciaBenefCuentaFamAhorro":$("#residenciabenef2").val(),
			"benef2CuentaFamAhorro.estadoCivilBenefCuentaFamAhorro":$("#estadocivilbenef2").val(),
			"benef2CuentaFamAhorro.fechaNacimientoBenefCuentaFamAhorro":$("#fechanacimientobenef2").val(),
			"benef2CuentaFamAhorro.parentescoBenefCuentaFamAhorro":$("#parentescobenef2").val(),
			"benef2CuentaFamAhorro.nacionalidadBenefCuentaFamAhorro":$("#nacionalidadbenef2").val(),
			"benef2CuentaFamAhorro.porcentajeBenefCuentaFamAhorro":$("#porcentajeBenefCuentaFamAhorro2").val()
		},
		dataType:'json',
		url:   '../../mvc/famahorro/actualizarfamahorro',
		type:  'post',		
		beforeSend: function () {
			$("#guardarContratoModFamAhorro").hide();
		},
		success:  function (response) {	
			//$("#guardarContratoModFamAhorro").show();
			alert("Actualizado en forma correcta!");
			top.frames['mainFrame'].location="../../views/famahorro/showafiliadosmod.jsp";
			//$("#resultadoGuardar").html("Se agregó el afiliado en forma correcta!<a href='#' onclick='procederCertificado()'>Generar Certificado</a>");			
		}		,	
		error: function (response) {
			alert("ERROR!");
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
