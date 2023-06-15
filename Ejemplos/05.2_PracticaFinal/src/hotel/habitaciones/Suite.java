package hotel.habitaciones;

import java.util.Objects;

import hotel.economia.Precios;

public class Suite extends Habitacion {
	
	private String nombre;
	private int numeroPlazas;
	private String serviciosExtra;
	
	
	public Suite(int numero, String descripcion, String nombre, int numeroPlazas,
			String serviciosExtra) {
		super(numero, Precios.PRECIO_SUITE, descripcion);
		this.nombre = nombre;
		this.numeroPlazas = numeroPlazas;
		this.serviciosExtra = serviciosExtra;
	}


	public String getNombre() {
		return nombre;
	}


	public int getNumeroPlazas() {
		return numeroPlazas;
	}


	public String getServiciosExtra() {
		return serviciosExtra;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setNumeroPlazas(int numeroPlazas) {
		this.numeroPlazas = numeroPlazas;
	}


	public void setServiciosExtra(String serviciosExtra) {
		this.serviciosExtra = serviciosExtra;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nombre, numeroPlazas, serviciosExtra);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Suite other = (Suite) obj;
		return Objects.equals(nombre, other.nombre) && numeroPlazas == other.numeroPlazas
				&& Objects.equals(serviciosExtra, other.serviciosExtra);
	}


	@Override
	public String toString() {
		return "Suite [nombre=" + nombre + ", numeroPlazas=" + numeroPlazas + ", serviciosExtra=" + serviciosExtra
				+ ", numero=" + numero + ", precio=" + precio + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
	

}
