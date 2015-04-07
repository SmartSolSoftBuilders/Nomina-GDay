package mx.nomina.gday.web.controller;

import java.util.ArrayList;
import java.util.List;








import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import mx.nomina.gday.modelo.Nomina;
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
				razonesSocialesTmp2.add("<a href='#' onclick='showEditarRazonSocial("+tmp.get(i).getIdRazonSocial()+")'><img src='../../static/img/editar.png' width='27' height='27'></img></a>");
				razonesSocialesTmp2.add("<a href='#' onclick='showNominasPorRazonSocial("+tmp.get(i).getIdRazonSocial()+")'>Nominas</a>");
				razonesSocialesTmp.add(razonesSocialesTmp2);
			}
			return razonesSocialesTmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		  return null;
		}
	  
	  //Obtiene las razones sociales para ser seleccionadas
	  @RequestMapping(value="/getrazonessociales_nomina",method = RequestMethod.POST)
	    @ResponseBody
	    public List obtenerRazonesSocialesSel(int porcentaje,String  id, String id2){ 
		StringTokenizer tokens=new StringTokenizer(id, ",");
		StringTokenizer tokens2=new StringTokenizer(id2, ",");
		
		ArrayList<String> ids=new ArrayList<String>();
		ArrayList<String> ids2=new ArrayList<String>();
		while(tokens.hasMoreTokens()) {
			 ids.add(tokens.nextToken());
		 }
		while(tokens2.hasMoreTokens()) {
			 ids2.add(tokens2.nextToken());
		 }
		 System.out.println("Controller Razon Social:"+id2);
		  try {
			  System.out.println("porcentaje:"+porcentaje+id); 
			List<RazonSocial> tmp =  this.razonSocialServicio.obtenerRazonesSociales();
			System.out.println("tmp"+tmp.size());
			List razonesSocialesTmp = new ArrayList();
			List razonesSocialesTmp2 = new ArrayList<String>();
			if (porcentaje>0){
			for (int i = 0; i < tmp.size(); i++) {
				razonesSocialesTmp2 = new ArrayList<String>();
				razonesSocialesTmp2.add(tmp.get(i).getIdRazonSocial());
				razonesSocialesTmp2.add(tmp.get(i).getGrupo().getNombre());
				razonesSocialesTmp2.add(tmp.get(i).getNombreRazonSocial());
				razonesSocialesTmp2.add(tmp.get(i).getNombreCortoRazonS());
				razonesSocialesTmp2.add(tmp.get(i).getRfc());
				System.out.println("CONTIENE"+tmp.get(i).getIdRazonSocial()+"?"+ids.contains(""+tmp.get(i).getIdRazonSocial()));
				if (!ids.contains(""+tmp.get(i).getIdRazonSocial())){
					razonesSocialesTmp2.add("(%):"+"<input type='text' size=5 id='porcentaje"+tmp.get(i).getIdRazonSocial()+"' value='"+porcentaje+"'/>");
					razonesSocialesTmp2.add("<a href='#' onclick='agregarRZ("+tmp.get(i).getIdRazonSocial()+",\""+tmp.get(i).getNombreCortoRazonS()+"\")'>Agregar</a>");
				}
				else{
					int pos=0;
					for (int k=0;k<ids.size();k++){
						if (ids.get(k).equals(""+tmp.get(i).getIdRazonSocial())){
							pos=k;
						}
					}
					razonesSocialesTmp2.add("(%):"+"<input type='text' size=5 id='porcentaje"+tmp.get(i).getIdRazonSocial()+"' value='"+ids2.get(pos)+"' readonly/>");
					razonesSocialesTmp2.add("YA ESTÁ AGREGADA");
				} 
				razonesSocialesTmp.add(razonesSocialesTmp2);
			}
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
			 	return this.razonSocialServicio.obtenerRazonSocialById(razonSocial.getIdRazonSocial());
			 	
			}	 
//LISTA DE NOMINAS POR RAZON SOCIAL
		 //Controller que permite obtener todas la razones sociales
		  @RequestMapping(value="/getnominasbyidrazonsocial",method = RequestMethod.POST)
		    @ResponseBody
		    public List obtenerNominasByIdRazonSocial(@ModelAttribute (value="RazonSocial") RazonSocial razonSocial, BindingResult result){    	
			  System.out.println("Controller NominasByIdRazonSocial"+razonSocial.getIdRazonSocial());
			
			  try {

				List<Nomina> tmp =  this.razonSocialServicio.obtenerNominasByIdRazonSocial(razonSocial.getIdRazonSocial());
				System.out.println("tmp"+tmp.size());
				List nominasRazonSocialTmp = new ArrayList();
				List nominasRazonSocialTmp2 = new ArrayList<String>();

				for (int i = 0; i < tmp.size(); i++) {
					nominasRazonSocialTmp2 = new ArrayList<String>();
					System.out.println("tmp"+tmp.get(i));
					nominasRazonSocialTmp2.add(tmp.get(i).getIdNomina());
					nominasRazonSocialTmp2.add(tmp.get(i).getNombreCorto());
					nominasRazonSocialTmp2.add(tmp.get(i).getEsquema().getNombreEsquema());
					nominasRazonSocialTmp2.add(tmp.get(i).getPatrona().getNombreCortoPatrona());
					nominasRazonSocialTmp2.add(tmp.get(i).getIntermediaria().getNombreCortoPatrona());
					nominasRazonSocialTmp2.add(tmp.get(i).getPeriodicidad());
					nominasRazonSocialTmp2.add(tmp.get(i).getTipoPago());
					nominasRazonSocialTmp2.add(tmp.get(i).getClaseRiesgo());
					nominasRazonSocialTmp2.add(tmp.get(i).getPorcPrimaVacacional());
					nominasRazonSocialTmp2.add(tmp.get(i).getFechaContrato());
					nominasRazonSocialTmp.add(nominasRazonSocialTmp2);
				}
				return nominasRazonSocialTmp;

			} catch (Exception e) {
				e.printStackTrace();
			}
			  return null;
			}
}
