package mx.nomina.gday.modelo;

public class RepresentanteLegalLaboral extends BaseModelo{
	
	private Integer idRepLegLab;
	private String nombreRepLegLab;
	
	public RepresentanteLegalLaboral(){
		
	}
	
	public RepresentanteLegalLaboral(Integer idRepLegLab,
			String nombreRepLegLab) {
		super();
		this.idRepLegLab = idRepLegLab;
		this.nombreRepLegLab = nombreRepLegLab;
	}

	public Integer getIdRepLegLab() {
		return idRepLegLab;
	}

	public void setIdRepLegLab(Integer idRepLegLab) {
		this.idRepLegLab = idRepLegLab;
	}

	public String getNombreRepLegLab() {
		return nombreRepLegLab;
	}

	public void setNombreRepLegLab(String nombreRepLegLab) {
		this.nombreRepLegLab = nombreRepLegLab;
	}

}
