<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>grupo day</title>
<jsp:include page="../common/librerias.jsp"/>
<script type="text/javascript" language="javascript"
	src="../../static/js/app/grupos/actualizar_grupo.js"></script>

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<link href="static/css/styles.css" rel="stylesheet">
<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
<link href="static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container" class="mayuscula">
		<div class="text-center col-lg-12">
			<div class="row">
				<div class="col-lg-6">
					<form id="actualizarGrupoForm" name="actualizarGrupoForm" novalidate="novalidate">
						<table>
							<tr>
								<td>NOMBRE<input id='nombre' name='nombre' type="text"
									class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
							</tr>
							<tr>
								<td>NOMBRE CORTO<input id='nombreCorto' name='nombreCorto'
									type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
							</tr>
						</table>
						<br> <br>
						<!-- /.col-lg-6 -->
						<div class="input-group">
							<span class="input-group-btn">
								<button type="button" class="btn btn-success"
									onclick="actualizarGrupo()">ACTUALIZAR</button>
							</span>
						</div>
						<!-- /input-group -->
					</form>
				</div>
			</div>
		</div>
	</div>
	<div id='resultadoGuardar'></div>
	<jsp:include page="../common/footer.jsp"/>	
</body>
</html>