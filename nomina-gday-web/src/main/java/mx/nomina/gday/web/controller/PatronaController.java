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

import mx.nomina.gday.modelo.Patrona;
import mx.nomina.gday.servicios.PatronaServicio;

@Controller
@RequestMapping("/patrona")
public class PatronaController {

	@Autowired
	private PatronaServicio patronaServicio;
	
	//Controller Guardar Patrona
	@RequestMapping(value="/guardarpatrona",method = RequestMethod.POST)
	 @ResponseBody
	 public boolean guardarPatrona(@ModelAttribute(value="patrona") Patrona patrona, BindingResult result){
		 	System.out.println("Guardando Patrona"+ patrona.getNumInteriorFiscalPatrona());
		 	patronaServicio.agregarPatrona(patrona);		 	
			return true;
	}
	
	
	//Controller que muestra la lista de Patronas y permite la seleccion de la misma
	 @RequestMapping(value="/getpatronas",method = RequestMethod.POST)
	    @ResponseBody
	    public List obtenerPatronas(){    	
		  System.out.println("Controller Grupo");
		  try {
			List<Patrona> tmp =  this.patronaServicio.obtenerPatronas();
			System.out.println("tmp"+tmp.size());
			List patronasTmp = new ArrayList();
			List patronasTmp2 = new ArrayList<String>();

			for (int i = 0; i < tmp.size(); i++) {
				patronasTmp2 = new ArrayList<String>();
				System.out.println("tmp"+tmp.get(i));
				patronasTmp2.add(tmp.get(i).getIdPatrona());				
				patronasTmp2.add(tmp.get(i).getNombreCortoPatrona());
				patronasTmp2.add(tmp.get(i).getTipoRegimen().getTipoRegimen());
				System.out.println("REG"+tmp.get(i).getTipoRegimen().getTipoRegimen());
				patronasTmp2.add("<a href='#' onclick='seleccionarPatrona("+tmp.get(i).getIdPatrona()+",\""+tmp.get(i).getNombreCortoPatrona()+"\")'>Seleccionar</a>");
				patronasTmp2.add("<a href='#' onclick='showEditarPatrona("+tmp.get(i).getIdPatrona()+")'><img src='../../static/img/editar.png' width='27' height='27'></img>'</a>");				
				patronasTmp.add(patronasTmp2);
			}
			return patronasTmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		  return null;
		}
	 
		//Controller que muestra la lista de Patronas y permite la seleccion de la misma
	 @RequestMapping(value="/getpatronasintermediarias",method = RequestMethod.POST)
	    @ResponseBody
	    public List obtenerPatronasIntermediarias(){    	
		  System.out.println("Controller PatronaIntermediaria");
		  try {
			List<Patrona> tmp =  this.patronaServicio.obtenerPatronasIntermediarias();
			System.out.println("tmp"+tmp.size());
			List patronasTmp = new ArrayList();
			List patronasTmp2 = new ArrayList<String>();

			for (int i = 0; i < tmp.size(); i++) {
				patronasTmp2 = new ArrayList<String>();				
				patronasTmp2.add(tmp.get(i).getIdPatrona());
				patronasTmp2.add(tmp.get(i).getNombreCortoPatrona());
				patronasTmp2.add("<a href='#' onclick='seleccionarPatronaIntermediaria("+tmp.get(i).getIdPatrona()+",\""+tmp.get(i).getNombreCortoPatrona()+"\")'>Seleccionar</a>");
				patronasTmp2.add("<a href='#' onclick='showEditarPatrona("+tmp.get(i).getIdPatrona()+")'><img src='../../static/img/editar.png' width='27' height='27'></img>'</a>");				
				patronasTmp.add(patronasTmp2);
			}
			return patronasTmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		  return null;
		}
	 
	//Controller que muestra la lista de Patronas y permite la edicion de la misma
		 @RequestMapping(value="/getpatronasaeditar",method = RequestMethod.POST)
		    @ResponseBody
		    public List obtenerPatronasaEditar(){    	
			  System.out.println("Controller Grupo");
			  try {
				List<Patrona> tmp =  this.patronaServicio.obtenerPatronas();
				
				System.out.println("tmp"+tmp.size());
				List patronasTmp = new ArrayList();
				List patronasTmp2 = new ArrayList<String>();

				for (int i = 0; i < tmp.size(); i++) {
					patronasTmp2 = new ArrayList<String>();
					System.out.println("tmp"+tmp.get(i));
					System.out.println("Domicilios:"+tmp.get(i).getDomVirtuales().size());
					System.out.println("Poderes notariales laborales:"+tmp.get(i).getPoderesNotarialesLaborales());
					System.out.println("PleitCob:->"+tmp.get(i).getPoderesNotarialesPleitosCobranzas());

					patronasTmp2.add(tmp.get(i).getIdPatrona());
					patronasTmp2.add(tmp.get(i).getNombreCortoPatrona());
					System.out.println("REG"+tmp.get(i).getTipoRegimen().getTipoRegimen());
					patronasTmp2.add(tmp.get(i).getTipoRegimen().getTipoRegimen());
					patronasTmp2.add("<a href='#' onclick='showEditarPatrona("+tmp.get(i).getIdPatrona()+")'><img src='../../static/img/editar.png' width='27' height='27'></img>'</a>");				
					patronasTmp.add(patronasTmp2);
				}
				return patronasTmp;

			} catch (Exception e) {
				e.printStackTrace();
			}
			  return null;
	}
		 
	 //MODIFICAR
	//Controller que permite Actualizar los datos de la Nomina a Editar
	 @RequestMapping(value="/modificapatrona",method = RequestMethod.POST)
	    @ResponseBody
	    public boolean modificarPatrona(@ModelAttribute(value="patrona") Patrona patrona, BindingResult result,HttpServletRequest request){    	    	    	    	   
	    
		 try {
			 System.out.println("Controller Actualizar Patrona"+ patrona.getNumInteriorFiscalPatrona());
				 patronaServicio.actualizarPatrona(patrona);			 
			 return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		 	return false;
	    }
	//LLENADO DEL SELECT COMBO, TIPO_REGIMEN
		 //Obteber los datos de TipoRegimen para el llenado de sus respectivos Combos
		 @RequestMapping(value="/getdatoscombo",method = RequestMethod.POST)
		    @ResponseBody
		    public List obtenerDatosCombo(){
			 	System.out.println("Controller Datos del combo");
				return this.patronaServicio.obtenerDatosCombo();
			}
		 
		 //Controller que permite obtener la Patrona por idPatrona
		 @RequestMapping(value="/obtenerpatronabyid",method = RequestMethod.POST)
		    @ResponseBody
		    public Patrona obtenerPatronaById(@ModelAttribute(value="Patrona") Patrona patrona, BindingResult result){   
			 	System.out.println("Patrona por id"+ patrona.getIdPatrona());
			 	return 	this.patronaServicio.obtenerPatronaById(patrona.getIdPatrona());
			}	
}
