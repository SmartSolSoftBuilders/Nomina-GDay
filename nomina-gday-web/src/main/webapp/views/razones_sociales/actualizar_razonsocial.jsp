<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>grupo day</title>
<jsp:include page="../common/librerias.jsp"/>  

<script type="text/javascript" language="javascript" src="../../static/js/app/razones_sociales/actualizar_razonsocial.js"></script>

</head>
<body>
	<div class="container" class="mayuscula">
	<h1><font color=#0051a4 class="mayuscula">Actualizar Razones Sociales</font></h1>	
		<div class="text-center col-lg-12">
			<div class="row">
				<div class="col-lg-6">
					<form  id="editarRazonSocialForm" name="editarRazonSocialForm" novalidate="novalidate">
					<table>
					 	<tr>
					 		<td>RAZON SOCIAL<input id='nombreRazonSocial' name='nombreRazonSocial' type="text" class="form-control"></td>
					 		<td><input id='razonSocialIdSel' name='razonSocialIdSel' type="hidden" class="form-control" /></td>					 						 		
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
					 							 		<button type="button" class="btn btn-default" onclick="quitarReferenciante();">QUITAR</button>					 		
					 							 		
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
					 		<td>FECHA ACTA CONSTITUTIVA<input id='fechaActaConst' name='fechaActaConst' type="date" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>FECHA INICIO OPERACION<input id='fechaIniOper' name='fechaIniOper' type="date" class="form-control"></td>					 	
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
			     	 <span>
			        	<button type="button" class="btn btn-success" onclick="actualizarRazonSocial();">MODIFICAR</button>
			     	 </span>			    
			     	 <span>
			        	<button type="button" class="btn btn-success" onclick="cancelar();">CANCELAR</button>
			     	 </span>			    
   		 		</div><!-- /input-group -->
   		 		</form>
				</div>
			</div>
			</div>
	  </div>
	<div id='resultadoGuardar'></div>
	<div id="divGrupos" title="Seleccionar Grupo" style="display:none">
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
