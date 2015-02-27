<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<!--link rel="shortcut icon" type="image/ico" href="http://www.datatables.net/media/images/favicon.ico" /-->
		
		<title>GDAY</title>
		<jsp:include page="../common/librerias.jsp"/>
		
		<script type="text/javascript" language="javascript" src="../../static/js/app/patronas/patronas.js"></script>
	</head>
	<body id="dt_example">
		<div id="progressbar">Cargando (75%)...</div>	
		<div id="container" class="mayuscula">
			<h1>Patronas</h1>		
			<div id="demo">
				<form id="formConsultarPatronas">
					<div style="text-align:right; padding-bottom:1em;">
						<!--button type="submit">Submit form</button-->
					</div>
					<table  cellpadding="0" cellspacing="0" border="0" class="display" id="tablaPatrona">
					<thead>			
						<tr class="odd gradeA">
							<th>NOMBRE</th>
							<th>TIPO REGIMEN</th>
							<%if (session.getAttribute("rolUser").equals("ROL_ADMINISTRADOR")){%>							 						 											
							<th></th>
							<%} %>							
							<%if (session.getAttribute("rolUser").equals("ROL_CALIDAD_INFORMACION")){%>							 						 											
							<th></th>
							<%} %>							
						</tr>
					</thead>
					</table>
				</form>
			</div>
			
			<div id="Patrona">				
			</div>
			<br>
			<br>		
			<div>
			 <%if (session.getAttribute("rolUser").equals("ROL_ADMINISTRADOR")){%>		
				<input type="button" class="btn btn-success" value="AGREGAR" onclick="showAgregarPatrona();"/>
			<%} %>			
			 <%if (session.getAttribute("rolUser").equals("ROL_CALIDAD_INFORMACION")){%>		
				<input type="button" class="btn btn-success" value="AGREGAR" onclick="showAgregarPatrona();"/>
			<%} %>			
			</div>
			<br>
			<br>
						<jsp:include page="../common/footer.jsp"/>	
			</div>
	</body>
</html>