<html>
 <head>
  <title>Registrar Afiliado</title>		
    <style type="text/css">
        .formdecorator label
        {
            display: block;
        }        
        .formdecorator
        {
            list-style: none;
            margin: 0;
            padding: 0;
        }
        
        .formdecorator li
        {
            clear: both;
            margin-bottom: 1em;
        }
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
.style15 {color: #000000; font-size: 16px; font-family: Verdana, Arial, Helvetica, sans-serif; }
.style18 {font-family: Verdana, Arial, Helvetica, sans-serif}
.style26 {color: #FFFFFF; font-size: 14px; }
.style30 {font-size: 14px; font-family: Verdana, Arial, Helvetica, sans-serif; color: #FFFFFF;}
.style32 {font-family: Verdana, Arial, Helvetica, sans-serif; font-style: italic; }
-->
  </style>
  	<link rel="stylesheet" href="../../static/js/libs/css/ui-lightness/jquery-ui-1.10.2.custom.css" />
  	<script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery-1.9.1.js"></script>
  	<script type="text/javascript" language="javascript" src="../../static/js/libs/js/jquery-ui-1.10.2.custom.js"></script>
	<script type="text/javascript" language="javascript" src="../../static/js/app/afiliados/alta.js"></script>		
    <style type="text/css">
<!--
.style33 {color: #000000}
-->
    </style>
</head>

<body class="demo-single">
<table width="888" border="0">
   <tr>
     <td width="799"><p align="center" class="style1 style10">Registro de Afiliado </p>     </td>
  </tr>
</table>
    <div class="container" id="container">
        <div class="main demo">
            <!-- Begin demo markup -->
            <form name="form1" action="../../mvc/afiliado/guardar" method="post">
			<div  id="tableMain">
            <ul class="formdecorator">
            <table width="859" border="2" bordercolor="#FF9966" bgcolor="#FFFFFF">
                    <tr>             
                      <td width="226" class="style13"><p class="style30 style33">Nombre: </p></td>
                      <td width="198">   <span class="style33">
                      <input name="nombre" value="" id="nombre" type="text" size =30/>  
                      </li>
                      </span></td>
					  <td width="199" class="style30 style33">Nacionalidad<span class="style18">:</span></td>
                      <td width="218"><span class="style33">
                        <select id="nacionalidad" name="nacionalidad" >
                          <option>Seleccione</option>
                          <option value="Mexicana">Mexicana</option>
                        </select>
                      </span> </td>
                    </tr>
	                <tr>
                       <td width="226" class="style30 style33">Apellido Paterno: </td>
                      <td width="198"><input name="app" type="text" id="app" value="" size =30/> </td>
	                   <td width="199" class="style30 style33">Estado Civil: </td>
	                   <td width="218"><input name="estadocivil" type="text" id="estadocivil" value="" size =30/></td>
                    </tr>
  	                  <tr>
                        <td width="226" class="style26"><span class="style18 style33">Apellido Materno :</span></td>
                        <td width="198"><input name="apm" type="text" id="apm" value="" size =30/></td>
	                    <td width="199" class="style30 style33">RFC:</td>
	                    <td width="218"><input name="rfc" type="text" id="rfc" value="" size =30/></td>
                      </tr>
					  <tr>
                        <td width="226" class="style26"><span class="style18 style33">Fecha de Nacimiento: </span></td>
                        <td width="198" class="style9"><input name="fechanacimiento" type="text" id="fechanacimiento" value="" size =30/></td>
                        <td width="199" class="style30 style33">&nbsp;</td>
	                    <td width="218" class="style15">&nbsp;</td>
                      </tr>
   	                  <tr>
                        <td width="226" class="style26"><div align="center" class="style33"><span class="style32">Direcci&oacute;n</span></div></td>
                        <td width="198"><span class="style33"></span></td>
	                    <td width="199" class="style30"><div align="center" class="style33"><em>Contacto</em></div></td>
	                    <td width="218"><span class="style33"></span></td>
                      </tr>
   	                  <tr>
                        <td width="226" class="style26"><span class="style18 style33">Calle y N&uacute;mero: </span></td>
                        <td width="198"><input name="domicilio" type="text" id="domicilio"  value="" size =30/> </td>
	                    <td width="199" class="style30 style33">Tel&eacute;fono Particular: </td>
	                    <td width="218"><input name="telparticular" type="text" id="telparticular" size =20/></td>
                      </tr>
   	                  <tr>
                        <td width="226" class="style26"><span class="style18 style33">Colonia:</span></td>
                        <td width="198"><input name="colonia" type="text" id="colonia" size=30/> </td>
	                    <td width="199" class="style30 style33">Tel&eacute;fono Celular: </td>
	                    <td width="218"><input name="telcelular" type="text" id="telcelular" size =20/></td>
                      </tr>
   	                  <tr>
                        <td width="226" class="style26"><span class="style18 style33">C.P.</span></td>
                        <td width="198"><input name="cp" type="text" id="cp" value="" size =10/> </td>
	                    <td width="199" class="style30 style33">Compañia:</td>
	                    <td width="218"><span class="style33">
	                      <select id="compania" name="compania" >
	                        <option>Seleccione</option>
	                        <option value="TelefonosSA">TelefonosSA</option>
                        </select>
	                      </span> </td>
   	                  </tr>
   	                  <tr>
                        <td width="226" class="style26"><span class="style18 style33">Entidad Federativa: </span></td>
                        <td width="198"><span class="style33">
                          <select id="entidad" name="entidad" >
                            <option>Seleccione</option>
                            <option value="DF">DF</option>
                          </select>
                        </span></td>
                        <td width="226" class="style26"><span class="style18 style33">E-Mail:</span></td>
                        <td width="198" class="style10"><input name="email" type="text" id="email" value="" size =20/></td>						          
                      </tr>
					  <tr>
                        <td width="226" class="style26"><span class="style18 style33">Municipio:</span></td>
                        <td width="198" class="style10"><span class="style33">
                          <select id="municipio" name="municipio" >
                            <option>Seleccione</option>
                          </select>
                        </span></td>
                        <td width="199" class="style30 style33">&nbsp;</td>
	                    <td width="218"><span class="style33"></span></td>
                      </tr>					  					
					<tr>
                        <td width="226" height="36" class="style26"><span class="style18">Escuela:</span></td>
                        <td width="198"><input name="escuela" type="text" id="escuela" value="" size =20/><input type="button" value="buscar" onClick="showEscuela()"/></td>
          				<td width="199" class="style30"><input type="hidden" id="idescuela" name="idescuela"/></td>
                	</tr>
				<tr>
					<td width="226" height="36" class="style26"><span class="style18">Puesto:</span></td>
        	        <td width="198"><input name="puesto" type="text" id="puesto" value="" size =20/></td>
				</tr>		
				<tr>
					<td width="226" height="36" class="style26"><span class="style18">Antiguedad:</span></td>
        	        <td width="198"><input name="antiguedad" type="text" id="antiguedad" value="" size =10/></td>
				</tr>		
              </table>		
              <input type="button" onClick="guardarAfiliado()" value="Guardar" />	                          
          </form>
	  </div>
</div>
		<div id="divEscuela" title="Seleccionar Escuela" style="display:none">
					<jsp:include page="escuela.jsp"></jsp:include>
		</div>
	</body>
</html>