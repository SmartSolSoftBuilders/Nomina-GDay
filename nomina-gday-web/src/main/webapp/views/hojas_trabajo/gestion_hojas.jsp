<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>grupo day</title>
  <jsp:include page="../common/librerias.jsp"/>	
  <script type="text/javascript" language="javascript" src="../../static/js/app/hojas_trabajo/gestion_hojas.js"></script>
</head> 
<body>
	<div class="container" class="mayuscula">
	<h1><font color=#0051a4 class="mayuscula">Gesi&oacute;n de Formato Por N&oacute;mina</font></h1>
		<div class="text-center col-lg-12">
			<div class="row">
				<div class="col-lg-6">
			<form:form method="post" action="../../mvc/hoja/carga" enctype="multipart/form-data" commandName="fileFormBean">
			    <table>
			        <tr>
			          <td colspan="2" align="center">Seleccione el Archivo:<input type="file" name="fichero" /></td>
			          <td><input type="text" id="idNomSubirArchivo" name="idNomSubirArchivo"/></td>
			        </tr>
			        <tr>
			        	<td colspan="2" align="center">
			        	<input type="submit" value="Subir Archivo">
			        	</td>
			        </tr>
			     </table>          
			</form:form>
				</div>
			</div>
			</div>
	  </div>
	<div id='resultadoGuardar'></div>
	<!-- /.container -->
	<!-- JS dependencies -->
	<div id="divSeleccionPlantillas" title="Selecci&oacute;n de Raz&oacute;n Social" >
		<div id="container" class="mayuscula">
			<h1>Formatos:</h1>		
			<div id="demo">
				<div style="text-align:right; padding-bottom:1em;">
				</div>
				<table  cellpadding="0" cellspacing="0" border="0" class="display" id="tablaPlantillas">
					<thead>			
						<tr class="odd gradeA">
							<th width="40px">ID</th>
							<th width="200px">FORMATO</th>
							<th width="200px">ESTATUS</th>															
							<th width="200px"></th>
							<th width="200px"></th>
						</tr>
						<tbody>			
						</tbody>
					</thead>
				</table>
			</div>
		</div>
	</div>
	

	<jsp:include page="../common/footer.jsp"/>
	
</body>
</html>