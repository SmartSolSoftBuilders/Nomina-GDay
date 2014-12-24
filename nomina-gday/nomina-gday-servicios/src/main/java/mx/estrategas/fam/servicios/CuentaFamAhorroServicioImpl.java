package mx.estrategas.fam.servicios;

import java.util.ArrayList;
import java.util.List;



import mx.estrategas.fam.dao.AfiliadoDao;
import mx.estrategas.fam.dao.AfiliadoModificacionDao;
import mx.estrategas.fam.dao.CuentaFamAhorroDao;
import mx.estrategas.fam.dao.MovimientoFamAhorroDao;
//import mx.sep.sajja.datos.vo.FiltroBusquedaVO;
import mx.estrategas.fam.modelo.Afiliado;
import mx.estrategas.fam.modelo.BenefCuentaFamAhorro;
import mx.estrategas.fam.modelo.CuentaFamAhorro;
import mx.estrategas.fam.modelo.Escuela;
import mx.estrategas.fam.modelo.MontoDescuentoCuentaFam;
import mx.estrategas.fam.modelo.MovimientoFamAhorro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CuentaFamAhorroServicioImpl implements CuentaFamAhorroServicio {

	@Autowired
	private CuentaFamAhorroDao cuentaFamAhorroDao;

	@Autowired
	private MovimientoFamAhorroDao movimientoFamAhorroDao;
	
	@Override
	public void guardarCuentaFamAhorroServicio(CuentaFamAhorro cuentaFamAhorro) { 
		this.cuentaFamAhorroDao.guardarCuentaFamAhorroDao(cuentaFamAhorro);
	}
	
	@Override
	public void actualizarCuentaFamAhorroServicio(CuentaFamAhorro cuentaFamAhorro) { 
		this.cuentaFamAhorroDao.actualizarCuentaFamAhorroDao(cuentaFamAhorro);
	}
	
	@Override
	public List<BenefCuentaFamAhorro> obtenerBeneficiariosCuentaFamAhorroByIdAfiliado (int idCuentaFamAhorro){
		List<BenefCuentaFamAhorro> benefCuentasFamAhorro = new ArrayList<BenefCuentaFamAhorro>();
		try{
			benefCuentasFamAhorro=this.cuentaFamAhorroDao.obtenerBeneficiariosCuentaFamAhorroByIdAfiliado(idCuentaFamAhorro);
		}
		catch(Exception e){
			System.out.println("ERROR"+e.getMessage());
		}
		return benefCuentasFamAhorro;
	}
	@Override
	public CuentaFamAhorro obtenerCuentaFamAhorroByIdAfiliado(int idAfiliado) {
		// TODO Auto-generated method stub
		CuentaFamAhorro cuentaFamAhorro = new CuentaFamAhorro();
		try{
			cuentaFamAhorro=this.cuentaFamAhorroDao.obtenerCuentaFamAhorroByIdAfiliado(idAfiliado);
		}
		catch(Exception e){
			System.out.println("ERROR"+e.getMessage());
		}
		return cuentaFamAhorro;
	}

	@Override
	public void actualizarSaldoByRfc(CuentaFamAhorro cuentaFamAhorro) {
		// TODO Auto-generated method stub
		this.cuentaFamAhorroDao.actualizarSaldoByRfc(cuentaFamAhorro);		
	}

	@Override
	public List<MovimientoFamAhorro> obtenerMovsFamAhorroByIdAfiliado(int idAfiliado) {
		// TODO Auto-generated method stub
		return this.movimientoFamAhorroDao.obtenerMovsFamAhorroByIdAfiliado(idAfiliado);
	}

	@Override
	public void guardarMovimientoCuentaFamAhorro(
			MovimientoFamAhorro movimientoFamAhorro) {
		// TODO Auto-generated method stub
		if (movimientoFamAhorro.getTipoMovimientoFamAhorro().equals("RETIRO"))
			this.movimientoFamAhorroDao.guardarMovimientoRetiroCuentaFamAhorro(movimientoFamAhorro);
		else
			this.movimientoFamAhorroDao.guardarMovimientoCuentaFamAhorro(movimientoFamAhorro);
	}

	@Override
	public void guardarMovimientoRetiroCuentaFamAhorro(
			MovimientoFamAhorro movimientoFamAhorro) {
		// TODO Auto-generated method stub		
	}

	@Override
	public double getSaldoCuentaFamAhorroByIdAfiliado(int idAfiliado) {
		// TODO Auto-generated method stub
		return this.movimientoFamAhorroDao.getSaldoCuentaFamAhorroByIdAfiliado(idAfiliado);
	}

	@Override
	public CuentaFamAhorro obtenerCuentaFamAhorroByIdAfiliado2(CuentaFamAhorro cuentaFamAhorro) {
		// TODO Auto-generated method stub
		CuentaFamAhorro cuentaFamAhorro2 = new CuentaFamAhorro();
		try{
			cuentaFamAhorro2=this.cuentaFamAhorroDao.obtenerCuentaFamAhorroByIdAfiliado2(cuentaFamAhorro);
		}
		catch(Exception e){
			System.out.println("ERROR"+e.getMessage());
		}
		return cuentaFamAhorro2;
	}

	@Override
	public List<MovimientoFamAhorro> obtenerMovsFamAhorroByIdFamAhorro(
			CuentaFamAhorro cuentaFamAhorro) {
		// TODO Auto-generated method stub
		try{
			return this.movimientoFamAhorroDao.obtenerMovsFamAhorro(cuentaFamAhorro.getIdCuentaFamAhorro()); 
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void guardarMovimientoCuentaFamAhorroIndividual(
			MovimientoFamAhorro movimientoFamAhorro) {
		// TODO Auto-generated method stub
		if (movimientoFamAhorro.getTipoMovimientoFamAhorro().equals("RETIRO"))
			this.movimientoFamAhorroDao.guardarMovimientoRetiroCuentaFamAhorroIndividual(movimientoFamAhorro);
		else
			this.movimientoFamAhorroDao.guardarMovimientoCuentaFamAhorroIndividual(movimientoFamAhorro);
		
	}

	@Override
	public void guardarMovimientoRetiroFamAhorroIndividual(
			MovimientoFamAhorro movimientoFamAhorro) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actualizarMontoDescuentoFAM(MontoDescuentoCuentaFam montoDescuentoCuentaFam){
		this.cuentaFamAhorroDao.actualizarMontoDescuentoFAM(montoDescuentoCuentaFam);
	}
}
