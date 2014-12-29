package mx.nomina.gday.dao;

import mx.nomina.gday.modelo.AcumuladoPeriodo;

public interface AcumuladoPeriodoDao {

	AcumuladoPeriodo CargarArchivoNomina();
	AcumuladoPeriodo ConsultarArchivosNominaEnBaseDeDatos();
	AcumuladoPeriodo CambiarEstatusAcumulado();
}
