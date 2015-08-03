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
		<script type="text/javascript" language="javascript" src="../../static/js/app/catalogos/mant_escuelas.js"></script>	
	</head>
	<body id="dt_example">
		<div id="container">
			<h1>
				Seleccione una escuela para modificar sus datos
			</h1>		
			<div id="demo">
				<form id="formMantenimientoMunicipios">
					<div style="text-align:right; padding-bottom:1em;">
						<!--button type="submit">Submit form</button-->
					</div>
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="tablaEscuelas">
					<thead>			
						<tr>
							<th>Id</th>						
							<th>Nombre</th>
							<th>Tipo</th>
							<th>Direcci&oacute;n</th>									
							<th>Colonia</th>
							<th>C.P.</th>
							<th>Municipio</th>
							<th>Entidad</th>						
							<th>Ciudad</th>						
							<th>Turno</th>
						</tr>
					<tbody>			
					</tbody>
					</thead>
					</table>
				</form>
			</div>
			
			<div title="Editar datos de escuela" id="divEscuelas" style="display:none">
				<input type="hidden" id="idescuela" name="idescuela"/>
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
						<option value="VESPERTINO">VESPERTINO</option>
						<option value="OTRO">OTRO</option>
				</select>							
			</div>
			<br>
			<br>		
			<div align="center">
				<input type="button" value="Corregir datos" onclick="corregirDatosEscuelas()"/>				
			</div>
			<br>
			<br>
			<!-- div id="footer" class="clear" style="text-align:center;"><span style="font-size:10px;"> DataTables designed and created by <a href="http://www.sprymedia.co.uk">Allan Jardine</a> &copy; 2007-2011<br>
					DataTables is dual licensed under the <a href="http://www.datatables.net/license_gpl2">GPL v2 license</a> or a <a href="http://www.datatables.net/license_bsd">BSD (3-point) license</a>.
				</span>
			</div -->
		</div>
	</body>
</html>