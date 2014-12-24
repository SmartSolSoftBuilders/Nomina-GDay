package mx.estrategas.fam.modelo;



public class Archivo extends BaseModelo {
	
	private int idArchivo;
	private String rutaArchivo;
	private String fechaArchivo;
	
	public int getIdArchivo() {
		return idArchivo;
	}
	public void setIdArchivo(int idArchivo) {
		this.idArchivo = idArchivo;
	}
	public String getRutaArchivo() {
		return rutaArchivo;
	}
	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}
	public String getFechaArchivo() {
		return fechaArchivo;
	}
	public void setFechaArchivo(String fechaArchivo) {
		this.fechaArchivo = fechaArchivo;
	}
	public Archivo(){
	}
	public Archivo(int idArchivo, String rutaArchivo, String fechaArchivo) {
		super();
		this.idArchivo = idArchivo;
		this.rutaArchivo = rutaArchivo;
		this.fechaArchivo = fechaArchivo;
	}
	
}
