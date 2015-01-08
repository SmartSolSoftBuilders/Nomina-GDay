package mx.nomina.gday.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nomina.gday.dao.RazonSocialDao;
import mx.nomina.gday.modelo.RazonSocial;

@Service
public class RazonSocialServicioImpl implements RazonSocialServicio {

	@Autowired
	private RazonSocialDao razonSocialDao; 
	
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
		int valor=this.razonSocialDao.agregarRazonSocial(razonSocial);
		return true;
	}

}
