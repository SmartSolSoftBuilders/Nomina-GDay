<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>grupo day</title>

<script type="text/javascript" language="javascript" src="static/js/app/grupos/actualizar_grupo.js"></script>		

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<link href="static/css/styles.css" rel="stylesheet">
<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
<link href="static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">

		<div class="text-center col-lg-12">
			<div class="row">
				<div class="col-lg-6">
					<table>
					 	<tr>
					 		<td>NOMBRE<input id='nombre' name='nombre' type="text" class="form-control"></td>
					 	</tr>
					 	<tr>
					 		<td>NOMBRE CORTO<input id='nombreCorto' name='nombreCorto' type="text" class="form-control"></td>					 	
					 	</tr>
					</table>
				<br>
				<br>
			<!-- /.col-lg-6 -->						
				 <div class="input-group">      
			     	 <span class="input-group-btn">
			        	<button type="button" class="btn btn-success" onclick="actualizarGrupo()">AGREGAR</button>
			     	 </span>			    
   		 		</div><!-- /input-group -->
				</div>
			</div>
			</div>
	  </div>
	<div id='resultadoGuardar'></div>
	<!-- /.container -->
	<!-- JS dependencies -->
	<script
		src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/modal.js"></script>
	<script>
        $(function() {
            Example.init({
                "selector": ".bb-alert"
            });
        });
    </script>

	<!-- bootbox code -->
	<script src="static/js/bootbox.js"></script>

	<!-- put all demo code in one place -->
	<script src="static/js/control.js"></script>
</body>
</html>