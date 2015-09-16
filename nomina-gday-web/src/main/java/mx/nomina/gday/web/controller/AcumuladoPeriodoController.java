package mx.nomina.gday.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.nomina.gday.modelo.AcumuladoPeriodo;
import mx.nomina.gday.modelo.Empleado;
import mx.nomina.gday.modelo.Nomina;
import mx.nomina.gday.modelo.Periodo;
import mx.nomina.gday.servicios.AcumuladoPeriodoServicio;
import mx.nomina.gday.servicios.EmpleadoMongoServicio;
import mx.nomina.gday.servicios.NominaServicio;
import mx.nomina.gday.web.util.UploadFile;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/acumulado")
public class AcumuladoPeriodoController {
	
	@Autowired
	private AcumuladoPeriodoServicio  acumuladoPeriodoServicio;

	@Autowired
	private EmpleadoMongoServicio empleadoMongoServicio;
	
	@Autowired
	private NominaServicio nominaServicio;
	
	UploadFile ufile;	
	public AcumuladoPeriodoController(){
		System.out.println("init AcumuladoPeriodoController");
		ufile = new UploadFile();
	}


	 @RequestMapping(value="/subiracumuladoPeriodo", method = RequestMethod.POST)
	 public @ResponseBody ModelAndView guardaFichero(MultipartHttpServletRequest request, HttpServletResponse response
			 , ModelAndView mav){  
	 	Iterator<String> itr =request.getFileNames();
	 	MultipartFile mpf = request.getFile(itr.next());
	 	AcumuladoPeriodo acumuladoPeriodo=new AcumuladoPeriodo();
	 	Integer existeArchivo=0;
	     try {
	     	ufile.idEvento = mpf.getBytes().length;
	 		ufile.length = mpf.getBytes().length;
	 		ufile.bytes= mpf.getBytes();
	 		ufile.type = mpf.getContentType();
	 		ufile.name = mpf.getOriginalFilename();		
	 		//Check file name
	 		existeArchivo=this.acumuladoPeriodoServicio.obtenerAcumuladosByName( mpf.getOriginalFilename());
	 		System.out.println( mpf.getOriginalFilename());
	 		System.out.println(this.acumuladoPeriodoServicio.obtenerAcumuladosByName( mpf.getOriginalFilename()));
	 		System.out.println("EXISTE EL ARChivO?"+existeArchivo);
	 		if (existeArchivo==0){
	 		//Saving file
		 		Nomina nomina= new Nomina();
		 		String periodo = request.getParameter("idPeriodo");
		 		String anioPago = request.getParameter("anioPagoHid");
		 		String mesPago = request.getParameter("mesPagoHid");
		 		
		 		Integer idNomina = Integer.parseInt(request.getParameter("idNomina"));	 		
		 		nomina.setIdNomina(idNomina);
		 		acumuladoPeriodo.setNumeroPeriodo(periodo);
		 		acumuladoPeriodo.setNomina(nomina);
		 		acumuladoPeriodo.setAnioPago(anioPago);
		 		acumuladoPeriodo.setMesPago(mesPago);
		 		System.out.println("TIPO DE ARCHIVO:"+ufile.type);
		 		String tipoArchivo="";
				if (ufile.type.equals("application/excel") || ufile.type.equals("application/vnd.ms-excel"))				
					tipoArchivo="xls";			
				else
					tipoArchivo="xlsx";			
				System.out.println();
				acumuladoPeriodo.setTipoArchivo(tipoArchivo);
		 		acumuladoPeriodo.setNombreArchivo(ufile.name);
		 		acumuladoPeriodo.setArchivoAcumulado(mpf.getBytes());
		 		System.out.println("Done"+ufile.length+acumuladoPeriodo.getArchivoAcumulado().length);
		 		if (this.acumuladoPeriodoServicio.validarArchivo(acumuladoPeriodo)){
		 			int idAcumulado=this.acumuladoPeriodoServicio.agregarArchivo(acumuladoPeriodo);
		 			System.out.println("ID Acumulado obtenido:"+idAcumulado);	 			
		 			acumuladoPeriodo.setIdAcumuladoPeriodo(acumuladoPeriodo.getId().intValue());
		     		this.empleadoMongoServicio.guardarDocumento(acumuladoPeriodo);
		 		}
		 		System.out.println("LOS VALORES DEL ARCHIVO:"+acumuladoPeriodo.getArchivoAcumulado().length);		
		 		FileOutputStream fos = new FileOutputStream("C://archivosNGDAY//tmpAcumulado."+tipoArchivo);
		 	    fos.write(acumuladoPeriodo.getArchivoAcumulado());
		 	    fos.close();
		 	   request.getSession().setAttribute("notification", "Archivo de Acumulado Guardado satifactoriamente!");
	 		}	 		
	     }
	     catch (Exception e) {
	     	System.out.println("Error creando el archivo - Carga"+e.getMessage());
	         e.printStackTrace();
	         return null;
	     }
	     String mensaje="Archivo grabado correctamente";
	     
	     if (existeArchivo==0){
	    	 mav.addObject("notification", "Guardado satifactoriamente!");
	     }
	     else{
	    	 mav.addObject("notification", "El archivo ya existe!");
	    	 request.getSession().setAttribute("notification", "El Archivo de Acumulado ya existe!");
	     }
	     mav.setViewName("acumulados/acumulado_periodo");
	     return mav;
	 }   
	
