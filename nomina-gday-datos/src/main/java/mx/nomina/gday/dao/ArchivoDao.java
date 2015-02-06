package mx.nomina.gday.dao;

import mx.nomina.gday.modelo.Archivo;

public interface ArchivoDao {

	public void agregarArchivo(Archivo archivo);
	public Archivo obtenerUltimaCargaArchivo();
}
