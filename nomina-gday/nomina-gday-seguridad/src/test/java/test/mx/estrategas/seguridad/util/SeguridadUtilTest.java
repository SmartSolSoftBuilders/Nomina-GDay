package test.mx.estrategas.seguridad.util;

import mx.estrategas.seguridad.modelo.UsuarioSeguridad;
import mx.estrategas.seguridad.util.SeguridadUtil;

import org.junit.Assert;
import org.junit.Test;

import test.mx.estrategas.seguridad.SeguridadBaseTest;

public class SeguridadUtilTest extends SeguridadBaseTest {

	@Test
	public void getUsuarioActualTest(){
		UsuarioSeguridad usuario = SeguridadUtil.getUsuarioActual();
		
		Assert.assertNotNull(usuario);
	}
}
