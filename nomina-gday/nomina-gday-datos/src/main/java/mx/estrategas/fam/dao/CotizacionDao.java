package mx.estrategas.fam.dao;

import java.util.List;

import mx.estrategas.fam.modelo.Cotizacion;

public interface CotizacionDao {
	
	public Integer guardarCotizacion(Cotizacion cotizacion);
	List<Cotizacion> obtenerCotizaciones(Cotizacion cotizacion);
	List<Cotizacion> obtenerCotizacionesPendientes();
	public Cotizacion obtenerCotizacionById(int idCotizacion);
	public int establecerEstatusCotizacion(Cotizacion cotizacion);

}
