package mx.nomina.gday.modelo;

public class Grupo {
	
	private int idGrupo;
	private String  nombreCortoGrupo;
	private String nombreGrupo;
	
	
	public Grupo(){
	}
	
	
	public Grupo(int idGrupo, String nombreCortoGrupo, String nombreGrupo) {
		super();
		this.idGrupo = idGrupo;
		this.nombreCortoGrupo = nombreCortoGrupo;
		this.nombreGrupo = nombreGrupo;
	}
	
	public int getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}
	public String getNombreCortoGrupo() {
		return nombreCortoGrupo;
	}
	public void setNombreCortoGrupo(String nombreCortoGrupo) {
		this.nombreCortoGrupo = nombreCortoGrupo;
	}
	public String getNombreGrupo() {
		return nombreGrupo;
	}
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}
	
	

}
