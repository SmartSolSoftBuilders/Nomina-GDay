package mx.nomina.gday.modelo;

public class PoderNotarialLaboral extends BaseModelo{

	private Integer idPodNotLab;
	private String numeroPodNotLab;
	
	public PoderNotarialLaboral(){
		
	}
	
	public PoderNotarialLaboral(Integer idPodNotLab,
			String numeroPodNotLab) {
		super();
		this.idPodNotLab = idPodNotLab;
		this.numeroPodNotLab = numeroPodNotLab;
	}

	public Integer getIdPodNotLab() {
		return idPodNotLab;
	}

	public void setIdPodNotLab(Integer idPodNotLab) {
		this.idPodNotLab = idPodNotLab;
	}

	public String getNumeroPodNotLab() {
		return numeroPodNotLab;
	}

	public void setNumeroPodNotLab(String numeroPodNotLab) {
		this.numeroPodNotLab = numeroPodNotLab;
	}
	
}
