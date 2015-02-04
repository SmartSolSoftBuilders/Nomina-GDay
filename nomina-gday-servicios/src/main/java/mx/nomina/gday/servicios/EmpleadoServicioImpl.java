package mx.nomina.gday.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nomina.gday.dao.EmpleadoDao;
import mx.nomina.gday.dao.EmpleadoNominaDao;
import mx.nomina.gday.modelo.Empleado;
import mx.nomina.gday.modelo.EmpleadoNomina;

@Service
public class EmpleadoServicioImpl implements EmpleadoServicio{
	
	@Autowired
	private EmpleadoDao empleadoDao;

	@Autowired
	private EmpleadoNominaDao empleadoNominaDao;

	//Metodo para guardar Empleado
		@Override
	public int agregarEmpleado(Empleado empleado) {
		
		System.out.println("Agregando empleado service"+ empleado);
		int valor=this.empleadoDao.agregarEmpleado(empleado);
		System.out.println("VALOR DEL EMPLEADO OBTENIDO"+valor);
		return valor;
	}
		
		//Metodo para guardar Empleado
	@Override
	public int agregarEmpleadoNomina(EmpleadoNomina empleadoNomina) {			
		System.out.println("Agregando empleado service"+ empleadoNomina);
		int valor=this.empleadoNominaDao.agregarEmpleadoNomina(empleadoNomina);
		System.out.println("VALOR DEL EMPLEADO OBTENIDO"+valor);
		return valor;
	}		
	
	//Metodo que Modifica los datos de una Nomina
	@Override
	public void actualizarEmpleado(Empleado empleado) {
		
		this.empleadoDao.actualizarEmpleado(empleado);
	}
	
	
	
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


	//Metodo que obtiene un Empleado por idEmpleado
	@Override
	public Empleado obtenerEmpleadoById(int idEmpleado) {

		System.out.println("Servicio obtenerNominaById"+ idEmpleado);

		return this.empleadoDao.obtenerEmpleadoById(idEmpleado);
	}	
	
			
}
