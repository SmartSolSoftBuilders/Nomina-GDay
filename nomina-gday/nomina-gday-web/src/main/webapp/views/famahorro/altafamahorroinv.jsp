<html>
 <head>  	
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>Registrar Cuenta de Inversión FAMAhorro para el Afiliado</title>
		<style type="text/css" title="currentStyle">
			@import "../../static/js/libs/css/demo_page.css";
			@import "../../static/js/libs/css/demo_table.css";
			@import "../../static/js/libs/css/ui-lightness/jquery-ui-1.10.2.custom.css";
		</style>
	<link rel="stylesheet" href="../../static/js/libs/css/validationEngine.jquery.css" type="text/css"/>
	<link rel="stylesheet" href="../../static/js/libs/css/template.css" type="text/css"/>
	<script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery-1.9.1.js"></script>
  	<script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery-ui-1.10.2.custom.js"></script>
  	<script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery.dataTables.js"></script>
	<script type="text/javascript" language="javascript" src="../../static/js/app/famahorro/alta_inv.js"></script>	
	
	<script src="../../static/js/libs/js/languages/jquery.validationEngine-es.js" type="text/javascript" charset="utf-8">
	</script>
	<script src="../../static/js/libs/js/jquery.validationEngine.js" type="text/javascript" charset="utf-8">
	</script>
	<script>
		jQuery(document).ready(function(){
			// binds form submission and fields to the validation engine
			$( "#fechanacimiento" ).datepicker({ dateFormat: "yy-mm-dd" });
			$( "#fechacontrato" ).datepicker({ dateFormat: "yy-mm-dd" });
			$( "#fechanacimientopersonaauto" ).datepicker({ dateFormat: "yy-mm-dd" });
			$( "#fechanacimientobenef1" ).datepicker({ dateFormat: "yy-mm-dd" });
			jQuery("#formAltaAfiliado2").validationEngine();	
		});

		/**
		*
		* @param {jqObject} the field where the validation applies
		* @param {Array[String]} validation rules for this field
		* @param {int} rule index
		* @param {Map} form options
		* @return an error string if validation failed
		*/
		
		function checkHELLO(field, rules, i, options){
			if (field.val() != "HELLO") {
				// this allows to use i18 for the error msgs
				return options.allrules.validate2fields.alertText;
			}
		}
	</script>
</head>

