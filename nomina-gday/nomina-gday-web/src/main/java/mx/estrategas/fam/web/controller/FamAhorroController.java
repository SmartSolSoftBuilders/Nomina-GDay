package mx.estrategas.fam.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mx.estrategas.fam.modelo.Afiliado;
import mx.estrategas.fam.modelo.BenefCuentaFamAhorro;
import mx.estrategas.fam.modelo.Escuela;
import mx.estrategas.fam.modelo.CuentaFamAhorro;
import mx.estrategas.fam.modelo.CuentaFamAhorroInversion;
import mx.estrategas.fam.modelo.MontoDescuentoCuentaFam;
import mx.estrategas.fam.modelo.MovimientoFamAhorro;
import mx.estrategas.fam.modelo.MovimientoFamAhorroInversion;
import mx.estrategas.fam.servicios.AfiliadoServicio;
import mx.estrategas.fam.servicios.CuentaFamAhorroServicio;
import mx.estrategas.fam.servicios.CuentaFamAhorroInversionServicio;
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
/*
 * 
 * @author SmartSolutions
 *
 */
@Controller
@RequestMapping("/famahorro")
public class FamAhorroController {	
	
	@Autowired
	private CuentaFamAhorroServicio cuentaFamAhorroServicio;
	@Autowired
	private CuentaFamAhorroInversionServicio cuentaFamAhorroInversionServicio;
	@Autowired
	private AfiliadoServicio afiliadoServicio;
	@Autowired
	private MttoSeguridadServicio mttoSeguridadServicio;

	private static final Logger log = LoggerFactory.getLogger(FamAhorroController.class);
    
