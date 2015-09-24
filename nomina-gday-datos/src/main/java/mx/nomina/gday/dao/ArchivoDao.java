package mx.nomina.gday.dao;

import java.util.List;

import mx.nomina.gday.modelo.Archivo;

public interface ArchivoDao {

	public void agregarArchivo(Archivo archivo);
	public void updateArchivo(Archivo archivo);
	public Archivo obtenerUltimaCargaArchivo();
	public List<Archivo> obtenerCargaArchivos();
}
