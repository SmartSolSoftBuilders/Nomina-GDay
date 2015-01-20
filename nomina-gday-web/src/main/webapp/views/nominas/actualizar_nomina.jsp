<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>grupo day</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="../../static/js/libs/js/jquery.validate.js"></script>
  <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
  <script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery.dataTables.js"></script>		
  <script type="text/javascript" language="javascript" src="../../static/js/app/nominas/actualizar_nomina.js"></script>
  
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
			<div class="row">
				<div class="col-lg-6">
			<form  id="actualizarNominaForm" name="actualizarNominaForm" novalidate="novalidate">		
					<table>					
					 	<tr>
					 		<td>NOMBRE<input id='nombreNomina' name='nombreNomina' type="text" class="form-control"  onkeyup="javascript:this.value=this.value.toUpperCase();"></td>
					 	</tr>
					 </table>
					<table border=2>
				  		<tr>
						  	<td>
						  		<table>
						 			<tr><td>RAZON SOCIAL</td></tr>
						  		</table>
				  			</td>
					  		</tr>						  		
					   		<tr>
						  		<td>							 			
					 				<select name="selectMult" id="selectMult" multiple="multiple" style="width:550px;height:100px">		
					 				</select>					 				
					 				<button type="button" class="btn btn-default" onclick="showRazonesSociales();">A�ADIR</button>
					 				<button type="button" class="btn btn-default" onclick="quitarRazonSocial();">QUITAR</button>
					 			</td>
					 		</tr>
					 </table>
					 <table>
							<tr>
							  	<td>
							  		<table>
							  			<tr><td>PATRONA</td></tr>
							  		</table>
					  			</td>
					  		</tr>	
							<tr>
								<td>
									<input id='patrona' name='patrona' type="text" class="form-control"></input>
									<input id='idPatrona' name='idPatrona' type="hidden" class="form-control"></input>
									<button type="button" class="btn btn-default" onclick="showPatronas();">SELECCIONAR</button> 		
						 		</td>
						 </tr>
					 </table>
					 <table>
					 	<tr>
					 		<td>ESQUEMA
					 		<select id='esquema' name='esquema' type="text" class="form-control"></select></td>					 	
					 		<td width="10%"></td>

					 		<td>EJECUTIVO
								<select id='ejecutivo' name='ejecutivo' type="text" class="form-control"></select>
							</td>				 						 	
					 	</tr>
					 	<tr>
					 		<td>PROVISION AGINALDO<input id='provisionAguinaldo' name='provisionAguinaldo' type="checkbox" class="form-control"></td>					 	
					 		<td></td>
					 		<td>PROVISION VACACIONES<input id='provisionVacaciones' name='provisionVacaciones' type="checkbox" class="form-control"></td>					 	
					 		<td></td>
					 	</tr>
					 </table>
					 <table>
					 	<tr>
					 		<td>PROVISION PRIMA VACACIONAL<input id='provisionPrimaVac' name='provisionPrimaVac' type="checkbox" class="form-control"></td>					 	
							<td></td>
					 		<td>% PRIMA VACIONAL<input id='porcPrimaVacacional' name='porcPrimaVacacional' type="text" class="form-control"></td>					 	
					 		<td></td>
					 		<td>FONDO DE AHORRO<input id='fondoDeAhorro' name='fondoDeAhorro' type="checkbox" class="form-control"></td>					 	
					 	</tr>
					 </table>
					 <table>
					 	<tr>
							<td></td>
					 		<td>FACTURA SUBSIDIO<input id='factSub' name='factSub' type="checkbox" class="form-control"></td>					 	
							<td></td>
					 		<td>IVA EXCENTO<input id='ivaExcento' name='ivaExcento' type="checkbox" class="form-control"></td>					 	
							<td></td>
					 		<td>RECONOCE ANTIG�EDAD<input id='reconoceAntihuedad' name='reconoceAntihuedad' type="checkbox" class="form-control"></td>					 	
					 		<td></td>
					 		<td>COMISION SOBRE COSTO SOCIAL<input id='comisionCostoSocial' name='comisionCostoSocial' type="checkbox" class="form-control"></td>					 	
					 	</tr>
					 </table>
					 <table>
					 	<tr>		 		
					 		<td>TIPO PAGO
					 		<select id='tipoPago' name='tipoPago' type="text" class="form-control">
		  							<option>Neto</option>
		  							<option>Bruto</option>
		  							<option>Sindicato Tres</option>
							</select></td>					 	
						 	<td></td>
					 		<td>CLASE DE RIESGO
					 		<select id='claseRiesgo' name='claseRiesgo' type="text" class="form-control">
		  							<option>CI</option>
		  							<option>CII</option>
		  							<option>CIII</option>
		  							<option>CIV</option>
		  							<option>CV</option>
							</select>
							</td>
						</tr>
						<tr>
							<td>REGISTRO PATRONAL<input id='registroPatronal' name='registroPatronal' type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"></td>					 	
					 		<td>PERIODICIDAD
					 			<select id='periodicidad' name='periodicidad' type="text" class="form-control">
		  							<option>Q</option>
		  							<option>S</option>
		  							<option>M</option>
		  							<option>C</option>
							</select></td>					 	
					 		<td>TIPO CALENDARIO
					 		<select id='tipoCalendario' name='tipoCalendario' type="text" class="form-control">
								</select>
							</td>					 	
						</tr>	
						<tr>					 	
					 		<td>FECHA CONTRATO<input id='fechaContrato' name='fechaContrato' type="date" class="form-control"></td>
					 		<td></td><td></td>					 	
					 	</tr>
					 </table>
				<br>
				<br>
			<!-- /.col-lg-6 -->						
				 <div class="input-group">      
			     	 <span>
			        	<button type="button" class="btn btn-success" onclick="guardarNomina();">CREAR</button>
			        	<button type="button" class="btn btn-success" onclick="cancelar();">CANCELAR</button>
			     	 </span>			    
   		 		</div><!-- /input-group -->
   		 	</form>
				</div>
			</div>
			</div>
	  </div>
	<div id='resultadoGuardar'></div>
	<!-- /.container -->
	<!-- JS dependencies -->
		<div id="divSeleccionRazonSocial" title="Selecci&oacute;n de Raz&oacute;n Social" style="display:none">
		<div id="container" class="mayuscula">
			<h1>Razones Sociales</h1>		
			<div id="demo">
				<div style="text-align:right; padding-bottom:1em;">
				</div>
				<table  cellpadding="0" cellspacing="0" border="0" class="display" id="tablaRazonesSociales">
					<thead>			
						<tr class="odd gradeA">
							<th width="40px">ID</th>
							<th width="200px">GRUPO</th>					
							<th width="200px">NOMBRE</th>
							<th width="200px">NOMBRE CORTO</th>
							<th width="200px">RFC</th>
							<th width="200px"></th>
							<th width="200px"></th>
						</tr>
						<tbody>			
						</tbody>
					</thead>
				</table>
			</div>
		</div>
	</div>
	
	<div id="divSeleccionPatrona" title="Selecci&oacute;n de Empresa Patrona" style="display:none">
		<div id="container2" class="mayuscula">
			<h1>Empresas Patronas</h1>		
			<div id="demo2">
				<div style="text-align:right; padding-bottom:1em;">
				</div>
				<table  cellpadding="0" cellspacing="0" border="0" class="display" id="tablaPatronas">
					<thead>			
						<tr class="odd gradeA">
							<th width="40px">ID</th>
							<th width="200px">NOMBRE CORTO</th>
							<th width="200px"></th>
						</tr>
						<tbody>			
						</tbody>
					</thead>
				</table>
			</div>
		</div>
	</div>	
	<div id="tmpTxtBox">ok</div>
	
</body>
</html>