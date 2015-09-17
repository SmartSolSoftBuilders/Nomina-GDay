package mx.nomina.gday.servicios;

import java.util.HashMap;
import java.util.List;









import mx.nomina.gday.modelo.AcumuladoPeriodo;
import mx.nomina.gday.modelo.Empleado;
import mx.nomina.gday.modelo.EmpleadoNomina;

public interface EmpleadoMongoServicio {

	public void testMongo();
	public void guardarDocumento(AcumuladoPeriodo acumuladoPeriodo);
	public void eliminarDocumento(AcumuladoPeriodo acumuladoPeriodo);
	List obtenerDocumentos(Integer id1, String id2, String id3, String id4, String id5, String id6, String id7, String id8, String id9);

}
