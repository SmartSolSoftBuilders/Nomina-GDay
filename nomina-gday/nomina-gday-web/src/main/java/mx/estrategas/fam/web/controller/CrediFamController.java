package mx.estrategas.fam.web.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


import java.io.InputStream;
import java.io.StringReader;
import java.io.FileOutputStream;
import java.io.StringReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;



import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.estrategas.fam.modelo.Afiliado;
import mx.estrategas.fam.modelo.Cotizacion;
import mx.estrategas.fam.modelo.Escuela;
import mx.estrategas.fam.modelo.Pago;
import mx.estrategas.fam.modelo.Reporte;
import mx.estrategas.fam.servicios.AfiliadoServicio;
import mx.estrategas.fam.servicios.CotizacionServicio;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/credifam")
public class CrediFamController {
	
	@Autowired
	private AfiliadoServicio afiliadoServicio;
	
	@Autowired
	private CotizacionServicio cotizacionServicio;
	
	
	 @RequestMapping(value="/cotizador", method = RequestMethod.GET)
	    public ModelAndView mostrarDatosAfiliado(HttpServletRequest request)
	            throws ServletException, IOException{
		 
		int idAfiliado=(Integer) request.getSession().getAttribute("idAfiliado");		
		Afiliado afiliado = afiliadoServicio.obtenerAfiliadoById(idAfiliado);
		System.out.println("CREDIFAM"+afiliado.getEscuelas().size());
		return new ModelAndView("credifam/cotizador", "afiliado", afiliado);		 
	 }
	 
	 
	 @RequestMapping(value="/obtenerTablaPagos", method = RequestMethod.POST)
	 @ResponseBody
	 public List<Pago> generarTablaPagos(@ModelAttribute(value="cotizacion") Cotizacion cotizacion, BindingResult result){
		
		 cotizacion=  cotizacionServicio.obtenerPagoCotizacion(cotizacion);		 
		 
		 return cotizacion.getPagos();	 		 
	 }
	 
	 
	 @RequestMapping(value="/guardarCotizacion",method = RequestMethod.POST)
	    @ResponseBody
	    public Cotizacion guardarCotizacion(@ModelAttribute(value="cotizacion")  Cotizacion cotizacion, BindingResult result, HttpServletRequest request){
		
		 int idAfiliado=(Integer) request.getSession().getAttribute("idAfiliado");		
		 Afiliado afiliado = afiliadoServicio.obtenerAfiliadoById(idAfiliado);
		 System.out.println("CREDIFAM"+afiliado);
		 cotizacion.setAfiliado(afiliado);
		 
		 cotizacion=cotizacionServicio.guardarCotizacion(cotizacion);
		 
		 //Recuperar la cotizacion completa con el id q se recibe		 
		 //saber que id de cotizacion es 
		 System.out.println("id_cotizacion"+cotizacion.getIdCotizacion());
 		 return cotizacion;
	    }
	 
	 
	 @RequestMapping(value="/getCotizacionesByAfiliado",method = RequestMethod.POST)
	    @ResponseBody
	    public List obtenerCotizaciones(@ModelAttribute(value="cotizacion") Cotizacion cotizacion, HttpServletRequest request,BindingResult result){
	    	System.out.println("Controller");    
	    	int idAfiliado=(Integer) request.getSession().getAttribute("idAfiliado");	
	    	Afiliado afiliado = new Afiliado();
	    	afiliado.setIdAfiliado(idAfiliado);
	    	cotizacion.setAfiliado(afiliado);
	    	List<Cotizacion> cotizaciones = (List<Cotizacion>) this.cotizacionServicio.obtenerCotizaciones((Cotizacion) cotizacion);

	    	System.out.println(cotizacion.getAfiliado());
	    	
	    	List cotizacionesDataTable = new ArrayList<String>();
	    	List cotizacionesDataTableTmp = new ArrayList<String>();
	    	
	    	for (int i=0; i<cotizaciones.size();i++){
	    		cotizacionesDataTableTmp = new ArrayList<String>();
	    		cotizacionesDataTableTmp.add(cotizaciones.get(i).getIdCotizacion());	    		
	    		cotizacionesDataTableTmp.add(cotizaciones.get(i).getPlazoPagos());
	    		cotizacionesDataTableTmp.add(cotizaciones.get(i).getPlazoCredito());	    		
	    		cotizacionesDataTableTmp.add(cotizaciones.get(i).getNumeroPagos());
	    		cotizacionesDataTableTmp.add(cotizaciones.get(i).getFormaPago());	    		
	    		cotizacionesDataTableTmp.add(cotizaciones.get(i).getDescuentoMensual());	    		
	    		cotizacionesDataTableTmp.add(cotizaciones.get(i).getDescuentoGestion());
	    		cotizacionesDataTableTmp.add(cotizaciones.get(i).getCreditoTotal());	    		
	    		cotizacionesDataTableTmp.add(cotizaciones.get(i).getPagototal());
	    		cotizacionesDataTableTmp.add(cotizaciones.get(i).getFechaCotizacion());
	    		cotizacionesDataTableTmp.add(cotizaciones.get(i).getEstatus());
	    		cotizacionesDataTable.add(cotizacionesDataTableTmp);
	    		
	    	}
			return cotizacionesDataTable;
		}
	 
