package mx.nomina.gday.seguridad.modelo;

import java.util.ArrayList;
import java.util.List;

public class UsuarioSeguridad extends BaseModelo{
	
	private String username;
	private String password;
	private String nombre;
	private String apellidoP;
	private String apellidoM;
	private boolean activo;	
	private String rol;
	private List<RolSeguridad> roles = new ArrayList<RolSeguridad>();	
	
	public UsuarioSeguridad(){}

	public UsuarioSeguridad(String username, String password, String nombre,
			String apellidoP, String apellidoM, boolean activo, String rol) {
		super();
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.activo = activo;
		this.rol = rol;
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

	public String getApellidoP() {
		return apellidoP;
	}

	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}

	public String getApellidoM() {
		return apellidoM;
	}

	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<RolSeguridad> getRoles() {
		return roles;
	}

	public void setRoles(List<RolSeguridad> roles) {
		this.roles = roles;
	}
	
	
}
