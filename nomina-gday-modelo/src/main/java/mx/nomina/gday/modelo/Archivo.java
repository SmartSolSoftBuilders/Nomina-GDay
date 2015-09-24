package mx.nomina.gday.modelo;

public class Archivo extends BaseModelo{

	private Integer idArchivo;
	private String fechaCarga;
	private String tipoArchivo;
	private byte[] archivo;
	private int cargados;
	private int rechazados;
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCargados() {
		return cargados;
	}

	public void setCargados(int cargados) {
		this.cargados = cargados;
	}

	public int getRechazados() {
		return rechazados;
	}

	public void setRechazados(int rechazados) {
		this.rechazados = rechazados;
	}

	public Archivo(){
		
	}
	
	public Archivo(Integer idArchivo, String fechaCarga, String tipoArchivo,
			byte[] archivo, int cargados, int rechazados, String nombre) {
		super();
		this.idArchivo = idArchivo;
		this.fechaCarga = fechaCarga;
		this.tipoArchivo = tipoArchivo;
		this.archivo = archivo;
		this.cargados=cargados;
		this.rechazados=rechazados;
		this.nombre=nombre;
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
