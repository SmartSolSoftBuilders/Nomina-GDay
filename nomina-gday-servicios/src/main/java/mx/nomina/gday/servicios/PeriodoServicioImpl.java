package mx.nomina.gday.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nomina.gday.dao.PeriodoDao;
import mx.nomina.gday.modelo.Periodo;

@Service
public class PeriodoServicioImpl implements PeriodoServicio {

	@Autowired
	private PeriodoDao periodoDao;
	
	@Override
	public List<Periodo> obtenerPeriodos() {

		System.out.println("Datos del Combo Servicio");
		List datosCombo = new ArrayList();
		try{
			datosCombo.add(this.periodoDao.obtenerPeriodos());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return datosCombo;
	}

}
