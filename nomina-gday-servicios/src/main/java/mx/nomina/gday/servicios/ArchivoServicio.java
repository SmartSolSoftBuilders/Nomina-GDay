package mx.nomina.gday.servicios;

import java.util.List;

import mx.nomina.gday.modelo.Archivo;

public interface ArchivoServicio {

	public void agregarArchivo(Archivo archivo);
	public Archivo obtenerUltimaCargaArchivo();
	public int revertirCarga();
	public List<Archivo> obtenerCargaArchivos();

}
