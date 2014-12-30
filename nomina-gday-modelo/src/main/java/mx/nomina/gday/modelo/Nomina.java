package mx.nomina.gday.modelo;

public class Nomina {
	
	private int idNomina;
	private Patrona patrona;
	private int idIntermediaria;
	private Esquema esquema;
	private Ejecutivo ejecutivoUsuario;
	private TipoCalendario tipoCalendario;
	private String nombreCorto;
	private boolean provisionAguinaldo;
	private boolean provisionVacaciones;
	private boolean provisionPrimaVacacional;
	private int diasAguinaldo;
	private float porcPrimaVacacional;
	private boolean fondoAhorro;
	private boolean facturaSubsidio;
	private boolean ivaExento;
	private boolean reconoceAntiguedad;
	private boolean comisionCostSocial;
	private String tipoPago;
	private String claseRiesgo;
	private String registroPatronal;
	private String periodicidad;
	
	
	public Nomina(){
	}


	public Nomina(int idNomina, Patrona patrona, int idIntermediaria,
			Esquema esquema, Ejecutivo ejecutivoUsuario,
			TipoCalendario tipoCalendario, String nombreCorto,
			boolean provisionAguinaldo, boolean provisionVacaciones,
			boolean provisionPrimaVacacional, int diasAguinaldo,
			float porcPrimaVacacional, boolean fondoAhorro,
			boolean facturaSubsidio, boolean ivaExento,
			boolean reconoceAntiguedad, boolean comisionCostSocial,
			String tipoPago, String claseRiesgo, String registroPatronal,
			String periodicidad) {
		super();
		this.idNomina = idNomina;
		this.patrona = patrona;
		this.idIntermediaria = idIntermediaria;
		this.esquema = esquema;
		this.ejecutivoUsuario = ejecutivoUsuario;
		this.tipoCalendario = tipoCalendario;
		this.nombreCorto = nombreCorto;
		this.provisionAguinaldo = provisionAguinaldo;
		this.provisionVacaciones = provisionVacaciones;
		this.provisionPrimaVacacional = provisionPrimaVacacional;
		this.diasAguinaldo = diasAguinaldo;
		this.porcPrimaVacacional = porcPrimaVacacional;
		this.fondoAhorro = fondoAhorro;
		this.facturaSubsidio = facturaSubsidio;
		this.ivaExento = ivaExento;
		this.reconoceAntiguedad = reconoceAntiguedad;
		this.comisionCostSocial = comisionCostSocial;
		this.tipoPago = tipoPago;
		this.claseRiesgo = claseRiesgo;
		this.registroPatronal = registroPatronal;
		this.periodicidad = periodicidad;
	}


	public int getIdNomina() {
		return idNomina;
	}


	public void setIdNomina(int idNomina) {
		this.idNomina = idNomina;
	}


	public Patrona getPatrona() {
		return patrona;
	}


	public void setPatrona(Patrona patrona) {
		this.patrona = patrona;
	}


	public int getIdIntermediaria() {
		return idIntermediaria;
	}


	public void setIdIntermediaria(int idIntermediaria) {
		this.idIntermediaria = idIntermediaria;
	}


	public Esquema getEsquema() {
		return esquema;
	}


	public void setEsquema(Esquema esquema) {
		this.esquema = esquema;
	}


	public Ejecutivo getEjecutivoUsuario() {
		return ejecutivoUsuario;
	}


	public void setEjecutivoUsuario(Ejecutivo ejecutivoUsuario) {
		this.ejecutivoUsuario = ejecutivoUsuario;
	}


	public TipoCalendario getTipoCalendario() {
		return tipoCalendario;
	}


	public void setTipoCalendario(TipoCalendario tipoCalendario) {
		this.tipoCalendario = tipoCalendario;
	}


	public String getNombreCorto() {
		return nombreCorto;
	}


	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}


	public boolean isProvisionAguinaldo() {
		return provisionAguinaldo;
	}


	public void setProvisionAguinaldo(boolean provisionAguinaldo) {
		this.provisionAguinaldo = provisionAguinaldo;
	}


	public boolean isProvisionVacaciones() {
		return provisionVacaciones;
	}


	public void setProvisionVacaciones(boolean provisionVacaciones) {
		this.provisionVacaciones = provisionVacaciones;
	}


	public boolean isProvisionPrimaVacacional() {
		return provisionPrimaVacacional;
	}


	public void setProvisionPrimaVacacional(boolean provisionPrimaVacacional) {
		this.provisionPrimaVacacional = provisionPrimaVacacional;
	}


	public int getDiasAguinaldo() {
		return diasAguinaldo;
	}


	public void setDiasAguinaldo(int diasAguinaldo) {
		this.diasAguinaldo = diasAguinaldo;
	}


	public float getPorcPrimaVacacional() {
		return porcPrimaVacacional;
	}


	public void setPorcPrimaVacacional(float porcPrimaVacacional) {
		this.porcPrimaVacacional = porcPrimaVacacional;
	}


	public boolean isFondoAhorro() {
		return fondoAhorro;
	}


	public void setFondoAhorro(boolean fondoAhorro) {
		this.fondoAhorro = fondoAhorro;
	}


	public boolean isFacturaSubsidio() {
		return facturaSubsidio;
	}


	public void setFacturaSubsidio(boolean facturaSubsidio) {
		this.facturaSubsidio = facturaSubsidio;
	}


	public boolean isIvaExento() {
		return ivaExento;
	}


	public void setIvaExento(boolean ivaExento) {
		this.ivaExento = ivaExento;
	}


	public boolean isReconoceAntiguedad() {
		return reconoceAntiguedad;
	}


	public void setReconoceAntiguedad(boolean reconoceAntiguedad) {
		this.reconoceAntiguedad = reconoceAntiguedad;
	}


	public boolean isComisionCostSocial() {
		return comisionCostSocial;
	}


	public void setComisionCostSocial(boolean comisionCostSocial) {
		this.comisionCostSocial = comisionCostSocial;
	}


	public String getTipoPago() {
		return tipoPago;
	}


	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}


	public String getClaseRiesgo() {
		return claseRiesgo;
	}


	public void setClaseRiesgo(String claseRiesgo) {
		this.claseRiesgo = claseRiesgo;
	}


	public String getRegistroPatronal() {
		return registroPatronal;
	}


	public void setRegistroPatronal(String registroPatronal) {
		this.registroPatronal = registroPatronal;
	}


	public String getPeriodicidad() {
		return periodicidad;
	}


	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}
	
	
	
	
	
}
