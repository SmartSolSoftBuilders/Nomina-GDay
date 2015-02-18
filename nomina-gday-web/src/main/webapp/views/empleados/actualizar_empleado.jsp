<!DOCTYPE html>	
<html lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<title>grupo day</title>
	<jsp:include page="../common/librerias.jsp"/>
 	<script type="text/javascript" language="javascript" src="../../static/js/app/empleados/actualizar_empleado.js"></script>  
	</head>

<body>
	<div class="container">
		<h1><font color=#0051a4 class="mayuscula">Actualizar Empleado</font></h1>
		<div class="text-center col-lg-12">
			<div class="row">
			  <form id="actualizarEmpleadoForm" name="actualizarEmpleadoForm">			
				<div class="col-lg-6">
					<table>					
					 	<tr>
					 		<input id='idEmpleado' name='idEmpleado' type="hidden" class="form-control"  onkeyup="javascript:this.value=this.value.toUpperCase();">					 		
					 		<td>NUMERO DE CONTROL<input id='numeroControl' name='numeroControl' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>NSS<input id='nss' name='nss' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 		
					 		<td>CURP<input onchange="setFieldsCurp();" id='curp' name='curp' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 	</tr>
					</table>
					<table>
						<tr>
						   <td>PATERNO<input id='paterno' name='paterno' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 	   <td>MATERNO<input id='materno' name='materno' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
						</tr>
					</table>
					<table>
					  	<tr>					 	
					 		<td>NOMBRE<input id='nombre' name='nombre' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>RFC<input id='rfc' name='rfc' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 	</tr>					  						
					</table>
					<table>
					  	<tr>					 	
					 		<td>FECHA DE NACIMIENTO<input id='fechaNacimiento' name='fechaNacimiento' type="date" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>EDAD<input id='edad' name='edad' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>SEXO<input id='sexo' name='sexo' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>PAIS ORIGEN<select id='paisOrigen' name='paisOrigen' class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
					 						<option>MEXICO</option>
					 						<option>E.U.A</option>
					 						<option>CANADA</option>
					 						
					 		</select></td>
					 	</tr>					  						
					</table>
					<table>
					  	<tr>					 	
					 		<td>NACIONALIDAD<input id='nacionalidad' name='nacionalidad' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>ESTADO CIVIL<select id='estadoCivil' name='estadoCivil' class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
					 						<option>SOLTERO(A)</option>
					 						<option>CASADO(A)</option>
					 						<option>DIVORCIADO(A)</option>
					 						<option>UNION LIBRE</option>
					 			
					 		</select></td>
					 		<td>CORREO ELECTRONICO<input id='correoElectronico' name='correoElectronico' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 	</tr>					  						
					</table>
					<table>
					  	<tr>					 	
					 		<td>FECHA INGRESO<input id='fechaIngreso' name='fechaIngreso' type="date" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>LISTA NEGRA POR DEMANDA<input id='listaNegra' name='listaNegra' type="checkbox" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 	</tr>					  						
					</table>
					<table>
						<tr>
							<td>DOMICILIO</td>
						</tr>
					  	<tr>				 		
					 		<td>CALLE<input id='calle' name='calle' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>NUMERO EXTERIOR<input id='numExt' name='numExt' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>NUMERO INTERIOR<input id='numInt' name='numInt' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>COLONIA<input id='colonia' name='colonia' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>CODIGO POSTAL<input id='codPostal' name='codPostal' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>MUNICIPIO O DELEGACION<input id='municipioDel' name='municipioDel' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>ESTADO<select id='estado' name='estado' type="text" class="form-control">
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
					</table>
					<table>
						<tr>
							<td>DOCUMENTOS</td>
						</tr>
					  	<tr>				 		
					 		<td>IDENTIFICACION OFICIAL<input id='indentificacionOficial' name='indentificacionOficial' type="checkbox" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>ACTA DE NACIMIENTO<input id='actaNacimiento' name='actaNacimiento' type="checkbox" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>CURP<input id='curpDoc' name='curpDoc' type="checkbox" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>RFC<input id='rfcDoc' name='rfcDoc' type="checkbox" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>COMPROBANTE DE DOMICILIO<input id='comprobanteDom' name='comprobanteDom' type="checkbox" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 	</tr>					  						
					</table>
					<table>
					  	<tr>				 		
					 		<td>COMPROBANTE DE ESTUDIOS<input id='comprobanteEst' name='comprobanteEst' type="checkbox" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>CORREO ELECTRONICO<input id='correoElec' name='correoElec' type="checkbox" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>CUENTA CLABE<input id='cuentaClave' name='cuentaClave' type="checkbox" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>PREAFILIACION IMSS<input id='preafiliacionImss' name='preafiliacionImss' type="checkbox" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 	</tr>
					</table>	
					<table>
						<tr>
							<td>DATOS BANCARIOS</td>
						</tr>
					  	<tr>				 		
					 		<td>NUMERO DE CUENTA<input id='numCuenta' name='numCuenta' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>BANCO<select id='banco' name='banco' class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
					 			     <option>BANCOMER VBBA</option>
					 			     <option>BANAMEX</option>
					 			     <option>SCOTIANK BANK INVERLAT</option>
					 			
					 		</select></td>
					 		<td>TIPO DE PAGO<select id='tipoPago' name='tipoPago' class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
					 				<option>EFECTIVO</option>
					 				<option>CHEQUE</option>
					 				
					 		</select></td>
					 		
					 	</tr>					  						
					</table>				  						
					<table>
						<tr>
							<td>DATOS INFONAVIT<input id='numCuenta' name='numCuenta' type="checkbox" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
							<td></td>
							<td>NUMERO DE CREDITO<input id='numCredito' name='numCredito' type="text" class="form-control" onclick="habilitar();"></td>
					 		<td>DESCUENTO VSMG<input id='descuentoVsmg' name='descuentoVsmg' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>DESCUENTO %<input id='descuento' name='descuento' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>IMPORTE<input id='importe' name='importe' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 		
					 	</tr>					  						
					</table>				  						
					<table>
						<tr>
							<td>FONACOT<input id='fonacot' name='fonacot' type="checkbox" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
							<td></td>
							<td>NUMERO DE PAGOS<input id='numPagos' name='numPagos' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>IMPORTE<input id='importeFonacot' name='importeFonacot' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 		
					 	</tr>					  						
					</table>				  						
					<table>
						<tr>
							<td>PENSION ALIMENTICIA<input id='pensionAlimenticia' name='pensionAlimenticia' type="checkbox" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
							<td></td>
					 		<td>IMPORTE<input id='importeAlimenticio' name='importeAlimenticio' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 		
							<td>%<input id='porcentajeAlimenticio' name='porcentajeAlimenticio' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
							<td>NOMBRE ACREEDOR<input id='nombreAcreedor' name='nombreAcreedor' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
							<td>OBSERVACIONES<input id='observaciones' name='observaciones' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 	</tr>					  						
					</table>				  						
				<br>
				<table width=900px>
					<tr>
						<td>NOMINAS ASIGNADAS</td>
					</tr>
				</table>
				<table border=2>
					   	<tr>
						  		<td>
							 		<button type="button" class="btn btn-success" onclick="agregarNominaAEmpleado();">AÑADIR</button>
						 		  <%if (session.getAttribute("rolUser").equals("ROLE_ADMINISTRADOR")){%>
										<button type="button" class="btn btn-success" onclick="shoBajaNominaForm();">ELIMINAR</button>
						            <%} %>  
									<button type="button" class="btn btn-success" onclick="editarObjetoJS();">EDITAR</button>					 			
					 			<br>
									<table name="tablanominasasignadas" id="tablanominasasignadas">
										<tr>
											<td>NÓMINA</td>
											<td>ESTATUS</td>
											<td>Seleccionar</td>
										</tr>
									 </table>
									 <input type="text" id="nominasNum" value="0"/>
							 	</td>
					 		</tr>
					 </table>
						<!-- /.col-lg-6 -->
								 <div class="input-group">      
			     	 <span>
			        	<button type="button" class="btn btn-success" onclick="actualizarEmpleado();">ACTUALIZAR</button>
			        	<button type="button" class="btn btn-success" onclick="cancelar();">CANCELAR</button>
			     	 </span>			    
   		 		</div><!-- /input-group -->
	 		  </form>	 				
			</div>
			</div>
			</div>
	  </div>
	 <div id="divSeleccionNominaParaEmpleado"
	 		title="SELECCIONE UNA N&#211;MINA PARA ASIGNAR" style="display: none" >
				<div id="tablaSelNominas">
					<table cellpadding="0" cellspacing="0" border="0" class="display"
						id="tablaNominas">
						<thead>
							<tr class="odd gradeA">
								<th>ID</th>
								<th>NOMBRE CORTO</th>
								<th>ESQUEMA</th>
								<th>PATRONA</th>
								<th>INTERMEDIARIA</th>
								<th>PERIODICIDAD</th>
								<th>TIPO PAGO</th>
								<th>CLASE</th>
								<th></th>
							</tr>
						<tbody>
						</tbody>
						</thead>
					</table>	
				</div>
			</div>

			<div id="tablaFormNominas" title="INGRESE LOS DATOS NÓMINA-EMPLEADO" style="display: none" >
			 <form id="actualizarNominaEmpleadoForm" name="actualizarNominaEmpleadoForm" novalidate="novalidate">
				<table>					
				 	<tr>
				 		<td>FECHA DE INGRESO<input id='fechaingresoformnomina' name='fechaingresoformnomina'  class="form-control" type="date" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
				 		<td>ESTATUS<select id='estatusformnomina' name='estatusformnomina' class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
				 				<option value="ACTIVO">ACTIVO</option>
				 				<option value="BAJA">BAJA</option>
				 			</select>
				 		</td>
				 		<td>TIPO SALARIO<select id='tiposalarioformnomina' name='tiposalarioformnomina' class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
				 				<option value="1">SALARIO 1</option>
				 			</select>
				 		</td>					 			
					</tr>
					<tr>
				 		<td>FECHA DE BAJA<input id='fechabajaformnomina' name='fechabajaformnomina'  class="form-control" type="date" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
				 		<td>TIPO CONTRATO<select id='tipocontratoformnomina' name='tipocontratoformnomina' class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
				 				<option value="1">TIPO 1</option>
				 			</select>
				 		</td>
				 		<td>FECHA DE VENCIMIENTO<input id='fechavencimientoformnomina' name='fechavencimientoformnomina' class="form-control" type="date" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 		
					</tr>
					<tr>
						<td>SUELDO MENSUAL<input id='sueldomensualformnomina' name='sueldomensualformnomina' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
				 		<td>SUELDO DIARIO<input id='sueldodiarioformnomina' name='sueldodiarioformnomina' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
				 		<td>SUELDO DIARIO INTEGRADO<input id='sueldodiariointformnomina' name='sueldodiariointformnomina' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 		
					</tr>
					<tr>
				 		<td>LOTE MOVIMIENTO ALTA IMSS<input id='loteimssformnomina' name='loteimssformnomina' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
				 		<td>PLAZA DE TRABAJO<select id='plazatrabajoformnomina' name='plazatrabajoformnomina' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
				 				<option value="PLAZA 1">PLAZA 1</option>
				 			</select>
				 		</td>
				 		<td>NÚMERO TRABAJADOR CLIENTE<input id='numtrabajadorclienteoformnomina' name='numtrabajadorclienteoformnomina' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 		
					</tr>
					<tr>
				 		<td>¿TIENE OTRO PATRÓN?<select id=otropatronformnomina name='otropatronformnomina' class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
				 				<option value="SI">SI</option>
				 				<option value="SI">NO</option>
				 			</select>
				 		</td>
				 		<td>NOMBRE OTRO PATRÓN<input id='nombreotropatronformnomina' name='nombreotropatronformnomina' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
				 		<td>RFC<input id='rfcnformnomina' name='rfcnformnomina' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 		
					</tr>
					<tr>
						<td>REQUIERE DOMICILIO DE TRABAJO (PERMANENCIAS)</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
				 		<td>CALLE<input id='calleformnomina' name='calleformnomina' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
				 		<td>NUM EXT<input id='numextformnomina' name='numextformnomina' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
				 		<td>NUM INT<input id='numintformnomina' name='numintformnomina' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 		
					</tr>
					<tr>
				 		<td>CODIGO POSTAL<input id='cpformnomina' name='cpformnomina' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
				 		<td>nomasignadavolverhidden:<input id='idnominaformnomina' name='idnominaformnomina' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
				 		<td>nomasignadavolverhidden:<input id='nombrenominaformnomina' name='nombrenominaformnomina' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
				 		<input id='statnominaformnomina' name='statnominaformnomina' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
				 		</td>					 		
					</tr>
					<tr>
				 		<td>COLONIA<input id='coloniaformnomina' name='coloniaformnomina' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
				 		<td>MUNICIPIO O DELEGACIÓN<input id='mundelformnomina' name='mundelformnomina' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
				 		<td>ESTADO<select id='estadoformnomina' name='estadoformnomina' class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
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
							</select>					 		
				 		</td>				 							 		
					</tr>
					<tr>
				 		<td>SUMINISTROS<select id='suministrosformnomina' name='suministrosformnomina'  class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
				 				<option value="SUM1">SUM1</option>
				 			</select>
				 		</td>
						<td>ACTIVIDADES<select id='actividadesformnomina' name='actividadesformnomina'  class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
								<option value="ACTIV1">ACTIV1</option>
							</select>
						</td>
				 		<td>PUESTOS<select id='puestosformnomina' name='puestosformnomina' class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
				 				<option value="PUESTO1">PUESTO1</option>
				 			</select>
				 		</td>					 		
					</tr>							
					<tr>
						 <td></td>
						 <td>SERVICIOS<select id='serviciosformnomina' name='serviciosformnomina'  class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
								<option value="SERV1">SERV1</option>
								<option value="SERV2">SERV2</option>
						 	</select>
						 </td>
						 <td>ÁREA<select id='areaformnomina' name='areaformnomina' class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
								<option value="AREA1">AREA1</option>	
							</select>						 
						 </td>					 		
					</tr>
						
					<tr>
						<td></td>
						<!-- button id="buttonAgregar" type="button" class="btn btn-success" onclick="agregarObjetoJS();">AGREGAR</button></td-->
						<td><button id="buttonAgregar" type="button" class="btn btn-success" onclick="guardarCambiosNominaEmpleado('../../mvc/empleado/guardarempleadonomina');">AGREGAR</button></td> 
						<td><button id="buttonGuardar" type="button" class="btn btn-success" onclick="guardarCambiosNominaEmpleado('../../mvc/empleado/guardareditarempleadonomina');">ACTUALIZAR</button></td>
						<td><button type="button" class="btn btn-success" onclick="hideNominaForm();">CANCELAR</button></td>
					</tr>
				</table>
			   </form>
			</div>
			
			<div id="tablaBajaFormNominas" title="INGRESE LOS DATOS DE BAJA NÓMINA-EMPLEADO" style="display: none" >
			 <form id="bajaNominaEmpleadoForm" name="bajaNominaEmpleadoForm" novalidate="novalidate">
				<table>					
				 	<tr>
				 		<td>FECHA DE BAJA<input id='fechabajaTmpformnomina' name='fechabajaTmpformnomina'  class="form-control" type="date" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
				 		<td>LOTE MOVIMIENTO BAJA IMSS<input id='loteimssbajaformnomina' name='loteimssbajaformnomina' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
				 		<td>¿APLICA FINIQUITO?<select id=aplicafiniquitoformnomina name='aplicafiniquitoformnomina' onclick="habilitaMontoFiniquito();" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();">
				 				<option value="SI">SI</option>
				 				<option value="NO">NO</option>
				 			</select>
				 		</td>	
				 	</tr>
				 	<tr>
				 		<td></td>			 		
				 		<td>MONTO<input id='montofiniquitoformnomina' name='montofiniquitoformnomina' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
				 		<td><button id="buttonAgregar" type="button" class="btn btn-success" onclick="darBajaNominaEmpleado();" >ACEPTAR</button></td>			 			
					</tr>
				</table>
			</form>
			</div>
	  	
	<div id='resultadoGuardar'></div>
	<jsp:include page="../common/footer.jsp"/>	
</body>
</html>
