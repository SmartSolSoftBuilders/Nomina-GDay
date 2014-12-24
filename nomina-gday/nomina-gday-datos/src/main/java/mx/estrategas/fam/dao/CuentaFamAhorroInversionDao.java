package mx.estrategas.fam.dao;

import java.util.List;

import mx.estrategas.fam.modelo.CuentaFamAhorro;
import mx.estrategas.fam.modelo.CuentaFamAhorroInversion;

public interface CuentaFamAhorroInversionDao {	
	public List<CuentaFamAhorroInversion> obtenerCuentasFamAhorro();
	public void guardarCuentaFamAhorroDao(CuentaFamAhorroInversion cuentaFamAhorroInversion);
	public CuentaFamAhorroInversion obtenerCuentaFamAhorroByIdAfiliado(int idAfiliado);
	public void actualizarSaldoByRfc(CuentaFamAhorroInversion cuentaFamAhorroInversion);
	public List<CuentaFamAhorroInversion> obtenerCuentasFamAhorroInvByIdAfiliado(int idAfiliado);
}
