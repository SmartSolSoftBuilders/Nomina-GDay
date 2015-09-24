<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../common/librerias.jsp"/>

<body id="dt_example" onload="getTablaCarga();">
<div id="container" >
	<h1 color=#0051a4 class="mayuscula">Adjunte el archivo que contiene la informaci&oacute;n</h1>
</div>
<div align="center">
<form:form method="post" action="../../mvc/carga" enctype="multipart/form-data" commandName="fileFormBean">
    <table id="tablaCargaArchivo">
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
<a href="LayoutCargaMasivaEmpleadosNuevo.xlsx">Descarga el Formato</a>
<div id="progressbar">Cargando (75%)...</div>	
		<div id="container" class="mayuscula">
			<h1>Historial de Archivos Cargados</h1>		
			<div id="demo">
				<form id="formSeleccionarGrupos">
					<div style="text-align:right; padding-bottom:1em;">
						<!--button type="submit">Submit form</button-->
					</div>
					<table  cellpadding="0" cellspacing="0" border="0" class="display" id="tablaArchivos">
					<thead>			
						<tr class="odd gradeA">
							<th>ID ARCHIVO</th>
							<th>FECHA DE CARGA</th>
							<th>ARCHIVO</th>
							<th>REGISTROS CARGADOS</th>
							<th>REGISTROS RECHAZADOS</th>							
						</tr>
					<tbody>			
					</tbody>
					</thead>
					</table>
				</form>
			</div>
			
			<div id="Grupo"></div>					
			</div>
</div>

<script type="text/javascript">
function getTablaCarga(){	
	$("#tablaCargaArchivo").hide();
	oTableGrupos=$('#tablaArchivos').dataTable();
	$.ajax({
		sync: true,
		type:  'post',
		url:   '../../mvc/carga/getfiles',
		dataType:  'json',
		beforeSend: function () {
			$("#resultado").html("Procesando, espere por favor...");
      	$( "#progressbar" ).progressbar({
		      value: 75
		    });	
        $( "#demo" ).hide();
		},
		success:  function (response) {
			$( "#demo" ).show();
			$( "#progressbar" ).hide();
			$('#tablaArchivos').dataTable().fnAddData(response);
			$("#tablaCargaArchivo").show();
		}	
	});
}

</script>
