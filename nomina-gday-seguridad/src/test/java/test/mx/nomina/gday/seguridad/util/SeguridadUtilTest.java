package test.mx.nomina.gday.seguridad.util;

import mx.nomina.gday.seguridad.modelo.UsuarioSeguridad;
import mx.nomina.gday.seguridad.util.SeguridadUtil;

import org.junit.Assert;
import org.junit.Test;

import test.mx.nomina.gday.seguridad.SeguridadBaseTest;

public class SeguridadUtilTest extends SeguridadBaseTest {

	@Test
	public void getUsuarioActualTest(){
		UsuarioSeguridad usuario = SeguridadUtil.getUsuarioActual();
		
		Assert.assertNotNull(usuario);
	}
}
