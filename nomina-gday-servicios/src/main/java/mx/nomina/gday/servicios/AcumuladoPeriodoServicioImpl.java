package mx.nomina.gday.servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

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

import mx.nomina.gday.dao.AcumuladoPeriodoDao;
import mx.nomina.gday.dao.NominaDao;
import mx.nomina.gday.dao.PeriodoDao;
import mx.nomina.gday.modelo.AcumuladoPeriodo;
import mx.nomina.gday.modelo.Empleado;
import mx.nomina.gday.modelo.EmpleadoNomina;
import mx.nomina.gday.modelo.HojaTrabajo;
import mx.nomina.gday.modelo.Nomina;

@Service
public class AcumuladoPeriodoServicioImpl implements AcumuladoPeriodoServicio {

	@Autowired
	private AcumuladoPeriodoDao acumuladoPeriodoDao;
	
	@Autowired
	private NominaDao nominaDao;
	
	@Autowired
	private PeriodoDao periodoDao;
	
		
	@Override
	public void agregarArchivo(AcumuladoPeriodo acumuladoPeriodo) {

		System.out.println("Acumulado"+acumuladoPeriodo.getNomina().getIdNomina());
		System.out.println("Acumulado"+acumuladoPeriodo.getPeriodo().getIdPeriodo());
		try{
			this.acumuladoPeriodoDao.agregarArchivo(acumuladoPeriodo);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List obtenerDatosCombo() {
		System.out.println("Datos del Combo Servicio");
		List datosCombo = new ArrayList();
		try{
			datosCombo.add(this.nominaDao.obtenerNominas());
			datosCombo.add(this.periodoDao.obtenerPeriodos());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return datosCombo;
	}

	@Override
	public List<AcumuladoPeriodo> obtenerAcumuladosByIdNominaAndIdPeriodo(AcumuladoPeriodo acumuladoPeriodo) {
		System.out.println("Acumulado Service");
		System.out.println("idNomina"+acumuladoPeriodo.getNomina().getIdNomina());
		System.out.println("idNomina"+acumuladoPeriodo.getPeriodo().getIdPeriodo());
		try {
			 
				List<AcumuladoPeriodo> tmp=this.acumuladoPeriodoDao.obtenerAcumuladosByIdNominaAndIdPeriodo(acumuladoPeriodo);
				System.out.println("Lista de Acumulados"+tmp.size());
					return tmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public File obtenerArchivoAcumulado(Integer idAcumulado) {
		// TODO Auto-generated method stub
		   //String rutaArchivo = System.getProperty("user.home")+"/ejemploExcelJava.xls";
	    AcumuladoPeriodo acumuladoPeriodo = this.acumuladoPeriodoDao.obtenerAcumuladosById(idAcumulado);
		String rutaArchivo = "c://archivosNGDAY//acumuladoTmp.xls";        
	    File archivoXLS = new File(rutaArchivo);
        
        try{
     		FileOutputStream fos = new FileOutputStream(rutaArchivo);
     	    fos.write(acumuladoPeriodo.getArchivoAcumulado());
     	    fos.close();     	    
     	   return archivoXLS;
        }
        catch(Exception e){
        	e.printStackTrace();
        }
       /*Cerramos el flujo de datos*/        
        return null;
	}

	@Override
	public boolean validarArchivo(AcumuladoPeriodo acumuladoPeriodo) {
		// TODO Auto-generated method stub
		int numArchivo=new Random().nextInt();
		String rutaArchivo = "c://archivosNGDAY//acumuladoTmp"+numArchivo+".xls";        
		File archivoXLS = new File(rutaArchivo);
	    try{
	       	List<String> titulosArchivo=new ArrayList<String>();
	        File archivo = null;
		    FileReader fr = null;
		    BufferedReader br = null;
	        archivo = new File ("C:\\archivosNGDAY\\encabezados.txt");
	        fr = new FileReader (archivo);
	        br = new BufferedReader(fr);
	      
	        String linea;
	        while((linea=br.readLine())!=null){
	    		StringTokenizer st = new StringTokenizer(linea,",");	    			
	    		while (st.hasMoreElements()) {
	    			String valor=""+st.nextElement();	    	
		            titulosArchivo.add(valor);
	    		}	     
	    		
	        }
	               
	        fr.close();
	        FileOutputStream fos = new FileOutputStream(rutaArchivo);
	     	fos.write(acumuladoPeriodo.getArchivoAcumulado());
	     	fos.close();
	    	FileInputStream file = new FileInputStream(rutaArchivo);
	    	HSSFWorkbook workbook = new HSSFWorkbook(file);    		
	        HSSFSheet hoja = workbook.getSheetAt(0);
	      	String data; 
	    	//System.out.println("Nombre de la Hoja\t" + archivoExcel.getSheet(sheetNo).getName());
	    	int filaNum=1;	    		
	    	Row fila = hoja.getRow(1);	    		
	    	System.out.println("datos:"+titulosArchivo.size());
	    	System.out.println("Columnas:"+fila.getLastCellNum());
	    	int numErrores=0;
	    	String cadenaErrores="No se encontraron las columnas:";
	    	for (int columna = 1; columna < fila.getLastCellNum()-1; columna++) { // Recorre					
	    		// cada columna de la fila
	    		if (fila.getCell(columna)!=null){
	    			fila.getCell(columna).setCellType(Cell.CELL_TYPE_STRING);
	    			data = fila.getCell(columna).getStringCellValue();
	    			int encontrado=0;
	    			for (int i=0;i<titulosArchivo.size();i++){
	    				if (data.equals(titulosArchivo.get(i))){
	    					encontrado++;
	    				}
	    			}
	    			if (encontrado==0){
	    				cadenaErrores=cadenaErrores+data+"-->";
	    				numErrores++;
	    			}
	    		}
	    	}
	    	System.out.println("Errores"+numErrores);
	    	System.out.println(cadenaErrores);
	       return true;	      
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    }
		return false;
	}

	@Override
	public File obtenerArchivoAcumuladoByData(List datos) {
		// TODO Auto-generated method stub
		   //String rutaArchivo = System.getProperty("user.home")+"/ejemploExcelJava.xls";	    
		String rutaArchivo = "c://archivosNGDAY//acumuladoMongo.xls";        
        /*Se crea el objeto de tipo File con la ruta del archivo*/
		File archivoXLS = new File(rutaArchivo); 
		//Evento eventoTmp=new Evento();
		System.out.println("Los datos que se buscan:"+datos.size());
		/*Se crea el archivo*/
        int filaInicial=1;
        int columnaInicial=0;        
        int totalDatos=20;
        try{
        	FileInputStream file = new FileInputStream(archivoXLS);
        	HSSFWorkbook workbook = new HSSFWorkbook(file);
        	HSSFSheet hoja = workbook.getSheetAt(0);
        	//Se llena el encabezado        	
        	//Se guardarán todos los empleados
        	Row fila = hoja.getRow(1);
        	for (int j=filaInicial,indexEmpleados=0; j<(datos.size()+filaInicial); j++,indexEmpleados++){
        		List <String> tmp=(List<String>) datos.get(indexEmpleados);
        		fila=hoja.createRow(j);
        		
        		int recorrerCeldas=0;
        	    			
        		fila.createCell(recorrerCeldas++).setCellValue(tmp.get(0));
        		fila.createCell(recorrerCeldas++).setCellValue(tmp.get(1));
        		fila.createCell(recorrerCeldas++).setCellValue(tmp.get(2));
        		fila.createCell(recorrerCeldas++).setCellValue(tmp.get(3));
        		fila.createCell(recorrerCeldas++).setCellValue(tmp.get(4));
        		fila.createCell(recorrerCeldas++).setCellValue(tmp.get(5));
        		fila.createCell(recorrerCeldas++).setCellValue(tmp.get(6));
        		fila.createCell(recorrerCeldas++).setCellValue(tmp.get(7)); 
        		fila.createCell(recorrerCeldas++).setCellValue(tmp.get(8));
        		fila.createCell(recorrerCeldas++).setCellValue(tmp.get(9));
        	}  	 	
            file.close();
            FileOutputStream outFile = new FileOutputStream(new File("C:\\archivosNGDAY\\tmpMongoGen.xls"));
            workbook.write(outFile);
            outFile.close();
            archivoXLS = new File("C:\\archivosNGDAY\\tmpMongoGen.xls"); 	
         	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("<OTIKA>ERROR!"+e.getMessage());
			e.printStackTrace();
		}
        /*Cerramos el flujo de datos*/        
        return archivoXLS;
	}
}


