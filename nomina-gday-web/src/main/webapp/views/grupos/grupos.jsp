<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		
		<title>GDAY</title>
		<jsp:include page="../common/librerias.jsp"/>
				
		<script type="text/javascript" language="javascript" src="../../static/js/app/grupos/grupos.js"></script>
		<script type="text/javascript" language="javascript" src="../../static/js/app/grupos/actualizar_grupo.js"></script>
	</head>
	<body id="dt_example">
		<div id="progressbar">Cargando (75%)...</div>	
		<div id="container" class="mayuscula">
			<h1>Grupos</h1>		
			<div id="demo">
				<form id="formSeleccionarGrupos">
					<div style="text-align:right; padding-bottom:1em;">
						<!--button type="submit">Submit form</button-->
					</div>
					<table  cellpadding="0" cellspacing="0" border="0" class="display" id="tablaGrupo">
					<thead>			
						<tr class="odd gradeA">
							<th>NUMERO GRUPO</th>
							<th>NOMBRE</th>
							<th>NOMBRE CORTO</th>					
							<th></th>
						</tr>
					<tbody>			
					</tbody>
					</thead>
					</table>
				</form>
			</div>
			
			<div id="Grupo"></div>
			
			<br>
			<br>
			<div>
				<input type="button" class="btn btn-success" value="AÑADIR GRUPO" onclick="showAgregarGrupo();"/>
			</div>
<!-- 			Modal para Editar Grupo -->				
			<div class="row">
				<div id="divGrupos" title="Actualizar Grupo" style="display:none"  class="col-lg-6">
				<form id="actualizarGrupoForm" name="actualizarGrupoForm" novalidate="novalidate">
				
					<table>
					 	<tr>
					 		<td>NOMBRE<input id='nombre' name='nombre' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 	</tr>
					 	<tr>
					 		<td>NOMBRE CORTO<input id='nombreCorto' name='nombreCorto' type="text" class="form-control">
					 		<input id='grupoIdSel' name='grupoIdSel' type="hidden" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 							 	
					 	</tr>
					</table>
				<br>
				<br>
			<!-- /.col-lg-6 -->						
				 <div class="input-group">      
			        	<button type="button" class="btn btn-success" onclick="actualizarGrupo()">MODIFICAR</button>
   		 		</div><!-- /input-group -->
   		 		</form>
				</div>
			</div>

			<br>
			<br>

			</div>
		<jsp:include page="../common/footer.jsp"/>	
	</body>
</html>