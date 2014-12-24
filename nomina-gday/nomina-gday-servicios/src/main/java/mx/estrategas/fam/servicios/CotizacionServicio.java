package mx.estrategas.fam.servicios;

import java.util.List;

import mx.estrategas.fam.modelo.Cotizacion;

public interface CotizacionServicio {
	
	public Cotizacion obtenerPagoCotizacion(Cotizacion cotizacion);
	public Cotizacion guardarCotizacion(Cotizacion cotizacion);
	List<Cotizacion> obtenerCotizaciones(Cotizacion cotizacion);
	public List<Cotizacion> obtenerCotizacionesPendientes();
	public Cotizacion obtenerCotizacionById(int idCotizacion);
	public boolean establecerEstatusCotizacion(Cotizacion cotizacion);

}
