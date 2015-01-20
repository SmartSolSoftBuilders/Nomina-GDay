package mx.nomina.gday.modelo;

public class Patrona extends BaseModelo{
	
	private Integer idPatrona;
	private String razonSocialPatrona;
	private String rfcPatrona;
	private String nombreCortoPatrona;
	private boolean esIntermediariaPatrona;
	private String tipoRegimenPatrona;
	private Integer folioMercantilPatrona;
	private String calleFiscalPatrona;
	private String coloniaFiscalPatrona;
	private Integer numExteriorFiscalPatrona;
	private Integer numInteriorFiscalPatrona;
	private Integer cpFiscalPatrona;
	private String municipioFiscalPatrona;
	private String estadoFiscalPatrona;
	private Integer fiscalNumPagoPatrona;
	private Integer telContactoPatrona;
	private float actaNumeroPatrona;
	private float actaNotariaPatrona;
	private String actaFechaPatrona;
	private float actaNotarioPatrona;
	private String actaCiudadPatrona;
	private String actaEstadoPatrona;
	
	
	public Patrona(){
	}


	public Patrona(Integer idPatrona, String razonSocialPatrona,
			String rfcPatrona, String nombreCortoPatrona,
			boolean esIntermediariaPatrona, String tipoRegimenPatrona,
			Integer folioMercantilPatrona, String calleFiscalPatrona,
			String coloniaFiscalPatrona, Integer numExteriorFiscalPatrona,
			Integer numInteriorFiscalPatrona, Integer cpFiscalPatrona,
			String municipioFiscalPatrona, String estadoFiscalPatrona,
			Integer fiscalNumPagoPatrona, Integer telContactoPatrona,
			float actaNumeroPatrona, float actaNotariaPatrona,
			String actaFechaPatrona, float actaNotarioPatrona,
			String actaCiudadPatrona, String actaEstadoPatrona) {
		super();
		this.idPatrona = idPatrona;
		this.razonSocialPatrona = razonSocialPatrona;
		this.rfcPatrona = rfcPatrona;
		this.nombreCortoPatrona = nombreCortoPatrona;
		this.esIntermediariaPatrona = esIntermediariaPatrona;
		this.tipoRegimenPatrona = tipoRegimenPatrona;
		this.folioMercantilPatrona = folioMercantilPatrona;
		this.calleFiscalPatrona = calleFiscalPatrona;
		this.coloniaFiscalPatrona = coloniaFiscalPatrona;
		this.numExteriorFiscalPatrona = numExteriorFiscalPatrona;
		this.numInteriorFiscalPatrona = numInteriorFiscalPatrona;
		this.cpFiscalPatrona = cpFiscalPatrona;
		this.municipioFiscalPatrona = municipioFiscalPatrona;
		this.estadoFiscalPatrona = estadoFiscalPatrona;
		this.fiscalNumPagoPatrona = fiscalNumPagoPatrona;
		this.telContactoPatrona = telContactoPatrona;
		this.actaNumeroPatrona = actaNumeroPatrona;
		this.actaNotariaPatrona = actaNotariaPatrona;
		this.actaFechaPatrona = actaFechaPatrona;
		this.actaNotarioPatrona = actaNotarioPatrona;
		this.actaCiudadPatrona = actaCiudadPatrona;
		this.actaEstadoPatrona = actaEstadoPatrona;
	}


	public Integer getIdPatrona() {
		return idPatrona;
	}


	public void setIdPatrona(Integer idPatrona) {
		this.idPatrona = idPatrona;
	}


	public String getRazonSocialPatrona() {
		return razonSocialPatrona;
	}


	public void setRazonSocialPatrona(String razonSocialPatrona) {
		this.razonSocialPatrona = razonSocialPatrona;
	}


	public String getRfcPatrona() {
		return rfcPatrona;
	}


	public void setRfcPatrona(String rfcPatrona) {
		this.rfcPatrona = rfcPatrona;
	}


	public String getNombreCortoPatrona() {
		return nombreCortoPatrona;
	}


	public void setNombreCortoPatrona(String nombreCortoPatrona) {
		this.nombreCortoPatrona = nombreCortoPatrona;
	}


	public boolean isEsIntermediariaPatrona() {
		return esIntermediariaPatrona;
	}


