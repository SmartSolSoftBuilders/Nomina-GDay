<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>grupo day</title>

<script type="text/javascript" language="javascript" src="static/js/app/grupos/agregar_grupo.js"></script>		

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
			<br>
			    <h2 style="color:#0051a4">Sistema de Gestión de Información <br>para Esquema de Pago de Nómina</h2><br><br>

			<br>
			<div class="row">
				<div class="col-lg-6">
					<table>
					 	<tr>
					 		<td>RAZON SOCIAL<input id='razonSocial' name='razonSocial' type="text" class="form-control"></td>
					 	</tr>
					 	<tr>
					 		<td>RFC<input id='rfc' name='rfc' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>NOMBRE CORTO<input id='nombreCorto' name='nombreCorto' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>CODIGO DE CLIENTE<input id='codCliente' name='codCliente' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>REFERENCIANTES<input id='referenciantes' name='referenciantes' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>OBJETO SOCIAL<input id='objetoSocial' name='objetoSocial' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>ACTA CONSTITUTIVA<input id='actaConst' name='actaConst' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>FECHA ACTA CONSTITUTIVA<input id='fechaActaConst' name='fechaActaConst' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>FECHA INICIO OPERACION<input id='fechaIniOper' name='fechaIniOper' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>REPRESENTANTE LEGAL</td>
					 		<td>APELLIDO PATERNO<input id='aPaterno' name='aPaterno' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>APELLIDO MATERNO<input id='aMaterno' name='aMaterno' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>NOMBRES<input id='nombres' name='nombres' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>DOMICILIO FISCAL</td>
					 		<td>CALLE<input id='calle' name='calle' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>COLONIA<input id='colonia' name='colonia' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>MUNICIPIO<input id='municipio' name='municipio' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>NUMERO EXT<input id='numeroExt' name='numeroExt' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>CODIGO POSTAL<input id='codPostal' name='codPostal' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>ESTADO<input id='estado' name='estado' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>NUMERO INT<input id='numeroInt' name='numeroInt' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>CONTACTO1</td>
					 		<td>NOMBRE<input id='nombreContUno' name='nombreContUno' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>TELEFONO<input id='telefonoContUno' name='telefonoContUno' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>CORREO<input id='correoContUno' name='correoContUno' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>CONTACTO2</td>
					 		<td>NOMBRE<input id='nombreContDos' name='nombreContDos' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>TELEFONO<input id='telefonoContDos' name='telefonoContDos' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>CORREO<input id='correoContDos' name='correoContDos' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>CONTACTO3</td>
					 		<td>NOMBRE<input id='nombreContTres' name='nombreContTres' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>TELEFONO<input id='telefonoContDos' name='telefonoContDos' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>CORREO<input id='correoContTres' name='correoContTres' type="text" class="form-control"></td>					 	
					 	</tr>
					</table>
				<br>
				<br>
			<!-- /.col-lg-6 -->						
				 <div class="input-group">      
			     	 <span class="input-group-btn">
			        	<button type="button" class="btn btn-default" onclick="guardarGrupo()">AÑADIR</button>
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