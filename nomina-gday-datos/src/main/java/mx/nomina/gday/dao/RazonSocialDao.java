package mx.nomina.gday.dao;

import mx.nomina.gday.modelo.RazonSocial;

public interface RazonSocialDao {

	RazonSocial ConsultarRazonSocial();
	RazonSocial CrearRazonSocial();
	RazonSocial ModificaRazonSocial();
	RazonSocial ConsultarNominasAsignadas();
}
