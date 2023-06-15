package orientacionobjetos;

import java.util.Objects;

public class Producto {
	
	private long codigo;
	private String nombre;
	private String descripcion;
	private double precio;
	
	
	public Producto() { }
	
	public Producto(long codigo, String nombre, String descripcion, double precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public String precioLiteral() {
		String resultado;
		
		if (precio > 0 && precio < 1.0)
			resultado = "GANGA";
		else if (precio >= 1.0 && precio < 10)
			resultado = "NORMAL";
		else
			resultado = "LUJO";
		
		return resultado;
		
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, descripcion, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return codigo == other.codigo && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
				+ precio + "]";
	}
	
	
	
	
	

}
