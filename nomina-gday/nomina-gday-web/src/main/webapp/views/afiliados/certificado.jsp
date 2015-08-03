<html>
 <head>
  <title>Registrar Certificado</title>		
    <style type="text/css">.formdecorator label{display: block;}        
        .formdecorator{list-style: none;  margin: 0;padding: 0;}        
        .formdecorator li{ clear: both;  margin-bottom: 1em;  }
    </style>

  <style type="text/css">
<!--
.style1 {
	color: #FF6600;
	font-size: 24px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
}
.style9 {font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 18px; }
.style10 {font-size: 18px}
.style13 {color: #000066}
.style15 {color: #000066; font-size: 16px; font-family: Verdana, Arial, Helvetica, sans-serif; }
.style18 {font-family: Verdana, Arial, Helvetica, sans-serif}
.style26 {color: #FFFFFF; font-size: 14px; }
.style30 {font-size: 14px; font-family: Verdana, Arial, Helvetica, sans-serif; color: #FFFFFF;}
.style32 {font-family: Verdana, Arial, Helvetica, sans-serif; font-style: italic; }
-->
  </style>  
  	<link rel="stylesheet" href="../../static/js/libs/css/ui-lightness/jquery-ui-1.10.2.custom.css" />
  	<style type="text/css" title="currentStyle">
			@import "../../static/js/libs/css/demo_page.css";
			@import "../../static/js/libs/css/demo_table.css";
			@import "../../static/js/libs/css/ui-lightness/jquery-ui-1.10.2.custom.css";
		</style>
  	<script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery-1.9.1.js"></script>
	<script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery.custom.js"></script>
	<script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery.dataTables.js"></script>
	<script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery-ui-1.10.2.custom.js"></script>
	<script type="text/javascript" language="javascript" src="../../static/js/app/afiliados/certificado.js"></script>
	<link rel="stylesheet" href="../../static/js/libs/css/validationEngine.jquery.css" type="text/css"/>
	<link rel="stylesheet" href="../../static/js/libs/css/template.css" type="text/css"/>
	<script src="../../static/js/libs/js/languages/jquery.validationEngine-es.js" type="text/javascript" charset="utf-8">
	</script>
	<script src="../../static/js/libs/js/jquery.validationEngine.js" type="text/javascript" charset="utf-8">
	</script>
	<script language="javascript">
	var oTable2;		
	var oTable3;
	var datosBeneficiario;
	jQuery(document).ready(function(){
		// binds form submission and fields to the validation engine
		$( "#fechanacimientobeneficiario" ).datepicker({ dateFormat: "yy-mm-dd" ,changeYear: true});
		$( "#fechanacimientoasegurado" ).datepicker({ dateFormat: "yy-mm-dd" ,changeYear: true});
		$( "#fechavigencia" ).datepicker({ dateFormat: "yy-mm-dd" ,changeYear: true});		
		jQuery("#formCertificado").validationEngine();
		//jQuery("#formAsegurado").validationEngine();
		$("#numerocertificado").focus();
		
	});	
	</script>		
</head>

<body class="demo-single">
<div align="center">
<form id="formCertificado"  name="formCertificado" class="formular" style="width:650px;" action="../../mvc/afiliado/guardar" method="post">
<legend><div id="divLabelCertificado"></div><input type="hidden" id="idafiliado" name="idafiliado" value=""/></legend>
	<table border=0>
		<tr>
			<td>		            
			<fieldset> <legend></legend>
			<legend>N&uacute;mero</legend>
				<label>	<input value="" class="validate[required] text-input" type="text" name="numerocertificado" id="numerocertificado" /></label>			
			<legend>Estatus Laboral</legend>
				<label>	
					<select name="estado" id="estado" class="validate[required]">						
						<option value="ACTIVO">ACTIVO</option>
						<option value="JUBILADO">JUBILADO</option>
						<option value="PENSIONADO">PENSIONADO</option>
						<option value="INTERINO">INTERINO</option>
					</select>
				</label>
			</fieldset>
			</td>
			<td>
			<fieldset>						
			<legend></legend>	
			<legend>Suma Asegurada</legend>
				<label><input value="" class="validate[required] text-input" type="text" name="sumaasegurada" id="sumaasegurada" /></label>
			<legend>Fecha Vigencia</legend>
				<label><input value="" class="validate[required] text-input" type="text" name="fechavigencia" id="fechavigencia" /></label>
			</fieldset>
			</td>
		</tr>	
		</table>		
</form>
</div>		
	        <div align="center">
              <input name="button" type="button" onClick="guardarCertificado()" value="Guardar" />
            </div>	 
<input type="hidden" id="idcertificadoafiliado" name="idcertificadoafiliado" value=""/></legend>		
<div id="beneficiarios" align="center">
	<form id="tableFormBeneficiario">
		<div style="text-align:right; padding-bottom:1em;">
			<!--button type="submit">Submit form</button-->
		</div>
		<span class="style1">Beneficiarios</span>
		<table width="321" border="0"  style="width:650px" cellpadding="0" cellspacing="0" class="display" id="tablaBeneficiario" align="center">
		<thead>			
			<tr>
				<th width="15%">Nombre</th>
				<th width="25%">Apellido Paterno</th>					
				<th width="25%">Apellido Materno</th>
				<th width="15">Parentesco</th>
				<th width="10%">Fecha Nacimiento</th>							
				<th width="10%">Edad</th>
			</tr>
		  <tbody>			
		  </tbody>
		</thead>
		</table>
	</form>				
    <div align="center">
        <input name="button2" type="button" onClick="agregarBeneficiario()" value="Agregar" />
        <input name="button2" type="button" onClick="modificarBeneficiario()" value="Editar" />
        <input name="button2" type="button" onClick="agregarBeneficiario()" value="Eliminar" />
    </div>
</div>

<div id="asegurados" align="center">
	<form id="tableFormAsegurado" align="center">
		<div style="text-align:right; padding-bottom:1em;">
			<!--button type="submit">Submit form</button-->
		</div>
		<span class="style1">Asegurados</span>
		<table width="321" border="0"  style="width:650px" cellpadding="0" cellspacing="0" class="display" id="tablaAsegurado" align="center">
		<thead>			
			<tr>
				<th width="15%">Nombre</th>
				<th width="25%">Apellido Paterno</th>					
				<th width="25%">Apellido Materno</th>
				<th width="15">Parentesco</th>
				<th width="10%">Fecha Nacimiento</th>							
				<th width="10%">Edad</th>
			</tr>
		  <tbody>			
		  </tbody>
		</thead>
		</table>
	</form>			
			
    <div align="center">
        <input name="button2" type="button" onClick="agregarAsegurado()" value="Agregar" />
        <input name="button2" type="button" onClick="agregarBeneficiario()" value="Editar" />
        <input name="button2" type="button" onClick="agregarBeneficiario()" value="Eliminar" />
    </div>
</div>
	<div id="instrucciones"></div>
	<div id="divBeneficiario" title="Agregar Beneficiario" style="display:none">
		<jsp:include page="altabeneficiario.jsp"></jsp:include> 		
	</div>
	<div id="divAsegurado" title="Agregar Asegurado" style="display:none">
		<jsp:include page="altaasegurado.jsp"></jsp:include> 		
	</div>
	
	<div id="divAviso" title="AVISO" style="display:none">
		<div id="divAvisoMensaje"></div>
	</div>
	

</body>
</html>