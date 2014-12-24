<%@ page language='java' contentType='text/html; charset=ISO-8859-1'
	pageEncoding='ISO-8859-1'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>
<title>Cotizador</title>
	<link rel='stylesheet' href='../../static/css/crediFam.css' type='text/css'/>

</head>
	<script type='text/javascript' language='javascript' src='../../static/js/libs/js/jquery-1.9.1.js'></script>
  	<script type='text/javascript' language='javascript' src='../../static/js/libs/js/jquery-ui-1.10.2.custom.js'></script>
	<script type='text/javascript' language='javascript' src='../../static/js/libs/js/jquery-1.3.2.min.js'></script>
	<script type='text/javascript' language='javascript' src='../../static/js/libs/js/jquery.maskedinput-1.2.2.js'></script>
  	<script type='text/javascript' language='javascript' src='../../static/js/libs/js/jspdf.js'></script>
  	<script type='text/javascript' language='javascript' src='../../static/js/libs/js/adler32cs.js'></script>
  	<script type='text/javascript' language='javascript' src='../../static/js/libs/js/FileSaver.js'></script>
  	<script type='text/javascript' language='javascript' src='../../static/js/libs/js/blobbuilder.js'></script>
  	<script type='text/javascript' language='javascript' src='../../static/js/libs/js/jspdf.plugin.table.js'></script>
  	<script type='text/javascript' language='javascript' src='../../static/js/libs/js/jquery.tabletojson.js'></script>
  	<script type='text/javascript' language='javascript' src='../../static/js/libs/js/jquery.tabletojson.min.js'></script>
  	<script type='text/javascript' language='javascript' src='../../static/js/libs/js/deflate.js'></script>
  	<script type='text/javascript' language='javascript' src='../../static/js/app/credifam/cotizador.js'></script>
  
<body id='target'>

<div  style='margin-left: 100px;margin-top: 0px;'>
	<table >
		<tr>
		<td><label style='color:#6E6E6E;font-weight: bold;'>COTIZACIÓN CRÉDITO PERSONAL</label>&nbsp;<label style='color:#6E6E6E;font-weight: bold;'>DESCUENTO POR NÓMINA</label></td>
		</tr>
	</table>
