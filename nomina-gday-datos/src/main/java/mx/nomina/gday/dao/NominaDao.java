package mx.nomina.gday.dao;

import java.util.List;

import mx.nomina.gday.modelo.Nomina;

public interface NominaDao {
	
	public int agregarNomina(Nomina nomina);
	void actualizarNomina(Nomina nomina);
	public Nomina obtenerNominaById(int id);
	public List<Nomina> obtenerNominas();
	public List<Nomina> obtenerNominasByNombre();
	public List<Nomina> obtenerNominasByIdRazonSocial(int id);
	public List<Nomina> obtenerNominasByIdEmpleado(Integer idEmpleado);
	public Nomina obtenerNominaByIdHojaTrabajo(Integer idHojaTrabajo);
	public List<Nomina> obtenerNominasByIdEjecutivo(Integer idEjecutivo);
	public List<String> obtenerNssByIdNomina(int idNomina);
	public List<String> obtenerCurpByIdNomina(int idNomina);
}
