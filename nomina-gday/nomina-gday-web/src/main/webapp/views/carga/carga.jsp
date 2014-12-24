<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
	<script type="text/javascript" language="javascript" src="../../static/js/app/carga/carga.js"></script>	
	<link rel="stylesheet" href="../../static/js/libs/css/validationEngine.jquery.css" type="text/css"/>
	<link rel="stylesheet" href="../../static/js/libs/css/template.css" type="text/css"/>
	<script src="../../static/js/libs/js/languages/jquery.validationEngine-es.js" type="text/javascript" charset="utf-8">
	</script>
	<script src="../../static/js/libs/js/jquery.validationEngine.js" type="text/javascript" charset="utf-8">
	</script>
<body id="dt_example">
<div id="container" >
	<h1>Adjunte el archivo que contiene la informaci&oacute;n</h1>
</div>
<div align="center">
<form:form method="post" action="../../mvc/carga" enctype="multipart/form-data" commandName="fileFormBean">
    <table>
        <tr>
           <td>Archivo: </td>
           <td><input type="file" name="fichero" /></td>
        </tr>
        <tr>
     
        </tr>
        <tr><td colspan="2" align="center">
        <input type="submit" value="Subir Archivo"></td>
        </tr>
     </table>          
</form:form>
</div>
