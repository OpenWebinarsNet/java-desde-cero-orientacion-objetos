package herencia;

import java.util.Arrays;
import java.util.Objects;

public final class Casa extends InmuebleVivienda {
	
	private int numPisos;
	
	public Casa() {
		super();
	}

	public Casa(int identificadorInmobiliario, String direccion, double precioVenta, double metrosCuadrados,
			Habitacion[] habitaciones, int numHabitaciones, int numBanios, int numPisos) {
		super(identificadorInmobiliario, direccion, precioVenta, metrosCuadrados, habitaciones, numHabitaciones,
				numBanios);
		this.numPisos = numPisos;
	}

	public int getNumPisos() {
		return numPisos;
	}

	public void setNumPisos(int numPisos) {
		this.numPisos = numPisos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numPisos);
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
		Casa other = (Casa) obj;
		return numPisos == other.numPisos;
	}

	@Override
	public String toString() {
		return "Casa [numPisos=" + numPisos + ", habitaciones=" + Arrays.toString(habitaciones) + ", numHabitaciones="
				+ numHabitaciones + ", numBanios=" + numBanios + ", identificadorInmobiliario="
				+ identificadorInmobiliario + ", direccion=" + direccion + ", precioVenta=" + precioVenta
				+ ", metrosCuadrados=" + metrosCuadrados + "]";
	}
	
	
	
	
	
	

	
	
	

}
