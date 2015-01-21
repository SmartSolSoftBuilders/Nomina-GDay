<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>grupo day</title>
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="../../static/js/libs/js/jquery.validate.js"></script>
	<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
	
	<script src="../../static/js/bootstrap.min.js"></script>
	<script src="../../static/js/modal.js"></script>
	<script src="../../static/js/bootbox.js"></script>
	<script src="../../static/js/control.js"></script>
	
	<script src="../../static/js/common.js"></script>
	<link href="../../static/css/styles.css" rel="stylesheet">
	<link href="../../static/css/multiple-select.css" rel="stylesheet">
	
<script type="text/javascript" language="javascript" src="../../static/js/app/grupos/agregar_grupo.js"></script>		

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="../../static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container" class="mayuscula">
	<h1>Grupos</h1>	
		<div class="text-center col-lg-12">
			<div class="row">
				<div class="col-lg-6">
					<table>
					 	<tr>
					 		<td>NOMBRE<input id='nombre' name='nombre' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 	</tr>
					 	<tr>
					 		<td>NOMBRE CORTO<input id='nombreCorto' name='nombreCorto' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 	
					 	</tr>
					</table>
				<br>
				<br>
			<!-- /.col-lg-6 -->						
				 <div class="input-group">
			     	 <span>
			        	<button type="button" class="btn btn-success" onclick="guardarGrupo()">AGREGAR</button>
			     	 </span>
			     	 <span>
			        	<button type="button" class="btn btn-success" onclick="cancelar()">CANCELAR</button>
			     	 </span>
   		 		</div><!-- /input-group -->
				</div>
			</div>
			</div>
	  </div>
	<div id='resultadoGuardar'></div>
	<!-- /.container -->
	<!-- JS dependencies -->
	<div id="mensaje" title="Mensaje" style="display:none">
	</div>
</body>
</html>