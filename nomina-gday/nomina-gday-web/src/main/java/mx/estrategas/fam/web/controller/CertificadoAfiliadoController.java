package mx.estrategas.fam.web.controller;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mx.estrategas.fam.modelo.CertificadoAfiliado;
import mx.estrategas.fam.modelo.Beneficiario;
import mx.estrategas.fam.modelo.AseguradoBeneficioAdicional;
import mx.estrategas.fam.servicios.CertificadoAfiliadoServicio;
import mx.estrategas.fam.servicios.BeneficiarioServicio;
import mx.estrategas.fam.servicios.AseguradoBeneficioAdicionalServicio;
import mx.estrategas.seguridad.modelo.UsuarioSeguridad;
import mx.estrategas.seguridad.util.SeguridadUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/certificadoafiliado")
public class CertificadoAfiliadoController {	
	
	@Autowired
	private CertificadoAfiliadoServicio certificadoAfiliadoServicio;
	@Autowired
	private BeneficiarioServicio beneficiarioServicio;
	@Autowired
	private AseguradoBeneficioAdicionalServicio aseguradoBeneficioAdicionalServicio;

	private static final Logger log = LoggerFactory.getLogger(CertificadoAfiliadoController.class);
    
    /**
     * Devuelve el index de la aplicaci贸n.
     * 
     * @return ModelAndView que corresponde a la vista principal de la aplicaci贸n.
     */	
	
	@RequestMapping(value="/guardarcertaprob",method = RequestMethod.POST)
    @ResponseBody
    public boolean guardarCertificadoAfiliadoModificacion(@ModelAttribute(value="certificadoAfiliado") CertificadoAfiliado certificadoAfiliado, BindingResult result,HttpServletRequest request){
		try{
		String rol=request.getSession().getAttribute("rolUser").toString();
		if (rol!=null)
			if (rol.equals("ROLE_ADMINISTRADOR")){
				System.out.println("<OTIKA>Guardar modificaci髇 directa certificado"+certificadoAfiliado.getNumeroCertificadoAfiliado());
	    		System.out.println("<OTIKA>"+certificadoAfiliado.getIdCertificadoAfiliado());
	    		certificadoAfiliadoServicio.actualizarCertificadoAfiliado(certificadoAfiliado);
			}
			else{
				System.out.println("<OTIKA>Guardar modificaci髇 certificado"+certificadoAfiliado.getNumeroCertificadoAfiliado());
				System.out.println("<OTIKA>"+certificadoAfiliado.getIdCertificadoAfiliado());
				certificadoAfiliadoServicio.guardarCertificadoAfiliadoModificacion(certificadoAfiliado);
			}
    		    		
    	}
    	catch (Exception e){
    		System.out.println("error!"+e);
    	}
        return true;
    }
	
    @RequestMapping(value="/guardar",method = RequestMethod.POST)
    @ResponseBody
    public boolean guardarCertificadoAfiliado(@ModelAttribute(value="certificadoAfiliado") CertificadoAfiliado certificadoAfiliado, BindingResult result){    	
    	try{
    		System.out.println("<OTIKA>"+certificadoAfiliado.getNumeroCertificadoAfiliado());
    		System.out.println("<OTIKA>"+certificadoAfiliado.getAfiliado().getIdAfiliado());
    		System.out.println("<OTIKA>"+certificadoAfiliado.getFechaInicioVigenciaCertificadoAfiliado());     		
    		certificadoAfiliadoServicio.guardarCertificadoAfiliado(certificadoAfiliado);
    	}
    	catch (Exception e){
    		System.out.println("error!"+e);
    	}
        return true;
    }
    
    @RequestMapping(value="/aprobarcambios",method = RequestMethod.POST)
    @ResponseBody
    public boolean aprobarCambiosCertificadoAfiliado(@ModelAttribute(value="certificadoAfiliado") CertificadoAfiliado certificadoAfiliado, BindingResult result){    	
    	try{
    		System.out.println("<OTIKA>AprobarCambios:"+certificadoAfiliado.getIdCertificadoAfiliado());    		
    		certificadoAfiliadoServicio.aprobarModificacionCertificadoAfiliado(certificadoAfiliado);
    	}
    	catch (Exception e){
    		System.out.println("error!"+e);
    	}
        return true;
    }
    
