package mx.nomina.gday.servicios;

import java.io.File;
import java.util.List;

import mx.nomina.gday.modelo.Archivo;
import mx.nomina.gday.modelo.HojaTrabajo;

public interface HojaTrabajoServicio {

	public List<HojaTrabajo> obtenerHojasByIdNomina(Integer idNomina);
	public List<HojaTrabajo> obtenerHojas();
	int activarHojaTrabajo(HojaTrabajo hojaTrabajo);
	int eliminarHojaTrabajo(HojaTrabajo hojaTrabajo);
	public void agregarArchivo(HojaTrabajo hojaTrabajo);
	public File generarHojaTrabajo(Integer idHojaTrabajo);
	public String generarHojaTrabajoExt(Integer idHojaTrabajo);
}
