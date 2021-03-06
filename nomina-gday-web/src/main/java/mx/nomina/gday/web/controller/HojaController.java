package mx.nomina.gday.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.nomina.gday.modelo.Archivo;
import mx.nomina.gday.modelo.Empleado;
import mx.nomina.gday.modelo.EmpleadoNomina;
import mx.nomina.gday.modelo.Grupo;
import mx.nomina.gday.modelo.HojaTrabajo;
import mx.nomina.gday.modelo.Nomina;
import mx.nomina.gday.modelo.RazonSocial;
import mx.nomina.gday.servicios.HojaTrabajoServicio;
import mx.nomina.gday.servicios.NominaServicio;
import mx.nomina.gday.web.util.UploadFile;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hoja")
public class HojaController {

	@Autowired
	private HojaTrabajoServicio hojaTrabajoServicio;
	
	UploadFile ufile;	
	public HojaController(){
		System.out.println("init CargaMasivaController");
		ufile = new UploadFile();
	}


		//Controller que muestra la lista de Nomina y permite la Edicion del mismo
		 @RequestMapping("/gethojas_nomina")
		 @ResponseBody
		    public List obtenerHojas(@ModelAttribute(value="nomina") Nomina nomina, BindingResult result){    	
			  System.out.println("Controller HojasTrab- Nomina:" + nomina.getIdNomina());
			  try {
				List<HojaTrabajo> tmp = new ArrayList<HojaTrabajo>();
				if (nomina.getIdNomina()==0)
					tmp=this.hojaTrabajoServicio.obtenerHojas();
				else
					tmp=this.hojaTrabajoServicio.obtenerHojasByIdNomina(nomina.getIdNomina());
				//System.out.println("tmp"+tmp.size());
				List nominasTmp = new ArrayList();
				List nominasTmp2 = new ArrayList<String>();
				for (int i = 0; i < tmp.size(); i++) {
					nominasTmp2 = new ArrayList<String>();
					//System.out.println("tmp"+tmp.get(i));
					nominasTmp2.add(tmp.get(i).getIdHojaTrabajo());
					nominasTmp2.add(tmp.get(i).getNombreArchivo());
					if (tmp.get(i).getArchivoPlantilla().equals("1"))
						nominasTmp2.add("ACTIVO");
					else
						nominasTmp2.add("");
					if(nomina.getIdNomina()!=0){
						nominasTmp2.add("<a href='#' onclick='eliminarHojaTrabajo("+tmp.get(i).getIdHojaTrabajo()+")'>Eliminar</a>");		
						nominasTmp2.add("<a href='#' onclick='activarHojaTrabajo("+tmp.get(i).getIdHojaTrabajo()+")'>Activar</a>");
					}
					else{
						nominasTmp2.add("<a href='#' onclick='generarHojaTrabajo("+tmp.get(i).getIdHojaTrabajo()+")'>Generar Hoja</a>");
					}
					nominasTmp.add(nominasTmp2);
				}
				return nominasTmp;

			} catch (Exception e) {
				e.printStackTrace();
			}
			  return null;
		}
		 
		@RequestMapping("/gethojastogen_nomina")
		@ResponseBody
		    public List obtenerHojastoGenNomina(@ModelAttribute(value="nomina") Nomina nomina, BindingResult result,HttpServletRequest request){    				  
			  try {
				List<HojaTrabajo> tmp = new ArrayList<HojaTrabajo>();
				String rol=request.getSession().getAttribute("rolUser").toString();
				Integer idUsr=Integer.parseInt(request.getSession().getAttribute("idUserSeg").toString());
				System.out.println("ID USER:"+idUsr);
				if (rol.equals("ROL_EJECUTIVO_NOMINA")){
					tmp=this.hojaTrabajoServicio.obtenerHojasByIdUser(idUsr);
				}
				else
					tmp=this.hojaTrabajoServicio.obtenerHojas();
				//System.out.println("tmp"+tmp.size());
				List nominasTmp = new ArrayList();
				List nominasTmp2 = new ArrayList<String>();
				for (int i = 0; i < tmp.size(); i++) {
					nominasTmp2 = new ArrayList<String>();
					//System.out.println("tmp"+tmp.get(i));
					nominasTmp2.add(tmp.get(i).getIdHojaTrabajo());			
					nominasTmp2.add(tmp.get(i).getNomina().getIdNomina());
					nominasTmp2.add(tmp.get(i).getNomina().getNombreCorto());
					if (tmp.get(i).getNomina().getPatrona()!=null)
						nominasTmp2.add(tmp.get(i).getNomina().getPatrona().getNombreCortoPatrona());
					else
						nominasTmp2.add("N/A");
					nominasTmp2.add("<a href='#' onclick='generarHojaTrabajo("+tmp.get(i).getIdHojaTrabajo()+")'>Generar Hoja</a>");					
					nominasTmp.add(nominasTmp2);
				}
				return nominasTmp;

			} catch (Exception e) {
				e.printStackTrace();
			}
			  return null;
		}

