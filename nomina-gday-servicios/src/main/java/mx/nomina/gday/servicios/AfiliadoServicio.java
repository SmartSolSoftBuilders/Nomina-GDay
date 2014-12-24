package mx.nomina.gday.servicios;

import java.util.List;


//import mx.sep.sajja.datos.vo.FiltroBusquedaVO;

import mx.nomina.gday.modelo.Afiliado;

 
public interface AfiliadoServicio {	
	void guardarAfiliado(Afiliado afiliado);
	void actualizarAfiliado(Afiliado afiliado);
	void guardarAfiliadoModificacion(Afiliado afiliado);
	List<Afiliado> obtenerAfiliados();
	List<Afiliado> obtenerAfiliadosModificacion();
	Afiliado obtenerAfiliadoModificadoById(int idAfiliado);
	Afiliado obtenerAfiliadoById(int idAfiliado);
	public void denegarAfiliadoModificacion(int idAfiliado);
	public void aprobarAfiliadoModificacion(Afiliado afiliado);
	int getIdAfiliadoByRfc(String rfcAfiliado);
	int getCountIdAfiliadoByRfc(String rfcAfiliado);
	List<Afiliado> obtenerAfiliadosDetalle();
}
