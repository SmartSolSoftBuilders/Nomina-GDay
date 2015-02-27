<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<!--link rel="shortcut icon" type="image/ico" href="http://www.datatables.net/media/images/favicon.ico" /-->

<title>GDAY</title>
<jsp:include page="../common/librerias.jsp" />

<script type="text/javascript" language="javascript"
	src="../../static/js/app/nominas/nominas.js"></script>
</head>
<body id="dt_example">
	<input id='idNomina' name='idNomina' type="hidden" class="form-control"></input>
	<div id="progressbar">Cargando (75%)...</div>
	<div id="container" class="mayuscula">
		<h1>Nominas</h1>
		<div id="demo">
			<form id="formConsultarNominas">
				<div style="text-align: right; padding-bottom: 1em;">
					<!--button type="submit">Submit form</button-->
				</div>
				<table cellpadding="0" cellspacing="0" border="0" class="display"
					id="tablaNomina">
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
							<%if (session.getAttribute("rolUser").equals("ROL_ADMINISTRADOR")){%>	
							<th></th>
							<th></th>
							<%} %>
							<%if (session.getAttribute("rolUser").equals("ROL_CALIDAD_INFORMACION")){%>	
							<th></th>
							<th></th>
							<%} %>
						</tr>
					<tbody>
					</tbody>
					</thead>
				</table>
			</form>
		</div>

		<div id="Nomina"></div>
		<br> <br>
		<div>
		<%if (session.getAttribute("rolUser").equals("ROL_ADMINISTRADOR")){%>	
			<input type="button" class="btn btn-success" value="AÑADIR NOMINA"
				onclick="showAgregarNomina();" />
		 <%} %>
		<%if (session.getAttribute("rolUser").equals("ROL_CALIDAD_INFORMACION")){%>	
			<input type="button" class="btn btn-success" value="AÑADIR NOMINA"
				onclick="showAgregarNomina();" />
		 <%} %>
		</div>
		<br> <br>
		<!-- 			Modal para consultar Empleado por Nomina -->
		<div class="row">
			<div id="divSeleccionNominaPorEmpleado"
				title="CONSULTA DE EMPLEADOS POR N&#211;MINA" style="display: none"
				class="col-lg-6">
				<table cellpadding="0" cellspacing="0" border="0" class="display"
					id="tablaEmpleados">
					<thead>
						<tr class="odd gradeA">
							<th>ID</th>
							<th>CURP</th>
							<th>PATERNO</th>
							<th>MATERNO</th>
							<th>NOMBRE</th>
							<th>NSS</th>
						</tr>
					<tbody>
					</tbody>
					</thead>
				</table>
				<input type="button" class="btn btn-success"
					value="DESCARGAR NOMINA" onclick="ajax_download();" /> <br> <br>
			</div>
		</div>
			<jsp:include page="../common/footer.jsp"/>	

	</div>


	</div>
</body>
</html>