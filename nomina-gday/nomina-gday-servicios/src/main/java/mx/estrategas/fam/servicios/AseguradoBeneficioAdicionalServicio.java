package mx.estrategas.fam.servicios;

import java.util.List;

//import mx.sep.sajja.datos.vo.FiltroBusquedaVO;
import mx.estrategas.fam.modelo.AseguradoBeneficioAdicional;
 
public interface AseguradoBeneficioAdicionalServicio {	
	void guardarAseguradoBeneficioAdicional(AseguradoBeneficioAdicional aseguradoBeneficioAdicional);
	void actualizarAseguradoBeneficioAdicional(AseguradoBeneficioAdicional aseguradoBeneficioAdicional);
	void eliminarAseguradoBeneficioAdicional(AseguradoBeneficioAdicional aseguradoBeneficioAdicional);
	List<AseguradoBeneficioAdicional> obtenerAseguradosBeneficioAdicionalById(int idCertificadoAfiliado);	
}
