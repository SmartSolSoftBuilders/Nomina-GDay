package mx.nomina.gday.servicios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nomina.gday.dao.EmpleadoDao;
import mx.nomina.gday.dao.EmpleadoNominaDao;
import mx.nomina.gday.dao.GrupoDao;
import mx.nomina.gday.dao.NominaDao;
import mx.nomina.gday.modelo.Empleado;
import mx.nomina.gday.modelo.EmpleadoNomina;
import mx.nomina.gday.modelo.Grupo;
import mx.nomina.gday.modelo.Nomina;
import mx.nomina.gday.modelo.RazonSocial;
@Service
public class ReportesServicioImpl implements ReportesServicio {
	
	@Autowired
	private EmpleadoDao empleadoDao;
	@Autowired
	private EmpleadoNominaDao empleadoNominaDao;
	@Autowired
	private NominaDao nominaDao;

	private List<String> encabezados;
	private List<String> contenidoCeldas;
	
	 
	@Override
	public File generarLayoutNominaEmpleados(Integer idNomina, String fechaInicio, String fechaFin) {
		/*La ruta donde se creará el archivo*/
        //String rutaArchivo = System.getProperty("user.home")+"/ejemploExcelJava.xls";
	    Nomina nomina = this.nominaDao.obtenerNominaById(idNomina);

		String rutaArchivo = "c://archivosNGDAY//layoutNominaEmpleado.xls";
        /*Se crea el objeto de tipo File con la ruta del archivo*/
		File archivoXLS = new File(rutaArchivo); 
		//Evento eventoTmp=new Evento();
		System.out.println("Los datos que se buscan:"+nomina.getIdNomina());
		/*Se crea el archivo*/
        int filaInicial=8;
        int columnaInicial=1;
        int totalDatos=67;
        try{
        	FileInputStream file = new FileInputStream(archivoXLS);
        	HSSFWorkbook workbook = new HSSFWorkbook(file);
        	HSSFSheet hoja = workbook.getSheetAt(0);
        	List <Empleado> empleados = this.empleadoDao.obtenerEmpleadosByIdNomina(nomina.getIdNomina());
        	//Se llena el encabezado
        	Row fila = hoja.getRow(1);	
        	fila.createCell(3).setCellValue(empleados.size());
        	fila = hoja.getRow(2);	
        	fila.createCell(3).setCellValue(nomina.getIdNomina());
        	fila = hoja.getRow(3);	
        	fila.createCell(3).setCellValue(nomina.getNombreCorto());
        	fila = hoja.getRow(4);	
        	//Nombre esquema
        	fila.createCell(5).setCellValue(nomina.getPatrona().getNombreCortoPatrona());
        	fila = hoja.getRow(2);	
        	fila.createCell(5).setCellValue(nomina.getIntermediaria().getNombreIntermediaria());
        	fila = hoja.getRow(3);	
        	fila.createCell(5).setCellValue(nomina.getPeriodicidad());
        	fila = hoja.getRow(4);	
        	fila.createCell(5).setCellValue(nomina.getTipoPago());
        	//Se guardarán todos los empleados
        	for (int j=filaInicial,indexEmpleados=0; j<(empleados.size()+filaInicial); j++,indexEmpleados++){
        		fila=hoja.getRow(j);
        		for (int k=columnaInicial,recorrerCeldas=0;k<totalDatos; k++){
        			recorrerCeldas=0;
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getIdEmpleado());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getNoControl());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getNss());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getCurp());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getApellidoPaterno());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getApellidoMaterno());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getNombre());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getRfc());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getFechaNacimiento());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getEdad());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getSexo());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getPaisOrigen());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getNacionalidad());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getEstadoCivil());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getCorreoElectronico());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getFechaIngresoReal());
        			fila.createCell(recorrerCeldas++).setCellValue("NO");
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getCalle());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getNumExterior());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getNumInterior());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getColonia());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getCodigoPostal());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getMunicipioDel());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getEntFederativa());
        			fila.createCell(recorrerCeldas++).setCellValue("SI");//IFE
        			fila.createCell(recorrerCeldas++).setCellValue("SI");//ACTA
        			fila.createCell(recorrerCeldas++).setCellValue("SI");//CURP
        			fila.createCell(recorrerCeldas++).setCellValue("SI");//RFC
        			fila.createCell(recorrerCeldas++).setCellValue("SI");//COMPROBANTE        	
        			fila.createCell(recorrerCeldas++).setCellValue("SI");//COMP EST
        			fila.createCell(recorrerCeldas++).setCellValue("SI");//CORREO
        			fila.createCell(recorrerCeldas++).setCellValue("SI");//PREAFIL
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getCuenta());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getBanco());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getTipoPago());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getNoCredInfonavit());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getDescInfonavitVsmg());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getDesInfonavitPorc());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getDescInfonavitImp());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getDescFonacotPago());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getDescFonacotNum());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getPensionAlimImp());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getPensionAlimPorc());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getPensionAlimAcred());
        			fila.createCell(recorrerCeldas++).setCellValue(empleados.get(indexEmpleados).getPensionAlimObs()); 
        			//NOMINA-EMPLEADO
        			EmpleadoNomina empleadoNomina = new EmpleadoNomina();
        			empleadoNomina.setNomina(nomina);
        			empleadoNomina.setEmpleado(empleados.get(indexEmpleados));
        			empleadoNomina=this.empleadoNominaDao.obtenerEmpleadoNominaByIdNominaEmpleado(empleadoNomina);
        			fila.createCell(recorrerCeldas++).setCellValue(empleadoNomina.getFechaIngreso());
        			fila.createCell(recorrerCeldas++).setCellValue(empleadoNomina.getEstatus());
        			fila.createCell(recorrerCeldas++).setCellValue(empleadoNomina.getTipoSalario());
        			fila.createCell(recorrerCeldas++).setCellValue(empleadoNomina.getFechaBaja());
        			fila.createCell(recorrerCeldas++).setCellValue(empleadoNomina.getLoteMovImssAlta());
        			fila.createCell(recorrerCeldas++).setCellValue(empleadoNomina.getFechaVencimiento());
        			fila.createCell(recorrerCeldas++).setCellValue(empleadoNomina.getSueldoMensual());
        			fila.createCell(recorrerCeldas++).setCellValue(empleadoNomina.getSalarioDiarioInt());
        			fila.createCell(recorrerCeldas++).setCellValue(empleadoNomina.getPlazaTrabajo());
        			fila.createCell(recorrerCeldas++).setCellValue(empleadoNomina.getNumeroTrabajadorCliente());
        			fila.createCell(recorrerCeldas++).setCellValue("SI");//OTRO PATRON
        			fila.createCell(recorrerCeldas++).setCellValue(empleadoNomina.getRfcOtroPatron());
        			fila.createCell(recorrerCeldas++).setCellValue(empleadoNomina.getNombreOtroPatron());
        			fila.createCell(recorrerCeldas++).setCellValue("PENDIENTE"); //Permanencia
        			fila.createCell(recorrerCeldas++).setCellValue("PENDIENTE");//Calle
        			fila.createCell(recorrerCeldas++).setCellValue(empleadoNomina.getCodigoPostal());
        			fila.createCell(recorrerCeldas++).setCellValue(empleadoNomina.getMunicipioDel());
        			fila.createCell(recorrerCeldas++).setCellValue(empleadoNomina.getEntFederativa());
        			fila.createCell(recorrerCeldas++).setCellValue(empleadoNomina.getLoteMovImssBaja());
        			fila.createCell(recorrerCeldas++).setCellValue("SI"); //Aplica finiquito
        			fila.createCell(recorrerCeldas++).setCellValue(empleadoNomina.getMontoFiniquito());        			
        		}	
        	}  	 	
            file.close();
            FileOutputStream outFile =new FileOutputStream(new File("C:\\tmp2\\update.xls"));
            workbook.write(outFile);
            outFile.close();
            archivoXLS = new File("C:\\tmp2\\update.xls"); 	
         	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("<OTIKA>ERROR!"+e.getMessage());
			e.printStackTrace();
		}
        /*Cerramos el flujo de datos*/        
        return archivoXLS;
	}
	
}