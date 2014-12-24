package mx.estrategas.fam.modelo;

public class Pago extends BaseModelo{

	private static final long serialVersionUID = 8207400300558249958L;

	private Integer numPago;
	private Float pago;
	private Float capital;
	private Float interes;
	private Float saldoInsoluto;
	
	
	public Pago(){
		
	}


	public Pago(Integer numPago, Float pago, Float capital, Float interes,
			Float saldoInsoluto) {
		super();
		this.numPago = numPago;
		this.pago = pago;
		this.capital = capital;
		this.interes = interes;
		this.saldoInsoluto = saldoInsoluto;
	}


	public Integer getNumPago() {
		return numPago;
	}


	public void setNumPago(Integer numPago) {
		this.numPago = numPago;
	}


	public Float getPago() {
		return pago;
	}


	public void setPago(Float pago) {
		this.pago = pago;
	}


	public Float getCapital() {
		return capital;
	}


	public void setCapital(Float capital) {
		this.capital = capital;
	}


	public Float getInteres() {
		return interes;
	}


	public void setInteres(Float interes) {
		this.interes = interes;
	}


	public Float getSaldoInsoluto() {
		return saldoInsoluto;
	}


	public void setSaldoInsoluto(Float saldoInsoluto) {
		this.saldoInsoluto = saldoInsoluto;
	}


	}
