<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		
		<title>GDAY</title>
		<jsp:include page="../common/librerias.jsp" />

		<script type="text/javascript" language="javascript" src="../../static/js/app/razones_sociales/razones_sociales.js"></script>
		
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
							 <%if (session.getAttribute("rolUser").equals("ROL_ADMINISTRADOR")){%>							 			
							<th class='btn btn-success'></th>
							<th></th>
							<%} %>							
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
				 <%if (session.getAttribute("rolUser").equals("ROL_ADMINISTRADOR")){%>				
				<input type="button" class="btn btn-success" value="AÑADIR" onclick="showAgregarRazonSocial();"/>
				<%} %>
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
			<jsp:include page="../common/footer.jsp"/>	

			</div>
		</div>
	</body>
</html>