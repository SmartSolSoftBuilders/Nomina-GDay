package mx.nomina.gday.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.nomina.gday.dao.EmpleadoDao;
import mx.nomina.gday.modelo.Empleado;

public class EmpleadoServicioImpl implements EmpleadoServicio{
	
	@Autowired
	private EmpleadoDao empleadoDao;

	@Override
	public List<Empleado> obtenerEmpleados() {
		System.out.println("Empleado Service");
		try {
			 
				List<Empleado> tmp=this.empleadoDao.obtenerEmpleados();
				System.out.println("Lista de Empleados"+tmp.size());
					return tmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return null;
	}
	
}