<body id="dt_example">
<div id="container" >	
</div>
<div align="left">
	<form id="formAltaAfiliado"   name="formAltaAfiliado" class="formular" style="width:1200px;" action="../../mvc/afiliado/guardar" method="post">	
		<table border=0>
			<tr>
				<td>
					<fieldset> 
					<legend>DATOS GENERALES DEL PARTICULAR</legend>
					<table border=0 >
						<tr>
							<td>
							<legend>Nombre</legend>
							<label>	<input value="" class="validate[required] text-input" readonly=true  type="text" name="nombre" id="nombre" /></label>
							<legend>Apellido Paterno</legend>
							<label><input value="" class="validate[required] text-input" type="text" name="app" id="app" /></label>
							<legend>Apellido Materno</legend>
							<label><input value="" class="validate[required] text-input" type="text" name="apm" id="apm" /></label>
							<legend>Fecha de Nacimiento</legend>
							<label><input value="" class="validate[required] text-input" type="text" name="fechanacimiento" id="fechanacimiento" /></label>
							</td>
							<td>			
							<legend>Nacionalidad</legend>
							<label><select name="nacionalidad" id="nacionalidad" class="validate[required]">
									<option value="">Seleccione...</option>
									<option value="option1">Mexicana</option>
									<option value="option2">Americana</option>
									<option value="option3">Guatemalteca</option>
									</select>
							</label>					
							<legend>Estado Civil </legend>						
							<label><select name="estadocivil" id="estadocivil">
									<option value="CASADO(A)">CASADO(A)</option>
									<option value="SOLTERO(A)">SOLTERO</option>
									<option value="UNION LIBRE">UNIONLIBRE</option>
									<option value="DIVORCIADO(A)">DIVORCIADO(A)</option>
									<option value="VIUDO(A)">VIUDO(A)</option>
							</select></label>
							<legend>N&uacute;mero de Empleado:</legend>
							<label><input value="" class="validate[required] text-input" type="text" name="rfc" id="rfc" /></label>
							</td>
						</tr>
					</table>
					</fieldset>											
				</td>
				<td>
					<fieldset>
					<legend>CONTACTO</legend>
					<table border=0 >
					<tr>								
						<td>
							<legend>Tel&eacute;fono Particular</legend>
							<label>	<input value="" class="validate[required] text-input" type="text" name="telparticular" id="telparticular" /></label>
							<legend>Tel&eacute;fono Celular</legend>
							<label>	<input value="" class="validate[required] text-input" type="text" name="telcelular" id="telcelular" /></label>
							<legend>Compania</legend>
							<label>	
							<select name="compania" id="compania" class="validate[required]">
									<option value="">Seleccione...</option>
									<option value="TELCEL">TELCEL</option>
									<option value="MOVISTAR">MOVISTAR</option>
									<option value="IUSACELL">IUSACELL</option>
								</select>
							</label>
							<legend>E-mail</legend>						
							<label>	<input value="" class="validate[required] text-input" type="text" name="email" id="email" /></label>
						</td>
					</tr>
					</table>
					</fieldset>			
				</td>
				<td>				
					<fieldset>
					<legend>DIRECCI&Oacute;N</legend>
					<table border=0 >
					<tr>
						<td>
						<legend>Calle y N&uacute;mero</legend>
							<label>	<input value="" class="validate[required] text-input" type="text" name="domicilio" id="domicilio" /></label>
						<legend>Colonia</legend>
							<label>	<input value="" class="validate[required] text-input" type="text" name="colonia" id="colonia" /></label>
						<legend>C.P.</legend>
							<label>	<input value="" class="validate[required] text-input" type="text" name="cp" id="cp" /></label>
						<legend>Entidad Federativa</legend>
							<label>	<select name="entidad" id="entidad" class="validate[required]">
									<option value="">Seleccione...</option>
									<option value="MEXICO">MEXICO</option>
									<option value="MEXICO2">NAYARIT</option>
							</select>
							</label>
						</td>
						<td>	
							<legend>Municipio</legend>
							<label>	<select name="municipio" id="municipio" class="validate[required]">
								<option value="">Seleccione...</option>							
							</select>
							</label>		
							<legend>Escuela</legend>
							<label>	<input value="" class="validate[required] text-input" type="text" name="escuela" id="escuela" /><input type="button" value="Buscar..." onClick="showEscuela()"/></label>		
							<legend>Puesto</legend>
							<label>	<input value="" class="validate[required] text-input" type="text" name="puesto" id="puesto" /></label>		
							<legend>Antiguedad</legend>
							<label>	<input value="" class="validate[required] text-input" type="text" name="antiguedad" id="antiguedad" /></label>		
						</td>
					</tr>
					</table>
					</fieldset>
				</td>
				<td align=CENTER>
					<div id="resultadoGuardar"></div>							
						<!--input id="skipbutton" class="submit validate-skip" type="submit" value="Skip Validate &amp; Send the form!"/><hr/-->
				</td>
			</tr>
		</table>		
	</form>	
