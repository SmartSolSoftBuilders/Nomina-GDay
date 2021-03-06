package mx.nomina.gday.dao;

import java.util.List;

import mx.nomina.gday.modelo.Ejecutivo;


public interface EjecutivoDao {
	
	public List<Ejecutivo> obtenerEjecutivos();
	public int agregarEjecutivo(Ejecutivo ejecutivo);
	void actualizarEjecutivo(Ejecutivo ejecutivo);
	public Ejecutivo obtenerEjecutivoById(int id);


}
