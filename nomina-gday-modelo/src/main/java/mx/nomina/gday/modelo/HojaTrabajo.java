package mx.nomina.gday.modelo;

public class HojaTrabajo extends BaseModelo{

	private int idHojaTrabajo;
	private Nomina nomina;
	private String nombreArchivo;
	private String archivoPlantilla;
	private byte[] archivoAcumulado;
	private String tipoArchivo;

	
	public HojaTrabajo(){
	}

	public String getTipoArchivo() {
		return tipoArchivo;
	}


	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}


	public int getIdHojaTrabajo() {
		return idHojaTrabajo;
	}


	public void setIdHojaTrabajo(int idHojaTrabajo) {
		this.idHojaTrabajo = idHojaTrabajo;
	}


	public Nomina getNomina() {
		return nomina;
	}


	public void setNomina(Nomina nomina) {
		this.nomina = nomina;
	}


	public String getNombreArchivo() {
		return nombreArchivo;
	}


	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}


	public String getArchivoPlantilla() {
		return archivoPlantilla;
	}


	public void setArchivoPlantilla(String archivoPlantilla) {
		this.archivoPlantilla = archivoPlantilla;
	}


	public byte[] getArchivoAcumulado() {
		return archivoAcumulado;
	}


	public void setArchivoAcumulado(byte[] archivoAcumulado) {
		this.archivoAcumulado = archivoAcumulado;
	}


	public HojaTrabajo(int idHojaTrabajo, Nomina nomina, String nombreArchivo,
			String archivoPlantilla, byte[] archivoAcumulado,String tipoArchivo) {
		super();
		this.idHojaTrabajo = idHojaTrabajo;
		this.nomina = nomina;
		this.nombreArchivo = nombreArchivo;
		this.archivoPlantilla = archivoPlantilla;
		this.archivoAcumulado = archivoAcumulado;
		this.tipoArchivo = tipoArchivo;
	}


}
