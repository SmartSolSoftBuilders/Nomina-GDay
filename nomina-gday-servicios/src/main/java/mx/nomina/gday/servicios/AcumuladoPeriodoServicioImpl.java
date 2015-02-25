package mx.nomina.gday.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nomina.gday.dao.AcumuladoPeriodoDao;
import mx.nomina.gday.dao.NominaDao;
import mx.nomina.gday.modelo.AcumuladoPeriodo;

@Service
public class AcumuladoPeriodoServicioImpl implements AcumuladoPeriodoServicio {

	@Autowired
	private AcumuladoPeriodoDao acumuladoPeriodoDao;
	
	@Autowired
	private NominaDao nominaDao;
	
	
		
	@Override
	public void agregarAcumulado(AcumuladoPeriodo acumuladoPeriodo) {

		try{
			this.acumuladoPeriodoDao.agregarAcumulado(acumuladoPeriodo);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List obtenerDatosCombo() {
		System.out.println("Datos del Combo Servicio");
		List datosCombo = new ArrayList();
		try{
			datosCombo.add(this.nominaDao.obtenerNominas());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return datosCombo;
	}
}
