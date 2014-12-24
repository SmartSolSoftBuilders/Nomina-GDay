package mx.estrategas.fam.web.controller;

import java.io.File;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import jxl.Sheet;
import jxl.Workbook;
import mx.estrategas.fam.modelo.Afiliado;
import mx.estrategas.fam.modelo.Archivo;
import mx.estrategas.fam.modelo.CuentaFamAhorro;
import mx.estrategas.fam.modelo.CertificadoAfiliado;
import mx.estrategas.fam.modelo.MovimientoFamAhorro;
import mx.estrategas.fam.servicios.AfiliadoServicio;
import mx.estrategas.fam.servicios.ArchivoServicio;

import mx.estrategas.fam.servicios.CertificadoAfiliadoServicio;
import mx.estrategas.fam.servicios.BeneficiarioServicio;
import mx.estrategas.fam.servicios.CuentaFamAhorroServicio;
import mx.estrategas.fam.web.util.FileFormBean;
import mx.estrategas.fam.web.util.ReadExcel;
import mx.estrategas.seguridad.modelo.UsuarioSeguridad;
import mx.estrategas.seguridad.servicios.MttoSeguridadServicio;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * @author SmartSolutions
 *
 */
@Controller
@RequestMapping("/cargasaldo")
public class CargaSaldoController {	
	
	@Autowired
	private AfiliadoServicio afiliadoServicio;
	@Autowired
	private CuentaFamAhorroServicio cuentaFamAhorroservicio;
	@Autowired
	private BeneficiarioServicio beneficiarioServicio;	
	@Autowired
	private ArchivoServicio archivoServicio;
	@Autowired
	private MttoSeguridadServicio mttoSeguridadServicio;

	private static final Logger log = LoggerFactory.getLogger(CargaSaldoController.class);
    
    /**
     * Devuelve el index de la aplicaciÃ³n.
     * 
     * @return ModelAndView que corresponde a la vista principal de la aplicaciÃ³n.
     */		    
    public @ModelAttribute("fileFormBean") FileFormBean getInitialMessage() {
    	System.out.println("Se crea el bean!");
        return new FileFormBean();
    }
 
