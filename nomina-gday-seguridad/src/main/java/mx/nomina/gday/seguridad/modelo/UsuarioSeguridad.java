package mx.nomina.gday.seguridad.modelo;

import java.util.ArrayList;
import java.util.List;

public class UsuarioSeguridad extends BaseModelo{
	
	private String username;
	private String password;
	private String nombre;
	private boolean activo;	
	private String rol;
	private List<RolSeguridad> roles = new ArrayList<RolSeguridad>();	
	
	public UsuarioSeguridad(){}
	
	public UsuarioSeguridad(String username, String password, String nombre, String rol,
			boolean activo) {
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.rol=rol;
		this.activo = activo;
	}	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public List<RolSeguridad> getRoles() {
		return roles;
	}
	public void setRoles(List<RolSeguridad> roles) {
		this.roles = roles;
	}
	public String getListaRoles() {
		StringBuilder sb = new StringBuilder();
		for(RolSeguridad rs: this.getRoles()){
			sb.append(rs.getRol()).append(",");
		}
		return sb.toString();
	}		
	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
