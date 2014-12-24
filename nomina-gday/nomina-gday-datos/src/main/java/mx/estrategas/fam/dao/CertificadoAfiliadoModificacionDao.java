package mx.estrategas.fam.dao;

import java.util.List;

import mx.estrategas.fam.modelo.CertificadoAfiliado;

public interface CertificadoAfiliadoModificacionDao {		
	void guardarCertificadoAfiliadoModificacion(CertificadoAfiliado certificadoAfiliado);	
	void borrarCertificadoAfiliadoModificacion(CertificadoAfiliado certificadoAfiliado);
	List<CertificadoAfiliado> obtenerCertificadosAfiliados();
	List<CertificadoAfiliado> obtenerCertificadosAfiliadosAprobaciones();
	CertificadoAfiliado obtenerCertificadoAfiliadoById(int id);
	CertificadoAfiliado obtenerCertificadoAfiliadoByIdCertificado(int id);	
}
