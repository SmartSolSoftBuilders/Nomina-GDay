package mx.estrategas.fam.web.controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import mx.estrategas.fam.servicios.AfiliadoServicio;
import mx.estrategas.fam.servicios.CertificadoAfiliadoServicio;
import mx.estrategas.seguridad.modelo.UsuarioSeguridad;
import mx.estrategas.seguridad.util.SeguridadUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/index")
public class IndexController {
	@Autowired
	private AfiliadoServicio afiliadoServicio;
	@Autowired
	private CertificadoAfiliadoServicio certificadoAfiliadoServicio;
	
	public final String ROLE_ADMINISTRADOR="ROLE_ADMINISTRADOR";
	public final String ROLE_USUARIO="ROLE_USUARIO";
	public final String ROLE_CAPTURISTA="ROLE_CAPTURISTA";

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);
    
    
    /**
     * Devuelve el index de la aplicación.
     * 
     * @return ModelAndView que corresponde a la vista principal de la aplicación.
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView mostrarIndex(HttpServletRequest request){	    	    
    	UsuarioSeguridad usuario = SeguridadUtil.getUsuarioActual();    	
    	String rol="";
    	System.out.println("<OTIKA>RFCenLogin:"+usuario.getNombre());
    	System.out.println("<OTIKA>Login!"+((SecurityContextImpl)request.getSession().getAttribute("SPRING_SECURITY_CONTEXT")).getAuthentication().getPrincipal().toString());    	
    	if ( ((SecurityContextImpl)request.getSession().getAttribute("SPRING_SECURITY_CONTEXT")).getAuthentication().getAuthorities().size()>0){
    		Iterator it = ((SecurityContextImpl)request.getSession().getAttribute("SPRING_SECURITY_CONTEXT")).getAuthentication().getAuthorities().iterator();
    		while (it.hasNext()){
    			rol=it.next().toString();
    			request.getSession().setAttribute("rolUser",rol);
    			break;
    		}    		
    	}     	
    	if ( rol.equals(ROLE_ADMINISTRADOR)) {    		
    		return new ModelAndView("menu/menu_adm/index", "usuario", usuario);    		
    	}
    	if ( rol.equals(ROLE_CAPTURISTA)) {
    		return new ModelAndView("menu/menu_cap/index", "usuario", usuario);
    	}
    	if ( rol.equals(ROLE_USUARIO)) {
        	int idAfiliado=this.afiliadoServicio.getIdAfiliadoByRfc(usuario.getNombre());
        	System.out.println("<OTIKA>Login,IDAfiliado:"+idAfiliado);
        	boolean esInversionista=false;
        	int idCertificadoAfiliado=0;
        	esInversionista=this.afiliadoServicio.obtenerAfiliadoById(idAfiliado).getInversionista();
        	System.out.println(""+this.afiliadoServicio.obtenerAfiliadoById(idAfiliado).getInversionista());
        	if (!esInversionista){
        		idCertificadoAfiliado = this.certificadoAfiliadoServicio.obtenerCertificadoAfiliadoById(idAfiliado).getIdCertificadoAfiliado();
        		request.getSession().setAttribute("inversionista",false);
        	}        	        	
        	else
        		request.getSession().setAttribute("inversionista",true);
        	System.out.println("<OTIKA>Login,CertificadoAfiliado:"+idCertificadoAfiliado);
        	request.getSession().setAttribute("idAfiliado",idAfiliado);    		
        	request.getSession().setAttribute("idCertificadoAfiliado",idCertificadoAfiliado);
        	request.getSession().setAttribute("usuarioAfiliado",usuario.getNombre());
       
    		return new ModelAndView("menu/menu_usr/index", "usuario", usuario);
    	}    	    	    	   
    	return new ModelAndView("contenido/index", "usuario", usuario);
    }
	
}
