package mx.nomina.gday.dao;

import java.util.List;

import mx.nomina.gday.modelo.Grupo;

public interface GrupoDao {

	public int agregarGrupo(Grupo grupo);
	public List<Grupo> obtenerGrupos();

}
