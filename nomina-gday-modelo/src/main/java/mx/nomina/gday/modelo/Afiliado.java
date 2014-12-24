package mx.nomina.gday.modelo;

import java.util.List;

public class Afiliado  {
	
	private int idAfiliado;
	private String nombreAfiliado;
	private String appPaternoAfiliado;
	private String appMaternoAfiliado;
	private String fechaNacimientoAfiliado;
	private String direccionAfiliado;
	private String coliniaAfiliado;
	private String cpAfiliado;
	private String entidadAfiliado;
	private String puestoAfiliado;
	private int antiguedadAfiliado;
	private String telParticularAfiliado;
	private String telCelularAfiliado;
	private String companiatelAfiliado;
	private String emailAfiliado;
	private String nacionalidadAfiliado;
	private String estadoCivilAfiliado;
	private String rfcAfiliado;	  	    	
	private String municipioAfiliado;
	private String nickAfiliado;
	//private CuentaFamAhorro cuentaFamAhorro;
	private boolean crediFam;
	private boolean famAhorro;
	private boolean inversionista;		
	

	public boolean getInversionista() {
		return inversionista;
	}

	public void setInversionista(boolean inversionista) {
		this.inversionista = inversionista;
	}

	public boolean getCrediFam() {
		return crediFam;
	}

	public void setCrediFam(boolean crediFam) {
		this.crediFam = crediFam;
	}

	public boolean getFamAhorro() {
		return famAhorro;
	}

	public void setFamAhorro(boolean famAhorro) {
		this.famAhorro = famAhorro;
	}

	public String getNickAfiliado() {
		return nickAfiliado;
	}

	public void setNickAfiliado(String nickAfiliado) {
		this.nickAfiliado = nickAfiliado;
	}

	public int getIdAfiliado() {
		return idAfiliado;
	}

	public void setIdAfiliado(int idAfiliado) {
		this.idAfiliado = idAfiliado;
	}
	
	public String getRfcAfiliado() {
		return rfcAfiliado;
	}

	public void setRfcAfiliado(String rfcAfiliado) {
		this.rfcAfiliado = rfcAfiliado;
	}

	public String getNacionalidadAfiliado() {
		return nacionalidadAfiliado;
	}	
	
	public void setNacionalidadAfiliado(String nacionalidadAfiliado) {
		this.nacionalidadAfiliado = nacionalidadAfiliado;
	}
	
	public String getEstadoCivilAfiliado() {
		return estadoCivilAfiliado;
	}

	public void setEstadoCivilAfiliado(String estadoCivilAfiliado) {
		this.estadoCivilAfiliado = estadoCivilAfiliado;
	}

	public String getNombreAfiliado() {
		return nombreAfiliado;
	}

	public void setNombreAfiliado(String nombreAfiliado) {
		this.nombreAfiliado = nombreAfiliado;
	}

	public String getAppPaternoAfiliado() {
		return appPaternoAfiliado;
	}

	public void setAppPaternoAfiliado(String appPaternoAfiliado) {
		this.appPaternoAfiliado = appPaternoAfiliado;
	}

	public String getAppMaternoAfiliado() {
		return appMaternoAfiliado;
	}

	public void setAppMaternoAfiliado(String appMaternoAfiliado) {
		this.appMaternoAfiliado = appMaternoAfiliado;
	}

	public String getFechaNacimientoAfiliado() {
		return fechaNacimientoAfiliado;
	}

	public void setFechaNacimientoAfiliado(String fechaNacimientoAfiliado) {
		this.fechaNacimientoAfiliado = fechaNacimientoAfiliado;
	}

	public String getDireccionAfiliado() {
		return direccionAfiliado;
	}

	public void setDireccionAfiliado(String direccionAfiliado) {
		this.direccionAfiliado = direccionAfiliado;
	}

	public String getColiniaAfiliado() {
		return coliniaAfiliado;
	}

	public void setColiniaAfiliado(String coliniaAfiliado) {
		this.coliniaAfiliado = coliniaAfiliado;
	}

	public String getCpAfiliado() {
		return cpAfiliado;
	}

	public void setCpAfiliado(String cpAfiliado) {
		this.cpAfiliado = cpAfiliado;
	}

