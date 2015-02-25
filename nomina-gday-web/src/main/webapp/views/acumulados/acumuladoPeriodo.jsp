<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../common/librerias.jsp"/>

<body id="dt_example">
<div id="container" >
	<h1 color=#0051a4 class="mayuscula">ACUMULADOS</h1>
</div>
<div align="center">
<form:form method="post" action="../../mvc/acumuladoPeriodo" enctype="multipart/form-data" commandName="fileFormBean">
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
