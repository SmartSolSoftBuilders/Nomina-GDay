package mx.nomina.gday.web.controller;

import java.util.ArrayList;
import java.util.List;




import mx.nomina.gday.modelo.Grupo;
import mx.nomina.gday.modelo.RazonSocial;
import mx.nomina.gday.servicios.RazonSocialServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/razonsocial")
public class RazonSocialController {
	
	@Autowired
	private RazonSocialServicio razonSocialServicio;
	
	  @RequestMapping(value="/getrazonessociales",method = RequestMethod.POST)
	    @ResponseBody
	    public List obtenerRazonesSociales(){    	
		  System.out.println("Controller Razon Social");
		  try {
			List<RazonSocial> tmp =  this.razonSocialServicio.obtenerRazonesSociales();
			System.out.println("tmp"+tmp.size());
			List razonesSocialesTmp = new ArrayList();
			List razonesSocialesTmp2 = new ArrayList<String>();

			for (int i = 0; i < tmp.size(); i++) {
				razonesSocialesTmp2 = new ArrayList<String>();
				System.out.println("tmp"+tmp.get(i));
				razonesSocialesTmp2.add(tmp.get(i).getIdRazonSocial());
				razonesSocialesTmp2.add(tmp.get(i).getRfc());
				razonesSocialesTmp2.add(tmp.get(i).getNombreCortoRazonS());
				razonesSocialesTmp2.add(tmp.get(i).getComision());
				razonesSocialesTmp2.add(tmp.get(i).getNombreRazonSocial());
				razonesSocialesTmp2.add("<a href='#' ("+tmp.get(i).getIdRazonSocial()+","+tmp.get(i).getNombreCortoRazonS()+"'>Editar</a>");
				razonesSocialesTmp.add(razonesSocialesTmp2);
			}
			return razonesSocialesTmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		  return null;
		}
	  
	  @RequestMapping(value="/guardarrazonsocial",method = RequestMethod.POST)
		 @ResponseBody
		    public boolean guardarRazonSocial(@ModelAttribute(value="razonsocial") RazonSocial razonSocial, BindingResult result){
		  		try {
					
		  			System.out.println("Guardando razon social"+ razonSocial);	  			
		  			razonSocialServicio.agregarRazonSocial(razonSocial);
		  			return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
		  	
			 	return false;
		 }
	
}
