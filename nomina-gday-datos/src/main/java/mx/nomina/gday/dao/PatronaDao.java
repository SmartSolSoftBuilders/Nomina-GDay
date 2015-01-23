package mx.nomina.gday.dao;

import java.util.List;

import mx.nomina.gday.modelo.Patrona;

public interface PatronaDao {
	
	public int agregarPatrona(Patrona patrona);
	public List<Patrona> obtenerPatronas();
	void actualizarPatrona(Patrona patrona);
	public Patrona obtenerPatronaById(int id);
	public List<Patrona> obtenerPatronasIntermediarias();
}

