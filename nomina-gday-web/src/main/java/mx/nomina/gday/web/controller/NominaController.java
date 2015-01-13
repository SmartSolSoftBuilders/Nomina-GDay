package mx.nomina.gday.web.controller;

import mx.nomina.gday.modelo.Nomina;
import mx.nomina.gday.servicios.NominaServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/nomina")
public class NominaController {

	@Autowired
	private NominaServicio nominaServicio;
	
	//Controller Guardar Grupo
		 @RequestMapping(value="/guardarnomina",method = RequestMethod.POST)
		 @ResponseBody
		    public boolean guardarNomina(@ModelAttribute(value="nomina") Nomina nomina, BindingResult result){
			 	System.out.println("Guardando Nomina"+ nomina);
			 	nominaServicio.agregarNomina(nomina);			 	
			return true;
			 
		 }
		
}
