package mx.estrategas.fam.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import mx.estrategas.fam.modelo.Afiliado;
import mx.estrategas.fam.modelo.Escuela;
import mx.estrategas.fam.modelo.Municipio;
import mx.estrategas.fam.modelo.TipoEscuela;
import mx.estrategas.fam.servicios.EscuelaServicio;
import mx.estrategas.fam.servicios.MunicipioServicio;
import mx.estrategas.seguridad.modelo.UsuarioSeguridad;
import mx.estrategas.seguridad.servicios.MttoSeguridadServicio;
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
 * @author SmartSolutions
 */

@Controller
@RequestMapping("/catalogos")
public class CatalogosController {	
	
	@Autowired
	private MunicipioServicio municipioServicio;
	@Autowired
	private EscuelaServicio escuelaServicio;	
	@Autowired
	private MttoSeguridadServicio mttoSeguridadServicio;
	
	private static final Logger log = LoggerFactory.getLogger(CatalogosController.class);
    
    /**
     * Devuelve el index de la aplicación.
     * 
     * @return ModelAndView que corresponde a la vista principal de la aplicación.
     */
	
    
    @RequestMapping(value="/municipios",method = RequestMethod.POST)
    @ResponseBody
    public List<Municipio> obtenerMunicipios(){    	
		return this.municipioServicio.obtenerMunicipios();
	}
    
    @RequestMapping(value="/usuarios",method = RequestMethod.POST)
    @ResponseBody
    public List<UsuarioSeguridad> obtenerUsuarios(){    	
		return this.mttoSeguridadServicio.consultarUsuarios();
	}
    
