package mx.nomina.gday.web.controller;

import java.util.ArrayList;
import java.util.List;

import mx.nomina.gday.modelo.Empleado;
import mx.nomina.gday.modelo.Grupo;
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
		    public boolean guardarEmpleado(@ModelAttribute(value="grupo") Empleado empleado, BindingResult result){
			 	System.out.println("Guardando empleado"+ empleado);
			 	empleadoServicio.agregarEmpleado(empleado);
			 	
				return true;
			 
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
}
