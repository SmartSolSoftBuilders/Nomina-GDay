package mx.nomina.gday.modelo;

public class Puesto extends BaseModelo{

	private Integer idPuesto;
	private String descripcion;
	
	
	public Puesto(){
		
	}


	public Puesto(Integer idPuesto, String descripcion) {
		super();
		this.idPuesto = idPuesto;
		this.descripcion = descripcion;
	}


	public Integer getIdPuesto() {
		return idPuesto;
	}


	public void setIdPuesto(Integer idPuesto) {
		this.idPuesto = idPuesto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
