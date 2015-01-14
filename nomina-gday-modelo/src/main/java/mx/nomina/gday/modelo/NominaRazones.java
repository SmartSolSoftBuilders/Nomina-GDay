package mx.nomina.gday.modelo;

public class NominaRazones extends BaseModelo{
	
	private Nomina nomina;
	private RazonSocial razonSocial;
	private float porcentaje;
	
	
	public NominaRazones(){
	}


	public NominaRazones(Nomina nomina, RazonSocial razonSocial,
			float porcentaje) {
		super();
		this.nomina = nomina;
		this.razonSocial = razonSocial;
		this.porcentaje = porcentaje;
	}


	public Nomina getNomina() {
		return nomina;
	}


	public void setNomina(Nomina nomina) {
		this.nomina = nomina;
	}


	public RazonSocial getRazonSocial() {
		return razonSocial;
	}


	public void setRazonSocial(RazonSocial razonSocial) {
		this.razonSocial = razonSocial;
	}


	public float getPorcentaje() {
		return porcentaje;
	}


	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
	
		
	

}