	 @RequestMapping(value="/htmlToPdf",method = RequestMethod.POST)
	    
	    public void htmlToPdf (@ModelAttribute(value="cotizacion") Cotizacion cotizacion, 
	    		HttpServletRequest request,HttpServletResponse response,BindingResult result)
	            throws ServletException, IOException{
		 System.out.println(cotizacion.getFormaPago());
	        System.out.println("HTML:"+cotizacion.getIdCotizacion());
	        int idCot=Integer.parseInt(request.getParameter("txt").toString());
	        
	    	File fileToDownload = null;
	        InputStream inputStream = null;
	        try {
	        
	        //Recuperar la cotizacion completa, con el id que se recibe		 
	        cotizacion.setIdCotizacion(idCot);
			System.out.println("CREDIFAM"+cotizacion.getIdCotizacion());
	        cotizacion=this.cotizacionServicio.obtenerCotizacionById(cotizacion.getIdCotizacion());

			int idAfiliado=(Integer) request.getSession().getAttribute("idAfiliado");		
			Afiliado afiliado = afiliadoServicio.obtenerAfiliadoById(idAfiliado);
			cotizacion.setAfiliado(afiliado);
			 
			cotizacion=  cotizacionServicio.obtenerPagoCotizacion(cotizacion);	

			//Obtener la tabla de pagos 1
			List<Pago> pagos = cotizacion.getPagos();
			DecimalFormat df = new DecimalFormat("#.##");
			String t1 = "<table border=1><tr  bgcolor='#FF7514'><td>No.Pago</td><td>Pagos</td><td>Capital</td><td>Intereses</td><td>Saldo Insoluto</td></tr>";
			for (int i = 0; i < pagos.size()/2; i++) {
					t1 += "<tr>";
					t1 += "<td>" + (i + 1 ) + "</td><td>"
							+ pagos.get(i).getPago() + "</td><td>"
							+ df.format(pagos.get(i).getCapital())+ "</td><td>"
							+ df.format(pagos.get(i).getInteres())+ "</td><td>"
							+ df.format(pagos.get(i).getSaldoInsoluto())+ "</td>";
					
					t1 += "</tr>";
			}
			 t1=t1+"</table>";
			 //Obtener la tabla de pagos 2
			String t2 = "<table border=1><tr  bgcolor='#FF7514'><td>No.Pago</td><td>Pagos</td><td>Capital</td><td>Intereses</td><td>Saldo Insoluto</td></tr>";
				for (int i = (pagos.size()/2); i <pagos.size() ; i++) {
					
					
					if( pagos.get(i).getSaldoInsoluto() < 0){						
						
						pagos.get(i).setSaldoInsoluto((float) 0);
						
					}
					t2 += "<tr>";
					t2 += "<td>" + (i + 1) + "</td><td>"
							+ pagos.get(i).getPago() + "</td><td>"
							+ df.format(pagos.get(i).getCapital())+ "</td><td>"
							+ df.format(pagos.get(i).getInteres())+ "</td><td>"
							+ df.format(pagos.get(i).getSaldoInsoluto())+ "</td>";
				
					t2 += "</tr>";
				}
				t2=t2+"</table>";
			//Obtener la lista de escuelas
			String escuelasReporte="";
			
			for (int i = 0; i < afiliado.getEscuelas().size(); i++) {
				 if (i>=0){
					escuelasReporte=escuelasReporte+afiliado.getEscuelas().get(i).getNombreEscuela();
					escuelasReporte= escuelasReporte + ",";
				}
			
			}
			System.out.println("escuelas"+escuelasReporte);
			
			//Cambiar de true, false a SI y NO
			 boolean miembroFamTmp = cotizacion.isMiembrofam();
			 String miembroFam="";
			if (miembroFamTmp == true) {
				miembroFam = "SI";
				System.out.println("MIEMBROFAM:" + miembroFam);
			} else if (miembroFamTmp == false) {
				miembroFam = "NO";
				System.out.println("MIEMBROFAM:" + miembroFam);
			}
			
	        String formularioHTML="";
	        formularioHTML=	"<table><tr><td><label style='color:#6E6E6E;font-weight: bold;'>COTIZACIÓN CRÉDITO PERSONAL</label>&nbsp;<label style='color:#6E6E6E;font-weight: bold;'>DESCUENTO POR NÓMINA</label></td></tr></table>"+
	        "<table border=1><tr><td  bgcolor='#FF7514'>Empleado</td><td>"+cotizacion.getAfiliado().getNombreAfiliado()+"&nbsp;"+cotizacion.getAfiliado().getAppPaternoAfiliado()+"&nbsp;"+cotizacion.getAfiliado().getAppMaternoAfiliado()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Antigüedad</td><td>"+cotizacion.getAfiliado().getAntiguedadAfiliado()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Tasa Fija Anual(IVA INCLUIDO)</td><td>"+cotizacion.getTasaFijaAnual()+"%"+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>CAT*</td><td>"+cotizacion.getCat()+"%"+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Tasa de comisión de gestión</td><td>"+cotizacion.getTasaComisionGestion()+"%"+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Escuela</td><td>"+escuelasReporte+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Sueldo Bruto Quincenal</td><td>$"+cotizacion.getSueldoBrutoQuincenal()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Sueldo Neto Quincenal</td><td>$"+cotizacion.getSueldoNeto()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Quincenas de Gracia</td><td>"+cotizacion.getQuincenasDeGracia()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Miembro FAM</td><td>"+miembroFam+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Credito Solicitado</td><td>$"+cotizacion.getCreditoSolicitado()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Crédito Máximo Alcanzado</td><td>$"+cotizacion.getCreditoMaximoAlcanzado()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Plazo Pagos</td><td>"+cotizacion.getPlazoPagos()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Plazo Creditos</td><td>"+cotizacion.getPlazoCredito()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Número de Pagos</td><td>"+cotizacion.getNumeroPagos()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Forma de Pago</td><td>"+cotizacion.getFormaPago()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Gestión FAM</td><td>$"+cotizacion.getGestionFam()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Descuento</td><td>$"+cotizacion.getDescuentoMensual()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Descuento Gestión</td><td>$"+cotizacion.getDescuentoGestion()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Crédito Total</td><td>$"+cotizacion.getCreditoTotal()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Pago Total</td><td>$"+cotizacion.getPagototal()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Fecha de Cotización</td><td>"+cotizacion.getFechaCotizacion()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Estatus</td><td>"+cotizacion.getEstatus()+"</td></tr>"+"</table>";
	        System.out.println("formularioHTML"+formularioHTML);
	        System.out.println("t1"+t1);
	        System.out.println("t2"+t2);
	        
	        formularioHTML=formularioHTML+"<table><tr><td><label style='color:#6E6E6E;font-weight: bold;'>TABLA DE PAGOS</label></td></tr></table>"+t1+t2;
	       
	            Document document = new Document(PageSize.LETTER);
	            PdfWriter.getInstance(document, new FileOutputStream("C://Users//Doraly Hernández//Desktop//Cot-"+cotizacion.getIdCotizacion()+".pdf"));
	         
	            HTMLWorker htmlWorker = new HTMLWorker(document);
	            document.open();
	            String formulario="";
	            formulario=formularioHTML;
	            String str = "<html><head></head><body>"+formularioHTML+        
	              "</body></html>";
	            htmlWorker.parse(new StringReader(str));
	            document.close();
	            
	            fileToDownload=new File("C://Users//Doraly Hernández//Desktop//Cot-"+cotizacion.getIdCotizacion()+".pdf");
	            inputStream=new FileInputStream(fileToDownload);
	            response.setContentType("text/html");
	            response.setHeader("Content-Disposition", "attachment; filename="+"Cot-"+cotizacion.getIdCotizacion()+".pdf"); 
	            IOUtils.copy(inputStream, response.getOutputStream());
	            response.flushBuffer();
	            System.out.println("Done");
	            
	            }
	          catch (Exception e) {
	        	 System.out.println("ERROR:"+e.getMessage());
	            e.printStackTrace();
	          }	     
			  
	 }
	 
