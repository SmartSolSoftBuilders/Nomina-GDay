<html>
 <head>  	
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>Registrar Afiliado</title>
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
	<script type="text/javascript" language="javascript" src="../../static/js/app/afiliados/alta.js"></script>	
	
	<script src="../../static/js/libs/js/languages/jquery.validationEngine-es.js" type="text/javascript" charset="utf-8">
	</script>
	<script src="../../static/js/libs/js/jquery.validationEngine.js" type="text/javascript" charset="utf-8">
	</script>
	<script>
		jQuery(document).ready(function(){
			// binds form submission and fields to the validation engine
			$( "#fechanacimiento" ).datepicker({ dateFormat: "yy-mm-dd" ,changeYear: true});
			jQuery("#formAltaAfiliado").validationEngine();	
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
	<h1>Por favor ingrese los datos del nuevo Afiliado</h1>
</div>
<div align="center">	
<form id="formAltaAfiliado"   name="formAltaAfiliado" class="formular" style="width:700px;" action="../../mvc/afiliado/guardar" method="post">
	<table border=0>
		<tr>
			<td>
				<fieldset> 
				<legend>DATOS GENERALES</legend>
				<table border=0 >
					<tr>
						<td>
						<legend>Nombre</legend>
						<label>	<input value="" class="validate[required] text-input" type="text" name="nombre" id="nombre" /></label>
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
								<option value="MEXICANA">MEXICANA</option>
								<option value="AMERICANA">AMERICANA</option>
								<option value="GUATEMALTECA">GUATEMALTECA</option>
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
		</tr>
	</table>	
	<table border=0>
		<tr>
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
								<option value="NAYARIT">NAYARIT</option>
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
			<label>¿Es Inversionista? <select name="esinversionista" id="esinversionista" class="validate[required]">																
								<option value="2">NO</option>
								<option value="1">SI</option>
						</select>
						</label>
				<div id="resultadoGuardar"></div>	
					<input class="button" type="button" id="guardarAfiliadoAlta" value="Guardar Afiliado" onClick="guardarAfiliado()"/>
					<!--input id="skipbutton" class="submit validate-skip" type="submit" value="Skip Validate &amp; Send the form!"/><hr/-->
			</td>
		</tr>
	</table>		
</form>
	
	<div id="divEscuela" title="Seleccionar Escuela" style="display:none">
		<jsp:include page="escuela.jsp"></jsp:include>
	</div>
	</div>
</body>			
</html>