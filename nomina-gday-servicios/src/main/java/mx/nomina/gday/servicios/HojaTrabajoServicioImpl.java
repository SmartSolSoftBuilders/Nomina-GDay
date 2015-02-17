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
		File archivoXLS = new File("C://archivosNGDAY//tmpHojaTrabajo"+idHojaTrabajo+".xlsm"); 
		//Evento eventoTmp=new Evento();
		/*Se crea el archivo*/
        int filaInicial=8;
        int columnaInicial=1;
        int totalDatos=67;
        try{
     		FileOutputStream fos = new FileOutputStream("C://archivosNGDAY//tmpHojaTrabajo"+idHojaTrabajo+".xlsm");
     	    fos.write(hojaTrabajo.getArchivoAcumulado());
     	    fos.close(); 
        	FileInputStream file = new FileInputStream(archivoXLS);
        	// Workbook wb = WorkbookFactory.create(new File("/path/to/your/excel/file"));
        	 //Sheet mySheet = wb.getSheetAt(0);
        	   // Iterator<Row> rowIter = mySheet.rowIterator();
        	    //System.out.println(mySheet.getRow(1).getCell(0));
//        	HSSFWorkbook workbook = new HSSFWorkbook(file);
        	Workbook wb = new XSSFWorkbook(file); //or new HSSFWorkbook();
            CreationHelper creationHelper = wb.getCreationHelper();
            
        	//Se trabaja la primer HOJA GENERALES EMPRESA
        	Sheet hoja = wb.getSheetAt(0);
        	Nomina nomina = this.nominaDao.obtenerNominaByIdHojaTrabajo(idHojaTrabajo);
        	nomina=this.nominaDao.obtenerNominaById(37);
        	System.out.println(nomina.getIdNomina());
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
        	//fila.createCell(1).setCellValue(nomina.getEjecutivo().getNombreEjecutivo());
        	/****Se llena 2da hoja****/
        	hoja = wb.getSheetAt(1);
        	fila = hoja.getRow(1);
//        	nomina.setRazonesSociales(this.nominaDao.);
        	fila.createCell(0).setCellValue(nomina.getRazonesSociales().get(0).getNombreCortoRazonS());
            file.close();
            FileOutputStream outFile =new FileOutputStream(new File("C:\\archivosNGDAY\\tmp12.xlsm"));
            wb.write(outFile);
            outFile.close();
            archivoXLS = new File("C:\\archivosNGDAY\\tmp12.xlsm"); 	
         	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("<OTIKA>ERROR!"+e.getMessage());
			e.printStackTrace();
		}
        /*Cerramos el flujo de datos*/        
        return archivoXLS;
	}

}
