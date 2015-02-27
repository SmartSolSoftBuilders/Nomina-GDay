<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../common/librerias.jsp"/>
 <script type="text/javascript" language="javascript" src="../../static/js/app/acumulados/acumulado_periodo.js"></script>  

<body id="dt_example">
<div id="container" >
	<h1 color=#0051a4 class="mayuscula">ACUMULADOS</h1>
</div>
<div align="center">
<form:form method="post" action="../../mvc/acumulado/acumuladoPeriodo" enctype="multipart/form-data" commandName="fileFormBean">
	<table>
		<tr>
			<td>NÓMINA
				<select id='nomina' name='nomina' class="form-control"></select>
			</td>
		</tr>
		<tr>
			<td>PERIODO
				<select id='periodo' name='periodo' onchange="obtenerAcumulados();" class="form-control"></select>
			</td>
		</tr>
	</table>
    <table>
        <tr>
          <td colspan="2" align="center">Archivo:<input type="file" name="fichero" /></td>
          <input id="idNomina" name="idNomina" type="hidden"/>
          <input id="idPeriodo" name="idPeriodo" type="hidden"/>          
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
							<th width="200px">CONSULTAR DATOS</th>
						</tr>
						<tbody>			
						</tbody>
					</thead>
				</table>
			</div>
		</div>
	</div>

</div>