	 //LLENADO DEL SELECT COMBO, PERIODO
	 //Obteber los datos de Ejecutivo y Esquema para el llenado de sus respectivos Combos
	 @RequestMapping(value="/getdatoscombo",method = RequestMethod.POST)
	    @ResponseBody
	    public List obtenerDatosCombo(){
		 	System.out.println("Controller Datos del combo");
			return this.acumuladoPeriodoServicio.obtenerDatosCombo();
		}
	
	 //Obteber los datos de Ejecutivo y Esquema para el llenado de sus respectivos Combos
	 @RequestMapping(value="/getdatoscombonsscurp",method = RequestMethod.POST)
	    @ResponseBody
	    public List obtenerDatosComboNssCurp(int idNomina){
		 	System.out.println("Buscando Datos de:"+idNomina);		 	
			return this.acumuladoPeriodoServicio.obtenerDatosComboNssCurp(idNomina);
		}
	
	 
	 //Controller que muestra la lista de Acumulados
	 @RequestMapping(value="/getacumulados",method = RequestMethod.POST)
	    @ResponseBody
	    public List obtenerAcumulados(AcumuladoPeriodo acumuladoPeriodo){    	
		  
		  System.out.println("Controller Acumulado"+acumuladoPeriodo.getAnioPago());
		  System.out.println("Controller Acumulado"+acumuladoPeriodo.getMesPago());
		  System.out.println("Controller Acumulado"+acumuladoPeriodo.getNumeroPeriodo());
		  try {
			List<AcumuladoPeriodo> tmp =  this.acumuladoPeriodoServicio.obtenerAcumuladosByIdNominaAndIdPeriodo(acumuladoPeriodo);
			System.out.println("tmp"+tmp.size());
			List acumuladosTmp = new ArrayList();
			List acumuladosTmp2 = new ArrayList<String>();

			for (int i = 0; i < tmp.size(); i++) {
				acumuladosTmp2 = new ArrayList<String>();
				System.out.println("tmp"+tmp.get(i));
				acumuladosTmp2.add(tmp.get(i).getIdAcumuladoPeriodo());
				acumuladosTmp2.add(tmp.get(i).getNombreArchivo());				
				acumuladosTmp2.add("<a href='#' onclick='ajax_download("+tmp.get(i).getIdAcumuladoPeriodo()+")'>Descargar</a>");
				acumuladosTmp2.add("<a href='#' onclick='eliminarAcumulado("+tmp.get(i).getIdAcumuladoPeriodo()+")'><img src='../../static/img/eliminar.png' width='27' height='27'></img></a>");
				acumuladosTmp.add(acumuladosTmp2);
			}
			return acumuladosTmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		  return null;
	 }


		@RequestMapping(value="/obteneracumulado",method = RequestMethod.POST)
	    @ResponseBody
	    public void getFile(HttpServletRequest request,HttpServletResponse response) {
			java.util.Date fecha = new Date();
			File fileToDownload = null;
	        InputStream inputStream = null;
	        Integer idAcumulado=Integer.parseInt(request.getParameter("id1"));
	        System.out.println("buscando el registro de nómina:"+idAcumulado);
	 		try{            
				//fileToDownload = this.hojaTrabajoServicio.generarHojaTrabajo(idHojaTrabajo);
				fileToDownload=acumuladoPeriodoServicio.obtenerArchivoAcumulado(idAcumulado);
				String ext= acumuladoPeriodoServicio.obtenerArchivoAcumuladoExt(idAcumulado);
	            inputStream = new FileInputStream(fileToDownload);
	            response.setContentType("application/force-download");
	            response.setHeader("Content-Disposition", "attachment; filename="+"acumulado-"+fecha+"."+ext); 
	            IOUtils.copy(inputStream, response.getOutputStream());
	            response.flushBuffer();
	        }catch(Exception e){            
	            e.printStackTrace();
	        }
	 
	    }	 			
		
		@RequestMapping(value="/obteneracumuladoval",method = RequestMethod.POST)
	    @ResponseBody
	    public void getFile2(HttpServletRequest request,HttpServletResponse response) {
			File fileToDownload = null;
	        InputStream inputStream = null;
	        System.out.println("DATOSssss");
	        Integer id1=Integer.parseInt(request.getParameter("id1"));
	        String id2=request.getParameter("id2").toString();
	        String id3=request.getParameter("id3").toString();
	        String id4=request.getParameter("id4").toString();
	       
	        System.out.println("buscando el registro de nómina:"+id1);
	        System.out.println("buscando el registro de nómina:"+id2);
	        System.out.println("buscando el registro de nómina:"+id3);
	        System.out.println("buscando el registro de nómina:"+id4);
	 		try{            
				//fileToDownload = this.hojaTrabajoServicio.generarHojaTrabajo(idHojaTrabajo);
	 			List tmp2=this.empleadoMongoServicio.obtenerDocumentos(id1, id2, id3,id4);
	 			System.out.println("Num Registros:"+tmp2.size());
				fileToDownload=acumuladoPeriodoServicio.obtenerArchivoAcumuladoByData(tmp2);
	            inputStream = new FileInputStream(fileToDownload);
	            response.setContentType("application/force-download");
	            response.setHeader("Content-Disposition", "attachment; filename="+"acumulado.xlsx"); 
	            IOUtils.copy(inputStream, response.getOutputStream());
	            response.flushBuffer();
	        }catch(Exception e){            
	            e.printStackTrace();
	        }
	 
	    }
								 
		 @RequestMapping(value="/eliminaracumuladoPeriodo", method = RequestMethod.POST)
		 @ResponseBody
		 public boolean eliminarAcumulado(@ModelAttribute(value="acumuladoPeriodo") AcumuladoPeriodo acumuladoPeriodo, BindingResult result){
			 System.out.println("Eliminando:"+acumuladoPeriodo.getIdAcumuladoPeriodo());
			 //Eliminando de BD
			 this.acumuladoPeriodoServicio.eliminarAcumulado(acumuladoPeriodo);
			 //Eliminando de Mongo			 
			 this.empleadoMongoServicio.eliminarDocumento(acumuladoPeriodo);
			 return true;
		 }   

}
