<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>GDAY</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
  <script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery.dataTables.js"></script>		
  <script type="text/javascript" language="javascript" src="../../static/js/app/patronas/actualizar_patrona.js"></script>
  
	<script src="../../static/js/bootstrap.min.js"></script>
	<script src="../../static/js/modal.js"></script>
	<!-- bootbox code -->
	<script src="../../static/js/bootbox.js"></script>

	<!-- put all demo code in one place -->
	<script src="../../static/js/control.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<link href="../../static/css/styles.css" rel="stylesheet">
<link href="../../static/css/multiple-select.css" rel="stylesheet">
<link href="../../static/css/bootstrap.min.css" rel="stylesheet">

</head>
<%session.setAttribute("titulo","AGREGAR NOMINA");%>

<body>
	<div class="container">
	<h1>Actualizar Patrona</h1>
		<div class="text-center col-lg-12">
			<div class="row">
				<div class="col-lg-6">
					<table>					
					 	<tr>
					 		<td>NOMBRE<input id='nombrePatrona' name='nombrePatrona' type="text" class="form-control"></td>
					 		<input id='idPatrona' name='idPatrona' type="hidden" class="form-control"></input>					 		
					 	</tr>
					 </table>
					<table>
						<tr>
						   <td>RAZON SOCIAL<input id='razonSocial' name='razonSocial' type="text" class="form-control"></td>
						</tr>
					</table>
					 <table>
					  	<tr>
					 		<td>RFC<input id='rfc' name='rfc' type="text" class="form-control"></td>
					 	</tr>
					  	<tr>
					 		<td>FOLIO MERCANTIL<input id='folioMerc' name='folioMerc' type="text" class="form-control"></td>
					 	</tr>
					  	<tr>
					 		<td>¿ES INTERMEDIARIA?<input id='intermediaria' name='intermediaria' type="checkbox" class="form-control"></td>
					 	</tr>					
					</table>
					 <table>
					  	<tr>
					 		<td>TIPO REGIMEN
					 		<select id='tipoReg' name='tipoReg' type="text" class="form-control">
		  							
							</select></td>
					 	</tr>
					  	<tr>
					  		<td>DOMICILIO FISCAL</td>
					 		<td>CALLE<input id='calle' name='calle' type="text" class="form-control"></td>
					 	</tr>
					  	<tr>
					 		<td>COLONIA<input id='colonia' name='colonia' type="text" class="form-control"></td>
					 	</tr>					
					</table>
					 <table>
					 	<tr>
					 		<td>NUMERO EXTERIOR<input id='numExt' name='numExt' type="text" class="form-control"></input></td>					 	
					 		<td></td>
					 		<td>NUMERO INTERIOR</td>
							<td><input id='numInt' name='numInt' type="text" class="form-control"/></td>					 	
					 	</tr>
					 </table>
					 <table>
					 	<tr>
					 		<td>CODIGO POSTAL<input id='cp' name='cp' type="text" class="form-control"/></td>					 	
					 		<td></td>
					 		<td>MUNICIPIO</td>
							<td><input id='municipio' name='municipio' type="text" class="form-control"/></td>					 	
					 	</tr>
					 </table>
					 <table>
					 	<tr>
					 		<td>ENTIDAD FEDERATIVA
					 		<select id='entidadFed' name='entidadFed' type="text" class="form-control">
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
					 		<td></td>
					 		<td>TELEFONO CONTACTO</td>
							<td><input id='telContacto' name='telContacto' type="text" class="form-control"/></td>					 	
					 	</tr>
					 </table>
					 <table>
					 	<tr>
					 		<td>DOMICILIOS VIRTUALES</td>
					 		<td></td>
					 		<td>DOMICILIO</td>
							<td><input id='domicilio' name='domicilio' type="text" class="form-control"/></td>
							<td>+<input id='agregarDom' name='agregarDom' type="text" class="form-control"/></td>
							<td><textarea id='domicilio' name='domicilio' type="text" class="form-control"></textarea></td>
							<td>-<input id='eliminarDom' name='eliminarDom' type="text" class="form-control"/></td>					 	
					 	</tr>
					 </table>
					  <table>
					 	<tr>
					 		<td>ACTA CONSTITUTIVA</td>
							<td>NUMERO<input id='numActaConst' name='numActaConst' type="text" class="form-control"/></td>					 	
					 		<td></td>
					 		<td>NUMERO NOTARIA</td>
							<td><input id='numNotaria' name='numNotaria' type="text" class="form-control"/></td>					 	
					 	</tr>
					 </table>	
					  <table>
					 	<tr>
							<td>FECHA<input id='fecha' name='fecha' type="date" class="form-control"/></td>					 	
					 		<td></td>
					 		<td>NOTARIO</td>
							<td><input id='notario' name='notario' type="text" class="form-control"/></td>					 	
					 		<td>CIUDAD</td>
							<td><input id='ciudad' name='ciudad' type="text" class="form-control"/></td>					 	
					 		<td>ESTADO</td>
							<td><input id='estado' name='estado' type="text" class="form-control"/></td>					 	
					 	</tr>
					 </table>
					 <table>
					 	<tr>
					 		<td>ACCIONISTAS</td>
					 		<td></td>
					 		<td>NOMBRE</td>
							<td><input id='nombreAccionista' name='nombreAccionista' type="text" class="form-control"/></td>
							<td>+<input id='agregarAccionista' name='agregarAccionista' type="text" class="form-control"/></td>
							<td><textarea id='accinistas' name='accinistas' type="text" class="form-control"></textarea></td>
							<td>-<input id='eliminarAccionista' name='eliminarAccionista' type="text" class="form-control"/></td>					 	
					 	</tr>
					 </table>
					 <table>
					 	<tr>
					 		<td>PODERES NOTARIALES PLEITOS Y COBRANZAS</td>
					 		<td></td>
							<td>NUMERO<input id='numeroPoderesNot' name='numeroPoderesNot' type="text" class="form-control"/></td>
							<td>NOTARIA<input id='notariaPoderesNot' name='notariaPoderesNot' type="text" class="form-control"/></td>
							<td>NOTARIO<input id='notarioPoderesNot' name='notarioPoderesNot' type="text" class="form-control"/></td>
							<td></td>
								<th>NUMERO</th>
								<th>NOTARIA</th>
								<th>NOTARIO</th>
					 	</tr>
					 </table>
					 <table>
					 	<tr>
					 		<td>REPRESENTANTES LEGALES PLEITOS Y COBRANZAS</td>
					 		<td></td>
					 		<td>NOMBRE</td>
							<td><input id='nombreRepresentantes' name='nombreAccionista' type="text" class="form-control"/></td>
							<td>+<input id='agregarRepresentantes' name='agregarRepresentantes' type="text" class="form-control"/></td>
							<td><textarea id='representantes' name='representantes' type="text" class="form-control"></textarea></td>
							<td>-<input id='eliminarRepresentantes' name='eliminarRepresentantes' type="text" class="form-control"/></td>					 	
					 	</tr>
					 </table>
					 <table>
					 	<tr>
					 		<td>PODERES NOTARIALES LABORALES</td>
					 		<td></td>
							<td>NUMERO<input id='numeroPoderesNotLab' name='numeroPoderesNotLab' type="text" class="form-control"/></td>
							<td>NOTARIA<input id='notariaPoderesNotLab' name='notariaPoderesNotLab' type="text" class="form-control"/></td>
							<td>NOTARIO<input id='notarioPoderesNotLab' name='notarioPoderesNotLab' type="text" class="form-control"/></td>
							<td></td>
								<th>NUMERO</th>
								<th>NOTARIA</th>
								<th>NOTARIO</th>
					 	</tr>
					 </table>
					 <table>
					 	<tr>
					 		<td>REPRESENTANTES LEGALES LABORALES</td>
					 		<td></td>
					 		<td>NOMBRE</td>
							<td><input id='nombreRepresentantesLegLab' name='nombreRepresentantesLegLab' type="text" class="form-control"/></td>
							<td>+<input id='agregarRepresentantesLegLab' name='agregarRepresentantesLegLab' type="text" class="form-control"/></td>
							<td><textarea id='representantesRepresentantesLegLab' name='representantesRepresentantesLegLab' type="text" class="form-control"></textarea></td>
							<td>-<input id='eliminarRepresentantesLegLab' name='eliminarRepresentantesLegLab' type="text" class="form-control"/></td>					 	
					 	</tr>
					 </table>
					 
					 <button type="button" class="btn btn-default" onclick="actualizarPatrona();">AGREGAR</button> 		
						 	
				<br>
				<br>
			</div>
			</div>
			</div>
	  </div>
	<div id='resultadoGuardar'></div>
	
</body>
</html>
