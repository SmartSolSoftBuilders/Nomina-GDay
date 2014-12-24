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
		<script type="text/javascript" language="javascript" src="../../static/js/app/credifam/cotizaciones.js"></script>
	
		<script type="text/javascript" charset="utf-8">
			var oTableCotizaciones;
		</script>
	</head>
	<body id="dt_example">
		<div id="progressbar">Cargando (75%)...</div>	
		<div id="container" style="margin-left:100px">
			<h1>Cotizaciones</h1>		
			<div id="demo">
				<form id="formMantenimiento">
					<div style="text-align:right; padding-bottom:1em;">
						<!--button type="submit">Submit form</button-->
					</div>
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="tablaCotizaciones">
					<thead>			
						<tr class="odd gradeA">
							<th>IdCotizacion</th>
							<th>Plazo Pagos</th>
							<th>Plazo creditos</th>					
							<th>N&uacute;mero de Pagos</th>
							<th>Forma de pago</th>
							<th>Descuento</th>
							<th>Descuento Gesti�n</th>
							<th>Credito Total</th>							
							<th>Pago Total</th>
							<th>Fecha de cotizaci&oacute;</th>
							<th>Estatus</th>
						</tr>
					</thead>
					</table>
				</form>
			</div>
			</div>
	</body>
</html>