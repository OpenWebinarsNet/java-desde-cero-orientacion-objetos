package interfaces;

public class Negocio extends ValorableAbstracto {
	
	private String nombre, ciudad;

	public Negocio(String nombre, String ciudad) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
	

}
