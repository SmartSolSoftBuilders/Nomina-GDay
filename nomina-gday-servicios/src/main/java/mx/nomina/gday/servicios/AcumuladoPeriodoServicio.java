package mx.nomina.gday.servicios;

import java.io.File;
import java.util.List;

import mx.nomina.gday.modelo.AcumuladoPeriodo;

public interface AcumuladoPeriodoServicio {
	
	public void eliminarAcumulado(AcumuladoPeriodo acumuladoPeriodo);
	public int agregarArchivo(AcumuladoPeriodo acumuladoPeriodo);
	public List obtenerDatosCombo();
	List<AcumuladoPeriodo> obtenerAcumuladosByIdNominaAndIdPeriodo(AcumuladoPeriodo acumuladoPeriodo);
	public File obtenerArchivoAcumulado(Integer idAcumulado);
	public boolean validarArchivo(AcumuladoPeriodo acumuladoPeriodo);
	public File obtenerArchivoAcumuladoByData(List tmp2);
	public String obtenerArchivoAcumuladoExt(Integer idAcumulado);

 
}
