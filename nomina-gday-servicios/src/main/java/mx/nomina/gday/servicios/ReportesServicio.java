package mx.nomina.gday.servicios;

import java.io.File;
import java.util.List;

import mx.nomina.gday.modelo.Grupo;
import mx.nomina.gday.modelo.Nomina;

public interface ReportesServicio {
	File generarLayoutNominaEmpleados(Integer idNomina, String fechaInicio, String fechaFin);
	File generarLayoutEmpleados(Integer idNomina, String fechaInicio,String fechaFin);
			
}