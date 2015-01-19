package mx.nomina.gday.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.nomina.gday.modelo.Grupo;
import mx.nomina.gday.modelo.Patrona;
import mx.nomina.gday.servicios.GrupoServicio;
import mx.nomina.gday.servicios.PatronaServicio;

@Controller
@RequestMapping("/patrona")
public class PatronaController {

	@Autowired
	private PatronaServicio patronaServicio;
	
	//Controller Guardar Grupo

	//Controller que muestra la lista de Grupos y permite la seleccion del mismo
	 @RequestMapping(value="/getpatronas",method = RequestMethod.POST)
	    @ResponseBody
	    public List obtenerGrupos(){    	
		  System.out.println("Controller Grupo");
		  try {
			List<Patrona> tmp =  this.patronaServicio.obtenerPatronas();
			System.out.println("tmp"+tmp.size());
			List patronasTmp = new ArrayList();
			List patronasTmp2 = new ArrayList<String>();

			for (int i = 0; i < tmp.size(); i++) {
				patronasTmp2 = new ArrayList<String>();
				System.out.println("tmp"+tmp.get(i));
				patronasTmp2.add(tmp.get(i).getIdPatrona());
				patronasTmp2.add(tmp.get(i).getNombreCorto());
				patronasTmp2.add("<a href='#' onclick='seleccionarPatrona("+tmp.get(i).getIdPatrona()+",\""+tmp.get(i).getNombreCorto()+"\")'>Seleccionar</a>");				
				patronasTmp.add(patronasTmp2);
			}
			return patronasTmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		  return null;
		}
	 
}
