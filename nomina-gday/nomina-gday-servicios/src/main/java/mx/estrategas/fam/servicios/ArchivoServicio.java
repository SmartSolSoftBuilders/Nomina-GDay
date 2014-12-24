package mx.estrategas.fam.servicios;

import java.util.List;

//import mx.sep.sajja.datos.vo.FiltroBusquedaVO;
import mx.estrategas.fam.modelo.Archivo;
 
public interface ArchivoServicio {	
	void guardarArchivo(Archivo archivo);	
	List<Archivo> obtenerArchivos();	
}
