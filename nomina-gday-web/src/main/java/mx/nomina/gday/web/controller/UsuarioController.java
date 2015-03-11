package mx.nomina.gday.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mx.nomina.gday.modelo.Ejecutivo;
import mx.nomina.gday.seguridad.modelo.UsuarioSeguridad;
import mx.nomina.gday.seguridad.servicios.MttoSeguridadServicio;
import mx.nomina.gday.seguridad.util.SeguridadUtil;
import mx.nomina.gday.servicios.EjecutivoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private MttoSeguridadServicio mttoSeguridadServicio;

	@Autowired
	private EjecutivoServicio ejecutivoServicio;
	
	//Controller que muestra la lista de Usuarios y permite la Edicion del mismo
		 @RequestMapping(value="/getusuarios",method = RequestMethod.POST)
		    @ResponseBody
		    public List obtenerUsuarios(){    	
			  System.out.println("Controller Usuario");
			  try {
				
				SeguridadUtil seguridadUtil = new SeguridadUtil();
				List<UsuarioSeguridad> tmpUsuarios = mttoSeguridadServicio.consultarUsuarios();
				String estatusTmp = "";
				
				System.out.println("tmp"+tmpUsuarios.size());
				List usuariosTmp = new ArrayList();
				List usuariosTmp2 = new ArrayList<String>();
				
				for (int i = 0; i < tmpUsuarios.size(); i++) {
					usuariosTmp2 = new ArrayList<String>();
					System.out.println("tmp"+tmpUsuarios.get(i));
					if(tmpUsuarios.get(i).isActivo() == true){
						estatusTmp = "ACTIVO";
					}else{
						estatusTmp = "BAJA";
					}
					usuariosTmp2.add(tmpUsuarios.get(i).getId());
					usuariosTmp2.add(tmpUsuarios.get(i).getUsername());
					usuariosTmp2.add(tmpUsuarios.get(i).getNombre());
					usuariosTmp2.add(estatusTmp);					
					usuariosTmp2.add("<a href='#' onclick='showEditarUsuario("+tmpUsuarios.get(i).getId()+")'>'<img src='../../static/img/editar.png' width='27' height='27'></img>'</a>");
					usuariosTmp.add(usuariosTmp2);
				}
				return usuariosTmp;

			} catch (Exception e) {
				e.printStackTrace();
			}
			  return null;
			}

		//Controller Guardar Usuario
		 @RequestMapping(value="/guardarusuario",method = RequestMethod.POST)
		 @ResponseBody
		    public boolean guardarUsuario(@ModelAttribute(value="usuario") UsuarioSeguridad usuarioSeguridad, BindingResult result){
			 	
			 	System.out.println("Guardando el Usuario"+ usuarioSeguridad.getRol());			 	
			 	mttoSeguridadServicio.agregarUsuarioSeguridad(usuarioSeguridad);			 	
			 	Ejecutivo ejecutivo = new Ejecutivo();
			 	System.out.println("Supuesto id generado:"+usuarioSeguridad.getId());
			 	System.out.println(usuarioSeguridad.getRol());
			 	 if(usuarioSeguridad.getRol().equals("1")){
					 ejecutivo.setIdUsuario(Integer.valueOf(String.valueOf(usuarioSeguridad.getId())));
					 ejecutivo.setMaternoEjecutivo(usuarioSeguridad.getApellidoM());
					 ejecutivo.setNombreEjecutivo(usuarioSeguridad.getNombre());
					 ejecutivo.setPaternoEjecutivo(usuarioSeguridad.getApellidoP());
					 System.out.println("Guardando el Ejecutivo"+ ejecutivo.getIdUsuario());
					 System.out.println("Guardando el Ejecutivo"+ usuarioSeguridad.getId());					 
					 ejecutivoServicio.agregarEjecutivo(ejecutivo);
			 	 }
			 return true;
			 
		 }
		 
		 //Controller que permite Actualizar los datos del Grupo a Editar
		 @RequestMapping(value="/modificarusuario",method = RequestMethod.POST)
		 @ResponseBody
		 public boolean modificarUsuario(@ModelAttribute(value="usuario") UsuarioSeguridad usuarioSeguridad, BindingResult result,HttpServletRequest request){    	    	    	    	   		   
			 System.out.println("Guardando el Usuario"+ usuarioSeguridad.getRol());			 
			 mttoSeguridadServicio.actualizarUsuarioConRol(usuarioSeguridad);			 	
			 Ejecutivo ejecutivo = new Ejecutivo();
			 System.out.println("Supuesto id generado:"+usuarioSeguridad.getId());
			 	 if(usuarioSeguridad.getRol().equals("ROL_EJECUTIVO_NOMINA")){
					 ejecutivo.setIdUsuario(Integer.valueOf(String.valueOf(usuarioSeguridad.getId())));
					 ejecutivo.setMaternoEjecutivo(usuarioSeguridad.getApellidoM());
					 ejecutivo.setNombreEjecutivo(usuarioSeguridad.getNombre());
					 ejecutivo.setPaternoEjecutivo(usuarioSeguridad.getApellidoP());
					 System.out.println("Guardando el Ejecutivo"+ usuarioSeguridad.getRol());
					 System.out.println("Guardando el Ejecutivo"+ usuarioSeguridad.getId());
					 try{
						 ejecutivoServicio.actualizarEjecutivo(ejecutivo);
						 return true;
					 }
					 catch(Exception e){
						 e.printStackTrace();
						 return false;
					 }
				 	 }			
			 	return true;
		 }
		
		//Controller que permite obtener el grupo por idGrupo
		 @RequestMapping(value="/obtenerusuarioconrolesbyid",method = RequestMethod.POST)
		    @ResponseBody
		    public UsuarioSeguridad obtenerUsuarioConRolesById(@ModelAttribute(value="usuario") UsuarioSeguridad usuarioSeguridad, BindingResult result){
			 try {
				 
				 System.out.println("Controller USUARIO APM"+ usuarioSeguridad.getApellidoM());
				 usuarioSeguridad= this.mttoSeguridadServicio.consultarUsuariosSeguridadConRol(usuarioSeguridad);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return usuarioSeguridad;
			 	
			}	
		 //LLENADO DEL SELECT COMBO, ROLES
		 @RequestMapping(value="/getdatoscombo",method = RequestMethod.POST)
		    @ResponseBody
		    public List obtenerDatosCombo(){
			 	System.out.println("Controller Datos del combo");
				return this.mttoSeguridadServicio.consultarRoles();
			}
		 
		 //Controller que permite obtener el ejecutivo por idEjecutivo
		 @RequestMapping(value="/obtenerejecutivobyid",method = RequestMethod.POST)
		    @ResponseBody
		    public Ejecutivo obtenerEjecutivoById(@ModelAttribute(value="ejecutivo") Ejecutivo ejecutivo, BindingResult result){    	
		    	System.out.println("Controller que obtiene el idEjecutivo"+ ejecutivo.getIdEjecutivo());
			 	return this.ejecutivoServicio.obtenerEjecutivoById(ejecutivo.getIdEjecutivo());
			 	
			}	 	
}
