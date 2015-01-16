package mx.nomina.gday.dao;

import java.util.List;

import mx.nomina.gday.modelo.Grupo;
import mx.nomina.gday.modelo.Nomina;

public interface NominaDao {
	
	public int agregarNomina(Nomina nomina);
	void actualizarNomina(Nomina nomina);
	public Nomina obtenerNominaById(int id);
	public List<Nomina> obtenerNominas();
	public List<Nomina> obtenerNominasByIdRazonSocial(int id);
}
