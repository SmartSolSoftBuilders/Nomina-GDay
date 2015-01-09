package mx.nomina.gday.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nomina.gday.dao.GrupoDao;
import mx.nomina.gday.modelo.Grupo;
import mx.nomina.gday.modelo.RazonSocial;

@Service
public class GrupoServicioImpl implements GrupoServicio {
	//Llamada al Dao de Grupo
	@Autowired
	private GrupoDao grupoDao;
	
	
	
	//Metodo para guardar Grupo
	@Override
	public boolean agregarGrupo(Grupo grupo) {
		
		System.out.println("Agregando grupo service"+ grupo);
		grupo.setNombre(grupo.getNombre().toUpperCase());
		grupo.setNombreCorto(grupo.getNombreCorto().toUpperCase());
		int valor=this.grupoDao.agregarGrupo(grupo); 
		return true;
	}

	//Metodo que obtiene la lista de Grupos
	@Override
	public List<Grupo> obtenerGrupos() {
		System.out.println("Grupo Service");
		try {
			 
				List<Grupo> tmp=this.grupoDao.obtenerGrupos();
				System.out.println("Lista de Grupos"+tmp.size());
					return tmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//Metodo que Modifica los datos del grupo
	@Override
	public void actualizarGrupo(Grupo grupo) {

		this.grupoDao.actualizarGrupo(grupo);
	}

	//Metodo que obtiene el grupo por Id del Grupo
	@Override
	public Grupo obtenerGrupoById(int idGrupo) {
		System.out.println("Servicio obtenerGrupoById"+ idGrupo);
		return this.grupoDao.obtenerGrupoById(idGrupo);
	}

}
