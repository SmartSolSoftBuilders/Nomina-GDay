package mx.nomina.gday.servicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nomina.gday.dao.ArchivoDao;
import mx.nomina.gday.dao.EmpleadoDao;
import mx.nomina.gday.dao.EmpleadoNominaDao;
import mx.nomina.gday.modelo.Archivo;
import mx.nomina.gday.modelo.Empleado;
import mx.nomina.gday.modelo.EmpleadoNomina;
import mx.nomina.gday.modelo.Nomina;


@Service
public class ArchivoServicioImpl implements ArchivoServicio{
	
	@Autowired
	private ArchivoDao archivoDao;
	
	@Autowired
	private EmpleadoNominaDao empleadoNominaDao;

	@Autowired
	private EmpleadoDao empleadoDao;

	@Override
	public void agregarArchivo(Archivo archivo) {
		// TODO Auto-generated method stub
		try{
			this.archivoDao.agregarArchivo(archivo);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public Archivo obtenerUltimaCargaArchivo() {
		// TODO Auto-generated method stub
	   return this.archivoDao.obtenerUltimaCargaArchivo();
	}

	@Override
	public int revertirCarga() {
		// TODO Auto-generated method stub
		Archivo archivo = new Archivo();
		archivo = this.obtenerUltimaCargaArchivo();
		try{
			System.out.println("ARCHIVO OBTENIDO:"+archivo.getArchivo().length);
			FileOutputStream fos = new FileOutputStream("C://archivosNGDAY//tmp2.xls");
		    fos.write(archivo.getArchivo());	    
		    fos.close();
		    this.revertirXLS("C://archivosNGDAY//tmp2.xls");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return 0;
	}
	
	public boolean revertirXLS(String nombreArchivo) {
	    
    	try {
    		System.out.println("se carga el archivo:"+nombreArchivo);    		
    		FileInputStream file = new FileInputStream(nombreArchivo);
    		HSSFWorkbook workbook = new HSSFWorkbook(file);    		
        	HSSFSheet hoja = workbook.getSheetAt(0);

        	//Se llena el encabezado        			        	
    			int numColumnas = 89; 
    			int numFilas = 5; 
    			String data; 
    			//System.out.println("Nombre de la Hoja\t" + archivoExcel.getSheet(sheetNo).getName());
    			int filaNum=3;
    			Row fila = hoja.getRow(filaNum);
    			for (; filaNum < numFilas; filaNum++) { // Recorre cada 
    				//fila de la hoja
    				fila = hoja.getRow(filaNum);    				    				
    				List <String> datos = new ArrayList<String>();    				
    					if (fila.getCell(2)!=null){
    						fila.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
    						String curp = fila.getCell(2).getStringCellValue();
    						Empleado empleado = new Empleado();
    						empleado.setCurp(curp);
    						empleado=empleadoDao.obtenerIdEmpleadoByCurp(empleado);
    						System.out.println(curp);
    						if (empleado!=null){
        						int idEmpleado=empleado.getIdEmpleado();
           						System.out.println("ID OBTENIDO:"+idEmpleado);
           					
    							data = ""+idEmpleado;
    							datos.add(data);
    						}
    					}    						
    				for (int i=0; i<datos.size();i++){
    					this.empleadoNominaDao.eliminarEmpleadoNominayEmpleado(Integer.parseInt(datos.get(i)));
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
