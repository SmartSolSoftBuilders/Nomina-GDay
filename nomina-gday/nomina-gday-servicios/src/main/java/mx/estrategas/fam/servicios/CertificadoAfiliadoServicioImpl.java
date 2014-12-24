package mx.estrategas.fam.servicios;

import java.util.List;

import mx.estrategas.fam.dao.CertificadoAfiliadoDao;
import mx.estrategas.fam.dao.CertificadoAfiliadoModificacionDao;
//import mx.sep.sajja.datos.vo.FiltroBusquedaVO;
import mx.estrategas.fam.modelo.CertificadoAfiliado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CertificadoAfiliadoServicioImpl implements CertificadoAfiliadoServicio {

	@Autowired
	private CertificadoAfiliadoDao certificadoAfiliadoDao;
	@Autowired
	private CertificadoAfiliadoModificacionDao certificadoAfiliadoModificacionDao;
	
	@Override
	public void guardarCertificadoAfiliado(CertificadoAfiliado certificadoAfiliado) {
		this.certificadoAfiliadoDao.guardarCertificadoAfiliado(certificadoAfiliado);
		
	}
	
	@Override
	public void actualizarCertificadoAfiliado(CertificadoAfiliado certificadoAfiliado) {
		this.certificadoAfiliadoDao.actualizarCertificadoAfiliado(certificadoAfiliado);
		
	}
	
	@Override
	public void guardarCertificadoAfiliadoModificacion(CertificadoAfiliado certificadoAfiliado) {
		this.certificadoAfiliadoModificacionDao.guardarCertificadoAfiliadoModificacion(certificadoAfiliado);
	}
	
	@Override
	public CertificadoAfiliado obtenerCertificadoAfiliadoById(
		int idAfiliado) {
		// TODO Auto-generated method stub
		CertificadoAfiliado certificadoAfiliado = new CertificadoAfiliado();
		try{
			 certificadoAfiliado =  this.certificadoAfiliadoDao.obtenerCertificadoAfiliadoById(idAfiliado);
 		}
		catch(Exception e){
			System.out.println("ERROR!!!"+e.getMessage());
		}
		return certificadoAfiliado; 
	}
	
	@Override
	public CertificadoAfiliado obtenerCertificadoAfiliadoByIdCertificado(
			int idAfiliado) {
		// TODO Auto-generated method stub
		return this.certificadoAfiliadoDao.obtenerCertificadoAfiliadoByIdCertificado(idAfiliado);
	}
	
	@Override
	public CertificadoAfiliado obtenerCertificadoAfiliadoByIdCertificado(
			CertificadoAfiliado certificadoAfiliado) {
		// TODO Auto-generated method stub
		return this.certificadoAfiliadoDao.obtenerCertificadoAfiliadoByIdCertificado(certificadoAfiliado);
	}

	@Override
	public List<CertificadoAfiliado> obtenerCertificadosAfiliados() {
		// TODO Auto-generated method stub
		return this.certificadoAfiliadoDao.obtenerCertificadosAfiliados();
	}
	
	@Override
	public List<CertificadoAfiliado> obtenerCertificadosAfiliadosAprobaciones() {
		// TODO Auto-generated method stub
		return this.certificadoAfiliadoModificacionDao.obtenerCertificadosAfiliadosAprobaciones();
	}

	@Override
	public CertificadoAfiliado obtenerCertificadoAfiliadoByIdCertificadoAprobacion(
			CertificadoAfiliado certificadoAfiliado) {
		// TODO Auto-generated method stub
		return this.certificadoAfiliadoModificacionDao.obtenerCertificadoAfiliadoByIdCertificado(certificadoAfiliado.getIdCertificadoAfiliado());
	}

	@Override
	public void aprobarModificacionCertificadoAfiliado(
			CertificadoAfiliado certificadoAfiliado) {
		this.certificadoAfiliadoDao.actualizarCertificadoAfiliado(certificadoAfiliado);
		this.certificadoAfiliadoModificacionDao.borrarCertificadoAfiliadoModificacion(certificadoAfiliado);
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void denegarModificacionCertificadoAfiliado(
			CertificadoAfiliado certificadoAfiliado) {		
		this.certificadoAfiliadoModificacionDao.borrarCertificadoAfiliadoModificacion(certificadoAfiliado);
		// TODO Auto-generated method stub
		
	}
	
}
