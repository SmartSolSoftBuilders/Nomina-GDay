package mx.estrategas.fam.modelo;

public class AseguradoBeneficioAdicional extends BaseModelo {
	private int idAseguradoBeneficioAdicional;
	private String nombreAseguradoBeneficioAdicional;
	private String appAseguradoBeneficioAdicional;
	private String apmAseguradoBeneficioAdicional;
	private String fechaNacimientoAseguradoBeneficioAdicional;
	private String parentescoAseguradoBeneficioAdicional;
	private int edadAseguradoBeneficioAdicional;
	private CertificadoAfiliado certificadoAfiliado;
			
	public int getIdAseguradoBeneficioAdicional() {
		return idAseguradoBeneficioAdicional;
	}
	public void setIdAseguradoBeneficioAdicional(int idAseguradoBeneficioAdicional) {
		this.idAseguradoBeneficioAdicional = idAseguradoBeneficioAdicional;
	}
	public String getNombreAseguradoBeneficioAdicional() {
		return nombreAseguradoBeneficioAdicional;
	}
	public void setNombreAseguradoBeneficioAdicional(
			String nombreAseguradoBeneficioAdicional) {
		this.nombreAseguradoBeneficioAdicional = nombreAseguradoBeneficioAdicional;
	}
	public String getAppAseguradoBeneficioAdicional() {
		return appAseguradoBeneficioAdicional;
	}
	public void setAppAseguradoBeneficioAdicional(
			String appAseguradoBeneficioAdicional) {
		this.appAseguradoBeneficioAdicional = appAseguradoBeneficioAdicional;
	}
	public String getApmAseguradoBeneficioAdicional() {
		return apmAseguradoBeneficioAdicional;
	}
	public void setApmAseguradoBeneficioAdicional(
			String apmAseguradoBeneficioAdicional) {
		this.apmAseguradoBeneficioAdicional = apmAseguradoBeneficioAdicional;
	}
	public String getFechaNacimientoAseguradoBeneficioAdicional() {
		return fechaNacimientoAseguradoBeneficioAdicional;
	}
	public void setFechaNacimientoAseguradoBeneficioAdicional(
			String fechaNacimientoAseguradoBeneficioAdicional) {
		this.fechaNacimientoAseguradoBeneficioAdicional = fechaNacimientoAseguradoBeneficioAdicional;
	}
	public String getParentescoAseguradoBeneficioAdicional() {
		return parentescoAseguradoBeneficioAdicional;
	}
	public void setParentescoAseguradoBeneficioAdicional(
			String parentescoAseguradoBeneficioAdicional) {
		this.parentescoAseguradoBeneficioAdicional = parentescoAseguradoBeneficioAdicional;
	}
	public int getEdadAseguradoBeneficioAdicional() {
		return edadAseguradoBeneficioAdicional;
	}
	public void setEdadAseguradoBeneficioAdicional(
			int edadAseguradoBeneficioAdicional) {
		this.edadAseguradoBeneficioAdicional = edadAseguradoBeneficioAdicional;
	}
	public CertificadoAfiliado getCertificadoAfiliado() {
		return certificadoAfiliado;
	}
	public void setCertificadoAfiliado(
			CertificadoAfiliado certificadoAfiliado) {
		this.certificadoAfiliado = certificadoAfiliado;
	}
	public AseguradoBeneficioAdicional(){	
	}
	public AseguradoBeneficioAdicional(int idAseguradoBeneficioAdicional,
			String nombreAseguradoBeneficioAdicional,
			String appAseguradoBeneficioAdicional,
			String apmAseguradoBeneficioAdicional,
			String fechaNacimientoAseguradoBeneficioAdicional,
			String parentescoAseguradoBeneficioAdicional,
			int edadAseguradoBeneficioAdicional,
			CertificadoAfiliado certificadoAfiliado) {
		super();
		this.idAseguradoBeneficioAdicional = idAseguradoBeneficioAdicional;
		this.nombreAseguradoBeneficioAdicional = nombreAseguradoBeneficioAdicional;
		this.appAseguradoBeneficioAdicional = appAseguradoBeneficioAdicional;
		this.apmAseguradoBeneficioAdicional = apmAseguradoBeneficioAdicional;
		this.fechaNacimientoAseguradoBeneficioAdicional = fechaNacimientoAseguradoBeneficioAdicional;
		this.parentescoAseguradoBeneficioAdicional = parentescoAseguradoBeneficioAdicional;
		this.edadAseguradoBeneficioAdicional = edadAseguradoBeneficioAdicional;
		this.certificadoAfiliado = certificadoAfiliado;
	}

	
}
