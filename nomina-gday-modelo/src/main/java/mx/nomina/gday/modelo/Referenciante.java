package mx.nomina.gday.modelo;

public class Referenciante {
	
	private int idReferenciante;
	private String referenciante;
	
	public Referenciante(int idReferenciante, String referenciante) {
		super();
		this.idReferenciante = idReferenciante;
		this.referenciante = referenciante;
	}

	public int getIdReferenciante() {
		return idReferenciante;
	}

	public void setIdReferenciante(int idReferenciante) {
		this.idReferenciante = idReferenciante;
	}

	public String getReferenciante() {
		return referenciante;
	}

	public void setReferenciante(String referenciante) {
		this.referenciante = referenciante;
	}
	
	
}
