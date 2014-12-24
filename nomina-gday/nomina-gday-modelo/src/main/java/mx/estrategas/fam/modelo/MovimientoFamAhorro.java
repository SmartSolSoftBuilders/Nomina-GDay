package mx.estrategas.fam.modelo;



public class MovimientoFamAhorro extends BaseModelo {
	private int idMovimientoFamAhorro;
	private String tipoMovimientoFamAhorro;
	private double montoMovimientoFamAhorro;
	private String documentoRefMovimientoFamAhorro;
	private String fechaMovimientoFamAhorro;
	
	public int getIdMovimientoFamAhorro() {
		return idMovimientoFamAhorro;
	}
	public void setIdMovimientoFamAhorro(int idMovimientoFamAhorro) {
		this.idMovimientoFamAhorro = idMovimientoFamAhorro;
	}
	public String getTipoMovimientoFamAhorro() {
		return tipoMovimientoFamAhorro;
	}
	public void setTipoMovimientoFamAhorro(String tipoMovimientoFamAhorro) {
		this.tipoMovimientoFamAhorro = tipoMovimientoFamAhorro;
	}
	public double getMontoMovimientoFamAhorro() {
		return montoMovimientoFamAhorro;
	}
	public void setMontoMovimientoFamAhorro(double montoMovimientoFamAhorro) {
		this.montoMovimientoFamAhorro = montoMovimientoFamAhorro;
	}
	public String getDocumentoRefMovimientoFamAhorro() {
		return documentoRefMovimientoFamAhorro;
	}
	public void setDocumentoRefMovimientoFamAhorro(
			String documentoRefMovimientoFamAhorro) {
		this.documentoRefMovimientoFamAhorro = documentoRefMovimientoFamAhorro;
	}
	public String getFechaMovimientoFamAhorro() {
		return fechaMovimientoFamAhorro;
	}
	public void setFechaMovimientoFamAhorro(String fechaMovimientoFamAhorro) {
		this.fechaMovimientoFamAhorro = fechaMovimientoFamAhorro;
	}	
	
	public MovimientoFamAhorro(){		
	}
	
	public MovimientoFamAhorro(int idMovimientoFamAhorro,
			String tipoMovimientoFamAhorro, double montoMovimientoFamAhorro,
			String documentoRefMovimientoFamAhorro,
			String fechaMovimientoFamAhorro) {
		super();
		this.idMovimientoFamAhorro = idMovimientoFamAhorro;
		this.tipoMovimientoFamAhorro = tipoMovimientoFamAhorro;
		this.montoMovimientoFamAhorro = montoMovimientoFamAhorro;
		this.documentoRefMovimientoFamAhorro = documentoRefMovimientoFamAhorro;
		this.fechaMovimientoFamAhorro = fechaMovimientoFamAhorro;
	}
	
}
