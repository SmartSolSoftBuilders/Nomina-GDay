package mx.nomina.gday.seguridad.servicios;

import java.util.List;

import mx.nomina.gday.seguridad.modelo.UsuarioSeguridad;

public interface MttoSeguridadServicio {

	List<UsuarioSeguridad> consultarUsuarios();	
	List<UsuarioSeguridad> consultarUsuariosConRoles();
	List<UsuarioSeguridad> consultarUsuariosByUser(UsuarioSeguridad usuario);
	UsuarioSeguridad consultarUsuarioConRoles(String username);
	UsuarioSeguridad consultarUsuariosSeguridadConRol(UsuarioSeguridad usuarioSeguridad);
	void agregarUsuarioSeguridad(UsuarioSeguridad usuario);
	void actualizarPassword(UsuarioSeguridad usuario);
	void actualizarUsuario(UsuarioSeguridad usuarioSeguridad);
	void actualizarUsuarioConRol(UsuarioSeguridad usuarioSeguridad);
	public List<UsuarioSeguridad> consultarRoles();
	public UsuarioSeguridad consultarUsuariosById(int idUsuario);


}

