package mx.nomina.gday.web.controller;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import mx.nomina.gday.servicios.CargaMasivaServicio;
import mx.nomina.gday.servicios.EmpleadoServicio;
import mx.nomina.gday.web.util.FileFormBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/carga")
public class CargaMasivaController {

@Autowired
private EmpleadoServicio empleadoServicio;	

@Autowired
private CargaMasivaServicio cargaMasivaServicio;
	
public @ModelAttribute("fileFormBean") FileFormBean getInitialMessage() {
	System.out.println("Se crea el bean!");
    return new FileFormBean();
}

@RequestMapping(value="/carga", method = RequestMethod.POST)
@ResponseBody
public @ModelAttribute("message") String guardaFichero(@ModelAttribute FileFormBean fileFormBean){        
    try {
        grabarFicheroALocal(fileFormBean);
        this.cargaMasivaServicio.cargarExcel("C://archivosNGDAY//"+fileFormBean.getFichero().getOriginalFilename().toString());
        
    }
    catch (Exception e) {
    	System.out.println("Error creando el archivo - Carga"+e.getMessage());
        e.printStackTrace();
        return "No se ha podido grabar el fichero";
    }
     
    return "Fichero grabado correctamente";
}        

private void grabarFicheroALocal(FileFormBean fileFormBean) throws Exception {
    CommonsMultipartFile uploaded = fileFormBean.getFichero();
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
	    
}
