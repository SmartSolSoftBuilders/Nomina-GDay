package mx.nomina.gday.modelo;

public class NominaRazones {
	
	private int idNomina;
	private int idRazonSocial;
	private float porcentaje;
	
	
	public NominaRazones(){
	}
	
	public NominaRazones(int idNomina, int idRazonSocial, float porcentaje) {
		super();
		this.idNomina = idNomina;
		this.idRazonSocial = idRazonSocial;
		this.porcentaje = porcentaje;
	}
	
	
	public int getIdNomina() {
		return idNomina;
	}
	public void setIdNomina(int idNomina) {
		this.idNomina = idNomina;
	}
	public int getIdRazonSocial() {
		return idRazonSocial;
	}
	public void setIdRazonSocial(int idRazonSocial) {
		this.idRazonSocial = idRazonSocial;
	}
	public float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	

}
