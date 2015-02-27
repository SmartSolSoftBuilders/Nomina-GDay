<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Ingresar</title>
		  <!-- JS dependencies -->
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	    <script src="static/js/bootstrap.min.js"></script>
   	 	<script src="static/js/modal.js"></script>
   		<script>
        $(function() {
            Example.init({
                "selector": ".bb-alert"
            	});
        	});
    	</script>

    <!-- bootbox code -->
    <script src="static/js/bootbox.js"></script>

    <!-- put all demo code in one place -->
    <script src="static/js/control.js"></script>
		
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="static/css/bootstrap.min.css" rel="stylesheet">
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="static/css/styles.css" rel="stylesheet">
	</head>  
  <frameset rows="160,*">
  <%if (session.getAttribute("rolUser").equals("ROL_ADMINISTRADOR")){%>
  		<frame name="menu" src="views/menu/menu.jsp" marginwidth="10"scrolling="no" frameborder="0">
  <%} %>    
  <%if (session.getAttribute("rolUser").equals("ROL_CALIDAD_INFORMACION")){%>
  		<frame name="menu" src="views/menu/menu.jsp" marginwidth="10"scrolling="no" frameborder="0">
  <%} %>    
  <%if (session.getAttribute("rolUser").equals("ROL_EJECUTIVO_NOMINA")){%>
  		<frame name="menu" src="views/menu/menu_usuario2.jsp" marginwidth="10"scrolling="no" frameborder="0">
  <%} %>    
    <frameset cols="100%,*">
      <frame name="main" src="views/main.jsp" marginwidth="10" marginheight="10" scrolling="auto" frameborder="0">     
    <frameset>
  <frameset> 

</html>