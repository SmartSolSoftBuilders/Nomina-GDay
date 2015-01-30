package mx.nomina.gday.dao;

import java.util.List;

import mx.nomina.gday.modelo.Empleado;


public interface EmpleadoDao {
	
	public int agregarEmpleado(Empleado empleado);
	public List<Empleado> obtenerEmpleados();
	public List<Empleado> obtenerEmpleadosByIdNomina(Integer idNomina);

}