		@RequestMapping(value="/activarhojatrabajo",method = RequestMethod.POST)
		@ResponseBody
		public boolean activarHojaTrabajo(@ModelAttribute(value="hojaTrabajo") HojaTrabajo hojaTrabajo, BindingResult result){
			try{
				System.out.println("Guardando Nomina"+ hojaTrabajo.getNomina().getIdNomina());
				this.hojaTrabajoServicio.activarHojaTrabajo(hojaTrabajo);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return true;
		}		 
		
		@RequestMapping(value="/eliminarhojatrabajo",method = RequestMethod.POST)
		@ResponseBody
		public boolean eliminarHojaTrabajo(@ModelAttribute(value="hojaTrabajo") HojaTrabajo hojaTrabajo, BindingResult result){
		 	System.out.println("Eliminando"+ hojaTrabajo.getIdHojaTrabajo());
		 	this.hojaTrabajoServicio.eliminarHojaTrabajo(hojaTrabajo);
		 	return true;
		}
		 
		@RequestMapping(value="/carga", method = RequestMethod.POST)
		public @ResponseBody ModelAndView  guardaFichero(MultipartHttpServletRequest request, HttpServletResponse response){  
			Iterator<String> itr =request.getFileNames();
		 	MultipartFile mpf = request.getFile(itr.next());
		 	HojaTrabajo hojaTrabajo=new HojaTrabajo();
		    try {
		     	ufile.idEvento = mpf.getBytes().length;
		 		ufile.length = mpf.getBytes().length;
		 		ufile.bytes= mpf.getBytes();
		 		ufile.type = mpf.getContentType();
		 		ufile.name = mpf.getOriginalFilename();		
		 		
		 		//Saving file
		 		Nomina nomina = new Nomina();
		 		Integer idNomina = Integer.parseInt(request.getParameter("idNomSubirArchivo"));
		 		System.out.println(idNomina);
		 		nomina.setIdNomina(idNomina);
		 		hojaTrabajo.setNomina(nomina);
		 		System.out.println("TIPO DE ARCHIVO:"+ufile.type);
		 		String tipoArchivo="";
				if (ufile.type.equals("application/excel") || ufile.type.equals("application/vnd.ms-excel"))				
					tipoArchivo="xls";			
				else
					tipoArchivo="xlsx";
		 		hojaTrabajo.setArchivoAcumulado(mpf.getBytes());
		 		hojaTrabajo.setNombreArchivo(ufile.name);
		 		hojaTrabajo.setTipoArchivo(tipoArchivo);
		 		System.out.println("Done"+ufile.length+hojaTrabajo.getArchivoAcumulado().length);
		     	this.hojaTrabajoServicio.agregarArchivo(hojaTrabajo);		
		 		System.out.println("LOS VALORES DEL ARCHIVO:"+hojaTrabajo.getArchivoAcumulado().length);		
		 		FileOutputStream fos = new FileOutputStream("C://archivosNGDAY//tmpHojaTrabajo."+ tipoArchivo);
		 	    fos.write(hojaTrabajo.getArchivoAcumulado());
		 	    fos.close(); 
		    }
		    catch (Exception e) {
		    	System.out.println("Error creando el archivo - Carga"+e.getMessage());
		        e.printStackTrace();
		        //return "No se ha podido grabar el fichero";
		        return null;
		    }		 
		    return new ModelAndView("hojas_trabajo/nominas");
		    //return "Fichero grabado correctamente";
		 }        

		@RequestMapping(value="/generarHojaTrabajo",method = RequestMethod.POST)
		@ResponseBody
		public void getFile(HttpServletRequest request,HttpServletResponse response) {
			File fileToDownload = null;
		    InputStream inputStream = null;
		    Integer idHojaTrabajo=Integer.parseInt(request.getParameter("id1"));
		    System.out.println("buscando el registro de n�mina:"+idHojaTrabajo);
		 	try{            
		 		fileToDownload = this.hojaTrabajoServicio.generarHojaTrabajo(idHojaTrabajo);
		 		String ext= this.hojaTrabajoServicio.generarHojaTrabajoExt(idHojaTrabajo);
		        inputStream = new FileInputStream(fileToDownload);
		        response.setContentType("application/force-download");
		        response.setHeader("Content-Disposition", "attachment; filename="+"hojaTrabajo.xlsx"); 
		        IOUtils.copy(inputStream, response.getOutputStream());
		        response.flushBuffer();
		    }
		 	catch(Exception e){            
		 		e.printStackTrace();
		    }		 
		}
}
