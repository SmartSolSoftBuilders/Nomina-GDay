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
		<script type="text/javascript" language="javascript" src="../../static/js/app/catalogos/altamunicipio.js"></script>

		<script type="text/javascript" charset="utf-8">
			var oTableMunicipios;						
		</script>
	</head>
<body id="dt_example">
<div id="container" >
	<h1>Por favor ingrese los datos del nuevo Municipio</h1>
</div>
<center>
<form id="formMunicipio"  name="formMunicipio" class="formular" style="width:650px;" action="../../mvc/afiliado/guardar" method="post">
	<table border=0>
		<tr>
			<td>		            
			<fieldset> <legend></legend>
			<legend>Nombre Municipio</legend>
				<label>	<input value="" class="validate[required] text-input" type="text" name="nombremunicipio" id="nombremunicipio" /></label>												
			</fieldset>		
			</td>
		</tr>	
	</table>
	<input type="button" value="Agregar" onclick="agregarMunicipio()"/>		
</form>		            
</center>
</body>
</html>