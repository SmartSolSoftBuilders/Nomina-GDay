package mx.nomina.gday.dao;

import mx.nomina.gday.modelo.HojaTrabajo;

public interface HojaTrabajoDao {

	HojaTrabajo SeleccionarEmpresaNomina();
	HojaTrabajo AsignarHojaDeTrabajoaNomina();
	HojaTrabajo GenerarHojaDeTrabajo();
}
