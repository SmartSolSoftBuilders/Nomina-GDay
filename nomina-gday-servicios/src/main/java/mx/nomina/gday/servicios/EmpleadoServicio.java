package mx.nomina.gday.servicios;

import java.util.List;

import mx.nomina.gday.modelo.Empleado;

public interface EmpleadoServicio {

	public boolean agregarEmpleado(Empleado empleado);
	public List<Empleado> obtenerEmpleados();
	public List<Empleado> obtenerEmpleadosByIdNomina(Integer idNomina);

 
}