    @RequestMapping(value="/denegarcambios",method = RequestMethod.POST)
    @ResponseBody
    public boolean denegarCambiosCertificadoAfiliado(@ModelAttribute(value="certificadoAfiliado") CertificadoAfiliado certificadoAfiliado, BindingResult result){    	
    	try{
    		System.out.println("<OTIKA>AprobarCambios:"+certificadoAfiliado.getIdCertificadoAfiliado());    		
    		certificadoAfiliadoServicio.denegarModificacionCertificadoAfiliado(certificadoAfiliado);
    	}
    	catch (Exception e){
    		System.out.println("error!"+e);
    	}
        return true;
    }
    
    @RequestMapping(value="/guardarbeneficiario",method = RequestMethod.POST)
    @ResponseBody
    public boolean guardarBeneficiario(@ModelAttribute(value="beneficiario") Beneficiario beneficiario, BindingResult result){    	
    	try{
    		System.out.println("<OTIKA>"+beneficiario.getNombreBeneficiario());
    		System.out.println("<OTIKA>"+beneficiario.getCertificadoAfiliado().getIdCertificadoAfiliado());
    		this.beneficiarioServicio.guardarBeneficiario(beneficiario);
    	}
    	catch (Exception e){
    		System.out.println("error!"+e);
    	}
        return true;
    }
    
    @RequestMapping(value="/actualizarbeneficiariomod",method = RequestMethod.POST)
    @ResponseBody
    public boolean actualizarBeneficiarioModificacion(@ModelAttribute(value="beneficiario") Beneficiario beneficiario, BindingResult result,HttpServletRequest request){    	
    	try{
    		String rol=request.getSession().getAttribute("rolUser").toString();
    		if (rol!=null)
    			if (rol.equals("ROLE_ADMINISTRADOR")){
    				System.out.println("<OTIKA>Agregando Beneficiario Directo!!"+beneficiario.getNombreBeneficiario());
    				this.beneficiarioServicio.actualizarBeneficiario(beneficiario);
    			}
    			else{
    				System.out.println("<OTIKA>Agregando Beneficiario Aprobaci髇!!"+beneficiario.getNombreBeneficiario());
    				this.beneficiarioServicio.guardarBeneficiarioModificacion(beneficiario);
    			}
    	}
    	catch (Exception e){
    		System.out.println("error!"+e);
    	}
        return true;
    }
    
    @RequestMapping(value="/eliminarbeneficiariomod",method = RequestMethod.POST)
    @ResponseBody
    public boolean eliminarBeneficiarioModificacion(@ModelAttribute(value="beneficiario") Beneficiario beneficiario, BindingResult result,HttpServletRequest request){    	
    	try{
    		String rol=request.getSession().getAttribute("rolUser").toString();
    		if (rol!=null)
    			if (rol.equals("ROLE_ADMINISTRADOR")){
    				System.out.println("<OTIKA>Eliminar Beneficiario Directo!!"+beneficiario.getIdBeneficiario());
    				this.beneficiarioServicio.borrarBeneficiarioById(beneficiario);    				
    			}
    			else{
    				System.out.println("<OTIKA>Eliminar Beneficiario Aprobaci髇!!"+beneficiario.getNombreBeneficiario());
    				//this.beneficiarioServicio.guardarBeneficiarioModificacion(beneficiario);
    			}
    	}
    	catch (Exception e){
    		System.out.println("error!"+e);
    	}
        return true;
    }

    
    @RequestMapping(value="/guardarbeneficiariomod",method = RequestMethod.POST)
    @ResponseBody
    public boolean guardarBeneficiarioModificacion(@ModelAttribute(value="beneficiario") Beneficiario beneficiario, BindingResult result,HttpServletRequest request){    	
    	try{
    		String rol=request.getSession().getAttribute("rolUser").toString();
    		if (rol!=null)
    			if (rol.equals("ROLE_ADMINISTRADOR")){
    				System.out.println("<OTIKA>Agregando Beneficiario Directo!!"+beneficiario.getNombreBeneficiario());
    				this.beneficiarioServicio.guardarBeneficiario(beneficiario);
    			}
    			else{
    				System.out.println("<OTIKA>Agregando Beneficiario Aprobaci髇!!"+beneficiario.getNombreBeneficiario());
    				this.beneficiarioServicio.guardarBeneficiarioModificacion(beneficiario);
    			}
    	}
    	catch (Exception e){
    		System.out.println("error!"+e);
    	}
        return true;
    }

    
    @RequestMapping(value="/guardarasegurado",method = RequestMethod.POST)
    @ResponseBody
    public boolean guardarAsegurado(@ModelAttribute(value="aseguradoBeneficioAdicional") AseguradoBeneficioAdicional aseguradoBeneficioAdicional, BindingResult result){    	
    	try{
    		System.out.println("<OTIKA>Guardar Asegurado:"+aseguradoBeneficioAdicional.getNombreAseguradoBeneficioAdicional());
    		this.aseguradoBeneficioAdicionalServicio.guardarAseguradoBeneficioAdicional(aseguradoBeneficioAdicional);
    	}
    	catch (Exception e){
    		System.out.println("error!"+e);
    	}
        return true;
    }
    
