package mx.nomina.gday.modelo;

public class Accionista extends BaseModelo{
	
	private Integer idAccionista;
	private String nombreAccionista;
	
	public Accionista(){
		
	}
	
	public Accionista(Integer idAccionista, String nombreAccionista) {
		super();
		this.idAccionista = idAccionista;
		this.nombreAccionista = nombreAccionista;
	}

	public Integer getIdAccionista() {
		return idAccionista;
	}

	public void setIdAccionista(Integer idAccionista) {
		this.idAccionista = idAccionista;
	}

	public String getNombreAccionista() {
		return nombreAccionista;
	}

	public void setNombreAccionista(String nombreAccionista) {
		this.nombreAccionista = nombreAccionista;
	}	

}
