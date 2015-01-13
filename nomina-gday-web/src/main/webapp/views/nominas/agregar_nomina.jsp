<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>grupo day</title>

<script type="text/javascript" language="javascript" src="../../static/js/app/nominas/agregar_nomina.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
  		<script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery.dataTables.js"></script>		
  
	<script src="../../static/js/bootstrap.min.js"></script>
	<script src="../../static/js/modal.js"></script>
	<script>
        $(function() {
            Example.init({
                "selector": ".bb-alert"
            });
        });
    </script>

	<!-- bootbox code -->
	<script src="../../static/js/bootbox.js"></script>

	<!-- put all demo code in one place -->
	<script src="../../static/js/control.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<link href="../../static/css/styles.css" rel="stylesheet">
<link href="../../static/css/multiple-select.css" rel="stylesheet">
<link href="../../static/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<div class="container">

		<div class="text-center col-lg-12">
			<br>
			    <h2 style="color:#0051a4">Sistema de Gestión de Información <br>para Esquema de Pago de Nómina</h2><br><br>

			<br>
			<div class="row">
				<div class="col-lg-6">
					<table>
					 	<tr>
					 		<td>NOMBRE<input id='nombreNomina' name='nombreNomina' type="text" class="form-control"></td>
					 	</tr>
					  	<tr>
					 		<td>RAZON SOCIAL<input id='razonSocial' name='razonSocial' type="text" class="form-control"></td>
					 		<td><button type="button" class="btn btn-default" onclick="agregarReferenciante();">AÑADIR</button>					 		</td>
				 		
					 	</tr>
					 	<tr>				 	
					 		<td><select id="selectMult" multiple="multiple">
					 			<option value="1">Miguel Gutierrez Perez</option>
					 			<option value="2">Rafael Mora Moran</option>
					 			<option value="3">Ricardo Perez Perez</option>
					 			<option value="4">Veronica Orduña Contreras</option>
					 			<option value="5">Monica Herrera Fernandez</option>
					 		</select></td>
					 	</tr>					 	
					 	<tr>
					 		<td>PATRONA<textarea id='patrona' name='patrona' type="text" class="form-control"></textarea></td>					 	
					 	</tr>
					 	<tr>
					 		<td>EJECUTIVO<input id='ejecutivo' name='ejecutivo' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>ESQUEMA<input id='esquema' name='esquema' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>PROVISION AGINALDO<input id='provisionAguinaldo' name='provisionAguinaldo' type="checkbox" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 	<tr>
					 		<td>PROVISION VACACIONES<input id='provisionVacaciones' name='provisionVacaciones' type="checkbox" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 	<tr>
					 		<td>PROVISION PRIMA VACACIONAL<input id='provisionPrimaVac' name='provisionPrimaVac' type="checkbox" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>% PRIMA VACIONAL<input id='primaVacacional' name='primaVacacional' type="checkbox" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>FONDO DE AHORRO<input id='fondoDeAhorro' name='fondoDeAhorro' type="checkbox" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>IVA EXCENTO<input id='ivaExcento' name='ivaExcento' type="checkbox" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>COMISION SOBRE COSTO SOCIAL<input id='comisionCostoSocial' name='comisionCostoSocial' type="checkbox" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>TIPO PAGO<input id='tipoPago' name='tipoPago' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>CLASE DE RIESGO<input id='claseRiesgo' name='claseRiesgo' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>REGISTRO PATRONAL<input id='registroPatronal' name='registroPatronal' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>PERIODICIDAD<input id='periodicidad' name='periodicidad' type="text" class="form-control"></td>					 	
					 	</tr>
				
					 	</table>
				<br>
				<br>
			<!-- /.col-lg-6 -->						
				 <div class="input-group">      
			     	 <span class="input-group-btn">
			        	<button type="button" class="btn btn-default" onclick="guardarNomina();">CREAR</button>
			     	 </span>			    
   		 		</div><!-- /input-group -->
				</div>
			</div>
			</div>
	  </div>
	<div id='resultadoGuardar'></div>
	<div id="divGrupos" title="Basic dialog" style="display:none">
		<div id="container" class="mayuscula">
			<h1>Seleccion de Grupos</h1>		
			<div id="demo">
				<form id="formSeleccionarGrupos">
					<div style="text-align:right; padding-bottom:1em;">
						<!--button type="submit">Submit form</button-->
					</div>
					<table  cellpadding="0" cellspacing="0" border="0" class="display" id="tablaGrupo">
					<thead>			
						<tr class="odd gradeA">
							<th>NUMERO GRUPO</th>
							<th>NOMBRE CORTO</th>					
							<th>NOMBRE</th>
							<th></th>
						</tr>
					<tbody>			
					</tbody>
					</thead>
					</table>
				</form>
			</div>
			
			</div>
	</div>
	<!-- /.container -->
	<!-- JS dependencies -->
	
</body>
</html>