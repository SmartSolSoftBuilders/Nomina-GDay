package mx.nomina.gday.modelo;

public class Departamento {

	private int idDepartamento;
	private String descripcion;

	public Departamento(){
		
	}
	
	public Departamento(int idDepartamento, String descripcion) {
		super();
		this.idDepartamento = idDepartamento;
		this.descripcion = descripcion;
	}
	
	
	public int getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
