package mx.estrategas.fam.servicios;

import java.util.List;

import mx.estrategas.fam.dao.EscuelaDao;
import mx.estrategas.fam.dao.TipoEscuelaDao;
import mx.estrategas.fam.modelo.Escuela;
import mx.estrategas.fam.modelo.TipoEscuela;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EscuelaServicioImpl implements EscuelaServicio {
	
	@Autowired
	private EscuelaDao escuelaDao;
	@Autowired
	private TipoEscuelaDao tipoEscuelaDao;

	@Override
	public void guardarEscuela(Escuela escuela) {
		// TODO Auto-generated method stub
		this.escuelaDao.guardarEscuela(escuela);
		
	}

	@Override
	public void actualizarEscuela(Escuela escuela) {
		// TODO Auto-generated method stub
		this.escuelaDao.actualizarEscuela(escuela);
	}

	@Override
	public List<Escuela> obtenerEscuelas() {
		// TODO Auto-generated method stub
		return this.escuelaDao.obtenerEscuelas();
	}

	@Override
	public List<TipoEscuela> obtenerTipoEscuelas() {
		// TODO Auto-generated method stub
		return this.tipoEscuelaDao.obtenerTipoEscuelas();
	}

}
