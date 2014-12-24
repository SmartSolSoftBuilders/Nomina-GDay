package mx.estrategas.fam.modelo;

public class Beneficiario extends BaseModelo {
	
	private int idBeneficiario;
	private String nombreBeneficiario;
	private String appBeneficiario;
	private String apmBeneficiario;
	private String fechaNacimientoBeneficiario;
	private String parentescoBeneficiario;
	private String porcentajeBeneficiario;	
	private String porcentajeBeneficiarioDos;
	private int edadBeneficiario;
	private int revocableBeneficiario;
	private int irrevocableBeneficiario;
	private CertificadoAfiliado certificadoAfiliado;
	
	public String getPorcentajeBeneficiarioDos() {
		return porcentajeBeneficiarioDos;
	}
	public void setPorcentajeBeneficiarioDos(String porcentajeBeneficiarioDos) {
		this.porcentajeBeneficiarioDos = porcentajeBeneficiarioDos;
	}
	
	public String getPorcentajeBeneficiario() {
		return porcentajeBeneficiario;
	}
	public void setPorcentajeBeneficiario(String porcentajeBeneficiario) {
		this.porcentajeBeneficiario = porcentajeBeneficiario;
	}
		
	public int getIdBeneficiario() {
		return idBeneficiario;
	}
	public void setIdBeneficiario(int idBeneficiario) {
		this.idBeneficiario = idBeneficiario;
	}
	public String getNombreBeneficiario() {
		return nombreBeneficiario;
	}
	public void setNombreBeneficiario(String nombreBeneficiario) {
		this.nombreBeneficiario = nombreBeneficiario;
	}
	public String getAppBeneficiario() {
		return appBeneficiario;
	}
	public void setAppBeneficiario(String appBeneficiario) {
		this.appBeneficiario = appBeneficiario;
	}
	public String getApmBeneficiario() {
		return apmBeneficiario;
	}
	public void setApmBeneficiario(String apmBeneficiario) {
		this.apmBeneficiario = apmBeneficiario;
	}
	public String getFechaNacimientoBeneficiario() {
		return fechaNacimientoBeneficiario;
	}
	public void setFechaNacimientoBeneficiario(String fechaNacimientoBeneficiario) {
		this.fechaNacimientoBeneficiario = fechaNacimientoBeneficiario;
	}
	public String getParentescoBeneficiario() {
		return parentescoBeneficiario;
	}
	public void setParentescoBeneficiario(String parentescoBeneficiario) {
		this.parentescoBeneficiario = parentescoBeneficiario;
	}
	public int getEdadBeneficiario() {
		return edadBeneficiario;
	}
	public void setEdadBeneficiario(int edadBeneficiario) {
		this.edadBeneficiario = edadBeneficiario;
	}
	public int getRevocableBeneficiario() {
		return revocableBeneficiario;
	}
	public void setRevocableBeneficiario(int revocableBeneficiario) {
		this.revocableBeneficiario = revocableBeneficiario;
	}
	public int getIrrevocableBeneficiario() {
		return irrevocableBeneficiario;
	}
	public void setIrrevocableBeneficiario(int irrevocableBeneficiario) {
		this.irrevocableBeneficiario = irrevocableBeneficiario;
	}
	public CertificadoAfiliado getCertificadoAfiliado() {
		return certificadoAfiliado;
	}
	public void setCertificadoAfiliado(
			CertificadoAfiliado certificadoAfiliado) {
		this.certificadoAfiliado = certificadoAfiliado;
	}
	
	public Beneficiario(){		
	}
	
	public Beneficiario(int idBeneficiario, String nombreBeneficiario,
			String appBeneficiario, String apmBeneficiario,
			String fechaNacimientoBeneficiario, String parentescoBeneficiario,
			String porcentajeBeneficiario,String porcentajeBeneficiarioDos,
			int edadBeneficiario, int revocableBeneficiario,
			int irrevocableBeneficiario,
			CertificadoAfiliado certificadoAfiliado) {
		super();
		this.idBeneficiario = idBeneficiario;
		this.nombreBeneficiario = nombreBeneficiario;
		this.appBeneficiario = appBeneficiario;
		this.apmBeneficiario = apmBeneficiario;
		this.fechaNacimientoBeneficiario = fechaNacimientoBeneficiario;
		this.parentescoBeneficiario = parentescoBeneficiario;
		this.porcentajeBeneficiario=porcentajeBeneficiario;
		this.porcentajeBeneficiarioDos=porcentajeBeneficiarioDos;
		this.edadBeneficiario = edadBeneficiario;
		this.revocableBeneficiario = revocableBeneficiario;
		this.irrevocableBeneficiario = irrevocableBeneficiario;
		this.certificadoAfiliado = certificadoAfiliado;		
	}	
	
}
