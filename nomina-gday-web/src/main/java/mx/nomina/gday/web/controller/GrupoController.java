package mx.nomina.gday.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.nomina.gday.modelo.Grupo;
import mx.nomina.gday.modelo.RazonSocial;
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
	 
	 @RequestMapping(value="/getgrupos",method = RequestMethod.POST)
	    @ResponseBody
	    public List obtenerGrupos(){    	
		  System.out.println("Controller Grupo");
		  try {
			List<Grupo> tmp =  this.grupoServicio.obtenerGrupos();
			System.out.println("tmp"+tmp.size());
			List gruposTmp = new ArrayList();
			List gruposTmp2 = new ArrayList<String>();

			for (int i = 0; i < tmp.size(); i++) {
				gruposTmp2 = new ArrayList<String>();
				System.out.println("tmp"+tmp.get(i));
				gruposTmp2.add(tmp.get(i).getIdGrupo());
				gruposTmp2.add(tmp.get(i).getNombre());
				gruposTmp2.add(tmp.get(i).getNombreCorto());
				gruposTmp2.add("<a href='#' onclick='seleccionarGrupo("+tmp.get(i).getIdGrupo()+",\""+tmp.get(i).getNombreCorto()+"\")'>Seleccionar</a>");				
				gruposTmp.add(gruposTmp2);
			}
			return gruposTmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		  return null;
		}

}
