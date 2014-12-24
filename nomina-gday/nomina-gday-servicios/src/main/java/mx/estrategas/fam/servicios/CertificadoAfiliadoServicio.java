package mx.estrategas.fam.servicios;

import java.util.List;

//import mx.sep.sajja.datos.vo.FiltroBusquedaVO;
import mx.estrategas.fam.modelo.CertificadoAfiliado;
 
public interface CertificadoAfiliadoServicio {	
	void guardarCertificadoAfiliado(CertificadoAfiliado certificadoAfiliado);
	void actualizarCertificadoAfiliado(CertificadoAfiliado certificadoAfiliado);
	void guardarCertificadoAfiliadoModificacion(CertificadoAfiliado certificadoAfiliado);
	void aprobarModificacionCertificadoAfiliado(CertificadoAfiliado certificadoAfiliado);
	void denegarModificacionCertificadoAfiliado(CertificadoAfiliado certificadoAfiliado);
	CertificadoAfiliado obtenerCertificadoAfiliadoById(int idAfiliado);
	CertificadoAfiliado obtenerCertificadoAfiliadoByIdCertificado(int idAfiliado);
	CertificadoAfiliado obtenerCertificadoAfiliadoByIdCertificado(CertificadoAfiliado certificadoAfiliado);
	CertificadoAfiliado obtenerCertificadoAfiliadoByIdCertificadoAprobacion(CertificadoAfiliado certificadoAfiliado);
	List<CertificadoAfiliado> obtenerCertificadosAfiliados();
	List<CertificadoAfiliado> obtenerCertificadosAfiliadosAprobaciones();
}
