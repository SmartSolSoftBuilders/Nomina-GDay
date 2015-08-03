package mx.nomina.gday.modelo;

public class Archivo extends BaseModelo{

	private Integer idArchivo;
	private String fechaCarga;
	private String tipoArchivo;
	private byte[] archivo;
	
	public Archivo(){
		
	}
	
	public Archivo(Integer idArchivo, String fechaCarga, String tipoArchivo,
			byte[] archivo) {
		super();
		this.idArchivo = idArchivo;
		this.fechaCarga = fechaCarga;
		this.tipoArchivo = tipoArchivo;
		this.archivo = archivo;
	}

	public Integer getIdArchivo() {
		return idArchivo;
	}

	public void setIdArchivo(Integer idArchivo) {
		this.idArchivo = idArchivo;
	}

	public String getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(String fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	public String getTipoArchivo() {
		return tipoArchivo;
	}

	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}

	public byte[] getArchivo() {
		return archivo;
	}

	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}
	
}
