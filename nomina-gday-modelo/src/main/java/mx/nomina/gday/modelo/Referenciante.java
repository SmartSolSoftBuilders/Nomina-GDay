package mx.nomina.gday.modelo;

public class Referenciante extends BaseModelo {
	
	private int idReferenciante;	
	private String nombreReferenciante;
	
	public Referenciante (){
		
	}
	public Referenciante(int idReferenciante, String nombreReferenciante) {
		super();
		this.idReferenciante = idReferenciante;
		this.nombreReferenciante = nombreReferenciante;
	}

	public int getIdReferenciante() {
		return this.idReferenciante;
	}

	public void setIdReferenciante(int idReferenciante) {
		this.idReferenciante = idReferenciante;
	}

	public String getNombreReferenciante() {
		return this.nombreReferenciante;
	}

	public void setNombreReferenciante(String nombreReferenciante) {
		this.nombreReferenciante = nombreReferenciante;
	}
	
	
}