    @RequestMapping(value="/actualizarasegurado",method = RequestMethod.POST)
    @ResponseBody
    public boolean actualizarAsegurado(@ModelAttribute(value="aseguradoBeneficioAdicional") AseguradoBeneficioAdicional aseguradoBeneficioAdicional, BindingResult result,HttpServletRequest request){    	
    	try{
    		String rol=request.getSession().getAttribute("rolUser").toString();
    		if (rol!=null){
    			if (rol.equals("ROLE_ADMINISTRADOR")){
    				System.out.println("<OTIKA>Actualizar Asegurado Directo:"+aseguradoBeneficioAdicional.getNombreAseguradoBeneficioAdicional());
    				this.aseguradoBeneficioAdicionalServicio.actualizarAseguradoBeneficioAdicional(aseguradoBeneficioAdicional);
    			}
    			else{
    				
    			}
    		}
    	}
    	catch (Exception e){
    		System.out.println("error!"+e);
    	}
        return true;
    }
    
    @RequestMapping(value="/eliminaraseguradomod",method = RequestMethod.POST)
    @ResponseBody
    public boolean eliminarAsegurado(@ModelAttribute(value="aseguradoBeneficioAdicional") AseguradoBeneficioAdicional aseguradoBeneficioAdicional, BindingResult result,HttpServletRequest request){    	
    	try{
    		String rol=request.getSession().getAttribute("rolUser").toString();
    		if (rol!=null){
    			if (rol.equals("ROLE_ADMINISTRADOR")){
    				System.out.println("<OTIKA>Eliminar Asegurado Directo:"+aseguradoBeneficioAdicional.getNombreAseguradoBeneficioAdicional());
    				this.aseguradoBeneficioAdicionalServicio.eliminarAseguradoBeneficioAdicional(aseguradoBeneficioAdicional);
    			}
    			else{
    				
    			}
    		}
    	}
    	catch (Exception e){
    		System.out.println("error!"+e);
    	}
        return true;
    }
    
    @RequestMapping(value="/getcertificadosall",method = RequestMethod.POST)
    @ResponseBody
    public List<CertificadoAfiliado> getCertificadosAfiliadosAll(){
    	List<CertificadoAfiliado> certificadosAliados = this.certificadoAfiliadoServicio.obtenerCertificadosAfiliados();
	    List certificadosStr = new ArrayList();
		List<String> certificadosStr2 = new ArrayList<String>();
		for (int i=0;i<certificadosAliados.size();i++){
			certificadosStr2 = new ArrayList<String>();
			certificadosStr2.add(""+certificadosAliados.get(i).getIdCertificadoAfiliado());
			certificadosStr2.add(""+certificadosAliados.get(i).getNumeroCertificadoAfiliado());
			certificadosStr2.add(""+certificadosAliados.get(i).getFechaInicioVigenciaCertificadoAfiliado());
			certificadosStr2.add(certificadosAliados.get(i).getEstadoCertificadoAfiliado());
			certificadosStr2.add(""+certificadosAliados.get(i).getSumaAseguradaCertificadoAfiliado());
			certificadosStr2.add(""+certificadosAliados.get(i).getAfiliado().getIdAfiliado());
//			afiliadosStr2.add(certificadosAliados.get(i).getNombreAfiliado());
//			afiliadosStr2.add(certificadosAliados.get(i).getAppPaternoAfiliado());
	//		afiliadosStr2.add(certificadosAliados.get(i).getAppMaternoAfiliado());									
			certificadosStr.add(certificadosStr2);
	}
	System.out.println("Controller2" + certificadosStr.size());
    return certificadosStr;
	}
	
    @RequestMapping(value="/getcertificados",method = RequestMethod.POST)
    @ResponseBody
    public List<CertificadoAfiliado> getCertificadosAfiliados(){
        return this.certificadoAfiliadoServicio.obtenerCertificadosAfiliados();
    }
    
