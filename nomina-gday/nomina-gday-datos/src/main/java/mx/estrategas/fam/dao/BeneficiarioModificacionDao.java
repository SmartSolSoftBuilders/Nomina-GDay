package mx.estrategas.fam.dao;

import java.util.List;
import mx.estrategas.fam.modelo.Beneficiario;

public interface BeneficiarioModificacionDao {	
	void guardarBeneficiario(Beneficiario beneficiario);
	List<Beneficiario> obtenerBeneficiariosById(int id);
	List<Beneficiario> obtenerBeneficiarios();
	int obtenerIdCertificadoByIdBeneficiario(int id);
	void borrarBeneficiariosByIdCertificado(int idCertificadoAfiliado);
}
