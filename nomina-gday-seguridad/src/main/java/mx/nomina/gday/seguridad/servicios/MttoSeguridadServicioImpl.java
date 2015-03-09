package mx.nomina.gday.seguridad.servicios;

import java.util.ArrayList;
import java.util.List;

import mx.nomina.gday.seguridad.dao.SeguridadDao;
import mx.nomina.gday.seguridad.modelo.UsuarioSeguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MttoSeguridadServicioImpl implements MttoSeguridadServicio{

	@Autowired
	private SeguridadDao seguridadDao;
	
	public List<UsuarioSeguridad> consultarUsuarios() {
		return seguridadDao.consultarUsuarios();
	}

	public List<UsuarioSeguridad> consultarUsuariosConRoles() {
		return seguridadDao.consultarUsuariosConRoles();
	}
	
	@Override
	public UsuarioSeguridad consultarUsuarioConRoles(String username){
		return seguridadDao.consultarUsuarioConRoles(username);
	}

	@Override
	public void agregarUsuarioSeguridad(UsuarioSeguridad usuario) {
		// TODO Auto-generated method stub
		seguridadDao.agregarUsuarioSeguridad(usuario);
		
	}

	@Override
	public List<UsuarioSeguridad> consultarUsuariosByUser(
			UsuarioSeguridad usuario) {
		// TODO Auto-generated method stub
		return seguridadDao.consultarUsuariosByUser(usuario);
	}

	@Override
	public void actualizarPassword(UsuarioSeguridad usuario) {
		// TODO Auto-generated method stub
		this.seguridadDao.actualizarPassword(usuario);
	}

	@Override
	public void actualizarUsuario(UsuarioSeguridad usuarioSeguridad) {
		// TODO Auto-generated method stub
		this.seguridadDao.actualizarUsuario(usuarioSeguridad);		
	}

	@Override
	public List<UsuarioSeguridad> consultarRoles() {
		System.out.println("Datos del Combo Servicio");
		List datosCombo = new ArrayList();
		try{
			datosCombo.add(this.seguridadDao.consultarRoles());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return datosCombo;
	}

	@Override
	public void actualizarUsuarioConRol(UsuarioSeguridad usuarioSeguridad) {
		// TODO Auto-generated method stub
		System.out.println("ROL USUARIO SERVICIO"+ usuarioSeguridad.getRol());
		this.seguridadDao.actualizarUsuarioConRol(usuarioSeguridad);
		
	}

	@Override
	public UsuarioSeguridad consultarUsuariosSeguridadConRol(UsuarioSeguridad usuarioSeguridad) {
		// TODO Auto-generated method stub
		try {
			System.out.println("USUARIO CON ROLES SERVICIO id"+usuarioSeguridad.getId());
			usuarioSeguridad=this.seguridadDao.consultarUsuariosSeguridadConRol(usuarioSeguridad);
			System.out.println("USUARIO CON ROLES SERVICIO USERNAME"+usuarioSeguridad.getNombre());
			System.out.println("USUARIO CON ROLES SERVICIO APP"+usuarioSeguridad.getApellidoP());
			System.out.println("USUARIO CON ROLES SERVICIO APM"+usuarioSeguridad.getApellidoM());
			System.out.println("USUARIO CON ROLES SERVICIO USERNAME"+usuarioSeguridad.getPassword());
			System.out.println("USUARIO CON ROLES SERVICIO USERNAME"+usuarioSeguridad.getRol());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return usuarioSeguridad;
		
	}

	@Override
	public UsuarioSeguridad consultarUsuariosById(int idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}


	//Para agregar al git de nuevo

	
}
