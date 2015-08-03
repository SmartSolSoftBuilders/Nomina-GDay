package mx.nomina.gday.servicios;

import java.util.ArrayList;
import java.util.List;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nomina.gday.dao.PatronaDao;
import mx.nomina.gday.dao.TipoRegimenDao;
import mx.nomina.gday.modelo.Patrona;

@Service
public class PatronaServicioImpl implements PatronaServicio {
	
	//Llamada al Dao de Grupo
	@Autowired
	private PatronaDao patronaDao;
	
	//Llamada al Dao TipoRegimen
	@Autowired
	private TipoRegimenDao tipoRegimenDao;
	
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
		System.out.println("Actualizar Patrona Servicio"+patrona.getNumInteriorFiscalPatrona());
		this.patronaDao.actualizarPatrona(patrona);
	}

	
	//Metodo que obtiene los nombres de Ejecutivo y Esquema
		@Override
		public List obtenerDatosCombo() {
			
			System.out.println("Datos del Combo Servicio");
			List datosCombo = new ArrayList();
			try{
				datosCombo.add(this.tipoRegimenDao.obtenerTipoRegimenes());
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return datosCombo;
		}
	
	//Metodo que obtiene la lista de Patronas, registradas
	@Override
	public List<Patrona> obtenerPatronas() {
		System.out.println("Servicio Patrona");
		return this.patronaDao.obtenerPatronas();
	}

	//Metodo que obtiene una Patrona por idPatrona
	@Override
	public Patrona obtenerPatronaById(int idPatrona) {
		return this.patronaDao.obtenerPatronaById(idPatrona);
	}

	@Override
	public List<Patrona> obtenerPatronasIntermediarias() {
		System.out.println("Servicio Patrona");
		return this.patronaDao.obtenerPatronasIntermediarias();
	}

}
