<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>grupo day</title>
<jsp:include page="../common/librerias.jsp"/>
 	<script type="text/javascript" language="javascript" src="../../static/js/app/empleados/agregar_empleado.js"></script>  
</head>
<%session.setAttribute("titulo","AGREGAR NOMINA");%>

<body>
	<div class="container">
	<h1><font color=#0051a4 class="mayuscula">Actualizar Empleado</font></h1>
		<div class="text-center col-lg-12">
			<div class="row">
				<div class="col-lg-6">
					<table>					
					 	<tr>
					 		<td>NUMERO DE CONTROL<input id='numeroControl' name='numeroControl' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>NSS<input id='nss' name='nss' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 		
					 		<td>CURP<input id='curp' name='curp' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
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
					 		<td>PAIS ORIGEN<select id='paisOrigen' name='paisOrigen' type="date" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></select></td>
					 	</tr>					  						
					</table>
					 <table>
					  	<tr>					 	
					 		<td>NACIONALIDAD<input id='nacionalidad' name='nacionalidad' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 		<td>ESTADO CIVIL<select id='estadoCivil' name='estadoCivil' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></select></td>
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
					 		<td>ESTADO<select id='estado' name='estado' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></select></td>
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
					 		<td>BANCO<select id='banco' name='banco' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></select></td>
					 		<td>TIPO DE PAGO<select id='tipoPago' name='tipoPago' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></select></td>
					 		
					 	</tr>					  						
					</table>				  						
					<table>
						<tr>
							<td>DATOS INFONAVIT<input id='numCuenta' name='numCuenta' type="checkbox" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
							<td></td>
							<td>NUMERO DE CREDITO<input id='numCredito' name='numCredito' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
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
				<br>
				<!-- /.col-lg-6 -->						
				 <div class="input-group">      
			     	 <span>
			        	<button type="button" class="btn btn-success" onclick="guardarEmpleado();">ACTUALIZAR</button>
			        	<button type="button" class="btn btn-success" onclick="cancelar();">CANCELAR</button>
			     	 </span>			    
   		 		</div><!-- /input-group -->
			</div>
			</div>
			</div>
	  </div>
	<div id='resultadoGuardar'></div>
		<jsp:include page="../common/footer.jsp"/>	
</body>
</html>
