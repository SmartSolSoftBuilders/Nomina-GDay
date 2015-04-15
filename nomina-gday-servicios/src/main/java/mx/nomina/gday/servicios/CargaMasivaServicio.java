package mx.nomina.gday.servicios;

public interface CargaMasivaServicio {
	
	 //public String cargarExcel(String nombreArchivo);
	 int getCountIdEmpleadoByNss(String nssEmpleado);
	 public String cargarExcel(String nombreArchivo, String tipoArchivo);

}
