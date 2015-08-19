<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../common/librerias.jsp"/>
<script type="text/javascript" language="javascript" src="../../static/js/app/acumulados/acumulado_periodo.js"></script>  
<style>
	.ui-dialog-titlebar { display:none; }
</style>
<body id="dt_example">
<div id="container" >
	<h3 color=#0051a4 class="mayuscula">Seleccione los datos para mostrar los acumulados:</h3>
</div>
<div align="center">
<%if (session.getAttribute("notification")!=null){%>
	<%=session.getAttribute("notification")%>
	<%session.setAttribute("notification","");%>
<%}%>
<form:form id="formSub" name="formSub" method="post" action="../../mvc/acumulado/subiracumuladoPeriodo" enctype="multipart/form-data" commandName="fileFormBean">
	<table>
		<tr>
			<td>N�MINA
				<select id='nomina' name='nomina' class="form-control" onchange="obtenerPeriodos();"></select>
			</td>
		</tr>
	</table>
	<table>
		<tr>			
			<td>MES DE PAGO
				<select style="width:35%;" id='mesPago' name='nomina'  class="form-control">
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
			<td>A�O DE PAGO
				<select id='anioPago' style="width:35%;" name='periodo' class="form-control">
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
				</select>				
				</td>
				<td>N�MERO DE PERIODO
					<select id='periodo' style="width:35%;" name='periodo'  class="form-control"></select>
				</td>
			</tr>
			</table>
			<br>
			<table>
				<tr>	
					<td align="center">
						<input style="width:300px;" id="obtenerAcumBtn" id="obtenerAcumBtn" type="button" onclick="obtenerAcumulados();$('#botonSubmit').show();" class="form-control" value="Consultar Acumulados">
					</td>
					<td>
					</td>
				</tr>
		</table>
	<br>
    <table>
        <tr>
          <td colspan="2" align="center">
          	<div id="ficheroDiv">Archivo de Acumulados:<input type="file" id="fichero" name="fichero" />
          	</div>
          </td>
          <input id="idNomina" name="idNomina" type="hidden"/>
          <input id="idPeriodo" name="idPeriodo" type="hidden"/>
		  <input id="anioPagoHid" name="anioPagoHid" type="hidden"/>
		  <input id="mesPagoHid" name="mesPagoHid" type="hidden"/>                             
          <td></td>
        </tr>
        <tr>     
        </tr>
        <tr>
        <td colspan="2" align="center">        
        <input name="botonSubmit" id="botonSubmit" type="button"  value="Subir Acumulado" onclick="validarFormSub();">               
        </tr>
     </table>          
</form:form>
<!-- /.container -->
	<!-- JS dependencies -->
	<div id="divSeleccionPlantillas" title="Selecci&oacute;n de Raz&oacute;n Social" >	
		<div id="container" class="mayuscula">
			<h1>Formatos:</h1>		
			<div id="demo">
				<div style="text-align:right; padding-bottom:1em;">
				</div>
				<input type="text" id="idAcumuladoHidden" name="idAcumuladoHidden"/>
				<table  cellpadding="0" cellspacing="0" border="0" class="display" id="tablaPlantillas">
					<thead>			
						<tr class="odd gradeA">
							<th width="40px">ID</th>
							<th width="200px">FORMATO</th>
							<th width="200px">LINK DE DESCARGA</th>															
							<th width="200px">ELIMINAR ACUMULADO</th>
						</tr>
						<tbody>			
						</tbody>
					</thead>
				</table>
			</div>
		</div>
	</div>
	<div id="divLoading" title="Por favor espere" style="display: none" class="col-lg-6">
		Por favor espere, se est�n obteniendo los acumulados de la n�mina..........................<br>
		<center><img name="imgLoading2" id="imgLoading2" src="../../static/img/loading_bar2.gif"></img></center>
	</div> 
	<div id="divLoading2" title="Por favor espere" style="display: none" class="col-lg-6">
		Por favor espere, se est� subiendo el archivo de acumulado para la n�mina..........................<br>
		<center><img name="imgLoading2" id="imgLoading2" src="../../static/img/loading_bar2.gif"></img></center>
	</div>
	<jsp:include page="../common/footer.jsp"/> 
</div>

