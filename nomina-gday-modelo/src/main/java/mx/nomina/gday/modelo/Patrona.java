package mx.nomina.gday.modelo;

public class Patrona extends BaseModelo{
	
	private Integer idPatrona;
	private String razonSocial;
	private String nombreCorto;
	private boolean esIntermediaria;
	private String tipoRegimen;
	private Integer folioMercantil;
	private String calleFiscal;
	private String coloniaFiscal;
	private Integer numExteriorFiscal;
	private Integer numInteriorFiscal;
	private Integer cpFiscal;
	private String municipioFiscal;
	private String estadoFiscal;
	private Integer fiscalNumPago;
	private Integer telContacto;
	private float actaNumero;
	private float actaNotaria;
	private String actaFecha;
	private float actaNotario;
	private String actaCiudad;
	private String actaEstado;
	
	
	public Patrona(){
	}


	public Patrona(Integer idPatrona, String razonSocial, String nombreCorto,
			boolean esIntermediaria, String tipoRegimen,
			Integer folioMercantil, String calleFiscal, String coloniaFiscal,
			Integer numExteriorFiscal, Integer numInteriorFiscal,
			Integer cpFiscal, String municipioFiscal, String estadoFiscal,
			Integer fiscalNumPago, Integer telContacto, float actaNumero,
			float actaNotaria, String actaFecha, float actaNotario,
			String actaCiudad, String actaEstado) {
		super();
		this.idPatrona = idPatrona;
		this.razonSocial = razonSocial;
		this.nombreCorto = nombreCorto;
		this.esIntermediaria = esIntermediaria;
		this.tipoRegimen = tipoRegimen;
		this.folioMercantil = folioMercantil;
		this.calleFiscal = calleFiscal;
		this.coloniaFiscal = coloniaFiscal;
		this.numExteriorFiscal = numExteriorFiscal;
		this.numInteriorFiscal = numInteriorFiscal;
		this.cpFiscal = cpFiscal;
		this.municipioFiscal = municipioFiscal;
		this.estadoFiscal = estadoFiscal;
		this.fiscalNumPago = fiscalNumPago;
		this.telContacto = telContacto;
		this.actaNumero = actaNumero;
		this.actaNotaria = actaNotaria;
		this.actaFecha = actaFecha;
		this.actaNotario = actaNotario;
		this.actaCiudad = actaCiudad;
		this.actaEstado = actaEstado;
	}


	public Integer getIdPatrona() {
		return idPatrona;
	}


	public void setIdPatrona(Integer idPatrona) {
		this.idPatrona = idPatrona;
	}


	public String getRazonSocial() {
		return razonSocial;
	}


	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}


	public String getNombreCorto() {
		return nombreCorto;
	}


	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}


	public boolean isEsIntermediaria() {
		return esIntermediaria;
	}


	public void setEsIntermediaria(boolean esIntermediaria) {
		this.esIntermediaria = esIntermediaria;
	}


	public String getTipoRegimen() {
		return tipoRegimen;
	}


	public void setTipoRegimen(String tipoRegimen) {
		this.tipoRegimen = tipoRegimen;
	}


	public Integer getFolioMercantil() {
		return folioMercantil;
	}


	public void setFolioMercantil(Integer folioMercantil) {
		this.folioMercantil = folioMercantil;
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


	public Integer getNumExteriorFiscal() {
		return numExteriorFiscal;
	}


	public void setNumExteriorFiscal(Integer numExteriorFiscal) {
		this.numExteriorFiscal = numExteriorFiscal;
	}


	public Integer getNumInteriorFiscal() {
		return numInteriorFiscal;
	}


	public void setNumInteriorFiscal(Integer numInteriorFiscal) {
		this.numInteriorFiscal = numInteriorFiscal;
	}


	public Integer getCpFiscal() {
		return cpFiscal;
	}


	public void setCpFiscal(Integer cpFiscal) {
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


	public Integer getFiscalNumPago() {
		return fiscalNumPago;
	}


	public void setFiscalNumPago(Integer fiscalNumPago) {
		this.fiscalNumPago = fiscalNumPago;
	}


	public Integer getTelContacto() {
		return telContacto;
	}


	public void setTelContacto(Integer telContacto) {
		this.telContacto = telContacto;
	}


	public float getActaNumero() {
		return actaNumero;
	}


	public void setActaNumero(float actaNumero) {
		this.actaNumero = actaNumero;
	}


	public float getActaNotaria() {
		return actaNotaria;
	}


	public void setActaNotaria(float actaNotaria) {
		this.actaNotaria = actaNotaria;
	}


	public String getActaFecha() {
		return actaFecha;
	}


	public void setActaFecha(String actaFecha) {
		this.actaFecha = actaFecha;
	}


	public float getActaNotario() {
		return actaNotario;
	}


	public void setActaNotario(float actaNotario) {
		this.actaNotario = actaNotario;
	}


	public String getActaCiudad() {
		return actaCiudad;
	}


	public void setActaCiudad(String actaCiudad) {
		this.actaCiudad = actaCiudad;
	}


	public String getActaEstado() {
		return actaEstado;
	}


	public void setActaEstado(String actaEstado) {
		this.actaEstado = actaEstado;
	}		

}
