package mx.nomina.gday.servicios;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargaMasivaServicioImpl implements CargaMasivaServicio {

	@Autowired
	private EmpleadoDao empleadoDao;
	
	@Autowired
	private EmpleadoNominaDao empleadoNominaDao;
	
	@Override
	public String cargarExcel(String nombreArchivo) {
		StringBuffer strBMain= new StringBuffer();
    	try {
    		//System.out.println("se carga el archivo:"+nombreArchivo);    		
    		FileInputStream file = new FileInputStream(nombreArchivo);
    		HSSFWorkbook workbook = new HSSFWorkbook(file);    		
        	HSSFSheet hoja = workbook.getSheetAt(0);
    		
        	System.out.println("nombre de archivo"+nombreArchivo);
        	//Se llena el encabezado        			        	
    			int numColumnas = 97; 
    			int numFilas = 2000; 
    			String data; 
    			//System.out.println("Nombre de la Hoja\t" + archivoExcel.getSheet(sheetNo).getName());
    			int filaNum=3;
    			Row fila = hoja.getRow(filaNum);
    			System.out.println("Num filas:"+hoja.getLastRowNum());
    			for (; filaNum < hoja.getLastRowNum(); filaNum++) { // Recorre cada 
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
    					System.out.print(data + " ->"+columna+"\n");	
    					datos.add(data);
    				}
    				if (datos.get(0)==""){
    					strBMain.append("Se encontró registro vacío, se interrumpe la carga\n");
    					System.out.println("Se encontró registro vacío, se interrumpe la carga");
    					break;
    				}    		
    				//DATOS DE EMPLEADO
    				empleado.setNoControl(datos.get(0));
    				empleado.setNss(datos.get(1));
    				empleado.setCurp(datos.get(2));
    				empleado.setApellidoPaterno(datos.get(3));
    				empleado.setApellidoMaterno(datos.get(4));
    				empleado.setNombre(datos.get(5));
    				empleado.setRfc(datos.get(6));
    				System.out.println("Fecha Nac:"+datos.get(6));
    				System.out.println("Fecha Nac:"+datos.get(7));
    				empleado.setFechaNacimiento(datos.get(7));
    				empleado.setEdad(Integer.parseInt(datos.get(8)));
    				empleado.setSexo(datos.get(9));
    				empleado.setPaisOrigen(datos.get(10));
    				empleado.setNacionalidad(datos.get(11));
    				empleado.setEstadoCivil(datos.get(12));
    				empleado.setCorreoElectronico(datos.get(13));
    				empleado.setFechaIngresoReal(datos.get(14));
    				System.out.println("Fecha real:"+datos.get(14));
    				empleado.setListaNegra(Boolean.parseBoolean(datos.get(15)));
    				empleado.setCalle(datos.get(16));
    				empleado.setNumExterior(datos.get(17));
    				empleado.setNumInterior(datos.get(18));
    				empleado.setColonia(datos.get(19));
    				empleado.setCodigoPostal(Integer.parseInt(datos.get(20)));
    				empleado.setMunicipioDel(datos.get(21));
    				empleado.setEntFederativa(datos.get(22));
    				empleado.setDocIfe(Boolean.parseBoolean(datos.get(23)));
    				empleado.setDocActNan(Boolean.parseBoolean(datos.get(24)));
    				empleado.setDocCurp(Boolean.parseBoolean(datos.get(25)));
    				empleado.setRfc(datos.get(26));
    				empleado.setDocComprobante(Boolean.parseBoolean(datos.get(27)));
    				empleado.setDocCompEst(Boolean.parseBoolean(datos.get(28)));
    				empleado.setDocCorreo(Boolean.parseBoolean(datos.get(29)));
    				empleado.setDocPreafiliacion(Boolean.parseBoolean(datos.get(30)));
    				empleado.setCuenta(datos.get(31));
    				empleado.setBanco(datos.get(32));
    				empleado.setTipoPago(datos.get(33));
    				empleado.setNoCredInfonavit(datos.get(34));
    				empleado.setDescInfonavitVsmg(Double.parseDouble(datos.get(35)));
    				empleado.setDesInfonavitPorc(Double.parseDouble(datos.get(36)));
					empleado.setDescInfonavitImp(Double.parseDouble(datos.get(37)));
					empleado.setDescFonacotPago(Double.parseDouble(datos.get(38)));
					empleado.setDescFonacotNum(Double.parseDouble(datos.get(39)));
					empleado.setPensionAlimImp(Double.parseDouble(datos.get(40)));
					empleado.setPensionAlimPorc(Double.parseDouble(datos.get(41)));
					empleado.setPensionAlimAcred(datos.get(42));
					empleado.setPensionAlimObs(datos.get(43));
					strBMain.append("Se intenta Guardar:"+empleado.getNss()+"\n");    				
    				int idEmpleadoTest=this.empleadoDao.obtenerCountIdEmpleadoByNss(empleado.getNss());
					if (idEmpleadoTest==0){
						this.empleadoDao.agregarEmpleado(empleado);						
						Long idEmpleado = empleado.getId();
						if (idEmpleado!= 0){
							strBMain.append("Se guarda al Empleado!\n");
							System.out.println("Guardé al Empleado:"+idEmpleado+":"+empleado.getNombre());
							empleado.setIdEmpleado(Integer.parseInt(""+idEmpleado));
							System.out.println("Supuesto empleado:"+datos.get(44));
							if (datos.get(43)!="" && datos.get(43)!=null){								
								EmpleadoNomina empleadoNomina = new EmpleadoNomina();
								Nomina nomina=new Nomina();
								empleado.setIdEmpleado(Integer.parseInt(""+empleado.getId()));
								nomina.setIdNomina(Integer.parseInt(datos.get(44)));
								empleadoNomina.setNomina(nomina);
								empleadoNomina.setEmpleado(empleado);
								empleadoNomina.setFechaIngreso(datos.get(45));
								empleadoNomina.setEstatus(datos.get(46));
								empleadoNomina.setTipoSalario(datos.get(47));
								empleadoNomina.setFechaBaja(datos.get(48));
								empleadoNomina.setLoteMovImssAlta(datos.get(49));
								empleadoNomina.setFechaVencimiento(datos.get(50));
								System.out.println(datos.get(51));
								empleadoNomina.setSueldoMensual(Double.parseDouble(datos.get(51)));
								empleadoNomina.setSalarioDiarioInt(Double.parseDouble(datos.get(52)));
								empleadoNomina.setPlazaTrabajo(datos.get(53));
								empleadoNomina.setNumeroTrabajadorCliente(datos.get(54));
								empleadoNomina.setOtroPatron(Boolean.parseBoolean(datos.get(55)));
								empleadoNomina.setRfcOtroPatron(datos.get(56));
								empleadoNomina.setNombreOtroPatron(datos.get(57));
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
						strBMain.append("Se interrumpió el insert de Empleados porque el empleado ya existe!\n");						
					}
    			}     	
    	}
    	catch (Exception ioe) { 
    		System.out.println("ERROR EN LA CARGA MASIVA DE EMPLEADOS!!!");
    		StringBuffer strB= new StringBuffer();
    		strB.append("Error:"+ioe.getMessage());
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

}
