package mx.nomina.gday.servicios;

import java.util.List;

import mx.nomina.gday.modelo.Grupo;
import mx.nomina.gday.modelo.RazonSocial;

public interface RazonSocialServicio {
	
	public List<RazonSocial> obtenerRazonesSociales(); 
	public boolean agregarRazonSocial(RazonSocial razonSocial);
	void actualizarRazonSocial(RazonSocial razonSocial);
	public RazonSocial obtenerRazonSocialById(int idRazonSocial);

}
