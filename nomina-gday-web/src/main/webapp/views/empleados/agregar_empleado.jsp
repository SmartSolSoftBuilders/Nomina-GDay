<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>grupo day</title>
<jsp:include page="../common/librerias.jsp"/>
 	<script type="text/javascript" language="javascript" src="../../static/js/app/patronas/agregar_patrona.js"></script>  
</head>
<%session.setAttribute("titulo","AGREGAR NOMINA");%>

<body>
	<div class="container">
	<h1>Agregar Patrona</h1>
		<div class="text-center col-lg-12">
			<div class="row">
				<div class="col-lg-6">
					<table>					
					 	<tr>
					 		<td>CURP<input id='curp' name='curp' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 	</tr>
					 </table>
					<table>
						<tr>
						   <td>PATERNO<input id='paterno' name='paterno' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
						</tr>
					</table>
					 <table>
					  	<tr>
					 		<td>MATERNO<input id='materno' name='materno' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 	</tr>
					  	<tr>
					 		<td>NOMBRE<input id='nombre' name='nombre' type="text" class="form-control"></td>
					 	</tr>
					  	<tr>
					 		<td>NSS<input id='nss' name='nss' type="text" class="form-control"></td>
					 	</tr>					  						
					</table>
				<br>
				<br>
			</div>
			</div>
			</div>
	  </div>
	<div id='resultadoGuardar'></div>
		<jsp:include page="../common/footer.jsp"/>	
</body>
</html>
