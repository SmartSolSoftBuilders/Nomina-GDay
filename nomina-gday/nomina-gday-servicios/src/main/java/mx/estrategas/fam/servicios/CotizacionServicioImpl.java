package mx.estrategas.fam.servicios;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.estrategas.fam.dao.AfiliadoDao;
import mx.estrategas.fam.dao.CotizacionDao;
import mx.estrategas.fam.modelo.Cotizacion;
import mx.estrategas.fam.modelo.Pago;

@Service
public class CotizacionServicioImpl implements CotizacionServicio {

	@Autowired
	private CotizacionDao cotizacionDao;
	
	@Autowired
	private AfiliadoDao afiliadoDao;
	
	@Override
	public Cotizacion obtenerPagoCotizacion(Cotizacion cotizacion) {

		cotizacion.setPagos(generarTablaPagos(cotizacion));

		return cotizacion;
	}


	private List<Pago> generarTablaPagos(Cotizacion cotizacion) {
		 int NUMQUINCENASOL = 24;
		 Float interes= (float) (cotizacion.getCreditoSolicitado() * (0.276 / 360 * 15.2083));
		 Float capital=(float) 0;
		 Float pagos=(float) 0;
		 Float saldoInsoluto= (float) (cotizacion.getCreditoSolicitado() + interes);
		 int numeroRenglones=0;
		 double saldoAnterior= 0;
		 double interesAnterior = 0;		
		 double interesActual= 0;
		 
		 
		DecimalFormat formateador = new DecimalFormat("#.###");
		List<Pago> listaPagosTmp = new ArrayList<Pago>();
		numeroRenglones = cotizacion.getNumeroPagos()
				+ cotizacion.getQuincenasDeGracia()-(1);
try {
		for (int i = 0; i <= numeroRenglones; i++) {

			Pago pago = new Pago();

			System.out.println("No.Pago" + "" + "" + i);

			if (i==0) {
				
				 System.out.println("pagos" + "$" + "-");			
				 System.out.println("capital" + "$" + "-");
				 System.out.println("interes" + "" + formateador.format(interes));
				 System.out.println("saldoInsoluto"+ formateador.format(saldoInsoluto));
				
			}if (i>0 && i<cotizacion.getQuincenasDeGracia()) {
				
				 interesAnterior = listaPagosTmp.get(i - 1).getInteres();
				 saldoAnterior = listaPagosTmp.get(i - 1).getSaldoInsoluto();	
				 interes = (float) ((saldoAnterior) * (0.276 / 360 * 15.2083));
				 saldoInsoluto=(float) (saldoAnterior+interes);
				 
				 System.out.println("pagos" + "$" + "-");			
				 System.out.println("capital" + "$" + "-");
				 System.out.println("interes" + "" + formateador.format(interes));
				 System.out.println("saldoInsoluto"+ formateador.format(saldoInsoluto));
				
			} 
			if (i>0 && i>=cotizacion.getQuincenasDeGracia() && i <= NUMQUINCENASOL / 2 + cotizacion.getQuincenasDeGracia()-(1)) {
				
				 interesAnterior = listaPagosTmp.get(i - 1).getInteres();
				 saldoAnterior = listaPagosTmp.get(i - 1).getSaldoInsoluto();
				 interes= (float) ((saldoAnterior) * (0.276 / 360 * 15.2083));
				 pagos = cotizacion.getDescuentoMensual() + cotizacion.getDescuentoGestion();
				 capital = (float) (pagos - interes - cotizacion.getDescuentoGestion());
				 saldoInsoluto= (float) (saldoAnterior - capital);
				 
				
				 System.out.println("interes" + "" + formateador.format(interes));
				 System.out.println("saldoInsoluto"+ formateador.format(saldoInsoluto));
				 System.out.println("capital"+capital);
				 System.out.println("pago"+pagos);				
			}
			if (i>0 && i>cotizacion.getQuincenasDeGracia() && i > NUMQUINCENASOL / 2 + cotizacion.getQuincenasDeGracia()-(1) && cotizacion.getCreditoSolicitado() < 25000) {
				
				 interesAnterior = listaPagosTmp.get(i - 1).getInteres();
				 saldoAnterior = listaPagosTmp.get(i - 1).getSaldoInsoluto();
				 interes= (float) ((saldoAnterior) * (0.276 / 360 * 15.2083));
				 pagos = cotizacion.getDescuentoMensual();
				 capital = (float) (pagos - interes);
				 saldoInsoluto= (float) (saldoAnterior - capital);
				 
				
				 System.out.println("interes" + "" + formateador.format(interes));
				 System.out.println("saldoInsoluto"+ formateador.format(saldoInsoluto));
				 System.out.println("capital"+capital);
				 System.out.println("pago"+pagos);				
			}
			if (i>0 && i>=cotizacion.getQuincenasDeGracia() && i <= NUMQUINCENASOL+cotizacion.getQuincenasDeGracia()-(1) && cotizacion.getCreditoSolicitado() > 25000) {
				
				 interesAnterior = listaPagosTmp.get(i - 1).getInteres();
				 saldoAnterior = listaPagosTmp.get(i - 1).getSaldoInsoluto();
				 interes= (float) ((saldoAnterior) * (0.276 / 360 * 15.2083));
				 pagos = cotizacion.getDescuentoMensual() + cotizacion.getDescuentoGestion();
				 capital = (float) (pagos - interes - cotizacion.getDescuentoGestion());
				 saldoInsoluto= (float) (saldoAnterior - capital);
				 
				
				 System.out.println("interes" + "" + formateador.format(interes));
				 System.out.println("saldoInsoluto"+ formateador.format(saldoInsoluto));
				 System.out.println("capital"+capital);
				 System.out.println("pago"+pagos);				
			}
			if (i>0 && i>=cotizacion.getQuincenasDeGracia() && i > NUMQUINCENASOL+cotizacion.getQuincenasDeGracia()-(1) && cotizacion.getCreditoSolicitado() > 25000) {
				
				 interesAnterior = listaPagosTmp.get(i - 1).getInteres();
				 saldoAnterior = listaPagosTmp.get(i - 1).getSaldoInsoluto();
				 interes= (float) ((saldoAnterior) * (0.276 / 360 * 15.2083));
				 pagos = cotizacion.getDescuentoMensual();
				 capital = (float) (pagos - interes);
				 saldoInsoluto= (float) (saldoAnterior - capital);
				 
				
				 System.out.println("interes" + "" + formateador.format(interes));
				 System.out.println("saldoInsoluto"+ formateador.format(saldoInsoluto));
				 System.out.println("capital"+capital);
				 System.out.println("pago"+pagos);				
			}
			
						 
			pago.setCapital(capital);
			pago.setNumPago(numeroRenglones);
			pago.setPago(pagos);
			pago.setInteres(interes);
			pago.setSaldoInsoluto(saldoInsoluto);

			listaPagosTmp.add(pago);
			cotizacion.setPagos(listaPagosTmp);

		}
} catch (Exception e) {
System.out.println("Error"+e.getMessage());
}
		return listaPagosTmp;
	}

