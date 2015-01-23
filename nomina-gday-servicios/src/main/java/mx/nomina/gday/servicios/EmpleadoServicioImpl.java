package mx.nomina.gday.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nomina.gday.dao.EmpleadoDao;
import mx.nomina.gday.modelo.Empleado;
import mx.nomina.gday.modelo.Nomina;

@Service
public class EmpleadoServicioImpl implements EmpleadoServicio{
	
	@Autowired
	private EmpleadoDao empleadoDao;

	@Override
	public List<Empleado> obtenerEmpleados() {
		// TODO Auto-generated method stub
		return null;
	}

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
