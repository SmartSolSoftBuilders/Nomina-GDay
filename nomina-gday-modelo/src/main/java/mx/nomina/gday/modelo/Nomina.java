package mx.nomina.gday.modelo;

public class Nomina {
	
	private int idNomina;
	private int idPatrona;
	private int idIntermediaria;
	private int idEsquema;
	private int idEjecutivoUsuario;
	private int idCalendario;
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
	private String tipoCalendario;
	
	
	public Nomina(){
	}
	
	
	
	public Nomina(int idNomina, int idPatrona, int idIntermediaria,
			int idEsquema, int idEjecutivoUsuario, int idCalendario,
			String nombreCorto, boolean provisionAguinaldo,
			boolean provisionVacaciones, boolean provisionPrimaVacacional,
			int diasAguinaldo, float porcPrimaVacacional, boolean fondoAhorro,
			boolean facturaSubsidio, boolean ivaExento,
			boolean reconoceAntiguedad, boolean comisionCostSocial,
			String tipoPago, String claseRiesgo, String registroPatronal,
			String periodicidad, String tipoCalendario) {
		super();
		this.idNomina = idNomina;
		this.idPatrona = idPatrona;
		this.idIntermediaria = idIntermediaria;
		this.idEsquema = idEsquema;
		this.idEjecutivoUsuario = idEjecutivoUsuario;
		this.idCalendario = idCalendario;
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
		this.tipoCalendario = tipoCalendario;
	}
	
	
	public int getIdNomina() {
		return idNomina;
	}
	public void setIdNomina(int idNomina) {
		this.idNomina = idNomina;
	}
	public int getIdPatrona() {
		return idPatrona;
	}
	public void setIdPatrona(int idPatrona) {
		this.idPatrona = idPatrona;
	}
	public int getIdIntermediaria() {
		return idIntermediaria;
	}
	public void setIdIntermediaria(int idIntermediaria) {
		this.idIntermediaria = idIntermediaria;
	}
	public int getIdEsquema() {
		return idEsquema;
	}
	public void setIdEsquema(int idEsquema) {
		this.idEsquema = idEsquema;
	}
	public int getIdEjecutivoUsuario() {
		return idEjecutivoUsuario;
	}
	public void setIdEjecutivoUsuario(int idEjecutivoUsuario) {
		this.idEjecutivoUsuario = idEjecutivoUsuario;
	}
	public int getIdCalendario() {
		return idCalendario;
	}
	public void setIdCalendario(int idCalendario) {
		this.idCalendario = idCalendario;
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
	public String getTipoCalendario() {
		return tipoCalendario;
	}
	public void setTipoCalendario(String tipoCalendario) {
		this.tipoCalendario = tipoCalendario;
	}
	
	
	
}
