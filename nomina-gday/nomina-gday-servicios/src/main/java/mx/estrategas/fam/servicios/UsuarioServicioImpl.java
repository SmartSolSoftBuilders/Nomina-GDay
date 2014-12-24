package mx.estrategas.fam.servicios;

import java.util.List;

import mx.estrategas.fam.dao.UsuarioDao;
//import mx.sep.sajja.datos.vo.FiltroBusquedaVO;
import mx.estrategas.fam.modelo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public Usuario obtenerUsuario() {
		// TODO Auto-generated method stub
		return usuarioDao.obtenerUsuario();
	}
	
	}
