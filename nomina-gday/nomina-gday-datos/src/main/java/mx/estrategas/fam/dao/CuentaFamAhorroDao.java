package mx.estrategas.fam.dao;

import java.util.List;

import mx.estrategas.fam.modelo.BenefCuentaFamAhorro;
import mx.estrategas.fam.modelo.CuentaFamAhorro;
import mx.estrategas.fam.modelo.MontoDescuentoCuentaFam;

public interface CuentaFamAhorroDao {	
	public List<CuentaFamAhorro> obtenerCuentasFamAhorro();
	public void guardarCuentaFamAhorroDao(CuentaFamAhorro cuentaFamAhorro);
	public void actualizarCuentaFamAhorroDao(CuentaFamAhorro cuentaFamAhorro);	
	public CuentaFamAhorro obtenerCuentaFamAhorroByIdAfiliado(int idAfiliado);
	public List<BenefCuentaFamAhorro> obtenerBeneficiariosCuentaFamAhorroByIdAfiliado (int idCuentaFamAhorro);
	public void actualizarSaldoByRfc(CuentaFamAhorro cuentaFamAhorro);
	public CuentaFamAhorro obtenerCuentaFamAhorroByIdAfiliado2(CuentaFamAhorro cuentaFamAhorro);
	public void actualizarMontoDescuentoFAM(MontoDescuentoCuentaFam montoDescuentoCuentaFam);
	
}
