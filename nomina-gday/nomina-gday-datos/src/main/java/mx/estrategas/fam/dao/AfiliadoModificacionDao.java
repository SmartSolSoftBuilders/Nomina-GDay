package mx.estrategas.fam.dao;

import java.util.List;

import mx.estrategas.fam.modelo.Afiliado;

public interface AfiliadoModificacionDao {	
	void guardarAfiliado(Afiliado afiliado);
	void borrarAfiliado(int id);
	Afiliado obtenerAfiliado();
	List<Afiliado> obtenerAfiliados();
	Afiliado obtenerAfiliadoById(int id);
}
