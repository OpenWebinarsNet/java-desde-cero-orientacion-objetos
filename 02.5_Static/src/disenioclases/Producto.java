package disenioclases;

public class Producto {
	
	private static int numeroProductos = 0;
	
	private String nombre;
	private double precio;
	
	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
		numeroProductos++;
	}
	
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public static int getNumeroProductos() {
		return numeroProductos;
	}
	
	

}
