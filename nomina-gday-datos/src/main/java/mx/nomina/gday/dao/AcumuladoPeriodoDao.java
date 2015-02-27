package mx.nomina.gday.dao;


import java.util.List;

import mx.nomina.gday.modelo.AcumuladoPeriodo;


public interface AcumuladoPeriodoDao {

	public void agregarArchivo(AcumuladoPeriodo acumuladoPeriodo);
	List<AcumuladoPeriodo> obtenerAcumuladosByIdNominaAndIdPeriodo(AcumuladoPeriodo acumuladoPeriodo);
	public AcumuladoPeriodo obtenerAcumuladosById(Integer idAcumuladoPeriodo);

	


}
