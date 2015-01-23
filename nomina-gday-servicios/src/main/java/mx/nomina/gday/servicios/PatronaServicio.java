package mx.nomina.gday.servicios;

import java.util.List;

import mx.nomina.gday.modelo.Patrona;

public interface PatronaServicio {

	void actualizarPatrona(Patrona patrona);
	public boolean agregarPatrona(Patrona patrona);
	public List obtenerDatosCombo();
	public List<Patrona> obtenerPatronas();
	public Patrona obtenerPatronaById(int idPatrona);
	List<Patrona> obtenerPatronasIntermediarias();

}
