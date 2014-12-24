package test.mx.estrategas.seguridad.dao;

import java.util.List;

import mx.estrategas.seguridad.dao.SeguridadDao;
import mx.estrategas.seguridad.modelo.UsuarioSeguridad;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.mx.estrategas.seguridad.SeguridadBaseTest;

public class SeguridadDaoTest extends SeguridadBaseTest {
	
	@Autowired
	private SeguridadDao seguridadDao;
	
	@Test
	public void dependenciaTest(){
		Assert.assertNotNull(seguridadDao);
	}
	
	@Test
	public void consultarUsariosTest(){
		List<UsuarioSeguridad> usuarios =
				seguridadDao.consultarUsuarios();
		
		Assert.assertFalse(usuarios.isEmpty());
	}
	
	@Test
	public void consultarUsuarioConRolesTest(){
		UsuarioSeguridad usuario =
				seguridadDao.consultarUsuarioConRoles("brian");
		
		Assert.assertNotNull(usuario);
		Assert.assertFalse(usuario.getRoles().isEmpty());
		Assert.assertEquals(2 ,usuario.getRoles().size());
	}
	
	@Test
	public void consultarUsuariosConRolesTest(){
		List<UsuarioSeguridad> usuarios =
				seguridadDao.consultarUsuariosConRoles();
		
		Assert.assertNotNull(usuarios);
		Assert.assertFalse(usuarios.isEmpty());
		Assert.assertEquals(3 ,usuarios.size());
	}
}
