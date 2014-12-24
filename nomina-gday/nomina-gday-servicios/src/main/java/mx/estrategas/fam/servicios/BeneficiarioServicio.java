package mx.estrategas.fam.servicios;

import java.util.List;

//import mx.sep.sajja.datos.vo.FiltroBusquedaVO;
import mx.estrategas.fam.modelo.Beneficiario;
 
public interface BeneficiarioServicio {	
	void guardarBeneficiario(Beneficiario Beneficiario);
	void borrarBeneficiariosByIdCertificado(int idCertificadoAfiliado);
	List<Beneficiario> obtenerBeneficiariosById(int idCertificadoAfiliado);
	void guardarBeneficiarioModificacion(Beneficiario beneficiario);
	List<Beneficiario> obtenerBeneficiariosModificacionById(int idCertificadoAfiliado);
	List<Beneficiario> obtenerBeneficiariosModificacion();
	int obtenerIdCertificadoByIdBeneficiarioMod(int idBeneficiario);
	void borrarBeneficiariosModByIdCertificado(int idCertificadoAfiliado);
	void actualizarBeneficiario(Beneficiario beneficiario);
	void borrarBeneficiarioById(Beneficiario beneficiario);
}
