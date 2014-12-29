package mx.nomina.gday.modelo;

public class PatronaEmpleado {
	
	private int idPatrona;
	private int idEmpleado;
	private int numeroConsecutivo;
	
	
	public PatronaEmpleado(){
	}
	
	public PatronaEmpleado(int idPatrona, int idEmpleado, int numeroConsecutivo) {
		super();
		this.idPatrona = idPatrona;
		this.idEmpleado = idEmpleado;
		this.numeroConsecutivo = numeroConsecutivo;
	}
	
	
	public int getIdPatrona() {
		return idPatrona;
	}
	public void setIdPatrona(int idPatrona) {
		this.idPatrona = idPatrona;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public int getNumeroConsecutivo() {
		return numeroConsecutivo;
	}
	public void setNumeroConsecutivo(int numeroConsecutivo) {
		this.numeroConsecutivo = numeroConsecutivo;
	}

}
