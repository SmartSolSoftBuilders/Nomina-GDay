package mx.nomina.gday.servicios;

import java.util.List;

import mx.nomina.gday.modelo.Grupo;

public interface GrupoServicio {

	public boolean agregarGrupo(Grupo grupo);
	public List<Grupo> obtenerGrupos(); 
	void actualizarGrupo(Grupo grupo);
	public Grupo obtenerGrupoById(int idGrupo);



}
