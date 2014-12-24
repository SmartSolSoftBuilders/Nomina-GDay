var oTable;
var idAfiliado=getParameter('id');

$(document).ready(function() {
	$.ajax({
		data: {
			"idAfiliado" : idAfiliado
		},
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
});

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
			//"benefOperadorCuentaFamAhorro.porcentajeBenefCuentaFamAhorro":$("#porcentajeBenefCuentaFamAhorro").val(),
			//Beneficiario1
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
		url:   '../../mvc/famahorro/guardar',
		type:  'post',		
		beforeSend: function () {			
		},
		success:  function (response) {	
			alert("Agregado en forma correcta!");
			$("#guardarFAMAHORRO").attr('disabled', true);
			//$("#resultadoGuardar").html("Se agregó el afiliado en forma correcta!<a href='#' onclick='procederCertificado()'>Generar Certificado</a>");
			top.frames['mainFrame'].location="../famahorro/showafiliados.jsp";
		},	
		error: function (response) {
			alert("ERROR! No fue posible crear la cuenta FAM AHORRO!");			
		}		
	});		
}

function copyDataPersAutorizada(){
	alert("Se copiará el registro de la persona autorizada como beneficiario 1.");
	$("#appbenef1").val($("#appersonaauto").val());
	$("#apmbenef1").val($("#apmpersonaauto").val());
	$("#nombrebenef1").val($("#nombrepersonaauto").val());
	$("#rfcbenef1").val($("#rfcpersonaauto").val());
	$("#residenciabenef1").val($("#residenciapersonaauto").val());
	$("#estadocivilbenef1").val($("#estadocivilpersonaauto").val());
	$("#fechanacimientobenef1").val($("#fechanacimientopersonaauto").val());
	$("#parentescobenef1").val($("#parentescopersonauto").val());
	$("#nacionalidadbenef1").val($("#nacionalidadpersonaauto").val());	
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
