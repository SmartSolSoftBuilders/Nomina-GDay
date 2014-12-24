package mx.estrategas.fam.modelo;

public class BenefCuentaFamAhorro extends BaseModelo {
	
	private int idBenefCuentaFamAhorro;	
	private int idCuentaFamAhorro;
	private String operadorBenefCuentaFamAhorro;
	private String apellidoPaternoBenefCuentaFamAhorro;
	private String apellidoMaternoBenefCuentaFamAhorro;
	private String nombreBenefCuentaFamAhorro;
	private String rfcBenefCuentaFamAhorro;
	private String paisResidenciaBenefCuentaFamAhorro;
	private String estadoCivilBenefCuentaFamAhorro;
	private String fechaNacimientoBenefCuentaFamAhorro;
	private String parentescoBenefCuentaFamAhorro;
	private String nacionalidadBenefCuentaFamAhorro;
	private String porcentajeBenefCuentaFamAhorro;
	
	
	public int getIdCuentaFamAhorro() {
		return idCuentaFamAhorro;
	}
	public void setIdCuentaFamAhorro(int idCuentaFamAhorro) {
		this.idCuentaFamAhorro = idCuentaFamAhorro;
	}
	public String getPorcentajeBenefCuentaFamAhorro() {
		return porcentajeBenefCuentaFamAhorro;
	}
	public void setPorcentajeBenefCuentaFamAhorro(
			String porcentajeBenefCuentaFamAhorro) {
		this.porcentajeBenefCuentaFamAhorro = porcentajeBenefCuentaFamAhorro;
	}
	public int getIdBenefCuentaFamAhorro() {
		return idBenefCuentaFamAhorro;
	}
	public void setIdBenefCuentaFamAhorro(int idBenefCuentaFamAhorro) {
		this.idBenefCuentaFamAhorro = idBenefCuentaFamAhorro;
	}
	
	public String getOperadorBenefCuentaFamAhorro() {
		return operadorBenefCuentaFamAhorro;
	}
	public void setOperadorBenefCuentaFamAhorro(String operadorBenefCuentaFamAhorro) {
		this.operadorBenefCuentaFamAhorro = operadorBenefCuentaFamAhorro;
	}
	public String getApellidoPaternoBenefCuentaFamAhorro() {
		return apellidoPaternoBenefCuentaFamAhorro;
	}
	public void setApellidoPaternoBenefCuentaFamAhorro(
			String apellidoPaternoBenefCuentaFamAhorro) {
		this.apellidoPaternoBenefCuentaFamAhorro = apellidoPaternoBenefCuentaFamAhorro;
	}
	public String getApellidoMaternoBenefCuentaFamAhorro() {
		return apellidoMaternoBenefCuentaFamAhorro;
	}
	public void setApellidoMaternoBenefCuentaFamAhorro(
			String apellidoMaternoBenefCuentaFamAhorro) {
		this.apellidoMaternoBenefCuentaFamAhorro = apellidoMaternoBenefCuentaFamAhorro;
	}
	public String getNombreBenefCuentaFamAhorro() {
		return nombreBenefCuentaFamAhorro;
	}
	public void setNombreBenefCuentaFamAhorro(String nombreBenefCuentaFamAhorro) {
		this.nombreBenefCuentaFamAhorro = nombreBenefCuentaFamAhorro;
	}
	public String getRfcBenefCuentaFamAhorro() {
		return rfcBenefCuentaFamAhorro;
	}
	public void setRfcBenefCuentaFamAhorro(String rfcBenefCuentaFamAhorro) {
		this.rfcBenefCuentaFamAhorro = rfcBenefCuentaFamAhorro;
	}
	public String getPaisResidenciaBenefCuentaFamAhorro() {
		return paisResidenciaBenefCuentaFamAhorro;
	}
	public void setPaisResidenciaBenefCuentaFamAhorro(
			String paisResidenciaBenefCuentaFamAhorro) {
		this.paisResidenciaBenefCuentaFamAhorro = paisResidenciaBenefCuentaFamAhorro;
	}
	public String getEstadoCivilBenefCuentaFamAhorro() {
		return estadoCivilBenefCuentaFamAhorro;
	}
	public void setEstadoCivilBenefCuentaFamAhorro(
			String estadoCivilBenefCuentaFamAhorro) {
		this.estadoCivilBenefCuentaFamAhorro = estadoCivilBenefCuentaFamAhorro;
	}
	public String getFechaNacimientoBenefCuentaFamAhorro() {
		return fechaNacimientoBenefCuentaFamAhorro;
	}
	public void setFechaNacimientoBenefCuentaFamAhorro(
			String fechaNacimientoBenefCuentaFamAhorro) {
		this.fechaNacimientoBenefCuentaFamAhorro = fechaNacimientoBenefCuentaFamAhorro;
	}
	public String getParentescoBenefCuentaFamAhorro() {
		return parentescoBenefCuentaFamAhorro;
	}
	public void setParentescoBenefCuentaFamAhorro(
			String parentescoBenefCuentaFamAhorro) {
		this.parentescoBenefCuentaFamAhorro = parentescoBenefCuentaFamAhorro;
	}
	public String getNacionalidadBenefCuentaFamAhorro() {
		return nacionalidadBenefCuentaFamAhorro;
	}
	public void setNacionalidadBenefCuentaFamAhorro(
			String nacionalidadBenefCuentaFamAhorro) {
		this.nacionalidadBenefCuentaFamAhorro = nacionalidadBenefCuentaFamAhorro;
	}
	public BenefCuentaFamAhorro(){
		
	}
	
	public BenefCuentaFamAhorro(int idBenefCuentaFamAhorro, int idCuentaFamAhorro,			
			String operadorBenefCuentaFamAhorro,
			String apellidoPaternoBenefCuentaFamAhorro,
			String apellidoMaternoBenefCuentaFamAhorro,
			String nombreBenefCuentaFamAhorro, String rfcBenefCuentaFamAhorro,
			String paisResidenciaBenefCuentaFamAhorro,
			String estadoCivilBenefCuentaFamAhorro,
			String fechaNacimientoBenefCuentaFamAhorro,
			String parentescoBenefCuentaFamAhorro,
			String nacionalidadBenefCuentaFamAhorro, String porcentajeBenefCuentaFamAhorro) {
		super();
		this.idBenefCuentaFamAhorro = idBenefCuentaFamAhorro;	
		this.idCuentaFamAhorro = idCuentaFamAhorro;
		this.operadorBenefCuentaFamAhorro = operadorBenefCuentaFamAhorro;
		this.apellidoPaternoBenefCuentaFamAhorro = apellidoPaternoBenefCuentaFamAhorro;
		this.apellidoMaternoBenefCuentaFamAhorro = apellidoMaternoBenefCuentaFamAhorro;
		this.nombreBenefCuentaFamAhorro = nombreBenefCuentaFamAhorro;
		this.rfcBenefCuentaFamAhorro = rfcBenefCuentaFamAhorro;
		this.paisResidenciaBenefCuentaFamAhorro = paisResidenciaBenefCuentaFamAhorro;
		this.estadoCivilBenefCuentaFamAhorro = estadoCivilBenefCuentaFamAhorro;
		this.fechaNacimientoBenefCuentaFamAhorro = fechaNacimientoBenefCuentaFamAhorro;
		this.parentescoBenefCuentaFamAhorro = parentescoBenefCuentaFamAhorro;
		this.nacionalidadBenefCuentaFamAhorro = nacionalidadBenefCuentaFamAhorro;
		this.porcentajeBenefCuentaFamAhorro = porcentajeBenefCuentaFamAhorro;
	}
	
			
}
