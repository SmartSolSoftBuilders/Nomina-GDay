package mx.nomina.gday.seguridad.util;

import java.util.ArrayList;
import java.util.List;

import mx.nomina.gday.seguridad.modelo.UsuarioSeguridad;
import mx.nomina.gday.seguridad.servicios.CustomUserDetails;
import mx.nomina.gday.seguridad.servicios.MenuSeguridadServicio;
import mx.nomina.gday.seguridad.servicios.MttoSeguridadServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Métodos de utilería para interactuar con el módulo de seguridad.
 * 
 * @author SmartSolutions
 *
 */
public class SeguridadUtil {
	
	public SeguridadUtil(){
		
	}
	
	@Autowired
	MttoSeguridadServicio mttoSeguridad;
	MenuSeguridadServicio mttoMenuSeguridad;
	
	public UsuarioSeguridad obtenerRoles(String username){
		
		return this.mttoSeguridad.consultarUsuarioConRoles(username);	
	}
	

	/**
	 * Trata de obtener la información del usuario autenticado para el hilo
	 * de ejecución actual.
	 * 
	 * Si no le es posible obtenerlo lanza un {@link RuntimeException}
	 * 
	 * @return Un objeto tipo {@link UsuarioSeguridad}
	 */
	public void agregarUsuarioSeguridad(UsuarioSeguridad usuario){
		this.mttoSeguridad.agregarUsuarioSeguridad(usuario);
	}
    public static UsuarioSeguridad getUsuarioActual() {
        if(SecurityContextHolder.getContext().
                getAuthentication() == null
           || !SecurityContextHolder.getContext().
                getAuthentication().
                getPrincipal().
                getClass().
                equals(CustomUserDetails.class)) {
            throw new RuntimeException("La sesión actual no ha sido autenticada", null);
        }

        CustomUserDetails cud = (CustomUserDetails) SecurityContextHolder.getContext().
                getAuthentication().
                getPrincipal();
        
        UsuarioSeguridad us = new UsuarioSeguridad(cud.getUsername(), "", cud.getNombre(), "", "", cud.isEnabled(), "");
        
        return us;
    }
    
    //Metodo que regresa una lista de usuarios
    public  List<UsuarioSeguridad> obtenerUsuariosSeguridad(){
		try {
			 
				List<UsuarioSeguridad> tmp=this.mttoSeguridad.consultarUsuarios();
				System.out.println("Lista de Usuarios"+tmp.size());
					return tmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }

    //Metodo que guarda usuarios
    public void guardarUsuario(UsuarioSeguridad usuarioSeguridad){
    	
    	this.mttoSeguridad.agregarUsuarioSeguridad(usuarioSeguridad);
    }

   	
	public List obtenerDatosCombo(){
		
		System.out.println("Datos del Combo Servicio");
		List datosCombo = new ArrayList();
		try{
			datosCombo.add(this.mttoSeguridad.consultarRoles());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return datosCombo;
	}
	
	//Metodo para obtener el usuario por id
	
	public UsuarioSeguridad obtenerUsuarioById(int idUsuario){
		
		return this.mttoSeguridad.consultarUsuariosById(idUsuario);
	}
	
	 //Metodo que modifica usuarios
	public UsuarioSeguridad obtenerUsuariosSeguridadConRol(UsuarioSeguridad usuarioSeguridad){
			
		return this.mttoSeguridad.consultarUsuariosSeguridadConRol(usuarioSeguridad);
		}
	
	//Para agregar al git de nuevo\\

}

