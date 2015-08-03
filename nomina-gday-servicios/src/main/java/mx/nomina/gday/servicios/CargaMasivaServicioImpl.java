package mx.nomina.gday.servicios;

import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import mx.nomina.gday.dao.EmpleadoDao;
import mx.nomina.gday.dao.EmpleadoNominaDao;
import mx.nomina.gday.modelo.Area;
import mx.nomina.gday.modelo.Departamento;
import mx.nomina.gday.modelo.Empleado;







import mx.nomina.gday.modelo.EmpleadoNomina;
import mx.nomina.gday.modelo.Nomina;
import mx.nomina.gday.modelo.Proceso;
import mx.nomina.gday.modelo.Puesto;

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
	private EmpleadoNominaDao empleadoNominaDao;
	
	@Override
	public String cargarExcel(String nombreArchivo,String tipoArchivo) {
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
    				if (datos.get(20)!="")
    					empleado.setCodigoPostal(Integer.parseInt(datos.get(20)));
    				else
    					empleado.setCodigoPostal(0);
    				empleado.setMunicipioDel(datos.get(21));
    				empleado.setEntFederativa(datos.get(22));
    				if (datos.get(23)!="")
    					empleado.setDocIfe(Boolean.parseBoolean(datos.get(23)));
    				else
    					empleado.setDocIfe(false);
    				if (datos.get(24)!="")
    					empleado.setDocActNan(Boolean.parseBoolean(datos.get(24)));
    				else
    					empleado.setDocActNan(false);
    				if (datos.get(25)!="")
    					empleado.setDocCurp(Boolean.parseBoolean(datos.get(25)));
    				else
    					empleado.setDocCurp(false);
    				if (datos.get(26)!="")
    					empleado.setDocRfc(Boolean.parseBoolean(datos.get(26)));
    				else
    					empleado.setDocRfc(false);    			
    				if (datos.get(27)!="")
    					empleado.setDocComprobante(Boolean.parseBoolean(datos.get(27)));
    				else
    					empleado.setDocComprobante(false);
    				if (datos.get(28)!="")
    					empleado.setDocCompEst(Boolean.parseBoolean(datos.get(28)));
    				else
    					empleado.setDocCompEst(false);
    				if (datos.get(29)!="")
    					empleado.setDocCorreo(Boolean.parseBoolean(datos.get(29)));
    				else
    					empleado.setDocCorreo(false);
    				if (datos.get(30)!="")
    					empleado.setDocPreafiliacion(Boolean.parseBoolean(datos.get(30)));
    				else
    					empleado.setDocPreafiliacion(false);
    				
    				empleado.setCuenta(datos.get(31));
    				empleado.setBanco(datos.get(32));
    				empleado.setTipoPago(datos.get(33));
    				empleado.setNoCredInfonavit(datos.get(34));
    				if (datos.get(35)!="")    					
    					empleado.setDescInfonavitVsmg(Double.parseDouble(datos.get(35)));
    				else
    					empleado.setDescInfonavitVsmg(0);
    				if (datos.get(36)!="")
    					empleado.setDesInfonavitPorc(Double.parseDouble(datos.get(36)));
    				else
    					empleado.setDesInfonavitPorc(0);
    				if (datos.get(37)!="")
    					empleado.setDescInfonavitImp(Double.parseDouble(datos.get(37)));
    				else
    					empleado.setDescInfonavitImp(0);
    				if (datos.get(38)!="")
    					empleado.setDescFonacotPago(Double.parseDouble(datos.get(38)));
    				else
    					empleado.setDescFonacotPago(0);
    				if (datos.get(39)!="")	
    					empleado.setDescFonacotNum(Double.parseDouble(datos.get(39)));
    				else
    					empleado.setDescFonacotNum(0);
    				if (datos.get(40)!="") 
    					empleado.setPensionAlimImp(Double.parseDouble(datos.get(40)));
    				else
    					empleado.setPensionAlimImp(0);
    				if (datos.get(41)!="")
    					empleado.setPensionAlimPorc(Double.parseDouble(datos.get(41)));
    				else
    					empleado.setPensionAlimPorc(0);
    				if (datos.get(42)!="")
    					empleado.setPensionAlimAcred(datos.get(42));
    				else
    					empleado.setPensionAlimAcred("0");
					empleado.setPensionAlimObs(datos.get(43));
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
							if (datos.get(43)!="" && datos.get(43)!=null){								
								EmpleadoNomina empleadoNomina = new EmpleadoNomina();
								Nomina nomina=new Nomina();
								empleado.setIdEmpleado(Integer.parseInt(""+empleado.getId()));
								nomina.setIdNomina(Integer.parseInt(datos.get(44)));
								empleadoNomina.setNomina(nomina);
								empleadoNomina.setEmpleado(empleado);
								//System.out.println("Fecha de Ingreso Nomina:"+datos.get(45));
								if  (validarFormatoFecha(datos.get(45))){
									empleadoNomina.setFechaIngreso(datos.get(45));
								}
								else{
									strBMain.append("Para El Empleado:"+empleado.getNss()+"La fecha de Ingreso: "+ datos.get(45)+ " No cumple el formato deseado yyyy-mm-dd. Se creó el empleado, pero no se registró en la nómina.\n");
									validarFormatoFechas=false;
								}								
								empleadoNomina.setEstatus(datos.get(46));
								empleadoNomina.setTipoSalario(datos.get(47));
								//System.out.println("FechaBaja"+datos.get(48));
								empleadoNomina.setFechaBaja(datos.get(48));
								if (datos.get(48)!=""){								
									if  (!validarFormatoFecha(datos.get(48))){									
										strBMain.append("Para El Empleado:"+empleado.getNss()+"La fecha de Baja: "+ datos.get(48)+ " No cumple el formato deseado yyyy-mm-dd. Se creó el empleado, pero no se registró en la nómina.\n");
										validarFormatoFechas=false;
									}
								}								
								empleadoNomina.setLoteMovImssAlta(datos.get(49));
								empleadoNomina.setFechaVencimiento(datos.get(50));
								if (datos.get(50)!=""){								
									if  (!validarFormatoFecha(datos.get(50))){									
										strBMain.append("Para El Empleado:"+empleado.getNss()+"La fecha de Vencimiento: "+ datos.get(50)+ " No cumple el formato deseado yyyy-mm-dd. Se creó el empleado, pero no se registró en la nómina.\n");
										validarFormatoFechas=false;
									}
								}
								System.out.println("FechaVenc"+datos.get(50));
								if (datos.get(51)!="")
									empleadoNomina.setSueldoMensual(Double.parseDouble(datos.get(51)));
								else
									empleadoNomina.setSueldoMensual(0);
								if (datos.get(52)!="")
									empleadoNomina.setSalarioDiarioInt(Double.parseDouble(datos.get(52)));
								else
									empleadoNomina.setSalarioDiarioInt(0);
								empleadoNomina.setPlazaTrabajo(datos.get(53));
								empleadoNomina.setNumeroTrabajadorCliente(datos.get(54));
								if (datos.get(55)!="")
									empleadoNomina.setOtroPatron(Boolean.parseBoolean(datos.get(55)));
								else
									empleadoNomina.setOtroPatron(false);
								empleadoNomina.setRfcOtroPatron(datos.get(56));
								empleadoNomina.setNombreOtroPatron(datos.get(57));
								if (datos.get(51)!="")
									empleadoNomina.setPermanencia(Boolean.parseBoolean(datos.get(58)));
								empleadoNomina.setCalle(datos.get(59));
								empleadoNomina.setCodigoPostal(datos.get(60));
								empleadoNomina.setMunicipioDel(datos.get(61));
								empleadoNomina.setEntFederativa(datos.get(62));
								if (datos.get(63)!="")
									empleadoNomina.setLoteMovImssBaja(Integer.parseInt(datos.get(63)));
								else
									empleadoNomina.setLoteMovImssBaja(0);
								empleadoNomina.setAplicaFiniquito(Boolean.parseBoolean(datos.get(64)));
								if (datos.get(65)!="")
									empleadoNomina.setMontoFiniquito(Double.parseDouble(datos.get(65)));
								else
									empleadoNomina.setMontoFiniquito(0);
								empleadoNomina.setArea(obtenerArea(datos.get(66)));
								empleadoNomina.setDepartamento(obtenerDepartamento(datos.get(67)));
								empleadoNomina.setProceso(obtenerProceso(datos.get(68)));
								empleadoNomina.setPuesto(obtenerPuesto(datos.get(69)));
								System.out.println("GUARDANDO!");
								if (validarFormatoFechas)
									this.empleadoNominaDao.agregarEmpleadoNomina(empleadoNomina);								
								System.out.println("Guardé un nuevo empleado nomina!");
								if (datos.get(70)!=null)
									empleadoNomina.setTipoContrato(datos.get(70));
								else
									empleadoNomina.setTipoContrato("N/A");
							}
							
							System.out.println("Empleado nomina:"+datos.get(71));
							if (datos.get(71)!="" && datos.get(70)!=null && datos.get(71).length()>0){			
								System.out.println("Empleado nomina:"+datos.get(71).length());

								EmpleadoNomina empleadoNomina = new EmpleadoNomina();
								Nomina nomina=new Nomina();
								empleado.setIdEmpleado(Integer.parseInt(""+empleado.getId()));
								nomina.setIdNomina(Integer.parseInt(datos.get(71)));
								empleadoNomina.setNomina(nomina);
								empleadoNomina.setEmpleado(empleado);
								//System.out.println("Fecha de Ingreso Nomina:"+datos.get(45));
								if  (validarFormatoFecha(datos.get(72))){
									empleadoNomina.setFechaIngreso(datos.get(72));
								}
								else{
									strBMain.append("Para El Empleado:"+empleado.getNss()+"La fecha de Ingreso: "+ datos.get(71)+ " No cumple el formato deseado yyyy-mm-dd. Se creó el empleado, pero no se registró en la nómina.\n");
									validarFormatoFechas=false;
								}
								empleadoNomina.setEstatus(datos.get(73));
								empleadoNomina.setTipoSalario(datos.get(74));
								//System.out.println("FechaBaja"+datos.get(48));
								empleadoNomina.setFechaBaja(datos.get(75));
								if (datos.get(75)!=""){								
									if  (!validarFormatoFecha(datos.get(75))){									
										strBMain.append("Para El Empleado:"+empleado.getNss()+"La fecha de Baja: "+ datos.get(74)+ " No cumple el formato deseado yyyy-mm-dd. Se creó el empleado, pero no se registró en la nómina.\n");
										validarFormatoFechas=false;
									}
								}								
								empleadoNomina.setLoteMovImssAlta(datos.get(76));
								empleadoNomina.setFechaVencimiento(datos.get(77));
								if (datos.get(77)!=""){								
									if  (!validarFormatoFecha(datos.get(77))){									
										strBMain.append("Para El Empleado:"+empleado.getNss()+"La fecha de Vencimiento: "+ datos.get(76)+ " No cumple el formato deseado yyyy-mm-dd. Se creó el empleado, pero no se registró en la nómina.\n");
										validarFormatoFechas=false;
									}
								}
								System.out.println("FechaVenc"+datos.get(77));
								if (datos.get(78)!="")
									empleadoNomina.setSueldoMensual(Double.parseDouble(datos.get(78)));
								else
									empleadoNomina.setSueldoMensual(0);
								if (datos.get(79)!="")
									empleadoNomina.setSalarioDiarioInt(Double.parseDouble(datos.get(79)));
								else
									empleadoNomina.setSalarioDiarioInt(0);
								empleadoNomina.setPlazaTrabajo(datos.get(80));
								empleadoNomina.setNumeroTrabajadorCliente(datos.get(81));
								if (datos.get(82)!="")
									empleadoNomina.setOtroPatron(Boolean.parseBoolean(datos.get(82)));
								else
									empleadoNomina.setOtroPatron(false);
								empleadoNomina.setRfcOtroPatron(datos.get(83));
								empleadoNomina.setNombreOtroPatron(datos.get(84));
								if (datos.get(85)!="")
									empleadoNomina.setPermanencia(Boolean.parseBoolean(datos.get(85)));
								else
									empleadoNomina.setPermanencia(false);
								empleadoNomina.setCalle(datos.get(86));
								empleadoNomina.setCodigoPostal(datos.get(87));
								empleadoNomina.setMunicipioDel(datos.get(88));
								empleadoNomina.setEntFederativa(datos.get(89));
								if (datos.get(90)!="")
									empleadoNomina.setLoteMovImssBaja(Integer.parseInt(datos.get(90)));
								else
									empleadoNomina.setLoteMovImssBaja(0);
								empleadoNomina.setAplicaFiniquito(Boolean.parseBoolean(datos.get(91)));
								if (datos.get(92)!="")
									empleadoNomina.setMontoFiniquito(Double.parseDouble(datos.get(92)));
								else
									empleadoNomina.setMontoFiniquito(0);
								empleadoNomina.setArea(obtenerArea(datos.get(93)));
								empleadoNomina.setDepartamento(obtenerDepartamento(datos.get(94)));
								empleadoNomina.setProceso(obtenerProceso(datos.get(95)));
								empleadoNomina.setPuesto(obtenerPuesto(datos.get(96)));
								if (datos.get(97)!=null)
									empleadoNomina.setTipoContrato(datos.get(97));
								else
									empleadoNomina.setTipoContrato("N/A");
								System.out.println("GUARDANDO!");
								if (validarFormatoFechas)
									this.empleadoNominaDao.agregarEmpleadoNomina(empleadoNomina);								
								System.out.println("Guardé un nuevo empleado nomina!");
							}							
							if (datos.get(66)!="" && datos.get(66)!=null){								
								/*EmpleadoNomina empleadoNomina = new EmpleadoNomina();
								Nomina nomina=new Nomina();
								System.out.println("ID NOMINA"+datos.get(66));
								empleado.setIdEmpleado(Integer.parseInt(""+empleado.getId()));
								nomina.setIdNomina(Integer.parseInt(datos.get(66)));
								empleadoNomina.setNomina(nomina);
								empleadoNomina.setEmpleado(empleado);
								empleadoNomina.setFechaIngreso(datos.get(67));
								empleadoNomina.setEstatus(datos.get(68));
								empleadoNomina.setTipoSalario(datos.get(69));
								empleadoNomina.setFechaBaja(datos.get(70));
								empleadoNomina.setLoteMovImssAlta(datos.get(71));
								empleadoNomina.setFechaVencimiento(datos.get(72));
								empleadoNomina.setSueldoMensual(Double.parseDouble(datos.get(73)));
								empleadoNomina.setSalarioDiarioInt(Double.parseDouble(datos.get(74)));
								empleadoNomina.setPlazaTrabajo(datos.get(75));
								empleadoNomina.setNumeroTrabajadorCliente(datos.get(76));
								empleadoNomina.setOtroPatron(Boolean.parseBoolean(datos.get(77)));
								empleadoNomina.setRfcOtroPatron(datos.get(78));
								empleadoNomina.setNombreOtroPatron(datos.get(79));
								empleadoNomina.setPermanencia(Boolean.parseBoolean(datos.get(80)));
								empleadoNomina.setCalle(datos.get(81));
								empleadoNomina.setCodigoPostal(datos.get(82));
								empleadoNomina.setMunicipioDel(datos.get(83));
								empleadoNomina.setEntFederativa(datos.get(84));
								empleadoNomina.setLoteMovImssBaja(Integer.parseInt(datos.get(85)));
								empleadoNomina.setAplicaFiniquito(Boolean.parseBoolean(datos.get(86)));
								empleadoNomina.setMontoFiniquito(Double.parseDouble(datos.get(87)));
								empleadoNomina.setArea(obtenerArea(datos.get(88)));
								empleadoNomina.setDepartamento(obtenerDepartamento(datos.get(89)));
								empleadoNomina.setProceso(obtenerProceso(datos.get(90)));
								empleadoNomina.setPuesto(obtenerPuesto(datos.get(91)));							
								System.out.println("GUARDANDO!");
								this.empleadoNominaDao.agregarEmpleadoNomina(empleadoNomina);
								System.out.println("Guardé un nuevo empleado nomina!");*/
							}							
						}
					}
					else{
						strBMain.append("Se interrumpió el insert de Empleados porque el empleado ya existe o la información no es válida!\n");						
					}
    			}     	
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
	    return true; //OK
	}
}