</div>
<div align="left">
	<form id="formAltaAfiliado2"   name="formAltaAfiliado2" class="formular" style="width:1200px;" action="../../mvc/afiliado/guardar" method="post">
	<h1>Por favor ingrese los datos del Afiliado para registrar su cuenta de inversión en FAMAhorro:</h1>
		<table border=0>
			<tr>
				<td>
					<fieldset> 
					<legend>ACTIVIDAD ECONOMICA/FUENTE DE INGRESOS</legend>
					<table border=0 >
						<tr>
							<td>
							<legend>Fecha de Contrato</legend>
							<label><input value="" class="validate[required] text-input" type="text" name="fechacontrato" id="fechacontrato" /></label>
							<legend>Asalariado</legend>
							<label><select name="asalariado" id="asalariado" class="validate[required]">
									<option value="">Seleccione...</option>
									<option value="SI">SI</option>
									<option value="NO">NO</option>									
									</select>
							</label>
							<legend>Actividad Empresarial</legend>
							<label><select name="actividadempresarial" id="actividadempresarial" class="validate[required]">
									<option value="">Seleccione...</option>
									<option value="COMISIONISTA">COMISIONISTA</option>
									<option value="EMPRESARIO">EMPRESARIO</option>									
									<option value="COMERCIANTE">COMERCIANTE</option>
									<option value="OTRA">OTRA</option>
									</select>
							</label>							
							</td>
							<td>
							<legend>Sin Actividad Económica</legend>
							<label><select name="sinactividadempresarial" id="sinactividadempresarial" class="validate[required]">
									<option value="">Seleccione...</option>
									<option value="DESEMPLEADO">DESEMPLEADO</option>
									<option value="AMA DE CASA">AMA DE CASA</option>									
									<option value="ESTUDIANTE">ESTUDIANTE</option>
									<option value="OTRA">OTRA</option>
									</select>
							</label>																
							<legend>Estatus Laboral</legend>
							<label><select name="estatuslaboral" id="estatuslaboral" class="validate[required]">
									<option value="">Seleccione...</option>
									<option value="PERSONAL ACTIVO">PERSONAL ACTIVO</option>
									<option value="JUBILADO">JUBILADO</option>
									<option value="PENSIONADO">PENSIONADO</option>
									<option value="RETIRADO">RETIRADO</option>
									</select>
							</label>					
							</td>
						</tr>
					</table>
					</fieldset>											
				</td>
				<td>
					<fieldset>
					<legend>DATOS DE LA CUENTA</legend>
					<table border=0 >
					<tr>								
						<td>
							<legend>Monto de Apertura</legend>
							<label>	<input value="" class="validate[required] text-input" type="text" name="montoapertura" id="montoapertura" /></label>
							<legend>Monto inicial aproximado de depósito en efectivo:</legend>							
							<label>	
							<select name="porcentajeahorro" id="porcentajeahorro" class="validate[required]">
									<option value="">Seleccione...</option>
									<option value="500000">MENOS DE 500000</option>
									<option value="500001">MAS DE 500000</option>									
								</select>
							</label>	
							<legend>Frecuencia de depósitos:</legend>							
							<label>	
							<select name="frecuenciadepositos" id="frecuenciadepositos" class="validate[required]">
									<option value="">Seleccione...</option>
									<option value="1">1 a 3 al año</option>
									<option value="2">más de 3 al año</option>									
								</select>
							</label>
						</td>
						<td>	
							<legend>Frecuencia de Retiros:</legend>							
							<label>	
							<select name="frecuenciaretiros" id="frecuenciaretiros" class="validate[required]">
									<option value="">Seleccione...</option>
									<option value="1">1 a 3 al año</option>
									<option value="2">más de 3 al año</option>
								</select>
							</label>
							<legend>Procedencia de los Recursos con que abre la cuenta:</legend>							
							<label>	
							<select name="procedenciarecursos" id="procedenciarecursos" class="validate[required]">
									<option value="">Seleccione...</option>									
									<option value="PERSONAL">PERSONAL</option>
									<option value="NEGOCIOS">NEGOCIOS</option>
									<option value="OTRA">OTRA</option>
								</select>
							</label>								
						</td>
					</tr>
					</table>
					</fieldset>			
				</td>				
			</tr>
		</table>
		<table border=0>
			<tr>
				<td>
					<fieldset> 
					<legend>PERSONA AUTORIZADA A OPERAR LA CUENTA (EN CASO DE INCAPACIDAD)</legend>
					<table border=0 >
						<tr> 
							<td>
							<legend>Nombre</legend>
							<label><input value="" class="validate[required] text-input" type="text" name="nombrepersonaauto" id="nombrepersonaauto" /></label>
							<legend>Apellido Paterno</legend>
							<label><input value="" class="validate[required] text-input" type="text" name="apppersonaauto" id="appersonaauto" /></label>
							<legend>Apellido Materno</legend>
							<label><input value="" class="validate[required] text-input" type="text" name="apmpersonaauto" id="apmpersonaauto" /></label>
							<legend>RFC</legend>
							<label><input value="" class="validate[required] text-input" type="text" name="rfcpersonaauto" id="rfcpersonaauto" /></label>
							</td>
							<td>
							<legend>Nacionalidad</legend>
							<label><select name="nacionalidadpersonaauto" id="nacionalidadpersonaauto" class="validate[required]">
									<option value="">Seleccione...</option>
									<option value="MEXICANA">MEXICANA</option>
									<option value="AMERICANA">AMERICANA</option>									
									</select>
							</label>
							<legend>País de Residencia</legend>
							<label><select name="residenciapersonaauto" id="residenciapersonaauto" class="validate[required]">
									<option value="">Seleccione...</option>
									<option value="MEXICO">MEXICO</option>
									<option value="USA">USA</option>									
									</select>
							</label>
							<legend>Estado Civil</legend>
							<label><select name="estadocivilpersonaauto" id="estadocivilpersonaauto" class="validate[required]">
									<option value="">Seleccione...</option>
									<option value="CASADO(A)">CASADO(A)</option>
									<option value="SOLTERO(A)">SOLTERO</option>
									<option value="UNION LIBRE">UNIONLIBRE</option>
									<option value="DIVORCIADO(A)">DIVORCIADO(A)</option>
									<option value="VIUDO(A)">VIUDO(A)</option>
							</select>
					</label>
					<legend>Fecha Nacimiento</legend>
					<label><input value="" class="validate[required] text-input" type="text" name="fechanacimientopersonaauto" id="fechanacimientopersonaauto" /></label>
								<legend>Parentesco</legend>
				<label>	
					<select name="parentescopersonauto" id="parentescopersonauto" class="validate[required]">
						<option value="">Seleccione...</option>
						<option value="PADRE">PADRE</option>
						<option value="MADRE">MADRE</option>
						<option value="HERMANO(A)">HERMANO(A)</option>
						<option value="ABUELO(A)">ABUELO(A)</option>						
						<option value="ESPOSO(A)">ESPOSO(A)</option>
						<option value="HIJO(A)">HIJO(A)</option>
						<option value="NIETO(A)">NIETO(A)</option>
						<option value="TIO(A)">TIO(A)</option>
						<option value="SOBRINO(A)">SOBRINO(A)</option>
						<option value="CONCUBINO(A)">CONCUBINO(A)</option>						
						<option value="OTRO">OTRO</option>						
					</select>
				</label>											
				</table>
				</fieldset>
				</td>
				<td>
					<fieldset> 
					<legend>BENEFICIARIO 1</legend>
					<table border=0 >
						<tr>
							<td>
								<legend>Nombre</legend>
								<label><input value="" class="validate[required] text-input" type="text" name="nombrebenef1" id="nombrebenef1" /></label>
								<legend>Apellido Paterno</legend>
								<label><input value="" class="validate[required] text-input" type="text" name="appbenef1" id="appbenef1" /></label>
								<legend>Apellido Materno</legend>
								<label><input value="" class="validate[required] text-input" type="text" name="apmbenef1" id="apmbenef1" /></label>
								<legend>RFC</legend>
								<label><input value="" class="validate[required] text-input" type="text" name="rfcbenef1" id="rfcbenef1" /></label>
							</td>
							<td>
								<legend>Nacionalidad</legend>
								<label><select name="nacionalidadbenef1" id="nacionalidadbenef1" class="validate[required]">
									<option value="">Seleccione...</option>
									<option value="MEXICANA">MEXICANA</option>
									<option value="AMERICANA">AMERICANA</option>									
									</select>
								</label>
								<legend>País de Residencia</legend>
								<label><select name="residenciabenef1" id="residenciabenef1" class="validate[required]">
									<option value="">Seleccione...</option>
									<option value="MEXICO">MEXICO</option>
									<option value="USA">USA</option>									
									</select>
								</label>
								<legend>Estado Civil</legend>
								<label><select name="estadocivilbenef1" id="estadocivilbenef1" class="validate[required]">
									<option value="">Seleccione...</option>
									<option value="CASADO(A)">CASADO(A)</option>
									<option value="SOLTERO(A)">SOLTERO</option>
									<option value="UNION LIBRE">UNIONLIBRE</option>
									<option value="DIVORCIADO(A)">DIVORCIADO(A)</option>
									<option value="VIUDO(A)">VIUDO(A)</option>
									</select>
								</label>
								<legend>Fecha Nacimiento</legend>
								<label><input value="" class="validate[required] text-input" type="text" name="fechanacimientobenef1" id="fechanacimientobenef1" /></label>
								<legend>Parentesco</legend>
								<label>	
								<select name="parentescobenef1" id="parentescobenef1" class="validate[required]">
									<option value="">Seleccione...</option>
									<option value="PADRE">PADRE</option>
									<option value="MADRE">MADRE</option>
									<option value="HERMANO(A)">HERMANO(A)</option>
									<option value="ABUELO(A)">ABUELO(A)</option>
									<option value="TIO(A)">TIO(A)</option>
									<option value="SOBRINO(A)">SOBRINO(A)</option>
									<option value="OTRO">OTRO</option>						
								</select>
								</label>											
						</table>
					</fieldset>
				</td>
				<td>
					<fieldset> 
					<legend>BENEFICIARIO 2</legend>
					<table border=0 >
						<tr>
							<td>
								<legend>Nombre</legend>
								<label><input value="" class="validate[required] text-input" type="text" name="nombrebenef2" id="nombrebenef2" /></label>
								<legend>Apellido Paterno</legend>
								<label><input value="" class="validate[required] text-input" type="text" name="appbenef2" id="appbenef2" /></label>
								<legend>Apellido Materno</legend>
								<label><input value="" class="validate[required] text-input" type="text" name="apmbenef2" id="apmbenef2" /></label>
								<legend>RFC</legend>
								<label><input value="" class="validate[required] text-input" type="text" name="rfcbenef2" id="rfcbenef2" /></label>
							</td>
							<td>
								<legend>Nacionalidad</legend>
								<label><select name="nacionalidadbenef2" id="nacionalidadbenef2" class="validate[required]">
									<option value="">Seleccione...</option>
									<option value="MEXICANA">MEXICANA</option>
									<option value="AMERICANA">AMERICANA</option>									
									</select>
								</label>
								<legend>País de Residencia</legend>
								<label><select name="residenciabenef2" id="residenciabenef2" class="validate[required]">
									<option value="">Seleccione...</option>
									<option value="MEXICO">MEXICO</option>
									<option value="USA">USA</option>									
									</select>
								</label>
								<legend>Estado Civil</legend>
								<label><select name="estadocivilbenef2" id="estadocivilbenef2" class="validate[required]">
									<option value="">Seleccione...</option>
									<option value="CASADO(A)">CASADO(A)</option>
									<option value="SOLTERO(A)">SOLTERO</option>
									<option value="UNION LIBRE">UNIONLIBRE</option>
									<option value="DIVORCIADO(A)">DIVORCIADO(A)</option>
									<option value="VIUDO(A)">VIUDO(A)</option>
									</select>
								</label>
								<legend>Fecha Nacimiento</legend>
								<label><input value="" class="validate[required] text-input" type="text" name="fechanacimientobenef2" id="fechanacimientobenef2" /></label>
								<legend>Parentesco</legend>
								<label>	
								<select name="parentescobenef2" id="parentescobenef2" class="validate[required]">
									<option value="">Seleccione...</option>
									<option value="PADRE">PADRE</option>
									<option value="MADRE">MADRE</option>
									<option value="HERMANO(A)">HERMANO(A)</option>
									<option value="ABUELO(A)">ABUELO(A)</option>
									<option value="TIO(A)">TIO(A)</option>
									<option value="SOBRINO(A)">SOBRINO(A)</option>
									<option value="OTRO">OTRO</option>						
								</select>
								</label>											
						</table>
					</fieldset>
				</td>																								
			</tr>
		</table>
		<center><input type="button" value="Guardar" onclick="guardarContrato()"/></center>		
	</form>	
</div>
</body>			
</html>