    @RequestMapping(value="/getcertificadobyidb",method = RequestMethod.POST)
    @ResponseBody
    public int getCertificadoAfiliadoByIdBeneficiario(@ModelAttribute(value="beneficiario") Beneficiario beneficiario, BindingResult result){
    	int idCert=0;
    	System.out.println("<OTIKA> Get certificado by id beneficiario:"+beneficiario.getIdBeneficiario());    
        try{
        	idCert=this.beneficiarioServicio.obtenerIdCertificadoByIdBeneficiarioMod(beneficiario.getIdBeneficiario());
        }
        catch(Exception e){
        	System.out.println(e.getMessage());
        }
        
        System.out.println("<OTIK>IDCERT:"+idCert);
        return idCert;
        
    }
    
    @RequestMapping(value="/getcertificadosaprob",method = RequestMethod.POST)
    @ResponseBody
    public List<CertificadoAfiliado> getCertificadosAfiliadosAprobaciones(){
        return this.certificadoAfiliadoServicio.obtenerCertificadosAfiliadosAprobaciones();
    }

    
    @RequestMapping(value="/getcertificado",method = RequestMethod.POST)
    @ResponseBody
    public CertificadoAfiliado getCertificadoAfiliado(@ModelAttribute(value="certificadoAfiliado") CertificadoAfiliado certificadoAfiliado, BindingResult result){
    	CertificadoAfiliado certificado = new CertificadoAfiliado();
    	try{
    		System.out.println("<OTIKA>IdAfiliado"+certificadoAfiliado.getAfiliado().getIdAfiliado());
    		certificado=this.certificadoAfiliadoServicio.obtenerCertificadoAfiliadoById(certificadoAfiliado.getAfiliado().getIdAfiliado());
    		System.out.println("<OTIKA>Certificado:"+certificado);
    		if (certificado!=null)
    			System.out.println("<OTIKA>NumCertificado"+certificado.getNumeroCertificadoAfiliado());
    		else{
    			certificado = new CertificadoAfiliado();
    			certificado.setIdCertificadoAfiliado(0);
    		}
    			
    	}
    	catch (Exception e){
    		System.out.println("error!"+e);
    	}
        return certificado;
    }
        
    @RequestMapping(value="/getmodcertificadobyidcer",method = RequestMethod.POST)
    @ResponseBody
    public CertificadoAfiliado getCertificadoAfiliadoAprobacionByIdCer(@ModelAttribute(value="certificadoAfiliado") CertificadoAfiliado certificadoAfiliado, BindingResult result){
    	CertificadoAfiliado certificado = new CertificadoAfiliado();
    	try{ 
    		System.out.println("<OTIKA>Id del Certif a aprobar:"+certificadoAfiliado.getAfiliado().getIdAfiliado());
    		certificado.setIdCertificadoAfiliado(certificadoAfiliado.getAfiliado().getIdAfiliado());
    		certificado=this.certificadoAfiliadoServicio.obtenerCertificadoAfiliadoByIdCertificadoAprobacion(certificado);
    		System.out.println("<OTIKA>Certificado:"+certificado);
    		if (certificado!=null){
    			System.out.println("<OTIKA>NumCertificado"+certificado.getNumeroCertificadoAfiliado());
    			System.out.println("<OTIKA>Afiliado del Certificado"+certificado.getAfiliado());
    		}
    		else{
    			certificado = new CertificadoAfiliado();
    			certificado.setIdCertificadoAfiliado(0);
    		}
    			
    	}
    	catch (Exception e){
    		System.out.println("error!"+e);
    	}
        return certificado;
    }
    
    @RequestMapping(value="/getcertificadobyidcer",method = RequestMethod.POST)
    @ResponseBody
    public CertificadoAfiliado getCertificadoAfiliadoByIdCer(@ModelAttribute(value="certificadoAfiliado") CertificadoAfiliado certificadoAfiliado, BindingResult result){
    	CertificadoAfiliado certificado = new CertificadoAfiliado();
    	try{ 
    		System.out.println("<OTIKA>IdAfiliado"+certificadoAfiliado.getAfiliado().getIdAfiliado());
    		certificado.setIdCertificadoAfiliado(certificadoAfiliado.getAfiliado().getIdAfiliado());
    		//certificado=this.certificadoAfiliadoServicio.obtenerCertificadoAfiliadoByIdCertificado(certificadoAfiliado.getAfiliado().getIdAfiliado());
    		certificado=this.certificadoAfiliadoServicio.obtenerCertificadoAfiliadoByIdCertificado(certificado.getIdCertificadoAfiliado());
    		System.out.println("<OTIKA>Certificado:"+certificado);
    		if (certificado!=null){
    			System.out.println("<OTIKA>NumCertificado"+certificado.getNumeroCertificadoAfiliado());
    			System.out.println("<OTIKA>Afiliado del Certificado"+certificado.getAfiliado());
    		}
    		else{
    			certificado = new CertificadoAfiliado();
    			certificado.setIdCertificadoAfiliado(0);
    		}
    			
    	}
    	catch (Exception e){
    		System.out.println("error!"+e);
    	}
        return certificado;
    }
    
