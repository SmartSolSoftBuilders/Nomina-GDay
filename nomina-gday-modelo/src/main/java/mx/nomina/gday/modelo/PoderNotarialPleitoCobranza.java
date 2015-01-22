package mx.nomina.gday.modelo;

public class PoderNotarialPleitoCobranza extends BaseModelo {
	
	private Integer idPodNotPleitosCob;
	private Integer numeroPodNotPleitosCob;
	private Integer notariaPodNotPleitosCob;
	private Integer notarioPodNotPleitosCob;
	
	public PoderNotarialPleitoCobranza(){
		
	}
	
	public PoderNotarialPleitoCobranza(Integer idPodNotPleitosCob,
			Integer numeroPodNotPleitosCob, Integer notariaPodNotPleitosCob,
			Integer notarioPodNotPleitosCob) {
		super();
		this.idPodNotPleitosCob = idPodNotPleitosCob;
		this.numeroPodNotPleitosCob = numeroPodNotPleitosCob;
		this.notariaPodNotPleitosCob = notariaPodNotPleitosCob;
		this.notarioPodNotPleitosCob = notarioPodNotPleitosCob;
	}

	public Integer getIdPodNotPleitosCob() {
		return idPodNotPleitosCob;
	}

	public void setIdPodNotPleitosCob(Integer idPodNotPleitosCob) {
		this.idPodNotPleitosCob = idPodNotPleitosCob;
	}

	public Integer getNumeroPodNotPleitosCob() {
		return numeroPodNotPleitosCob;
	}

	public void setNumeroPodNotPleitosCob(Integer numeroPodNotPleitosCob) {
		this.numeroPodNotPleitosCob = numeroPodNotPleitosCob;
	}

	public Integer getNotariaPodNotPleitosCob() {
		return notariaPodNotPleitosCob;
	}

	public void setNotariaPodNotPleitosCob(Integer notariaPodNotPleitosCob) {
		this.notariaPodNotPleitosCob = notariaPodNotPleitosCob;
	}

	public Integer getNotarioPodNotPleitosCob() {
		return notarioPodNotPleitosCob;
	}

	public void setNotarioPodNotPleitosCob(Integer notarioPodNotPleitosCob) {
		this.notarioPodNotPleitosCob = notarioPodNotPleitosCob;
	}
	
}
