package mx.estrategas.fam.dao;

import java.util.List;

import mx.estrategas.fam.modelo.Afiliado;
import mx.estrategas.fam.modelo.CuentaFamAhorro;

public interface AfiliadoDao {	
	void guardarAfiliado(Afiliado afiliado);
	void actualizarAfiliado(Afiliado afiliado);
	Afiliado obtenerAfiliado();
	Afiliado obtenerAfiliadoById(int id);
	List<Afiliado> obtenerAfiliados();
	int obtenerIdAfiliadoByRfc(String rfcAfiliado);
	int obtenerCountIdAfiliadoByRfc(String rfcAfiliado);
	List<Afiliado> obtenerAfiliadosDetalle();
	List<CuentaFamAhorro> obtenerCuentasFamAhorro(Afiliado afiliado);	
}
