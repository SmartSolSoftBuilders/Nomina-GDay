package mx.nomina.gday.web.controller;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import mx.nomina.gday.modelo.Archivo;
import mx.nomina.gday.servicios.ArchivoServicio;
import mx.nomina.gday.servicios.CargaMasivaServicio;
import mx.nomina.gday.servicios.EmpleadoServicio;
import mx.nomina.gday.web.util.FileFormBean;
import mx.nomina.gday.web.util.UploadFile;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/carga")
public class CargaMasivaController {

@Autowired
private EmpleadoServicio empleadoServicio;	

@Autowired
private CargaMasivaServicio cargaMasivaServicio;

@Autowired
private ArchivoServicio archivoServicio;

UploadFile ufile;	
public CargaMasivaController(){
	System.out.println("init CargaMasivaController");
	ufile = new UploadFile();
}

public @ModelAttribute("ufile") FileFormBean getInitialMessage() {
	System.out.println("Se crea el bean!");
    return new FileFormBean();
}

@RequestMapping(value="/carga", method = RequestMethod.POST)
public @ResponseBody void guardaFichero(MultipartHttpServletRequest request, HttpServletResponse response, ModelAndView mav){  
	Iterator<String> itr =request.getFileNames();
	MultipartFile mpf = request.getFile(itr.next());
	Archivo archivo = new Archivo();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();	
	String nombreArchivoLog="C:\\archivosNGDAY\\log-"+dateFormat.format(date)+(new Random().nextInt())+".txt";
	System.out.println(nombreArchivoLog);
	File fileToDownload = new File(nombreArchivoLog);	
	String logContent="";
    InputStream inputStream = null;
    System.out.println("DATOSssss");
    try {    	    
    	if (!fileToDownload.exists())
    		fileToDownload.createNewFile();    	
    	ufile.idEvento = mpf.getBytes().length;
		ufile.length = mpf.getBytes().length;
		ufile.bytes= mpf.getBytes();
		ufile.type = mpf.getContentType();
		ufile.name = mpf.getOriginalFilename();		
		
		//Saving file
		System.out.println("TIPO DE ARCHIVO:"+ufile.type);
		archivo.setArchivo(mpf.getBytes());
		
	   if (ufile.type.equals("application/vnd.ms-excel"))
		   archivo.setTipoArchivo("xls");
	   if (ufile.type.equals("application/excel"))
		   archivo.setTipoArchivo("xlsx");				
		System.out.println("Done"+ufile.length+archivo.getArchivo().length);
		System.out.println("FECHA DE CARGA:"+dateFormat.format(date));
        archivo.setFechaCarga(dateFormat.format(date));
    	this.archivoServicio.agregarArchivo(archivo);		
		//archivoServicio.agregarArchivo(archivo);
		System.out.println("LOS VALORES DEL ARCHIVO:"+archivo.getArchivo().length);		
		FileOutputStream fos = new FileOutputStream("C://archivosNGDAY//tmp.xls");
	    fos.write(archivo.getArchivo());
	    fos.close();		
        logContent=this.cargaMasivaServicio.cargarExcel("C://archivosNGDAY//tmp.xls");
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileToDownload));
        writer.write(logContent);
        writer.close();
        inputStream = new FileInputStream(fileToDownload);        
        response.setContentType("application/force-download");
        response.setHeader("Content-Disposition", "attachment; filename="+nombreArchivoLog); 
        IOUtils.copy(inputStream, response.getOutputStream());
        response.flushBuffer();                
    }
    catch (IOException e) {
    	System.out.println("Error creando el archivo de log!!:"+e.getMessage());
        e.printStackTrace();        
    }
    request.getSession().setAttribute("notification","Cargado con éxito");

}        


@RequestMapping(value="/revertir", method = RequestMethod.POST)
public @ResponseBody String revertir(){  	
	int valor = this.archivoServicio.revertirCarga();
	System.out.println("Terminando CARGA REVERTIDA");
    return "Fichero grabado correctamente";
}        

/*private void grabarFicheroALocal(UploadFile ufile) throws Exception {
	UploadFile uploaded = ufile;
    File localFile = new File("c://archivosNGDAY//"+uploaded.getOriginalFilename());        
    FileOutputStream os = null;         
    try {             
        os = new FileOutputStream(localFile);
        os.write(uploaded.getBytes());
    }
    finally {
        if (os != null) {
            try {
            	os.close();
            } catch (IOException e) {
            	System.out.println("<OTIKA>Error al guardar el archivo:"+e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
/*private void grabarFicheroALocal(UploadFile ufile) throws Exception {
	UploadFile uploaded = ufile;
    File localFile = new File("c://archivosNGDAY//"+uploaded.getOriginalFilename());        
    FileOutputStream os = null;         
    try {             
        os = new FileOutputStream(localFile);
        os.write(uploaded.getBytes());
    }
    finally {
        if (os != null) {
            try {
            	os.close();
            } catch (IOException e) {
            	System.out.println("<OTIKA>Error al guardar el archivo:"+e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
*/

	    
}
