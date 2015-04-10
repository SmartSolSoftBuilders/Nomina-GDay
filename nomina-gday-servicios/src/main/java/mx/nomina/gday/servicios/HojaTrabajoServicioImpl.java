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
	public File generarHojaTrabajo(Integer idHojaTrabajo) {
		// TODO Auto-generated method stub
		/*La ruta donde se creará el archivo*/
        //String rutaArchivo = System.getProperty("user.home")+"/ejemploExcelJava.xls";
	    HojaTrabajo hojaTrabajo = this.hojaTrabajoDao.obtenerHojaById(idHojaTrabajo);	    
		String rutaArchivo = "c://archivosNGDAY//layoutHojaTrabajo.xls";
        /*Se crea el objeto de tipo File con la ruta del archivo*/ 	    
		File archivoXLS = new File("C://archivosNGDAY//tmpHojaTrabajo"+idHojaTrabajo+".xls"); 
		//Evento eventoTmp=new Evento();
		/*Se crea el archivo*/
        int filaInicial=8;
        int columnaInicial=1;
        int totalDatos=67;
        try{
     		FileOutputStream fos = new FileOutputStream("C://archivosNGDAY//tmpHojaTrabajo"+idHojaTrabajo+".xls");
     	    fos.write(hojaTrabajo.getArchivoAcumulado());
     	    fos.close(); 
        	FileInputStream file = new FileInputStream(archivoXLS);
        	// Workbook wb = WorkbookFactory.create(new File("/path/to/your/excel/file"));
        	 //Sheet mySheet = wb.getSheetAt(0);
        	   // Iterator<Row> rowIter = mySheet.rowIterator();
        	    //System.out.println(mySheet.getRow(1).getCell(0));
        	HSSFWorkbook wb = new HSSFWorkbook(file);
        	//Workbook wb = new XSSFWorkbook(file); //or new HSSFWorkbook();
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
        	Row fila = hoja.getRow(0);	
        	fila.createCell(1).setCellValue(nomina.getNombreCorto());
        	fila = hoja.getRow(1);	
        	fila.createCell(1).setCellValue(nomina.getEsquema().getNombreEsquema());
        	fila = hoja.getRow(2);	
        	fila.createCell(1).setCellValue(nomina.getClaseRiesgo());
        	fila = hoja.getRow(3);	
        	fila.createCell(1).setCellValue(nomina.getPatrona().getNombreCortoPatrona());
        	fila = hoja.getRow(6);	
        	fila.createCell(1).setCellValue(nomina.getEjecutivo().getNombreEjecutivo());
        	fila = hoja.getRow(7);	
        	fila.createCell(1).setCellValue(nomina.getTipoPago());
        	fila = hoja.getRow(8);	
        	fila.createCell(1).setCellValue(nomina.getTipoPago());
        	fila = hoja.getRow(9);	
        	fila.createCell(1).setCellValue(nomina.getEsquema().getNombreEsquema());
        	fila = hoja.getRow(10);	
        	fila.createCell(1).setCellValue(nomina.getPeriodicidad());
        	fila = hoja.getRow(13);	
        	fila.createCell(1).setCellValue(nomina.getTipoCalendario().getSiglas());
        	fila = hoja.getRow(14);	
        	fila.createCell(1).setCellValue(nomina.getDiasAguinaldo());
        	fila = hoja.getRow(15);	
        	fila.createCell(1).setCellValue(nomina.getPorcPrimaVacacional());
        	fila = hoja.getRow(16);	
        	fila.createCell(1).setCellValue(nomina.getPorcPrimaVacacional());
        	fila = hoja.getRow(17);	
        	fila.createCell(1).setCellValue(nomina.getDiasAguinaldo());
        	/****Se llena 2da hoja****/
        	hoja = wb.getSheetAt(1);
           	int numRz=1;
           	System.out.println("Razones Sociales"+nomina.getRazonesSociales().size());
           	for (int j=0; j<nomina.getRazonesSociales().size();j++){
           		fila = hoja.createRow(numRz);
           		fila.createCell(0).setCellValue(nomina.getRazonesSociales().get(j).getNombreRazonSocial());
           		fila.createCell(1).setCellValue(nomina.getRazonesSociales().get(j).getNombreCortoRazonS());
           		fila.createCell(2).setCellValue(nomina.getRazonesSociales().get(j).getRfc());
           		fila.createCell(3).setCellValue(nomina.getRazonesSociales().get(j).getCodCliente());
           		fila.createCell(4).setCellValue("100%");
           		fila.createCell(5).setCellValue(nomina.getRazonesSociales().get(j).getComision()+"%");
           		numRz++;
           		System.out.println(nomina.getRazonesSociales().get(j));
           	}
           	System.out.println("Número de Empleados:"+empleados.size());
           	/****Se llena 3ra hoja****/           	
        	hoja = wb.getSheetAt(2);
        	numRz=1;
        	int j=0;
        	for (j=0; j<nomina.getRazonesSociales().size();j++){
        		fila = hoja.createRow(numRz);
        		fila.createCell(j+4).setCellValue(nomina.getRazonesSociales().get(j).getNombreCortoRazonS());
        	}
        	fila.createCell(j+4).setCellValue("Total");
           	numRz=2;
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
           	/****Se llena 4ta hoja****/
           	hoja = wb.getSheetAt(3);
           	numRz=2;
           	for (j=0; j<empleados.size();j++){
           		fila = hoja.createRow(numRz);
           		fila.createCell(0).setCellValue(""+(j+1));	
           		fila.createCell(1).setCellValue(empleados.get(j).getNoControl());
           		fila.createCell(2).setCellValue(empleados.get(j).getNss());	
           		fila.createCell(3).setCellValue(empleados.get(j).getNombre());
           		fila.createCell(4).setCellValue(empleados.get(j).getApellidoPaterno());
           		fila.createCell(5).setCellValue(empleados.get(j).getApellidoMaterno());
           		fila.createCell(6).setCellValue(empleados.get(j).getCurp());
           		fila.createCell(7).setCellValue(empleados.get(j).getRfc());
           		fila.createCell(8).setCellValue(empleados.get(j).getNss());
           		fila.createCell(9).setCellValue(empleados.get(j).getFechaNacimiento());
           		fila.createCell(10).setCellValue(empleados.get(j).getEdad());
           		fila.createCell(11).setCellValue(empleados.get(j).getSexo());
           		fila.createCell(12).setCellValue(empleados.get(j).getEstadoCivil());
           		fila.createCell(13).setCellValue(empleados.get(j).getNacionalidad());
           		fila.createCell(14).setCellValue(empleados.get(j).getCalle());
           		//------Test-
           		fila.createCell(15).setCellValue(empleados.get(j).getNumExterior());
           		fila.createCell(16).setCellValue(empleados.get(j).getNumInterior());
           		fila.createCell(17).setCellValue(empleados.get(j).getColonia());
           		fila.createCell(18).setCellValue(empleados.get(j).getCodigoPostal());
           		fila.createCell(19).setCellValue(empleados.get(j).getMunicipioDel());
           		fila.createCell(20).setCellValue(empleados.get(j).getEntFederativa());
           		fila.createCell(21).setCellValue(empleados.get(j).getCuenta());
           		fila.createCell(22).setCellValue(empleados.get(j).getBanco());
           		fila.createCell(23).setCellValue(empleados.get(j).getTipoPago());
           		fila.createCell(24).setCellValue(empleados.get(j).getFechaIngresoReal());
           		fila.createCell(25).setCellValue(empleados.get(j).getNoCredInfonavit());
           		fila.createCell(26).setCellValue(empleados.get(j).getDesInfonavitPorc());
           		fila.createCell(27).setCellValue(empleados.get(j).getDescInfonavitVsmg());
           		fila.createCell(28).setCellValue("");
           		fila.createCell(29).setCellValue(empleados.get(j).getDescInfonavitImp());
           		fila.createCell(30).setCellValue(empleados.get(j).getNoCredInfonavit());
           		fila.createCell(31).setCellValue(empleados.get(j).getPensionAlimAcred());
           		fila.createCell(32).setCellValue(empleados.get(j).getPensionAlimImp());
           		//Nómina Empleado	
           		EmpleadoNomina emp1= new EmpleadoNomina();
           		emp1.setNomina(nomina);
           		emp1.setEmpleado(empleados.get(j));
           		emp1= this.empleadoNominaDao.obtenerEmpleadoNominaByIdNominaEmpleado(emp1);
           		fila.createCell(34).setCellValue("SI");
           		fila.createCell(35).setCellValue(emp1.getNombreOtroPatron());
           		fila.createCell(36).setCellValue(emp1.getRfcOtroPatron());
           		fila.createCell(37).setCellValue(emp1.getFechaIngreso());
           		fila.createCell(38).setCellValue("Régimen de Contratación");
           		fila.createCell(39).setCellValue("2016/03/03");
           		fila.createCell(40).setCellValue(emp1.getFechaBaja());
           		fila.createCell(41).setCellValue(emp1.getSalarioDiarioInt()*26);
           		fila.createCell(42).setCellValue(emp1.getSalarioDiarioInt());   
           		fila.createCell(44).setCellValue(emp1.getSalarioDiarioInt());
           		fila.createCell(45).setCellValue(emp1.getSalarioDiarioInt());
              	numRz++;
           	}
            file.close();
            FileOutputStream outFile =new FileOutputStream(new File("C:\\archivosNGDAY\\tmp12.xls"));
            wb.write(outFile);
            outFile.close();
            archivoXLS = new File("C:\\archivosNGDAY\\tmp12.xls"); 	
         	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("<OTIKA>ERROR!"+e.getMessage());
			e.printStackTrace();
		}
        /*Cerramos el flujo de datos*/        
        return archivoXLS;
	}

}