    @RequestMapping(value="/getasegurados2",method = RequestMethod.POST)
    @ResponseBody
    public List<AseguradoBeneficioAdicional> getAsegurados2(@ModelAttribute(value="aseguradoBeneficioAdicional") AseguradoBeneficioAdicional aseguradoBeneficioAdicional, BindingResult result){
    	List<AseguradoBeneficioAdicional> asegurados=new ArrayList<AseguradoBeneficioAdicional>();
    	try{
    		System.out.println("<OTIKA>Carga de Asegurados...");
    		System.out.println("<OTIKA>IdBeneficiario"+aseguradoBeneficioAdicional.getIdAseguradoBeneficioAdicional());
    		CertificadoAfiliado certificado = new CertificadoAfiliado();
    		certificado.setIdCertificadoAfiliado(aseguradoBeneficioAdicional.getIdAseguradoBeneficioAdicional());
    		aseguradoBeneficioAdicional.setCertificadoAfiliado(certificado);    		
    		asegurados = this.aseguradoBeneficioAdicionalServicio.obtenerAseguradosBeneficioAdicionalById(aseguradoBeneficioAdicional.getCertificadoAfiliado().getIdCertificadoAfiliado());    		
    	}
    	catch (Exception e){
    		System.out.println("error!"+e);
    	}
    	System.out.println("<OTIKA>Asegurados:"+asegurados);
        return asegurados;
    }
    
    @RequestMapping(value="/getbeneficiarios",method = RequestMethod.POST)
    @ResponseBody
    public List<Beneficiario> getBeneficiarios(@ModelAttribute(value="beneficiario") Beneficiario beneficiario, BindingResult result){
    	List<Beneficiario> beneficiarios=new ArrayList<Beneficiario>();
    	try{
    		System.out.println("<OTIKA>Carga de beneficiarios...");
    		System.out.println("<OTIKA>IdBeneficiario:"+beneficiario.getIdBeneficiario());
    		CertificadoAfiliado certificado = new CertificadoAfiliado();
    		certificado.setIdCertificadoAfiliado(beneficiario.getIdBeneficiario());
    		beneficiario.setCertificadoAfiliado(certificado);
    		System.out.println("<OTIKA>"+beneficiario.getCertificadoAfiliado().getIdCertificadoAfiliado());
    		beneficiarios = this.beneficiarioServicio.obtenerBeneficiariosById(beneficiario.getCertificadoAfiliado().getIdCertificadoAfiliado());
    		System.out.println("<OTIKA>Beneficiario:"+beneficiarios.size());
    	}
    	catch (Exception e){
    		System.out.println("error!"+e);
    	}
        return beneficiarios;
    }
    
    @RequestMapping(value="/getbeneficiariosmod",method = RequestMethod.POST)
    @ResponseBody
    public List<Beneficiario> getBeneficiariosAprobaciones(@ModelAttribute(value="beneficiario") Beneficiario beneficiario, BindingResult result){
    	List<Beneficiario> beneficiarios=new ArrayList<Beneficiario>();
    	try{
    		System.out.println("<OTIKA>Carga de beneficiarios...");
    		System.out.println("<OTIKA>IdBeneficiario:"+beneficiario.getIdBeneficiario());
    		CertificadoAfiliado certificado = new CertificadoAfiliado();
    		certificado.setIdCertificadoAfiliado(beneficiario.getIdBeneficiario());
    		beneficiario.setCertificadoAfiliado(certificado);
    		System.out.println("<OTIKA>"+beneficiario.getCertificadoAfiliado().getIdCertificadoAfiliado());
    		beneficiarios = this.beneficiarioServicio.obtenerBeneficiariosModificacion();
    		System.out.println("<OTIKA>Beneficiario:"+beneficiarios.size());
    	}
    	catch (Exception e){
    		System.out.println("error!"+e);
    	}
        return beneficiarios;
    }
    
