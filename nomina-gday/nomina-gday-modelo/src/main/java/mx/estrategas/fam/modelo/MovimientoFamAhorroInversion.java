package mx.estrategas.fam.modelo;



public class MovimientoFamAhorroInversion extends BaseModelo {
	private int idMovimientoFamAhorroInversion;
	private String tipoMovimientoFamAhorro;
	private double montoMovimientoFamAhorro;
	private String documentoRefMovimientoFamAhorro;
	private String fechaMovimientoFamAhorro;
	
	public int getIdMovimientoFamAhorroInversion() {
		return idMovimientoFamAhorroInversion;
	}
	public void setIdMovimientoFamAhorroInversion(int idMovimientoFamAhorroInversion) {
		this.idMovimientoFamAhorroInversion = idMovimientoFamAhorroInversion;
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
	
	public MovimientoFamAhorroInversion(){		
	}
	
	public MovimientoFamAhorroInversion(int idMovimientoFamAhorroInversion,
			String tipoMovimientoFamAhorro, double montoMovimientoFamAhorro,
			String documentoRefMovimientoFamAhorro,
			String fechaMovimientoFamAhorro) {
		super();
		this.idMovimientoFamAhorroInversion = idMovimientoFamAhorroInversion;
		this.tipoMovimientoFamAhorro = tipoMovimientoFamAhorro;
		this.montoMovimientoFamAhorro = montoMovimientoFamAhorro;
		this.documentoRefMovimientoFamAhorro = documentoRefMovimientoFamAhorro;
		this.fechaMovimientoFamAhorro = fechaMovimientoFamAhorro;
	}
	
}
