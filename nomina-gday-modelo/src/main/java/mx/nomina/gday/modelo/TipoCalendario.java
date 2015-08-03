package mx.nomina.gday.modelo;

public class TipoCalendario extends BaseModelo{

	private int idCalendario;
	private String tipoCalendario;
	private String siglas;
	private String pr;
	
	public TipoCalendario(){
		
	}
	
	public TipoCalendario(int idCalendario, String tipoCalendario,
			String siglas, String pr) {
		super();
		this.idCalendario = idCalendario;
		this.tipoCalendario = tipoCalendario;
		this.siglas = siglas;
		this.pr = pr;
	}

	public int getIdCalendario() {
		return idCalendario;
	}

	public void setIdCalendario(int idCalendario) {
		this.idCalendario = idCalendario;
	}
	public String getTipoCalendario() {
		return tipoCalendario;
	}
	public void setTipoCalendario(String tipoCalendario) {
		this.tipoCalendario = tipoCalendario;
	}
	public String getSiglas() {
		return siglas;
	}
	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}
	public String getPr() {
		return pr;
	}
	public void setPr(String pr) {
		this.pr = pr;
	}
}
