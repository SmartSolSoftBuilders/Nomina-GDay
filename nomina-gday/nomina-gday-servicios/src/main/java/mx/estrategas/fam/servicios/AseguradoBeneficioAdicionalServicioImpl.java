package mx.estrategas.fam.servicios;

import java.util.List;


import mx.estrategas.fam.dao.AseguradoBeneficioAdicionalDao;
//import mx.sep.sajja.datos.vo.FiltroBusquedaVO;
import mx.estrategas.fam.modelo.AseguradoBeneficioAdicional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AseguradoBeneficioAdicionalServicioImpl implements AseguradoBeneficioAdicionalServicio {

	@Autowired
	private AseguradoBeneficioAdicionalDao aseguradoBeneficioAdicionalDao;
	
	@Override
	public void guardarAseguradoBeneficioAdicional(AseguradoBeneficioAdicional aseguradoBeneficioAdicional) {
		this.aseguradoBeneficioAdicionalDao.guardarAseguradoBeneficioAdicional(aseguradoBeneficioAdicional);		
	}

	@Override
	public List<AseguradoBeneficioAdicional> obtenerAseguradosBeneficioAdicionalById(
			int idCertificadoAfiliado) {
		return this.aseguradoBeneficioAdicionalDao.obtenerAseguradosBeneficioAdicionalById(idCertificadoAfiliado);
	}

	@Override
	public void actualizarAseguradoBeneficioAdicional(
			AseguradoBeneficioAdicional aseguradoBeneficioAdicional) { 
		this.aseguradoBeneficioAdicionalDao.actualizarAseguradoBeneficioAdicional(aseguradoBeneficioAdicional);
	}

	@Override
	public void eliminarAseguradoBeneficioAdicional(
			AseguradoBeneficioAdicional aseguradoBeneficioAdicional) {
		this.aseguradoBeneficioAdicionalDao.eliminarAseguradoBeneficioAdicional(aseguradoBeneficioAdicional);		
	}
	
}
