<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>grupo day</title>
<jsp:include page="../common/librerias.jsp"/>
 	<script type="text/javascript" language="javascript" src="../../static/js/app/patronas/agregar_patrona.js"></script>  
</head>

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
					 		<td>¿ES INTERMEDIARIA?<input id='intermediaria' name='intermediaria' type="checkbox" class="form-control"></td>
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
					 <table border=2>
				  		<tr>
						  	<td>
						  		<table>
						 			<tr><td>DOMICILIOS VIRTUALES</td></tr>
						  		</table>
				  			</td>
					  		</tr>						  		
					   		<tr>
						  		<td>
									<input id='domicilio' name='domicilio' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
					 				<button type="button" class="btn btn-default" onclick="agregarDomVirtual();">AÑADIR</button>
					 				<button type="button" class="btn btn-default" onclick="quitarDomVirtual();">QUITAR</button>
					 				<br>
					 				<select id="selectMult" multiple="multiple"></select>						 				
					 			</td>
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
					<table border=2>
				  		<tr>
						  	<td>
						  		<table>
						 			<tr><td>ACCIONISTAS</td></tr>
						  		</table>
				  			</td>
					  		</tr>						  		
					   		<tr>
						  		<td>
								NOMBRE<input id='nombreAccionista' name='nombreAccionista' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
					 			<button type="button" class="btn btn-default" onclick="agregarAccionista();">AÑADIR</button>
					 			<button type="button" class="btn btn-default" onclick="quitarAccionista();">QUITAR</button>
					 			<br>
					 			<select id="selectMultAccionista" multiple="multiple"></select>							 				
					 			</td>
					 		</tr>
					 </table>
					 <table border=2>
				  		<tr>
						  	<td>
						  		<table>
						 			<tr><td>PODERES NOTARIALES PLEITOS Y COBRANZAS</td></tr>
						  		</table>
				  			</td>
					  	</tr>						  		
					   	<tr>
						  		<td>
									<span style="float:left;">NUMERO</span><input id='numeroPoderesNot' name='numeroPoderesNot' type="text" class="form-control" style="width:150px;float:left;"/>
									<span style="float:left;">NOTARIA</span><input id='notariaPoderesNot' name='notariaPoderesNot' type="text" class="form-control" style="width:150px;float:left;"/>
									<span style="float:left;">NOTARIO</span><input id='notarioPoderesNot' name='notarioPoderesNot' type="text" class="form-control" style="width:150px;float:left;"/>
					 			<button type="button" class="btn btn-default" onclick="addRow('tablaPodNotPleitos',1);">AÑADIR</button>
					 			<button type="button" class="btn btn-default" onclick="deleteRow('tablaPodNotPleitos',1);">QUITAR</button>					 			
					 			<br>
									<table name="tablaPodNotPleitos" id="tablaPodNotPleitos">
										<tr>
											<td>NUMERO</td>
											<td>NOTARIA</td>
											<td>NOTARIO</td>
											<td>-</td>
										</tr>
									 </table>
									 <input type="text" id="podNotNum" value="0"/>
					 		</tr>
					 </table>
	 				<table border=2>
				  		<tr>
						  	<td>
						  		<table>
						 			<tr><td>REPRESENTANTES LEGALES PLEITOS Y COBRANZAS</td></tr>
						  		</table>
				  			</td>
					  		</tr>						  		
					   		<tr>
						  		<td>
								NOMBRE<input id='nombreRepresentantes' name='nombreRepresentantes' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
					 			<button type="button" class="btn btn-default" onclick="agregarRepresentantes();">AÑADIR</button>
					 			<button type="button" class="btn btn-default" onclick="quitarRepresentantes();">QUITAR</button>
					 			<br>
					 			<select id="selectMultRepresentantes" multiple="multiple"></select>							 				
					 			</td>
					 		</tr>
					 </table>
					 <table border=2>
				  		<tr>
						  	<td>
						  		<table>
						 			<tr><td>PODERES NOTARIALES LABORALES</td></tr>
						  		</table>
				  			</td>
					  	</tr>						  		
					   	<tr>
						  		<td>
						  		<span style="float:left;">NUMERO</span><input id='numeroPoderesNotLab' name='numeroPoderesNotLab' type="text" class="form-control" style="width:150px;float:left;"/>
								<span style="float:left;">NOTARIA</span><input id='notariaPoderesNotLab' name='notariaPoderesNotLab' type="text" class="form-control" style="width:150px;float:left;"/>
								<span style="float:left;">NOTARIO</span><input id='notarioPoderesNotLab' name='notarioPoderesNotLab' type="text" class="form-control" style="width:150px;float:left;"/>
					 			<button type="button" class="btn btn-default" onclick="addRow('tablaPodNotLab',2);">AÑADIR</button>
					 			<button type="button" class="btn btn-default" onclick="deleteRow('tablaPodNotLab',2);">QUITAR</button>					 			
					 			<br>
									<table name="tablaPodNotLab" id="tablaPodNotLab">
										<tr>
											<td>NUMERO</td>
											<td>NOTARIA</td>
											<td>NOTARIO</td>
											<td>-</td>
										</tr>
									 </table>
									 <input type="text" id="podNotLabNum" value="0"/>
	
					 		</tr>
					 </table>
					 					<table border=2>
				  		<tr>
						  	<td>
						  		<table>
						 			<tr><td>REPRESENTANTES LEGALES LABORALES</td></tr>
						  		</table>
				  			</td>
					  		</tr>						  		
					   		<tr>
						  		<td>
								NOMBRE<input id='nombreRepresentantesLegLab' name='nombreRepresentantesLegLab' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">					 			
					 			<button type="button" class="btn btn-default" onclick="agregarRepresentantesLegLab();">AÑADIR</button>
					 		<button type="button" class="btn btn-default" onclick="quitarRepresentantesLegLab();">QUITAR</button>
					 			<br>
					 			<select id="selectMultRepresentantesLegLab" multiple="multiple"></select>							 				
					 			</td>
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
