package mx.estrategas.fam.web.controller;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mx.estrategas.fam.modelo.Afiliado;
import mx.estrategas.fam.modelo.Escuela;
import mx.estrategas.fam.modelo.CuentaFamAhorro;
import mx.estrategas.fam.servicios.AfiliadoServicio;
import mx.estrategas.seguridad.modelo.UsuarioSeguridad;
import mx.estrategas.seguridad.servicios.MttoSeguridadServicio;
import mx.estrategas.seguridad.util.SeguridadUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller encargado de devolver la vista principal o index de la aplicaci贸n.
 * 
 * El path colocado en la anotaci贸n @RequestMappig corresponde a la cofiguraci贸n dentro
 * del archivo web.xml
 * 
 * <pre>
 * {@code
 *   <welcome-file-list>
 *       <welcome-file>mvc/index</welcome-file>
 *   </welcome-file-list>   
 * }
 * </pre>
 * 
 * @author SmartSolutions
 *
 */
@Controller
@RequestMapping("/afiliado")
public class AfiliadoController {	
	
	@Autowired
	private AfiliadoServicio afiliadoServicio;
	@Autowired
	private MttoSeguridadServicio mttoSeguridadServicio;

	private static final Logger log = LoggerFactory.getLogger(AfiliadoController.class);
    
    /**
     * Devuelve el index de la aplicaci贸n.
     * 
     * @return ModelAndView que corresponde a la vista principal de la aplicaci贸n.
     */
	
    @RequestMapping(value="/guardar",method = RequestMethod.POST)
    @ResponseBody
    public boolean guardarAfiliado(@ModelAttribute(value="afiliado") Afiliado afiliado, BindingResult result){
    	System.out.println("<OTIKA>Guardando!!"+afiliado.getNombreAfiliado());
    	System.out.println("<OTIKA>Guardando!!"+afiliado.getAppPaternoAfiliado());
    	try{
    		afiliadoServicio.guardarAfiliado(afiliado);
    		UsuarioSeguridad usuarioSeguridad = new UsuarioSeguridad();
    		usuarioSeguridad.setNombre(afiliado.getRfcAfiliado());
    		usuarioSeguridad.setUsername(afiliado.getRfcAfiliado());
    		usuarioSeguridad.setPassword(afiliado.getRfcAfiliado());
    		mttoSeguridadServicio.agregarUsuarioSeguridad(usuarioSeguridad);    		
    	}
    	
    	catch (Exception e){
    		System.out.println("error!"+e);
    		e.printStackTrace();
    	}
        return true;
    }
    
    @RequestMapping(value="/modificaafiliado",method = RequestMethod.POST)
    @ResponseBody
    public boolean modificarAfiliado(@ModelAttribute(value="afiliado") Afiliado afiliado, BindingResult result,HttpServletRequest request){    	    	    	    	   
    	try{
    		String rol=request.getSession().getAttribute("rolUser").toString();
    		if (rol!=null)
    			if (rol.equals("ROLE_ADMINISTRADOR")){
    				System.out.println("<OTIKA>Modificando Directo!!"+afiliado.getNombreAfiliado());
    				afiliadoServicio.actualizarAfiliado(afiliado);
    			}
    			else{
    				System.out.println("<OTIKA>Modificando a aprobaci髇!!"+afiliado.getNombreAfiliado());
    				afiliadoServicio.guardarAfiliadoModificacion(afiliado);
    			}
    	}
    	catch (Exception e){
    		System.out.println("Error! al actualizar el afiliado"+e);
    		return false;
    	}
        return true;
    }
    
    @RequestMapping(value="/denegaraprobacion",method = RequestMethod.POST)
    @ResponseBody
    public boolean denegarAprobacion(@ModelAttribute(value="afiliado") Afiliado afiliado, BindingResult result){
    	System.out.println("<OTIKA>Denegar modificaci髇 del afiliado!"+afiliado.getIdAfiliado());    	
    	afiliadoServicio.denegarAfiliadoModificacion(afiliado.getIdAfiliado());    	    	
        return true;
    }
    
    @RequestMapping(value="/aprobarmodafiliado",method = RequestMethod.POST)
    @ResponseBody
    public boolean aprobarModificacionAfiliado(@ModelAttribute(value="afiliado") Afiliado afiliado, BindingResult result){
    	System.out.println("<OTIKA>Aprobar modificaci髇 del afiliado!"+afiliado.getIdAfiliado());    	
    	afiliadoServicio.aprobarAfiliadoModificacion(afiliado);    	    	
        return true;
    }

    
    @RequestMapping(value="/escuelas",method = RequestMethod.POST)
    @ResponseBody
    public List<Escuela> obtenerEscuelas(){    	
		return this.afiliadoServicio.obtenerEscuelas();
	}
    
