<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">	<meta charset="utf-8">
	<title>GDAY</title>
		<jsp:include page="../common/librerias.jsp"/>  
		<script type="text/javascript" language="javascript" src="../../static/js/app/razones_sociales/actualizar_razonsocial.js"></script>		
</head>
<body>	
	<div class="container" class="mayuscula">
	<h1><font color=#0051a4 class="mayuscula">Actualizar Razones Sociales</font></h1>	
		<div class="text-center col-lg-12">
			<div class="row">
				<div class="col-lg-6" align="center">
				<form  id="editarRazonSocialForm" name="editarRazonSocialForm" novalidate="novalidate">					
					<table>
					 	<tr>
					 		<td>RAZON SOCIAL<input id='nombreRazonSocial' name='nombreRazonSocial' type="text" class="form-control" size=50 required onkeyup="javascript:this.value=this.value.toUpperCase();"/>
					 		<input id='razonSocialIdSel' name='razonSocialIdSel' type="hidden" />
					 		</td>
					 	</tr>
					 </table>
					 <table border="2">
					 	<tr>	
					 		<td>RFC<input id='rfc' name='rfc' type="text" class="form-control" maxlength="13" size="13" onblur="validaRfc(this.value)" onkeyup="javascript:this.value=this.value.toUpperCase();"/></td>
					 		<td width="5%"></td>					 
					 		<td>NOMBRE CORTO<input id='nombreCorto' name='nombreCorto' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 	
						</tr>
						<tr>					 	
					 		<td>CODIGO DE CLIENTE<input id='codCliente' name='codCliente' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 	
						 	<td width="5%"></td>
					 		<td>GRUPO<input id='grupo' name='grupo' readonly=true  type="text" class="form-control" onclick="showGrupos()">
					 		<input id='grupoIdSel' name='grupoIdSel' type="hidden" class="form-control"></td>						 	
					 	</tr>
					 	<tr>
					 		<td>COMISION<input id='comision' name='comision' type="text" class="form-control"></td>					 	
							<td width="5%"></td>
					 		<td>REFERENCIANTES<input id='referenciante' name='referenciante' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
					 		<button type="button" class="btn btn-default" onclick="agregarReferenciante();">AÑADIR</button>
					 		<button type="button" class="btn btn-default" onclick="quitarReferenciante();">QUITAR</button>					 		
					 							 		
					 		<select id="selectMult" multiple="multiple"></select>
					 	</tr>					 	
					 	<tr>
					 		<td>OBJETO SOCIAL<textarea id='objetoSocial' name='objetoSocial' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></textarea></td>					 	
							<td width="5%"></td>					 	
					 		<td>ACTA CONSTITUTIVA<input id='actaConst' name='actaConst' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>FECHA ACTA CONSTITUTIVA<input id='fechaActaConst' name='fechaActaConst' type="date" class="form-control"></td>					 	
					 		<td width="5%"></td>
					 		<td>FECHA INICIO OPERACION<input id='fechaIniOper' name='fechaIniOper' type="date" class="form-control"></td>					 	
					 	</tr>
					 	</table>
					 	<table>
					 	<tr>
					 		<td>REPRESENTANTE LEGAL</td>
					 		<td width="5%"></td>					 		
					 		<td>APELLIDO PATERNO<input id='aPaterno' name='aPaterno' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>						
					 		<td>APELLIDO MATERNO<input id='aMaterno' name='aMaterno' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 	
					 		<td>NOMBRES<input id='nombres' name='nombres' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 	
					 	</tr>
					 	</table>
					 	<table>
					 	<tr>
					 		<td>DOMICILIO FISCAL</td>
					 	</tr>
					 	<tr>
					 		<td>CALLE<input id='calle' name='calle' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 	
					 		<td>NUMERO EXT<input id='numeroExt' name='numeroExt' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 	
					 		<td>NUMERO INT<input id='numeroInt' name='numeroInt' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>COLONIA<input id='colonia' name='colonia' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 	
					 		<td>CODIGO POSTAL<input id='codPostal' name='codPostal' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 	
					 		<td>MUNICIPIO<input id='municipio' name='municipio' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 	</tr>
					 	<tr>
					 	<td>ESTADO
					 		<select id='estado' name='estado' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
		  							<option>AGUASCALIENTES</option>
		  							<option>BAJA CALIFORNIA</option>
		  							<option>BAJA CALIFORNIA SUR</option>
		  							<option>CAMPECHE</option>
		  							<option>CHIAPAS</option>
		  							<option>CHIHUAHUA</option>
		  							<option>COAHUILA</option>
		  							<option>COLIMA</option>
		  							<option>DISTRITO FEDERAL</option>
		  							<option>DURANGO</option>
		  							<option>GUANAJUATO</option>
		  							<option>GUERRERO</option>
		  							<option>HIDALGO</option>
		  							<option>JALISCO</option>
		  							<option>MEXICO</option>
		  							<option>MICHOACAN</option>
		  							<option>MORELOS</option>
		  							<option>NAYARIT</option>
		  							<option>NUEVO LEON</option>
		  							<option>OAXACA</option>
		  							<option>PUEBLA</option>
		  							<option>QUERETARO</option>
		  							<option>QUINTANA ROO</option>
		  							<option>SAN LUIS POTOSI</option>
		  							<option>SINALOA</option>
		  							<option>SONORA</option>
		  							<option>TABASCO</option>
		  							<option>TAMAULIPAS</option>
		  							<option>TLAXCALA</option>
		  							<option>VERACRUZ</option>
		  							<option>YUCATAN</option>
		  							<option>ZACATECAS</option>
							</select></td>						 				 	
					 	</tr>
					 	<tr>					 	
					 		<td>REGISTRO PUBLICO DE LA PROPIEDAD<input id='regPublicoPropiedad' name='regPublicoPropiedad' type="text" class="form-control"  onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td></td>					 	
					 		<td>FECHA DE REGISTRO PUBLICO DE LA PROPIEDAD<input id='fechaRegPublicoPropiedad' name='fechaRegPublicoPropiedad' type="date" class="form-control"></td>
					 	</tr>
					 	</table>					 	
					 	<table>
					 	<tr>
					 		<td>CONTACTO1</td>
					 	</tr>
					 	</table>
					 	<table>
					 	<tr>
					 		<td>NOMBRE<input id='nombreContUno' name='nombreContUno' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 	
					 		<td>TELEFONO<input id='telefonoContUno' name='telefonoContUno' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 	
					 		<td>CORREO<input id='correoContUno' name='correoContUno' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 	
					 	</tr>
					 	</table>
					 	<table>
					 	<tr>
					 		<td>CONTACTO2</td>
					 	</tr>
					 	</table>
					 	<table>					 	
					 	<tr>
					 		<td>NOMBRE<input id='nombreContDos' name='nombreContDos' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 	
					 		<td>TELEFONO<input id='telefonoContDos' name='telefonoContDos' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 	
					 		<td>CORREO<input id='correoContDos' name='correoContDos' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 	
					 	</tr>
					 	</table>
					 	<table>
					 	<tr>
					 		<td>CONTACTO3</td>
					 	</tr>
					 	</table>
					 	<table>	
					 	<tr>				 	
					 		<td>NOMBRE<input id='nombreContTres' name='nombreContTres' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 	
					 		<td>TELEFONO<input id='telefonoContTres' name='telefonoContTres' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 	
					 		<td>CORREO<input id='correoContTres' name='correoContTres' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 	
					 	</tr>
						</table>
				
				<br>
				<br>
				 <div class="input-group" style="position:absolute">      
			     	 <span>
			        	<button type="button" class="btn btn-success" onclick="actualizarRazonSocial();">GUARDAR</button>
			     	   	<button type="button" class="btn btn-success" onclick="cancelar();">CANCELAR</button>
			     	 </span>			    
				</div>
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
							<th width="40px">ID</th>
							<th width="200px">NOMBRE CORTO</th>					
							<th width="200px">NOMBRE</th>
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
		<jsp:include page="../common/footer.jsp"/>	
</body>
</html>
