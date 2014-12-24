package mx.estrategas.seguridad.servicios;

import java.util.List;

import mx.estrategas.seguridad.modelo.ModuloMenu;
import mx.estrategas.seguridad.modelo.OpcionMenu;

import org.springframework.security.access.prepost.PostFilter;

public interface MenuSeguridadServicio {

	/**
	 * Obtiene una lista de Módulos de la aplicación, per sólo si
	 * el usuario tiene acceso a los mismos.
	 * 
	 * Este filtrado se hace por medio de la anotación {@link PostFilter} de
	 * Spring Security.
	 * 
	 * @return List<ModuloMenu> Lista de módulos 
	 */
	@PostFilter("hasPermission(filterObject, 'read')")
	List<ModuloMenu> consultarModulos(); 
	
	OpcionMenu consultarOpcionSubOpciones(Long idPadre);
	
	ModuloMenu consultarModuloMenu(Long idModulo);
}
