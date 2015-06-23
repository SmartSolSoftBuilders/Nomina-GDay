package mx.nomina.gday.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	//Controller Guardar Grupo
	 @RequestMapping(value="/guardargrupo",method = RequestMethod.POST)
	 @ResponseBody
	    public boolean guardarGrupo(@ModelAttribute(value="grupo") Grupo grupo, BindingResult result){
		 	System.out.println("Guardando el grupo"+ grupo.getNombreCorto());
		 	Integer check=this.grupoServicio.checkGrupoByRS(grupo);		 	
		 	if (check>0)
		 		return false;
		 	System.out.println("Existe?"+ grupo);
		 	grupoServicio.agregarGrupo(grupo);		 	
			return true;
		 
	 }
	 
	 //Controller que muestra la lista de Grupos y permite la seleccion del mismo
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
	 
	 //MODIFICAR GRUPO
	 
	//Controller que muestra la lista de Grupos y permite la Edicion del mismo
		 @RequestMapping(value="/getgruposaeditar",method = RequestMethod.POST)
		    @ResponseBody
		    public List obtenerGruposaEditar(){    	
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
					gruposTmp2.add("<a href='#' onclick='obtenerGrupo("+tmp.get(i).getIdGrupo()+")'><img src='../../static/img/editar.png' width='27' height='27'></img></a>");
					gruposTmp.add(gruposTmp2);
				}
				return gruposTmp;

			} catch (Exception e) {
				e.printStackTrace();
			}
			  return null;
			}

	 //Controller que permite Actualizar los datos del Grupo a Editar
	 @RequestMapping(value="/modificagrupo",method = RequestMethod.POST)
	    @ResponseBody
	    public boolean modificarGrupo(@ModelAttribute(value="grupo") Grupo grupo, BindingResult result,HttpServletRequest request){    	    	    	    	   
	    
		 try {
			 System.out.println("Controller Actualizar Grupo"+ grupo.getIdGrupo());
			 Integer check=this.grupoServicio.checkGrupoByRS(grupo);		 	
			 if (check>0)
			 	return false;
			grupoServicio.actualizarGrupo(grupo);			 
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		 	return false;
	    }
	 
	 //Controller que permite obtener el grupo por idGrupo
	 @RequestMapping(value="/obtenergrupobyid",method = RequestMethod.POST)
	    @ResponseBody
	    public Grupo obtenerGrupoById(@ModelAttribute(value="grupo") Grupo grupo, BindingResult result){    	
	    	System.out.println("Controller que obtiene el idGrupo"+ grupo.getIdGrupo());
		 	return this.grupoServicio.obtenerGrupoById(grupo.getIdGrupo());
		 	
		}	 

}
