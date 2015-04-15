package mx.nomina.gday.modelo;

public class AcumuladoPeriodo extends BaseModelo{
	
	private Integer idAcumuladoPeriodo;
	private Nomina nomina;
	private String numeroPeriodo;
	private byte[] archivoAcumulado;
	private String estatus;
	private String nombreArchivo;
	private String mesPago;
	private String anioPago;
	private String tipoArchivo;
	
	public AcumuladoPeriodo(){
	}		

	public String getTipoArchivo() {
		return tipoArchivo;
	}

	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
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

	public String getNumeroPeriodo() {
		return numeroPeriodo;
	}

	public void setNumeroPeriodo(String numeroPeriodo) {
		this.numeroPeriodo = numeroPeriodo;
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

	public String getMesPago() {
		return mesPago;
	}

	public void setMesPago(String mesPago) {
		this.mesPago = mesPago;
	}

	public String getAnioPago() {
		return anioPago;
	}

	public void setAnioPago(String anioPago) {
		this.anioPago = anioPago;
	}

	public AcumuladoPeriodo(Integer idAcumuladoPeriodo, Nomina nomina,
			String numeroPeriodo, byte[] archivoAcumulado, String estatus,
			String nombreArchivo, String mesPago, String anioPago, String tipoArchivo) {
		super();
		this.idAcumuladoPeriodo = idAcumuladoPeriodo;
		this.nomina = nomina;
		this.numeroPeriodo = numeroPeriodo;
		this.archivoAcumulado = archivoAcumulado;
		this.estatus = estatus;
		this.nombreArchivo = nombreArchivo;
		this.mesPago = mesPago;
		this.anioPago = anioPago;
		this.tipoArchivo = tipoArchivo;
	}


		
}
