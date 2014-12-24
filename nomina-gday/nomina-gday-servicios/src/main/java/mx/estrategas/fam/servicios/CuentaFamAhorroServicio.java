package mx.estrategas.fam.servicios;

import java.util.List;

//import mx.sep.sajja.datos.vo.FiltroBusquedaVO;
import mx.estrategas.fam.modelo.Afiliado;
import mx.estrategas.fam.modelo.BenefCuentaFamAhorro;
import mx.estrategas.fam.modelo.CuentaFamAhorro;
import mx.estrategas.fam.modelo.MontoDescuentoCuentaFam;
import mx.estrategas.fam.modelo.MovimientoFamAhorro;
 
public interface CuentaFamAhorroServicio {	
	void guardarCuentaFamAhorroServicio(CuentaFamAhorro cuentaFamAhorro);
	CuentaFamAhorro obtenerCuentaFamAhorroByIdAfiliado(int idAfiliado);
	void actualizarSaldoByRfc(CuentaFamAhorro cuentaFamAhorro);
	List<MovimientoFamAhorro> obtenerMovsFamAhorroByIdAfiliado(int idAfiliado);
	void guardarMovimientoCuentaFamAhorro(MovimientoFamAhorro movimientoFamAhorro);
	void guardarMovimientoRetiroCuentaFamAhorro(MovimientoFamAhorro movimientoFamAhorro);
	double getSaldoCuentaFamAhorroByIdAfiliado(int idAfiliado);
	List<BenefCuentaFamAhorro> obtenerBeneficiariosCuentaFamAhorroByIdAfiliado(int idCuentaFamAhorro);
	void actualizarCuentaFamAhorroServicio(CuentaFamAhorro cuentaFamAhorro);
	CuentaFamAhorro obtenerCuentaFamAhorroByIdAfiliado2(CuentaFamAhorro cuentaFamAhorro);
	List<MovimientoFamAhorro> obtenerMovsFamAhorroByIdFamAhorro(CuentaFamAhorro cuentaFamAhorro);
	void guardarMovimientoCuentaFamAhorroIndividual(MovimientoFamAhorro movimientoFamAhorro);
	void guardarMovimientoRetiroFamAhorroIndividual(MovimientoFamAhorro movimientoFamAhorro);
	void actualizarMontoDescuentoFAM(MontoDescuentoCuentaFam montoDescuentoCuentaFam);
}
