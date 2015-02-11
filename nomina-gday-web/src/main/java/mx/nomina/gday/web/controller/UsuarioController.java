package mx.nomina.gday.web.controller;

import java.util.ArrayList;
import java.util.List;

import mx.nomina.gday.seguridad.modelo.UsuarioSeguridad;
import mx.nomina.gday.seguridad.servicios.MttoSeguridadServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private MttoSeguridadServicio mttoSeguridadServicio;

	//Controller que muestra la lista de Grupos y permite la seleccion del mismo
		 @RequestMapping(value="/getusuarios",method = RequestMethod.POST)
		    @ResponseBody
		    public List obtenerUsuarios(){    	
			  System.out.println("Controller Usuario");
			  try {
				List<UsuarioSeguridad> tmpUsuario =  this.mttoSeguridadServicio.consultarUsuarios();
				System.out.println("tmp"+tmpUsuario.size());
				List usuariosTmp = new ArrayList();
				List usuariosTmp2 = new ArrayList<String>();

				for (int i = 0; i < tmpUsuario.size(); i++) {
					usuariosTmp2 = new ArrayList<String>();
					System.out.println("tmp"+tmpUsuario.get(i));
					usuariosTmp2.add(tmpUsuario.get(i).getNombre());
					usuariosTmp2.add(tmpUsuario.get(i).getUsername());
					usuariosTmp2.add("<a href='#' onclick='showEditarUsuario("+tmpUsuario.get(i).getId()+")'>'<img src='../../static/img/editar.png' width='27' height='27'></img>'</a>");
					usuariosTmp.add(usuariosTmp2);
				}
				return usuariosTmp;

			} catch (Exception e) {
				e.printStackTrace();
			}
			  return null;
			}

}
