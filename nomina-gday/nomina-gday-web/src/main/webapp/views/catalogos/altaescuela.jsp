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
		<script type="text/javascript" language="javascript" src="../../static/js/app/catalogos/altaescuela.js"></script>

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
				<br>Nombre:<input type="text" id="nombreescuela" name="nombreescuela"/>
				<br>Tipo Escuela:<select id="tipoescuelacombo" name="tipoescuelacombo"></select>
				<br>Direcci&oacute;n:<input type="text" id="direccionescuela" name="direccionescuela"/>
				<br>Colonia:<input type="text" id="coloniaescuela" name="coloniaescuela"/>
				<br>C.P.:<input type="text" id="cpescuela" name="cpescuela"/>
				<br>Municipio:<select id="municipiocombo" name="municipioescuela"></select>
				<br>Ciudad:<input type="text" id="ciudadescuela" name="ciudadescuela"/>
				<br>Entidad:<input type="text" id="entidadescuela" name="entidadescuela"/>
				<br>Turno:<select id="turnoescuela" name="turnoescuela">
						<option value="MATUTINO">MATUTINO</option>
						<option value="MATUTINO">VESPERTINO</option>
						<option value="MATUTINO">OTRO</option>
				</select>												
			</fieldset>		
			</td>
		</tr>	
	</table>
	<input type="button" value="Agregar" onclick="agregarEscuela()"/>		
</form>		            
</center>
</body>
</html>