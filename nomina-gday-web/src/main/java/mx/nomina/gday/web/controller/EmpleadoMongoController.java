package mx.nomina.gday.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import mx.nomina.gday.modelo.Archivo;
import mx.nomina.gday.servicios.ArchivoServicio;
import mx.nomina.gday.servicios.CargaMasivaServicio;
import mx.nomina.gday.servicios.EmpleadoMongoServicio;
import mx.nomina.gday.web.util.FileFormBean;
import mx.nomina.gday.web.util.UploadFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/empleadomongo")
public class EmpleadoMongoController {

	@Autowired
	private EmpleadoMongoServicio empleadoMongoServicio;	
		
	@RequestMapping(value="/mongotest", method = RequestMethod.GET)
	public @ResponseBody String guardaFichero(){  
		this.empleadoMongoServicio.testMongo();
		return "Fichero grabado correctamente";
	}        
	    
}