    /**
     * Devuelve el index de la aplicaciÃ³n.
     * 
     * @return ModelAndView que corresponde a la vista principal de la aplicaciÃ³n.
     */
	
    
    @RequestMapping(value="/afiliados",method = RequestMethod.POST)
    @ResponseBody
    public List<Afiliado> obtenerAfiliados(){    	
		return this.afiliadoServicio.obtenerAfiliados();
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
			if (afiliados.get(i).getFamAhorro()==true)
				afiliadosStr2.add("SI");
			else
				afiliadosStr2.add("NO");			
			afiliadosStr2.add("NO");
			if (afiliados.get(i).getInversionista()==true)
				afiliadosStr2.add("SI");
			else
				afiliadosStr2.add("NO");
			afiliadosStr.add(afiliadosStr2);
		}
		System.out.println("Controller2FAMAhorro");
		return afiliadosStr;
	}
    
    public List<Afiliado> obtenerAfiliadosDetalle(){
    	//List<Afiliado>lista=this.obtenerAfiliadosDetalle();
    	List<Afiliado>lista=new ArrayList<Afiliado>();
    	/*for (int i=0; i<lista.size();i++){
    		Porqué hacia esto?System.out.println(lista.get(i).getCuentaFamAhorro());
    	}*/
		return this.afiliadoServicio.obtenerAfiliadosDetalle();
	}
    

    @RequestMapping(value="/guardar",method = RequestMethod.POST)
    @ResponseBody
    public boolean guardarContratoFamAhorro(@ModelAttribute(value="cuentaFamAhorro") CuentaFamAhorro cuentaFamAhorro, BindingResult result){
    	System.out.println("<OTIKA>GuardarFAMAHORRO");
    	System.out.println("<OTIKA>"+cuentaFamAhorro.getFechaApertura());
    	System.out.println("<OTIKA>"+cuentaFamAhorro.getBenefOperadorCuentaFamAhorro().getNombreBenefCuentaFamAhorro());
    	if (cuentaFamAhorro.getBenef1CuentaFamAhorro().getNombreBenefCuentaFamAhorro()=="")
    		cuentaFamAhorro.setBenef1CuentaFamAhorro(null);
    	if (cuentaFamAhorro.getBenef2CuentaFamAhorro().getNombreBenefCuentaFamAhorro()=="")
    		cuentaFamAhorro.setBenef2CuentaFamAhorro(null);
    	this.cuentaFamAhorroServicio.guardarCuentaFamAhorroServicio(cuentaFamAhorro);
    	return true;
    }
    
    @RequestMapping(value="/actualizarfamahorro",method = RequestMethod.POST)
    @ResponseBody
    public boolean actualizarContratoFamAhorro(@ModelAttribute(value="cuentaFamAhorro") CuentaFamAhorro cuentaFamAhorro, BindingResult result){
    	System.out.println("<OTIKA>Actualizar-GuardarFAMAHORRO");
    	System.out.println("<OTIKA>"+cuentaFamAhorro.getFechaApertura());
    	System.out.println("<OTIKA>"+cuentaFamAhorro.getBenefOperadorCuentaFamAhorro().getNombreBenefCuentaFamAhorro());
    	if (cuentaFamAhorro.getBenef1CuentaFamAhorro().getNombreBenefCuentaFamAhorro()=="")
    		cuentaFamAhorro.setBenef1CuentaFamAhorro(null);
    	if (cuentaFamAhorro.getBenef2CuentaFamAhorro().getNombreBenefCuentaFamAhorro()=="")
    		cuentaFamAhorro.setBenef2CuentaFamAhorro(null);
    	this.cuentaFamAhorroServicio.actualizarCuentaFamAhorroServicio(cuentaFamAhorro);
    	return true;
    }
    
    @RequestMapping(value="/guardarinv",method = RequestMethod.POST)
    @ResponseBody
    public boolean guardarContratoFamAhorro(@ModelAttribute(value="cuentaFamAhorro") CuentaFamAhorroInversion cuentaFamAhorroInversion, BindingResult result){
    	System.out.println("<OTIKA>GuardarFAMAHORROINVERSION");
    	System.out.println("<OTIKA>"+cuentaFamAhorroInversion.getAfiliado().getIdAfiliado());
    	System.out.println("<OTIKA>"+cuentaFamAhorroInversion.getFechaApertura());
    	System.out.println("<OTIKA>"+cuentaFamAhorroInversion.getBenefOperadorCuentaFamAhorro().getNombreBenefCuentaFamAhorro());
    	this.cuentaFamAhorroInversionServicio.guardarCuentaFamAhorroServicio(cuentaFamAhorroInversion);
    	return true;
    }
    
    
    @RequestMapping(value="/getcuentasinvbyidafiliado",method = RequestMethod.POST)
    @ResponseBody
    public List<CuentaFamAhorroInversion> obtenerCuentasFamAhorroInvByIdAfiliado(@ModelAttribute(value="cuentaFamAhorroInversion") CuentaFamAhorroInversion cuentaFamAhorroInversion, BindingResult result){    	
    	System.out.println("<OTIKA>Buscar Cuentas Inversión FAMAhorro de Afiliado:"+cuentaFamAhorroInversion.getAfiliado().getIdAfiliado());
    	return this.cuentaFamAhorroInversionServicio.obtenerCuentasFamAhorroInvByIdAfiliado(cuentaFamAhorroInversion.getAfiliado().getIdAfiliado());
	}
    
    @RequestMapping(value="/getfamahorrobyidafiliado",method = RequestMethod.POST)
    @ResponseBody
    public CuentaFamAhorro obtenerCuentaFamAhorroByIdAfiliado(@ModelAttribute(value="cuentaFamAhorro") CuentaFamAhorro cuentaFamAhorro, BindingResult result){    	
    	System.out.println("<OTIKA>Buscar FAMAhorro de Afiliado:"+cuentaFamAhorro.getAfiliado().getIdAfiliado());
    	return this.cuentaFamAhorroServicio.obtenerCuentaFamAhorroByIdAfiliado(cuentaFamAhorro.getAfiliado().getIdAfiliado());
	}
    
    @RequestMapping(value="/getfamahorrobyidfamahorro",method = RequestMethod.POST)
    @ResponseBody
    public CuentaFamAhorro obtenerCuentaFamAhorroByIdFamAhorro(@ModelAttribute(value="cuentaFamAhorro") CuentaFamAhorro cuentaFamAhorro, BindingResult result){    	
    	System.out.println("<OTIKA>Buscar FAMAhorro con ID:"+cuentaFamAhorro.getIdCuentaFamAhorro());
    	try {
    		System.out.println("SIZE:"+this.cuentaFamAhorroServicio.obtenerCuentaFamAhorroByIdAfiliado2(cuentaFamAhorro).getSaldo());
    		return this.cuentaFamAhorroServicio.obtenerCuentaFamAhorroByIdAfiliado2(cuentaFamAhorro);
    	}
    	catch(Exception e){
    		System.out.println("ERROR"+ e.getMessage());
    	}
    	return null;
    	
	}
    
    @RequestMapping(value="/getfamahorrobyidafiliadoall",method = RequestMethod.POST)
    @ResponseBody
    public List obtenerDetalleCuentaFamAhorroByIdAfiliado(@ModelAttribute(value="cuentaFamAhorro") CuentaFamAhorro cuentaFamAhorro, BindingResult result){
    	List listaDetalleFamAhorro = new ArrayList();    	
    	System.out.println("<OTIKA>Buscar FAMAhorro de Afiliado:"+cuentaFamAhorro.getAfiliado().getIdAfiliado());
    	//cuentaFamAhorro= this.cuentaFamAhorroServicio.obtenerCuentaFamAhorroByIdAfiliado(cuentaFamAhorro.getAfiliado().getIdAfiliado());
    	listaDetalleFamAhorro.add(this.cuentaFamAhorroServicio.obtenerCuentaFamAhorroByIdAfiliado2(cuentaFamAhorro));
    	System.out.println("IDFAMAHORRO"+((CuentaFamAhorro) listaDetalleFamAhorro.get(0)).getIdCuentaFamAhorro());
    	List<BenefCuentaFamAhorro> beneficiariosCuentaFamAhorro = cuentaFamAhorroServicio.obtenerBeneficiariosCuentaFamAhorroByIdAfiliado(((CuentaFamAhorro) listaDetalleFamAhorro.get(0)).getIdCuentaFamAhorro());
    	System.out.println(beneficiariosCuentaFamAhorro.size());
    	for (int i = 0; i<beneficiariosCuentaFamAhorro.size();i++ ){
    		System.out.println(beneficiariosCuentaFamAhorro.size());
    		listaDetalleFamAhorro.add(beneficiariosCuentaFamAhorro.get(i));
    	}
    	return listaDetalleFamAhorro;
	}
    
    @RequestMapping(value="/getmovscuentafam",method = RequestMethod.POST)
    @ResponseBody
    public List<MovimientoFamAhorro> obtenerMovimientosFamAhorroByIdAfiliado(@ModelAttribute(value="cuentaFamAhorro") CuentaFamAhorro cuentaFamAhorro, BindingResult result){    	
    	System.out.println("<OTIKA>Buscar Movimientos FAMAhorro Inversión de la cuenta:"+cuentaFamAhorro.getAfiliado().getIdAfiliado());
    	return this.cuentaFamAhorroServicio.obtenerMovsFamAhorroByIdAfiliado(cuentaFamAhorro.getAfiliado().getIdAfiliado());
	}
    
    @RequestMapping(value="/getmovscuentafamahorrobyid",method = RequestMethod.POST)
    @ResponseBody
    public List<MovimientoFamAhorro> obtenerMovimientosFamAhorroByIdCuentaFam(@ModelAttribute(value="cuentaFamAhorro") CuentaFamAhorro cuentaFamAhorro, BindingResult result){    	
    	System.out.println("<OTIKA>Buscar Movimientos FAMAhorro de la cuenta:"+cuentaFamAhorro.getIdCuentaFamAhorro());
    	List<MovimientoFamAhorro> listaTmp = new ArrayList<MovimientoFamAhorro>();
    	listaTmp=this.cuentaFamAhorroServicio.obtenerMovsFamAhorroByIdFamAhorro(cuentaFamAhorro);  
    	System.out.println("<OTIKA>"+listaTmp.size());
    	return listaTmp;
	}
    
    @RequestMapping(value="/getmovscuentafaminv",method = RequestMethod.POST)
    @ResponseBody
    public List<MovimientoFamAhorroInversion> obtenerMovimientosFamAhorroInvByIdAfiliado(@ModelAttribute(value="cuentaFamAhorroInversion") CuentaFamAhorroInversion cuentaFamAhorroInversion, BindingResult result){    	
    	System.out.println("<OTIKA>Buscar Movimientos FAMAhorro Inversión de la cuenta:"+cuentaFamAhorroInversion.getIdCuentaFamAhorroInversion());
    	return this.cuentaFamAhorroInversionServicio.obtenerMovsFamAhorroByIdAfiliado(cuentaFamAhorroInversion.getIdCuentaFamAhorroInversion());
	}
    
    @RequestMapping(value="/getsaldocuentafam",method = RequestMethod.POST)
    @ResponseBody
    public double getSaldoCuentaFamAhorroByIdAfiliado(@ModelAttribute(value="cuentaFamAhorro") CuentaFamAhorro cuentaFamAhorro, BindingResult result){    	
    	System.out.println("<OTIKA>Buscar Saldo cuentaFAMAhorro de Afiliado:"+cuentaFamAhorro.getAfiliado().getIdAfiliado());
    	return this.cuentaFamAhorroServicio.getSaldoCuentaFamAhorroByIdAfiliado(cuentaFamAhorro.getAfiliado().getIdAfiliado());
	}
    
    @RequestMapping(value="/guardarmov",method = RequestMethod.POST)
    @ResponseBody
    public boolean guardarMovimientoFamAhorro(@ModelAttribute(value="MovimientoFamAhorro") MovimientoFamAhorro movimientoFamAhorro, BindingResult result){
    	System.out.println("<OTIKA>GuardarMovFAMAHORRO");    	
    	try{this.cuentaFamAhorroServicio.guardarMovimientoCuentaFamAhorro(movimientoFamAhorro);    	
    	}
    	catch(Exception e){
    		System.out.println("Error!"+e.getMessage());
    	}
    	return true;
    }
    
    @RequestMapping(value="/guardarmovimiento",method = RequestMethod.POST)
    @ResponseBody
    public MovimientoFamAhorro guardarMovFamAhorro(@ModelAttribute(value="movimientoFamAhorro") MovimientoFamAhorro movimientoFamAhorro, BindingResult result){
    	System.out.println("<OTIKA>GuardarMovFAMAHORRO de:"+movimientoFamAhorro.getIdMovimientoFamAhorro());    	
    	try{    		
            Calendar fecha = new GregorianCalendar();
            //Obtenemos el valor del año, mes, día,
            //hora, minuto y segundo del sistema
            //usando el método get y el parámetro correspondiente
            int año = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH);
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            movimientoFamAhorro.setFechaMovimientoFamAhorro(año+"/"+mes+"/"+dia);
            System.out.println(movimientoFamAhorro.getFechaMovimientoFamAhorro());
    		this.cuentaFamAhorroServicio.guardarMovimientoCuentaFamAhorroIndividual(movimientoFamAhorro);
    		System.out.println("<OTIKA>Movimiento registrado con éxito");
    		return movimientoFamAhorro;
    	}
    	catch(Exception e){
    		System.out.println("Error!"+e.getMessage());
    		return null;
    	}    	
    }
    
    @RequestMapping(value="/guardarmovinv",method = RequestMethod.POST)
    @ResponseBody
    public boolean guardarMovimientoFamAhorro(@ModelAttribute(value="MovimientoFamAhorroInversion") MovimientoFamAhorroInversion movimientoFamAhorro, BindingResult result){
    	System.out.println("<OTIKA>GuardarMovFAMAHORROInversión");    	
    	this.cuentaFamAhorroInversionServicio.guardarMovimientoCuentaFamAhorro(movimientoFamAhorro);
    	return true;
    }
    
    @RequestMapping(value="/actualizarmontodescuentofam",method = RequestMethod.POST)
    @ResponseBody
    public boolean actualizarMontoDescuentoFAM(@ModelAttribute(value="MontoDescuentoCuentaFam") MontoDescuentoCuentaFam montoDescuentoCuentaFam, BindingResult result){    	    
    	this.cuentaFamAhorroServicio.actualizarMontoDescuentoFAM(montoDescuentoCuentaFam);
    	return true;
    }
        
}
