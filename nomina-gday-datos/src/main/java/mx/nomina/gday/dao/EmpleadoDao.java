package mx.nomina.gday.dao;

import mx.nomina.gday.modelo.Empleado;

public interface EmpleadoDao {

	Empleado ConsultarEmpleado();
	Empleado CrearNuevoEmpleado();
	Empleado ModificarEmpleado();

}