	 @RequestMapping(value="/htmlToPdf2",method = RequestMethod.POST)
	    
	    public void htmlToPdf2 (@ModelAttribute(value="cotizacion") Cotizacion cotizacion, 
	    		HttpServletRequest request,HttpServletResponse response,BindingResult result)
	            throws ServletException, IOException{
		 System.out.println(cotizacion.getFormaPago());
	        int idCot=Integer.parseInt(request.getParameter("txt").toString());
	        
	    	File fileToDownload = null;
	        InputStream inputStream = null;
	        try {
	        
	        //Recuperar la cotizacion completa, con el id que se recibe		 
	        cotizacion.setIdCotizacion(idCot);

	        System.out.println("CREDIFAM"+cotizacion.getIdCotizacion());
	        cotizacion=this.cotizacionServicio.obtenerCotizacionById(cotizacion.getIdCotizacion());

			cotizacion=  cotizacionServicio.obtenerPagoCotizacion(cotizacion);	

			//Obtener la tabla de pagos 1
			List<Pago> pagos = cotizacion.getPagos();
			DecimalFormat df = new DecimalFormat("#.##");
			String t1 = "<table border=1><tr  bgcolor='#FF7514'><td>No.Pago</td><td>Pagos</td><td>Capital</td><td>Intereses</td><td>Saldo Insoluto</td></tr>";
			for (int i = 0; i < pagos.size()/2; i++) {
					t1 += "<tr>";
					t1 += "<td>" + (i + 1 ) + "</td><td>"
							+ pagos.get(i).getPago() + "</td><td>"
							+ df.format(pagos.get(i).getCapital())+ "</td><td>"
							+ df.format(pagos.get(i).getInteres())+ "</td><td>"
							+ df.format(pagos.get(i).getSaldoInsoluto())+ "</td>";
					
					t1 += "</tr>";
			}
			 t1=t1+"</table>";
			 //Obtener la tabla de pagos 2
			String t2 = "<table border=1><tr  bgcolor='#FF7514'><td>No.Pago</td><td>Pagos</td><td>Capital</td><td>Intereses</td><td>Saldo Insoluto</td></tr>";
				for (int i = (pagos.size()/2); i <pagos.size() ; i++) {
					
					
					if( pagos.get(i).getSaldoInsoluto() < 0){						
						
						pagos.get(i).setSaldoInsoluto((float) 0);
						
					}
					t2 += "<tr>";
					t2 += "<td>" + (i + 1) + "</td><td>"
							+ pagos.get(i).getPago() + "</td><td>"
							+ df.format(pagos.get(i).getCapital())+ "</td><td>"
							+ df.format(pagos.get(i).getInteres())+ "</td><td>"
							+ df.format(pagos.get(i).getSaldoInsoluto())+ "</td>";
				
					t2 += "</tr>";
				}
				t2=t2+"</table>";
			//Obtener la lista de escuelas
			String escuelasReporte="";
			
			
			//Cambiar de true, false a SI y NO
			 boolean miembroFamTmp = cotizacion.isMiembrofam();
			 String miembroFam="";
			if (miembroFamTmp == true) {
				miembroFam = "SI";
				System.out.println("MIEMBROFAM:" + miembroFam);
			} else if (miembroFamTmp == false) {
				miembroFam = "NO";
				System.out.println("MIEMBROFAM:" + miembroFam);
			}
			
	        String formularioHTML="";
	        formularioHTML=	"<table><tr><td><label style='color:#6E6E6E;font-weight: bold;'>COTIZACIÓN CRÉDITO PERSONAL</label>&nbsp;<label style='color:#6E6E6E;font-weight: bold;'>DESCUENTO POR NÓMINA</label></td></tr></table>"+
	        "<table border=1><tr><td  bgcolor='#FF7514'>Empleado</td><td>"+cotizacion.getAfiliado().getNombreAfiliado()+"&nbsp;"+cotizacion.getAfiliado().getAppPaternoAfiliado()+"&nbsp;"+cotizacion.getAfiliado().getAppMaternoAfiliado()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Antigüedad</td><td>"+cotizacion.getAfiliado().getAntiguedadAfiliado()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Tasa Fija Anual(IVA INCLUIDO)</td><td>"+cotizacion.getTasaFijaAnual()+"%"+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>CAT*</td><td>"+cotizacion.getCat()+"%"+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Tasa de comisión de gestión</td><td>"+cotizacion.getTasaComisionGestion()+"%"+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Escuela</td><td>"+escuelasReporte+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Sueldo Bruto Quincenal</td><td>$"+cotizacion.getSueldoBrutoQuincenal()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Sueldo Neto Quincenal</td><td>$"+cotizacion.getSueldoNeto()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Quincenas de Gracia</td><td>"+cotizacion.getQuincenasDeGracia()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Miembro FAM</td><td>"+miembroFam+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Credito Solicitado</td><td>$"+cotizacion.getCreditoSolicitado()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Crédito Máximo Alcanzado</td><td>$"+cotizacion.getCreditoMaximoAlcanzado()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Plazo Pagos</td><td>"+cotizacion.getPlazoPagos()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Plazo Creditos</td><td>"+cotizacion.getPlazoCredito()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Número de Pagos</td><td>"+cotizacion.getNumeroPagos()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Forma de Pago</td><td>"+cotizacion.getFormaPago()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Gestión FAM</td><td>$"+cotizacion.getGestionFam()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Descuento</td><td>$"+cotizacion.getDescuentoMensual()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Descuento Gestión</td><td>$"+cotizacion.getDescuentoGestion()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Crédito Total</td><td>$"+cotizacion.getCreditoTotal()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Pago Total</td><td>$"+cotizacion.getPagototal()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Fecha de Cotización</td><td>"+cotizacion.getFechaCotizacion()+"</td></tr>"+
	        "<tr><td  bgcolor='#FF7514'>Estatus</td><td>"+cotizacion.getEstatus()+"</td></tr>"+"</table>";
	        System.out.println("formularioHTML"+formularioHTML);
	        System.out.println("t1"+t1);
	        System.out.println("t2"+t2);
	        
	        formularioHTML=formularioHTML+"<table><tr><td><label style='color:#6E6E6E;font-weight: bold;'>TABLA DE PAGOS</label></td></tr></table>"+t1+t2;
	       
	            Document document = new Document(PageSize.LETTER);
	            PdfWriter.getInstance(document, new FileOutputStream("C://Users//Doraly Hernández//Desktop//Cot-"+cotizacion.getIdCotizacion()+".pdf"));
	         
	            HTMLWorker htmlWorker = new HTMLWorker(document);
	            document.open();
	            String formulario="";
	            formulario=formularioHTML;
	            String str = "<html><head></head><body>"+formularioHTML+        
	              "</body></html>";
	            htmlWorker.parse(new StringReader(str));
	            document.close();
	            
	            fileToDownload=new File("C://Users//Doraly Hernández//Desktop//Cot-"+cotizacion.getIdCotizacion()+".pdf");
	            inputStream=new FileInputStream(fileToDownload);
	            response.setContentType("text/html");
	            response.setHeader("Content-Disposition", "attachment; filename="+"Cot-"+cotizacion.getIdCotizacion()+".pdf"); 
	            IOUtils.copy(inputStream, response.getOutputStream());
	            response.flushBuffer();
	            System.out.println("Done");
	            
	            }
	          catch (Exception e) {
	        	 System.out.println("ERROR:"+e.getMessage());
	            e.printStackTrace();
	          }	     
			  
	 }
	 
