package mx.nomina.gday.modelo;

import java.util.List;

public class Nomina extends BaseModelo{
	
	private Integer idNomina;
	private Patrona patrona;
	private Patrona intermediaria;
	private Esquema esquema;
	private Ejecutivo ejecutivo;
	private TipoCalendario tipoCalendario;
	private String nombreCorto;
	private boolean provisionAguinaldo;
	private boolean provisionVacaciones;
	private boolean provisionPrimaVacacional;
	private int diasAguinaldo;
	private Integer comision;
	private float porcPrimaVacacional;
	private Integer fondoAhorro;
	private boolean facturaSubsidio;
	private boolean ivaExento;
	private boolean reconoceAntiguedad;
	private boolean comisionCostSocial;
	private String tipoPago;
	private String claseRiesgo;
	private String registroPatronal;
	private String periodicidad;
	private String fechaContrato;
	private String jsonValue;
	private List<RazonSocial> razonesSociales;
	private String tipoTabulador;
	
	
	public String getTipoTabulador() {
		return tipoTabulador;
	}
	public void setTipoTabulador(String tipoTabulador) {
		this.tipoTabulador = tipoTabulador;
	}
	public Integer getComision() {
		return comision;
	}
	public void setComision(Integer comision) {
		this.comision = comision;
	}
	public Integer getIdNomina() {
		return idNomina;
	}
	public void setIdNomina(Integer idNomina) {
		this.idNomina = idNomina;
	}
	public Patrona getPatrona() {
		return patrona;
	}
	public void setPatrona(Patrona patrona) {
		this.patrona = patrona;
	}
	public Patrona getIntermediaria() {
		return intermediaria;
	}
	public void setIntermediaria(Patrona intermediaria) {
		this.intermediaria = intermediaria;
	}
	public Esquema getEsquema() {
		return esquema;
	}
	public void setEsquema(Esquema esquema) {
		this.esquema = esquema;
	}
	public Ejecutivo getEjecutivo() {
		return ejecutivo;
	}
	public void setEjecutivo(Ejecutivo ejecutivo) {
		this.ejecutivo = ejecutivo;
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
	public Integer getFondoAhorro() {
		return fondoAhorro;
	}
	public void setFondoAhorro(Integer fondoAhorro) {
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
	public String getFechaContrato() {
		return fechaContrato;
	}
	public void setFechaContrato(String fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	public String getJsonValue() {
		return jsonValue;
	}
	public void setJsonValue(String jsonValue) {
		this.jsonValue = jsonValue;
	}
	public List<RazonSocial> getRazonesSociales() {
		return razonesSociales;
	}
	public void setRazonesSociales(List<RazonSocial> razonesSociales) {
		this.razonesSociales = razonesSociales;
	}
	public Nomina(Integer idNomina, Patrona patrona, Patrona intermediaria,
			Esquema esquema, Ejecutivo ejecutivo,
			TipoCalendario tipoCalendario, String nombreCorto,
			boolean provisionAguinaldo, boolean provisionVacaciones,
			boolean provisionPrimaVacacional, int diasAguinaldo,
			float porcPrimaVacacional, Integer fondoAhorro,
			boolean facturaSubsidio, boolean ivaExento,
			boolean reconoceAntiguedad, boolean comisionCostSocial,
			String tipoPago, String claseRiesgo, String registroPatronal,
			String periodicidad, String fechaContrato, String jsonValue,
			List<RazonSocial> razonesSociales,Integer comision, String tipoTabulador) {
		super();
		this.idNomina = idNomina;
		this.patrona = patrona;
		this.intermediaria = intermediaria;
		this.esquema = esquema;
		this.ejecutivo = ejecutivo;
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
		this.fechaContrato = fechaContrato;
		this.jsonValue = jsonValue;
		this.razonesSociales = razonesSociales;
		this.comision=comision;
		this.tipoTabulador=tipoTabulador;
	}
	
	public Nomina (){
		
	}
	

}