    @RequestMapping(value="/afiliados",method = RequestMethod.POST)
    @ResponseBody
    public List<Afiliado> obtenerAfiliados(){
    	System.out.println("Controller");    	
		List<Afiliado> afiliados = this.afiliadoServicio.obtenerAfiliados(); 
		
		System.out.println("Controller2");
		return afiliados;
	}
    
    @RequestMapping(value="/afiliadosall",method = RequestMethod.POST)
    @ResponseBody
    public List obtenerAfiliadosStr(){
    	System.out.println("Controller");    	
		List<Afiliado> afiliados = this.afiliadoServicio.obtenerAfiliados(); 
		List afiliadosStr = new ArrayList();
		List<String> afiliadosStr2 = new ArrayList<String>();
		for (int i=0;i<afiliados.size();i++){
			afiliadosStr2 = new ArrayList<String>();
			afiliadosStr2.add(""+afiliados.get(i).getIdAfiliado());
			afiliadosStr2.add(afiliados.get(i).getRfcAfiliado());
			afiliadosStr2.add(afiliados.get(i).getNombreAfiliado());
			afiliadosStr2.add(afiliados.get(i).getAppPaternoAfiliado());
			afiliadosStr2.add(afiliados.get(i).getAppMaternoAfiliado());			
			if (afiliados.get(i).getCertificadoAfiliado()!=null){
				//System.out.println("OK"+afiliados.get(i).getRfcAfiliado());
				//System.out.println("OK"+afiliados.get(i).getCertificadoAfiliado().getIdCertificadoAfiliado());
				afiliadosStr2.add("SI");
			}
			else
				afiliadosStr2.add("NO");
			if (afiliados.get(i).getFamAhorro()==true)
				afiliadosStr2.add("SI");
			else
				afiliadosStr2.add("NO");			
			afiliadosStr2.add("NO");

			if (afiliados.get(i).getInversionista())
				afiliadosStr2.add("SI");
			else
				afiliadosStr2.add("NO");
			
			afiliadosStr.add(afiliadosStr2);
		}
		System.out.println("Controller2");
		return afiliadosStr;
	}
    
        
    @RequestMapping(value="/obtenercuentasfamahorro",method = RequestMethod.POST)
    @ResponseBody
    public List<CuentaFamAhorro> obtenerCuentasFamAhorro(@ModelAttribute(value="id") Afiliado afiliado, BindingResult result){
    	System.out.println("<OTIKA>Se obtienen las cuentas FamAhorro del Afiliado:"+afiliado.getIdAfiliado());
		return this.afiliadoServicio.obtenerCuentasFamAhorro(afiliado);
	}
    
    @RequestMapping(value="/obtenercuentasfamahorroshow",method = RequestMethod.POST)
    @ResponseBody
    public List<CuentaFamAhorro> obtenerCuentasFamAhorroShow(@ModelAttribute(value="afiliado") Afiliado afiliado, BindingResult result){
    	System.out.println("<OTIKA>Se obtienen las cuentas FamAhorro del Afiliado:"+afiliado.getIdAfiliado());
		return this.afiliadoServicio.obtenerCuentasFamAhorro(afiliado);
	}
    
    @RequestMapping(value="/afiliadosaprobaciones",method = RequestMethod.POST)
    @ResponseBody
    public List<Afiliado> obtenerAfiliadosAprobaciones(){    	
		return this.afiliadoServicio.obtenerAfiliadosModificacion();
	}
    
    @RequestMapping(value="/obtenerafiliadobyid",method = RequestMethod.POST)
    @ResponseBody
    public Afiliado obtenerAfiliadoById(@ModelAttribute(value="afiliado") Afiliado afiliado, BindingResult result){    	
    	System.out.println("<OTIKA>Buscar Afiliado:"+afiliado.getIdAfiliado());
    	return this.afiliadoServicio.obtenerAfiliadoById(afiliado.getIdAfiliado());
	}
    
    @RequestMapping(value="/obtenerafiliadomodbyid",method = RequestMethod.POST)
    @ResponseBody
    public Afiliado obtenerAfiliadoModById(@ModelAttribute(value="afiliado") Afiliado afiliado, BindingResult result){    	
    	System.out.println("<OTIKA>Buscar Afiliado Aprobaci髇:"+afiliado.getIdAfiliado());
    	return this.afiliadoServicio.obtenerAfiliadoModificadoById(afiliado.getIdAfiliado());
	}
}
