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
			<td>NÓMINA
				<select id='nomina' name='nomina' class="form-control" onchange="obtenerPeriodos();"></select>
			</td>
		</tr>
	</table>
	<table>
		<tr>			
			<td>MES DE PAGO
				<select style="width:35%;" id='mesPago' name='mesPago'  class="form-control">
					<option value="">seleccione...</option>
					<option value="1">ENE</option>
					<option value="2">FEB</option>
					<option value="3">MAR</option>
					<option value="4">ABR</option>
					<option value="5">MAY</option>
					<option value="6">JUN</option>
					<option value="7">JUL</option>
					<option value="8">AGO</option>
					<option value="9">SEP</option>
					<option value="10">OCT</option>
					<option value="11">NOV</option>
					<option value="12">DIC</option>										
				</select>				
			</td>					
			<td>AÑO DE PAGO
				<select id='anioPago' style="width:35%;" name='anioPago' class="form-control">
					<option value="">seleccione...</option>
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
					<select id='periodo' style="width:35%;" name='periodo'  class="form-control"></select>
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
