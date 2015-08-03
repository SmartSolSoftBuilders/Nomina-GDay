<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		
		<title>GDAY</title>
		<jsp:include page="../common/librerias.jsp"/>
				
		<script type="text/javascript" language="javascript" src="../../static/js/app/grupos/grupos.js"></script>
		
	</head>
	<body id="dt_example">
		<div id="progressbar">Cargando (75%)...</div>	
		<div id="container" class="mayuscula">
			<h1>Grupos</h1>		
			<div id="demo">
				<form id="formSeleccionarGrupos">
					<div style="text-align:right; padding-bottom:1em;">
						<!--button type="submit">Submit form</button-->
					</div>
					<table  cellpadding="0" cellspacing="0" border="0" class="display" id="tablaGrupo">
					<thead>			
						<tr class="odd gradeA">
							<th>NUMERO GRUPO</th>
							<th>NOMBRE</th>
							<th>NOMBRE CORTO</th>
							<%if (session.getAttribute("rolUser").equals("ROL_ADMINISTRADOR")){%>						 					
							<th></th>
							 <%} %>							
							<%if (session.getAttribute("rolUser").equals("ROL_CALIDAD_INFORMACION")){%>						 					
							<th></th>
							 <%} %>							
						</tr>
					<tbody>			
					</tbody>
					</thead>
					</table>
				</form>
			</div>
			
			<div id="Grupo"></div>
			
			<br>
			<br>
			<div>
			<%if (session.getAttribute("rolUser").equals("ROL_ADMINISTRADOR")){%>							 
				<input type="button" class="btn btn-success" value="AÑADIR GRUPO" onclick="showAgregarGrupo();"/>
			 <%} %>							
			<%if (session.getAttribute("rolUser").equals("ROL_CALIDAD_INFORMACION")){%>							 
				<input type="button" class="btn btn-success" value="AÑADIR GRUPO" onclick="showAgregarGrupo();"/>
			 <%} %>							
			</div>
			<br>
			<br>

			</div>
		<jsp:include page="../common/footer.jsp"/>	
	</body>
</html>