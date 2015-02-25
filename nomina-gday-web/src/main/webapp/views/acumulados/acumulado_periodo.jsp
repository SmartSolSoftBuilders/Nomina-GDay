<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../common/librerias.jsp"/>
 <script type="text/javascript" language="javascript" src="../../static/js/app/acumulados/acumulado_periodo.js"></script>  

<body id="dt_example">
<div id="container" >
	<h1 color=#0051a4 class="mayuscula">ACUMULADOS</h1>
</div>
<div align="center">
	<table>
		<tr>
			<td>NÓMINA
				<select id='nomina' name='nomina' class="form-control"></select>
			</td>
		</tr>
		<tr>
			<td>PERIODO
				<select id='periodo' name='periodo' class="form-control"></select>
			</td>
		</tr>
	</table>
<form:form method="post" action="../../mvc/acumulado_periodo" enctype="multipart/form-data" commandName="fileFormBean">
    <table>
        <tr>
          <td colspan="2" align="center">Archivo:<input type="file" name="fichero" /></td>
          <td></td>
        </tr>
        <tr>     
        </tr>
        <tr>
        <td colspan="2" align="center">
        <input type="submit" value="Subir Archivo"></td>
        </tr>
     </table>          
</form:form>
</div>
