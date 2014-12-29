package mx.nomina.gday.dao;

import mx.nomina.gday.modelo.EmpleadoNomina;

public interface EmpleadoNominaDao {

	EmpleadoNomina AñadirEmpleadoNomina();
	EmpleadoNomina BajaEmpleadoEnNomina();
	EmpleadoNomina ModficarDatosEnNomina();
	EmpleadoNomina AltaMasivaDeEmpleados();
	EmpleadoNomina RevertirUltimaAltaMasivaDeEmpleados();
	EmpleadoNomina DescargarEnExcel();
}
