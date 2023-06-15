package herencia;

public final class Apartamento extends InmuebleVivienda {

	public Apartamento() {
		super();
	}

	public Apartamento(int identificadorInmobiliario, String direccion, double precioVenta, double metrosCuadrados,
			Habitacion[] habitaciones, int numHabitaciones, int numBanios) {
		super(identificadorInmobiliario, direccion, precioVenta, metrosCuadrados, habitaciones, numHabitaciones, numBanios);
	}
	
	

}
