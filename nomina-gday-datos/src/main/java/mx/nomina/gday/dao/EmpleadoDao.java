package mx.nomina.gday.dao;

import java.util.List;

import mx.nomina.gday.modelo.Empleado;

public interface EmpleadoDao {

	public List<Empleado> obtenerEmpleados();
	public List<Empleado> obtenerEmpleadosByIdNomina(Integer idNomina);

}
