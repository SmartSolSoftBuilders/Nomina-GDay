package mx.nomina.gday.servicios;

import java.util.List;


import mx.nomina.gday.modelo.Empleado;
import mx.nomina.gday.modelo.EmpleadoNomina;

public interface EmpleadoServicio {

	public int agregarEmpleado(Empleado empleado);
	public int agregarEmpleadoNomina(EmpleadoNomina empleadoNomina);
	void actualizarEmpleado(Empleado empleado);
	public Empleado obtenerEmpleadoById(int idEmpleado);
	public List<Empleado> obtenerEmpleados();
	public List<Empleado> obtenerEmpleadosByIdNomina(Integer idNomina);
	public EmpleadoNomina obtenerEmpleadoNominaByIds(EmpleadoNomina empleadoNomina);

 
}
