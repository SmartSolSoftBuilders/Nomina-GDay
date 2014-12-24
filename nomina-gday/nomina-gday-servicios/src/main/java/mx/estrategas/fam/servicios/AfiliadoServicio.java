package mx.estrategas.fam.servicios;

import java.util.List;


//import mx.sep.sajja.datos.vo.FiltroBusquedaVO;
import mx.estrategas.fam.modelo.Afiliado;
import mx.estrategas.fam.modelo.Escuela;
import mx.estrategas.fam.modelo.CuentaFamAhorro;
 
public interface AfiliadoServicio {	
	void guardarAfiliado(Afiliado afiliado);
	void actualizarAfiliado(Afiliado afiliado);
	void guardarAfiliadoModificacion(Afiliado afiliado);
	List<Escuela> obtenerEscuelas();
	List<Afiliado> obtenerAfiliados();
	List<Afiliado> obtenerAfiliadosModificacion();
	Afiliado obtenerAfiliadoModificadoById(int idAfiliado);
	Afiliado obtenerAfiliadoById(int idAfiliado);
	public void denegarAfiliadoModificacion(int idAfiliado);
	public void aprobarAfiliadoModificacion(Afiliado afiliado);
	int getIdAfiliadoByRfc(String rfcAfiliado);
	int getCountIdAfiliadoByRfc(String rfcAfiliado);
	List<Afiliado> obtenerAfiliadosDetalle();
	List<CuentaFamAhorro> obtenerCuentasFamAhorro(Afiliado afiliado);
}
