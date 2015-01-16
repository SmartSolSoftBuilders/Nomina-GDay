<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<!--link rel="shortcut icon" type="image/ico" href="http://www.datatables.net/media/images/favicon.ico" /-->
		
		<title>GDAY</title>
		<style type="text/css" title="currentStyle">
			@import "../../static/js/libs/css/demo_page.css";
 			@import "../../static/js/libs/css/demo_table.css";
 			@import "../../static/js/libs/css/bootstrap.min.css"; 			
 			@import "../../static/js/libs/css/ui-lightness/jquery-ui-1.10.2.custom.css";
		</style>
		<script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery.custom.js"></script>
		<script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery.dataTables.js"></script>		
		<script type="text/javascript" language="javascript" src="../../static/js/app/razones_sociales/razones_sociales.js"></script>
		

		<script type="text/javascript" charset="utf-8">
			var oTableRazonesSociales;
		</script>
	</head>
	<body id="dt_example">
		<div id="progressbar" >Cargando (75%)...</div>	
		<div id="container" class="mayuscula">
			<h1>Razones Sociales</h1>		
			<div id="demo">
				<form id="formConsultarRazonesSociales">
					<div style="text-align:right; padding-bottom:1em;">
						<!--button type="submit">Submit form</button-->
					</div>
					<table  cellpadding="0" cellspacing="0" border="0" class="display" id="tablaRazonSocial">
					<thead>			
						<tr class="odd gradeA">
							<th>ID</th>
							<th>RFC</th>
							<th>NOMBRE CORTO</th>					
							<th>COMISION</th>
							<th>RAZON SOCIAL</th>
							<th class='btn btn-success'></th>
							<th></th>
						</tr>
					<tbody>			
					</tbody>
					</thead>
					</table>
				</form>
			</div>
			
			<div id="RazonSocial">				
			</div>
			<br>
			<br>		
			<div>
				<input type="button" class="btn btn-success" value="Añadir" onclick="showAgregarRazonSocial();"/>
			</div>
			<br>
			<br>
		<div id="divNominas" title="Nominas Asignadas a la Razon Social" style="display:none">
		<div id="container" class="mayuscula">
			<h1>Nominas por Razon Social</h1>		
			<div id="demo">
				<form id="formConsultarNominas">
					<div style="text-align:right; padding-bottom:1em;">
						<!--button type="submit">Submit form</button-->
					</div>
					<table  cellpadding="0" cellspacing="0" border="0" class="display" id="tablaNominasPorRazonSocial">
					<thead>			
						<tr class="odd gradeA">
							<th width="40px">ID</th>
							<th width="200px">NOMBRE CORTO</th>					
							<th width="200px">ESQUEMA</th>
							<th width="200px">PATRONA</th>
							<th width="200px">INTERMEDIARIA</th>
							<th width="200px">PERIODICIDAD</th>
							<th width="200px">TIPO PAGO</th>
							<th width="200px">CLASE</th>
							<th width="200px">PORCENTAJE</th>
							<th width="200px">FECHA CONTRATO</th>
						</tr>
					<tbody>			
					</tbody>
					</thead>
					</table>
			</div>
			
			</div>
	</div>
			<!-- div id="footer" class="clear" style="text-align:center;"><span style="font-size:10px;"> DataTables designed and created by <a href="http://www.sprymedia.co.uk">Allan Jardine</a> &copy; 2007-2011<br>
					DataTables is dual licensed under the <a href="http://www.datatables.net/license_gpl2">GPL v2 license</a> or a <a href="http://www.datatables.net/license_bsd">BSD (3-point) license</a>.
				</span -->
			</div>
		</div>
	</body>
</html>