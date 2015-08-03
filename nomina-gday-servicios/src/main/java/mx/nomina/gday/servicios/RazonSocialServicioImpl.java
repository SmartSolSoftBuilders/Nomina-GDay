package mx.nomina.gday.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nomina.gday.dao.NominaDao;
import mx.nomina.gday.dao.RazonSocialDao;
import mx.nomina.gday.modelo.Nomina;
import mx.nomina.gday.modelo.RazonSocial;

@Service
public class RazonSocialServicioImpl implements RazonSocialServicio {

	@Autowired
	private RazonSocialDao razonSocialDao; 
	
	@Autowired
	private NominaDao nominaDao;
	
	@Override
	public List<RazonSocial> obtenerRazonesSociales() {
		System.out.println("Razon Social Service");
		try {
			 
				List<RazonSocial> tmp=	this.razonSocialDao.obtenerRazonesSociales();
				System.out.println("Lista de Razon Social"+tmp.size());
					return tmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean agregarRazonSocial(RazonSocial razonSocial) {
		try {
			System.out.println("Razon Social Service"+ razonSocial);
			razonSocial.setCalleFiscal(razonSocial.getCalleFiscal().toUpperCase());
			razonSocial.setCodCliente(razonSocial.getCodCliente().toUpperCase());
			razonSocial.setColoniaFiscal(razonSocial.getColoniaFiscal().toUpperCase());
			razonSocial.setContactoDosCorreo(razonSocial.getContactoDosCorreo().toUpperCase());
			razonSocial.setContactoDosNombre(razonSocial.getContactoDosNombre().toUpperCase());
			razonSocial.setContactoTresCorreo(razonSocial.getContactoTresCorreo().toUpperCase());
			razonSocial.setContactoTresNombre(razonSocial.getContactoTresNombre().toUpperCase());
			razonSocial.setContactoUnoCorreo(razonSocial.getContactoUnoCorreo().toUpperCase());
			razonSocial.setContactoUnoNombre(razonSocial.getContactoUnoNombre().toUpperCase());
			razonSocial.setEstadoFiscal(razonSocial.getEstadoFiscal().toUpperCase());
			razonSocial.setMaternoRepresentante(razonSocial.getMaternoRepresentante().toUpperCase());
			razonSocial.setMunicipioFiscal(razonSocial.getMunicipioFiscal().toUpperCase());
			razonSocial.setNombreCortoRazonS(razonSocial.getNombreCortoRazonS().toUpperCase());
			razonSocial.setNombreRazonSocial(razonSocial.getNombreRazonSocial().toUpperCase());
			razonSocial.setNombresRepresentante(razonSocial.getNombresRepresentante().toUpperCase());
			razonSocial.setNumExteriorFiscal(razonSocial.getNumExteriorFiscal().toUpperCase());
			razonSocial.setNumInteriorFiscal(razonSocial.getNumInteriorFiscal().toUpperCase());
			razonSocial.setPaternoRepresentante(razonSocial.getPaternoRepresentante().toUpperCase());
			razonSocial.setObjetoSocial(razonSocial.getObjetoSocial().toUpperCase());
			int valor=this.razonSocialDao.agregarRazonSocial(razonSocial);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void actualizarRazonSocial(RazonSocial razonSocial) {
		try {
  			System.out.println("Actualizando razon social Servicio"+ razonSocial.getIdRazonSocial());
  			System.out.println("Actualizando grupo de razon social Servicio"+ razonSocial.getGrupo().getIdGrupo());
			this.razonSocialDao.actualizarRazonSocial(razonSocial);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public RazonSocial obtenerRazonSocialById(int idRazonSocial) {

		return this.razonSocialDao.obtenerRazonSocialById(idRazonSocial);
	}

	@Override
	public List<Nomina> obtenerNominasByIdRazonSocial(int idNomina) {
		System.out.println("Nominas por Razon Social Service");
		try {
			 
				List<Nomina> tmp=	this.nominaDao.obtenerNominasByIdRazonSocial(idNomina);
				System.out.println("Lista de Nominas"+tmp.size());
					return tmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
}
	

