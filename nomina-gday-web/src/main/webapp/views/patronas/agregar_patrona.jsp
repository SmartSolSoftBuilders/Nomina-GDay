<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>grupo day</title>
<jsp:include page="../common/librerias.jsp"/>
 	<script type="text/javascript" language="javascript" src="../../static/js/app/patronas/agregar_patrona.js"></script>  
</head>
<%session.setAttribute("titulo","AGREGAR NOMINA");%>

<body>
	<div class="container">
	<h1>Agregar Patrona</h1>
		<div class="text-center col-lg-12">
			<div class="row">
				<div class="col-lg-6">
					<table>					
					 	<tr>
					 		<td>NOMBRE<input id='nombrePatrona' name='nombrePatrona' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 	</tr>
					 </table>
					<table>
						<tr>
						   <td>RAZON SOCIAL<input id='razonSocial' name='razonSocial' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
						</tr>
					</table>
					 <table>
					  	<tr>
					 		<td>RFC<input id='rfc' name='rfc' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 	</tr>
					  	<tr>
					 		<td>FOLIO MERCANTIL<input id='folioMerc' name='folioMerc' type="text" class="form-control"></td>
					 	</tr>
					  	<tr>
					 		<td>�ES INTERMEDIARIA?<input id='intermediaria' name='intermediaria' type="checkbox" class="form-control"></td>
					 	</tr>					
					</table>
					 <table>
					  	<tr>
					 		<td>TIPO REGIMEN
					 		<select id='tipoReg' name='tipoReg' type="text" class="form-control">
		  							
							</select></td>
					 		<td>DOMICILIO FISCAL</td>
					 		<td>CALLE<input id='calle' name='calle' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>COLONIA<input id='colonia' name='colonia' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
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
							<td><input id='municipio' name='municipio' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"/></td>					 	
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
					 		<td>DOMICILIO</td>					 	
							<td width="5%"></td>
					 		<td>DOMICILIOS VIRTUALES<input id='domicilio' name='domicilio' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
					 		<button type="button" class="btn btn-default" onclick="agregarDomVirtual();">A�ADIR</button>
					 		<button type="button" class="btn btn-default" onclick="quitarDomVirtual();">QUITAR</button>					 		
					 							 		
					 		<select id="selectMult" multiple="multiple"></select>				 		
					 	</tr>
					 </table>
					  <table>
					 	<tr>
					 		<td>ACTA CONSTITUTIVA</td>
					 		<td></td>
							<td>NUMERO<input id='numActaConst' name='numActaConst' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"/></td>					 	
					 		<td></td>
					 		<td>NUMERO NOTARIA<input id='numNotaria' name='numNotaria' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"/></td>					 	
							<td>FECHA<input id='fecha' name='fecha' type="date" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"/></td>					 	
					 		<td></td>
					 	</tr>
					 </table>
					 <table>
					 	<tr>
					 		<td>NOTARIO<input id='notario' name='notario' type="text" class="form-control"/></td>					 	
					 		<td>CIUDAD<input id='ciudad' name='ciudad' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"/></td>					 	
					 		<td>ESTADO<input id='estado' name='estado' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"/></td>
						</tr>
					</table>					 	
					 <table>
					 	<tr>
					 		<td>ACCIONISTAS</td>					 	
							<td width="5%"></td>
					 		<td>NOMBRE<input id='nombreAccionista' name='nombreAccionista' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
					 		<button type="button" class="btn btn-default" onclick="agregarAccionista();">A�ADIR</button>
					 		<button type="button" class="btn btn-default" onclick="quitarAccionista();">QUITAR</button>					 		
					 							 		
					 		<select id="selectMultAccionista" multiple="multiple"></select>					 	
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
							<td width="5%"></td>
					 		<td>NOMBRE<input id='nombreRepresentantes' name='nombreRepresentantes' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
					 		<button type="button" class="btn btn-default" onclick="agregarRepresentantes();">A�ADIR</button>
					 		<button type="button" class="btn btn-default" onclick="quitarRepresentantes();">QUITAR</button>					 		
					 							 		
					 		<select id="selectMultRepresentantes" multiple="multiple"></select>					 	
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
							<td width="5%"></td>
					 		<td>NOMBRE<input id='nombreRepresentantesLegLab' name='nombreRepresentantesLegLab' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
					 		<button type="button" class="btn btn-default" onclick="agregarRepresentantesLegLab();">A�ADIR</button>
					 		<button type="button" class="btn btn-default" onclick="quitarRepresentantesLegLab();">QUITAR</button>					 		
					 							 		
					 		<select id="selectMultRepresentantesLegLab" multiple="multiple"></select>							 	
					 	</tr>
					 </table>					 
					 <button type="button" class="btn btn-success" onclick="guardarPatrona();">AGREGAR</button>						 	
				<br>
				<br>
			</div>
			</div>
			</div>
	  </div>
	<div id='resultadoGuardar'></div>
		<jsp:include page="../common/footer.jsp"/>	
</body>
</html>
