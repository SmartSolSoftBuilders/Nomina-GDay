<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>grupo day</title>
  <jsp:include page="../common/librerias.jsp"/>	
  <script type="text/javascript" language="javascript" src="../../static/js/app/hojas_trabajo/generar_hoja.js"></script>
</head> 
<body>
	<div class="container" class="mayuscula">
	<h3><font color=#0051a4 class="mayuscula">GENERAR ARCHIVO DE TRABAJO</font></h3>
	</div>	
	<div id='resultadoGuardar'></div>
	<!-- /.container -->
	<!-- JS dependencies -->
	<div id="divSeleccionPlantillas" title="Selecci&oacute;n de Raz&oacute;n Social" >
		<div id="container" class="mayuscula">
			<h3>N&oacute;minas:</h3>		
			<div id="demo">
				<div style="text-align:right; padding-bottom:1em;">
				</div>
				<table  cellpadding="0" cellspacing="0" border="0" class="display" id="tablaPlantillas">
					<thead>			
						<tr class="odd gradeA">
							<th width="40px">ID</th>
							<th width="200px">N�MINA</th>
							<th width="200px">PATRONA</th>																													
							<th width="200px"></th>
						</tr>
						<tbody>			
						</tbody>
					</thead>
				</table>
			</div>
		</div>
	</div>
	<input type="hidden" id="hojaTrabajoHid" name="hojaTrabajoHid"/>

	<jsp:include page="../common/footer.jsp"/>
	
</body>
</html>