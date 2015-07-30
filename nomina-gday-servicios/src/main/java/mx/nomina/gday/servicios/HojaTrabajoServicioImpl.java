package mx.nomina.gday.servicios;

import java.io.File;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.nomina.gday.dao.ArchivoDao;
import mx.nomina.gday.dao.EmpleadoDao;
import mx.nomina.gday.dao.EmpleadoNominaDao;
import mx.nomina.gday.dao.HojaTrabajoDao;
import mx.nomina.gday.dao.NominaDao;
import mx.nomina.gday.dao.RazonSocialDao;
import mx.nomina.gday.dao.EmpleadoNominaDao;
import mx.nomina.gday.modelo.Archivo;
import mx.nomina.gday.modelo.Empleado;
import mx.nomina.gday.modelo.EmpleadoNomina;
import mx.nomina.gday.modelo.HojaTrabajo;
import mx.nomina.gday.modelo.Nomina;


@Service
public class HojaTrabajoServicioImpl implements HojaTrabajoServicio{
	
	@Autowired
	private HojaTrabajoDao hojaTrabajoDao;

	@Autowired
	private NominaDao nominaDao;

	@Autowired
	private EmpleadoNominaDao empleadoNominaDao;

	@Autowired
	private EmpleadoDao empleadoDao;

	@Autowired
	private RazonSocialDao razonSocialDao;

	@Override
	public List<HojaTrabajo> obtenerHojasByIdNomina(Integer idNomina) {
		// TODO Auto-generated method stub
		return this.hojaTrabajoDao.obtenerHojasByIdNomina(idNomina);
	}

	@Override
	public List<HojaTrabajo> obtenerHojas() {
		// TODO Auto-generated method stub
		return this.hojaTrabajoDao.obtenerHojas();
	}

	@Override
	public int activarHojaTrabajo(HojaTrabajo hojaTrabajo) {
		// TODO Auto-generated method stub
		return this.hojaTrabajoDao.activarHojaTrabajo(hojaTrabajo);
	}

	@Override
	public int eliminarHojaTrabajo(HojaTrabajo hojaTrabajo) {
		// TODO Auto-generated method stub
		return this.hojaTrabajoDao.eliminarHojaTrabajo(hojaTrabajo);
	}

