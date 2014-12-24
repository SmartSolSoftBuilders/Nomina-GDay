package mx.estrategas.fam.servicios;

import java.util.List;


import mx.estrategas.fam.dao.BeneficiarioDao;
import mx.estrategas.fam.dao.BeneficiarioModificacionDao;
//import mx.sep.sajja.datos.vo.FiltroBusquedaVO;
import mx.estrategas.fam.modelo.Beneficiario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BeneficiarioServicioImpl implements BeneficiarioServicio {

	@Autowired
	private BeneficiarioDao beneficiarioDao;
	
	@Autowired
	private BeneficiarioModificacionDao beneficiarioModificacionDao;
	
	@Override
	public void guardarBeneficiario(Beneficiario beneficiario) {
		this.beneficiarioDao.guardarBeneficiario(beneficiario);		
	}

	@Override
	public List<Beneficiario> obtenerBeneficiariosById(int idCertificadoAfiliado) {
		// TODO Auto-generated method stub
		return this.beneficiarioDao.obtenerBeneficiariosById(idCertificadoAfiliado);
	}

	@Override
	public void guardarBeneficiarioModificacion(Beneficiario beneficiario) {
		// TODO Auto-generated method stub
		this.beneficiarioModificacionDao.guardarBeneficiario(beneficiario);
	}

	@Override
	public List<Beneficiario> obtenerBeneficiariosModificacionById(
			int idCertificadoAfiliado) {
		// TODO Auto-generated method stub
		return this.beneficiarioModificacionDao.obtenerBeneficiariosById(idCertificadoAfiliado);
	}
	
	@Override
	public List<Beneficiario> obtenerBeneficiariosModificacion(
			) {
		// TODO Auto-generated method stub
		return this.beneficiarioModificacionDao.obtenerBeneficiarios();
	}

	@Override
	public int obtenerIdCertificadoByIdBeneficiarioMod(int idBeneficiario) {
		// TODO Auto-generated method stub
		return this.beneficiarioModificacionDao.obtenerIdCertificadoByIdBeneficiario(idBeneficiario);
	}

	@Override
	public void borrarBeneficiariosByIdCertificado(int idCertificadoAfiliado) {
		this.beneficiarioDao.borrarBeneficiariosByIdCertificado(idCertificadoAfiliado);		
	}

	@Override
	public void borrarBeneficiariosModByIdCertificado(int idCertificadoAfiliado) {
		// TODO Auto-generated method stub
		this.beneficiarioModificacionDao.borrarBeneficiariosByIdCertificado(idCertificadoAfiliado);
	}

	@Override
	public void actualizarBeneficiario(Beneficiario beneficiario) {
		// TODO Auto-generated method stub
		this.beneficiarioDao.actualizarBeneficiario(beneficiario);
	}

	@Override
	public void borrarBeneficiarioById(Beneficiario beneficiario) {
		// TODO Auto-generated method stub
		this.beneficiarioDao.borrarBeneficiarioById(beneficiario);
	}
	
}

