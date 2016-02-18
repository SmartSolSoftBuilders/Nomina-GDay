package mx.nomina.gday.servicios;

import java.util.HashMap;
import java.util.List;











import mx.nomina.gday.modelo.AcumuladoPeriodo;
import mx.nomina.gday.modelo.Empleado;
import mx.nomina.gday.modelo.EmpleadoNomina;
import mx.nomina.gday.modelo.Nomina;

public interface EmpleadoMongoServicio {

	public void testMongo();
	public List<String> guardarDocumento(AcumuladoPeriodo acumuladoPeriodo);
	public void eliminarDocumento(AcumuladoPeriodo acumuladoPeriodo);
	List obtenerDocumentos(Integer id1, String id2, String id3, String id4, String id5, String id6, String id7, String id8, String id9);
	public List obtenerDocumentos(Integer id1, String id2, String id3,
			String id4, String id5, String id6, String id7, String id8,
			String id9, List<Nomina> nominas);

}
