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
import mx.nomina.gday.dao.GrupoDao;
import mx.nomina.gday.dao.NominaDao;
import mx.nomina.gday.dao.PatronaDao;
import mx.nomina.gday.dao.PeriodoDao;
import mx.nomina.gday.dao.TipoCalendarioDao;
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
	
	@Autowired
	private PatronaDao patronaDao;
	
	@Autowired
	private GrupoDao grupoDao;
	
	@Autowired
	private TipoCalendarioDao tipoCalendarioDao;
	
	@Override
	public void eliminarAcumulado(AcumuladoPeriodo acumuladoPeriodo){
		System.out.println("Eliminando Acumulado"+acumuladoPeriodo.getIdAcumuladoPeriodo());		
		try{
			this.acumuladoPeriodoDao.eliminarAcumulado(acumuladoPeriodo);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

		 
	@Override
	public int agregarArchivo(AcumuladoPeriodo acumuladoPeriodo) {
		System.out.println("Acumulado"+acumuladoPeriodo.getNomina().getIdNomina());
		System.out.println("Acumulado"+acumuladoPeriodo.getNumeroPeriodo());
		try{
			return this.acumuladoPeriodoDao.agregarArchivo(acumuladoPeriodo);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public List obtenerDatosComboNssCurp(int idNomina) {
		System.out.println("Datos del Combo Servicio");
		List datosCombo = new ArrayList();
		List<String> nsss=this.nominaDao.obtenerNssByIdNomina(idNomina);
		List<String> curps=this.nominaDao.obtenerCurpByIdNomina(idNomina);
		System.out.println(nsss.size());
		System.out.println(curps.size());
		try{			
			datosCombo.add(nsss);			
			datosCombo.add(curps);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return datosCombo;
	}
	
	@Override
	public List obtenerDatosCombo() {
		System.out.println("Datos del Combo Servicio");
		List datosCombo = new ArrayList();
		try{
			datosCombo.add(this.nominaDao.obtenerNominas());
			datosCombo.add(this.periodoDao.obtenerPeriodos());
			datosCombo.add(this.grupoDao.obtenerGrupos());
			datosCombo.add(this.patronaDao.obtenerPatronas());			
			datosCombo.add(this.tipoCalendarioDao.obtenerTiposCalendario());
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
		System.out.println("idNomina"+acumuladoPeriodo.getNumeroPeriodo());
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
	public String obtenerArchivoAcumuladoExt(Integer idAcumulado) {
		AcumuladoPeriodo acumuladoPeriodo = this.acumuladoPeriodoDao.obtenerAcumuladosById(idAcumulado);	    
	    if (acumuladoPeriodo.getTipoArchivo()=="xls")
	    	return "xls";
	    else
	    	return "xlsx";
	}
	
	@Override
	public Integer obtenerAcumuladosByName(String nombreArchivo){
		return this.acumuladoPeriodoDao.obtenerAcumuladosByName(nombreArchivo);
	}
	@Override
	public File obtenerArchivoAcumulado(Integer idAcumulado) {
		// TODO Auto-generated method stub
		   //String rutaArchivo = System.getProperty("user.home")+"/ejemploExcelJava.xls";
	    AcumuladoPeriodo acumuladoPeriodo = this.acumuladoPeriodoDao.obtenerAcumuladosById(idAcumulado);
	    String rutaArchivo = "c://archivosNGDAY//acumuladoTmp.xlsx";
	    if (acumuladoPeriodo.getTipoArchivo()=="xls")
	    	rutaArchivo = "c://archivosNGDAY//acumuladoTmp.xls";        
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
	    	HSSFWorkbook workbook = null;
	    	Workbook workbookxlsx = null;
	    	Sheet hoja= null;
	    	if (acumuladoPeriodo.getTipoArchivo().equals("xls")){
	    		workbook = new HSSFWorkbook(file);
	    		hoja = workbook.getSheetAt(0);
	    	}
	    	else{
	    		workbookxlsx = new XSSFWorkbook(file); //or new HSSFWorkbook();
	    		hoja = workbookxlsx.getSheetAt(0);
	    	}
	    		        
	      	String data; 
	    	//System.out.println("Nombre de la Hoja\t" + archivoExcel.getSheet(sheetNo).getName());
	    	int filaNum=1;	    		
	    	Row fila = hoja.getRow(1);	    		
	    	//System.out.println("datos:"+titulosArchivo.size());
	    	//System.out.println("Columnas:"+fila.getLastCellNum());
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
		String rutaArchivo = "c://archivosNGDAY//acumuladoMongo.xlsx";        
        /*Se crea el objeto de tipo File con la ruta del archivo*/
		File archivoXLS = new File(rutaArchivo); 
		//Evento eventoTmp=new Evento();
		//System.out.println("Los datos que se buscan:"+datos.size());
		/*Se crea el archivo*/
        int filaInicial=1;
        int columnaInicial=0;        
        int limitePorHoja=1000; 
        try{
	    	Workbook workbookxlsx = null;
	    	Sheet hoja= null;	    	
        	FileInputStream file = new FileInputStream(archivoXLS);
        	workbookxlsx = new XSSFWorkbook(file); //or new HSSFWorkbook();
        	int contadorHojas=0;        	
	    	hoja = workbookxlsx.getSheetAt(contadorHojas);        	
        	//Se llena el encabezado        	
        	Row fila = hoja.getRow(1);
        	for (int j=filaInicial,indexEmpleados=0; j<=(datos.size()); j++,indexEmpleados++){
        		if(indexEmpleados<limitePorHoja){
        			List <String> tmp=(List<String>) datos.get(indexEmpleados);
        			//System.out.println("VALOR:"+tmp.get(0));
        			if (contadorHojas==0){
        				fila=hoja.createRow(j);
        			}
        			else{
        				//System.out.println("J;"+j);
        				fila=hoja.createRow(j-(limitePorHoja/2));        			
        			}
        			int recorrerCeldas=0;        
        			//System.out.println("num Control:+"+tmp.get(0));
        			//System.out.println("Registro:+"+indexEmpleados);
        			//fila.createCell(recorrerCeldas++).setCellValue((indexEmpleados+1));
        			//System.out.println("TOTAL RG:"+tmp.size());        			
        			if (!tmp.get(0).equals("null") && tmp.get(0)!=""){        				
        				for (int l=0;l<416;l++)
        					fila.createCell(recorrerCeldas++).setCellValue(tmp.get(l));	        			
        			}
        		}
        		else{
        			limitePorHoja=limitePorHoja+limitePorHoja;        					
        			contadorHojas++;
        			workbookxlsx.createSheet(""+contadorHojas);
        			hoja = workbookxlsx.getSheet(""+contadorHojas);
        			filaInicial=2;
        		}
        		
        	}  	 	
            file.close();
            FileOutputStream outFile = new FileOutputStream(new File("C:\\archivosNGDAY\\tmpMongoGen.xlsx"));
            workbookxlsx.write(outFile);
            outFile.close();
            archivoXLS = new File("C:\\archivosNGDAY\\tmpMongoGen.xlsx"); 	         	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("<OTIKA>ERROR!"+e.getMessage());
			e.printStackTrace();
		}
        /*Cerramos el flujo de datos*/        
        return archivoXLS;
	}
}