	@Override
	public void agregarArchivo(HojaTrabajo hojaTrabajo){
		// TODO Auto-generated method stub
		try{
			this.hojaTrabajoDao.agregarArchivo(hojaTrabajo);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override 
	public String generarHojaTrabajoExt(Integer idHojaTrabajo) {
		// TODO Auto-generated method stub
		/*La ruta donde se creará el archivo*/
        //String rutaArchivo = System.getProperty("user.home")+"/ejemploExcelJava.xls";
	    HojaTrabajo hojaTrabajo = this.hojaTrabajoDao.obtenerHojaById(idHojaTrabajo);
	    return hojaTrabajo.getTipoArchivo();
	}
	
	@Override
	public File generarHojaTrabajo(Integer idHojaTrabajo) {
		// TODO Auto-generated method stub
		/*La ruta donde se creará el archivo*/
        //String rutaArchivo = System.getProperty("user.home")+"/ejemploExcelJava.xls";
	    HojaTrabajo hojaTrabajo = this.hojaTrabajoDao.obtenerHojaById(idHojaTrabajo);	    
		//String rutaArchivo = "c://archivosNGDAY//layoutHojaTrabajo.xlsx";
	    String rutaArchivo = "c://archivosNGDAY//layoutNuevo.xlsx";
        /*Se crea el objeto de tipo File con la ruta del archivo*/ 	    
		File archivoXLS = new File("C://archivosNGDAY//tmpHojaTrabajo"+idHojaTrabajo+".xlsx"); 
		//Evento eventoTmp=new Evento();
		/*Se crea el archivo*/
        int filaInicial=8;
        int columnaInicial=1;
        int totalDatos=67;
        try{
     		FileOutputStream fos = new FileOutputStream("C://archivosNGDAY//tmpHojaTrabajo"+idHojaTrabajo+".xlsx");
     		File inFile = new File(rutaArchivo);
     		FileInputStream in = new FileInputStream(inFile);
     		int c;
			while( (c = in.read() ) != -1)
				fos.write(c);
			in.close();
			fos.close();			
     	    //fos.write(hojaTrabajo.getArchivoAcumulado());
     	    //fos.close(); 
        	FileInputStream file = new FileInputStream(archivoXLS);
        	// Workbook wb = WorkbookFactory.create(new File("/path/to/your/excel/file"));
        	 //Sheet mySheet = wb.getSheetAt(0);
        	   // Iterator<Row> rowIter = mySheet.rowIterator();
        	    //System.out.println(mySheet.getRow(1).getCell(0));
        	//HSSFWorkbook wb = new HSSFWorkbook(file);
        	Workbook wb = new XSSFWorkbook(file); //or new HSSFWorkbook();
            CreationHelper creationHelper = wb.getCreationHelper();
            //Test
        	//Se trabaja la primer HOJA GENERALES EMPRESA
        	Sheet hoja = wb.getSheetAt(0);
        	Nomina nomina = this.nominaDao.obtenerNominaByIdHojaTrabajo(idHojaTrabajo);
        	//nomina=this.nominaDao.obtenerNominaById(37);
        	System.out.println("GENERANDO LAYOUT"+nomina.getIdNomina());
        	System.out.println(nomina.getEsquema());
        	System.out.println(nomina.getEjecutivo().getNombreEjecutivo());
        	nomina.setRazonesSociales(this.razonSocialDao.obtenerRazonesSocialesByIdNomina(nomina.getIdNomina()));
        	System.out.println(nomina.getRazonesSociales());
        	EmpleadoNomina empleado=new EmpleadoNomina();
        	//empleado  = this.empleadoNominaDao.obtenerEmpleadoNominaByIdNomina(nomina.)
        	List<Empleado> empleados = this.empleadoDao.obtenerEmpleadosByIdNomina(nomina.getIdNomina());
        	/****Se llena 1era hoja****/
        	Row fila = hoja.getRow(2);	
        	fila.createCell(1).setCellValue(nomina.getNombreCorto());
        	fila = hoja.getRow(3);	
        	fila.createCell(1).setCellValue(nomina.getEsquema().getNombreEsquema());
        	fila = hoja.getRow(4);	
        	fila.createCell(1).setCellValue(nomina.getPatrona().getNombreCortoPatrona());
        	fila = hoja.getRow(5);
        	fila.createCell(1).setCellValue(nomina.getClaseRiesgo());        	
        	fila = hoja.getRow(6);	
        	//fila.createCell(1).setCellValue(nomina.getEjecutivo().getNombreEjecutivo());
        	fila = hoja.getRow(7);	
        	//fila.createCell(1).setCellValue(nomina.getTipoPago());
        	fila = hoja.getRow(8);	
        	fila.createCell(1).setCellValue(nomina.getEjecutivo().getNombreEjecutivo()+ " "+ nomina.getEjecutivo().getPaternoEjecutivo() + " " +nomina.getEjecutivo().getMaternoEjecutivo());
        	fila = hoja.getRow(9);	
        	fila.createCell(1).setCellValue(nomina.getTipoPago());
        	fila = hoja.getRow(10);	
        	fila.createCell(1).setCellValue("");
        	fila = hoja.getRow(11);	
        	fila.createCell(1).setCellValue(nomina.getPeriodicidad());
        	fila = hoja.getRow(12);	
        	fila.createCell(1).setCellValue(14);
        	//fila = hoja.getRow(13);	 
        	//fila.createCell(1).setCellValue(nomina.getTipoCalendario().getSiglas());
        	fila = hoja.getRow(14);	
        	fila.createCell(1).setCellValue(nomina.getTipoCalendario().getTipoCalendario());
        	fila = hoja.getRow(15);	
        	fila.createCell(1).setCellValue(nomina.isProvisionAguinaldo());
        	fila = hoja.getRow(16);	
        	fila.createCell(1).setCellValue(nomina.isProvisionPrimaVacacional());
        	fila = hoja.getRow(17);	
        	fila.createCell(1).setCellValue(nomina.isProvisionVacaciones());
        	fila = hoja.getRow(18);	
        	fila.createCell(1).setCellValue(nomina.getDiasAguinaldo());
        	fila = hoja.getRow(18);	
        	fila.createCell(1).setCellValue(nomina.getDiasAguinaldo());
        	fila = hoja.getRow(19);	
        	fila.createCell(1).setCellValue(nomina.getPorcPrimaVacacional());
        	fila = hoja.getRow(20);	
        	fila.createCell(1).setCellValue(nomina.isFondoAhorro());
        	//21,22,23
        	fila = hoja.getRow(24);
        	fila.createCell(1).setCellValue(nomina.isFacturaSubsidio());
        	fila = hoja.getRow(25);	
        	fila.createCell(1).setCellValue(nomina.isIvaExento());
        	fila = hoja.getRow(26);	
        	fila.createCell(1).setCellValue(nomina.isComisionCostSocial());
        	//27,28
        	int indiceFilasRZTmp=29;
        	for (int j=0; j<nomina.getRazonesSociales().size();j++){
        		fila = hoja.getRow(indiceFilasRZTmp);	
            	fila.createCell(0).setCellValue(nomina.getRazonesSociales().get(j).getNombreRazonSocial());
            	fila = hoja.getRow(indiceFilasRZTmp);	
            	fila.createCell(1).setCellValue(nomina.getRazonesSociales().get(j).getNombreCortoRazonS());
            	fila = hoja.getRow(indiceFilasRZTmp);	
            	fila.createCell(2).setCellValue(nomina.getRazonesSociales().get(j).getRfc());
            	fila = hoja.getRow(indiceFilasRZTmp);	
            	fila.createCell(3).setCellValue(nomina.getRazonesSociales().get(j).getComision());
            	fila = hoja.getRow(indiceFilasRZTmp);	
            	fila.createCell(4).setCellValue("100");
            	indiceFilasRZTmp++;
        	}
        	/****Se llena 2da hoja****/
        	hoja = wb.getSheetAt(1);
           	int numRz=3;
        	int j=0;
        	for (j=0; j<nomina.getRazonesSociales().size();j++){
        		fila = hoja.getRow(numRz);
        		fila.createCell(j+4).setCellValue(nomina.getRazonesSociales().get(j).getNombreCortoRazonS());
        	}
        	fila.createCell(j+4).setCellValue("Total");
           	numRz=4;
           	for (j=0; j<empleados.size();j++){
           		fila = hoja.createRow(numRz);
           		fila.createCell(0).setCellValue(""+(j+1));	
           		fila.createCell(1).setCellValue(empleados.get(j).getNoControl());
           		fila.createCell(2).setCellValue(empleados.get(j).getNss());	
           		fila.createCell(3).setCellValue(empleados.get(j).getNombre()+" "+empleados.get(j).getApellidoPaterno()+ " " +empleados.get(j).getApellidoMaterno());
           		fila.createCell(4).setCellValue("100%");
           		fila.createCell(5).setCellValue("100%");
              	numRz++;
           	}
           	/****Se llena 3ta hoja****/
           	hoja = wb.getSheetAt(2);
           	//System.out.println("CLS"+wb.getNumberOfSheets());
           	numRz=2;
           	for (j=0; j<empleados.size();j++){
           		fila = hoja.createRow(numRz);
           		fila.createCell(0).setCellValue(""+(j+1));	
           		fila.createCell(1).setCellValue(empleados.get(j).getNoControl());
           		fila.createCell(2).setCellValue(empleados.get(j).getNss());	           		
           		fila.createCell(3).setCellValue(empleados.get(j).getCurp());
           		fila.createCell(4).setCellValue(empleados.get(j).getApellidoPaterno());
           		fila.createCell(5).setCellValue(empleados.get(j).getApellidoMaterno());
           		fila.createCell(6).setCellValue(empleados.get(j).getNombre());
           		fila.createCell(7).setCellValue(empleados.get(j).getRfc());           		
           		fila.createCell(8).setCellValue(empleados.get(j).getFechaNacimiento());
           		fila.createCell(9).setCellValue(empleados.get(j).getEdad());
           		fila.createCell(10).setCellValue(empleados.get(j).getPaisOrigen());           		
           		fila.createCell(11).setCellValue(empleados.get(j).getNacionalidad());
           		fila.createCell(12).setCellValue(empleados.get(j).getEstadoCivil());
           		fila.createCell(13).setCellValue(empleados.get(j).getCorreoElectronico());
           		fila.createCell(14).setCellValue(empleados.get(j).getFechaIngresoReal());
           		fila.createCell(15).setCellValue(empleados.get(j).isListaNegra());
           		fila.createCell(16).setCellValue(empleados.get(j).getCalle());
           		//------Test-          		
           		fila.createCell(17).setCellValue(empleados.get(j).getNumExterior());
           		fila.createCell(18).setCellValue(empleados.get(j).getNumInterior()); 
           		fila.createCell(19).setCellValue(empleados.get(j).getColonia());
           		fila.createCell(20).setCellValue(empleados.get(j).getCodigoPostal());
           		fila.createCell(21).setCellValue(empleados.get(j).getMunicipioDel());
           		fila.createCell(22).setCellValue(empleados.get(j).getEntFederativa());
           		fila.createCell(23).setCellValue(empleados.get(j).isDocIfe());
           		fila.createCell(24).setCellValue(empleados.get(j).isDocActNan());
           		fila.createCell(25).setCellValue(empleados.get(j).isDocCurp());
           		fila.createCell(26).setCellValue(empleados.get(j).isDocRfc());
           		fila.createCell(27).setCellValue(empleados.get(j).isDocComprobante());
           		fila.createCell(28).setCellValue(empleados.get(j).isDocCompEst());
           		fila.createCell(29).setCellValue(empleados.get(j).isDocCorreo());
           		fila.createCell(30).setCellValue(empleados.get(j).isDocPreafiliacion());
           		fila.createCell(31).setCellValue(empleados.get(j).getCuenta());
           		fila.createCell(32).setCellValue(empleados.get(j).getBanco());
           		fila.createCell(33).setCellValue(empleados.get(j).getTipoPago());
           		fila.createCell(34).setCellValue(empleados.get(j).getNoCredInfonavit());
           		fila.createCell(35).setCellValue(empleados.get(j).getDescInfonavitVsmg());
           		fila.createCell(36).setCellValue(empleados.get(j).getDesInfonavitPorc());
           		fila.createCell(37).setCellValue(empleados.get(j).getDescInfonavitImp());
           		fila.createCell(38).setCellValue(empleados.get(j).getDescFonacotPago());
           		fila.createCell(39).setCellValue(empleados.get(j).getDescFonacotNum());
           		fila.createCell(40).setCellValue(empleados.get(j).getNoCredInfonavit());
           		fila.createCell(41).setCellValue(empleados.get(j).getPensionAlimImp());
           		fila.createCell(42).setCellValue(empleados.get(j).getPensionAlimPorc());
           		fila.createCell(43).setCellValue(empleados.get(j).getPensionAlimAcred());
           		fila.createCell(44).setCellValue(empleados.get(j).getPensionAlimObs());
           		fila.createCell(45).setCellValue("N/A");
           		//Nómina Empleado	
           		EmpleadoNomina emp1= new EmpleadoNomina();
           		emp1.setNomina(nomina);
           		fila.createCell(46).setCellValue(emp1.getNomina().getIdNomina());
           		emp1.setEmpleado(empleados.get(j));
           		emp1= this.empleadoNominaDao.obtenerEmpleadoNominaByIdNominaEmpleado(emp1);
           		fila.createCell(47).setCellValue(emp1.getFechaIngreso());
           		fila.createCell(48).setCellValue(emp1.getEstatus());
           		fila.createCell(49).setCellValue(emp1.getTipoSalario());
           		fila.createCell(50).setCellValue(emp1.getFechaBaja());
           		fila.createCell(51).setCellValue(emp1.getLoteMovImssAlta());
           		fila.createCell(52).setCellValue(emp1.getFechaVencimiento());
           		fila.createCell(53).setCellValue(emp1.getSueldoMensual());
           		fila.createCell(54).setCellValue(emp1.getSalarioDiarioInt());
           		fila.createCell(55).setCellValue(emp1.getPlazaTrabajo());
           		fila.createCell(56).setCellValue(emp1.getNumeroTrabajadorCliente());
           		if (emp1.getOtroPatron())
           			fila.createCell(57).setCellValue("SI");
           		else
           			fila.createCell(57).setCellValue("NO");           		
           		fila.createCell(58).setCellValue(emp1.getRfcOtroPatron());
           		fila.createCell(59).setCellValue(emp1.getNombreOtroPatron());
           		fila.createCell(60).setCellValue(emp1.isPermanencia());
           		fila.createCell(61).setCellValue(emp1.getCalle());
           		fila.createCell(62).setCellValue(emp1.getCodigoPostal());
           		fila.createCell(63).setCellValue(emp1.getMunicipioDel());
           		fila.createCell(64).setCellValue(emp1.getEntFederativa());
           		fila.createCell(65).setCellValue(emp1.getLoteMovImssBaja());
           		fila.createCell(66).setCellValue(emp1.isAplicaFiniquito());
           		fila.createCell(67).setCellValue(emp1.getMontoFiniquito());
           		fila.createCell(68).setCellValue(emp1.getPuesto().getDescripcion());
           		fila.createCell(69).setCellValue(emp1.getArea().getDescripcion());   
           		fila.createCell(70).setCellValue(emp1.getDepartamento().getDescripcion());
           		fila.createCell(71).setCellValue("N/A");
           		fila.createCell(72).setCellValue(emp1.getTipoContrato());
           		fila.createCell(73).setCellValue(emp1.getSueldoDiario());
           		fila.createCell(74).setCellValue("N/A");
           		fila.createCell(75).setCellValue("N/A");
              	numRz++;
           	}
            file.close();
            FileOutputStream outFile =new FileOutputStream(new File("C:\\archivosNGDAY\\tmp12.xlsx"));
            wb.write(outFile);
            outFile.close();
            archivoXLS = new File("C:\\archivosNGDAY\\tmp12.xlsx"); 	
         	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("<OTIKA>ERROR!"+e.getMessage());
			e.printStackTrace();
		}
        /*Cerramos el flujo de datos*/        
        return archivoXLS;
	}

}
