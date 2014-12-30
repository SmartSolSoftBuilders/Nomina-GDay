package mx.nomina.gday.modelo;

public class HojaTrabajo {

	private int idHojaTrabajo;
	private Nomina nomina;
	private String nombreArchivo;
	private String archivoPlantilla;
	
	public HojaTrabajo(){
	}

	public HojaTrabajo(int idHojaTrabajo, Nomina nomina, String nombreArchivo,
			String archivoPlantilla) {
		super();
		this.idHojaTrabajo = idHojaTrabajo;
		this.nomina = nomina;
		this.nombreArchivo = nombreArchivo;
		this.archivoPlantilla = archivoPlantilla;
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
	
	
	
	
}
