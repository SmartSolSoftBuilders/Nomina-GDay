package mx.nomina.gday.modelo;

public class Esquema extends BaseModelo{
	
	private int idEsquema;
	private String nombreEsquema;
	
	public Esquema(){
	}
	
	public Esquema(int idEsquema, String nombreEsquema) {
		super();
		this.idEsquema = idEsquema;
		this.nombreEsquema = nombreEsquema;
	}
	
	public int getIdEsquema() {
		return idEsquema;
	}
	public void setIdEsquema(int idEsquema) {
		this.idEsquema = idEsquema;
	}
	public String getNombreEsquema() {
		return nombreEsquema;
	}
	public void setNombreEsquema(String nombreEsquema) {
		this.nombreEsquema = nombreEsquema;
	}

}
