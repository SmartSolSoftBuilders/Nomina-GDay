package mx.estrategas.fam.servicios;

import java.util.List;

import mx.estrategas.fam.dao.AfiliadoDao;
import mx.estrategas.fam.dao.AfiliadoModificacionDao;
import mx.estrategas.fam.dao.EscuelaDao;
//import mx.sep.sajja.datos.vo.FiltroBusquedaVO;
import mx.estrategas.fam.modelo.Afiliado;
import mx.estrategas.fam.modelo.CuentaFamAhorro;
import mx.estrategas.fam.modelo.Escuela;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AfiliadoServicioImpl implements AfiliadoServicio {

	@Autowired
	private AfiliadoDao afiliadoDao;
	@Autowired
	private AfiliadoModificacionDao afiliadoModificacionDao;
	@Autowired
	private EscuelaDao escuelaDao;

	@Override
	public void guardarAfiliado(Afiliado afiliado) {
		System.out.println("Guardando afiliado Service!"+afiliado);
		this.afiliadoDao.guardarAfiliado(afiliado);
		
	}

	@Override
	public List<Escuela> obtenerEscuelas() {
		// TODO Auto-generated method stub
		return this.escuelaDao.obtenerEscuelas();
	}

	@Override
	public List<Afiliado> obtenerAfiliados() {
		System.out.println("Service");
		return this.afiliadoDao.obtenerAfiliados();
	}
	
	@Override
	public List<Afiliado> obtenerAfiliadosModificacion() {
		return this.afiliadoModificacionDao.obtenerAfiliados();
	}

	@Override
	public void guardarAfiliadoModificacion(Afiliado afiliado) {
		this.afiliadoModificacionDao.guardarAfiliado(afiliado);
	}

	@Override
	public Afiliado obtenerAfiliadoById(int idAfiliado) {
		// TODO Auto-generated method stub
		return this.afiliadoDao.obtenerAfiliadoById(idAfiliado);
	}

	@Override
	public Afiliado obtenerAfiliadoModificadoById(int idAfiliado) {
		// TODO Auto-generated method stub
		return this.afiliadoModificacionDao.obtenerAfiliadoById(idAfiliado);
	}

	@Override
	public void denegarAfiliadoModificacion(int idAfiliado) {
		this.afiliadoModificacionDao.borrarAfiliado(idAfiliado);
	}
	
	@Override
	public void aprobarAfiliadoModificacion(Afiliado afiliado) {
		try{
		this.afiliadoDao.actualizarAfiliado(afiliado);
		}
		catch (Exception e1){
			System.out.println(e1.getMessage());
		}
		this.afiliadoModificacionDao.borrarAfiliado(afiliado.getIdAfiliado());
	}

	@Override
	public int getIdAfiliadoByRfc(String rfcAfiliado) {
		// TODO Auto-generated method stub
		try{
			return this.afiliadoDao.obtenerIdAfiliadoByRfc(rfcAfiliado);
		}
		catch(Exception e){
			return 0;
		}
		
	}

	@Override
	public void actualizarAfiliado(Afiliado afiliado) {
		// TODO Auto-generated method stub
		this.afiliadoDao.actualizarAfiliado(afiliado);		
	}

	@Override
	public int getCountIdAfiliadoByRfc(String rfcAfiliado) {
		// TODO Auto-generated method stub
		return this.afiliadoDao.obtenerCountIdAfiliadoByRfc(rfcAfiliado);
	}

	@Override
	public List<Afiliado> obtenerAfiliadosDetalle() {
		// TODO Auto-generated method stub
		return this.afiliadoDao.obtenerAfiliadosDetalle();
	}

	@Override
	public List<CuentaFamAhorro> obtenerCuentasFamAhorro(Afiliado afiliado) {
		// TODO Auto-generated method stub
		try{
			return this.afiliadoDao.obtenerCuentasFamAhorro(afiliado);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	
}
