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
  	<script type="text/javascript" language="javascript" src="../../static/js/app/catalogos/cambio_cont.js"></script>
</head>
<script src="../../static/js/libs/js/languages/jquery.validationEngine-es.js" type="text/javascript" charset="utf-8">
	</script>
	<script src="../../static/js/libs/js/jquery.validationEngine.js" type="text/javascript" charset="utf-8">
	</script>
	<script>
		jQuery(document).ready(function(){
			// binds form submission and fields to the validation engine
			$( "#fechanacimiento" ).datepicker({ dateFormat: "yy-mm-dd" });
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
	<h1>Por favor complete los siguientes datos para modificar su contraseña</h1>
</div>
<div align="center">	
<form id="formModCont" name="formModCont" class="formular" style="width:700px;" action="../../mvc/afiliado/guardar" method="post">
	<table border=0>
		<tr>
			<td>
				<fieldset> 
				<legend>Cambio de Contraseña</legend>
				<table border=0 >
					<tr>
						<td>
						<legend>Contraseña anterior:</legend>
						<label>	<input value="" class="validate[required] text-input" type="password" name="contrasenia" id="contrasenia" /></label>
						<legend>Nueva Contraseña:</legend>
						<label><input value="" class="validate[required] text-input" type="password" name="newcontrasenia" id="newcontrasenia" /></label>
						<legend>Confirme nueva Contraseña:</legend>
						<label><input value="" class="validate[required] text-input" type="password" name="recontrasenia" id="recontrasenia" /></label>												
						<input type="button" value="Aceptar" onclick="cambiaCont()"/>
						</td>
					</tr>
				</table>
			</fieldset>
		</td>
		</tr>
		</table>			
		</form>		
		</div>	
		<div id="mensajeCambioCont" title="Mensaje" style="display:none">
				
		</div>											
	</body>
</html>