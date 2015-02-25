package mx.nomina.gday.web.controller;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import mx.nomina.gday.modelo.AcumuladoPeriodo;
import mx.nomina.gday.modelo.Archivo;
import mx.nomina.gday.modelo.HojaTrabajo;
import mx.nomina.gday.modelo.Nomina;
import mx.nomina.gday.modelo.Periodo;
import mx.nomina.gday.servicios.AcumuladoPeriodoServicio;
import mx.nomina.gday.web.util.UploadFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	 		Nomina nomina = new Nomina();
	 		Periodo periodo = new Periodo();
	 		Integer idPeriodo = Integer.parseInt(request.getParameter("idNomSubirArchivo"));
	 		System.out.println(idPeriodo);
	 		periodo.setIdPeriodo(idPeriodo);
	 		acumuladoPeriodo.setPeriodo(periodo);;
	 		System.out.println("TIPO DE ARCHIVO:"+ufile.type);
	 		acumuladoPeriodo.setArchivoAcumulado(mpf.getBytes());
	 		System.out.println("Done"+ufile.length+acumuladoPeriodo.getArchivoAcumulado().length);
	     	this.acumuladoPeriodoServicio.agregarAcumulado(acumuladoPeriodo);		
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
	 
}
