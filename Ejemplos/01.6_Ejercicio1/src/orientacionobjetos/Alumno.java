package orientacionobjetos;

import java.util.Objects;

public class Alumno {
	
	private String nombre;
	private String apellidos;
	private String email;
	private int edad;
	private String telefono;
	
	public Alumno() { }

	public Alumno(String nombre, String apellidos, String email, int edad, String telefono) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.edad = edad;
		this.telefono = telefono;
	}

	public Alumno(String nombre, String apellidos, int edad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	
	// También así
	/*public Alumno(String nombre, String apellidos, int edad) {
		this(nombre, apellidos, null, edad, null);
	}*/

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getEmail() {
		return email;
	}

	public int getEdad() {
		return edad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public boolean esMayorEdad() {
		return (edad >= 18);
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, edad, email, nombre, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(apellidos, other.apellidos) && edad == other.edad && Objects.equals(email, other.email)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", edad=" + edad
				+ ", telefono=" + telefono + "]";
	}
	
	
	
	
	
	
	
	

}
