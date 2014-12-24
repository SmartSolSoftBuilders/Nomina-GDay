package mx.estrategas.fam.modelo;

import java.util.List;

public class Cotizacion extends BaseModelo {

	private static final long serialVersionUID = 251048393838953752L;
	
	private int idCotizacion;
	private String escuela;
	private String nombreEmpleado;
	private int antiguedad;
	private boolean miembrofam;
	private double sueldoBrutoQuincenal;
	private double sueldoNeto;
	private double creditoMaximoAlcanzado;
	private int quincenasDeGracia;
	private double creditoSolicitado;
	private double creditoTotal;
	private double tasaFijaAnual;
	private double cat;
	private double tasaComisionGestion;
	private Float gestionFam;
	private int plazoPagos;
	private int plazoCredito;
	private String formaPago;
	private int numeroPagos;
	private Float descuentoMensual;
	private Float descuentoGestion;
	private double pagototal;
	private String estatus;
	private String fechaCotizacion;
	private List<Pago> pagos;
	private Afiliado afiliado;
	
	public Cotizacion(){
		
	}

	public Cotizacion(int idCotizacion, String escuela, String nombreEmpleado,
			int antiguedad, boolean miembrofam, double sueldoBrutoQuincenal,
			double sueldoNeto, double creditoMaximoAlcanzado,
			int quincenasDeGracia, double creditoSolicitado,
			double creditoTotal, double tasaFijaAnual, double cat,
			double tasaComisionGestion, Float gestionFam, int plazoPagos,
			int plazoCredito, String formaPago, int numeroPagos,
			Float descuentoMensual, Float descuentoGestion, double pagototal,
			String estatus, String fechaCotizacion, List<Pago> pagos,
			Afiliado afiliado) {
		super();
		this.idCotizacion = idCotizacion;
		this.escuela = escuela;
		this.nombreEmpleado = nombreEmpleado;
		this.antiguedad = antiguedad;
		this.miembrofam = miembrofam;
		this.sueldoBrutoQuincenal = sueldoBrutoQuincenal;
		this.sueldoNeto = sueldoNeto;
		this.creditoMaximoAlcanzado = creditoMaximoAlcanzado;
		this.quincenasDeGracia = quincenasDeGracia;
		this.creditoSolicitado = creditoSolicitado;
		this.creditoTotal = creditoTotal;
		this.tasaFijaAnual = tasaFijaAnual;
		this.cat = cat;
		this.tasaComisionGestion = tasaComisionGestion;
		this.gestionFam = gestionFam;
		this.plazoPagos = plazoPagos;
		this.plazoCredito = plazoCredito;
		this.formaPago = formaPago;
		this.numeroPagos = numeroPagos;
		this.descuentoMensual = descuentoMensual;
		this.descuentoGestion = descuentoGestion;
		this.pagototal = pagototal;
		this.estatus = estatus;
		this.fechaCotizacion = fechaCotizacion;
		this.pagos = pagos;
		this.afiliado = afiliado;
	}

	public int getIdCotizacion() {
		return idCotizacion;
	}

	public void setIdCotizacion(int idCotizacion) {
		this.idCotizacion = idCotizacion;
	}

	public String getEscuela() {
		return escuela;
	}

	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public boolean isMiembrofam() {
		return miembrofam;
	}

	public void setMiembrofam(boolean miembrofam) {
		this.miembrofam = miembrofam;
	}

	public double getSueldoBrutoQuincenal() {
		return sueldoBrutoQuincenal;
	}

	public void setSueldoBrutoQuincenal(double sueldoBrutoQuincenal) {
		this.sueldoBrutoQuincenal = sueldoBrutoQuincenal;
	}

	public double getSueldoNeto() {
		return sueldoNeto;
	}

	public void setSueldoNeto(double sueldoNeto) {
		this.sueldoNeto = sueldoNeto;
	}

	public double getCreditoMaximoAlcanzado() {
		return creditoMaximoAlcanzado;
	}

	public void setCreditoMaximoAlcanzado(double creditoMaximoAlcanzado) {
		this.creditoMaximoAlcanzado = creditoMaximoAlcanzado;
	}

	public int getQuincenasDeGracia() {
		return quincenasDeGracia;
	}

	public void setQuincenasDeGracia(int quincenasDeGracia) {
		this.quincenasDeGracia = quincenasDeGracia;
	}

	public double getCreditoSolicitado() {
		return creditoSolicitado;
	}

	public void setCreditoSolicitado(double creditoSolicitado) {
		this.creditoSolicitado = creditoSolicitado;
	}

	public double getCreditoTotal() {
		return creditoTotal;
	}

	public void setCreditoTotal(double creditoTotal) {
		this.creditoTotal = creditoTotal;
	}

	public double getTasaFijaAnual() {
		return tasaFijaAnual;
	}

	public void setTasaFijaAnual(double tasaFijaAnual) {
		this.tasaFijaAnual = tasaFijaAnual;
	}

	public double getCat() {
		return cat;
	}

	public void setCat(double cat) {
		this.cat = cat;
	}

	public double getTasaComisionGestion() {
		return tasaComisionGestion;
	}

	public void setTasaComisionGestion(double tasaComisionGestion) {
		this.tasaComisionGestion = tasaComisionGestion;
	}

	public Float getGestionFam() {
		return gestionFam;
	}

	public void setGestionFam(Float gestionFam) {
		this.gestionFam = gestionFam;
	}

	public int getPlazoPagos() {
		return plazoPagos;
	}

	public void setPlazoPagos(int plazoPagos) {
		this.plazoPagos = plazoPagos;
	}

	public int getPlazoCredito() {
		return plazoCredito;
	}

	public void setPlazoCredito(int plazoCredito) {
		this.plazoCredito = plazoCredito;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public int getNumeroPagos() {
		return numeroPagos;
	}

	public void setNumeroPagos(int numeroPagos) {
		this.numeroPagos = numeroPagos;
	}

	public Float getDescuentoMensual() {
		return descuentoMensual;
	}

	public void setDescuentoMensual(Float descuentoMensual) {
		this.descuentoMensual = descuentoMensual;
	}

	public Float getDescuentoGestion() {
		return descuentoGestion;
	}

	public void setDescuentoGestion(Float descuentoGestion) {
		this.descuentoGestion = descuentoGestion;
	}

	public double getPagototal() {
		return pagototal;
	}

	public void setPagototal(double pagototal) {
		this.pagototal = pagototal;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getFechaCotizacion() {
		return fechaCotizacion;
	}

	public void setFechaCotizacion(String fechaCotizacion) {
		this.fechaCotizacion = fechaCotizacion;
	}

	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Afiliado getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(Afiliado afiliado) {
		this.afiliado = afiliado;
	}
	
}