	public void setEsIntermediariaPatrona(boolean esIntermediariaPatrona) {
		this.esIntermediariaPatrona = esIntermediariaPatrona;
	}


	public String getTipoRegimenPatrona() {
		return tipoRegimenPatrona;
	}


	public void setTipoRegimenPatrona(String tipoRegimenPatrona) {
		this.tipoRegimenPatrona = tipoRegimenPatrona;
	}


	public Integer getFolioMercantilPatrona() {
		return folioMercantilPatrona;
	}


	public void setFolioMercantilPatrona(Integer folioMercantilPatrona) {
		this.folioMercantilPatrona = folioMercantilPatrona;
	}


	public String getCalleFiscalPatrona() {
		return calleFiscalPatrona;
	}


	public void setCalleFiscalPatrona(String calleFiscalPatrona) {
		this.calleFiscalPatrona = calleFiscalPatrona;
	}


	public String getColoniaFiscalPatrona() {
		return coloniaFiscalPatrona;
	}


	public void setColoniaFiscalPatrona(String coloniaFiscalPatrona) {
		this.coloniaFiscalPatrona = coloniaFiscalPatrona;
	}


	public Integer getNumExteriorFiscalPatrona() {
		return numExteriorFiscalPatrona;
	}


	public void setNumExteriorFiscalPatrona(Integer numExteriorFiscalPatrona) {
		this.numExteriorFiscalPatrona = numExteriorFiscalPatrona;
	}


	public Integer getNumInteriorFiscalPatrona() {
		return numInteriorFiscalPatrona;
	}


	public void setNumInteriorFiscalPatrona(Integer numInteriorFiscalPatrona) {
		this.numInteriorFiscalPatrona = numInteriorFiscalPatrona;
	}


	public Integer getCpFiscalPatrona() {
		return cpFiscalPatrona;
	}


	public void setCpFiscalPatrona(Integer cpFiscalPatrona) {
		this.cpFiscalPatrona = cpFiscalPatrona;
	}


	public String getMunicipioFiscalPatrona() {
		return municipioFiscalPatrona;
	}


	public void setMunicipioFiscalPatrona(String municipioFiscalPatrona) {
		this.municipioFiscalPatrona = municipioFiscalPatrona;
	}


	public String getEstadoFiscalPatrona() {
		return estadoFiscalPatrona;
	}


	public void setEstadoFiscalPatrona(String estadoFiscalPatrona) {
		this.estadoFiscalPatrona = estadoFiscalPatrona;
	}


	public Integer getFiscalNumPagoPatrona() {
		return fiscalNumPagoPatrona;
	}


	public void setFiscalNumPagoPatrona(Integer fiscalNumPagoPatrona) {
		this.fiscalNumPagoPatrona = fiscalNumPagoPatrona;
	}


	public Integer getTelContactoPatrona() {
		return telContactoPatrona;
	}


	public void setTelContactoPatrona(Integer telContactoPatrona) {
		this.telContactoPatrona = telContactoPatrona;
	}


	public float getActaNumeroPatrona() {
		return actaNumeroPatrona;
	}


	public void setActaNumeroPatrona(float actaNumeroPatrona) {
		this.actaNumeroPatrona = actaNumeroPatrona;
	}


	public float getActaNotariaPatrona() {
		return actaNotariaPatrona;
	}


	public void setActaNotariaPatrona(float actaNotariaPatrona) {
		this.actaNotariaPatrona = actaNotariaPatrona;
	}


	public String getActaFechaPatrona() {
		return actaFechaPatrona;
	}


	public void setActaFechaPatrona(String actaFechaPatrona) {
		this.actaFechaPatrona = actaFechaPatrona;
	}


	public float getActaNotarioPatrona() {
		return actaNotarioPatrona;
	}


	public void setActaNotarioPatrona(float actaNotarioPatrona) {
		this.actaNotarioPatrona = actaNotarioPatrona;
	}


	public String getActaCiudadPatrona() {
		return actaCiudadPatrona;
	}


	public void setActaCiudadPatrona(String actaCiudadPatrona) {
		this.actaCiudadPatrona = actaCiudadPatrona;
	}


	public String getActaEstadoPatrona() {
		return actaEstadoPatrona;
	}


	public void setActaEstadoPatrona(String actaEstadoPatrona) {
		this.actaEstadoPatrona = actaEstadoPatrona;
	}

}
