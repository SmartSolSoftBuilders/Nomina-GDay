package test.mx.estrategas.seguridad.servicios;

import java.util.List;

import mx.estrategas.seguridad.modelo.UsuarioSeguridad;
import mx.estrategas.seguridad.servicios.MttoSeguridadServicio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.mx.estrategas.seguridad.SeguridadBaseTest;

public class MttoSeguridadServicioImplTest extends SeguridadBaseTest {
	
	@Autowired
	private MttoSeguridadServicio mttoSeguridadServicio;

	@Test
	public void dependenciaTest(){
		Assert.assertNotNull(mttoSeguridadServicio);
	}
	
	@Test
	public void consultarUsuariosTest(){
		List<UsuarioSeguridad> usuarios = mttoSeguridadServicio.consultarUsuarios();
		
		Assert.assertFalse(usuarios.isEmpty());
	}
}
