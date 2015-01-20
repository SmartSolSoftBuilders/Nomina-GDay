package mx.nomina.gday.servicios;

import java.util.List;

import mx.nomina.gday.modelo.Nomina;
import mx.nomina.gday.modelo.RazonSocial;

public interface NominaServicio {

	public boolean agregarNomina(Nomina nomina);
	void actualizarNomina(Nomina nomina);
	public Nomina obtenerNominaById(int idNomina);
	public List<Nomina> obtenerNominas();
	public List obtenerDatosCombo();
	public List<RazonSocial> obtenerRazonesSocialesByIdNomina(Integer idNomina);

}
