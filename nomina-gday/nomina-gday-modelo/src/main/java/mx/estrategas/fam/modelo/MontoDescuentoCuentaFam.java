package mx.estrategas.fam.modelo;

import java.util.Date;

public class MontoDescuentoCuentaFam extends BaseModelo {
	private int idMontoDescuentoCuentaFam;
	private float monto;
	private Date fechaRegistro;
	
	public int getIdMontoDescuentoCuentaFam() {
		return idMontoDescuentoCuentaFam;
	}


	public void setIdMontoDescuentoCuentaFam(int idMontoDescuentoCuentaFam) {
		this.idMontoDescuentoCuentaFam = idMontoDescuentoCuentaFam;
	}


	public float getMonto() {
		return monto;
	}


	public void setMonto(float monto) {
		this.monto = monto;
	}


	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public MontoDescuentoCuentaFam(){
		
	}


	public MontoDescuentoCuentaFam(int idMontoDescuentoCuentaFam, float monto,
			Date fechaRegistro) {
		super();
		this.idMontoDescuentoCuentaFam = idMontoDescuentoCuentaFam;
		this.monto = monto;
		this.fechaRegistro = fechaRegistro;
	}
	
	

}
