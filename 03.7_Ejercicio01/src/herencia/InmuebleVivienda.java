package herencia;

import java.util.Arrays;
import java.util.Objects;

public sealed abstract class InmuebleVivienda extends Inmueble permits Casa, Apartamento {

	private static final int MIN_SIZE_HABITACION = 3;

	protected Habitacion[] habitaciones;
	protected int numHabitaciones;
	protected int numBanios;
	

	public InmuebleVivienda() {
		super();
		habitaciones = new Habitacion[MIN_SIZE_HABITACION];
		numHabitaciones = 0;
	}
	
	public InmuebleVivienda(int identificadorInmobiliario, String direccion, double precioVenta, double metrosCuadrados,
			Habitacion[] habitaciones, int numHabitaciones, int numBanios) {
		super(identificadorInmobiliario, direccion, precioVenta, metrosCuadrados);
		// clonamos el array para obtener una copia limpia
		this.habitaciones = habitaciones.clone();
		this.numHabitaciones = habitaciones.length;
		this.numBanios = numBanios;
	}

	public Habitacion[] getHabitaciones() {
		// Devolvemos una copia y evitamos
		// que se pueda modificar desde fuera
		// de la clase
		return habitaciones.clone();
	}
	
	public void addHabitacion(Habitacion h) {
		if (habitaciones.length == numHabitaciones) {
			habitaciones = Arrays.copyOf(habitaciones, habitaciones.length+1);			
		}
		habitaciones[numHabitaciones++] = h;
	}
	
	public void removeHabitacion(int index) {
		if (index > 0 && index < numHabitaciones) {
			habitaciones[index] = null;
			for(int i = index+1; i < numHabitaciones-1; i++) {
				habitaciones[i] = habitaciones[i+1];
			}
			numHabitaciones--;
		}
	}

	public int getNumHabitaciones() {
		return numHabitaciones;
	}

	public int getNumBanios() {
		return numBanios;
	}

	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}

	public void setNumBanios(int numBanios) {
		this.numBanios = numBanios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(habitaciones);
		result = prime * result + Objects.hash(numBanios, numHabitaciones);
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
		InmuebleVivienda other = (InmuebleVivienda) obj;
		return Arrays.equals(habitaciones, other.habitaciones) && numBanios == other.numBanios
				&& numHabitaciones == other.numHabitaciones;
	}

	@Override
	public String toString() {
		return "InmuebleVivienda [habitaciones=" + Arrays.toString(habitaciones) + ", numHabitaciones="
				+ numHabitaciones + ", numBanios=" + numBanios + ", identificadorInmobiliario="
				+ identificadorInmobiliario + ", direccion=" + direccion + ", precioVenta=" + precioVenta
				+ ", metrosCuadrados=" + metrosCuadrados + "]";
	}
	
	
	
	
	

}
