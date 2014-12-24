package mx.estrategas.fam.dao;

import java.util.List;

import mx.estrategas.fam.modelo.Archivo;

public interface ArchivoDao {	
	void guardarArchivo(Archivo archivo);
	List<Archivo> obtenerArchivos();	
}
