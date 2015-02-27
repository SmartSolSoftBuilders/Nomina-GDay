package mx.nomina.gday.modelo;

public class AcumuladoPeriodo extends BaseModelo{
	
	private Integer idAcumuladoPeriodo;
	private Nomina nomina;
	private Periodo periodo;
	private byte[] archivoAcumulado;
	private String estatus;
	private String nombreArchivo;

	
	
	
	
	public AcumuladoPeriodo(){
	}


	public AcumuladoPeriodo(Integer idAcumuladoPeriodo, Nomina nomina,
			Periodo periodo, byte[] archivoAcumulado, String estatus,
			String nombreArchivo) {
		super();
		this.idAcumuladoPeriodo = idAcumuladoPeriodo;
		this.nomina = nomina;
		this.periodo = periodo;
		this.archivoAcumulado = archivoAcumulado;
		this.estatus = estatus;
		this.nombreArchivo = nombreArchivo;
	}





	public Integer getIdAcumuladoPeriodo() {
		return idAcumuladoPeriodo;
	}





	public void setIdAcumuladoPeriodo(Integer idAcumuladoPeriodo) {
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





	public String getNombreArchivo() {
		return nombreArchivo;
	}





	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}


		
}