	 @RequestMapping(value="/getCotizacionesPendientes",method = RequestMethod.POST)
	    @ResponseBody
	    public List obtenerCotizacionesPendientes (HttpServletRequest request){
	    	System.out.println("Controller");    
	    	List<Cotizacion> cotizaciones = (List<Cotizacion>) this.cotizacionServicio.obtenerCotizacionesPendientes();	    	
	    	List cotizacionesDataTable = new ArrayList<String>();
	    	List cotizacionesDataTableTmp = new ArrayList<String>();
	    	
	    	for (int i=0; i<cotizaciones.size();i++){
	    		cotizacionesDataTableTmp = new ArrayList<String>();
	    		cotizacionesDataTableTmp.add(cotizaciones.get(i).getIdCotizacion());	    		
	    		cotizacionesDataTableTmp.add(cotizaciones.get(i).getPlazoPagos());
	    		cotizacionesDataTableTmp.add(cotizaciones.get(i).getPlazoCredito());	    		
	    		cotizacionesDataTableTmp.add(cotizaciones.get(i).getNumeroPagos());
	    		cotizacionesDataTableTmp.add(cotizaciones.get(i).getFormaPago());	    		
	    		cotizacionesDataTableTmp.add(cotizaciones.get(i).getDescuentoMensual());	    		
	    		cotizacionesDataTableTmp.add(cotizaciones.get(i).getDescuentoGestion());
	    		cotizacionesDataTableTmp.add(cotizaciones.get(i).getCreditoTotal());	    		
	    		cotizacionesDataTableTmp.add(cotizaciones.get(i).getPagototal());
	    		cotizacionesDataTableTmp.add(cotizaciones.get(i).getFechaCotizacion());
	    		cotizacionesDataTableTmp.add("<a href='#' onclick='ajax_download("+cotizaciones.get(i).getIdCotizacion()+")'>Ver Pdf</a>");
	    		cotizacionesDataTableTmp.add("<a href='#' onclick='establecerEstatus("+cotizaciones.get(i).getIdCotizacion()+",\"ACEPTADA\")'>Aceptar</a><a href='#' onclick='establecerEstatus("+cotizaciones.get(i).getIdCotizacion()+",\"RECHAZADA\")'>Rechazar</a>");			
	    		cotizacionesDataTable.add(cotizacionesDataTableTmp);		
	    		
	    	}
			return cotizacionesDataTable;
		}
	 
	 //Cambiar Estatus de la cotización
	 
	 @RequestMapping(value="/setEstatusCotizacion",method = RequestMethod.POST)
	    @ResponseBody
	    public boolean establecerEstatusCotizacion (Cotizacion cotizacion){
		 
		 try{
	    		if (cotizacion.getEstatus()!= null){
	    				boolean valor=cotizacionServicio.establecerEstatusCotizacion(cotizacion);
	    		}
	    		else return false;
	    			
	    	}
	    	catch (Exception e){
	    		System.out.println("Error! al actualizar el estatus de la cotizacion"+e.getMessage());
	    		return false;
	    	}
		  return true;		 
	 }
}
