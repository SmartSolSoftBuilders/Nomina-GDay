<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>grupo day</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">

  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="../../static/js/libs/js/jquery.validate.js"></script>
  <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
  <script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery.dataTables.js"></script>		
  
  <script src="../../static/js/bootstrap.min.js"></script>
  <script src="../../static/js/modal.js"></script>

	<!-- bootbox code -->
  <script src="../../static/js/bootbox.js"></script>

	<!-- put all demo code in one place -->
  <script src="../../static/js/control.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <script type="text/javascript" language="javascript" src="../../static/js/app/razones_sociales/actualizar_razonsocial.js"></script>

<link href="../../static/css/styles.css" rel="stylesheet">
<link href="../../static/css/multiple-select.css" rel="stylesheet">
<link href="../../static/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<div class="container">

		<div class="text-center col-lg-12">
			<div class="row">
				<div class="col-lg-6">
					<form  id="editarRazonSocialForm" name="editarRazonSocialForm" novalidate="novalidate">
					<table>
					 	<tr>
					 		<td>RAZON SOCIAL<input id='nombreRazonSocial' name='nombreRazonSocial' type="text" class="form-control"></td>
					 		<input id='razonSocialIdSel' name='razonSocialIdSel' type="hidden" class="form-control"></td>					 						 		
					 	</tr>
					 </table>
					 <table>
					 	<tr>
					 		<td>RFC<input id='rfc' name='rfc' type="text" class="form-control"></td>					 	
						 	<td></td>
					 		<td>NOMBRE CORTO<input id='nombreCorto' name='nombreCorto' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>CODIGO DE CLIENTE<input id='codCliente' name='codCliente' type="text" class="form-control"></td>					 	
							<td></td>
					 		<td>GRUPO<input id='grupo' name='grupo' type="text" class="form-control" onclick="showGrupos()">
					 		<input id='grupoIdSel' name='grupoIdSel' type="hidden" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>COMISION<input id='comision' name='comision' type="text" class="form-control"></td>					 	
					 		<td></td>
					 		<td>REFERENCIANTES<input id='referenciante' name='referenciante' type="text" class="form-control">
					 		<select id="selectMult" multiple="multiple">
					 		</select><button type="button" class="btn btn-default" onclick="agregarReferenciante();">AÑADIR</button>					 		
					 		</td>		 		
					 	</tr>
					 	<tr>				 	
					 		<td></td>
						 	<td></td>
					 		<td>OBJETO SOCIAL<textarea id='objetoSocial' name='objetoSocial' type="text" class="form-control"></textarea></td>					 	
					 	</tr>
					 	<tr>
					 		<td>ACTA CONSTITUTIVA<input id='actaConst' name='actaConst' type="text" class="form-control"></td>					 	
							<td></td>
					 		<td>FECHA ACTA CONSTITUTIVA<input id='fechaActaConst' name='fechaActaConst' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>FECHA INICIO OPERACION<input id='fechaIniOper' name='fechaIniOper' type="text" class="form-control"></td>					 	
					 	</tr>
					 	</table>
					 	<table>
					 	<tr>
					 		<td>REPRESENTANTE LEGAL</td>
					 	</tr>
					 	</table>
					 	<table>
					 		<td>APELLIDO PATERNO<input id='aPaterno' name='aPaterno' type="text" class="form-control"></td>					 	
					 		<td></td>
					 		<td>APELLIDO MATERNO<input id='aMaterno' name='aMaterno' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>NOMBRES<input id='nombres' name='nombres' type="text" class="form-control"></td>
					 		<td></td>					 	
					 	</tr>
					 	</table>
					 	<table>
					 	<tr>
					 		<td>DOMICILIO FISCAL</td>
					 	</tr>
					 	</table>
					 	<table>
					 		<tr>
					 		<td>CALLE<input id='calle' name='calle' type="text" class="form-control"></td>					 	
						 	<td></td>						 	
					 		<td>NUMERO EXT<input id='numeroExt' name='numeroExt' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>NUMERO INT<input id='numeroInt' name='numeroInt' type="text" class="form-control"></td>					 	
							<td></td>
					 		<td>COLONIA<input id='colonia' name='colonia' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>CODIGO POSTAL<input id='codPostal' name='codPostal' type="text" class="form-control"></td>					 	
							<td></td>					 	
					 		<td>MUNICIPIO<input id='municipio' name='municipio' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>ESTADO<input id='estado' name='estado' type="text" class="form-control"></td>					 	
							<td></td>
							<td></td>					 	
					 	</tr>
					 	</table>
					 	<table>
					 	<tr>
					 		<td>CONTACTO1</td>
					 	</tr>
					 	</table>
					 	<table>
					 	<tr>
					 		<td>NOMBRE<input id='nombreContUno' name='nombreContUno' type="text" class="form-control"></td>					 	
					 		<td>TELEFONO<input id='telefonoContUno' name='telefonoContUno' type="text" class="form-control"></td>					 	
					 		<td>CORREO<input id='correoContUno' name='correoContUno' type="text" class="form-control"></td>					 	
					 	</tr>
					 	</table>
					 	<table>
					 	<tr>
					 		<td>CONTACTO2</td>
					 	
					 	</tr>
					 	</table>
					 	<table>
					 	<tr>
					 		<td>NOMBRE<input id='nombreContDos' name='nombreContDos' type="text" class="form-control"></td>
					 		<td>TELEFONO<input id='telefonoContDos' name='telefonoContDos' type="text" class="form-control"></td>					 	
					 		<td>CORREO<input id='correoContDos' name='correoContDos' type="text" class="form-control"></td>					 	
					 							 	
					 	</tr>
					 	</table>
					 	<table>
					 	<tr>
					 		<td>CONTACTO3</td>
					 	</tr>
					 	</table>
					 	<table>
					 	<tr>
					 		<td>TELEFONO<input id='telefonoContTres' name='telefonoContTres' type="text" class="form-control"></td>					 	
					 		<td>CORREO<input id='correoContTres' name='correoContTres' type="text" class="form-control"></td>
					 		<td>NOMBRE<input id='nombreContTres' name='nombreContTres' type="text" class="form-control"></td>					 	
					 	</tr>
					</table>
				<br>
				<br>
			<!-- /.col-lg-6 -->						
				 <div class="input-group">      
			     	 <span class="input-group-btn">
			        	<button type="button" class="btn btn-default" onclick="actualizarRazonSocial();">MODIFICAR</button>
			     	 </span>			    
   		 		</div><!-- /input-group -->
   		 		</form>
				</div>
			</div>
			</div>
	  </div>
	<div id='resultadoGuardar'></div>
	<div id="divGrupos" title="Basic dialog" style="display:none">
		<div id="container" class="mayuscula">
			<h1>Seleccion de Grupos</h1>		
			<div id="demo">
				<form id="formSeleccionarGrupos">
					<div style="text-align:right; padding-bottom:1em;">
						<!--button type="submit">Submit form</button-->
					</div>
					<table  cellpadding="0" cellspacing="0" border="0" class="display" id="tablaGrupo">
					<thead>			
						<tr class="odd gradeA">
							<th>NUMERO GRUPO</th>
							<th>NOMBRE CORTO</th>					
							<th>NOMBRE</th>
							<th></th>
						</tr>
					<tbody>			
					</tbody>
					</thead>
					</table>
				</form>
			</div>
			
			</div>
	</div>
	<!-- /.container -->
	<!-- JS dependencies -->
	
</body>
</html>