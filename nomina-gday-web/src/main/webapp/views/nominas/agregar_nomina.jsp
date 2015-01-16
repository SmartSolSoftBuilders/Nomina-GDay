<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>grupo day</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
  <script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery.dataTables.js"></script>		
  <script type="text/javascript" language="javascript" src="../../static/js/app/nominas/agregar_nomina.js"></script>
  
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
<%session.setAttribute("titulo","AGREGAR NOMINA");%>

<body>
	<div class="container">
		<div class="text-center col-lg-12">
			<div class="row">
				<div class="col-lg-6">
					<table>					
					 	<tr>
					 		<td>NOMBRE<input id='nombreNomina' name='nombreNomina' type="text" class="form-control"></td>
					 	</tr>
					 </table>
					 <table>
					  	<tr>
					 		<td>RAZON SOCIAL</td>
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
					 </table>
					 <table>
					 	<tr>
					 		<td>PATRONA<input id='patrona' name='patrona' type="text" class="form-control"></input></td>					 	
					 		<td></td>
					 		<td>EJECUTIVO</td>
							 	<td><select id='ejecutivo' name='ejecutivo' type="text" class="form-control"></select></td>					 	
					 	</tr>
					 	<tr>
					 		<td>ESQUEMA</td>
					 		<td><select id='esquema' name='esquema' type="text" class="form-control"></select></td>					 	
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
					 		<td>% PRIMA VACIONAL<input id='porcPrimaVacacional' name='porcPrimaVacacional' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>FONDO DE AHORRO<input id='fondoDeAhorro' name='fondoDeAhorro' type="checkbox" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 	<tr>
					 		<td>FACTURA SUBSIDIO<input id='factSub' name='factSub' type="checkbox" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>IVA EXCENTO<input id='ivaExcento' name='ivaExcento' type="checkbox" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>RECONOCE ANTIGÜEDAD<input id='reconoceAntihuedad' name='reconoceAntihuedad' type="checkbox" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>COMISION SOBRE COSTO SOCIAL<input id='comisionCostoSocial' name='comisionCostoSocial' type="checkbox" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>TIPO PAGO</td>
					 		<td><select id='tipoPago' name='tipoPago' type="text" class="form-control">
		  							<option>Neto</option>
		  							<option>Bruto</option>
		  							<option>Sindicato Tres</option>
							</select></td>					 	
					 	</tr>
					 	<tr>
					 		<td>CLASE DE RIESGO</td>
					 		<td><select id='claseRiesgo' name='claseRiesgo' type="text" class="form-control">
		  							<option>CI</option>
		  							<option>CII</option>
		  							<option>CIII</option>
		  							<option>CIV</option>
		  							<option>CV</option>
							</select></td>					 	
					 	</tr>
					 	<tr>
					 		<td>REGISTRO PATRONAL<input id='registroPatronal' name='registroPatronal' type="text" class="form-control"></td>					 	
					 	</tr>
					 	<tr>
					 		<td>PERIODICIDAD</td>
					 		<td><select id='periodicidad' name='periodicidad' type="text" class="form-control">
		  							<option>Q</option>
		  							<option>S</option>
		  							<option>M</option>
		  							<option>C</option>
							</select></td>					 	
					 	</tr>
				
					 	<tr>
					 		<td>TIPO CALENDARIO</td>
					 		<td><select id='tipoCalendario' name='tipoCalendario' type="text" class="form-control">
		  							<option>Semanal</option>
		  							<option>Diario</option>
		  							<option>Mensual</option>
							</select></td>					 	
					 	</tr>
						<tr>
					 		<td>FECHA CONTRATO<input id='fechaContrato' name='fechaContrato' type="date" class="form-control"></td>					 	
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
	<!-- /.container -->
	<!-- JS dependencies -->
	
</body>
</html>