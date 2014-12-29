package mx.nomina.gday.modelo;

public class Ejecutivo {

	private int idEjecutivo;
	private String nombreEjecutivo;
	private String paternoEjecutivo;
	private String maternoEjecutivo;
	
	public Ejecutivo(){
		
	}

	public Ejecutivo(int idEjecutivo, String nombreEjecutivo,
			String paternoEjecutivo, String maternoEjecutivo) {
		super();
		this.idEjecutivo = idEjecutivo;
		this.nombreEjecutivo = nombreEjecutivo;
		this.paternoEjecutivo = paternoEjecutivo;
		this.maternoEjecutivo = maternoEjecutivo;
	}
	
	public int getIdEjecutivo() {
		return idEjecutivo;
	}
	public void setIdEjecutivo(int idEjecutivo) {
		this.idEjecutivo = idEjecutivo;
	}
	public String getNombreEjecutivo() {
		return nombreEjecutivo;
	}
	public void setNombreEjecutivo(String nombreEjecutivo) {
		this.nombreEjecutivo = nombreEjecutivo;
	}
	public String getPaternoEjecutivo() {
		return paternoEjecutivo;
	}
	public void setPaternoEjecutivo(String paternoEjecutivo) {
		this.paternoEjecutivo = paternoEjecutivo;
	}
	public String getMaternoEjecutivo() {
		return maternoEjecutivo;
	}
	public void setMaternoEjecutivo(String maternoEjecutivo) {
		this.maternoEjecutivo = maternoEjecutivo;
	}
}
