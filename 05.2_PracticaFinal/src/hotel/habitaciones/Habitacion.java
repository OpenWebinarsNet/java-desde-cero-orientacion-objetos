package hotel.habitaciones;

import java.util.Objects;

public abstract class Habitacion {
	
	protected int numero;
	protected double precio;
	protected String descripcion;
	
	public Habitacion(int numero, double precio, String descripcion) {
		this.numero = numero;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	
	public int getNumero() {
		return numero;
	}
	public double getPrecio() {
		return precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, numero, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Habitacion other = (Habitacion) obj;
		return Objects.equals(descripcion, other.descripcion) && numero == other.numero
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}

	@Override
	public String toString() {
		return "Habitacion [numero=" + numero + ", precio=" + precio + ", descripcion=" + descripcion + "]";
	}
	
	
	
	

}
