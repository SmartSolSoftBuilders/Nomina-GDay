package mx.nomina.gday.servicios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

}
