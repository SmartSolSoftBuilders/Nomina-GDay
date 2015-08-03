<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<!--link rel="shortcut icon" type="image/ico" href="http://www.datatables.net/media/images/favicon.ico" /-->
		
		<title>FAM</title>
		<style type="text/css" title="currentStyle">
			@import "../../static/js/libs/css/demo_page.css";
			@import "../../static/js/libs/css/demo_table.css";
			@import "../../static/js/libs/css/ui-lightness/jquery-ui-1.10.2.custom.css";
		</style>
		<script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery.custom.js"></script>
		<script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery.dataTables.js"></script>		
		<script type="text/javascript" language="javascript" src="../../static/js/app/catalogos/altausuario.js"></script>

	</head>
<body id="dt_example">
<div id="container" >
	<h1>Registro de usuario para Afiliados:</h1>
</div>
<center>
Nota: Solo se pueden registrar usuarios cuyo n&uacute;mero de empleado a&uacute;n no est&eacute; registrado.
<form id="formRegUser"  name="formRegUser" class="formular" style="width:650px;" action="../../mvc/afiliado/guardar" method="post">
<table border=0>
		<tr>
			<td>		            
			<fieldset> <legend></legend>
			<legend>N&uacute;mero de Empleado:</legend>
				<label>	<input value="" class="validate[required] text-input" type="text" name="buscanombreusuario" id="buscanombreusuario" /></label>												
			</fieldset>		
			</td>
		</tr>	
	</table>	
	<input type="button" value="Buscar" onclick="buscarUsuario()"/>		
</form>		            
<div id="divRegister">
	<form id="formRegUserOk"  name="formRegUserOk" class="formular" style="width:650px;" action="../../mvc/afiliado/guardar" method="post">
	<table border=0>
		<tr>
			<td>		            
			<fieldset> <legend></legend>
			<legend>Username:</legend>
				<label>	<input value="" class="validate[required] text-input" type="text" name="nombreusuario" id="nombreusuario" readonly=true/></label>												
			<legend>Password:</legend>
				<label>	<input value="" class="validate[required] text-input" type="text" name="passwordusuario" id="passwordusuario" /></label>
			<legend>Nombre Usuario:</legend>
				<label>	<input value="" class="validate[required] text-input" type="text" name="nombreuser" id="nombreuser" /></label>
			</fieldset>		
			</td>
		</tr>	
	</table>	
	<input type="button" value="Guardar" onclick="guardarUsuario()"/>		
</form>		          
</div>
</center>

</body>
</html>