package mx.estrategas.fam.web.controller;

import java.util.List;

import mx.estrategas.fam.modelo.Afiliado;
import mx.estrategas.fam.modelo.Archivo;
import mx.estrategas.fam.modelo.Escuela;
import mx.estrategas.fam.servicios.AfiliadoServicio;
import mx.estrategas.fam.servicios.ArchivoServicio;
import mx.estrategas.seguridad.modelo.UsuarioSeguridad;
import mx.estrategas.seguridad.util.SeguridadUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller encargado de devolver la vista principal o index de la aplicación.
 * 
 * El path colocado en la anotación @RequestMappig corresponde a la cofiguración dentro
 * del archivo web.xml
 * 
 * <pre>
 * {@code
 *   <welcome-file-list>
 *       <welcome-file>mvc/index</welcome-file>
 *   </welcome-file-list>   
 * }
 * </pre>
 * 
 * @author SmartSolutions
 *
 */
@Controller
@RequestMapping("/archivo")
public class ArchivoController {	
	
	@Autowired
	private ArchivoServicio archivoServicio;

	private static final Logger log = LoggerFactory.getLogger(ArchivoController.class);
    
    /**
     * Devuelve el index de la aplicación.
     * 
     * @return ModelAndView que corresponde a la vista principal de la aplicación.
     */
	
	@RequestMapping(value="/getarchivos", method = RequestMethod.GET)
    @ResponseBody
    public List<Archivo> getArchivos() {                 
        return this.archivoServicio.obtenerArchivos();
    }
}