</div>
</br>
<div id='table' class='CSS_Table_Example' style='width:750px;height:750px;'>
	<table border='1' align='center'>
		<tr>
		</tr>		
		<tr>
			<td>Solicitante/Empleado</br><input id='nombreEmpl' name='nombreEmpl' size='30' disabled
				value='<c:out value='${afiliado.nombreAfiliado}'/>&nbsp;<c:out value='${afiliado.appPaternoAfiliado}'/>&nbsp;<c:out value='${afiliado.appMaternoAfiliado}'/>' /></td>
			<td>Antig&uuml;edad</br><input id='antiguedad' name='antiguedad' size='30' type='text' disabled value='<c:out value='${afiliado.antiguedadAfiliado}'/>' /></td>
		</tr>
		<tr>
			<td>Tasa Fija Anual(IVA INCLUIDO)<input id='tasaFijaA' name='tasaFijaA' type='text' size='3'	value='27.6'  disabled />%</td>
			<td>CAT*<input id='cat' name='cat' type='text' value='27.1' size='3' disabled onchange='valorCat()' />% Sin IVA</td>
		</tr>
		<tr>
			<td>Tasa de comisión de gestión<input id='tasaComisionG' name='tasaComisionG' size='3' type='text'  value='2.5' disabled />%</td>
			<td>Escuela</br></br><c:forEach var="escuela" items="${afiliado.escuelas}"><c:out value='${escuela.nombreEscuela}'/>&nbsp;&nbsp;</c:forEach></td>
		</tr>
			
		<tr>
			<td>Sueldo Bruto Quincenal</br> $<input id='sueldoB' name='sueldoB' onkeyup="format(this)" onchange="format(this)" size='30'  type='text' /></td>
			<td>Sueldo Neto Quincenal </br>$<input id='sueldoN' name='sueldoN' onkeyup="format(this)" onchange="format(this)"size='30'   type='text'/></td>
		</tr>
		<tr>
			<td>Quincenas de Gracia</br><input id='quincenasGracia' name='quincenasGracia' value='4' disabled size='30' type='text' /></td>
			<td>Miembro FAM</br><select id='miembroFam' name='miembroFam'  onchange='obtenerCreditoMaximoAlcanzado();'>
					<option>Seleccione</option>
					<option>SI</option>
					<option>NO</option>
			</select></td>
		</tr>	
		<tr>
			<td>Credito Solicitado </br>$<input id='creditoS' name='creditoS' onkeyup="format(this)" onchange="format(this)" size='30' type='text'/></td>				
			<td>Crédito Máximo Alcanzado</br>$<input id='creditoAlcanzado' name='creditoAlcanzado' size='30' onkeyup="format(this)" onchange="format(this)" type='text'/></td>
				
		</tr>
		<tr>
			<td>Plazo Pagos (12, 24, 36, 48)</br><select id='plazoPagos' name='plazoPagos' onchange='obtenerNumeroPagos();'>
			<option>Plazo</option>
			<option>12</option>
			<option>24</option>
			<option>36</option>
			<option>48</option>
			</select> meses</td>
			<td>Plazo Creditos</br><input id='plazoCredito' name='plazoCredito' size='30' type='text' onchange='obtenerPlazoCredito();'/>meses</td>
		</tr>
		<tr>
			<td>Número de Pagos</br><input id='numeroP' name='numeroP' size='30' type='text'/></td>			
			<td>Forma de Pago</br><input id='formaP' name='formaP' size='30' type='text' value='Quincenal' disabled /></td>		
		</tr>
		<tr>
		</tr>
		<tr>
		<td></td>
		<td>Gestión FAM</br>$<input id='gestionFam' name='gestionFam' size='30' type='text' onkeyup="format(this)" onchange='format(this)' /></td>		
		</tr>
		<tr>
			<td>Descuento</br>$<input id='descuentoMensual' name='descuentoMensual' size='30' type='text'  onkeyup="format(this)" onchange="format(this)"/></td>		
			<td>Descuento Gestión(12 o 24 quincenas)</br>$<input id='descGestion' name='descGestion' size='30' type='text'  onkeyup="format(this)" onchange="format(this)"/></td>		
		</tr>
		<tr>
		</tr>	
		<tr>
			<td>Crédito Total</br>$<input id='creditoT' name='creditoT' size='30' type='text' onkeyup="format(this)" onchange="format(this)"/></td>
			<td>Pago Total</br>$<input id='pagoT' name='pagoT' size='30' type='text' onkeyup="format(this)" onchange="format(this)"/></td>
		</tr>
		<tr>
			<td>Fecha de Cotización</br><input id='fechaCotizacion' type='date' name='fechaCotizacion'/></td>
			<td>Estatus</br><input id='estatus' name='estatus' value='PENDIENTE' disabled size='30' type='text'/></td>
		</tr>				
	</table>
</div>
		<input id='botonCotizar' style='margin-left:420px; margin-top:10px' class='btn' name='botonCotizar' size='30' type='button' value='cotizar'  onclick='cotizar()' onclick='validar()'/>
<div>
	<table id='tbl' border=1 style='margin-left: 100px;margin-top: 60px;'>
		<tr>
			<td >
				<div id='resultadoCotizar'  >

				</div>
			</td >
			<td  >
				<div id='resultadoCotizar2'>
		
				</div>
			</td>
		<tr>
	</table>
</div>
<div id='resultadoGuardar'></div>
<div>
<table>
	<tr>
	<td><input id='guardar' class='btn' name='guardar' type='button'  onClick='guardarCotizacion()'  onclick='validar()' value='Guardar' style='display:none;margin-left:375px'/></td>
	<td><input id='descargar' class='btn' name='descargar' type='button'  value='Descargar PDF' style='display:none;margin-left:390px'/></td>
	<td><input id='reCotizar'  class='btn' name='reCotizar' type='button'  onClick='volverCotizar()'  value='Volver a Cotizar' style='display:none;'/></td>
	</tr>
</table>
</div>
</body>

</html>
