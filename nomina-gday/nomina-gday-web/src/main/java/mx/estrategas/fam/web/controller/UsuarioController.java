package mx.estrategas.fam.web.controller;

import java.util.List;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.estrategas.fam.web.util.ControllerBase;
//import mx.sep.sajja.datos.vo.FiltroBusquedaVO;
import mx.estrategas.fam.modelo.Usuario;
import mx.estrategas.fam.servicios.UsuarioServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller de ejemplo para dar mantenimiento a la entidad de modelo Usuario.
 * 
 * @author Alejandro Pimentel
 *
 */
@Controller
@RequestMapping(value = "/usuarios") 
public class UsuarioController{   
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@RequestMapping(value = "/guardar", method=RequestMethod.POST)
	@ResponseBody
	public Long guardarFormulario(@ModelAttribute("formulario") Usuario usuario) {
		//usuarioServicio.guardarFormulario(usuario);
		
		return usuario.getId();
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	@ResponseBody
	public void test() {
		//usuarioServicio.guardarFormulario(usuario);
		
		System.out.println("<OTIKA>Login!!");
	}
	
	@RequestMapping(value = "/guardar/json", method=RequestMethod.POST)
	@ResponseBody
	public Long guardarFormularioJson(@RequestBody Usuario usuario) {
		//usuarioServicio.guardarFormulario(usuario);
		
		return usuario.getId();
	}
	
	@RequestMapping(value = "/listar", method=RequestMethod.GET)
	@ResponseBody	
	public List<Usuario> buscar(){
		//return usuarioServicio.buscar();
		return null;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody	
	public List<Usuario> buscarEnModoRest(@RequestHeader("Range") String rango
										, HttpServletResponse response, HttpServletRequest request){

		//Integer total = usuarioServicio.contar();
		//FiltroBusquedaVO filtroBusquedaVO = this.manejarRestPaging(rango, total, request, response);
		
		//return usuarioServicio.buscar(filtroBusquedaVO);
		return null;
	}
}

