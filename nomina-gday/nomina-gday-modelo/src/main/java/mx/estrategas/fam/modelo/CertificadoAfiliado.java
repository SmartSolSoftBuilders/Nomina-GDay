package mx.estrategas.fam.modelo;

import java.util.Date;

public class CertificadoAfiliado extends BaseModelo {
	
	private int idCertificadoAfiliado;
	private int numeroCertificadoAfiliado;
	private String fechaInicioVigenciaCertificadoAfiliado;
	private String estadoCertificadoAfiliado;
	private int sumaAseguradaCertificadoAfiliado;
	private Afiliado afiliado;
	
	public int getIdCertificadoAfiliado() {
		return idCertificadoAfiliado;
	}
	public void setIdCertificadoAfiliado(int idCertificadoAfiliado) {
		this.idCertificadoAfiliado = idCertificadoAfiliado;
	}
	public int getNumeroCertificadoAfiliado() {
		return numeroCertificadoAfiliado;
	}
	public void setNumeroCertificadoAfiliado(int numeroCertificadoAfiliado) {
		this.numeroCertificadoAfiliado = numeroCertificadoAfiliado;
	}
	public String getFechaInicioVigenciaCertificadoAfiliado() {
		return fechaInicioVigenciaCertificadoAfiliado;
	}
	public void setFechaInicioVigenciaCertificadoAfiliado(
			String fechaInicioVigenciaCertificadoAfiliado) {
		this.fechaInicioVigenciaCertificadoAfiliado = fechaInicioVigenciaCertificadoAfiliado;
	}
	public String getEstadoCertificadoAfiliado() {
		return estadoCertificadoAfiliado;
	}
	public void setEstadoCertificadoAfiliado(String estadoCertificadoAfiliado) {
		this.estadoCertificadoAfiliado = estadoCertificadoAfiliado;
	}
	public int getSumaAseguradaCertificadoAfiliado() {
		return sumaAseguradaCertificadoAfiliado;
	}
	public void setSumaAseguradaCertificadoAfiliado(
			int sumaAseguradaCertificadoAfiliado) {
		this.sumaAseguradaCertificadoAfiliado = sumaAseguradaCertificadoAfiliado;
	}
	public Afiliado getAfiliado() {
		return afiliado;
	}
	public void setAfiliado(Afiliado afiliado) {
		this.afiliado = afiliado;
	}
	
	public CertificadoAfiliado(){		
	};
	
	public CertificadoAfiliado(int idCertificadoAfiliado,
			int numeroCertificadoAfiliado,
			String fechaInicioVigenciaCertificadoAfiliado,
			String estadoCertificadoAfiliado,
			int sumaAseguradaCertificadoAfiliado, Afiliado afiliado) {
		super();
		this.idCertificadoAfiliado = idCertificadoAfiliado;
		this.numeroCertificadoAfiliado = numeroCertificadoAfiliado;
		this.fechaInicioVigenciaCertificadoAfiliado = fechaInicioVigenciaCertificadoAfiliado;
		this.estadoCertificadoAfiliado = estadoCertificadoAfiliado;
		this.sumaAseguradaCertificadoAfiliado = sumaAseguradaCertificadoAfiliado;
		this.afiliado = afiliado;
	}
	
}
