package mx.estrategas.fam.modelo;

import java.util.Date;

public class Escuela extends BaseModelo {
	private int idEscuela;
	private String nombreEscuela;
	private int nivelEscuela;
	private String direccionEscuela;
	private String coloniaEscuela;
	private String cpEscuela;
	private String municipioEscuela;
	private String ciudadEscuela;
	private String entidadEscuela;
	private String turnoEscuela;
	private TipoEscuela tipoEscuela;
	
	
	public String getTurnoEscuela() {
		return turnoEscuela;
	}
	public void setTurnoEscuela(String turnoEscuela) {
		this.turnoEscuela = turnoEscuela;
	}
	public TipoEscuela getTipoEscuela() {
		return tipoEscuela;
	}
	public void setTipoEscuela(TipoEscuela tipoEscuela) {
		this.tipoEscuela = tipoEscuela;
	}
	public int getIdEscuela() {
		return idEscuela;
	}
	public void setIdEscuela(int idEscuela) {
		this.idEscuela = idEscuela;
	}
	public String getNombreEscuela() {
		return nombreEscuela;
	}
	public void setNombreEscuela(String nombreEscuela) {
		this.nombreEscuela = nombreEscuela;
	}
	public int getNivelEscuela() {
		return nivelEscuela;
	}
	public void setNivelEscuela(int nivelEscuela) {
		this.nivelEscuela = nivelEscuela;
	}
	public String getDireccionEscuela() {
		return direccionEscuela;
	}
	public void setDireccionEscuela(String direccionEscuela) {
		this.direccionEscuela = direccionEscuela;
	}
	public String getColoniaEscuela() {
		return coloniaEscuela;
	}
	public void setColoniaEscuela(String coloniaEscuela) {
		this.coloniaEscuela = coloniaEscuela;
	}
	public String getCpEscuela() {
		return cpEscuela;
	}
	public void setCpEscuela(String cpEscuela) {
		this.cpEscuela = cpEscuela;
	}
	public String getMunicipioEscuela() {
		return municipioEscuela;
	}
	public void setMunicipioEscuela(String municipioEscuela) {
		this.municipioEscuela = municipioEscuela;
	}
	public String getCiudadEscuela() {
		return ciudadEscuela;
	}
	public void setCiudadEscuela(String ciudadEscuela) {
		this.ciudadEscuela = ciudadEscuela;
	}
	public String getEntidadEscuela() {
		return entidadEscuela;
	}
	public void setEntidadEscuela(String entidadEscuela) {
		this.entidadEscuela = entidadEscuela;
	}
	
	public Escuela(){
	
	}
	public Escuela(int idEscuela, String nombreEscuela,
			int nivelEscuela, String direccionEscuela, String coloniaEscuela,
			String cpEscuela, String municipioEscuela, String ciudadEscuela,
			String entidadEscuela, String turnoEscuela, TipoEscuela tipoEscuela) {
		super();
		this.idEscuela = idEscuela;
		this.nombreEscuela = nombreEscuela;
		this.nivelEscuela = nivelEscuela;
		this.direccionEscuela = direccionEscuela;
		this.coloniaEscuela = coloniaEscuela;
		this.cpEscuela = cpEscuela;
		this.municipioEscuela = municipioEscuela;
		this.ciudadEscuela = ciudadEscuela;
		this.entidadEscuela = entidadEscuela;
		this.turnoEscuela = turnoEscuela;
		this.tipoEscuela = tipoEscuela;
	}
	

	
}