    @RequestMapping(value="/cargasaldo", method = RequestMethod.POST)
    @ResponseBody
    public @ModelAttribute("message") ModelAndView guardaFichero(@ModelAttribute FileFormBean fileFormBean){
    	ModelAndView modelAndView = new ModelAndView("carga/return_carga_saldos");
        try {
            grabarFicheroALocal(fileFormBean);
            Archivo archivo = new Archivo();
            archivo.setRutaArchivo(fileFormBean.getFichero().getOriginalFilename().toString());                       
            this.cargarExcel("c:/archivosZEUS/"+fileFormBean.getFichero().getOriginalFilename().toString());
            Calendar fecha = new GregorianCalendar();
            int año = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH);
            int dia = fecha.get(Calendar.DAY_OF_MONTH);                 		 
            archivo.setFechaArchivo(año+"/"+(mes+1)+"/"+dia);
            archivoServicio.guardarArchivo(archivo);
            modelAndView.addObject("msjCargaSaldos", "Carga finalizada con éxito");            
        }
        catch (Exception e) {
        	System.out.println("ErrorCarga"+e.getMessage());
            e.printStackTrace();
            modelAndView.addObject("msjCargaSaldos", "Errores en la carga!");
            return modelAndView;
        }
         System.out.println("Terminada la carga del archivo!");
        //return "Fichero grabado correctamente";          		 
         return modelAndView;
    }        
    
    private void grabarFicheroALocal(FileFormBean fileFormBean) throws Exception {
        CommonsMultipartFile uploaded = fileFormBean.getFichero();
        File localFile = new File("c:/archivosZEUS/"+uploaded.getOriginalFilename());        
        FileOutputStream os = null;         
        try {             
            os = new FileOutputStream(localFile);
            os.write(uploaded.getBytes());
        }
        finally {
            if (os != null) {
                try {
                	os.close();
                } catch (IOException e) {
                	System.out.println("<OTIKA>Error al guardar el archivo:"+e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }
 
    public boolean cargarExcel(String nombreArchivo){    
    	try {
    		//System.out.println("se carga el archivo:"+nombreArchivo);
    		Workbook archivoExcel = Workbook.getWorkbook(new File(nombreArchivo));    		
    		File logCargaMasiva= new File ("c:/archivosZEUS/logCargaMasivaTmp.txt");
    		FileWriter w = new FileWriter(logCargaMasiva,true);
    		BufferedWriter bw = new BufferedWriter(w);
    		PrintWriter wr = new PrintWriter(bw);  
    		//wr.write("Esta es una linea de codigo");
            Calendar fecha = new GregorianCalendar();
            int año = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH);
            int dia = fecha.get(Calendar.DAY_OF_MONTH);             
    		wr.append("\nRegistro de Carga de Saldos ->>>>>>>>>>>"+ dia + "/" + (mes+1) + "/" + año+"\n");
    		for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++){ // Recorre cada hoja                                                                                                                                                       					 
    			Sheet hoja = archivoExcel.getSheet(sheetNo); 
    			int numColumnas = hoja.getColumns(); 
    			int numFilas = hoja.getRows(); 
    			String data; 
    			for (int fila = 1; fila < numFilas; fila++) { // Recorre cada 
    				//fila de la hoja
    				CuentaFamAhorro cuentaFamAhorro = new CuentaFamAhorro();
    				MovimientoFamAhorro movimientoFamAhorro = new MovimientoFamAhorro();
    				Afiliado afiliado = new Afiliado();
    				List <String> datos = new ArrayList<String>();
    				for (int columna = 0; columna < numColumnas; columna++) { // Recorre					
    					data = hoja.getCell(columna, fila).getContents();					
    					datos.add(data);
    				} 				
					afiliado.setRfcAfiliado(datos.get(0));
					System.out.println("Reg Movimiento del Afiliado:"+datos.get(0));
					wr.append("\nReg Movimiento del Afiliado:"+datos.get(0));
					CuentaFamAhorro checkCuenta = new CuentaFamAhorro();
					if (datos.get(1)!="")
						checkCuenta.setIdCuentaFamAhorro(Integer.parseInt(datos.get(1)));
					else
						checkCuenta.setIdCuentaFamAhorro(0);
					Afiliado afiliadoTmp = new Afiliado();
					int idTmp=afiliadoServicio.getIdAfiliadoByRfc(datos.get(0));
					//System.out.println("ID Tmp Afiliado"+idTmp);
					afiliadoTmp.setIdAfiliado(idTmp); 
					checkCuenta.setAfiliado(afiliadoTmp);
					wr.append("\tId Cuenta FAMAHORRO:"+datos.get(1)+"\n");					
					checkCuenta = this.cuentaFamAhorroservicio.obtenerCuentaFamAhorroByIdAfiliado2(checkCuenta);			
					System.out.println("checkCuenta");
					System.out.println(checkCuenta);										
					if (checkCuenta!=null){				
						System.out.println("checkCuenta id Cuenta FAM Ahorro"+checkCuenta.getIdCuentaFamAhorro());
						wr.append("\tMovimiento:"+datos.get(2));
						wr.append("\tMonto:"+datos.get(3));
						movimientoFamAhorro.setIdMovimientoFamAhorro(checkCuenta.getIdCuentaFamAhorro());
						movimientoFamAhorro.setTipoMovimientoFamAhorro(datos.get(2));
						movimientoFamAhorro.setMontoMovimientoFamAhorro(new Double(datos.get(3)));
						movimientoFamAhorro.setDocumentoRefMovimientoFamAhorro(datos.get(4));
						movimientoFamAhorro.setFechaMovimientoFamAhorro(datos.get(5));																		
						if (checkCuenta!=null){							
								this.cuentaFamAhorroservicio.guardarMovimientoCuentaFamAhorroIndividual(movimientoFamAhorro);							
						}			
						else{
							//System.out.println("Se interrumpió el update porque el afiliado no está registrado!");
							wr.append("Se omitio el registro porque la cuenta FAM AHORRO No existe:"+datos.get(0)+"\n");
						}
	    			}
					else
						wr.append("Se omitio el registro porque el afiliado no esta registrado:"+datos.get(0)+"\n");
    			}
    		}     		
    		wr.append("\n-------------------------------------------\n");
    		wr.close();
    		bw.close();
    	}
    	catch (Exception ioe) {     		
    		System.out.println("Error:"+ioe.getMessage());
    		ioe.printStackTrace(); 
    	} 
    	return true;
    }    
}
