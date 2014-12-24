package mx.estrategas.fam.dao;

import java.util.List;

import mx.estrategas.fam.modelo.Escuela;

public interface EscuelaDao {	
	List<Escuela> obtenerEscuelas();
	void actualizarEscuela(Escuela escuela);	
	void guardarEscuela(Escuela escuela);
}
