package mx.nomina.gday.dao;

import mx.nomina.gday.modelo.HojaTrabajo;

public interface TipoCalendarioDao {

	HojaTrabajo SeleccionarEmpresaNomina();
	HojaTrabajo AsignarHojaDeTrabajoaNomina();
	HojaTrabajo GenerarHojaDeTrabajo();
}
