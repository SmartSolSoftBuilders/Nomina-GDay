package mx.estrategas.fam.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import jxl.Sheet;
import jxl.Workbook;
import mx.estrategas.fam.modelo.Afiliado;
import mx.estrategas.fam.modelo.Archivo;
import mx.estrategas.fam.modelo.AseguradoBeneficioAdicional;
import mx.estrategas.fam.modelo.Beneficiario;
import mx.estrategas.fam.modelo.Escuela;
import mx.estrategas.fam.modelo.CertificadoAfiliado;
import mx.estrategas.fam.servicios.AfiliadoServicio;
import mx.estrategas.fam.servicios.AseguradoBeneficioAdicionalServicio;
import mx.estrategas.fam.servicios.ArchivoServicio;
import mx.estrategas.fam.servicios.CertificadoAfiliadoServicio;
import mx.estrategas.fam.servicios.BeneficiarioServicio;
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

/*
 * 
 * @author SmartSolutions
 *
 */
@Controller
@RequestMapping("/carga")
public class CargaMasivaController {	
	
	@Autowired
	private AfiliadoServicio afiliadoServicio;
	@Autowired
	private CertificadoAfiliadoServicio certificadoAfiliadoServicio;
	@Autowired
	private BeneficiarioServicio beneficiarioServicio;	
	@Autowired
	private  AseguradoBeneficioAdicionalServicio aseguradoServicio;
	@Autowired
	private ArchivoServicio archivoServicio;
	@Autowired
	private MttoSeguridadServicio mttoSeguridadServicio;

	private static final Logger log = LoggerFactory.getLogger(CargaMasivaController.class);
    
    /**
     * Devuelve el index de la aplicaciÃ³n.
     * @return ModelAndView que corresponde a la vista principal de la aplicaciÃ³n.
     */		    
    public @ModelAttribute("fileFormBean") FileFormBean getInitialMessage() {
    	System.out.println("Se crea el bean!");
        return new FileFormBean();
    }
 
