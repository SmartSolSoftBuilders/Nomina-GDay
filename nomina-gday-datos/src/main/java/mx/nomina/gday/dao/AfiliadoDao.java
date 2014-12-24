package mx.nomina.gday.dao;

import java.util.List;

import mx.nomina.gday.modelo.Afiliado;

public interface AfiliadoDao {	
	void guardarAfiliado(Afiliado afiliado);
	void actualizarAfiliado(Afiliado afiliado);
	Afiliado obtenerAfiliado();
	Afiliado obtenerAfiliadoById(int id);
	List<Afiliado> obtenerAfiliados();
	int obtenerIdAfiliadoByRfc(String rfcAfiliado);
	int obtenerCountIdAfiliadoByRfc(String rfcAfiliado);
	List<Afiliado> obtenerAfiliadosDetalle();
}
