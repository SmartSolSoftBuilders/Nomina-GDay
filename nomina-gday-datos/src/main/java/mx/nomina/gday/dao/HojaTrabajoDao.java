package mx.nomina.gday.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import mx.nomina.gday.modelo.Archivo;
import mx.nomina.gday.modelo.HojaTrabajo;

public interface HojaTrabajoDao {

	HojaTrabajo SeleccionarEmpresaNomina();
	HojaTrabajo AsignarHojaDeTrabajoaNomina();
	HojaTrabajo GenerarHojaDeTrabajo();
	List<HojaTrabajo> obtenerHojasByIdNomina(Integer idNomina);
	List<HojaTrabajo> obtenerHojas();
	int activarHojaTrabajo(HojaTrabajo hojaTrabajo);
	int eliminarHojaTrabajo(HojaTrabajo hojaTrabajo);
	public void agregarArchivo(HojaTrabajo hojaTrabajo);
	HojaTrabajo obtenerHojaById(Integer idHojaTrabajo);
	void agregarArchivoAll(HojaTrabajo hojaTrabajo);
	List<HojaTrabajo> obtenerHojasByIdUser(@Param("id")Integer idUsr);

}