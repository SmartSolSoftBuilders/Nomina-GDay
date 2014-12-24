<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<!--link rel="shortcut icon" type="image/ico" href="http://www.datatables.net/media/images/favicon.ico" /-->		
<title>FAM</title>

<script type="text/javascript" language="javascript" src="../../../static/js/libs/js/jquery-1.9.1.js"></script>
<script type="text/javascript" language="javascript" src="../../../static/js/libs/js/jquery.custom.js"></script>

	<link rel="stylesheet" href="../../../static/js/libs/css/jquery.treeview.css" />
	<link rel="stylesheet" href="../../../static/js/libs/css/screen.css" />	
	
	<script src="../../../static/js/libs/js/jquery.cookie.js" type="text/javascript"></script>
	<script src="../../../static/js/libs/js/jquery.treeview.js" type="text/javascript"></script>	
	<script type="text/javascript" src="../../../static/js/libs/js/demo.js"></script>
	
	<script language="javascript">
		jQuery(document).ready(function(){
					
		});
		
		function openFrame(url){
			top.frames['mainFrame'].location="../../"+url+".jsp"; 
		}
		function cursor(a) { 
		    if (navigator.appName=="Netscape") { 
		        a.style.cursor='pointer'; 
		    } else { 
		        a.style.cursor='hand'; 
		    } 
		} 
	</script>
		

<body>
	<p>&nbsp;</p>
	<div align="center">
		<p><img src="../../../static/img/1.png" width="115" height="72"/>    </p>
	</div>
	<h4>Men&uacute; Principal - Capturista</h4>
	<ul id="browser" class="filetree">
		<li><span class="folder">Afiliado</span>
			<ul>
				<li><span class="file" onMouseOver="cursor(this)" onclick="openFrame('afiliados/altaafiliado')">Registrar Afiliado</span></li>
				<li><span class="file" onMouseOver="cursor(this)" onclick="openFrame('afiliados/mantenimiento')">Mantenimiento Afiliados</span></li>
				<li><span class="file" onMouseOver="cursor(this)" onclick="openFrame('carga/carga')">Carga Masiva Afiliados</span></li>				
			</ul>
		</li>
		<li><span class="folder">P&oacute;liza Colectiva</span>
			<ul>
				<li><span class="file" onMouseOver="cursor(this)" onclick="openFrame('certificados/mantenimiento')">Corregir Datos Certificado</span></li>
				<li><span class="file" onMouseOver="cursor(this)" onclick="openFrame('certificados/mantenimientodetcer')">Mantenimiento de Certificados</span></li>
			</ul>
		</li>
		<li class="closed"><span class="folder">Productos</span>
			<ul>
				<li class="closed"><span class="folder">FAMAhorro</span>
					<ul><span class="file" onMouseOver="cursor(this)" onclick="openFrame('carga/carga_saldos')">Actualizar Saldos</span></ul>
					<ul><span class="file" onMouseOver="cursor(this)" onclick="openFrame('famahorro/showafiliados')">Registro FAMAhorro</span></ul>
					<ul><span class="file" onMouseOver="cursor(this)" onclick="openFrame('famahorro/showafiliadosmod')">Mantenimiento FAMAhorro</span></ul>
				</li>
				<li class="closed"><span class="folder">CrediFAM</span>
				</li>
			</ul>
		</li>
		<li class="closed"><span class="folder">Cat&aacute;logos</span>
		</li>	
	</ul>
	<a class="logout" href="../../../logout" target="_top">Cerrar sesi�n</a>		
</body>
</html>