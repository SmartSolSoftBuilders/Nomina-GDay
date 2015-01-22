package mx.nomina.gday.modelo;

public class RepresentanteLegalePleitoCobranza extends BaseModelo{
	
	private Integer idRepLegPleiCob;
	private String nombreRepLegPleiCob;
	
	public RepresentanteLegalePleitoCobranza(){
		
	}
	
	public RepresentanteLegalePleitoCobranza(Integer idRepLegPleiCob,
			String nombreRepLegPleiCob) {
		super();
		this.idRepLegPleiCob = idRepLegPleiCob;
		this.nombreRepLegPleiCob = nombreRepLegPleiCob;
	}

	public Integer getIdRepLegPleiCob() {
		return idRepLegPleiCob;
	}

	public void setIdRepLegPleiCob(Integer idRepLegPleiCob) {
		this.idRepLegPleiCob = idRepLegPleiCob;
	}

	public String getNombreRepLegPleiCob() {
		return nombreRepLegPleiCob;
	}

	public void setNombreRepLegPleiCob(String nombreRepLegPleiCob) {
		this.nombreRepLegPleiCob = nombreRepLegPleiCob;
	}
	
}
