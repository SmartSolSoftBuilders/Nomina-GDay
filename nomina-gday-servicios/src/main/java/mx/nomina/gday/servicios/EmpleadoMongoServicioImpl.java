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
    		String data; 
    		String titulo;
    		//System.out.println("Nombre de la Hoja\t" + archivoExcel.getSheet(sheetNo).getName());
    		int filaNum=1;
    		int colNum=1;
    		Row filaTitulo = hoja.getRow(0);
    		Row fila = hoja.getRow(colNum);
    		//System.out.println("LINEAS:"+hoja.getLastRowNum());
    		for (; filaNum <= hoja.getLastRowNum()-1; filaNum++) { // Recorre cada fila de la hoja     			
    			fila = hoja.getRow(filaNum);
    			map = new HashMap();
    			map.put("id_nomina",acumuladoPeriodo.getNomina().getIdNomina());
    			map.put("id_acumulado",acumuladoPeriodo.getIdAcumuladoPeriodo());	
    			map.put("numero_periodo",acumuladoPeriodo.getNumeroPeriodo());    			    			
    			if (fila==null)
    				break;
        		System.out.println("columnas:"+fila.getLastCellNum());
    			for (int columna = 0; columna < (fila.getLastCellNum()-1); columna++) { 
    				// Recorre cada columna de la fila
    				if (fila.getCell(columna)!=null){
    					
    					filaTitulo.getCell(columna).setCellType(Cell.CELL_TYPE_STRING);
    					titulo = filaTitulo.getCell(columna).getStringCellValue();    					
    					fila.getCell(columna).setCellType(Cell.CELL_TYPE_STRING);
    					data = fila.getCell(columna).getStringCellValue();    					
    					//System.out.print("Columna->"+titulo+"Valor_"+data);
    					if (titulo.equals("AGRUP_NOMINA_TABLERO_CONTROL")){
    						System.out.println("Por Obtener el num de control!"+titulo+"->"+data);
    						int anio=2000;
    						String cadena=data;
    						int numEspacios=0;
    						int contador=0;
    						int i=0;
    						for (i=0; i<cadena.length();i++){
    							if (cadena.charAt(i)==' '){
    								contador++;
    							}
    							if (contador==3)
    								break;    							     						   
    						}
    						System.out.println("En el caracter: Contador:"+i);
    						int indice=i+1;
    						if (data.length()>1){
    							System.out.println("-"+data.substring(indice,indice+3)+"-");
    							System.out.println(data.substring(indice,indice+3));
    							map.put("mes_pago",data.substring(indice,indice+3).toUpperCase());
    							if (isNumber( (data.substring(indice+4,indice+6))+anio)){
    								System.out.println("-"+(Integer.parseInt(data.substring(indice+4,indice+6))+anio)+"-");
    								map.put("anio_pago",""+(Integer.parseInt(data.substring(indice+4,indice+6))+anio));
    							}
    							else
    								map.put("anio_pago","");
    						}
    						else{
    							map.put("mes_pago","");
    							map.put("anio_pago","");
    						}
    					}
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
	
	
	public static boolean isNumber(String string){
		try{
			Integer.parseInt(string);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	@Override 
	public List obtenerDocumentos(Integer id1, String id2, String id3, String id4, String id5, String id6, String id7, String id8, String id9){
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
		if (id5!=null && id5!="" ){
			if  (!id5.equals("0"))
				whereQuery.put("GRUPO", id5);
		}
		if (id6!=null && id6!="" ){
			if  (!id6.equals("0"))
				whereQuery.put("PATRONA", id6);
		}
		/*if (id7!=null && id7!="" ){
			if  (!id7.equals("0"))
				whereQuery.put("numero_periodo", id7);
		}*/
		if (id8!=null && id8!="" ){
			if  (!id8.equals("0"))
				whereQuery.put("CURP", id8);
		}
		System.out.println(id9);
		if (id9!=null && id9!="" ){
			if  (!id9.equals("0"))
				whereQuery.put("NSS", id9);
		}
	
        DBCursor cursor = collection.find(whereQuery);
        int i=1;
        System.out.println("Se buscarán los registros de la nómina:"+id1);
        while (cursor.hasNext()) {        	
           List<String> listaMongo  = new ArrayList<String>();
           //System.out.println("Document: "+i); 
           DBObject obj=cursor.next();
           listaMongo.add(""+obj.get("NUM_CONTROL"));
           listaMongo.add(""+obj.get("ESQUEMA"));
           listaMongo.add(""+obj.get("PATRONA"));
           listaMongo.add(""+obj.get("RAZON_SOCIAL"));
           listaMongo.add(""+obj.get("RFC_EMPRESA"));
           listaMongo.add(""+obj.get("CALLE_NUM"));
           listaMongo.add(""+obj.get("COLONIA"));
           listaMongo.add(""+obj.get("DELEGACION"));
           listaMongo.add(""+obj.get("ESTADO"));
           listaMongo.add(""+obj.get("PAIS"));
           listaMongo.add(""+obj.get("CODIGO_POSTAL"));
           listaMongo.add(""+obj.get("REGIMEN_FISCAL"));
           listaMongo.add(""+obj.get("REG_PATRONAL"));
           listaMongo.add(""+obj.get("CLASE_RIESGO_TRABAJO"));
           listaMongo.add(""+obj.get("CLAVE_RIESGO_TRABAJO"));
           listaMongo.add(""+obj.get("INTERMEDIARIA"));
           listaMongo.add(""+obj.get("NOMBRE_COMPLETO"));
           listaMongo.add(""+obj.get("NOMBRE"));
           listaMongo.add(""+obj.get("AP_PATERNO"));
           listaMongo.add(""+obj.get("AP_MATERNO"));
           listaMongo.add(""+obj.get("CURP"));
           listaMongo.add(""+obj.get("RFC_EMPLEADO"));
           listaMongo.add(""+obj.get("NSS"));
           listaMongo.add(""+obj.get("NUM_CRED_INFONAVIT"));
           listaMongo.add(""+obj.get("DESC_INFONAVIT"));
           listaMongo.add(""+obj.get("CRED_FON_IMP_RET_IMSS"));
           listaMongo.add(""+obj.get("FECHA_ANIVERSARIO"));
           listaMongo.add(""+obj.get("FECHA_INGRESO"));
           listaMongo.add(""+obj.get("FECHA_ANT_EMPL_SAT"));
           listaMongo.add(""+obj.get("FECHA_ANT_EMPL_IMSS"));
           listaMongo.add(""+obj.get("FECHA_BAJA_EMPL"));
           listaMongo.add(""+obj.get("SALARIO_REAL_MES_PATR"));
           listaMongo.add(""+obj.get("SALARIO_REAL_MES_SIND"));
           listaMongo.add(""+obj.get("TIPO_CONTRATACION"));
           listaMongo.add(""+obj.get("CVE_TIPO_CONTRATACION"));
           listaMongo.add(""+obj.get("TIPO_COMPROBANTE"));
           listaMongo.add(""+obj.get("TIPO_CONTRATO"));
           listaMongo.add(""+obj.get("TIPO_JORNADA"));
           listaMongo.add(""+obj.get("SALARIO_BASE"));
           listaMongo.add(""+obj.get("FACTOR_INTEGRACION"));
           listaMongo.add(""+obj.get("SALARIO_DIA_INT_IMSS"));
           listaMongo.add(""+obj.get("FECHA_MODIFICACION"));
           listaMongo.add(""+obj.get("DIAS_BIMESTRE_ANT"));
           listaMongo.add(""+obj.get("INGR_VAR_BIM_ANT"));
           listaMongo.add(""+obj.get("PUESTO_ESQUEMA"));
           listaMongo.add(""+obj.get("AREA"));
           listaMongo.add(""+obj.get("DEPARTAMENTO"));
           listaMongo.add(""+obj.get("PUESTO"));
           listaMongo.add(""+obj.get("CATEGORIA"));
           listaMongo.add(""+obj.get("SUELDO_DIA_USO_INTERNO"));
           listaMongo.add(""+obj.get("D_LABORADOS"));
           listaMongo.add(""+obj.get("D_COMPLEMENTARIOS"));
           listaMongo.add(""+obj.get("D_VACACIONES"));
           listaMongo.add(""+obj.get("D_INCAPACIDAD"));
           listaMongo.add(""+obj.get("D_TPO_INCAPACIDAD"));
           listaMongo.add(""+obj.get("D_DESCUENTO"));
           listaMongo.add(""+obj.get("D_FESTIVO"));
           listaMongo.add(""+obj.get("D_FALTAS"));
           listaMongo.add(""+obj.get("D_PRIMA_VACACIONAL"));
           listaMongo.add(""+obj.get("D_PRIMA_DOMINICAL"));
           listaMongo.add(""+obj.get("D_AGUINALDO"));
           listaMongo.add(""+obj.get("HET_DIAS"));
           listaMongo.add(""+obj.get("HET_TIPO_HRS"));
           listaMongo.add(""+obj.get("HET_HRS_EXTRA"));
           listaMongo.add(""+obj.get("HET_IMPORTE"));
           listaMongo.add(""+obj.get("HED_DIAS"));
           listaMongo.add(""+obj.get("HED_TIPO_HORAS"));
           listaMongo.add(""+obj.get("HED_HORAS_EXTRA"));
           listaMongo.add(""+obj.get("HED_IMPORTE"));
           listaMongo.add(""+obj.get("ANTICIPO_REMANENTES"));
           listaMongo.add(""+obj.get("S_TIPO"));
           listaMongo.add(""+obj.get("S_CLAVE"));
           listaMongo.add(""+obj.get("S_CONCEPTO"));
           listaMongo.add(""+obj.get("S_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("S_IMP_EXENTO"));
           listaMongo.add(""+obj.get("V_TIPO"));
           listaMongo.add(""+obj.get("V_CLAVE"));
           listaMongo.add(""+obj.get("V_CONCEPTO"));
           listaMongo.add(""+obj.get("V_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("V_IMP_EXENTO"));
           listaMongo.add(""+obj.get("PV_TIPO"));
           listaMongo.add(""+obj.get("PV_CLAVE"));
           listaMongo.add(""+obj.get("PV_CONCEPTO"));
           listaMongo.add(""+obj.get("PV_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("PV_IMP_EXENTO"));
           listaMongo.add(""+obj.get("HED_TIPO"));
           listaMongo.add(""+obj.get("HED_CLAVE"));
           listaMongo.add(""+obj.get("HED_CONCEPTO"));
           listaMongo.add(""+obj.get("HED_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("HED_IMP_EXENTO"));
           listaMongo.add(""+obj.get("HET_TIPO"));
           listaMongo.add(""+obj.get("HET_CLAVE"));
           listaMongo.add(""+obj.get("HET_CONCEPTO"));
           listaMongo.add(""+obj.get("HET_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("HET_IMP_EXENTO"));
           listaMongo.add(""+obj.get("DF_TIPO"));
           listaMongo.add(""+obj.get("DF_CLAVE"));
           listaMongo.add(""+obj.get("DF_CONCEPTO"));
           listaMongo.add(""+obj.get("DF_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("DF_IMP_EXENTO"));
           listaMongo.add(""+obj.get("PD_TIPO"));
           listaMongo.add(""+obj.get("PD_CLAVE"));
           listaMongo.add(""+obj.get("PD_CONCEPTO"));
           listaMongo.add(""+obj.get("PD_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("PD_IMP_EXENTO"));
           listaMongo.add(""+obj.get("A_TIPO"));
           listaMongo.add(""+obj.get("A_CLAVE"));
           listaMongo.add(""+obj.get("A_CONCEPTO"));
           listaMongo.add(""+obj.get("A_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("A_IMP_EXENTO"));
           listaMongo.add(""+obj.get("CG_TIPO"));
           listaMongo.add(""+obj.get("CG_CLAVE"));
           listaMongo.add(""+obj.get("CG_CONCEPTO"));
           listaMongo.add(""+obj.get("CG_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("CG_IMP_EXENTO"));
           listaMongo.add(""+obj.get("C_TIPO"));
           listaMongo.add(""+obj.get("C_CLAVE"));
           listaMongo.add(""+obj.get("C_CONCEPTO"));
           listaMongo.add(""+obj.get("C_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("C_IMP_EXENTO"));
           listaMongo.add(""+obj.get("B_TIPO"));
           listaMongo.add(""+obj.get("B_CLAVE"));
           listaMongo.add(""+obj.get("B_CONCEPTO"));
           listaMongo.add(""+obj.get("B_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("B_IMP_EXENTO"));
           listaMongo.add(""+obj.get("AA_TIPO"));
           listaMongo.add(""+obj.get("AA_CLAVE"));
           listaMongo.add(""+obj.get("AA_CONCEPTO"));
           listaMongo.add(""+obj.get("AA_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("AA_IMP_EXENTO"));
           listaMongo.add(""+obj.get("FA_TIPO"));
           listaMongo.add(""+obj.get("FA_CLAVE"));
           listaMongo.add(""+obj.get("FA_CONCEPTO"));
           listaMongo.add(""+obj.get("FA_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("FA_IMP_EXENTO"));
           listaMongo.add(""+obj.get("OA1_TIPO"));
           listaMongo.add(""+obj.get("OA1_CLAVE"));
           listaMongo.add(""+obj.get("OA1_CONCEPTO"));
           listaMongo.add(""+obj.get("OA1_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("OA1_IMP_EXENTO"));
           listaMongo.add(""+obj.get("OA2_TIPO"));
           listaMongo.add(""+obj.get("OA2_CLAVE"));
           listaMongo.add(""+obj.get("OA2_CONCEPTO"));
           listaMongo.add(""+obj.get("OA2_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("OA2_IMP_EXENTO"));
           listaMongo.add(""+obj.get("OA3_TIPO"));
           listaMongo.add(""+obj.get("OA3_CLAVE"));
           listaMongo.add(""+obj.get("OA3_CONCEPTO"));
           listaMongo.add(""+obj.get("OA3_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("OA3_IMP_EXENTO"));
           listaMongo.add(""+obj.get("OA4_TIPO"));
           listaMongo.add(""+obj.get("OA4_CLAVE"));
           listaMongo.add(""+obj.get("OA4_CONCEPTO"));
           listaMongo.add(""+obj.get("OA4_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("OA4_IMP_EXENTO"));
           listaMongo.add(""+obj.get("O_TIPO"));
           listaMongo.add(""+obj.get("O_CLAVE"));
           listaMongo.add(""+obj.get("O_CONCEPTO"));
           listaMongo.add(""+obj.get("O_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("O_IMP_EXENTO"));
           listaMongo.add(""+obj.get("PA_TIPO"));
           listaMongo.add(""+obj.get("PA_CLAVE"));
           listaMongo.add(""+obj.get("PA_CONCEPTO"));
           listaMongo.add(""+obj.get("PA_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("PA_IMP_EXENTO"));
           listaMongo.add(""+obj.get("SVRT_TIPO"));
           listaMongo.add(""+obj.get("SVRT_CLAVE"));
           listaMongo.add(""+obj.get("SVRT_CONCEPTO"));
           listaMongo.add(""+obj.get("SVRT_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("SVRT_IMP_EXENTO"));
           listaMongo.add(""+obj.get("TOT_ANT_REMANENTES"));
           listaMongo.add(""+obj.get("TOT_SALARIOS"));
           listaMongo.add(""+obj.get("PROV_AGUINALDO"));
           listaMongo.add(""+obj.get("PROV_VACACIONES"));
           listaMongo.add(""+obj.get("PROV_PRIMA_VAC"));
           listaMongo.add(""+obj.get("SIND_TIPO"));
           listaMongo.add(""+obj.get("SIND_CLAVE"));
           listaMongo.add(""+obj.get("SIND_CONCEPTO"));
           listaMongo.add(""+obj.get("SIND_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("SIND_IMP_EXENTO"));
           listaMongo.add(""+obj.get("FPS_TIPO"));
           listaMongo.add(""+obj.get("FPS_CLAVE"));
           listaMongo.add(""+obj.get("FPS_CONCEPTO"));
           listaMongo.add(""+obj.get("FPS_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("FPS_IMP_EXENTO"));
           listaMongo.add(""+obj.get("FPSUP_TIPO"));
           listaMongo.add(""+obj.get("FPSUP_CLAVE"));
           listaMongo.add(""+obj.get("FPSUP_CONCEPTO"));
           listaMongo.add(""+obj.get("FPSUP_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("FPSUP_IMP_EXENTO"));
           listaMongo.add(""+obj.get("AAD_TIPO"));
           listaMongo.add(""+obj.get("AAD_CLAVE"));
           listaMongo.add(""+obj.get("AAD_CONCEPTO"));
           listaMongo.add(""+obj.get("AAD_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("AAD_IMP_EXENTO"));
           listaMongo.add(""+obj.get("AAC_TIPO"));
           listaMongo.add(""+obj.get("AAC_CLAVE"));
           listaMongo.add(""+obj.get("AAC_CONCEPTO"));
           listaMongo.add(""+obj.get("AAC_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("AAC_IMP_EXENTO"));
           listaMongo.add(""+obj.get("AFO_TIPO"));
           listaMongo.add(""+obj.get("AFO_CLAVE"));
           listaMongo.add(""+obj.get("AFO_CONCEPTO"));
           listaMongo.add(""+obj.get("AFO_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("AFO_IMP_EXENTO"));
           listaMongo.add(""+obj.get("PROV_AGUI_SINDIC"));
           listaMongo.add(""+obj.get("PROV_PRIM_VAC_SINDIC"));
           listaMongo.add(""+obj.get("PROV_AGUI_FON_PEN_SUP"));
           listaMongo.add(""+obj.get("PROV_PRIM_VAC_FON_PEN_SUP"));
           listaMongo.add(""+obj.get("PROV_AGUI_FON_PEN_SUB"));
           listaMongo.add(""+obj.get("PROV_PRIM_VAC_FON_PEN_SUB"));
           listaMongo.add(""+obj.get("PROV_AGUI_AYUDAS"));
           listaMongo.add(""+obj.get("PROV_PRIM_VAC_AYUDAS"));
           listaMongo.add(""+obj.get("INC_TIPO"));
           listaMongo.add(""+obj.get("INC_CLAVE"));
           listaMongo.add(""+obj.get("INC_CONCEPTO"));
           listaMongo.add(""+obj.get("INC_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("INC_IMP_EXENTO"));
           listaMongo.add(""+obj.get("AUS_TIPO"));
           listaMongo.add(""+obj.get("AUS_CLAVE"));
           listaMongo.add(""+obj.get("AUS_CONCEPTO"));
           listaMongo.add(""+obj.get("AUS_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("AUS_IMP_EXENTO"));
           listaMongo.add(""+obj.get("PEAL_TIPO"));
           listaMongo.add(""+obj.get("PEAL_CLAVE"));
           listaMongo.add(""+obj.get("PEAL_CONCEPTO"));
           listaMongo.add(""+obj.get("PEAL_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("PEAL_IMP_EXENTO"));
           listaMongo.add(""+obj.get("AVA_TIPO"));
           listaMongo.add(""+obj.get("AVA_CLAVE"));
           listaMongo.add(""+obj.get("AVA_CONCEPTO"));
           listaMongo.add(""+obj.get("AVA_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("AVA_IMP_EXENTO"));
           listaMongo.add(""+obj.get("PAFPS_TIPO"));
           listaMongo.add(""+obj.get("PAFPS_CLAVE"));
           listaMongo.add(""+obj.get("PAFPS_CONCEPTO"));
           listaMongo.add(""+obj.get("PAFPS_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("PAFPS_IMP_EXENTO"));
           listaMongo.add(""+obj.get("PAFPSUB_TIPO"));
           listaMongo.add(""+obj.get("PAFPSUB_CLAVE"));
           listaMongo.add(""+obj.get("PAFPSUB_CONCEPTO"));
           listaMongo.add(""+obj.get("PAFPSUB_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("PAFPSUB_IMP_EXENTO"));
           listaMongo.add(""+obj.get("PAA_TIPO"));
           listaMongo.add(""+obj.get("PAA_CLAVE"));
           listaMongo.add(""+obj.get("PAA_CONCEPTO"));
           listaMongo.add(""+obj.get("PAA_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("PAA_IMP_EXENTO"));
           listaMongo.add(""+obj.get("OD1_TIPO"));
           listaMongo.add(""+obj.get("OD1_CLAVE"));
           listaMongo.add(""+obj.get("OD1_CONCEPTO"));
           listaMongo.add(""+obj.get("OD1_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("OD1_IMP_EXENTO"));
           listaMongo.add(""+obj.get("FONA_TIPO"));
           listaMongo.add(""+obj.get("FONA_CLAVE"));
           listaMongo.add(""+obj.get("FONA_CONCEPTO"));
           listaMongo.add(""+obj.get("FONA_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("FONA_IMP_EXENTO"));
           listaMongo.add(""+obj.get("OD2_TIPO"));
           listaMongo.add(""+obj.get("OD2_CLAVE"));
           listaMongo.add(""+obj.get("OD2_CONCEPTO"));
           listaMongo.add(""+obj.get("OD2_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("OD2_IMP_EXENTO"));
           listaMongo.add(""+obj.get("DESF_TIPO"));
           listaMongo.add(""+obj.get("DESF_CLAVE"));
           listaMongo.add(""+obj.get("DESF_CONCEPTO"));
           listaMongo.add(""+obj.get("DESF_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("DESF_IMP_EXENTO"));
           listaMongo.add(""+obj.get("INTERESES_PRESTAMO"));
           listaMongo.add(""+obj.get("DED_PREST_FON_AHORRO"));
           listaMongo.add(""+obj.get("RIMO_TIPO"));
           listaMongo.add(""+obj.get("RIMO_CLAVE"));
           listaMongo.add(""+obj.get("RIMO_CONCEPTO"));
           listaMongo.add(""+obj.get("RIMO_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("RIMO_IMP_EXENTO"));
           listaMongo.add(""+obj.get("RET_IMSS_MES_PATR"));
           listaMongo.add(""+obj.get("RIBO_TIPO"));
           listaMongo.add(""+obj.get("RIBO_CLAVE"));
           listaMongo.add(""+obj.get("RIBO_CONCEPTO"));
           listaMongo.add(""+obj.get("RIBO_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("RIBO_IMP_EXENTO"));
           listaMongo.add(""+obj.get("RET_IMSS_BIM_PATR"));
           listaMongo.add(""+obj.get("RI_TIPO	RI_CLAVE"));
           listaMongo.add(""+obj.get("RI_CONCEPTO"));
           listaMongo.add(""+obj.get("RI_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("RI_IMP_EXENTO"));
           listaMongo.add(""+obj.get("RET_INFONAVIT_SALALARIOS"));
           listaMongo.add(""+obj.get("RET_INFONAVIT_SINDICATOS"));
           listaMongo.add(""+obj.get("RET_INFONAVIT_FON_PEN_SUP"));
           listaMongo.add(""+obj.get("RET_INFONAVIT_FON_PEN_SUB"));
           listaMongo.add(""+obj.get("RET_INFONAVIT_AYUDAS"));
           listaMongo.add(""+obj.get("INFONAVIT_PATRONAL"));
           listaMongo.add(""+obj.get("RISR_TIPO"));
           listaMongo.add(""+obj.get("RISR_CLAVE"));
           listaMongo.add(""+obj.get("RISR_CONCEPTO"));
           listaMongo.add(""+obj.get("RISR_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("RISR_IMP_EXENTO"));
           listaMongo.add(""+obj.get("ISR_TIPO"));
           listaMongo.add(""+obj.get("ISR_IMPORTE"));
           listaMongo.add(""+obj.get("PSE_TIPO"));
           listaMongo.add(""+obj.get("PSE_CLAVE"));
           listaMongo.add(""+obj.get("PSE_CONCEPTO"));
           listaMongo.add(""+obj.get("PSE_IMP_GRAVADO"));
           listaMongo.add(""+obj.get("PSE_IMP_EXENTO"));
           listaMongo.add(""+obj.get("IMPUESTO_SOBRE_NOMINAS"));
           listaMongo.add(""+obj.get("PERC_PER_TOT_GRAV"));
           listaMongo.add(""+obj.get("PERC_PER_TOT_EXENTO"));
           listaMongo.add(""+obj.get("DEDU_DED_TOT_GRAV"));
           listaMongo.add(""+obj.get("DEDU_DED_TOT_EXENTO"));
           listaMongo.add(""+obj.get("CANTIDAD"));
           listaMongo.add(""+obj.get("UNIDAD"));
           listaMongo.add(""+obj.get("PRECIO"));
           listaMongo.add(""+obj.get("IMPORTE"));
           listaMongo.add(""+obj.get("SUBTOTAL"));
           listaMongo.add(""+obj.get("DESCRIPCION"));
           listaMongo.add(""+obj.get("DESCUENTO"));
           listaMongo.add(""+obj.get("MOTIVO_DESCUENTO"));
           listaMongo.add(""+obj.get("TOTAL"));
           listaMongo.add(""+obj.get("ANTICIPO_REMANENTES1"));
           listaMongo.add(""+obj.get("TOTAL_ANTIC_REMANENTES"));
           listaMongo.add(""+obj.get("EXENTO_FONDO_AHORRO"));
           listaMongo.add(""+obj.get("EXENTO_HORAS_EXTRA"));
           listaMongo.add(""+obj.get("EXENTO_PRIMA_DOMINICAL"));
           listaMongo.add(""+obj.get("EXENTO_PRIMA_VACACIONAL"));
           listaMongo.add(""+obj.get("EXENTO_SEPARACION_VOLUNTARIA"));
           listaMongo.add(""+obj.get("EXENTO_AGUINALDO"));
           listaMongo.add(""+obj.get("GRAVADO"));
           listaMongo.add(""+obj.get("SUBSIDIO_EMPLEO_APLICADO"));
           listaMongo.add(""+obj.get("SUELDO_NETO"));
           listaMongo.add(""+obj.get("SALARIO_BRUTO"));
           listaMongo.add(""+obj.get("COSTO_SOCIAL"));
           listaMongo.add(""+obj.get("COMISION"));
           listaMongo.add(""+obj.get("COSTO_TOT_ANTES_IVA"));
           listaMongo.add(""+obj.get("TOTAL_FACTURA_CLIENTE"));
           listaMongo.add(""+obj.get("TOTAL_FACTURA_PATRONA"));
           listaMongo.add(""+obj.get("COSTO_UNITARIO_EMPLEADO"));
           listaMongo.add(""+obj.get("RAZON_SOCIAL_CLIENTE"));
           listaMongo.add(""+obj.get("RFC_CLIENTE"));
           listaMongo.add(""+obj.get("NOMBRE_CORTO_CLIENTE"));
           listaMongo.add(""+obj.get("PERIODICIDAD"));
           listaMongo.add(""+obj.get("FECHA_DE_PAGO"));
           listaMongo.add(""+obj.get("FECHA_INICIAL_PAGO"));
           listaMongo.add(""+obj.get("FECHA_FINAL_PAGO"));
           listaMongo.add(""+obj.get("PERIODO_DE_PAGO"));
           listaMongo.add(""+obj.get("METODO_DE_PAGO"));
           listaMongo.add(""+obj.get("CUENTA_BANCARIA"));
           listaMongo.add(""+obj.get("CLABE"));
           listaMongo.add(""+obj.get("BANCO"));
           listaMongo.add(""+obj.get("LUGAR_DE_EXPEDICION"));
           listaMongo.add(""+obj.get("PAIS1"));
           listaMongo.add(""+obj.get("EMAIL1"));
           listaMongo.add(""+obj.get("EMAIL2"));
           listaMongo.add(""+obj.get("EMAIL3"));
           listaMongo.add(""+obj.get("OBSERVACIONES_PENS_ALIMENTACIA"));
           listaMongo.add(""+obj.get("OBSERVACIONES_EJECUTIVO"));
           listaMongo.add(""+obj.get("TIENE_OTRO_PATRON"));
           listaMongo.add(""+obj.get("NOMBRE_OTRO_PATRON"));
           listaMongo.add(""+obj.get("RFC_OTRO_PATRON"));
           listaMongo.add(""+obj.get("EXTR_TIPO_DOCUMENTO"));
           listaMongo.add(""+obj.get("EXTR_FECHA_VENCIMIENTO"));
           listaMongo.add(""+obj.get("SALARIO_DIARIO"));
           listaMongo.add(""+obj.get("FACTOR_INTEGRACION_PATRON"));
           listaMongo.add(""+obj.get("SBC"));
           listaMongo.add(""+obj.get("TOPE_25_VSMA"));
           listaMongo.add(""+obj.get("TOPE_3_SALARIOS_MINIMOS"));
           listaMongo.add(""+obj.get("DIAS_COMP"));
           listaMongo.add(""+obj.get("DIAS_INC"));
           listaMongo.add(""+obj.get("DIAS_TIPO_INC"));
           listaMongo.add(""+obj.get("DIAS_D_COTIZAR"));
           listaMongo.add(""+obj.get("ENFMAT_FIJA_PATRON"));
           listaMongo.add(""+obj.get("ENFMAT_FIJA_OBRERO"));
           listaMongo.add(""+obj.get("ENFMAT_EXCEDENTE_PATRON"));
           listaMongo.add(""+obj.get("ENFMAT_EXCEDENTE_OBRERO"));
           listaMongo.add(""+obj.get("ENFMAT_PD_PATRON"));
           listaMongo.add(""+obj.get("ENFMAT_PD_OBRERO"));
           listaMongo.add(""+obj.get("ENFMAT_GMP_PATRON"));
           listaMongo.add(""+obj.get("ENFMAT_GMP_OBRERO"));
           listaMongo.add(""+obj.get("RITRAB_PATRON"));
           listaMongo.add(""+obj.get("RITRAB_OBRERO"));
           listaMongo.add(""+obj.get("INVIDA_PATRON"));
           listaMongo.add(""+obj.get("INVIDA_OBRERO"));
           listaMongo.add(""+obj.get("GUPRESTSOC_PATRON"));
           listaMongo.add(""+obj.get("GUPRESTSOC_OBRERO"));
           listaMongo.add(""+obj.get("TOTCOPMEN_PATRON"));
           listaMongo.add(""+obj.get("TOTCOPMEN_OBRERO"));
           listaMongo.add(""+obj.get("RETIRO_PATRON"));
           listaMongo.add(""+obj.get("RETIRO_OBRERO"));
           listaMongo.add(""+obj.get("CESAVE_PATRON"));
           listaMongo.add(""+obj.get("CESAVE_OBRERO"));
           listaMongo.add(""+obj.get("TOCOIMRE_PATRON"));
           listaMongo.add(""+obj.get("TOCOIMRE_OBRERO"));
           listaMongo.add(""+obj.get("TOIMSS_IMSS_PATR_TOT"));
           listaMongo.add(""+obj.get("TOIMSS_IMSS_OBR_TOT"));
           listaMongo.add(""+obj.get("TOIMSS_TOTAL"));
           listaMongo.add(""+obj.get("TOTINFO_PATRON"));
           listaMongo.add(""+obj.get("TOTINFO_OBRERO"));
           listaMongo.add(""+obj.get("SEGDES_PATRON"));
           listaMongo.add(""+obj.get("SEGDES_OBRERO"));
           listaMongo.add(""+obj.get("TART113_LI"));
           listaMongo.add(""+obj.get("TART113_EXCEDENTE"));
           listaMongo.add(""+obj.get("TART113_SOBRE_EXEC"));
           listaMongo.add(""+obj.get("TART113_IMPTE_EXCE"));
           listaMongo.add(""+obj.get("TART113_CUOTA_FIJA"));
           listaMongo.add(""+obj.get("TART113_IMP_TARIFA"));
           listaMongo.add(""+obj.get("ISR_RETENER_SDIAS_LAB"));
           listaMongo.add(""+obj.get("SUBSIDIO_EMPLEO_APLICADO1"));
           listaMongo.add(""+obj.get("RETENCION_ISR"));
           listaMongo.add(""+obj.get("SUBSIDIO_ENTREGAR"));
           listaMongo.add(""+obj.get("IMPUESTO_SOBRE_NOMINAS1"));
           listaMongo.add(""+obj.get("AGRUP_NOMINA_LARGO"));
           listaMongo.add(""+obj.get("AGRUP_NOMINA_TABLERO_CONTROL"));
           listaMongo.add(""+obj.get("AGRUP_NOMINA_CORTO_REPATR"));
           listaMongo.add(""+obj.get("AGRUP_NOMINA_CORTO_RESIND"));
           /*listaMongo.add(""+obj.get("# Control"));
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
           listaMongo.add(""+obj.get("Salario Diario"));*/           
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
