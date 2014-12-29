package mx.nomina.gday.modelo;

public class Proceso {

	private int idProceso;
	private String descripcion;
	
	
	public Proceso(){
		
	}	
	
	public Proceso(int idProceso, String descripcion) {
		super();
		this.idProceso = idProceso;
		this.descripcion = descripcion;
	}
	
	
	public int getIdProceso() {
		return idProceso;
	}
	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
