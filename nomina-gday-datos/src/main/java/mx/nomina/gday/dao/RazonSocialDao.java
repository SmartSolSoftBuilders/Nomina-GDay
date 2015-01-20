package mx.nomina.gday.dao;

import java.util.List;

import mx.nomina.gday.modelo.RazonSocial;

public interface RazonSocialDao {

	public List<RazonSocial> obtenerRazonesSociales();
	public int agregarRazonSocial(RazonSocial razonSocial);
	void actualizarRazonSocial(RazonSocial razonSocial);
	public RazonSocial obtenerRazonSocialById(int id);


}
