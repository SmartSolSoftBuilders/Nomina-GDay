package mx.nomina.gday.modelo;

public class PoderNotarialLaboral extends BaseModelo{
	
	private Integer idPodNotLab; 
	private Integer numero;
	private String notaria;
	private String notario;
	
	public PoderNotarialLaboral(){
		
	}

	public Integer getIdPodNotLab() {
		return idPodNotLab;
	}

	public void setIdPodNotLab(Integer idPodNotLab) {
		this.idPodNotLab = idPodNotLab;
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

	public PoderNotarialLaboral(Integer idPodNotLab, Integer numero,
			String notaria, String notario) {
		super();
		this.idPodNotLab = idPodNotLab;
		this.numero = numero;
		this.notaria = notaria;
		this.notario = notario;
	}	
	
}
