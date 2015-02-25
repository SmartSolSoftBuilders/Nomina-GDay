package mx.nomina.gday.modelo;

public class AcumuladoPeriodo {
	
	private int idAcumuladoPeriodo;
	private Nomina nomina;
	private Periodo periodo;
	private byte[] archivoAcumulado;
	private String estatus;
	
	
	
	public AcumuladoPeriodo(){
	}



	public AcumuladoPeriodo(int idAcumuladoPeriodo, Nomina nomina,
			Periodo periodo, byte[] archivoAcumulado, String estatus) {
		super();
		this.idAcumuladoPeriodo = idAcumuladoPeriodo;
		this.nomina = nomina;
		this.periodo = periodo;
		this.archivoAcumulado = archivoAcumulado;
		this.estatus = estatus;
	}



	public int getIdAcumuladoPeriodo() {
		return idAcumuladoPeriodo;
	}



	public void setIdAcumuladoPeriodo(int idAcumuladoPeriodo) {
		this.idAcumuladoPeriodo = idAcumuladoPeriodo;
	}



	public Nomina getNomina() {
		return nomina;
	}



	public void setNomina(Nomina nomina) {
		this.nomina = nomina;
	}



	public Periodo getPeriodo() {
		return periodo;
	}



	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}



	public byte[] getArchivoAcumulado() {
		return archivoAcumulado;
	}



	public void setArchivoAcumulado(byte[] archivoAcumulado) {
		this.archivoAcumulado = archivoAcumulado;
	}



	public String getEstatus() {
		return estatus;
	}



	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
}
