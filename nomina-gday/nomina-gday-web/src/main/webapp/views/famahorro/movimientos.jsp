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
		<script type="text/javascript" language="javascript" src="../../static/js/app/famahorro/movimientos.js"></script>

		<script type="text/javascript" charset="utf-8">
			var oTableCuentaFAM;
		</script>
	</head>
	<body id="dt_example">
		<div id="container">
			<div id="movFamAhorroDiv">
			<h1>Movimientos FAMAhorro</h1>
			Seleccione la cuenta de FamAhorro:<select id="cuentasfam" onchange="getCuentasFam()">
				<option value="">Seleccione...</option>
			</select>
			<br><div id="divcuenta"></div>
			<div id="demo">
				<form id="formMantenimientoCuentaFAM">
					<div style="text-align:right; padding-bottom:1em;">
						<!--button type="submit">Submit form</button-->
					</div>
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="tablaCuentaFAM">
					<thead>			
						<tr>
							<th>Folio</th>
							<th>Tipo de Movimiento</th>
							<th>Monto</th>
							<th>Referencia</th>	
							<th>Fecha</th>													
						</tr>
					<tbody>			
					</tbody>
					</thead>
					</table>					
				</form>				
				<br><div id="divsaldo"></div>				
				<div align="center">
				<input type="hidden" id="hidfechaapertura" name="hidfechaapertura"/>
				<input type="button" value="Registrar Movimiento" onclick="registrarMovimiento()"/>								
			</div>
			</div>
		</div>
	<body id="dt_example">
		<div id="container">
			<h1>Movimientos FAMAhorro Inversión</h1>
			Seleccione la cuenta de inversión:<select id="cuentasinv" onchange="getCuentasInv()">
				<option value="">Seleccione...</option>
			</select>
			<br><div id="divcuentainv"></div>
			<div id="demo">
				<form id="formMantenimientoCuentaFAMInv">
					<div style="text-align:right; padding-bottom:1em;">
						<!--button type="submit">Submit form</button-->
					</div>
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="tablaCuentaFAMInv">
					<thead>			
						<tr>
							<th>Folio</th>
							<th>Tipo de Movimiento</th>
							<th>Monto</th>
							<th>Referencia</th>	
							<th>Fecha</th>													
						</tr>
					<tbody>			
					</tbody>
					</thead>
					</table>					
				</form>
				<br><div id="divsaldoinv"></div>				
			</div>		
				
			<div id="divRegistroMov" title="Registro de Movimientos cuenta FAMAhorro">
				Tipo de Movimiento:
				<select id="tipomovimiento">
					<option value="DEPOSITO">DEPOSITO</option>
					<option value="RETIRO">RETIRO</option>
				</select>				
				<br>Monto:<input type="text" id="monto" name="monto"/>
				<br>Documento Referencia:<input type="text" id="documentoref" name="documentoref"/>
			</div>
			<div id="divRegistroMovInv" title="Registro de Movimientos cuenta FAMAhorro Inversión">
				Tipo de Movimiento:
				<select id="tipomovimientoinv">
					<option value="DEPOSITO">DEPOSITO</option>
					<option value="RETIRO">RETIRO</option>
				</select>				
				<br>Monto:<input type="text" id="montoinv" name="montoinv"/>
				<br>Documento Referencia:<input type="text" id="documentorefinv" name="documentorefinv"/>
			</div>
			<br>
			<br>		
			<div align="center">
				<input type="button" value="Registrar Movimiento" onclick="registrarMovimientoInv()"/>								
			</div>
			<br>
			<br>
			<!-- div id="footer" class="clear" style="text-align:center;"><span style="font-size:10px;"> DataTables designed and created by <a href="http://www.sprymedia.co.uk">Allan Jardine</a> &copy; 2007-2011<br>
					DataTables is dual licensed under the <a href="http://www.datatables.net/license_gpl2">GPL v2 license</a> or a <a href="http://www.datatables.net/license_bsd">BSD (3-point) license</a>.
				</span>
			</div-->
		</div>
	</body>
</html>