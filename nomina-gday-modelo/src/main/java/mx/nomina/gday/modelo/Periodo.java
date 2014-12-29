package mx.nomina.gday.modelo;

public class Periodo {
	
	private int idPeriodo;
	private int noPago;
	private String fechaInicialPago;
	private String fechaFinalPago;
	
	
	
	
	public Periodo(){
	}
	
	public Periodo(int idPeriodo, int noPago, String fechaInicialPago,
			String fechaFinalPago) {
		super();
		this.idPeriodo = idPeriodo;
		this.noPago = noPago;
		this.fechaInicialPago = fechaInicialPago;
		this.fechaFinalPago = fechaFinalPago;
	}
	
	
	public int getIdPeriodo() {
		return idPeriodo;
	}
	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}
	public int getNoPago() {
		return noPago;
	}
	public void setNoPago(int noPago) {
		this.noPago = noPago;
	}
	public String getFechaInicialPago() {
		return fechaInicialPago;
	}
	public void setFechaInicialPago(String fechaInicialPago) {
		this.fechaInicialPago = fechaInicialPago;
	}
	public String getFechaFinalPago() {
		return fechaFinalPago;
	}
	public void setFechaFinalPago(String fechaFinalPago) {
		this.fechaFinalPago = fechaFinalPago;
	}

}
