package interfaces;

public class Producto extends ValorableAbstracto {
	
	private String nombre, categoria;
	private double precio;
	
	
	public Producto(String nombre, String categoria, double precio) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	
	

}
