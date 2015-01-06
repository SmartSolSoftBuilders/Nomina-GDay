$(function() {
    var demos = {};

    $(document).on("click", "a[data-bb]", function(e) {
        e.preventDefault();
        var type = $(this).data("bb");

        if (typeof demos[type] === 'function') {
            demos[type]();
        }
    });

    // let's namespace the demo methods; it makes them easier
    // to invoke
    demos.alert = function() {
        bootbox.alert("Hello world!");
    };

    demos.alert_callback = function() {
        bootbox.alert("Hello world!", function() {
            Example.show("Hello world callback");
        });
    };

    demos.confirm = function() {
        bootbox.confirm("Are you sure?", function(result) {
            Example.show("Confirm result: "+result);
        });
    };

    demos.alert_button = function() {
        bootbox.alert("This alert has custom button text", "So it does!");
    };

    demos.confirm_buttons = function() {
        bootbox.confirm("This confirm has custom buttons - see?", "No", "Yes!", function(result) {
            if (result) {
                Example.show("Well done!");
            } else {
                Example.show("Oh no - try again!");
            }
        });
    };

    demos.prompt = function() {
        bootbox.prompt("What is your name?", function(result) {
            if (result === null) {
                Example.show("Prompt dismissed");
            } else {
                Example.show("Hi <b>"+result+"</b>");
            }
        });
    };

    demos.prompt_default_value = function(){
        bootbox.prompt({
            title: "What is your real name?",
            value: "makeusabrew",
            callback: function(result) {
                if (result === null) {
                    Example.show("Prompt dismissed");
                } else {
                    Example.show("Hi <b>"+result+"</b>");
                }
            }
        }); 
    };

    demos.dialog = function() {
      bootbox.dialog({
        message: "I am a custom dialog",
        title: "Custom title",
        buttons: {
          success: {
            label: "Success!",
            className: "btn-success",
            callback: function() {
              Example.show("great success");
            }
          },
          danger: {
            label: "Danger!",
            className: "btn-danger",
            callback: function() {
              Example.show("uh oh, look out!");
            }
          },
          main: {
            label: "Click ME!",
            className: "btn-primary",
            callback: function() {
              Example.show("Primary button");
            }
          }
        }
      });
    };

  demos.custom_html = function () {
    bootbox.dialog({
      title: "That html",
      message: '<img src="images/bootstrap_logo.png" width="100px"/><br/> You can also use <b>html</b>'
    });
  };

  demos.custom_form = function () {
    bootbox.dialog({
        title: "<p style='color:#0051a4'>GESTIÓN DE FORMATO POR NOMINA.</p>",
        message: '<div class="row">  ' +
          '<div class="form-group"> ' +
          '<label class="col-lg-12 control-label" for="name" aling="left">Nombre de nómina</label> ' +
          '</div> ' +
          '<div class="col-md-12"> ' +
          '<input id="name" name="name" type="text" placeholder="Ruta de archivo XLSX" class="form-control input-md"> ' +
		 ' <p align="right"><button type="button" class="btn btn-default">SELECCIONAR</button></p>'+
          '</div> ' +
		  '<div class="col-md-4"> ' +
		   '</div> ' +
		  '<div class="col-md-12"> ' +
          '<table width="80%" border="1">'+
  '<tbody>'+
   ' <tr style="background-color:#0051a4">'+
     ' <th scope="col">ACT</th>'+
     ' <th scope="col">FORMATO</th>'+
     ' <th scope="col">LINK DE DESCARGA</th>'+
   ' </tr>'+
   ' <tr>'+
    '  <td><input type="radio" name="awesomeness" id="awesomeness-0"  checked="checked">'+
	'</td>'+
     ' <td>FORMATO1.XLS</td>'+
     ' <td>LINK</td>'+
   ' </tr>'+
    '<tr>'+
      '<td><input type="radio" name="awesomeness" id="awesomeness-1" value="Super awesome">'+
	  '</td>'+
     ' <td>FORMATO2.XLS</td>'+
     ' <td>LINK</td>'+
   ' </tr>'+
   ' <tr>'+
    '  <td><input type="radio" name="awesomeness" id="awesomeness-1" value="Super awesome">'+
	'</td>'+
     ' <td>FORMATO3.XLS</td>'+
     ' <td>LINK</td>'+
   ' </tr>'+
 ' </tbody>'+
'</table>' +
'<div class="col-md-4"> ' +
'</div> ' +
'</div> ' +
'</div> ' +
          '</form> </div>  </div>',
        buttons: {
          success: {
            label: "Guardar",
            className: "btn-success",
            callback: function () {
              var name = $('#name').val();
              var answer = $("input[name='awesomeness']:checked").val()
              Example.show("Hello " + name + ". You've chosen <b>" + answer + "</b>");
            }
          }
        }
      }
    );
  };

});
