package mx.estrategas.fam.dao;

import java.util.List;
import mx.estrategas.fam.modelo.Beneficiario;

public interface BeneficiarioDao {	
	void guardarBeneficiario(Beneficiario beneficiario);
	void actualizarBeneficiario(Beneficiario beneficiario);
	void borrarBeneficiarioById(Beneficiario beneficiario);
	List<Beneficiario> obtenerBeneficiariosById(int id);
	int obtenerIdCertificadoByIdBeneficiario(int id);
	void borrarBeneficiariosByIdCertificado(int id);
}
