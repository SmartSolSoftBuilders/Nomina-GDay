package mx.nomina.gday.modelo;

public class PatronaEmpleado {
	
	private Patrona patrona;
	private Empleado empleado;
	private int numeroConsecutivo;
	
	
	public PatronaEmpleado(){
	}


	public PatronaEmpleado(Patrona patrona, Empleado empleado,
			int numeroConsecutivo) {
		super();
		this.patrona = patrona;
		this.empleado = empleado;
		this.numeroConsecutivo = numeroConsecutivo;
	}


	public Patrona getPatrona() {
		return patrona;
	}


	public void setPatrona(Patrona patrona) {
		this.patrona = patrona;
	}


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	public int getNumeroConsecutivo() {
		return numeroConsecutivo;
	}


	public void setNumeroConsecutivo(int numeroConsecutivo) {
		this.numeroConsecutivo = numeroConsecutivo;
	}
	
	

}
