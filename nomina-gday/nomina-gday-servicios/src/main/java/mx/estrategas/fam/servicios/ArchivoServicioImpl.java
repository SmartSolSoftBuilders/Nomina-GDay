package mx.estrategas.fam.servicios;

import java.util.List;

import mx.estrategas.fam.dao.AfiliadoDao;
import mx.estrategas.fam.dao.AfiliadoModificacionDao;
import mx.estrategas.fam.dao.ArchivoDao;
import mx.estrategas.fam.dao.EscuelaDao;
//import mx.sep.sajja.datos.vo.FiltroBusquedaVO;
import mx.estrategas.fam.modelo.Afiliado;
import mx.estrategas.fam.modelo.Archivo;
import mx.estrategas.fam.modelo.Escuela;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArchivoServicioImpl implements ArchivoServicio {

	@Autowired
	private ArchivoDao archivoDao;

	@Override
	public void guardarArchivo(Archivo archivo) {
		// TODO Auto-generated method stub
		this.archivoDao.guardarArchivo(archivo);
		
	}

	@Override
	public List<Archivo> obtenerArchivos() {
		// TODO Auto-generated method stub
		return this.archivoDao.obtenerArchivos();
	}
	
		
}
