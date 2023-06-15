package composicion;

import java.util.Objects;

public class Habitacion {
	
	private int numero;
    private String tipo;

    public Habitacion(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

	public int getNumero() {
		return numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero, tipo);
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
		return numero == other.numero && Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString() {
		return "Habitacion [numero=" + numero + ", tipo=" + tipo + "]";
	}

    

}
