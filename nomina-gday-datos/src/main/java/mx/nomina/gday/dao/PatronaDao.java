package mx.nomina.gday.dao;

import mx.nomina.gday.modelo.Patrona;

public interface PatronaDao {
	
	Patrona SeleccionDePatronas();
	Patrona AñadirEmpresaPatrona();
	Patrona EditarEmpresaPatrona();
}
