<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		
		<title>GDAY</title>
		<jsp:include page="../common/librerias.jsp"/>	
		<script type="text/javascript" language="javascript" src="../../static/js/app/empleados/empleados.js"></script>
	</head>
	<body id="dt_example">
		<div id="progressbar">Cargando (75%)...</div>	
		<div id="container" class="mayuscula">
			<h1>Empleados</h1>		
			<div id="demo">
				<form id="formSeleccionarEmpleados">
					<div style="text-align:right; padding-bottom:1em;">
						<!--button type="submit">Submit form</button-->
					</div>
					<table  cellpadding="0" cellspacing="0" border="0" class="display" id="tablaEmpleado">
					<thead>			
						<tr class="odd gradeA">
							<th width="40px">ID</th>
							<th width="40px">RFC</th>
							<th width="200px">PATERNO</th>
							<th width="200px">MATERNO</th>
							<th width="200px">NOMBRE</th>
							<th width="200px">CURP</th>					
							<th width="200px">NSS</th>	
						</tr>
					</thead>
					</table>
				</form>
			</div>
			
			<div id="Empleado">				
			</div>
			<br>
			<br>
			<br>
			<br>
			<!-- div id="footer" class="clear" style="text-align:center;"><span style="font-size:10px;"> DataTables designed and created by <a href="http://www.sprymedia.co.uk">Allan Jardine</a> &copy; 2007-2011<br>
					DataTables is dual licensed under the <a href="http://www.datatables.net/license_gpl2">GPL v2 license</a> or a <a href="http://www.datatables.net/license_bsd">BSD (3-point) license</a>.
				</span -->
			</div>
		</div>
	</body>
</html>