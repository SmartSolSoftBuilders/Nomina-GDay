<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		
		<title>GDAY</title>
		<jsp:include page="../common/librerias.jsp" />

		<script type="text/javascript" language="javascript" src="../../static/js/app/usuarios/usuarios.js"></script>
		
	</head>
	<body id="dt_example">
		<div id="progressbar" >Cargando (75%)...</div>	
		<div id="container" class="mayuscula">
			<h1>Usuarios</h1>		
			<div id="demo">
				<form id="formConsultarUsuarios">
					<div style="text-align:right; padding-bottom:1em;">
						<!--button type="submit">Submit form</button-->
					</div>
					<table  cellpadding="0" cellspacing="0" border="0" class="display" id="tablaUsuario">
					<thead>			
						<tr class="odd gradeA">
							<th>ID</th>
							<th>USUARIO</th>
							<th>NOMBRE</th>					
							<th>ESTATUS</th>					
							<th class='btn btn-success'></th>
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
				<input type="button" class="btn btn-success" value="AÑADIR USUARIO" onclick="showAgregarUsuario();"/>
			</div>
			<br>
			<br>
			<jsp:include page="../common/footer.jsp"/>	

			</div>
	</body>
</html>