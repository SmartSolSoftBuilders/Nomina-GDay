<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<!--link rel="shortcut icon" type="image/ico" href="http://www.datatables.net/media/images/favicon.ico" /-->
		
		<title>FAM</title>
		<style type="text/css" title="currentStyle">
			@import "../../static/js/libs/css/demo_page.css";
			@import "../../static/js/libs/css/demo_table.css";
			@import "../../static/js/libs/css/bootstrap.min.css";			
			@import "../../static/js/libs/css/ui-lightness/jquery-ui-1.10.2.custom.css";
		</style>
		<script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery.custom.js"></script>
		<script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery.dataTables.js"></script>		
		<script type="text/javascript" language="javascript" src="../../static/js/app/nominas/nominas.js"></script>
		

		<script type="text/javascript" charset="utf-8">
			var oTableNominas;
		</script>
	</head>
	<body id="dt_example">
		<div id="progressbar">Cargando (75%)...</div>	
		<div id="container" class="mayuscula">
			<h1>Nominas</h1>		
			<div id="demo">
				<form id="formConsultarNominas">
					<div style="text-align:right; padding-bottom:1em;">
						<!--button type="submit">Submit form</button-->
					</div>
					<table  cellpadding="0" cellspacing="0" border="0" class="display" id="tablaNomina">
					<thead>			
						<tr class="odd gradeA">
							<th>ID</th>
							<th>NOMBRE CORTO</th>					
							<th>ESQUEMA</th>
							<th>PATRONA</th>												
							<th>INTERMEDIARIA</th>												
							<th>PERIODICIDAD</th>
							<th>TIPO PAGO</th>
							<th>CLASE</th>
							<th></th>
							<th></th>
						</tr>
					<tbody>			
					</tbody>
					</thead>
					</table>
				</form>
			</div>
			
			<div id="Nomina">				
			</div>
			<br>
			<br>		
			<div>
				<input type="button" class="btn btn-success" value="Añadir Nomina" onclick="showAgregarNomina();"/>
			</div>
			<br>
			<br>
			<!-- div id="footer" class="clear" style="text-align:center;"><span style="font-size:10px;"> DataTables designed and created by <a href="http://www.sprymedia.co.uk">Allan Jardine</a> &copy; 2007-2011<br>
					DataTables is dual licensed under the <a href="http://www.datatables.net/license_gpl2">GPL v2 license</a> or a <a href="http://www.datatables.net/license_bsd">BSD (3-point) license</a>.
				</span -->
			</div>
		</div>
	</body>
</html>