package mx.estrategas.fam.servicios;

import java.util.List;



//import mx.sep.sajja.datos.vo.FiltroBusquedaVO;
import mx.estrategas.fam.modelo.Afiliado;
import mx.estrategas.fam.modelo.CuentaFamAhorro;
import mx.estrategas.fam.modelo.CuentaFamAhorroInversion;
import mx.estrategas.fam.modelo.MontoDescuentoCuentaFam;
import mx.estrategas.fam.modelo.MovimientoFamAhorroInversion;
 
public interface CuentaFamAhorroInversionServicio {	
	void guardarCuentaFamAhorroServicio(CuentaFamAhorroInversion cuentaFamAhorroInversion);
	CuentaFamAhorroInversion obtenerCuentaFamAhorroByIdAfiliado(int idAfiliado);
	void actualizarSaldoByRfc(CuentaFamAhorroInversion cuentaFamAhorroInversion);
	List<MovimientoFamAhorroInversion> obtenerMovsFamAhorroByIdAfiliado(int idAfiliado);
	void guardarMovimientoCuentaFamAhorro(MovimientoFamAhorroInversion movimientoFamAhorro);
	void guardarMovimientoRetiroCuentaFamAhorro(MovimientoFamAhorroInversion movimientoFamAhorro);
	double getSaldoCuentaFamAhorroByIdAfiliado(int idAfiliado);
	List<CuentaFamAhorroInversion> obtenerCuentasFamAhorroInvByIdAfiliado(int idAfiliado);	
}
