package mx.estrategas.fam.dao;

import java.util.List;
import mx.estrategas.fam.modelo.Archivo;
import mx.estrategas.fam.modelo.MovimientoFamAhorroInversion;

public interface MovimientoFamAhorroInversionDao {	
	void guardarMovimiento(Archivo archivo);
	List<MovimientoFamAhorroInversion> obtenerMovsFamAhorroByIdAfiliado(int idAfiliado);
	void guardarMovimientoCuentaFamAhorro(MovimientoFamAhorroInversion movimientoFamAhorroInversion);	
	void guardarMovimientoRetiroCuentaFamAhorro(MovimientoFamAhorroInversion movimientoFamAhorroInversion);
	double getSaldoCuentaFamAhorroByIdAfiliado(int idAfiliado);
}
