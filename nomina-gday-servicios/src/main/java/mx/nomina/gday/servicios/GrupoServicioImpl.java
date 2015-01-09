package mx.nomina.gday.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nomina.gday.dao.GrupoDao;
import mx.nomina.gday.modelo.Grupo;
import mx.nomina.gday.modelo.RazonSocial;

@Service
public class GrupoServicioImpl implements GrupoServicio {
	
	@Autowired
	private GrupoDao grupoDao;
	
	@Override
	public boolean agregarGrupo(Grupo grupo) {
		
		System.out.println("Agregando grupo service"+ grupo);
		grupo.setNombre(grupo.getNombre().toUpperCase());
		grupo.setNombreCorto(grupo.getNombreCorto().toUpperCase());
		int valor=this.grupoDao.agregarGrupo(grupo); 
		return true;
	}

	
	@Override
	public List<Grupo> obtenerGrupos() {
		System.out.println("Grupo Service");
		try {
			 
				List<Grupo> tmp=	this.grupoDao.obtenerGrupos();
				System.out.println("Lista de Grupos"+tmp.size());
					return tmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
