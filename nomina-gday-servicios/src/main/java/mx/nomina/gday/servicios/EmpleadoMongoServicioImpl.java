package mx.nomina.gday.servicios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nomina.gday.dao.AreaDao;
import mx.nomina.gday.dao.DepartamentoDao;
import mx.nomina.gday.modelo.AcumuladoPeriodo;
import mx.nomina.gday.modelo.Empleado;
import mx.nomina.gday.modelo.EmpleadoNomina;
import mx.nomina.gday.modelo.Nomina;
import mx.nomina.gday.mongo.EmpleadoMongo;
import mx.nomina.gday.mongo.EmpleadoMongoImpl;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

@Service
public class EmpleadoMongoServicioImpl implements EmpleadoMongoServicio{
	
	private EmpleadoMongo empleadoMongo = new EmpleadoMongoImpl();
	
	@Override 
	public void guardarDocumento(AcumuladoPeriodo acumuladoPeriodo){
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("testDB");
	    DBCollection collection = db.getCollection("empleados");
	    HashMap map = new HashMap();
	    String nombreArchivo = "C:\\archivosNGDAY\\cargaMongo."+acumuladoPeriodo.getTipoArchivo();
	    File archivoXLS = new File(nombreArchivo);
	    //Se crea el acumuladoTemporal
        try{
     		FileOutputStream fos = new FileOutputStream(nombreArchivo);
     	    fos.write(acumuladoPeriodo.getArchivoAcumulado());
     	    fos.close();     	    
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        //Se genera un hashMap con el valor columna-valor
        try {
    		System.out.println("se carga el archivo:"+nombreArchivo);    		    		
    		FileInputStream file = new FileInputStream(nombreArchivo);
    		HSSFWorkbook workbook = null;
    		Workbook workbookxlsx = null; 
    		Sheet hoja = null;
    		if (acumuladoPeriodo.getTipoArchivo().equals("xls")){
    			workbook = new HSSFWorkbook(file);
    			hoja = workbook.getSheetAt(0);
    		}    			
    		else {
    			workbookxlsx = new XSSFWorkbook(file); //or new HSSFWorkbook();
    			hoja = workbookxlsx.getSheetAt(0);
    		}

        	//Se llena el encabezado        			        	
    		int numColumnas = 22; 
    		int numFilas = 10; 
    		String data; 
    		String titulo;
    		//System.out.println("Nombre de la Hoja\t" + archivoExcel.getSheet(sheetNo).getName());
    		int filaNum=2;
    		int colNum=1;
    		Row filaTitulo = hoja.getRow(1);
    		Row fila = hoja.getRow(colNum);
    		//System.out.println("LINEAS:"+hoja.getLastRowNum());
    		for (; filaNum < hoja.getLastRowNum()-1; filaNum++) { // Recorre cada fila de la hoja     			
    			fila = hoja.getRow(filaNum);
    			map = new HashMap();
    			map.put("id_nomina",acumuladoPeriodo.getNomina().getIdNomina());
    			map.put("id_acumulado",acumuladoPeriodo.getIdAcumuladoPeriodo());	
    			map.put("numero_periodo",acumuladoPeriodo.getNumeroPeriodo());    			
    			map.put("mes_pago",acumuladoPeriodo.getMesPago());
    			map.put("anio_pago",acumuladoPeriodo.getAnioPago());
    			
        		System.out.println("columnas:"+fila.getLastCellNum());
    			for (int columna = 1; columna < (fila.getLastCellNum()-1); columna++) { // Recorre					
    				// cada columna de la fila
    				if (fila.getCell(columna)!=null){
    					filaTitulo.getCell(columna).setCellType(Cell.CELL_TYPE_STRING);
    					titulo = filaTitulo.getCell(columna).getStringCellValue();
    					fila.getCell(columna).setCellType(Cell.CELL_TYPE_STRING);
    					data = fila.getCell(columna).getStringCellValue();    					
    			//		System.out.print(" Columna->"+titulo+"Valor_"+data);	
        				if (titulo.length()>1)
        					map.put(titulo.replace(".","_"),data);

    				}
    			}
    			this.empleadoMongo.saveDocument(collection, map);
    		}			        			
    	}
    	catch (Exception ioe) { 
    		System.out.println("Error:"+ioe.getMessage());
    		ioe.printStackTrace(); 
    	}  
	}
	
	@Override 
	public List obtenerDocumentos(Integer id1, String id2, String id3, String id4){
		List listaPrincipal  = new ArrayList();		
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("testDB");
	    DBCollection collection = db.getCollection("empleados");
	    System.out.println("Collection mycol selected successfully");
		BasicDBObject whereQuery = new BasicDBObject();
		if (id1>0)
			whereQuery.put("id_nomina", id1);
		if (id2!=null && id2!="" ){
			if  (!id2.equals("0"))
				whereQuery.put("mes_pago", id2);
		}
		if (id3!=null && id3!="" ){
			if  (!id3.equals("0"))
				whereQuery.put("anio_pago", id3);
		}
		if (id4!=null && id4!="" ){
			if  (!id4.equals("0"))
				whereQuery.put("numero_periodo", id4);
		}
			
        DBCursor cursor = collection.find(whereQuery);
        int i=1;
        System.out.println("Se buscarán los registros de la nómina:"+id1);
        while (cursor.hasNext()) {        	
           List<String> listaMongo  = new ArrayList<String>();
           //System.out.println("Document: "+i); 
           DBObject obj=cursor.next();
           listaMongo.add(""+obj.get("# Control"));
           listaMongo.add(""+obj.get("Nombre"));
           listaMongo.add(""+obj.get("Paterno"));
           listaMongo.add(""+obj.get("Materno"));
           listaMongo.add(""+obj.get("CURP"));
           listaMongo.add(""+obj.get("RFC"));
           listaMongo.add(""+"");
           listaMongo.add(""+""+obj.get("Esquema"));
           listaMongo.add(""+obj.get("Patrona"));
           listaMongo.add(""+obj.get("# Crédito Infonavit"));
           listaMongo.add(""+obj.get("Crédito Infonavit"));
           listaMongo.add(""+obj.get("Fecha de Aniversario"));
           listaMongo.add(""+obj.get("Fecha de ingreso"));
           listaMongo.add(""+obj.get("Antigüedad"));
           listaMongo.add(""+obj.get("Tipo Contrato"));
           listaMongo.add(""+obj.get("SDI"));
           listaMongo.add(""+obj.get("Depto"));
           listaMongo.add(""+obj.get("Puesto"));
           listaMongo.add(""+obj.get("Categoria"));
           listaMongo.add(""+obj.get("Salario Diario"));
           listaPrincipal.add(listaMongo);
           i++;
        }
	    return listaPrincipal;
	}
	
	
	@Override
	public void testMongo() {
		// TODO Auto-generated method stub
		 MongoClient mongo = new MongoClient("localhost", 27017);
		 DB db = mongo.getDB("testDB");
	     DBCollection collection = db.getCollection("empleados");
	         
	        ///Delete All documents before running example again
	       WriteResult result = collection.remove(new BasicDBObject());
	       System.out.println("Test!!");
	       System.out.println(result);
	        try{
		        this.empleadoMongo.basicDBObject_Example(collection);
		         
		        this.empleadoMongo.basicDBObjectBuilder_Example(collection);
		         
		        this.empleadoMongo.hashMap_Example(collection);
		         
		        this.empleadoMongo.parseJSON_Example(collection);
		         
		        DBCursor cursor = collection.find();
		        while(cursor.hasNext()) {
		            System.out.println(cursor.next());
		        }
	        }
	        catch (Exception e){
	        	System.out.println("Error:"+e.getMessage());
	        }
		
	}

	@Override
	public void eliminarDocumento(AcumuladoPeriodo acumuladoPeriodo) {
		// TODO Auto-generated method stub
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("testDB");
	    DBCollection collection = db.getCollection("empleados");
	    BasicDBObject query = new BasicDBObject();
	    query.append("id_acumulado", acumuladoPeriodo.getIdAcumuladoPeriodo());
	    collection.remove(query);
	}

	
}
