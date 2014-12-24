package mx.estrategas.fam.modelo;

public class Municipio extends BaseModelo {
	
	private Integer idMunicipio;
	private String nombreMunicipio;
	public Integer getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	public String getNombreMunicipio() {
		return nombreMunicipio;
	}
	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}
	
	public Municipio(Integer idMunicipio, String nombreMunicipio) {
		super();
		this.idMunicipio = idMunicipio;
		this.nombreMunicipio = nombreMunicipio;
	}
	
	public Municipio(){
		
	}
	

}
