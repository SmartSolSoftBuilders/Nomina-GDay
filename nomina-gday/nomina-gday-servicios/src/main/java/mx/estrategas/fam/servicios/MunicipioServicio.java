package mx.estrategas.fam.servicios;

import java.util.List;
import mx.estrategas.fam.modelo.Municipio;
 
public interface MunicipioServicio {	
	void guardarMunicipio(Municipio municipio);
	void actualizarMunicipio(Municipio municipio);	
	List<Municipio> obtenerMunicipios();
}
