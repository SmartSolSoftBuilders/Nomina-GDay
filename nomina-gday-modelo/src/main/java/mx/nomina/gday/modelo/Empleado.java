package mx.nomina.gday.modelo;

public class Empleado extends BaseModelo{

	private Integer idEmpleado;
	private String noControl;
	private String nss;
	private String curp;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombre;
	private String rfc;
	private String fechaNacimiento;
	private Integer edad;
	private String sexo;
	private String paisOrigen;
	private String nacionalidad;
	private String estadoCivil;
	private String correoElectronico;
	private String fechaIngresoReal;
	private boolean listaNegra;
	private String calle;
	private String numExterior;
	private String numInterior;
	private String colonia;
	private Integer codigoPostal;
	private String municipioDel;
	private String entFederativa;
	private boolean docIfe;
	private boolean docActNan;
	private boolean  docCurp;
	private boolean docRfc;
	private boolean docComprobante;
	private boolean docCompEst;
	private boolean docCorreo;
	private boolean docClabe;
	private boolean docPreafiliacion;
	private String cuenta;
	private String banco;
	private String tipoPago;
	private String noCredInfonavit;
	private double descInfonavitVsmg;
	private double desInfonavitPorc;
	private double descInfonavitImp;
	private double descFonacotNum;
	private double descFonacotPago;
	private double  pensionAlimImp;
	private double pensionAlimPorc;
	private String pensionAlimAcred;
	private String pensionAlimObs;
	
	public Empleado(){
		
	}

