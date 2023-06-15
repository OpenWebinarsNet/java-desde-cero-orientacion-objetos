package interfaces;

public class Valoracion {
	
	private Usuario usuario;
	private Valorable valorable;
	private int puntuacion;
	
	
	public Valoracion(Usuario usuario, Valorable valorable, int puntuacion) {
		this.usuario = usuario;
		this.valorable = valorable;
		this.puntuacion = puntuacion;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Valorable getValorable() {
		return valorable;
	}


	public void setValorable(Valorable valorable) {
		this.valorable = valorable;
	}


	public int getPuntuacion() {
		return puntuacion;
	}


	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	
	
	
	

}