	public String getEntidadAfiliado() {
		return entidadAfiliado;
	}

	public void setEntidadAfiliado(String entidadAfiliado) {
		this.entidadAfiliado = entidadAfiliado;
	}

	public String getPuestoAfiliado() {
		return puestoAfiliado;
	}

	public void setPuestoAfiliado(String puestoAfiliado) {
		this.puestoAfiliado = puestoAfiliado;
	}

	public int getAntiguedadAfiliado() {
		return antiguedadAfiliado;
	}

	public void setAntiguedadAfiliado(int antiguedadAfiliado) {
		this.antiguedadAfiliado = antiguedadAfiliado;
	}

	public String getTelParticularAfiliado() {
		return telParticularAfiliado;
	}

	public void setTelParticularAfiliado(String telParticularAfiliado) {
		this.telParticularAfiliado = telParticularAfiliado;
	}

	public String getTelCelularAfiliado() {
		return telCelularAfiliado;
	}

	public void setTelCelularAfiliado(String telCelularAfiliado) {
		this.telCelularAfiliado = telCelularAfiliado;
	}

	public String getCompaniatelAfiliado() {
		return companiatelAfiliado;
	}

	public void setCompaniatelAfiliado(String companiatelAfiliado) {
		this.companiatelAfiliado = companiatelAfiliado;
	}

	public String getEmailAfiliado() {
		return emailAfiliado;
	}

	public void setEmailAfiliado(String emailAfiliado) {
		this.emailAfiliado = emailAfiliado;
	}

	public String getMunicipioAfiliado() {
		return municipioAfiliado;
	}

	public void setMunicipioAfiliado(String municipioAfiliado) {
		this.municipioAfiliado = municipioAfiliado;
	}


	public Afiliado() {
    }

	public Afiliado(int idAfiliado, String appPaternoAfiliado,
			String appMaternoAfiliado, String fechaNacimientoAfiliado,
			String direccionAfiliado, String coliniaAfiliado,
			String cpAfiliado, String entidadAfiliado, String puestoAfiliado,
			int antiguedadAfiliado, String telParticularAfiliado,
			String telCelularAfiliado, String companiatelAfiliado,
			String emailAfiliado, String nacionalidadAfiliado, String estadoCivilAfiliado, String rfcAfiliado,
			String municipioAfiliado, String nickAfiliado,/* CuentaFamAhorro cuentaFamAhorro,*/ boolean crediFam, boolean famAhorro,
			boolean inversionista,String nombreAfiliado) {
		super();
		this.idAfiliado = idAfiliado;
		this.nacionalidadAfiliado=nacionalidadAfiliado;
		this.appPaternoAfiliado = appPaternoAfiliado;
		this.appMaternoAfiliado = appMaternoAfiliado;
		this.fechaNacimientoAfiliado = fechaNacimientoAfiliado;
		this.direccionAfiliado = direccionAfiliado;
		this.coliniaAfiliado = coliniaAfiliado;
		this.cpAfiliado = cpAfiliado;
		this.entidadAfiliado = entidadAfiliado;
		this.puestoAfiliado = puestoAfiliado;
		this.antiguedadAfiliado = antiguedadAfiliado;
		this.telParticularAfiliado = telParticularAfiliado;
		this.telCelularAfiliado = telCelularAfiliado;
		this.companiatelAfiliado = companiatelAfiliado;
		this.emailAfiliado = emailAfiliado;
		this.estadoCivilAfiliado = estadoCivilAfiliado;
		this.rfcAfiliado = rfcAfiliado;
		this.municipioAfiliado = municipioAfiliado;
		this.nickAfiliado=nickAfiliado;
		//this.cuentaFamAhorro=cuentaFamAhorro;
		this.crediFam=crediFam;
		this.famAhorro=famAhorro;
		this.inversionista=inversionista;
		this.nombreAfiliado=nombreAfiliado;
	}
 
/*	public CuentaFamAhorro getCuentaFamAhorro() {
		return cuentaFamAhorro;
	}

	public void setCuentaFamAhorro(CuentaFamAhorro cuentaFamAhorro) {
		this.cuentaFamAhorro = cuentaFamAhorro;
	}*/
		
}
