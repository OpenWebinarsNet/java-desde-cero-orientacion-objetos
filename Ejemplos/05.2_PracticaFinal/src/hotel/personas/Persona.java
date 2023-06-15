package hotel.personas;

import java.util.Objects;

public abstract class Persona {
	
	protected String nombre, dni;
	protected int edad;

	public Persona(String nombre, int edad, String dni) {
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public String getDni() {
		return dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, edad, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(edad, other.edad)
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + "]";
	}
	
	

}
