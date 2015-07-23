package mx.nomina.gday.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nomina.gday.dao.AreaDao;
import mx.nomina.gday.dao.DepartamentoDao;
import mx.nomina.gday.dao.EmpleadoDao;
import mx.nomina.gday.dao.EmpleadoNominaDao;
import mx.nomina.gday.dao.ProcesoDao;
import mx.nomina.gday.dao.PuestoDao;
import mx.nomina.gday.modelo.Empleado;
import mx.nomina.gday.modelo.EmpleadoNomina;

@Service
public class EmpleadoServicioImpl implements EmpleadoServicio{
	
	@Autowired
	private EmpleadoDao empleadoDao;

	@Autowired
	private EmpleadoNominaDao empleadoNominaDao;
	
	@Autowired
	private AreaDao areaDao;
	
	@Autowired
	private PuestoDao puestoDao;
	
	@Autowired
	private ProcesoDao procesoDao;
	
	@Autowired
	private DepartamentoDao departamentoDao;

	//Metodo para guardar Empleado
		@Override
	public int agregarEmpleado(Empleado empleado) {
		
		System.out.println("Agregando empleado service"+ empleado);
		int valor=this.empleadoDao.agregarEmpleado(empleado);
		valor=Integer.parseInt(""+empleado.getId());
		System.out.println("VALOR DEL EMPLEADO OBTENIDO:"+valor);
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
	
	@Override
	public int darBajaEmpleadoNomina(EmpleadoNomina empleadoNomina) {			
		System.out.println("Agregando empleado service"+ empleadoNomina);
		int valor=this.empleadoNominaDao.darBajaEmpleadoNomina(empleadoNomina);
		System.out.println("VALOR DEL EMPLEADO OBTENIDO"+valor);
		return valor;
	}		
	
	@Override
	public int actualizarEmpleadoNomina(EmpleadoNomina empleadoNomina) {			
		System.out.println("Actualizando empleado service"+ empleadoNomina.getNomina().getIdNomina());
		System.out.println("Actualizando empleado service"+ empleadoNomina.getEmpleado().getIdEmpleado());
		System.out.println(empleadoNomina.getSalarioDiarioInt()+"-"+empleadoNomina.getSueldoDiario()+"-"+empleadoNomina.getSueldoMensual());
		int valor=this.empleadoNominaDao.actualizarEmpleadoNomina(empleadoNomina);
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
	
			
	@Override
	public EmpleadoNomina obtenerEmpleadoNominaByIds(
			EmpleadoNomina empleadoNomina) {
		// TODO Auto-generated method stub
		try{
			System.out.println("SERVICIO!");
			return this.empleadoNominaDao.obtenerEmpleadoNominaByIdNominaEmpleado(empleadoNomina);
		}
		catch (Exception e){
			System.out.println("ERROR"+e.getMessage());
			return null;
		}
	}

	@Override
	public List obtenerDatosCombo() {

		System.out.println("Datos del Combo Servicio");
		List datosCombo = new ArrayList();
		try{
			datosCombo.add(this.areaDao.obtenerAreas());
			datosCombo.add(this.procesoDao.obtenerProcesos());
			datosCombo.add(this.departamentoDao.obtenerDepartamentos());
			datosCombo.add(this.puestoDao.obtenerPuestos());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return datosCombo;
	}

	@Override
	public int eliminarEmpleadoNominayEmpleado(int idEmpleado) {
		// TODO Auto-generated method stub
		return this.eliminarEmpleadoNominayEmpleado(idEmpleado);
	}

}
