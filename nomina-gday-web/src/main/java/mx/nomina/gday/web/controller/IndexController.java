package mx.nomina.gday.web.controller;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import mx.nomina.gday.seguridad.modelo.UsuarioSeguridad;
import mx.nomina.gday.seguridad.servicios.MttoSeguridadServicio;
import mx.nomina.gday.seguridad.util.SeguridadUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class IndexController {

	@Autowired
	private MttoSeguridadServicio mttoSeguridadServicio;

	public final String ROLE_ADMINISTRADOR="ROLE_ADMINISTRADOR";
	public final String ROLE_USUARIO="ROLE_USUARIO";
	public final String ROLE_USUARIO2="ROLE_USUARIO2";
		
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView mostrarMenuRol(HttpServletRequest request){	    	    
    	UsuarioSeguridad usuario = SeguridadUtil.getUsuarioActual();    	
    	String rol="";
    	System.out.println("<OTIKA>RFCenLogin:"+usuario.getNombre());
    	System.out.println("<OTIKA>Login!"+((SecurityContextImpl)request.getSession().getAttribute("SPRING_SECURITY_CONTEXT")).getAuthentication().getPrincipal().toString());    	
    	if ( ((SecurityContextImpl)request.getSession().getAttribute("SPRING_SECURITY_CONTEXT")).getAuthentication().getAuthorities().size()>0){
    		Iterator it = ((SecurityContextImpl)request.getSession().getAttribute("SPRING_SECURITY_CONTEXT")).getAuthentication().getAuthorities().iterator();
    		while (it.hasNext()){
    			rol=it.next().toString();
    			usuario=this.mttoSeguridadServicio.consultarUsuariosByUser(usuario).get(0);
    			System.out.println(usuario.getId());
    			request.getSession().setAttribute("idUserSeg",usuario.getId());
    			
    			request.getSession().setAttribute("rolUser",rol);
    			break;
    		}    		
    	}
    	return new ModelAndView("../views/index");    	
	}
}