	public Empleado(Integer idEmpleado, String noControl, String nss,
			String curp, String apellidoPaterno, String apellidoMaterno,
			String nombre, String rfc, String fechaNacimiento, Integer edad,
			String sexo, String paisOrigen, String nacionalidad,
			String estadoCivil, String correoElectronico,
			String fechaIngresoReal, boolean listaNegra, String calle,
			String numExterior, String numInterior, String colonia,
			Integer codigoPostal, String municipioDel, String entFederativa,
			boolean docIfe, boolean docActNan, boolean docCurp, boolean docRfc,
			boolean docComprobante, boolean docCompEst, boolean docCorreo,
			boolean docClabe, boolean docPreafiliacion, String cuenta,
			String banco, String tipoPago, String noCredInfonavit,
			double descInfonavitVsmg, double desInfonavitPorc,
			double descInfonavitImp, double descFonacotNum,
			double descFonacotPago, double pensionAlimImp,
			double pensionAlimPorc, String pensionAlimAcred,
			String pensionAlimObs) {
		super();
		this.idEmpleado = idEmpleado;
		this.noControl = noControl;
		this.nss = nss;
		this.curp = curp;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombre = nombre;
		this.rfc = rfc;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.sexo = sexo;
		this.paisOrigen = paisOrigen;
		this.nacionalidad = nacionalidad;
		this.estadoCivil = estadoCivil;
		this.correoElectronico = correoElectronico;
		this.fechaIngresoReal = fechaIngresoReal;
		this.listaNegra = listaNegra;
		this.calle = calle;
		this.numExterior = numExterior;
		this.numInterior = numInterior;
		this.colonia = colonia;
		this.codigoPostal = codigoPostal;
		this.municipioDel = municipioDel;
		this.entFederativa = entFederativa;
		this.docIfe = docIfe;
		this.docActNan = docActNan;
		this.docCurp = docCurp;
		this.docRfc = docRfc;
		this.docComprobante = docComprobante;
		this.docCompEst = docCompEst;
		this.docCorreo = docCorreo;
		this.docClabe = docClabe;
		this.docPreafiliacion = docPreafiliacion;
		this.cuenta = cuenta;
		this.banco = banco;
		this.tipoPago = tipoPago;
		this.noCredInfonavit = noCredInfonavit;
		this.descInfonavitVsmg = descInfonavitVsmg;
		this.desInfonavitPorc = desInfonavitPorc;
		this.descInfonavitImp = descInfonavitImp;
		this.descFonacotNum = descFonacotNum;
		this.descFonacotPago = descFonacotPago;
		this.pensionAlimImp = pensionAlimImp;
		this.pensionAlimPorc = pensionAlimPorc;
		this.pensionAlimAcred = pensionAlimAcred;
		this.pensionAlimObs = pensionAlimObs;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNoControl() {
		return noControl;
	}

	public void setNoControl(String noControl) {
		this.noControl = noControl;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getFechaIngresoReal() {
		return fechaIngresoReal;
	}

	public void setFechaIngresoReal(String fechaIngresoReal) {
		this.fechaIngresoReal = fechaIngresoReal;
	}

	public boolean isListaNegra() {
		return listaNegra;
	}

	public void setListaNegra(boolean listaNegra) {
		this.listaNegra = listaNegra;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumExterior() {
		return numExterior;
	}

	public void setNumExterior(String numExterior) {
		this.numExterior = numExterior;
	}

	public String getNumInterior() {
		return numInterior;
	}

	public void setNumInterior(String numInterior) {
		this.numInterior = numInterior;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getMunicipioDel() {
		return municipioDel;
	}

	public void setMunicipioDel(String municipioDel) {
		this.municipioDel = municipioDel;
	}

	public String getEntFederativa() {
		return entFederativa;
	}

	public void setEntFederativa(String entFederativa) {
		this.entFederativa = entFederativa;
	}

	public boolean isDocIfe() {
		return docIfe;
	}

	public void setDocIfe(boolean docIfe) {
		this.docIfe = docIfe;
	}

	public boolean isDocActNan() {
		return docActNan;
	}

	public void setDocActNan(boolean docActNan) {
		this.docActNan = docActNan;
	}

	public boolean isDocCurp() {
		return docCurp;
	}

	public void setDocCurp(boolean docCurp) {
		this.docCurp = docCurp;
	}

	public boolean isDocRfc() {
		return docRfc;
	}

	public void setDocRfc(boolean docRfc) {
		this.docRfc = docRfc;
	}

	public boolean isDocComprobante() {
		return docComprobante;
	}

	public void setDocComprobante(boolean docComprobante) {
		this.docComprobante = docComprobante;
	}

	public boolean isDocCompEst() {
		return docCompEst;
	}

	public void setDocCompEst(boolean docCompEst) {
		this.docCompEst = docCompEst;
	}

	public boolean isDocCorreo() {
		return docCorreo;
	}

	public void setDocCorreo(boolean docCorreo) {
		this.docCorreo = docCorreo;
	}

	public boolean isDocClabe() {
		return docClabe;
	}

	public void setDocClabe(boolean docClabe) {
		this.docClabe = docClabe;
	}

	public boolean isDocPreafiliacion() {
		return docPreafiliacion;
	}

	public void setDocPreafiliacion(boolean docPreafiliacion) {
		this.docPreafiliacion = docPreafiliacion;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getNoCredInfonavit() {
		return noCredInfonavit;
	}

	public void setNoCredInfonavit(String noCredInfonavit) {
		this.noCredInfonavit = noCredInfonavit;
	}

	public double getDescInfonavitVsmg() {
		return descInfonavitVsmg;
	}

	public void setDescInfonavitVsmg(double descInfonavitVsmg) {
		this.descInfonavitVsmg = descInfonavitVsmg;
	}

	public double getDesInfonavitPorc() {
		return desInfonavitPorc;
	}

	public void setDesInfonavitPorc(double desInfonavitPorc) {
		this.desInfonavitPorc = desInfonavitPorc;
	}

	public double getDescInfonavitImp() {
		return descInfonavitImp;
	}

	public void setDescInfonavitImp(double descInfonavitImp) {
		this.descInfonavitImp = descInfonavitImp;
	}

	public double getDescFonacotNum() {
		return descFonacotNum;
	}

	public void setDescFonacotNum(double descFonacotNum) {
		this.descFonacotNum = descFonacotNum;
	}

	public double getDescFonacotPago() {
		return descFonacotPago;
	}

	public void setDescFonacotPago(double descFonacotPago) {
		this.descFonacotPago = descFonacotPago;
	}

	public double getPensionAlimImp() {
		return pensionAlimImp;
	}

	public void setPensionAlimImp(double pensionAlimImp) {
		this.pensionAlimImp = pensionAlimImp;
	}

	public double getPensionAlimPorc() {
		return pensionAlimPorc;
	}

	public void setPensionAlimPorc(double pensionAlimPorc) {
		this.pensionAlimPorc = pensionAlimPorc;
	}

	public String getPensionAlimAcred() {
		return pensionAlimAcred;
	}

	public void setPensionAlimAcred(String pensionAlimAcred) {
		this.pensionAlimAcred = pensionAlimAcred;
	}

	public String getPensionAlimObs() {
		return pensionAlimObs;
	}

	public void setPensionAlimObs(String pensionAlimObs) {
		this.pensionAlimObs = pensionAlimObs;
	}
	
}