    @RequestMapping(value="/carga", method = RequestMethod.POST)
    @ResponseBody
    public @ModelAttribute("message") String guardaFichero(@ModelAttribute FileFormBean fileFormBean){        
        try {
            grabarFicheroALocal(fileFormBean);
            Archivo archivo = new Archivo();
            archivo.setRutaArchivo(fileFormBean.getFichero().getOriginalFilename().toString());                       
            this.cargarExcel("c:/archivosZEUS/"+fileFormBean.getFichero().getOriginalFilename().toString());
            archivo.setFechaArchivo("2000-02-05");
            archivoServicio.guardarArchivo(archivo);
        }
        catch (Exception e) {
        	System.out.println("Error creando el archivo - Carga"+e.getMessage());
            e.printStackTrace();
            return "No se ha podido grabar el fichero";
        }
         
        return "Fichero grabado correctamente";
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
    		for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++){ // Recorre cada hoja                                                                                                                                                       					 
    			Sheet hoja = archivoExcel.getSheet(sheetNo); 
    			int numColumnas = hoja.getColumns(); 
    			int numFilas = hoja.getRows(); 
    			String data; 
    			//System.out.println("Nombre de la Hoja\t" + archivoExcel.getSheet(sheetNo).getName()); 
    			for (int fila = 1; fila < numFilas; fila++) { // Recorre cada 
    				//fila de la hoja
    				Afiliado afiliado = new Afiliado();
    				List <String> datos = new ArrayList<String>();
    				for (int columna = 0; columna < numColumnas; columna++) { // Recorre					
    					// cada columna de la fila                                                                                 
    					data = hoja.getCell(columna, fila).getContents();					
    					//System.out.print(data + " ->"+columna+"\n");	
    					datos.add(data);
    				} 				
					afiliado.setNombreAfiliado(datos.get(0));
					afiliado.setAppPaternoAfiliado(datos.get(1));
					afiliado.setAppMaternoAfiliado(datos.get(2));
					afiliado.setRfcAfiliado(datos.get(3));		
					afiliado.setFechaNacimientoAfiliado(datos.get(4));
					afiliado.setEstadoCivilAfiliado(datos.get(5));
					afiliado.setEstadoCivilAfiliado(datos.get(6));
					afiliado.setDireccionAfiliado(datos.get(7));
					afiliado.setColiniaAfiliado(datos.get(8));
					afiliado.setCpAfiliado(datos.get(9));
					afiliado.setEntidadAfiliado(datos.get(10));
					afiliado.setMunicipioAfiliado(datos.get(11));
					afiliado.setNacionalidadAfiliado(datos.get(12));
					afiliado.setPuestoAfiliado(datos.get(13));
					afiliado.setTelParticularAfiliado(datos.get(15));
					afiliado.setTelCelularAfiliado(datos.get(16));
					afiliado.setEmailAfiliado(datos.get(18));					
					int idAfiliadoTest=this.afiliadoServicio.getCountIdAfiliadoByRfc(afiliado.getRfcAfiliado());
					if (idAfiliadoTest==0){
						System.out.println("<OTIKA>Usuario aún no dado de alta");
						this.afiliadoServicio.guardarAfiliado(afiliado);
						int idAfiliado=this.afiliadoServicio.getIdAfiliadoByRfc(afiliado.getRfcAfiliado());
						if (idAfiliado != 0){
							System.out.println("Guardé al afiliado:"+idAfiliado+":"+afiliado.getNombreAfiliado());
							afiliado.setIdAfiliado(idAfiliado);
							//Se crea el certificado 
							CertificadoAfiliado certificadoAfiliado = new CertificadoAfiliado();
							certificadoAfiliado.setAfiliado(afiliado);
							certificadoAfiliado.setEstadoCertificadoAfiliado("ACTIVO");
							int numeroAleatorio = (int) (Math.random()*25+1);
							certificadoAfiliado.setNumeroCertificadoAfiliado(numeroAleatorio);
							this.certificadoAfiliadoServicio.guardarCertificadoAfiliado(certificadoAfiliado);					
							certificadoAfiliado=this.certificadoAfiliadoServicio.obtenerCertificadoAfiliadoById(idAfiliado);					
							System.out.println("Guardé el certificado:"+certificadoAfiliado.getIdCertificadoAfiliado());
							UsuarioSeguridad usuarioSeguridad = new UsuarioSeguridad();
							usuarioSeguridad.setNombre(afiliado.getRfcAfiliado());
							usuarioSeguridad.setUsername(afiliado.getRfcAfiliado());
							usuarioSeguridad.setPassword(afiliado.getRfcAfiliado());
							mttoSeguridadServicio.agregarUsuarioSeguridad(usuarioSeguridad);							
							if (datos.get(23)!="" && datos.get(23)!=null){
								Beneficiario beneficiario = new Beneficiario();							
								beneficiario.setNombreBeneficiario(datos.get(23));
								beneficiario.setAppBeneficiario(datos.get(24));
								beneficiario.setApmBeneficiario(datos.get(25));
								if (datos.get(26).equals("SI"))
									beneficiario.setRevocableBeneficiario(1);
								else
									beneficiario.setRevocableBeneficiario(0);
								if (datos.get(27).equals("SI"))
									beneficiario.setIrrevocableBeneficiario(1);
								else
									beneficiario.setIrrevocableBeneficiario(0);
								if (datos.get(28)!="" && datos.get(28)!=null)
									beneficiario.setFechaNacimientoBeneficiario(datos.get(28));
								else
									beneficiario.setFechaNacimientoBeneficiario("1900-02-02");
								if (datos.get(29)!="" && datos.get(29)!=null)
									beneficiario.setEdadBeneficiario(Integer.parseInt(datos.get(29)));
								beneficiario.setParentescoBeneficiario(datos.get(30));
								beneficiario.setPorcentajeBeneficiario(datos.get(31));																					
								beneficiario.setPorcentajeBeneficiarioDos(datos.get(32));								
								beneficiario.setCertificadoAfiliado(certificadoAfiliado);
								this.beneficiarioServicio.guardarBeneficiario(beneficiario);
								System.out.println("Guardé un nuevo beneficiario!");
							}
							if (datos.get(33)!="" && datos.get(33)!=null){
								Beneficiario beneficiario = new Beneficiario();							
								beneficiario.setNombreBeneficiario(datos.get(33));
								beneficiario.setAppBeneficiario(datos.get(34));
								beneficiario.setApmBeneficiario(datos.get(35));
								if (datos.get(36).equals("SI"))
									beneficiario.setRevocableBeneficiario(1);
								else
									beneficiario.setRevocableBeneficiario(0);
								if (datos.get(37).equals("SI"))
									beneficiario.setIrrevocableBeneficiario(1);
								else
									beneficiario.setIrrevocableBeneficiario(0);
								if (datos.get(38)!="" && datos.get(38)!=null)
									beneficiario.setFechaNacimientoBeneficiario(datos.get(36));
								else
									beneficiario.setFechaNacimientoBeneficiario("1900-02-02");								
								if (datos.get(39)!="" && datos.get(39)!=null)
									beneficiario.setEdadBeneficiario(Integer.parseInt(datos.get(39)));
								beneficiario.setParentescoBeneficiario(datos.get(40));
								beneficiario.setPorcentajeBeneficiario(datos.get(41));																					
								beneficiario.setPorcentajeBeneficiarioDos(datos.get(42));																
								beneficiario.setCertificadoAfiliado(certificadoAfiliado);
								this.beneficiarioServicio.guardarBeneficiario(beneficiario);
								System.out.println("Guardé un nuevo beneficiario!");
							}
							if (datos.get(43)!="" && datos.get(43)!=null){
								Beneficiario beneficiario = new Beneficiario();							
								beneficiario.setNombreBeneficiario(datos.get(43));
								beneficiario.setAppBeneficiario(datos.get(44));
								beneficiario.setApmBeneficiario(datos.get(45));
								if (datos.get(46).equals("SI"))
									beneficiario.setRevocableBeneficiario(1);
								else
									beneficiario.setRevocableBeneficiario(0);
								if (datos.get(47).equals("SI"))
									beneficiario.setIrrevocableBeneficiario(1);
								else
									beneficiario.setIrrevocableBeneficiario(0);
								if (datos.get(48)!="" && datos.get(48)!=null)
									beneficiario.setFechaNacimientoBeneficiario(datos.get(48));
								else
									beneficiario.setFechaNacimientoBeneficiario("1900-02-02");								
								if (datos.get(49)!="" && datos.get(49)!=null)
									beneficiario.setEdadBeneficiario(Integer.parseInt(datos.get(49)));
								beneficiario.setPorcentajeBeneficiario(datos.get(50));					
								beneficiario.setPorcentajeBeneficiario(datos.get(51));
								beneficiario.setPorcentajeBeneficiarioDos(datos.get(52));
								beneficiario.setCertificadoAfiliado(certificadoAfiliado);
								this.beneficiarioServicio.guardarBeneficiario(beneficiario);
								System.out.println("Guardé un nuevo beneficiario!");
							}
							if (datos.get(53)!="" && datos.get(53)!=null){
								AseguradoBeneficioAdicional asegurado = new AseguradoBeneficioAdicional();
								//APELLIDOPATERNO	APELLIDOMATERNO	FECHANACIMIENTO	EDAD	PARENTESCO	PORCENTAJE
								asegurado.setNombreAseguradoBeneficioAdicional(datos.get(53));
								asegurado.setAppAseguradoBeneficioAdicional(datos.get(54));
								asegurado.setApmAseguradoBeneficioAdicional(datos.get(55));
								if (datos.get(56)!="" && datos.get(56)!=null)
									asegurado.setFechaNacimientoAseguradoBeneficioAdicional(datos.get(56));
								else
									asegurado.setFechaNacimientoAseguradoBeneficioAdicional("1900-02-02");
								if (datos.get(57)!="" && datos.get(57)!=null)
									asegurado.setEdadAseguradoBeneficioAdicional(Integer.parseInt(datos.get(57)));
								asegurado.setParentescoAseguradoBeneficioAdicional(datos.get(58));								
								asegurado.setCertificadoAfiliado(certificadoAfiliado);			
								this.aseguradoServicio.guardarAseguradoBeneficioAdicional(asegurado);
							}
							if (datos.get(60)!="" && datos.get(60)!=null){
								AseguradoBeneficioAdicional asegurado = new AseguradoBeneficioAdicional();
								//APELLIDOPATERNO	APELLIDOMATERNO	FECHANACIMIENTO	EDAD	PARENTESCO	PORCENTAJE
								asegurado.setNombreAseguradoBeneficioAdicional(datos.get(60));
								asegurado.setAppAseguradoBeneficioAdicional(datos.get(61));
								asegurado.setApmAseguradoBeneficioAdicional(datos.get(62));								
								if (datos.get(63)!="" && datos.get(63)!=null)
									asegurado.setFechaNacimientoAseguradoBeneficioAdicional(datos.get(61));
								else
									asegurado.setFechaNacimientoAseguradoBeneficioAdicional("1900-02-02");
								if (datos.get(64)!="" && datos.get(64)!=null)
									asegurado.setEdadAseguradoBeneficioAdicional(Integer.parseInt(datos.get(64)));
								asegurado.setParentescoAseguradoBeneficioAdicional(datos.get(65));
								asegurado.setCertificadoAfiliado(certificadoAfiliado);				
								this.aseguradoServicio.guardarAseguradoBeneficioAdicional(asegurado);
							}
							if (datos.get(67)!="" && datos.get(67)!=null){
								AseguradoBeneficioAdicional asegurado = new AseguradoBeneficioAdicional();
								//APELLIDOPATERNO	APELLIDOMATERNO	FECHANACIMIENTO	EDAD	PARENTESCO	PORCENTAJE
								asegurado.setNombreAseguradoBeneficioAdicional(datos.get(67));
								asegurado.setAppAseguradoBeneficioAdicional(datos.get(68));
								asegurado.setApmAseguradoBeneficioAdicional(datos.get(69));								
								if (datos.get(70)!="" && datos.get(70)!=null)
									asegurado.setFechaNacimientoAseguradoBeneficioAdicional(datos.get(68));
								else
									asegurado.setFechaNacimientoAseguradoBeneficioAdicional("1900-02-02");
								if (datos.get(71)!="" && datos.get(71)!=null)
									asegurado.setEdadAseguradoBeneficioAdicional(Integer.parseInt(datos.get(71)));
								asegurado.setParentescoAseguradoBeneficioAdicional(datos.get(72));
								asegurado.setCertificadoAfiliado(certificadoAfiliado);				
								this.aseguradoServicio.guardarAseguradoBeneficioAdicional(asegurado);
							}
						}
					}
					else
						System.out.println("Se interrumpió el insert de afiliado porque ya existe!");
    			} 
    		} 
    	}
    	catch (Exception ioe) { 
    		System.out.println("Error:"+ioe.getMessage());
    		ioe.printStackTrace(); 
    	} 
    	return true;
    }    
}
