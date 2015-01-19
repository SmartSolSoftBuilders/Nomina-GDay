package mx.nomina.gday.modelo;

import java.util.List;

public class RazonSocial extends BaseModelo{
	
	private int idRazonSocial;
	private Grupo grupo;
	private String nombreRazonSocial;
	private String rfc;
	private String nombreCortoRazonS;
	private String codCliente;
	private float comision;
	private int actConstitutiva;
	private String fechaActConstitutiva;
	private String fechaInicioOperacion;
	private String paternoRepresentante;
	private String maternoRepresentante;
	private String nombresRepresentante;
	private String calleFiscal;
	private String coloniaFiscal;
	private String numExteriorFiscal;
	private String numInteriorFiscal;
	private float cpFiscal;
	private String municipioFiscal;
	private String estadoFiscal;
	private String regPublicoPropiedad;
	private String fechaRegPublicoPropiedad;
	private String contactoUnoNombre;
	private String contactoUnoTelefono;
	private String contactoUnoCorreo;
	private String contactoDosNombre;
	private String contactoDosTelefono;
	private String contactoDosCorreo;
	private String contactoTresNombre;
	private String contactoTresTelefono;
	private String contactoTresCorreo;
	private String objetoSocial;
	private List<Referenciante> referenciantes;
	private String jsonString;
	
	
	public String getJsonString() {
		return jsonString;
	}



	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}



	public RazonSocial(){
		
	}



	public RazonSocial(int idRazonSocial, Grupo grupo,
			String nombreRazonSocial, String rfc, String nombreCortoRazonS,
			String codCliente, float comision, int actConstitutiva,
			String fechaActConstitutiva, String fechaInicioOperacion,
			String paternoRepresentante, String maternoRepresentante,
			String nombresRepresentante, String calleFiscal,
			String coloniaFiscal, String numExteriorFiscal,
			String numInteriorFiscal, float cpFiscal, String municipioFiscal,
			String estadoFiscal, String regPublicoPropiedad,
			String fechaRegPublicoPropiedad, String contactoUnoNombre,
			String contactoUnoTelefono, String contactoUnoCorreo,
			String contactoDosNombre, String contactoDosTelefono,
			String contactoDosCorreo, String contactoTresNombre,
			String contactoTresTelefono, String contactoTresCorreo,
			String objetoSocial, List<Referenciante> referenciantes,
			String jsonString) {
		super();
		this.idRazonSocial = idRazonSocial;
		this.grupo = grupo;
		this.nombreRazonSocial = nombreRazonSocial;
		this.rfc = rfc;
		this.nombreCortoRazonS = nombreCortoRazonS;
		this.codCliente = codCliente;
		this.comision = comision;
		this.actConstitutiva = actConstitutiva;
		this.fechaActConstitutiva = fechaActConstitutiva;
		this.fechaInicioOperacion = fechaInicioOperacion;
		this.paternoRepresentante = paternoRepresentante;
		this.maternoRepresentante = maternoRepresentante;
		this.nombresRepresentante = nombresRepresentante;
		this.calleFiscal = calleFiscal;
		this.coloniaFiscal = coloniaFiscal;
		this.numExteriorFiscal = numExteriorFiscal;
		this.numInteriorFiscal = numInteriorFiscal;
		this.cpFiscal = cpFiscal;
		this.municipioFiscal = municipioFiscal;
		this.estadoFiscal = estadoFiscal;
		this.regPublicoPropiedad = regPublicoPropiedad;
		this.fechaRegPublicoPropiedad = fechaRegPublicoPropiedad;
		this.contactoUnoNombre = contactoUnoNombre;
		this.contactoUnoTelefono = contactoUnoTelefono;
		this.contactoUnoCorreo = contactoUnoCorreo;
		this.contactoDosNombre = contactoDosNombre;
		this.contactoDosTelefono = contactoDosTelefono;
		this.contactoDosCorreo = contactoDosCorreo;
		this.contactoTresNombre = contactoTresNombre;
		this.contactoTresTelefono = contactoTresTelefono;
		this.contactoTresCorreo = contactoTresCorreo;
		this.objetoSocial = objetoSocial;
		this.referenciantes = referenciantes;
		this.jsonString = jsonString;
	}



	public int getIdRazonSocial() {
		return idRazonSocial;
	}



	public void setIdRazonSocial(int idRazonSocial) {
		this.idRazonSocial = idRazonSocial;
	}



	public Grupo getGrupo() {
		return grupo;
	}



	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}



	public String getNombreRazonSocial() {
		return nombreRazonSocial;
	}



	public void setNombreRazonSocial(String nombreRazonSocial) {
		this.nombreRazonSocial = nombreRazonSocial;
	}



	public String getRfc() {
		return rfc;
	}



	public void setRfc(String rfc) {
		this.rfc = rfc;
	}



	public String getNombreCortoRazonS() {
		return nombreCortoRazonS;
	}



	public void setNombreCortoRazonS(String nombreCortoRazonS) {
		this.nombreCortoRazonS = nombreCortoRazonS;
	}



	public String getCodCliente() {
		return codCliente;
	}



	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}



	public float getComision() {
		return comision;
	}



	public void setComision(float comision) {
		this.comision = comision;
	}



	public int getActConstitutiva() {
		return actConstitutiva;
	}



	public void setActConstitutiva(int actConstitutiva) {
		this.actConstitutiva = actConstitutiva;
	}



	public String getFechaActConstitutiva() {
		return fechaActConstitutiva;
	}



	public void setFechaActConstitutiva(String fechaActConstitutiva) {
		this.fechaActConstitutiva = fechaActConstitutiva;
	}



	public String getFechaInicioOperacion() {
		return fechaInicioOperacion;
	}



	public void setFechaInicioOperacion(String fechaInicioOperacion) {
		this.fechaInicioOperacion = fechaInicioOperacion;
	}



	public String getPaternoRepresentante() {
		return paternoRepresentante;
	}



	public void setPaternoRepresentante(String paternoRepresentante) {
		this.paternoRepresentante = paternoRepresentante;
	}



	public String getMaternoRepresentante() {
		return maternoRepresentante;
	}



	public void setMaternoRepresentante(String maternoRepresentante) {
		this.maternoRepresentante = maternoRepresentante;
	}



	public String getNombresRepresentante() {
		return nombresRepresentante;
	}



	public void setNombresRepresentante(String nombresRepresentante) {
		this.nombresRepresentante = nombresRepresentante;
	}



	public String getCalleFiscal() {
		return calleFiscal;
	}



	public void setCalleFiscal(String calleFiscal) {
		this.calleFiscal = calleFiscal;
	}



	public String getColoniaFiscal() {
		return coloniaFiscal;
	}



	public void setColoniaFiscal(String coloniaFiscal) {
		this.coloniaFiscal = coloniaFiscal;
	}



	public String getNumExteriorFiscal() {
		return numExteriorFiscal;
	}



	public void setNumExteriorFiscal(String numExteriorFiscal) {
		this.numExteriorFiscal = numExteriorFiscal;
	}



	public String getNumInteriorFiscal() {
		return numInteriorFiscal;
	}



	public void setNumInteriorFiscal(String numInteriorFiscal) {
		this.numInteriorFiscal = numInteriorFiscal;
	}



	public float getCpFiscal() {
		return cpFiscal;
	}



	public void setCpFiscal(float cpFiscal) {
		this.cpFiscal = cpFiscal;
	}



	public String getMunicipioFiscal() {
		return municipioFiscal;
	}



	public void setMunicipioFiscal(String municipioFiscal) {
		this.municipioFiscal = municipioFiscal;
	}



	public String getEstadoFiscal() {
		return estadoFiscal;
	}



	public void setEstadoFiscal(String estadoFiscal) {
		this.estadoFiscal = estadoFiscal;
	}



	public String getRegPublicoPropiedad() {
		return regPublicoPropiedad;
	}



	public void setRegPublicoPropiedad(String regPublicoPropiedad) {
		this.regPublicoPropiedad = regPublicoPropiedad;
	}



	public String getFechaRegPublicoPropiedad() {
		return fechaRegPublicoPropiedad;
	}



	public void setFechaRegPublicoPropiedad(String fechaRegPublicoPropiedad) {
		this.fechaRegPublicoPropiedad = fechaRegPublicoPropiedad;
	}



	public String getContactoUnoNombre() {
		return contactoUnoNombre;
	}



	public void setContactoUnoNombre(String contactoUnoNombre) {
		this.contactoUnoNombre = contactoUnoNombre;
	}



	public String getContactoUnoTelefono() {
		return contactoUnoTelefono;
	}



	public void setContactoUnoTelefono(String contactoUnoTelefono) {
		this.contactoUnoTelefono = contactoUnoTelefono;
	}



	public String getContactoUnoCorreo() {
		return contactoUnoCorreo;
	}



	public void setContactoUnoCorreo(String contactoUnoCorreo) {
		this.contactoUnoCorreo = contactoUnoCorreo;
	}



	public String getContactoDosNombre() {
		return contactoDosNombre;
	}



	public void setContactoDosNombre(String contactoDosNombre) {
		this.contactoDosNombre = contactoDosNombre;
	}



	public String getContactoDosTelefono() {
		return contactoDosTelefono;
	}



	public void setContactoDosTelefono(String contactoDosTelefono) {
		this.contactoDosTelefono = contactoDosTelefono;
	}



	public String getContactoDosCorreo() {
		return contactoDosCorreo;
	}



	public void setContactoDosCorreo(String contactoDosCorreo) {
		this.contactoDosCorreo = contactoDosCorreo;
	}



	public String getContactoTresNombre() {
		return contactoTresNombre;
	}



	public void setContactoTresNombre(String contactoTresNombre) {
		this.contactoTresNombre = contactoTresNombre;
	}



	public String getContactoTresTelefono() {
		return contactoTresTelefono;
	}



	public void setContactoTresTelefono(String contactoTresTelefono) {
		this.contactoTresTelefono = contactoTresTelefono;
	}



	public String getContactoTresCorreo() {
		return contactoTresCorreo;
	}



	public void setContactoTresCorreo(String contactoTresCorreo) {
		this.contactoTresCorreo = contactoTresCorreo;
	}



	public String getObjetoSocial() {
		return objetoSocial;
	}



	public void setObjetoSocial(String objetoSocial) {
		this.objetoSocial = objetoSocial;
	}



	public List<Referenciante> getReferenciantes() {
		return referenciantes;
	}



	public void setReferenciantes(List<Referenciante> referenciantes) {
		this.referenciantes = referenciantes;
	}



}
