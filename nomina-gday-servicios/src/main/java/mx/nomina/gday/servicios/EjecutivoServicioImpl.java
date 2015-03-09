package mx.nomina.gday.servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nomina.gday.dao.EjecutivoDao;
import mx.nomina.gday.modelo.Ejecutivo;

@Service
public class EjecutivoServicioImpl implements EjecutivoServicio {

	@Autowired
	private EjecutivoDao ejecutivoDao;
	
	@Override
	public boolean agregarEjecutivo(Ejecutivo ejecutivo) {

		int valor=this.ejecutivoDao.agregarEjecutivo(ejecutivo); 

		return true;
		
	}
	

	@Override
	public void actualizarEjecutivo(Ejecutivo ejecutivo) {

		this.ejecutivoDao.actualizarEjecutivo(ejecutivo);
	}

}
