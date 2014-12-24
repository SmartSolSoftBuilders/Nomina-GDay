package mx.estrategas.fam.dao;

import java.util.List;

import mx.estrategas.fam.modelo.CertificadoAfiliado;

public interface CertificadoAfiliadoDao {	
	void guardarCertificadoAfiliado(CertificadoAfiliado certificadoAfiliado);
	void actualizarCertificadoAfiliado(CertificadoAfiliado certificadoAfiliado);
	List<CertificadoAfiliado> obtenerCertificadosAfiliados();
	CertificadoAfiliado obtenerCertificadoAfiliadoById(int id);
	CertificadoAfiliado obtenerCertificadoAfiliadoByIdCertificado(int id);	
	CertificadoAfiliado obtenerCertificadoAfiliadoByIdCertificado(CertificadoAfiliado certificadoAfiliado);
}
