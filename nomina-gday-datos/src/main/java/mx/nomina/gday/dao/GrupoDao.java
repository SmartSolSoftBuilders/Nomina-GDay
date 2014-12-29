package mx.nomina.gday.dao;

import mx.nomina.gday.modelo.Grupo;

public interface GrupoDao {

	Grupo SeleccionDeGrupos();
	Grupo AñadirGrupos();
	Grupo EditarGrupos();
}
