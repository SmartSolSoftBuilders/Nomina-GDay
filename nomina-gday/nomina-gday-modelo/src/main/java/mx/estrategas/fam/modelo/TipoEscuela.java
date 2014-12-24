package mx.estrategas.fam.modelo;

import java.util.Date;

public class TipoEscuela extends BaseModelo {
	private int idTipoEscuela;
	private String descripcionTipoEscuela;
	public int getIdTipoEscuela() {
		return idTipoEscuela;
	}
	public void setIdTipoEscuela(int idTipoEscuela) {
		this.idTipoEscuela = idTipoEscuela;
	}
	public String getDescripcionTipoEscuela() {
		return descripcionTipoEscuela;
	}
	public void setDescripcionTipoEscuela(String descripcionTipoEscuela) {
		this.descripcionTipoEscuela = descripcionTipoEscuela;
	}
	
	public TipoEscuela(){
		
	}
	
	public TipoEscuela(int idTipoEscuela, String descripcionTipoEscuela) {
		super();
		this.idTipoEscuela = idTipoEscuela;
		this.descripcionTipoEscuela = descripcionTipoEscuela;
	}
			
}
