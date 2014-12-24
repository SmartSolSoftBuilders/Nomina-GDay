package mx.estrategas.fam.servicios;

import java.util.List;





import mx.estrategas.fam.dao.AfiliadoDao;
import mx.estrategas.fam.dao.AfiliadoModificacionDao;
import mx.estrategas.fam.dao.CuentaFamAhorroInversionDao;
import mx.estrategas.fam.dao.MovimientoFamAhorroDao;
import mx.estrategas.fam.dao.MovimientoFamAhorroInversionDao;
//import mx.sep.sajja.datos.vo.FiltroBusquedaVO;
import mx.estrategas.fam.modelo.Afiliado;
import mx.estrategas.fam.modelo.CuentaFamAhorro;
import mx.estrategas.fam.modelo.CuentaFamAhorroInversion;
import mx.estrategas.fam.modelo.Escuela;
import mx.estrategas.fam.modelo.MontoDescuentoCuentaFam;
import mx.estrategas.fam.modelo.MovimientoFamAhorroInversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CuentaFamAhorroInversionServicioImpl implements CuentaFamAhorroInversionServicio {

	@Autowired
	private CuentaFamAhorroInversionDao cuentaFamAhorroInversionDao;

	@Autowired
	private MovimientoFamAhorroInversionDao movimientoFamAhorroDao;
	
	@Override
	public void guardarCuentaFamAhorroServicio(CuentaFamAhorroInversion cuentaFamAhorroInversion) { 
		this.cuentaFamAhorroInversionDao.guardarCuentaFamAhorroDao(cuentaFamAhorroInversion);
	}

	@Override
	public CuentaFamAhorroInversion obtenerCuentaFamAhorroByIdAfiliado(int idAfiliado) {
		// TODO Auto-generated method stub
		return this.cuentaFamAhorroInversionDao.obtenerCuentaFamAhorroByIdAfiliado(idAfiliado);
	}

	@Override
	public void actualizarSaldoByRfc(CuentaFamAhorroInversion cuentaFamAhorroInversion) {
		// TODO Auto-generated method stub
		this.cuentaFamAhorroInversionDao.actualizarSaldoByRfc(cuentaFamAhorroInversion);		
	}

	@Override
	public List<MovimientoFamAhorroInversion> obtenerMovsFamAhorroByIdAfiliado(int idAfiliado) {
		// TODO Auto-generated method stub
		return this.movimientoFamAhorroDao.obtenerMovsFamAhorroByIdAfiliado(idAfiliado);
	}

	@Override
	public void guardarMovimientoCuentaFamAhorro(
			MovimientoFamAhorroInversion movimientoFamAhorro) {
		// TODO Auto-generated method stub
		if (movimientoFamAhorro.getTipoMovimientoFamAhorro().equals("RETIRO"))
			this.movimientoFamAhorroDao.guardarMovimientoRetiroCuentaFamAhorro(movimientoFamAhorro);
		else
			this.movimientoFamAhorroDao.guardarMovimientoCuentaFamAhorro(movimientoFamAhorro);
	}

	@Override
	public void guardarMovimientoRetiroCuentaFamAhorro(
			MovimientoFamAhorroInversion movimientoFamAhorro) {
		// TODO Auto-generated method stub		
	}

	@Override
	public double getSaldoCuentaFamAhorroByIdAfiliado(int idAfiliado) {
		// TODO Auto-generated method stub
		return this.movimientoFamAhorroDao.getSaldoCuentaFamAhorroByIdAfiliado(idAfiliado);
	}

	@Override
	public List<CuentaFamAhorroInversion> obtenerCuentasFamAhorroInvByIdAfiliado(int idAfiliado) {
		// TODO Auto-generated method stub
		return this.cuentaFamAhorroInversionDao.obtenerCuentasFamAhorroInvByIdAfiliado(idAfiliado);
	}

		
}
