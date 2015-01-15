package mx.nomina.gday.web.controller;

import java.util.ArrayList;
import java.util.List;





import javax.servlet.http.HttpServletRequest;

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
	
	  //Controller que permite obtener todas la razones sociales
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
				System.out.println("idRazonSocial"+ tmp.get(i).getIdRazonSocial());
				System.out.println("idGrupo"+ tmp.get(i).getGrupo().getIdGrupo());
				razonesSocialesTmp2.add(tmp.get(i).getIdRazonSocial());
				razonesSocialesTmp2.add(tmp.get(i).getRfc());
				razonesSocialesTmp2.add(tmp.get(i).getNombreCortoRazonS());
				razonesSocialesTmp2.add(tmp.get(i).getComision());
				razonesSocialesTmp2.add(tmp.get(i).getNombreRazonSocial());
//				razonesSocialesTmp2.add("<a href='#' onclick='obtenerRazonSocial("+tmp.get(i).getIdRazonSocial()+")'>Editar</a>");				
				razonesSocialesTmp2.add("<a href='#' onclick='showEditarRazonSocial("+tmp.get(i).getIdRazonSocial()+")'>Editar</a>");
				razonesSocialesTmp.add(razonesSocialesTmp2);
			}
			return razonesSocialesTmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		  return null;
		}
	  
	  //Controller 	que guarda una razon social
	  @RequestMapping(value="/guardarrazonsocial",method = RequestMethod.POST)
		 @ResponseBody
		    public boolean guardarRazonSocial(@ModelAttribute(value="razonsocial") RazonSocial razonSocial){
		  		try {
					
		  			System.out.println("Guardando razon social"+ razonSocial.getNombreCortoRazonS());
		  			System.out.println("Guardando razon social"+ razonSocial.getCodCliente());
		  			System.out.println(razonSocial.getJsonString());

		  			//razonSocial.setJsonString("{\"referenciantes\":[{ \"idReferenciante\": 1, \"nombreReferenciante\": \"GABY VAZQUEZ\" },{ \"idReferenciante\": 2,\"nombreReferenciante\": \"GABY VAZQUEZ\" }]}");
		  			//razonSocial.setJsonString("{ \"idReferenciante\": 1}");
		  			
		  			System.out.println(razonSocial.getJsonString());

		  			razonSocialServicio.agregarRazonSocial(razonSocial);
		  			return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
		  	
			 	return false;
		 }
	  
	 //MODIFICAR 
	//Controller que permite Actualizar los datos de la Razon Social a Editar
		 @RequestMapping(value="/modificarazonsocial",method = RequestMethod.POST)
		    @ResponseBody
		    public boolean modificarRazonSocial(@ModelAttribute(value="RazonSocial") RazonSocial razonSocial, BindingResult result,HttpServletRequest request){    	    	    	    	   		    
			 try {
		  			System.out.println("Actualizando razon social Controller"+ razonSocial.getIdRazonSocial());
		  			System.out.println("Actualizando grupo de razon social Controller"+ razonSocial.getGrupo().getIdGrupo());
		  			razonSocialServicio.actualizarRazonSocial(razonSocial);			 
				 return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			 	return false;
		    }
		 
		 //Controller que permite obtener la Razon Social por idGrupo
		 @RequestMapping(value="/obtenerrazonsocialbyid",method = RequestMethod.POST)
		    @ResponseBody
		    public RazonSocial obtenerRazonSocialById(@ModelAttribute(value="RazonSocial") RazonSocial razonSocial, BindingResult result){   
			 	System.out.println("Razon Social por id"+ razonSocial);
			 	return this.razonSocialServicio.obtenerRazonSocialById(razonSocial.getIdRazonSocial());
			 	
			}	 

	
}
