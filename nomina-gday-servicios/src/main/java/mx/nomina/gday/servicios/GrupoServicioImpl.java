package mx.nomina.gday.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nomina.gday.dao.GrupoDao;
import mx.nomina.gday.modelo.Grupo;

@Service
public class GrupoServicioImpl implements GrupoServicio {
	
	@Autowired
	private GrupoDao grupoDao;
	
	@Override
	public boolean agregarGrupo(Grupo grupo) {
		
		System.out.println("Agregando grupo service"+ grupo);
		
		int valor=this.grupoDao.agregarGrupo(grupo); 
		return true;
	}

}
