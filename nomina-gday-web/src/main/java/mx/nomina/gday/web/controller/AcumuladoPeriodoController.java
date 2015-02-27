package mx.nomina.gday.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.nomina.gday.modelo.AcumuladoPeriodo;
import mx.nomina.gday.modelo.Empleado;
import mx.nomina.gday.modelo.Nomina;
import mx.nomina.gday.modelo.Periodo;
import mx.nomina.gday.servicios.AcumuladoPeriodoServicio;
import mx.nomina.gday.servicios.NominaServicio;
import mx.nomina.gday.web.util.UploadFile;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@Controller
@RequestMapping("/acumulado")
public class AcumuladoPeriodoController {
	
	@Autowired
	private AcumuladoPeriodoServicio  acumuladoPeriodoServicio;
	
	@Autowired
	private NominaServicio nominaServicio;
	
	UploadFile ufile;	
	public AcumuladoPeriodoController(){
		System.out.println("init AcumuladoPeriodoController");
		ufile = new UploadFile();
	}


	 @RequestMapping(value="/acumuladoPeriodo", method = RequestMethod.POST)
	 public @ResponseBody String guardaFichero(MultipartHttpServletRequest request, HttpServletResponse response){  
	 	Iterator<String> itr =request.getFileNames();
	 	MultipartFile mpf = request.getFile(itr.next());
	 	AcumuladoPeriodo acumuladoPeriodo=new AcumuladoPeriodo();
	     try {
	     	ufile.idEvento = mpf.getBytes().length;
	 		ufile.length = mpf.getBytes().length;
	 		ufile.bytes= mpf.getBytes();
	 		ufile.type = mpf.getContentType();
	 		ufile.name = mpf.getOriginalFilename();		
	 		
	 		//Saving file
	 		Periodo periodo = new Periodo();
	 		Nomina nomina= new Nomina();
	 		Integer idPeriodo = Integer.parseInt(request.getParameter("idPeriodo"));
	 		Integer idNomina = Integer.parseInt(request.getParameter("idNomina"));
	 		System.out.println(idPeriodo);
	 		System.out.println(idNomina);
	 		periodo.setIdPeriodo(idPeriodo);
	 		nomina.setIdNomina(idNomina);
	 		acumuladoPeriodo.setPeriodo(periodo);
	 		acumuladoPeriodo.setNomina(nomina);
	 		System.out.println("TIPO DE ARCHIVO:"+ufile.type);
	 		acumuladoPeriodo.setNombreArchivo(ufile.name);
	 		acumuladoPeriodo.setArchivoAcumulado(mpf.getBytes());
	 		System.out.println("Done"+ufile.length+acumuladoPeriodo.getArchivoAcumulado().length);
	     	this.acumuladoPeriodoServicio.agregarArchivo(acumuladoPeriodo);		
	 		System.out.println("LOS VALORES DEL ARCHIVO:"+acumuladoPeriodo.getArchivoAcumulado().length);		
	 		FileOutputStream fos = new FileOutputStream("C://archivosNGDAY//tmpAcumulado.xls");
	 	    fos.write(acumuladoPeriodo.getArchivoAcumulado());
	 	    fos.close(); 
	     }
	     catch (Exception e) {
	     	System.out.println("Error creando el archivo - Carga"+e.getMessage());
	         e.printStackTrace();
	         return "No se ha podido grabar el fichero";
	     }
	      
	     return "Fichero grabado correctamente";
	 }   
	
	 //LLENADO DEL SELECT COMBO, PERIODO
	 //Obteber los datos de Ejecutivo y Esquema para el llenado de sus respectivos Combos
	 @RequestMapping(value="/getdatoscombo",method = RequestMethod.POST)
	    @ResponseBody
	    public List obtenerDatosCombo(){
		 	System.out.println("Controller Datos del combo");
			return this.acumuladoPeriodoServicio.obtenerDatosCombo();
		}
	
	 
	 //Controller que muestra la lista de Acumulados
	 @RequestMapping(value="/getacumulados",method = RequestMethod.POST)
	    @ResponseBody
	    public List obtenerAcumulados(AcumuladoPeriodo acumuladoPeriodo){    	
		  System.out.println("Controller Acumulado"+acumuladoPeriodo);
		  try {
			List<AcumuladoPeriodo> tmp =  this.acumuladoPeriodoServicio.obtenerAcumuladosByIdNominaAndIdPeriodo(acumuladoPeriodo);
			System.out.println("tmp"+tmp.size());
			List acumuladosTmp = new ArrayList();
			List acumuladosTmp2 = new ArrayList<String>();

			for (int i = 0; i < tmp.size(); i++) {
				acumuladosTmp2 = new ArrayList<String>();
				System.out.println("tmp"+tmp.get(i));
				acumuladosTmp2.add(tmp.get(i).getIdAcumuladoPeriodo());
				acumuladosTmp2.add(tmp.get(i).getNombreArchivo());				
				acumuladosTmp2.add("<a href='#' onclick='ajax_download("+tmp.get(i).getIdAcumuladoPeriodo()+")'>Descargar</a>");			
				acumuladosTmp2.add(tmp.get(i).getPeriodo().getIdPeriodo());
				acumuladosTmp.add(acumuladosTmp2);
			}
			return acumuladosTmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		  return null;
	 }


		@RequestMapping(value="/obteneracumulado",method = RequestMethod.POST)
	    @ResponseBody
	    public void getFile(HttpServletRequest request,HttpServletResponse response) {
			File fileToDownload = null;
	        InputStream inputStream = null;
	        Integer idAcumulado=Integer.parseInt(request.getParameter("id1"));
	        System.out.println("buscando el registro de nómina:"+idAcumulado);
	 		try{            
				//fileToDownload = this.hojaTrabajoServicio.generarHojaTrabajo(idHojaTrabajo);
				fileToDownload=acumuladoPeriodoServicio.obtenerArchivoAcumulado(idAcumulado);
	            inputStream = new FileInputStream(fileToDownload);
	            response.setContentType("application/force-download");
	            response.setHeader("Content-Disposition", "attachment; filename="+"acumulado.xls"); 
	            IOUtils.copy(inputStream, response.getOutputStream());
	            response.flushBuffer();
	        }catch(Exception e){            
	            e.printStackTrace();
	        }
	 
	    }	 
}
