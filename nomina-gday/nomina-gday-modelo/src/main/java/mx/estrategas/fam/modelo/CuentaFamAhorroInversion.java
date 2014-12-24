package mx.estrategas.fam.modelo;

import java.util.List;

public class CuentaFamAhorroInversion extends BaseModelo {
	
	private int idCuentaFamAhorroInversion;
	private double saldo;
	private String fechaApertura;
	private int asalariado;
	private String actividadEmpresarial;
	private int porcentajeAhorro;
	private String procedenciaNegocio;
	private double montoApertura;
	private String actividadEconomica;
	private String estatusLaboral;
	private String frecuenciaDepositos;
	private String frecuenciaRetiros;
	private Afiliado afiliado;
	private BenefCuentaFamAhorro benefOperadorCuentaFamAhorro;
	private BenefCuentaFamAhorro benef1CuentaFamAhorro;
	private BenefCuentaFamAhorro benef2CuentaFamAhorro;
	
	public BenefCuentaFamAhorro getBenefOperadorCuentaFamAhorro() {
		return benefOperadorCuentaFamAhorro;
	}
	public void setBenefOperadorCuentaFamAhorro(
			BenefCuentaFamAhorro benefOperadorCuentaFamAhorro) {
		this.benefOperadorCuentaFamAhorro = benefOperadorCuentaFamAhorro;
	}
	public BenefCuentaFamAhorro getBenef1CuentaFamAhorro() {
		return benef1CuentaFamAhorro;
	}
	public void setBenef1CuentaFamAhorro(BenefCuentaFamAhorro benef1CuentaFamAhorro) {
		this.benef1CuentaFamAhorro = benef1CuentaFamAhorro;
	}
	public BenefCuentaFamAhorro getBenef2CuentaFamAhorro() {
		return benef2CuentaFamAhorro;
	}
	public void setBenef2CuentaFamAhorro(BenefCuentaFamAhorro benef2CuentaFamAhorro) {
		this.benef2CuentaFamAhorro = benef2CuentaFamAhorro;
	}
	
	public int getIdCuentaFamAhorroInversion() {
		return idCuentaFamAhorroInversion;
	}
	public void setIdCuentaFamAhorroInversion(int idCuentaFamAhorroInversion) {
		this.idCuentaFamAhorroInversion = idCuentaFamAhorroInversion;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	public int getAsalariado() {
		return asalariado;
	}
	public void setAsalariado(int asalariado) {
		this.asalariado = asalariado;
	}
	public String getActividadEmpresarial() {
		return actividadEmpresarial;
	}
	public void setActividadEmpresarial(String actividadEmpresarial) {
		this.actividadEmpresarial = actividadEmpresarial;
	}
	public int getPorcentajeAhorro() {
		return porcentajeAhorro;
	}
	public void setPorcentajeAhorro(int porcentajeAhorro) {
		this.porcentajeAhorro = porcentajeAhorro;
	}
	public String getProcedenciaNegocio() {
		return procedenciaNegocio;
	}
	public void setProcedenciaNegocio(String procedenciaNegocio) {
		this.procedenciaNegocio = procedenciaNegocio;
	}	
	public double getMontoApertura() {
		return montoApertura;
	}
	public void setMontoApertura(double montoApertura) {
		this.montoApertura = montoApertura;
	}
	public String getActividadEconomica() {
		return actividadEconomica;
	}
	public void setActividadEconomica(String actividadEconomica) {
		this.actividadEconomica = actividadEconomica;
	}
	public String getEstatusLaboral() {
		return estatusLaboral;
	}
	public void setEstatusLaboral(String estatusLaboral) {
		this.estatusLaboral = estatusLaboral;
	}
	public String getFrecuenciaDepositos() {
		return frecuenciaDepositos;
	}
	public void setFrecuenciaDepositos(String frecuenciaDepositos) {
		this.frecuenciaDepositos = frecuenciaDepositos;
	}
	public String getFrecuenciaRetiros() {
		return frecuenciaRetiros;
	}
	public void setFrecuenciaRetiros(String frecuenciaRetiros) {
		this.frecuenciaRetiros = frecuenciaRetiros;
	}
	public CuentaFamAhorroInversion(){
		
	}
	public CuentaFamAhorroInversion(int idCuentaFamAhorroInversion, double saldo,
			String fechaApertura, int asalariado, String actividadEmpresarial,
			int porcentajeAhorro, String procedenciaNegocio, double montoApertura,
			String actividadEconomica, String estatusLaboral, String frecuenciaDepositos, String frecuenciaRetiros,
			BenefCuentaFamAhorro benefOperadorCuentaFamAhorro,BenefCuentaFamAhorro benef1CuentaFamAhorro,BenefCuentaFamAhorro benef2CuentaFamAhorro,
			Afiliado afiliado) {
		super();
		this.idCuentaFamAhorroInversion = idCuentaFamAhorroInversion;
		this.saldo = saldo;
		this.fechaApertura = fechaApertura;
		this.asalariado = asalariado;
		this.actividadEmpresarial = actividadEmpresarial;
		this.porcentajeAhorro = porcentajeAhorro;
		this.procedenciaNegocio = procedenciaNegocio;
		this.montoApertura = montoApertura;
		this.actividadEconomica=actividadEconomica;
		this.estatusLaboral=estatusLaboral;
		this.frecuenciaDepositos=frecuenciaDepositos;
		this.frecuenciaRetiros=frecuenciaRetiros;
		this.benefOperadorCuentaFamAhorro=benefOperadorCuentaFamAhorro;
		this.benef1CuentaFamAhorro=benef1CuentaFamAhorro;
		this.benef2CuentaFamAhorro=benef2CuentaFamAhorro;
		this.afiliado=afiliado;
	}
	public Afiliado getAfiliado() {
		return afiliado;
	}
	public void setAfiliado(Afiliado afiliado) {
		this.afiliado = afiliado;
	}
		
}

