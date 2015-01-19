package mx.nomina.gday.servicios;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.nomina.gday.dao.PatronaDao;
import mx.nomina.gday.modelo.Patrona;

@Service
public class PatronaServicioImpl implements PatronaServicio {
	//Llamada al Dao de Grupo
	@Autowired
	private PatronaDao patronaDao;

	@Override
	public List<Patrona> obtenerPatronas() {
		// TODO Auto-generated method stub
		return this.patronaDao.obtenerPatronas();
	}
	
	

}
