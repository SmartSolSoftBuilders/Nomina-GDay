package mx.nomina.gday.dao;

import java.util.List;

import mx.nomina.gday.modelo.Empleado;


public interface EmpleadoDao {
	
	public int agregarEmpleado(Empleado empleado);
	void actualizarEmpleado(Empleado empleado);
	public Empleado obtenerEmpleadoById(int id);
	public List<Empleado> obtenerEmpleados();
	public List<Empleado> obtenerEmpleadosByIdNomina(Integer idNomina);
	int obtenerCountIdEmpleadoByNss(String nssEmpleado);
	public Empleado obtenerIdEmpleadoByCurp(Empleado empleado);
	public Empleado obtenerIdEmpleadoByNss(Empleado empleado);
}
