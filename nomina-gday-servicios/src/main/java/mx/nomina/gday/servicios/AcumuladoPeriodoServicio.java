package mx.nomina.gday.servicios;

import java.io.File;
import java.util.List;

import mx.nomina.gday.modelo.AcumuladoPeriodo;

public interface AcumuladoPeriodoServicio {

	public void agregarArchivo(AcumuladoPeriodo acumuladoPeriodo);
	public List obtenerDatosCombo();
	List<AcumuladoPeriodo> obtenerAcumuladosByIdNominaAndIdPeriodo(AcumuladoPeriodo acumuladoPeriodo);
	public File obtenerArchivoAcumulado(Integer idAcumulado);
	public boolean validarArchivo(AcumuladoPeriodo acumuladoPeriodo);


}
