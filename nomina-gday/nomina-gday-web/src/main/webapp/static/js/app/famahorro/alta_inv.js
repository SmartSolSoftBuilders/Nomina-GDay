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
		url:   '../../mvc/famahorro/guardarinv',
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
