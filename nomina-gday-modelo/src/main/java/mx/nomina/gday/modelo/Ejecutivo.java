package mx.nomina.gday.modelo;

public class Ejecutivo extends BaseModelo  {

	private Integer idEjecutivo;
	private Integer idUsuario;
	private String nombreEjecutivo;
	private String paternoEjecutivo;
	private String maternoEjecutivo;
	
	public Ejecutivo(){
		
	}

	public Ejecutivo(Integer idEjecutivo, Integer idUsuario,
			String nombreEjecutivo, String paternoEjecutivo,
			String maternoEjecutivo) {
		super();
		this.idEjecutivo = idEjecutivo;
		this.idUsuario = idUsuario;
		this.nombreEjecutivo = nombreEjecutivo;
		this.paternoEjecutivo = paternoEjecutivo;
		this.maternoEjecutivo = maternoEjecutivo;
	}

	public Integer getIdEjecutivo() {
		return idEjecutivo;
	}

	public void setIdEjecutivo(Integer idEjecutivo) {
		this.idEjecutivo = idEjecutivo;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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
