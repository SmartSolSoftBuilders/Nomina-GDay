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
	
	//Metodo que agrega una Patrona
	@Override
	public boolean agregarPatrona(Patrona patrona) {
		
		try {
			System.out.println("Agregando patrona service"+ patrona);
			
			int valor=this.patronaDao.agregarPatrona(patrona); 
			
			return true;		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}

	//Metodo que Modifica los datos de una Patrona
	@Override
	public void actualizarPatrona(Patrona patrona) {

		this.patronaDao.actualizarPatrona(patrona);
	}

	@Override
	public List<Patrona> obtenerPatronas() {
		// TODO Auto-generated method stub
		return this.patronaDao.obtenerPatronas();
	}


}
