package mx.nomina.gday.modelo;

public class EmpleadoNomina {
	
			private Nomina nomina;
			private Empleado empleado;
			private Puesto puesto;
			private Departamento departamento;
			private Area area;
			private Proceso proceso;
			private String fechaIngreso; 
			private String estatus;
			private String tipoSalario;
			private String fechaBaja;
			private String loteMovImssAlta;
			private String fechaVencimiento;
			private double sueldoMensual;
			private double salarioDiarioInt;
			private String plazaTrabajo;
			private String numeroTrabajadorCliente;
			private boolean otroPatron;
			private String rfcOtroPatron;
			private String nombreOtroPatron;
			private boolean permanencia;
			private String calle;
			private String numExterior;
			private String numInterior;
			private String colonia;
			private String codigoPostal;
			private String municipioDel;
			private String entFederativa;
			private int loteMovImssBaja;
			private boolean aplicaFiniquito;
			private double montoFiniquito;
			
			public EmpleadoNomina(){
				
			}

			public EmpleadoNomina(Nomina nomina, Empleado empleado,
					Puesto puesto, Departamento departamento, Area area,
					Proceso proceso, String fechaIngreso, String estatus,
					String tipoSalario, String fechaBaja,
					String loteMovImssAlta, String fechaVencimiento,
					double sueldoMensual, double salarioDiarioInt,
					String plazaTrabajo, String numeroTrabajadorCliente,
					boolean otroPatron, String rfcOtroPatron,
					String nombreOtroPatron, boolean permanencia, String calle,
					String numExterior, String numInterior, String colonia,
					String codigoPostal, String municipioDel,
					String entFederativa, int loteMovImssBaja,
					boolean aplicaFiniquito, double montoFiniquito) {
				super();
				this.nomina = nomina;
				this.empleado = empleado;
				this.puesto = puesto;
				this.departamento = departamento;
				this.area = area;
				this.proceso = proceso;
				this.fechaIngreso = fechaIngreso;
				this.estatus = estatus;
				this.tipoSalario = tipoSalario;
				this.fechaBaja = fechaBaja;
				this.loteMovImssAlta = loteMovImssAlta;
				this.fechaVencimiento = fechaVencimiento;
				this.sueldoMensual = sueldoMensual;
				this.salarioDiarioInt = salarioDiarioInt;
				this.plazaTrabajo = plazaTrabajo;
				this.numeroTrabajadorCliente = numeroTrabajadorCliente;
				this.otroPatron = otroPatron;
				this.rfcOtroPatron = rfcOtroPatron;
				this.nombreOtroPatron = nombreOtroPatron;
				this.permanencia = permanencia;
				this.calle = calle;
				this.numExterior = numExterior;
				this.numInterior = numInterior;
				this.colonia = colonia;
				this.codigoPostal = codigoPostal;
				this.municipioDel = municipioDel;
				this.entFederativa = entFederativa;
				this.loteMovImssBaja = loteMovImssBaja;
				this.aplicaFiniquito = aplicaFiniquito;
				this.montoFiniquito = montoFiniquito;
			}

			public Nomina getNomina() {
				return nomina;
			}

			public void setNomina(Nomina nomina) {
				this.nomina = nomina;
			}

			public Empleado getEmpleado() {
				return empleado;
			}

			public void setEmpleado(Empleado empleado) {
				this.empleado = empleado;
			}

			public Puesto getPuesto() {
				return puesto;
			}

			public void setPuesto(Puesto puesto) {
				this.puesto = puesto;
			}

			public Departamento getDepartamento() {
				return departamento;
			}

			public void setDepartamento(Departamento departamento) {
				this.departamento = departamento;
			}

			public Area getArea() {
				return area;
			}

			public void setArea(Area area) {
				this.area = area;
			}

			public Proceso getProceso() {
				return proceso;
			}

			public void setProceso(Proceso proceso) {
				this.proceso = proceso;
			}

			public String getFechaIngreso() {
				return fechaIngreso;
			}

			public void setFechaIngreso(String fechaIngreso) {
				this.fechaIngreso = fechaIngreso;
			}

			public String getEstatus() {
				return estatus;
			}

			public void setEstatus(String estatus) {
				this.estatus = estatus;
			}

			public String getTipoSalario() {
				return tipoSalario;
			}

			public void setTipoSalario(String tipoSalario) {
				this.tipoSalario = tipoSalario;
			}

			public String getFechaBaja() {
				return fechaBaja;
			}

			public void setFechaBaja(String fechaBaja) {
				this.fechaBaja = fechaBaja;
			}

			public String getLoteMovImssAlta() {
				return loteMovImssAlta;
			}

			public void setLoteMovImssAlta(String loteMovImssAlta) {
				this.loteMovImssAlta = loteMovImssAlta;
			}

			public String getFechaVencimiento() {
				return fechaVencimiento;
			}

			public void setFechaVencimiento(String fechaVencimiento) {
				this.fechaVencimiento = fechaVencimiento;
			}

			public double getSueldoMensual() {
				return sueldoMensual;
			}

			public void setSueldoMensual(double sueldoMensual) {
				this.sueldoMensual = sueldoMensual;
			}

			public double getSalarioDiarioInt() {
				return salarioDiarioInt;
			}

			public void setSalarioDiarioInt(double salarioDiarioInt) {
				this.salarioDiarioInt = salarioDiarioInt;
			}

			public String getPlazaTrabajo() {
				return plazaTrabajo;
			}

			public void setPlazaTrabajo(String plazaTrabajo) {
				this.plazaTrabajo = plazaTrabajo;
			}

			public String getNumeroTrabajadorCliente() {
				return numeroTrabajadorCliente;
			}

			public void setNumeroTrabajadorCliente(String numeroTrabajadorCliente) {
				this.numeroTrabajadorCliente = numeroTrabajadorCliente;
			}

			public boolean isOtroPatron() {
				return otroPatron;
			}

			public void setOtroPatron(boolean otroPatron) {
				this.otroPatron = otroPatron;
			}

			public String getRfcOtroPatron() {
				return rfcOtroPatron;
			}

			public void setRfcOtroPatron(String rfcOtroPatron) {
				this.rfcOtroPatron = rfcOtroPatron;
			}

			public String getNombreOtroPatron() {
				return nombreOtroPatron;
			}

			public void setNombreOtroPatron(String nombreOtroPatron) {
				this.nombreOtroPatron = nombreOtroPatron;
			}

			public boolean isPermanencia() {
				return permanencia;
			}

			public void setPermanencia(boolean permanencia) {
				this.permanencia = permanencia;
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

			public String getCodigoPostal() {
				return codigoPostal;
			}

			public void setCodigoPostal(String codigoPostal) {
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

			public int getLoteMovImssBaja() {
				return loteMovImssBaja;
			}

			public void setLoteMovImssBaja(int loteMovImssBaja) {
				this.loteMovImssBaja = loteMovImssBaja;
			}

			public boolean isAplicaFiniquito() {
				return aplicaFiniquito;
			}

			public void setAplicaFiniquito(boolean aplicaFiniquito) {
				this.aplicaFiniquito = aplicaFiniquito;
			}

			public double getMontoFiniquito() {
				return montoFiniquito;
			}

			public void setMontoFiniquito(double montoFiniquito) {
				this.montoFiniquito = montoFiniquito;
			}			
			
			

}
