package mx.nomina.gday.dao;

import java.util.List;

import mx.nomina.gday.modelo.Empleado;

public interface EmpleadoDao {

	Empleado ConsultarEmpleado();
	Empleado CrearNuevoEmpleado();
	Empleado ModificarEmpleado();
	public List <Empleado> obtenerEmpleadosByIdNomina(Integer idNomina);

}
