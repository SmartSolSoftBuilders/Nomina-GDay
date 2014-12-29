package mx.nomina.gday.modelo;

public class HojaTrabajo {

	private int idHojaTrabajo;
	private int idNomina;
	private String nombreArchivo;
	private String archivoPlantilla;
	
	public HojaTrabajo(){
	}
	
	public HojaTrabajo(int idHojaTrabajo, int idNomina, String nombreArchivo,
			String archivoPlantilla) {
		super();
		this.idHojaTrabajo = idHojaTrabajo;
		this.idNomina = idNomina;
		this.nombreArchivo = nombreArchivo;
		this.archivoPlantilla = archivoPlantilla;
	}
	
	public int getIdHojaTrabajo() {
		return idHojaTrabajo;
	}
	public void setIdHojaTrabajo(int idHojaTrabajo) {
		this.idHojaTrabajo = idHojaTrabajo;
	}
	public int getIdNomina() {
		return idNomina;
	}
	public void setIdNomina(int idNomina) {
		this.idNomina = idNomina;
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
	
	
	
}
