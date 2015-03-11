<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../common/librerias.jsp"/>
 <script type="text/javascript" language="javascript" src="../../static/js/app/acumulados/ver_acumulados.js"></script>  

<body id="dt_example">
<div id="container" >
	<h1 color=#0051a4 class="mayuscula">VER DATOS DE ACUMULADOS</h1>
</div>
<div align="center">
	<table>
		<tr>
			<td>ID NÓMINA:
				<select id='nomina' name='nomina' class="form-control"></select>
			</td>
			</tr>
		<tr>
			<td>AÑO:
				<select id='anio' name='anio' class="form-control">
					<option id="2001">2001</option>
					<option id="2002">2002</option>
					<option id="2003">2003</option>
					<option id="2004">2004</option>
					<option id="2005">2005</option>
					<option id="2006">2006</option>
					<option id="2007">2007</option>
					<option id="2008">2008</option>
					<option id="2009">2009</option>
					<option id="2010">2010</option>
					<option id="2011">2011</option>
					<option id="2012">2012</option>
					<option id="2013">2013</option>
					<option id="2014">2014</option>
					<option id="2015">2015</option>
					<option id="2016">2016</option>
					<option id="2017">2017</option>
					<option id="2018">2018</option>
					<option id="2019">2019</option>
					<option id="2020">2020</option>
					<option id="2021">2021</option>
					<option id="2022">2022</option>
					<option id="2023">2023</option>
					<option id="2024">2024</option>
					<option id="2025">2025</option>
					<option id="2026">2026</option>
					<option id="2027">2027</option>
					<option id="2028">2028</option>														
				</select>
			</td>
		</tr>		
		<tr>
			<td>PERIODO:
				<select id='periodo' name='periodo' class="form-control"></select>
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" value="Consultar" onclick="obtenerAcumuladosVal()">
			</td>
		</tr>
	</table>

</div>
