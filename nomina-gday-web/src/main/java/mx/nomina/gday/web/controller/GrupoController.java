package mx.nomina.gday.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.nomina.gday.modelo.Grupo;
import mx.nomina.gday.servicios.GrupoServicio;

@Controller
@RequestMapping("/grupo")
public class GrupoController {

	@Autowired
	private GrupoServicio grupoServicio;

	 @RequestMapping(value="/guardargrupo",method = RequestMethod.POST)
	 @ResponseBody
	    public boolean guardarGrupo(@ModelAttribute(value="grupo") Grupo grupo, BindingResult result){
		 	System.out.println("Guardando el grupo"+ grupo);
		 	grupoServicio.agregarGrupo(grupo);
		 	
			return true;
		 
	 }

}
