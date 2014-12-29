package mx.nomina.gday.modelo;

public class Patrona {
	
	private int idPatrona;
	private String razonSocial;
	private String nombreCorto;
	private boolean esIntermediaria;
	private String tipoRegimen;
	private int folioMercantil;
	private String calleFiscal;
	private String coloniaFiscal;
	private int numExteriorFiscal;
	private int numInteriorFiscal;
	private int cpFiscal;
	private String municipioFiscal;
	private String estadoFiscal;
	private int fiscalNumPago;
	private int telContacto;
	private String domVirtuales;
	private float actaNumero;
	private float actaNotaria;
	private String actaFecha;
	private float actaNotario;
	private String actaCiudad;
	private String actaEstado;
	
	
	public Patrona(){
	}
	
	
	public Patrona(int idPatrona, String razonSocial, String nombreCorto,
			boolean esIntermediaria, String tipoRegimen, int folioMercantil,
			String calleFiscal, String coloniaFiscal, int numExteriorFiscal,
			int numInteriorFiscal, int cpFiscal, String municipioFiscal,
			String estadoFiscal, int fiscalNumPago, int telContacto,
			String domVirtuales, float actaNumero, float actaNotaria,
			String actaFecha, float actaNotario, String actaCiudad,
			String actaEstado) {
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
		this.domVirtuales = domVirtuales;
		this.actaNumero = actaNumero;
		this.actaNotaria = actaNotaria;
		this.actaFecha = actaFecha;
		this.actaNotario = actaNotario;
		this.actaCiudad = actaCiudad;
		this.actaEstado = actaEstado;
	}
	
	
	public int getIdPatrona() {
		return idPatrona;
	}
	public void setIdPatrona(int idPatrona) {
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
	public int getFolioMercantil() {
		return folioMercantil;
	}
	public void setFolioMercantil(int folioMercantil) {
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
	public int getNumExteriorFiscal() {
		return numExteriorFiscal;
	}
	public void setNumExteriorFiscal(int numExteriorFiscal) {
		this.numExteriorFiscal = numExteriorFiscal;
	}
	public int getNumInteriorFiscal() {
		return numInteriorFiscal;
	}
	public void setNumInteriorFiscal(int numInteriorFiscal) {
		this.numInteriorFiscal = numInteriorFiscal;
	}
	public int getCpFiscal() {
		return cpFiscal;
	}
	public void setCpFiscal(int cpFiscal) {
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
	public int getFiscalNumPago() {
		return fiscalNumPago;
	}
	public void setFiscalNumPago(int fiscalNumPago) {
		this.fiscalNumPago = fiscalNumPago;
	}
	public int getTelContacto() {
		return telContacto;
	}
	public void setTelContacto(int telContacto) {
		this.telContacto = telContacto;
	}
	public String getDomVirtuales() {
		return domVirtuales;
	}
	public void setDomVirtuales(String domVirtuales) {
		this.domVirtuales = domVirtuales;
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
