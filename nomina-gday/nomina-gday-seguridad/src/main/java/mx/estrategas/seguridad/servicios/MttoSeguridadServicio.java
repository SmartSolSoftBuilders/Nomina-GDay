package mx.estrategas.seguridad.servicios;

import java.util.List;

import mx.estrategas.seguridad.modelo.UsuarioSeguridad;

public interface MttoSeguridadServicio {

	List<UsuarioSeguridad> consultarUsuarios();	
	List<UsuarioSeguridad> consultarUsuariosConRoles();
	List<UsuarioSeguridad> consultarUsuariosByUser(UsuarioSeguridad usuario);
	UsuarioSeguridad consultarUsuarioConRoles(String username);
	void agregarUsuarioSeguridad(UsuarioSeguridad usuario);
	void actualizarPassword(UsuarioSeguridad usuario);
	void actualizarUsuario(UsuarioSeguridad usuarioSeguridad);
}
