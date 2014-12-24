package mx.estrategas.fam.dao;

import java.util.List;

import mx.estrategas.fam.modelo.Municipio;

public interface MunicipioDao {	
	void guardarMunicipio(Municipio municipio);
	void actualizarMunicipio(Municipio municipio);	
	List<Municipio> obtenerMunicipios();	
}
