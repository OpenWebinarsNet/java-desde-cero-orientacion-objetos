package interfaces;

public class Usuario {
	
	private String username;
	private String email;
	private Valoracion[] valoraciones;
	private int cantidadValoraciones;
	
	
	public Usuario(String username) {
		this.username = username;
		cantidadValoraciones = 0;
		valoraciones = new Valoracion[10];
	}
	
	public Usuario(String username, String email) {
		this(username);
		this.email = email;
	}
	
	public void agregarValoracion(Valoracion valoracion) {
        if (cantidadValoraciones < valoraciones.length) {
            valoraciones[cantidadValoraciones] = valoracion;
            cantidadValoraciones++;
        } else {
            System.out.println("No se pueden agregar más valoraciones");
        }
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Valoracion[] getValoraciones() {
		return valoraciones.clone();
	}

	public int getCantidadValoraciones() {
		return cantidadValoraciones;
	}
	
	
	
	
	

}
