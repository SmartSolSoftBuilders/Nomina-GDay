package mx.nomina.gday.modelo;

public class DomVirtual extends BaseModelo{

	private Integer idDomVirtual;
	private String domVirtual;
	
	public DomVirtual(){
		
	}
	
	public DomVirtual(Integer idDomVirtual, String domVirtual) {
		super();
		this.idDomVirtual = idDomVirtual;
		this.domVirtual = domVirtual;
	}

	public Integer getIdDomVirtual() {
		return idDomVirtual;
	}

	public void setIdDomVirtual(Integer idDomVirtual) {
		this.idDomVirtual = idDomVirtual;
	}

	public String getDomVirtual() {
		return domVirtual;
	}

	public void setDomVirtual(String domVirtual) {
		this.domVirtual = domVirtual;
	}
	
	
}
