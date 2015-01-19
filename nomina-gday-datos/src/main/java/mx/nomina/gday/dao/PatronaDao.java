package mx.nomina.gday.dao;

import java.util.List;

import mx.nomina.gday.modelo.Patrona;

public interface PatronaDao {
	
	Patrona SeleccionDePatronas();
	Patrona AñadirEmpresaPatrona();
	Patrona EditarEmpresaPatrona();
	List<Patrona> obtenerPatronas();
}
