package mx.nomina.gday.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import mx.nomina.gday.modelo.Empleado;
import mx.nomina.gday.modelo.EmpleadoNomina;
import mx.nomina.gday.modelo.Grupo;
import mx.nomina.gday.modelo.Nomina;
import mx.nomina.gday.modelo.RazonSocial;
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
	
	//Controller Guardar Nomina
		 @RequestMapping(value="/guardarnomina",method = RequestMethod.POST)
		 @ResponseBody
		 public boolean guardarNomina(@ModelAttribute(value="nomina") Nomina nomina, BindingResult result){
			 System.out.println("Guardando Nomina"+ nomina);
			 System.out.println("nomina"+nomina.getJsonValue());
			StringTokenizer tokens=new StringTokenizer(nomina.getJsonValue(), ",");				
			List<RazonSocial> razonesSociales = new ArrayList<RazonSocial>();
			while(tokens.hasMoreTokens()) {
				StringTokenizer tokens2=new StringTokenizer(tokens.nextToken(), ":");
				RazonSocial razonSocial = new RazonSocial();
				razonSocial.setIdRazonSocial(Integer.parseInt(tokens2.nextToken()));
				razonSocial.setJsonString(tokens2.nextToken());
				System.out.println(razonSocial.getIdRazonSocial());
				System.out.println(razonSocial.getJsonString());
				razonesSociales.add(razonSocial);
			}
			nomina.setRazonesSociales(razonesSociales);
			nominaServicio.agregarNomina(nomina);			 	
		return true;			
		}
		 
		//MODIFICAR
		//Controller que muestra la lista de Nomina y permite la Edicion del mismo
		 @RequestMapping(value="/getnominas",method = RequestMethod.POST)
		    @ResponseBody
		    public List obtenerNominasaEditar(HttpServletRequest request){    	
			  System.out.println("Controller Nomina");
			  String rol=request.getSession().getAttribute("rolUser").toString();
			  Integer idUsr=Integer.parseInt(request.getSession().getAttribute("idUserSeg").toString());
			  try {
				List<Nomina> tmp = new ArrayList<Nomina>();
				if (rol.equals("ROL_EJECUTIVO_NOMINA")){
					System.out.println("EJECUTIVO!!!");
					tmp =  this.nominaServicio.obtenerNominasByIdEjecutivo(idUsr);
				}
				else{
					tmp =  this.nominaServicio.obtenerNominas();
				}
				System.out.println("tmp"+tmp.size());
				List nominasTmp = new ArrayList();
				List nominasTmp2 = new ArrayList<String>();

				for (int i = 0; i < tmp.size(); i++) {
					nominasTmp2 = new ArrayList<String>();
					System.out.println("tmp"+tmp.get(i));
					nominasTmp2.add(tmp.get(i).getIdNomina());
					nominasTmp2.add(tmp.get(i).getNombreCorto());
					nominasTmp2.add(tmp.get(i).getEsquema().getNombreEsquema());
					nominasTmp2.add(tmp.get(i).getPatrona().getNombreCortoPatrona());
					nominasTmp2.add(tmp.get(i).getIntermediaria().getNombreCortoPatrona());					
					nominasTmp2.add(tmp.get(i).getPeriodicidad());
					nominasTmp2.add(tmp.get(i).getTipoPago());
					nominasTmp2.add(""+tmp.get(i).getClaseRiesgo());
					nominasTmp2.add("<a href='#' onclick='showEditarNomina("+tmp.get(i).getIdNomina()+")'>'<img src='../../static/img/editar.png' width='27' height='27'></img>'</a>");
					nominasTmp2.add("<a href='#' onclick='obtenerEmpleadoByIdNomina("+tmp.get(i).getIdNomina()+")'>Empleados</a>");
					nominasTmp.add(nominasTmp2);
				}
				return nominasTmp;

			} catch (Exception e) {
				e.printStackTrace();
			}
			  return null;
		}
			//Controller que muestra la lista de Nomina y permite la Edicion del mismo
		 @RequestMapping(value="/getnominas_hojas",method = RequestMethod.POST)
		    @ResponseBody
		    public List obtenerNominasHojas(HttpServletRequest request){
			  System.out.println("Controller HojasTrab- Nomina");
			  System.out.println("Controller Nomina");
			  String rol=request.getSession().getAttribute("rolUser").toString();
			  Integer idUsr=Integer.parseInt(request.getSession().getAttribute("idUserSeg").toString());
			  try {
				List<Nomina> tmp = new ArrayList<Nomina>();
				if (rol.equals("ROL_EJECUTIVO_NOMINA")){
					System.out.println("EJECUTIVO!!!");
					tmp =  this.nominaServicio.obtenerNominasByIdEjecutivo(idUsr);
				}
				else{
					tmp =  this.nominaServicio.obtenerNominas();
				}
			  System.out.println("tmp"+tmp.size());
				List nominasTmp = new ArrayList();
				List nominasTmp2 = new ArrayList<String>();

				for (int i = 0; i < tmp.size(); i++) {
					nominasTmp2 = new ArrayList<String>();
					System.out.println("tmp"+tmp.get(i));
					nominasTmp2.add(tmp.get(i).getIdNomina());
					nominasTmp2.add(tmp.get(i).getNombreCorto());
					nominasTmp2.add(tmp.get(i).getEsquema().getNombreEsquema());
					nominasTmp2.add(tmp.get(i).getIntermediaria().getNombreCortoPatrona());
					nominasTmp2.add(tmp.get(i).getPatrona().getNombreCortoPatrona());
					nominasTmp2.add(tmp.get(i).getPeriodicidad());
					nominasTmp2.add(tmp.get(i).getTipoPago());
					nominasTmp2.add(tmp.get(i).getClaseRiesgo());
					nominasTmp2.add("<a href='#' onclick='showHojasTrabajoNomina("+tmp.get(i).getIdNomina()+")'>GESTIONAR FORMATO</a>");		
					nominasTmp.add(nominasTmp2);
				}
				return nominasTmp;

			} catch (Exception e) {
				e.printStackTrace();
			}
			  return null;
		}

		//Controller que muestra la lista de nóminas para seleccionarla a un empleado
		@RequestMapping(value="/getnominasemp",method = RequestMethod.POST)
		    @ResponseBody
		    public List obtenerNominasEmpleado(){    	
			  System.out.println("Controller Nomina");
			  try {
				List<Nomina> tmp =  this.nominaServicio.obtenerNominas();
				System.out.println("tmp"+tmp.size());
				List nominasTmp = new ArrayList();
				List nominasTmp2 = new ArrayList<String>();

				for (int i = 0; i < tmp.size(); i++) {
					nominasTmp2 = new ArrayList<String>();
					System.out.println("tmp"+tmp.get(i));
					nominasTmp2.add(tmp.get(i).getIdNomina());
					nominasTmp2.add(tmp.get(i).getNombreCorto());
					nominasTmp2.add(tmp.get(i).getEsquema().getNombreEsquema());
					nominasTmp2.add(tmp.get(i).getIntermediaria().getNombreCortoPatrona());
					nominasTmp2.add(tmp.get(i).getPatrona().getNombreCortoPatrona());
					nominasTmp2.add(tmp.get(i).getPeriodicidad());
					nominasTmp2.add(tmp.get(i).getTipoPago());
					nominasTmp2.add(tmp.get(i).getClaseRiesgo());
					nominasTmp2.add("<a href='#' onclick='showNominaForm("+tmp.get(i).getIdNomina()+",\""+tmp.get(i).getNombreCorto()+"\")'><img src='../../static/img/editar.png' width='27' height='27'></img></a>");
					nominasTmp.add(nominasTmp2);
				}
				return nominasTmp;

			} catch (Exception e) {
				e.printStackTrace();
			}
			  return null;
		}

		

		//Controller que permite Actualizar los datos de la Nomina a Editar
		 @RequestMapping(value="/modificanomina",method = RequestMethod.POST)
		    @ResponseBody
		    public boolean modificarNomina(@ModelAttribute(value="nomina") Nomina nomina, BindingResult result,HttpServletRequest request){    	    	    	    	   
		    
			 try {
				 System.out.println("Controller Actualizar Nomina"+ nomina.getIdNomina());
				 	System.out.println("Guardando Nomina"+ nomina);
				 	System.out.println("nomina"+nomina.getJsonValue());
					StringTokenizer tokens=new StringTokenizer(nomina.getJsonValue(), ",");				
					List<RazonSocial> razonesSociales = new ArrayList<RazonSocial>();
					while(tokens.hasMoreTokens()) {
						StringTokenizer tokens2=new StringTokenizer(tokens.nextToken(), ":");
						RazonSocial razonSocial = new RazonSocial();
						razonSocial.setIdRazonSocial(Integer.parseInt(tokens2.nextToken()));
						razonSocial.setJsonString(tokens2.nextToken());
						System.out.println(razonSocial.getIdRazonSocial());
						System.out.println(razonSocial.getJsonString());
						razonesSociales.add(razonSocial);
					 }
					nomina.setRazonesSociales(razonesSociales);
					 nominaServicio.actualizarNomina(nomina);			 
				 return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			 	return false;
		    }
		
		 //Controller que permite obtener la Nomina por idNomina
		 @RequestMapping(value="/obtenernominabyid",method = RequestMethod.POST)
		    @ResponseBody
		    public Nomina obtenerNominaById(@ModelAttribute(value="Nomina") Nomina nomina, BindingResult result){   
			 	System.out.println("Nomina por id"+ nomina);
			 	Nomina nominaTmp=this.nominaServicio.obtenerNominaById(nomina.getIdNomina());
			 	nominaTmp.setRazonesSociales(this.nominaServicio.obtenerRazonesSocialesByIdNomina(nomina.getIdNomina()));
			 	return nominaTmp;
			 	
			}	 
		 
		 //LLENADO DEL SELECT COMBO, EJECUTIVO Y ESQUEMA
		 //Obteber los datos de Ejecutivo y Esquema para el llenado de sus respectivos Combos
		 @RequestMapping(value="/getdatoscombo",method = RequestMethod.POST)
		    @ResponseBody
		    public List obtenerDatosCombo(){
			 	System.out.println("Controller Datos del combo");
				return this.nominaServicio.obtenerDatosCombo();
			}
		 
		 @RequestMapping(value="/obtenernominasbyempleado",method = RequestMethod.POST)
		    @ResponseBody
		    public List<Nomina> obtenerNominasByEmpleadoById(@ModelAttribute(value="Empleado") Empleado empleado, BindingResult result){   
			 	System.out.println("Empleado por id"+ empleado.getIdEmpleado());
			 	return this.nominaServicio.obtenerNominasByIdEmpleado(empleado.getIdEmpleado());
			 	
			}
		

}
