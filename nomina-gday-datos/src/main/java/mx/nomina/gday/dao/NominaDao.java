package mx.nomina.gday.dao;

import mx.nomina.gday.modelo.Nomina;

public interface NominaDao {
	
	Nomina consultarNomina();
	Nomina crearNuevaNomina();
	Nomina ModificarNomina();
	Nomina ConsultarEmpleadosAsignados();
	Nomina SeleccionDeRazonSocial();
	Nomina AsignarEmpleado();
	Nomina DescargarEmpleadosPorNominaEnExcel();

}
