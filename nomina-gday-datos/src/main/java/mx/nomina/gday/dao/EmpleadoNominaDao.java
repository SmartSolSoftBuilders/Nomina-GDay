package mx.nomina.gday.dao;

import mx.nomina.gday.modelo.EmpleadoNomina;

public interface EmpleadoNominaDao {
	public int agregarEmpleadoNomina(EmpleadoNomina empleadoNomina);
	EmpleadoNomina AñadirEmpleadoNomina();
	EmpleadoNomina BajaEmpleadoEnNomina();
	EmpleadoNomina ModficarDatosEnNomina();
	EmpleadoNomina AltaMasivaDeEmpleados();
	EmpleadoNomina RevertirUltimaAltaMasivaDeEmpleados();
	EmpleadoNomina DescargarEnExcel();
	public EmpleadoNomina obtenerEmpleadoNominaByIdNominaEmpleado(EmpleadoNomina empleadoNomina);
	public int actualizarEmpleadoNomina(EmpleadoNomina empleadoNomina);
	public int darBajaEmpleadoNomina(EmpleadoNomina empleadoNomina);
	public int eliminarEmpleadoNominayEmpleado(int id);
}
