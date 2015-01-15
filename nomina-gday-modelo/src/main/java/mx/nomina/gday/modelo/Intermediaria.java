package mx.nomina.gday.modelo;

public class Intermediaria extends BaseModelo{
	
	private Integer idIntermediaria;
	private String nombreIntermediaria;
	
	public Intermediaria()  {
	
	}

	public Intermediaria(Integer idIntermediaria, String nombreIntermediaria) {
		super();
		this.idIntermediaria = idIntermediaria;
		this.nombreIntermediaria = nombreIntermediaria;
	}

	public Integer getIdIntermediaria() {
		return idIntermediaria;
	}

	public void setIdIntermediaria(Integer idIntermediaria) {
		this.idIntermediaria = idIntermediaria;
	}

	public String getNombreIntermediaria() {
		return nombreIntermediaria;
	}

	public void setNombreIntermediaria(String nombreIntermediaria) {
		this.nombreIntermediaria = nombreIntermediaria;
	}
		
}