    @RequestMapping(value="/buscarusuario",method = RequestMethod.POST)
    @ResponseBody
    public List<UsuarioSeguridad> obtenerUsuarioById(@ModelAttribute(value="usuarioSeguridad") UsuarioSeguridad usuarioSeguridad, BindingResult result){
    	System.out.println("<OTIKA>Find user:" + usuarioSeguridad.getUsername());
    	List<UsuarioSeguridad> usuario = new ArrayList<UsuarioSeguridad>();    	
    	try{
    		usuario = this.mttoSeguridadServicio.consultarUsuariosByUser(usuarioSeguridad);    	
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	if (usuario!= null)
    		System.out.println("<OTIKA>FOUND?" + usuario.size());
    	return usuario;
	}
    
    @RequestMapping(value="/actualizarusuario",method = RequestMethod.POST)
    @ResponseBody
    public boolean actualizarUsuario(@ModelAttribute(value="usuarioSeguridad") UsuarioSeguridad usuarioSeguridad, BindingResult result,HttpServletRequest request){
    	System.out.println("<OTIKA>Update user:" + usuarioSeguridad.getUsername());
    	System.out.println("<OTIKA>Update user:" + usuarioSeguridad.getPassword());
    	System.out.println("<OTIKA>Update Activo? user:" + usuarioSeguridad.getNombre());
    	if (usuarioSeguridad.getNombre().equals("ACTIVO"))
    		usuarioSeguridad.setActivo(true);
    	else
    		usuarioSeguridad.setActivo(false);
    	try{
    		this.mttoSeguridadServicio.actualizarUsuario(usuarioSeguridad);    
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    		return false;
    	}
    	return true;
	}
    
    @RequestMapping(value="/cambiacont",method = RequestMethod.POST)
    @ResponseBody
    public boolean cambiarContrase�a(@ModelAttribute(value="usuarioSeguridad") UsuarioSeguridad usuarioSeguridad, BindingResult result,HttpServletRequest request){
    	System.out.println("<OTIKA>Find user:" + usuarioSeguridad.getUsername());
    	System.out.println("<OTIKA>Find user:" + usuarioSeguridad.getPassword());
    	System.out.println("<OTIKA>Find user:" + usuarioSeguridad.getNombre());
    	UsuarioSeguridad usuarioActual = SeguridadUtil.getUsuarioActual();
    	System.out.println("<OTIKA>User actual!:"+usuarioActual.getUsername());    	
    	List<UsuarioSeguridad> usuario = new ArrayList<UsuarioSeguridad>();
    	try{
    		usuario = this.mttoSeguridadServicio.consultarUsuariosByUser(usuarioActual);    	
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	if (usuario!= null){
    		System.out.println("<OTIKA>FOUND?" + usuario.size());
    		System.out.println("<OTIKA>FOUND?" + usuario.get(0).getPassword()+"->>>"+usuarioSeguridad.getUsername());
    		if (usuario.get(0).getPassword().equals(usuarioSeguridad.getUsername())){
    			usuario.get(0).setPassword(usuarioSeguridad.getPassword());
    			this.mttoSeguridadServicio.actualizarPassword(usuario.get(0));	
    		}
    		else{
    			System.out.println("<OTIKA>El pwd no coincide!");
    			return false;    			
    		}
    	}
    	else{
    		System.out.println("<OTIKA>NOTFOUND");
    	}
    	return true;
	}

    
    @RequestMapping(value="/guardarusuario",method = RequestMethod.POST)
    @ResponseBody
    public boolean guardarUsuario(@ModelAttribute(value="usuarioSeguridad") UsuarioSeguridad usuarioSeguridad, BindingResult result){
    	System.out.println("<OTIKA>Create user:" + usuarioSeguridad.getUsername());
    	usuarioSeguridad.setActivo(true);
    	this.mttoSeguridadServicio.agregarUsuarioSeguridad(usuarioSeguridad);
    	return true;
	}
    
    @RequestMapping(value="/escuelas",method = RequestMethod.POST)
    @ResponseBody
    public List<Escuela> obtenerEscuelas(){
    	System.out.println("<OTIKA>ObtenerEscuelas");
		try{
		List<Escuela> escuelas = this.escuelaServicio.obtenerEscuelas();
		System.out.println(escuelas.get(0).getNombreEscuela());
		System.out.println(escuelas.get(0).getTipoEscuela());
		return escuelas;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
    
    @RequestMapping(value="/actualizarescuela",method = RequestMethod.POST)
    @ResponseBody
    public boolean actualizarEscuela(@ModelAttribute(value="escuela") Escuela escuela, BindingResult result){
    	System.out.println("<OTIKA>Actualizar Escuela:"+escuela.getIdEscuela());
    	System.out.println("<OTIKA>Actualizar Municipio:"+escuela.getTipoEscuela());
    	try{this.escuelaServicio.actualizarEscuela(escuela);    	
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    	return true;
    }
    
    @RequestMapping(value="/guardarescuela",method = RequestMethod.POST)
    @ResponseBody
    public boolean guardarEscuela(@ModelAttribute(value="escuela") Escuela escuela, BindingResult result){    	
    	System.out.println("<OTIKA>Actualizar Escuela:"+escuela.getDireccionEscuela());
    	System.out.println("<OTIKA>Actualizar Municipio:"+escuela.getTipoEscuela());
    	try{this.escuelaServicio.guardarEscuela(escuela);    	
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    	return true;
    }
    
    @RequestMapping(value="/tipoescuelas",method = RequestMethod.POST)
    @ResponseBody
    public List<TipoEscuela> obtenerTipoEscuelas(){    	
		return this.escuelaServicio.obtenerTipoEscuelas();
	}
    
    @RequestMapping(value="/actualizarmunicipio",method = RequestMethod.POST)
    @ResponseBody
    public boolean actualizarMunicipio(@ModelAttribute(value="municipio") Municipio municipio, BindingResult result){
    	System.out.println("<OTIKA>Actualizar Municipio:"+municipio.getIdMunicipio());
    	System.out.println("<OTIKA>Actualizar Municipio:"+municipio.getNombreMunicipio());
    	this.municipioServicio.actualizarMunicipio(municipio);
    	return true;
    }
    
    @RequestMapping(value="/agregarmunicipio",method = RequestMethod.POST)
    @ResponseBody
    public boolean agregarMunicipio(@ModelAttribute(value="municipio") Municipio municipio, BindingResult result){
    	System.out.println("<OTIKA>Agregar Municipio:"+municipio.getIdMunicipio());
    	System.out.println("<OTIKA>Agregar Municipio:"+municipio.getNombreMunicipio());
    	this.municipioServicio.guardarMunicipio(municipio);
    	return true;
    }      
    
}
