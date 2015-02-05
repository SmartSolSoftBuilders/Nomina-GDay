package mx.nomina.gday.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mx.nomina.gday.modelo.Empleado;
import mx.nomina.gday.modelo.EmpleadoNomina;
import mx.nomina.gday.modelo.Grupo;
import mx.nomina.gday.modelo.Nomina;
import mx.nomina.gday.servicios.EmpleadoServicio;
import mx.nomina.gday.servicios.ReportesServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoServicio empleadoServicio;


	//Controller Guardar Grupo
	@RequestMapping(value="/guardarempleado",method = RequestMethod.POST)
	@ResponseBody
    public int guardarEmpleado(@ModelAttribute(value="grupo") Empleado empleado, BindingResult result){
		 	System.out.println("Guardando empleado"+ empleado);
		 	return empleadoServicio.agregarEmpleado(empleado);
	}
	
	//Controller Guardar Grupo
	@RequestMapping(value="/guardarempleadonomina",method = RequestMethod.POST)
	@ResponseBody
    public boolean guardarEmpleadoNomina(@ModelAttribute(value="empleadoNomina") EmpleadoNomina empleadoNomina, BindingResult result){
		 	System.out.println("Guardando empleado nomina"+ empleadoNomina.getNomina().getIdNomina());
		 	empleadoServicio.agregarEmpleadoNomina(empleadoNomina);
		return true;	 
	}

	//Controller Guardar Grupo
	@RequestMapping(value="/guardareditarempleadonomina",method = RequestMethod.POST)
	@ResponseBody
    public boolean guardarEditarEmpleadoNomina(@ModelAttribute(value="empleadoNomina") EmpleadoNomina empleadoNomina, BindingResult result){
		 	System.out.println("Guardando empleado nomina"+ empleadoNomina.getNomina().getIdNomina());
		 	empleadoServicio.actualizarEmpleadoNomina(empleadoNomina);
		return true;	 
	}

	//Controller Guardar Grupo
	@RequestMapping(value="/bajaempleadonomina",method = RequestMethod.POST)
	@ResponseBody
    public boolean darBajaEmpleadoNomina(@ModelAttribute(value="empleadoNomina") EmpleadoNomina empleadoNomina, BindingResult result){
		 	System.out.println("Guardando baja empleado nomina"+ empleadoNomina.getNomina().getIdNomina());
		 	empleadoServicio.darBajaEmpleadoNomina(empleadoNomina);
		return true;	 
	}

	
	// Controller que permite Actualizar los datos del Empleado a Editar
	@RequestMapping(value = "/modificaempleado", method = RequestMethod.POST)
	@ResponseBody
	public boolean modificarEmpleado(
			@ModelAttribute(value = "empleado") Empleado empleado,
			BindingResult result, HttpServletRequest request) {

		try {
			System.out.println("Controller Actualizar Empleado");
			System.out.println("Controller Actualizar Empleado"+empleado.getPaisOrigen());
			empleadoServicio.actualizarEmpleado(empleado);
	
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	 //Controller que muestra la lista de Empleado
	 @RequestMapping(value="/getempleados",method = RequestMethod.POST)
	    @ResponseBody
	    public List obtenerEmpleados(){    	
		  System.out.println("Controller Empleado");
		  try {
			List<Empleado> tmp =  this.empleadoServicio.obtenerEmpleados();
			System.out.println("tmp"+tmp.size());
			List empleadosTmp = new ArrayList();
			List empleadosTmp2 = new ArrayList<String>();

			for (int i = 0; i < tmp.size(); i++) {
				empleadosTmp2 = new ArrayList<String>();
				System.out.println("tmp"+tmp.get(i));
				empleadosTmp2.add(tmp.get(i).getIdEmpleado());
				empleadosTmp2.add(tmp.get(i).getRfc());
				empleadosTmp2.add(tmp.get(i).getApellidoPaterno());
				empleadosTmp2.add(tmp.get(i).getApellidoMaterno());
				empleadosTmp2.add(tmp.get(i).getNombre());
				empleadosTmp2.add(tmp.get(i).getCurp());
				empleadosTmp2.add(tmp.get(i).getNss());
				empleadosTmp2.add("<a href='#' onclick='showEditarEmpleado("+tmp.get(i).getIdEmpleado()+")'>'<img src='../../static/img/editar.png' width='27' height='27'></img>'</a>");
				empleadosTmp.add(empleadosTmp2);
			}
			return empleadosTmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		  return null;
	 }
	 
	 //Controller que muestra la lista de Empleado por Nomina
	 @RequestMapping(value="/getempleadosbyidnomina",method = RequestMethod.POST)
	    @ResponseBody
	    public List obtenerEmpleadosByIdNomina(Integer idNomina){    	
		  System.out.println("Controller Empleado");
		  try {
			List<Empleado> tmp =  this.empleadoServicio.obtenerEmpleadosByIdNomina(idNomina);
			System.out.println("tmp"+tmp.size());
			List empleadosTmp = new ArrayList();
			List empleadosTmp2 = new ArrayList<String>();

			for (int i = 0; i < tmp.size(); i++) {
				empleadosTmp2 = new ArrayList<String>();
				System.out.println("tmp"+tmp.get(i));
				empleadosTmp2.add(tmp.get(i).getIdEmpleado());
				empleadosTmp2.add(tmp.get(i).getCurp());
				empleadosTmp2.add(tmp.get(i).getApellidoPaterno());
				empleadosTmp2.add(tmp.get(i).getApellidoMaterno());
				empleadosTmp2.add(tmp.get(i).getNombre());
				empleadosTmp2.add(tmp.get(i).getNss());
				empleadosTmp.add(empleadosTmp2);
			}
			return empleadosTmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		  return null;
	 }
	 
	//Controller que permite obtener el Empleado por idEmpleado
	 @RequestMapping(value="/obtenerempleadobyid",method = RequestMethod.POST)
	    @ResponseBody
	    public Empleado obtenerEmpleadoById(@ModelAttribute(value="Empleado") Empleado empleado, BindingResult result){   
		 	System.out.println("Empleado por id"+ empleado);
		 	return this.empleadoServicio.obtenerEmpleadoById(empleado.getIdEmpleado());
		 	
		}
		//Controller que permite obtener el Empleado por idEmpleado
	 @RequestMapping(value="/getnominasempbyid",method = RequestMethod.POST)
	    @ResponseBody
	    public EmpleadoNomina obtenerNominaEmpleadoById(@ModelAttribute(value="Empleado") EmpleadoNomina empleadoNomina, BindingResult result){   
		 	System.out.println("Empleado por id"+ empleadoNomina.getEmpleado().getIdEmpleado());
		 	System.out.println("Empleado por id"+ empleadoNomina.getNomina().getIdNomina());
		 	return this.empleadoServicio.obtenerEmpleadoNominaByIds(empleadoNomina);
		 	
		}	
	 
	//LLENADO DEL SELECT COMBO, TIPO_REGIMEN
	 //Obteber los datos de TipoRegimen para el llenado de sus respectivos Combos
	 @RequestMapping(value="/getdatoscombo",method = RequestMethod.POST)
	    @ResponseBody
	    public List obtenerDatosCombo(){
		 	System.out.println("Controller Datos del combo");
			return this.empleadoServicio.obtenerDatosCombo();
		}
	 
}
