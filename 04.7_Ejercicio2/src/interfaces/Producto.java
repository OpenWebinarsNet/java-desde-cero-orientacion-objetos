package interfaces;

public class Producto implements Vendible {
	 private String nombre;
	 private String categoria;
	 private double precio;

	 public Producto(String nombre, String categoria, double precio) {
	     this.nombre = nombre;
	     this.categoria = categoria;
	     this.precio = precio;
	 }

	 @Override
	 public double getPrecio() {
	     return precio;
	 }

	public String getNombre() {
		return nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	 
	 
}
