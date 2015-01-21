package mx.nomina.gday.modelo;

public class TipoRegimen extends BaseModelo{

	private Integer idTipoRegimen;
	private String tipoRegimen;
	
	public TipoRegimen(){
		
	}
	
	
	public TipoRegimen(Integer idTipoRegimen, String tipoRegimen) {
		super();
		this.idTipoRegimen = idTipoRegimen;
		this.tipoRegimen = tipoRegimen;
	}


	public Integer getIdTipoRegimen() {
		return idTipoRegimen;
	}


	public void setIdTipoRegimen(Integer idTipoRegimen) {
		this.idTipoRegimen = idTipoRegimen;
	}


	public String getTipoRegimen() {
		return tipoRegimen;
	}


	public void setTipoRegimen(String tipoRegimen) {
		this.tipoRegimen = tipoRegimen;
	}
	
	

}