    @RequestMapping(value="/getbeneficiariosmodbycer",method = RequestMethod.POST)
    @ResponseBody
    public List<Beneficiario> getBeneficiariosModificaciones(@ModelAttribute(value="beneficiario") Beneficiario beneficiario, BindingResult result){
    	List<Beneficiario> beneficiarios=new ArrayList<Beneficiario>();
    	try{
    		System.out.println("<OTIKA>Carga de beneficiarios modificados...");
    		System.out.println("<OTIKA>IdCertificadoAfiliado:"+beneficiario.getIdBeneficiario());    		
    		beneficiarios = this.beneficiarioServicio.obtenerBeneficiariosModificacionById(beneficiario.getIdBeneficiario());
    		System.out.println("<OTIKA>Beneficiario:"+beneficiarios.size());
    	}
    	catch (Exception e){
    		System.out.println("error!"+e);
    	}
        return beneficiarios;
    }
    
    @RequestMapping(value="/getbeneficiariosbycer",method = RequestMethod.POST)
    @ResponseBody
    public List<Beneficiario> getBeneficiariosActuales(@ModelAttribute(value="beneficiario") Beneficiario beneficiario, BindingResult result){
    	List<Beneficiario> beneficiarios=new ArrayList<Beneficiario>();
    	try{
    		System.out.println("<OTIKA>Carga de beneficiarios actuales...");
    		System.out.println("<OTIKA>IdCertificadoAfiliado:"+beneficiario.getIdBeneficiario());    		
    		beneficiarios = this.beneficiarioServicio.obtenerBeneficiariosById(beneficiario.getIdBeneficiario());
    		System.out.println("<OTIKA>Beneficiario:"+beneficiarios.size());
    	}
    	catch (Exception e){
    		System.out.println("error!"+e);
    	}
        return beneficiarios;
    }

    
    @RequestMapping(value="/getasegurados",method = RequestMethod.POST)
    @ResponseBody
    public List<AseguradoBeneficioAdicional> getAsegurados(@ModelAttribute(value="aseguradoBeneficioAdicional") AseguradoBeneficioAdicional aseguradoBeneficioAdicional, BindingResult result){
    	List<AseguradoBeneficioAdicional> asegurados=new ArrayList<AseguradoBeneficioAdicional>();
    	try{
    		System.out.println("<OTIKA>Carga de Asegurados...");
    		System.out.println("<OTIKA>IdBeneficiario"+aseguradoBeneficioAdicional.getIdAseguradoBeneficioAdicional());
    		CertificadoAfiliado certificado = new CertificadoAfiliado();
    		certificado.setIdCertificadoAfiliado(aseguradoBeneficioAdicional.getIdAseguradoBeneficioAdicional());
    		aseguradoBeneficioAdicional.setCertificadoAfiliado(certificado);    		
    		asegurados = this.aseguradoBeneficioAdicionalServicio.obtenerAseguradosBeneficioAdicionalById(aseguradoBeneficioAdicional.getCertificadoAfiliado().getIdCertificadoAfiliado());    		
    	}
    	catch (Exception e){
    		System.out.println("error!"+e);
    	}
    	System.out.println("<OTIKA>Asegurados:"+asegurados.size());
        return asegurados;
    }
    
    
    
    @RequestMapping(value="/aprobarcambiosbeneficiarios",method = RequestMethod.POST)
    @ResponseBody
    public boolean aprobarCambiosBeneficiarios(@ModelAttribute(value="certificadoAfiliado") CertificadoAfiliado certificadoAfiliado, BindingResult result){    	
    	try{
    		System.out.println("<OTIKA>AprobarCambios:"+certificadoAfiliado.getIdCertificadoAfiliado());
    		//Borramos los beneficiarios actuales
    		this.beneficiarioServicio.borrarBeneficiariosByIdCertificado(certificadoAfiliado.getIdCertificadoAfiliado());
    		//Actualizamos los beneficiarios
    		List<Beneficiario> beneficiarios = this.beneficiarioServicio.obtenerBeneficiariosModificacionById(certificadoAfiliado.getIdCertificadoAfiliado());
    		for (Beneficiario beneficiario:beneficiarios){
    			beneficiario.setCertificadoAfiliado(certificadoAfiliado);
    			this.beneficiarioServicio.guardarBeneficiario(beneficiario);
    		}    		    		
    		//Borramos los registros a modificar
    		beneficiarioServicio.borrarBeneficiariosModByIdCertificado(certificadoAfiliado.getIdCertificadoAfiliado());
    	}
    	catch (Exception e){
    		System.out.println("error!"+e);
    	}
        return true;
    }


    
}