	@Override
	public Cotizacion guardarCotizacion(Cotizacion cotizacion) {

		System.out.println("Guardando cotizacion Service!"+cotizacion);
		try {
			
			Integer result= cotizacionDao.guardarCotizacion(cotizacion);
		} catch (Exception e) {
			System.out.println("---"+e.getMessage());
			e.printStackTrace();
		}
		return cotizacion;
	}

	@Override
	public List<Cotizacion> obtenerCotizaciones(Cotizacion cotizacion) {
		System.out.println("Service");
		return this.cotizacionDao.obtenerCotizaciones(cotizacion);
	}
	
	@Override
	public List<Cotizacion> obtenerCotizacionesPendientes() {
		// TODO Auto-generated method stub
		System.out.println("Service");
		return this.cotizacionDao.obtenerCotizacionesPendientes();	
	}


	@Override
	public Cotizacion obtenerCotizacionById(int idCotizacion) {
		// TODO Auto-generated method stub
		return this.cotizacionDao.obtenerCotizacionById(idCotizacion);
	}


	@Override
	public boolean establecerEstatusCotizacion(Cotizacion cotizacion) {
		// TODO Auto-generated method stub
		try{
			int valor=cotizacionDao.establecerEstatusCotizacion(cotizacion);
		}
		catch(Exception e){
			return false;
		}
		return true;
	}

}
