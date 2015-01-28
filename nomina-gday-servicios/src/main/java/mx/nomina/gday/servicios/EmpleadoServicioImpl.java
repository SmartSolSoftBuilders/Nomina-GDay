package mx.nomina.gday.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nomina.gday.dao.EmpleadoDao;
import mx.nomina.gday.modelo.Empleado;

@Service
public class EmpleadoServicioImpl implements EmpleadoServicio{
	
	@Autowired
	private EmpleadoDao empleadoDao;
	
	//Metodo que obtiene una lista de Empleados
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

	//Metodo que obtiene una lista de empleado por idNomina
	@Override
	public List<Empleado> obtenerEmpleadosByIdNomina(Integer idNomina) {
		System.out.println("Nomina Service");
		try {
			 
				List<Empleado> tmp=this.empleadoDao.obtenerEmpleadosByIdNomina(idNomina);
				System.out.println("Lista de Empleados por Nomina"+tmp.size());
				return tmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
	
}
