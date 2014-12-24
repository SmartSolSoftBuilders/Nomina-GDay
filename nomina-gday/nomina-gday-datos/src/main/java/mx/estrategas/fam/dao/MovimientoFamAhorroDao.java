package mx.estrategas.fam.dao;

import java.util.List;

import mx.estrategas.fam.modelo.Archivo;
import mx.estrategas.fam.modelo.CuentaFamAhorro;
import mx.estrategas.fam.modelo.MovimientoFamAhorro;

public interface MovimientoFamAhorroDao {	
	void guardarMovimiento(Archivo archivo);
	List<MovimientoFamAhorro> obtenerMovsFamAhorroByIdAfiliado(int idAfiliado);
	void guardarMovimientoCuentaFamAhorro(MovimientoFamAhorro movimientoFamAhorro);	
	void guardarMovimientoRetiroCuentaFamAhorro(MovimientoFamAhorro movimientoFamAhorro);
	double getSaldoCuentaFamAhorroByIdAfiliado(int idAfiliado);
	List<MovimientoFamAhorro>  obtenerMovsFamAhorro(int idCuentaFamAhorro);
	void guardarMovimientoRetiroCuentaFamAhorroIndividual(MovimientoFamAhorro movimientoFamAhorro);
	void guardarMovimientoCuentaFamAhorroIndividual(MovimientoFamAhorro movimientoFamAhorro);
}
