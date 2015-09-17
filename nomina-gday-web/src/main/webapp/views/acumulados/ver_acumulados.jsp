<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../common/librerias.jsp"/>
 <script type="text/javascript" language="javascript" src="../../static/js/app/acumulados/ver_acumulados.js"></script>  
<style>
.ui-dialog-titlebar { display:none; }
</style>
<div id="container" >	
	<h3 color=#0051a4 class="mayuscula">Seleccione los datos para mostrar los acumulados:</h3>
</div>
<div align="center">
	<table>
		<tr>
			<td>GRUPO
				<select id='grupo' style="width:150px;" name='grupo'  class="form-control"></select>
			</td>
			<td>PATRONA
				<select id='patrona' style="width:150px;" name='patrona'  class="form-control"></select>
			</td>			
			<td>NÓMINA
				<select id='nomina' style="width:150px;" name='nomina' class="form-control" onchange="obtenerPeriodos();obtenerNssCurp();"></select>
			</td>
		</tr>
	</table>
	<table>
		<tr>			
			<td>MES DE PAGO
				<select style="width:150px;" id='mesPago' name='mesPago'  class="form-control">
					<option value="0">seleccione...</option>
					<option value="ENE">ENE</option>
					<option value="FEB">FEB</option>
					<option value="MAR">MAR</option>
					<option value="ABR">ABR</option>
					<option value="MAY">MAY</option>
					<option value="JUN">JUN</option>
					<option value="JUL">JUL</option>
					<option value="AGO">AGO</option>
					<option value="SEP">SEP</option>
					<option value="OCT">OCT</option>
					<option value="NOV">NOV</option>
					<option value="DIC">DIC</option>										
				</select>				
			</td>					
			<td>AÑO DE PAGO
				<select id='anioPago' style="width:150px;" name='anioPago' class="form-control">
					<option value="0">seleccione...</option>
					<option value="2000">2000</option>
					<option value="2001">2001</option>
					<option value="2002">2002</option>
					<option value="2003">2003</option>
					<option value="2004">2004</option>
					<option value="2005">2005</option>
					<option value="2006">2006</option>
					<option value="2007">2007</option>
					<option value="2008">2008</option>
					<option value="2009">2009</option>
					<option value="2010">2010</option>
					<option value="2011">2011</option>
					<option value="2012">2012</option>
					<option value="2013">2013</option>
					<option value="2014">2014</option>
					<option value="2015">2015</option>
					<option value="2016">2016</option>
					<option value="2017">2017</option>
					<option value="2018">2018</option>
					<option value="2019">2019</option>
					<option value="2020">2020</option>
					<option value="2021">2021</option>
					<option value="2022">2022</option>
					<option value="2023">2023</option>
					<option value="2024">2024</option>
					<option value="2025">2025</option>
					<option value="2026">2026</option>
				</select>				
				</td>
				<td>NÚMERO DE PERIODO
					<select id='periodo' style="width:150px;" name='periodo'  class="form-control"></select>
				</td>
			</tr>
			<tr>				
				<td>TIPO CALENDARIO
					<select id='tipoCalendario' style="width:150px;" name='tipoCalendario'  class="form-control"></select>			
				<td>CURP
					<select id='curp' style="width:150px;" name='curp'  class="form-control"></select>
				</td>
				<td>NSS
					<select id='nss' style="width:150px;" name='nss'  class="form-control"></select>
				</td>				
			</tr>
			</table>
			<br>	
			<div id="divLoadingNoms" title="Por favor espere"  class="col-lg-6">
				Por favor espere, se están obteniendo las nóminas..........................
				<center>
					<img name="imgLoading2" id="imgLoading2" height="15" src="../../static/img/loading_bar2.gif"></img>
				</center>
			</div>		
			<table>
				<tr>	
					<td align="center">					
						<input style="width:300px;" id="obtenerAcumBtn" name="obtenerAcumBtn" type="button" onclick="obtenerAcumuladosVal();" class="form-control" value="Obtener Acumulado (Archivo Excel)">
					</td>
					<td>
					</td>
				</tr>
			</table>
		<br>              				
</div>
