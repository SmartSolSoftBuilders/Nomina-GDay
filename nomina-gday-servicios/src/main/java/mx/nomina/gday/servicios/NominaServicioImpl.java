package mx.nomina.gday.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nomina.gday.dao.EjecutivoDao;
import mx.nomina.gday.dao.EsquemaDao;
import mx.nomina.gday.dao.NominaDao;
import mx.nomina.gday.dao.RazonSocialDao;
import mx.nomina.gday.dao.TipoCalendarioDao;
import mx.nomina.gday.modelo.EmpleadoNomina;
import mx.nomina.gday.modelo.Nomina;
import mx.nomina.gday.modelo.RazonSocial;

@Service
public class NominaServicioImpl implements NominaServicio {
	
	@Autowired
	private NominaDao nominaDao;
	
	@Autowired
	private EjecutivoDao ejecutivoDao;
	
	@Autowired
	private EsquemaDao esquemaDao;
	
	@Autowired
	private TipoCalendarioDao tipoCalendarioDao;
	
	@Autowired
	private RazonSocialDao razonSocialDao;
	
	//Metodo que agrega una Nomina
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

	//Metodo que Modifica los datos de una Nomina
	@Override
	public void actualizarNomina(Nomina nomina) {

		this.nominaDao.actualizarNomina(nomina);
	}

	//Metodo que obtiene una Nomina por idNomina
	@Override
	public Nomina obtenerNominaById(int idNomina) {
		System.out.println("Servicio obtenerNominaById"+ idNomina);
		return this.nominaDao.obtenerNominaById(idNomina);

	}

	//Metodo que obtiene la lista de todas las Nominas registradas
	@Override
	public List<Nomina> obtenerNominas() {

		System.out.println("Nomina Service");
		try {
			 
				List<Nomina> tmp=this.nominaDao.obtenerNominas();
				System.out.println("Lista de Nominas"+tmp.size());
					return tmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Metodo que obtiene los nombres de Ejecutivo y Esquema
	@Override
	public List obtenerDatosCombo() {
		
		System.out.println("Datos del Combo Servicio");
		List datosCombo = new ArrayList();
		try{
			datosCombo.add(this.ejecutivoDao.obtenerEjecutivos());
			datosCombo.add(this.esquemaDao.obtenerEsquemas());
			datosCombo.add(this.tipoCalendarioDao.obtenerTiposCalendario());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return datosCombo;
	}

	@Override
	public List<RazonSocial> obtenerRazonesSocialesByIdNomina(Integer idNomina) {
		// TODO Auto-generated method stub
		return this.razonSocialDao.obtenerRazonesSocialesByIdNomina(idNomina);
	}
	
	
	//Metodo que obtiene la lista de todas las Nominas registradas
	@Override
	public List<Nomina> obtenerNominasByIdEmpleado(Integer idEmpleado) {

		System.out.println("Nomina Service");
		try {
			 
				List<Nomina> tmp=this.nominaDao.obtenerNominasByIdEmpleado(idEmpleado);
				System.out.println("Lista de Nominas"+tmp.size());
					return tmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Nomina> obtenerNominasByIdEjecutivo(Integer idEjecutivo) {
		// TODO Auto-generated method stub

		System.out.println("Nomina Service");
		try {			 
			List<Nomina> tmp=this.nominaDao.obtenerNominasByIdEjecutivo(idEjecutivo);
			System.out.println("Lista de Nominas"+tmp.size());
			return tmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
