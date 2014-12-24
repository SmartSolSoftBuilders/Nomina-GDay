package mx.estrategas.fam.servicios;

import java.util.List;

import mx.estrategas.fam.modelo.Escuela;
import mx.estrategas.fam.modelo.TipoEscuela;
 
public interface EscuelaServicio {	
	void guardarEscuela(Escuela escuela);
	void actualizarEscuela(Escuela escuela);	
	List<Escuela> obtenerEscuelas();
	List<TipoEscuela> obtenerTipoEscuelas();
}
