package mx.nomina.gday.modelo;

public class AcumuladoPeriodo {
	
	private int idAcumuladoPeriodo;
	private int idNomina;
	private int idPeriodo;
	private String archivoAcumulado;
	private String estatus;
	private String periodo;
	
	
	
	public AcumuladoPeriodo(){
	}
	
	

	public AcumuladoPeriodo(int idAcumuladoPeriodo, int idNomina,
			int idPeriodo, String archivoAcumulado, String estatus,
			String periodo) {
		super();
		this.idAcumuladoPeriodo = idAcumuladoPeriodo;
		this.idNomina = idNomina;
		this.idPeriodo = idPeriodo;
		this.archivoAcumulado = archivoAcumulado;
		this.estatus = estatus;
		this.periodo = periodo;
	}



	public int getIdAcumuladoPeriodo() {
		return idAcumuladoPeriodo;
	}

	public void setIdAcumuladoPeriodo(int idAcumuladoPeriodo) {
		this.idAcumuladoPeriodo = idAcumuladoPeriodo;
	}

	public int getIdNomina() {
		return idNomina;
	}

	public void setIdNomina(int idNomina) {
		this.idNomina = idNomina;
	}

	public int getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public String getArchivoAcumulado() {
		return archivoAcumulado;
	}

	public void setArchivoAcumulado(String archivoAcumulado) {
		this.archivoAcumulado = archivoAcumulado;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	
	
	
	
	
}
