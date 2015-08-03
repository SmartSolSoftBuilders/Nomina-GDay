package mx.nomina.gday.modelo;

public class PoderNotarialPleitoCobranza extends BaseModelo {
	
	private Integer idPodNotLabPleiCob; 
	private Integer numero;
	private String notaria;
	private String notario;
	
	public PoderNotarialPleitoCobranza(){
		
	}

	public Integer getIdPodNotLabPleiCob() {
		return idPodNotLabPleiCob;
	}

	public void setIdPodNotLabPleiCob(Integer idPodNotLabPleiCob) {
		this.idPodNotLabPleiCob = idPodNotLabPleiCob;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNotaria() {
		return notaria;
	}

	public void setNotaria(String notaria) {
		this.notaria = notaria;
	}

	public String getNotario() {
		return notario;
	}

	public void setNotario(String notario) {
		this.notario = notario;
	}

	public PoderNotarialPleitoCobranza(Integer idPodNotLabPleiCob,
			Integer numero, String notaria, String notario) {
		super();
		this.idPodNotLabPleiCob = idPodNotLabPleiCob;
		this.numero = numero;
		this.notaria = notaria;
		this.notario = notario;
	}

		
}
