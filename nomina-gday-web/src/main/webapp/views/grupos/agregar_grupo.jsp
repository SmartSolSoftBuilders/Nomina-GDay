<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>grupo day</title>
<jsp:include page="../common/librerias.jsp" />
<script type="text/javascript" language="javascript"
	src="../../static/js/app/grupos/agregar_grupo.js"></script>
</head>
<body>
	<div class="container" class="mayuscula">
		<h1><font color=#0051a4 class="mayuscula">Grupos</font></h1>
		<div class="text-center col-lg-12">
			<div class="row">
				<div class="col-lg-6">
					<form id="agregarGrupoForm" name="agregarGrupoForm"
						novalidate="novalidate">

						<table>
							<tr>
								<td>NOMBRE<input id='nombre' name='nombre' type="text"
									class="form-control"
									onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
							</tr>
							<tr>
								<td>NOMBRE CORTO<input id='nombreCorto' name='nombreCorto'
									type="text" class="form-control"
									onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
							</tr>
						</table>
						<br> <br>
						<!-- /.col-lg-6 -->
						<div class="input-group">
							<span>
								<button type="button" class="btn btn-success"
									onclick="guardarGrupo()">AGREGAR</button>
							</span> <span>
								<button type="button" class="btn btn-success"
									onclick="cancelar()">CANCELAR</button>
							</span>
						</div>
						<!-- /input-group -->
					</form>
				</div>
			</div>
		</div>
	</div>
	<div id='resultadoGuardar'></div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>