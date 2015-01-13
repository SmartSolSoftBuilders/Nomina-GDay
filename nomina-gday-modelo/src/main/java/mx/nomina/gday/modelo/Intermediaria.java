package mx.nomina.gday.modelo;

public class Intermediaria extends BaseModelo{
	
	private Integer idIntermediria;
	private String nombreIntermediaria;
	
	public Intermediaria()  {
	
	}
	
	public Intermediaria(Integer idIntermediria, String nombreIntermediaria) {
		this.idIntermediria = idIntermediria;
		this.nombreIntermediaria = nombreIntermediaria;
	}

	public Integer getIdIntermediria() {
		return idIntermediria;
	}

	public void setIdIntermediria(Integer idIntermediria) {
		this.idIntermediria = idIntermediria;
	}

	public String getNombreIntermediaria() {
		return nombreIntermediaria;
	}

	public void setNombreIntermediaria(String nombreIntermediaria) {
		this.nombreIntermediaria = nombreIntermediaria;
	}
	
	
	
}
