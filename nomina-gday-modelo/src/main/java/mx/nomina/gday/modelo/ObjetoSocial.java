package mx.nomina.gday.modelo;

public class ObjetoSocial {

	private int idObjetoSocial;
	private String objetoSocial;
	
	public ObjetoSocial(int idObjetoSocial, String objetoSocial) {
		super();
		this.idObjetoSocial = idObjetoSocial;
		this.objetoSocial = objetoSocial;
	}

	public int getIdObjetoSocial() {
		return idObjetoSocial;
	}

	public void setIdObjetoSocial(int idObjetoSocial) {
		this.idObjetoSocial = idObjetoSocial;
	}

	public String getObjetoSocial() {
		return objetoSocial;
	}

	public void setObjetoSocial(String objetoSocial) {
		this.objetoSocial = objetoSocial;
	}
	
	
	
}
