package mx.nomina.gday.modelo;

public class Grupo extends BaseModelo {
	
	private Integer idGrupo;
	private String  nombre;
	private String nombreCorto;
	
	
	public Grupo(){
	}


	public Grupo(Integer idGrupo, String nombre, String nombreCorto) {
		this.idGrupo = idGrupo;
		this.nombre = nombre;
		this.nombreCorto = nombreCorto;
	}


	public Integer getIdGrupo() {
		return idGrupo;
	}


	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getNombreCorto() {
		return nombreCorto;
	}


	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

}
