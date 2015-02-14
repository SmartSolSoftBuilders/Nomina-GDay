package mx.nomina.gday.seguridad.dao;

import java.util.List;

import mx.nomina.gday.seguridad.modelo.RolSeguridad;
import mx.nomina.gday.seguridad.modelo.UsuarioSeguridad;

/**
 * Servicios de acceso a datos para roles y usuario de seguridad.
 * 
 * @author SmartSolutions
 *
 */
public interface SeguridadDao {

	List<UsuarioSeguridad> consultarUsuarios();
	
	List<RolSeguridad> consultarRoles();
	
	UsuarioSeguridad consultarUsuarioConRoles(String username);

	UsuarioSeguridad consultarUsuariosConRolesById(UsuarioSeguridad usuarioSeguridad);

	UsuarioSeguridad consultarUsuariosSeguridadConRol(UsuarioSeguridad usuarioSeguridad);
	
	List<UsuarioSeguridad> consultarUsuariosConRoles();
	
	void agregarUsuarioSeguridad(UsuarioSeguridad usuario);

	List<UsuarioSeguridad> consultarUsuariosByUser(UsuarioSeguridad usuario);

	void actualizarPassword(UsuarioSeguridad usuario);

	void actualizarUsuario(UsuarioSeguridad usuarioSeguridad);

	void actualizarUsuarioConRol(UsuarioSeguridad usuarioSeguridad);
	
	public UsuarioSeguridad consultarUsuariosById(int id);

}
