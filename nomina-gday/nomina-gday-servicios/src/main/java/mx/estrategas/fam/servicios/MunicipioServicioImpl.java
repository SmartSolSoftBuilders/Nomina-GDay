package mx.estrategas.fam.servicios;

import java.util.List;


import mx.estrategas.fam.dao.MunicipioDao;
//import mx.sep.sajja.datos.vo.FiltroBusquedaVO;
import mx.estrategas.fam.modelo.Municipio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MunicipioServicioImpl implements MunicipioServicio {

	@Autowired
	private MunicipioDao municipioDao;

	@Override
	public void guardarMunicipio(Municipio municipio) {
		// TODO Auto-generated method stub
		this.municipioDao.guardarMunicipio(municipio);
		
	}

	@Override
	public void actualizarMunicipio(Municipio municipio) {
		// TODO Auto-generated method stub
		this.municipioDao.actualizarMunicipio(municipio);
		
	}

	@Override
	public List<Municipio> obtenerMunicipios() {
		// TODO Auto-generated method stub
		return this.municipioDao.obtenerMunicipios();
	}

}
