package mx.estrategas.fam.dao;

import java.util.List;

import mx.estrategas.fam.modelo.AseguradoBeneficioAdicional;

public interface AseguradoBeneficioAdicionalDao {	
	void guardarAseguradoBeneficioAdicional(AseguradoBeneficioAdicional aseguradoBeneficioAdicional);
	void actualizarAseguradoBeneficioAdicional(	AseguradoBeneficioAdicional aseguradoBeneficioAdicional);
	void eliminarAseguradoBeneficioAdicional(AseguradoBeneficioAdicional aseguradoBeneficioAdicional);
	List<AseguradoBeneficioAdicional> obtenerAseguradosBeneficioAdicionalById(int id);	
}
