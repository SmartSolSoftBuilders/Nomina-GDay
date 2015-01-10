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
	<body>
<!--login modal-->
<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header" align="center">
        
        <img src="static/img/logo.png">
      </div>
      <div class="modal-body">
	<form name="loginform" class=" col-mformd-12 center-block" action="j_spring_security_check" method="post">		
	  <p>
		Por favor teclee sus datos:<br>
		${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </p>
		<div class="form-group">
              <input type="text" id="j_username" name="j_username" class="form-control input-lg" placeholder="Usuario">
            </div>
            <div class="form-group">
              <input type="password" name="j_password" id="j_password" class="form-control input-lg" placeholder="Contraseña">
         </div>
		
			<input  class="btn btn-primary btn-lg btn-block" type="submit" value="Aceptar"/>
	</form>			 
      </div>
      <div class="modal-footer">
          <div class="col-md-12">

		  </div>	
      </div>
  </div>
  </div>
</div>
        
  </body>
</html>