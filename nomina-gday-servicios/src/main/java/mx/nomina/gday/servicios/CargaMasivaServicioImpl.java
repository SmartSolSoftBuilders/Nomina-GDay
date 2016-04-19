package mx.nomina.gday.servicios;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import mx.nomina.gday.dao.ArchivoDao;
import mx.nomina.gday.dao.EmpleadoDao;
import mx.nomina.gday.dao.EmpleadoNominaDao;
import mx.nomina.gday.modelo.Archivo;
import mx.nomina.gday.modelo.Area;
import mx.nomina.gday.modelo.Departamento;
import mx.nomina.gday.modelo.Empleado;
import mx.nomina.gday.modelo.EmpleadoNomina;
import mx.nomina.gday.modelo.Nomina;
import mx.nomina.gday.modelo.Proceso;
import mx.nomina.gday.modelo.Puesto;



//Save commit
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargaMasivaServicioImpl implements CargaMasivaServicio {

	@Autowired
	private EmpleadoDao empleadoDao;
	
	@Autowired
	private ArchivoDao archivoDao;
	
	@Autowired
	private EmpleadoNominaDao empleadoNominaDao;
	
	@Override
	public String cargarExcel(String nombreArchivo,String tipoArchivo, Long long1) {
		StringBuffer strBMain= new StringBuffer();
    	try {
    		//System.out.println("se carga el archivo:"+nombreArchivo);    		
    		FileInputStream file = new FileInputStream(nombreArchivo);
    		
    		HSSFWorkbook workbook = null;
	    	Workbook workbookxlsx = null;
	    	Sheet hoja= null;
	    	if (tipoArchivo.equals("xls")){
	    		workbook = new HSSFWorkbook(file);
	    		hoja = workbook.getSheetAt(0);
	    	}
	    	else{
	    		workbookxlsx = new XSSFWorkbook(file); //or new HSSFWorkbook();
	    		hoja = workbookxlsx.getSheetAt(0);
	    	}    		
        	System.out.println("nombre de archivo"+nombreArchivo);
        	//Se llena el encabezado        			        	
    			int numColumnas = 97; 
    			int numFilas = 2000; 
    			int cargados=0;
    			int rechazados=0;
    			String data; 
    			//System.out.println("Nombre de la Hoja\t" + archivoExcel.getSheet(sheetNo).getName());
    			int filaNum=3;
    			Row fila = hoja.getRow(filaNum);
    			System.out.println("Num filas:"+hoja.getLastRowNum());
    			for (; filaNum < hoja.getLastRowNum()-1; filaNum++) { // Recorre cada 
    				//fila de la hoja
    				fila = hoja.getRow(filaNum);
    				Empleado empleado = new Empleado();
    				List <String> datos = new ArrayList<String>();
    				for (int columna = 0; columna < numColumnas-1; columna++) { // Recorre					
    					// cada columna de la fila
    					//System.out.print(" ->"+columna+"\n");	    					
    					if (fila.getCell(columna)!=null){
    						fila.getCell(columna).setCellType(Cell.CELL_TYPE_STRING);
    						data = fila.getCell(columna).getStringCellValue();
    					}
    					else{
    						data = "";    						
    					}
    					//System.out.print(data + " ->"+columna+"\n");	
    					datos.add(data);
    				}
    				
    				if (datos.get(0)=="" || datos.get(0).length()==0){
    					strBMain.append("Se encontró registro vacío, se interrumpe la carga\n");
    					System.out.println("Se encontró registro vacío, se interrumpe la carga");
    					break;
    				}    	
    				boolean validarFormatoFechas=true;
    				//DATOS DE EMPLEADO
    				empleado.setNoControl(datos.get(0));
    				empleado.setNss(datos.get(1));
    				empleado.setCurp(datos.get(2));
    				empleado.setApellidoPaterno(datos.get(3));
    				empleado.setApellidoMaterno(datos.get(4));
    				empleado.setNombre(datos.get(5));
    				empleado.setRfc(datos.get(6));    				
    				if (validarFormatoFecha(datos.get(7))){
    					empleado.setFechaNacimiento(datos.get(7));
    				}
    				else{
    					strBMain.append("Para El Empleado:"+empleado.getNss()+"La fecha de Nacimiento: "+ datos.get(7)+ " No cumple el formato deseado yyyy-mm-dd.Se interrumpe la carga.\n");
    					validarFormatoFechas=false;
    				}    			
    				if (datos.get(8)!="")
    					empleado.setEdad(Integer.parseInt(datos.get(8)));
    				else
    					empleado.setEdad(0);
    				empleado.setSexo(datos.get(9));
    				empleado.setPaisOrigen(datos.get(10));
    				empleado.setNacionalidad(datos.get(11));
    				empleado.setEstadoCivil(datos.get(12));
    				empleado.setCorreoElectronico(datos.get(13));
    				if (validarFormatoFecha(datos.get(14))){
    					empleado.setFechaIngresoReal(datos.get(14));
    				}
    				else{
    					strBMain.append("Para El Empleado:"+empleado.getNss()+"La fecha de Ingreso Real: "+ datos.get(14)+ " No cumple el formato deseado yyyy-mm-dd.Se interrumpe la carga.\n");
    					validarFormatoFechas=false;
    				}    				
    				if (datos.get(15)!="")
    					empleado.setListaNegra(Boolean.parseBoolean(datos.get(15)));
    				else
    					empleado.setListaNegra(false);
    				empleado.setCalle(datos.get(16));
    				empleado.setNumExterior(datos.get(17));
    				empleado.setNumInterior(datos.get(18));
    				empleado.setColonia(datos.get(19));
    				if (datos.get(20).length()>2)
    					empleado.setCodigoPostal(Integer.parseInt(datos.get(20)));
    				else
    					empleado.setCodigoPostal(0);
    				empleado.setMunicipioDel(datos.get(21));
    				empleado.setEntFederativa(datos.get(22));
    				if (datos.get(23)!=""){
    					if (datos.get(23).equals("SI"))
    						empleado.setDocIfe(true);
    					else
    						empleado.setDocIfe(false);
    				}
    				else
    					empleado.setDocIfe(false);
    				if (datos.get(24)!=""){
    					if (datos.get(24).equals("SI"))
    						empleado.setDocActNan(true);
    					else
    						empleado.setDocActNan(false);
    				}    					
    				else
    					empleado.setDocActNan(false);
    				if (datos.get(25)!=""){
    					if (datos.get(25).equals("SI"))
    						empleado.setDocCurp(true);
    					else
    						empleado.setDocCurp(false);
    				}    					    					
    				else
    					empleado.setDocCurp(false);
    				if (datos.get(26)!=""){
    					if (datos.get(26).equals("SI"))
    						empleado.setDocRfc(true);
    					else
    						empleado.setDocRfc(false);
    				}    					    					
    				else
    					empleado.setDocRfc(false);    			
    				if (datos.get(27)!=""){
    					if (datos.get(27).equals("SI"))
    						empleado.setDocComprobante(true);
    					else
    						empleado.setDocComprobante(false);
    				}    	    					
    				else
    					empleado.setDocComprobante(false);
    				if (datos.get(28)!=""){
    					if (datos.get(28).equals("SI"))
    						empleado.setDocCompEst(true);
    					else
    						empleado.setDocCompEst(false);
    				}    	    					
    				else
    					empleado.setDocCompEst(false);
    				if (datos.get(29)!=""){
    					if (datos.get(29).equals("SI"))
    						empleado.setDocCorreo(true);
    					else
    						empleado.setDocCorreo(false);
    				}    	    			    					
    				else
    					empleado.setDocCorreo(false);
    				if (datos.get(30)!=""){
    					if (datos.get(30).equals("SI"))
    						empleado.setDocPreafiliacion(true);
    					else
    						empleado.setDocPreafiliacion(false);
    				}    	    			       					
    				else
    					empleado.setDocPreafiliacion(false);
    				
    				empleado.setCuenta(datos.get(31));
    				empleado.setBanco(datos.get(32));
    				empleado.setTipoPago(datos.get(33));
    				empleado.setNoCredInfonavit(datos.get(34));
    				System.out.println(datos.get(35).length());
    				System.out.println(datos.get(35));
    				if (datos.get(35).length()>0)  					
    					empleado.setDescInfonavitVsmg(Double.parseDouble(datos.get(35)));
    				else
    					empleado.setDescInfonavitVsmg(0);
    				if (datos.get(36).length()>0)
    					empleado.setDesInfonavitPorc(Double.parseDouble(datos.get(36)));
    				else
    					empleado.setDesInfonavitPorc(0);
    				if (datos.get(37).length()>0) 
    					empleado.setDescInfonavitImp(Double.parseDouble(datos.get(37)));
    				else
    					empleado.setDescInfonavitImp(0);
    				if (datos.get(38).length()>0)
    					empleado.setDescFonacotPago(Double.parseDouble(datos.get(38)));
    				else
    					empleado.setDescFonacotPago(0);
    				if (datos.get(39).length()>0)	
    					empleado.setDescFonacotNum(Double.parseDouble(datos.get(39)));
    				else
    					empleado.setDescFonacotNum(0);
    				if (datos.get(40).length()>0) 
    					empleado.setPensionAlimImp(Double.parseDouble(datos.get(40)));
    				else
    					empleado.setPensionAlimImp(0);
    				if (datos.get(41).length()>0)
    					empleado.setPensionAlimPorc(Double.parseDouble(datos.get(41)));
    				else
    					empleado.setPensionAlimPorc(0);
    				if (datos.get(42).length()>0)
    					empleado.setPensionAlimAcred(datos.get(42));
    				else
    					empleado.setPensionAlimAcred("0");
					empleado.setPensionAlimObs(datos.get(43));
					if (datos.get(44)!=""){
						empleado.setReconoceAntiguedad(Boolean.parseBoolean(datos.get(44)));
					}
					if (datos.get(45)!=""){
						empleado.setDocumentoMigratorio(datos.get(45));
					}
					System.out.println("FECHA DOC MIG:"+datos.get(46).length());
					if (datos.get(46)!="" && datos.get(46)!=null && datos.get(46).length()>0){
						System.out.println("No está vacía la fecha");
						if  (!validarFormatoFecha(datos.get(46))){									
							strBMain.append("Para El Empleado:"+empleado.getNss()+"La fecha de Documento Migratorio: "+ datos.get(46)+ " No cumple el formato deseado yyyy-mm-dd.No se registró el empleado.\n");
							validarFormatoFechas=false;
						}
						else{
							empleado.setFechaVigenciaDocumentoMigratorio(datos.get(46));
						}
					}
					else
						empleado.setFechaVigenciaDocumentoMigratorio("");
					strBMain.append("Se intenta Guardar:"+empleado.getNss()+"\n");	
    				int idEmpleadoTest=this.empleadoDao.obtenerCountIdEmpleadoByNss(empleado.getNss());
					if (idEmpleadoTest==0 && validarFormatoFechas){
						validarFormatoFechas=true;
						this.empleadoDao.agregarEmpleado(empleado);						
						Long idEmpleado = empleado.getId();
						if (idEmpleado!= 0){
							strBMain.append("Se guarda al Empleado!\n");
							//System.out.println("Guardé al Empleado:"+idEmpleado+":"+empleado.getNombre());
							empleado.setIdEmpleado(Integer.parseInt(""+idEmpleado));
							//System.out.println("Supuesto empleado:"+datos.get(44));
							if (datos.get(47)!="" && datos.get(47)!=null){								
								EmpleadoNomina empleadoNomina = new EmpleadoNomina();
								Nomina nomina=new Nomina();
								empleado.setIdEmpleado(Integer.parseInt(""+empleado.getId()));
								nomina.setIdNomina(Integer.parseInt(datos.get(47)));
								empleadoNomina.setNomina(nomina);
								empleadoNomina.setEmpleado(empleado);
								//System.out.println("Fecha de Ingreso Nomina:"+datos.get(45));
								if  (validarFormatoFecha(datos.get(48))){
									empleadoNomina.setFechaIngreso(datos.get(48));
								}
								else{
									strBMain.append("Para El Empleado:"+empleado.getNss()+" La fecha de Ingreso: "+ datos.get(48)+ " No cumple el formato deseado yyyy-mm-dd. Se creó el empleado, pero no se registró en la nómina.\n");
									validarFormatoFechas=false;
								}								
								empleadoNomina.setEstatus(datos.get(49));
								empleadoNomina.setTipoSalario(datos.get(50));
								//System.out.println("FechaBaja"+datos.get(48));
								empleadoNomina.setFechaBaja(datos.get(51));
								if (datos.get(51).length()>0){								
									if  (!validarFormatoFecha(datos.get(51))){									
										strBMain.append("Para El Empleado:"+empleado.getNss()+" La fecha de Baja: "+ datos.get(51)+ " No cumple el formato deseado yyyy-mm-dd. Se creó el empleado, pero no se registró en la nómina.\n");
										validarFormatoFechas=false;
									}
								}								
								empleadoNomina.setLoteMovImssAlta(datos.get(52));
								empleadoNomina.setFechaVencimiento(datos.get(53));
								if (datos.get(53).length()>0){								
									if  (!validarFormatoFecha(datos.get(53))){									
										strBMain.append("Para El Empleado:"+empleado.getNss()+" La fecha de Vencimiento: "+ datos.get(53)+ " No cumple el formato deseado yyyy-mm-dd. Se creó el empleado, pero no se registró en la nómina.\n");
										validarFormatoFechas=false;
									}
								}
								System.out.println("FechaVenc"+datos.get(53));
								if (datos.get(54).length()>0)
									empleadoNomina.setSueldoMensual(Double.parseDouble(datos.get(54)));
								else
									empleadoNomina.setSueldoMensual(0);
								if (datos.get(55).length()>0)
									empleadoNomina.setSalarioDiarioInt(Double.parseDouble(datos.get(55)));
								else
									empleadoNomina.setSalarioDiarioInt(0);
								if (datos.get(56).length()>0)
									empleadoNomina.setSueldoDiario(Double.parseDouble(datos.get(56)));
								else
									empleadoNomina.setSueldoDiario(0);
								empleadoNomina.setPlazaTrabajo(datos.get(57));
								empleadoNomina.setNumeroTrabajadorCliente(datos.get(58));
								if (datos.get(59)!="")
									empleadoNomina.setOtroPatron(Boolean.parseBoolean(datos.get(59)));
								else
									empleadoNomina.setOtroPatron(false);
								empleadoNomina.setRfcOtroPatron(datos.get(60));
								empleadoNomina.setNombreOtroPatron(datos.get(61));
								if (datos.get(62)!="")
									empleadoNomina.setPermanencia(Boolean.parseBoolean(datos.get(62)));
								empleadoNomina.setCalle(datos.get(63));
								empleadoNomina.setCodigoPostal(datos.get(64));
								empleadoNomina.setMunicipioDel(datos.get(65));
								empleadoNomina.setEntFederativa(datos.get(66));
								if (datos.get(67).length()>0)
									empleadoNomina.setLoteMovImssBaja(Integer.parseInt(datos.get(67)));
								else
									empleadoNomina.setLoteMovImssBaja(0);
								empleadoNomina.setAplicaFiniquito(Boolean.parseBoolean(datos.get(68)));
								if (datos.get(69).length()>0)
									empleadoNomina.setMontoFiniquito(Double.parseDouble(datos.get(69)));
								else
									empleadoNomina.setMontoFiniquito(0);
								empleadoNomina.setArea(obtenerArea(datos.get(70)));
								empleadoNomina.setDepartamento(obtenerDepartamento(datos.get(71)));
								empleadoNomina.setProceso(obtenerProceso(datos.get(72)));
								empleadoNomina.setPuesto(obtenerPuesto(datos.get(73)));								
								empleadoNomina.setTipoContrato(datos.get(74));
								System.out.println("GUARDANDO!");
								if (validarFormatoFechas){
									/*for (Field field : empleadoNomina.getClass().getDeclaredFields()) {
									    field.setAccessible(true);
									    String name = field.getName();
									    Object value = field.get(empleadoNomina);
									    System.out.printf("Field name: %s, Field value: %s%n", name, value);
									}*/
									System.out.println(nomina.getIdNomina());
									System.out.println(empleado.getIdEmpleado());
									this.empleadoNominaDao.agregarEmpleadoNomina(empleadoNomina);
								}
								
								System.out.println("Guardé un nuevo empleado nomina!");
							}
							System.out.println("Empleado nomina:"+datos.get(75));
							if (datos.get(75)!="" && datos.get(75)!=null && datos.get(75).length()>0){			
								//System.out.println("Empleado nomina:"+datos.get(74).length());
								EmpleadoNomina empleadoNomina = new EmpleadoNomina();
								Nomina nomina=new Nomina();
								empleado.setIdEmpleado(Integer.parseInt(""+empleado.getId()));
								nomina.setIdNomina(Integer.parseInt(datos.get(75)));
								empleadoNomina.setNomina(nomina);
								empleadoNomina.setEmpleado(empleado);
								//System.out.println("Fecha de Ingreso Nomina:"+datos.get(45));
								if  (validarFormatoFecha(datos.get(76))){
									empleadoNomina.setFechaIngreso(datos.get(76));
								}
								else{
									strBMain.append("Para El Empleado:"+empleado.getNss()+"La fecha de Ingreso: "+ datos.get(76)+ " No cumple el formato deseado yyyy-mm-dd. Se creó el empleado, pero no se registró en la nómina.\n");
									validarFormatoFechas=false;
								}
								empleadoNomina.setEstatus(datos.get(77));
								empleadoNomina.setTipoSalario(datos.get(78));								
								//System.out.println("FechaBaja"+datos.get(48));
								empleadoNomina.setFechaBaja(datos.get(79));
								System.out.println(datos.get(79).length());
								if (datos.get(79).length()>2){								
									if  (!validarFormatoFecha(datos.get(78))){									
										strBMain.append("Para El Empleado:"+empleado.getNss()+" La fecha de Baja: "+ datos.get(79)+ " No cumple el formato deseado yyyy-mm-dd. Se creó el empleado, pero no se registró en la nómina.\n");
										validarFormatoFechas=false;
									}
								}								
								empleadoNomina.setLoteMovImssAlta(datos.get(80));
								empleadoNomina.setFechaVencimiento(datos.get(81));
								if (datos.get(81).length()>0){								
									if  (!validarFormatoFecha(datos.get(81))){									
										strBMain.append("Para El Empleado:"+empleado.getNss()+" La fecha de Vencimiento: "+ datos.get(80)+ " No cumple el formato deseado yyyy-mm-dd. Se creó el empleado, pero no se registró en la nómina.\n");
										validarFormatoFechas=false;
									}
								}
								System.out.println("FechaVenc"+datos.get(81));
								if (datos.get(82)!="")
									empleadoNomina.setSueldoMensual(Double.parseDouble(datos.get(82)));
								else
									empleadoNomina.setSueldoMensual(0);
								if (datos.get(83).length()>0)
									empleadoNomina.setSalarioDiarioInt(Double.parseDouble(datos.get(83)));
								else
									empleadoNomina.setSalarioDiarioInt(0);
								if (datos.get(84).length()>0)
									empleadoNomina.setSueldoDiario(Double.parseDouble(datos.get(84)));
								else
									empleadoNomina.setSueldoDiario(0);
								empleadoNomina.setPlazaTrabajo(datos.get(85));
								empleadoNomina.setNumeroTrabajadorCliente(datos.get(86));
								if (datos.get(87)!="")
									empleadoNomina.setOtroPatron(Boolean.parseBoolean(datos.get(87)));
								else
									empleadoNomina.setOtroPatron(false);
								empleadoNomina.setRfcOtroPatron(datos.get(88));
								empleadoNomina.setNombreOtroPatron(datos.get(89));
								if (datos.get(90)!="")
									empleadoNomina.setPermanencia(Boolean.parseBoolean(datos.get(90)));
								else
									empleadoNomina.setPermanencia(false);
								empleadoNomina.setCalle(datos.get(91));
								empleadoNomina.setCodigoPostal(datos.get(92));
								empleadoNomina.setMunicipioDel(datos.get(93));
								empleadoNomina.setEntFederativa(datos.get(94));
								if (datos.get(95).length()>0)
									empleadoNomina.setLoteMovImssBaja(Integer.parseInt(datos.get(95)));
								else
									empleadoNomina.setLoteMovImssBaja(0);
								empleadoNomina.setAplicaFiniquito(Boolean.parseBoolean(datos.get(96)));
								if (datos.get(97).length()>0)
									empleadoNomina.setMontoFiniquito(Double.parseDouble(datos.get(97)));
								else
									empleadoNomina.setMontoFiniquito(0);
								empleadoNomina.setArea(obtenerArea(datos.get(98)));
								empleadoNomina.setDepartamento(obtenerDepartamento(datos.get(99)));
								empleadoNomina.setProceso(obtenerProceso(datos.get(100)));
								empleadoNomina.setPuesto(obtenerPuesto(datos.get(101)));
								empleadoNomina.setTipoContrato(datos.get(102));
								System.out.println("GUARDANDO!");
								if (validarFormatoFechas){
									this.empleadoNominaDao.agregarEmpleadoNomina(empleadoNomina);
									cargados++;
								}
								System.out.println("Guardé un nuevo empleado nomina!");
							}																											
						}
					}
					else{
						strBMain.append("Se interrumpió el insert de Empleados porque el empleado ya existe o la información no es válida!\n");
						rechazados++;
					}
    			}
    			Archivo archivo = new Archivo();
    			archivo.setIdArchivo(long1.intValue());
    			archivo.setCargados(cargados);
    			archivo.setRechazados(rechazados);
    			this.archivoDao.updateArchivo(archivo);
    	}
    	catch (Exception ioe) { 
    		System.out.println("ERROR EN LA CARGA MASIVA DE EMPLEADOS!!!");
    		StringBuffer strB= new StringBuffer();
    		strB.append("ERROR EN LA CARGA MASIVA DE EMPLEADOS!!!El Error es:"+ioe.getMessage());
    		ioe.printStackTrace();
    		return strB.toString();
    	} 
    	return strBMain.toString();		
	}

	
	private Area obtenerArea(String valor) {
		// TODO Auto-generated method stub
		Area area = new Area();
		area.setIdArea(Integer.parseInt(valor));
		return area;
	}
	private Departamento obtenerDepartamento(String valor) {
		// TODO Auto-generated method stub
		Departamento departamento = new Departamento();
		departamento.setIdDepartamento(Integer.parseInt(valor));
		return departamento;
	}
	private Proceso obtenerProceso(String valor) {
		// TODO Auto-generated method stub
		Proceso proceso = new Proceso();
		proceso.setIdProceso(Integer.parseInt(valor));
		return proceso;
	}
	private Puesto obtenerPuesto(String valor) {
		// TODO Auto-generated method stub
		Puesto puesto = new Puesto();
		puesto.setIdPuesto(Integer.parseInt(valor));
		return puesto;
	}


	@Override
	public int getCountIdEmpleadoByNss(String nssEmpleado) {
		
		
		return this.empleadoDao.obtenerCountIdEmpleadoByNss(nssEmpleado);
	}
	
	public boolean validarFormatoFecha(String fecha){
		System.out.println("Validando Fecha:"+fecha);
		try {
	        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-mm-dd", Locale.getDefault());
	        formatoFecha.setLenient(false);
	        formatoFecha.parse(fecha);
	    } catch (ParseException e) {
	        return false;
	    }
	    return true;
	}
}
