package mx.nomina.gday.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nomina.gday.dao.NominaDao;
import mx.nomina.gday.modelo.Nomina;

@Service
public class NominaServicioImpl implements NominaServicio {
	
	@Autowired
	private NominaDao nominaDao;
	
	@Override
	public boolean agregarNomina(Nomina nomina) {
		try {
			System.out.println("Agregando nomina service"+ nomina);
			
			int valor=this.nominaDao.agregarNomina(nomina); 
			
			return true;		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}

}
