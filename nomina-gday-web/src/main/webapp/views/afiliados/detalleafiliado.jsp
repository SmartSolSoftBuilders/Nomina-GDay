<html>
 <head>  	
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />	
	<title>Detalle Afiliado</title>
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
	<script type="text/javascript" language="javascript" src="../../static/js/app/afiliados/detalle.js"></script>	
	
	<script src="../../static/js/libs/js/languages/jquery.validationEngine-es.js" type="text/javascript" charset="utf-8">
	</script>
	<script src="../../static/js/libs/js/jquery.validationEngine.js" type="text/javascript" charset="utf-8">
	</script>
	<script>
		jQuery(document).ready(function(){
			// binds form submission and fields to the validation engine
			//jQuery("#formAfiliado").validationEngine();	
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

<body>
<body id="dt_example">
<div id="container" >
</div>	
<table border=0>
	<tr>
		<td>
		<form id="formAprobModAfiliado"   name="formAltaAfiliado" class="formular" style="width:700px;" action="../../mvc/afiliado/guardar" method="post">
			<h1>Cambios a aplicar</h1>
			<table border=0>
			<tr>
			<td>
				<fieldset> 
				<legend>DATOS GENERALES</legend>
				<table border=0 >
					<tr>
						<td>
						<legend>Nombre</legend>
						<label>	<input value="" class="validate[required] text-input" type="text" name="nombre" id="nombre" readonly=true/></label>
						<legend>Apellido Paterno</legend>
						<label><input value="" class="validate[required] text-input" type="text" name="app" id="app" readonly=true/></label>
						<legend>Apellido Materno</legend>
						<label><input value="" class="validate[required] text-input" type="text" name="apm" id="apm" readonly=true/></label>
						<legend>Fecha de Nacimiento</legend>
						<label><input value="" class="validate[required] text-input" type="text" name="fechanacimiento" id="fechanacimiento" readonly=true/></label>
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
						<label><input value="" class="validate[required] text-input" type="text" name="estadocivil" id="estadocivil" readonly=true/></label>
						<legend>N&uacute;mero de Empleado</legend>
						<label><input value="" class="validate[required] text-input" type="text" name="rfc" id="rfc" readonly=true/></label>
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
						<label>	<input value="" class="validate[required] text-input" type="text" name="telparticular" id="telparticular" readonly=true/></label>
						<legend>Tel&eacute;fono Celular</legend>
						<label>	<input value="" class="validate[required] text-input" type="text" name="telcelular" id="telcelular" readonly=true/></label>
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
						<label>	<input value="" class="validate[required] text-input" type="text" name="email" id="email" readonly=true/></label>
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
						<label>	<input value="" class="validate[required] text-input" type="text" name="domicilio" id="domicilio" readonly=true/></label>
					<legend>Colonia</legend>
						<label>	<input value="" class="validate[required] text-input" type="text" name="colonia" id="colonia" readonly=true/></label>
					<legend>C.P.</legend>
						<label>	<input value="" class="validate[required] text-input" type="text" name="cp" id="cp" readonly=true/></label>
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
							<option value="Municipio1">Municipio1</option>
							<option value="Municipio2">Municipio2</option>
						</select>
						</label>		
						<legend>Escuela</legend>
						<label>	<input value="" class="validate[required] text-input" type="text" name="escuela" id="escuela" /><input type="button" value="Buscar..." onClick="showEscuela()" readonly=true/></label>		
						<legend>Puesto</legend>
						<label>	<input value="" class="validate[required] text-input" type="text" name="puesto" id="puesto" readonly=true/></label>		
						<legend>Antiguedad</legend>
						<label>	<input value="" class="validate[required] text-input" type="text" name="antiguedad" id="antiguedad" readonly=true/></label>		
					</td>
				</tr>
				</table>
				</fieldset>
			</td>
			<td align=CENTER>
				<div id="resultadoGuardar"></div>	
				<input class="button" type="button" value="Aprobar" onClick="aprobar()"/>
				<input class="button" type="button" value="Denegar" onClick="denegar()"/>				
			</td>
			</tr>
		</table>		
		</form>
		</td>
		<td>			
			<form id="formAfiliadoActual"   name="formAfiliadoActual" class="formular" style="width:700px;" action="../../mvc/afiliado/guardar" method="post">
			<h1>Datos actuales</h1>
			<table border=0>
			<tr>
				<td>
					<fieldset> 
					<legend>DATOS GENERALES</legend>
					<table border=0 >
						<tr>
							<td>
							<legend>Nombre</legend>
								<label>	<div id="nombreactual"></div></label>
								<legend>Apellido Paterno</legend>
								<label>	<div id="appactual"></div></label>
								<legend>Apellido Materno</legend>
								<label>	<div id="apmactual"></div></label>
								<legend>Fecha de Nacimiento</legend>
								<label>	<div id="fechanacimientoactual"></div></label>
							</td>
							<td>			
								<legend>Nacionalidad</legend>
								<label>	<div id="nacionalidadactual"></div></label>					
								<legend>Estado Civil </legend>
								<label>	<div id="estadocivilactual"></div></label>
								<legend>RFC</legend>
								<label>	<div id="rfcactual"></div></label>
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
							<label>	<div id="telparticularactual"></div></label>
							<legend>Tel&eacute;fono Celular</legend>
							<label>	<div id="telcelularactual"></div></label>
							<legend>Compania</legend>
							<label>	<div id="companiaactual"></div></label>						
							<legend>E-mail</legend>						
							<label>	<div id="emailactual"></div></label>
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
						<label>	<div id="domicilioactual"></div></label>
						<legend>Colonia</legend>
						<label>	<div id="coloniaactual"></div></label>
						<legend>C.P.</legend>
						<label>	<div id="cpactual"></div></label>
						<legend>Entidad Federativa</legend>
						<label>	<div id="entidadactual"></div></label>
					</td>
					<td>	
						<legend>Municipio</legend>
						<label>	<div id="municipioactual"></div></label>		
						<legend>Escuela</legend>
						<label>	<div id="escuelaactual"></div></label>		
						<legend>Puesto</legend>
						<label>	<div id="puestoactual"></div></label>		
						<legend>Antiguedad</legend>
						<label>	<div id="antiguedadactual"></div></label>		
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
		<br><br><br><br><br><br><br><br>		
	</form>					
		</td>
	</tr>
	</table>
				
	<div id="resultadoGuardar"></div>
	<div id="divEscuela" title="Seleccionar Escuela" style="display:none">
		<jsp:include page="escuela.jsp"></jsp:include>
	</div>
</body>			
</html>