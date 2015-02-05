<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
