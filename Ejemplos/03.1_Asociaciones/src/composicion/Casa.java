package composicion;

public class Casa {
	
	private Habitacion[] habitaciones;
	private int cantidadHabitaciones;
	

	public Casa() {
		habitaciones = new Habitacion[6];
		cantidadHabitaciones = 0;
	}
	
	public Casa(int numeroHabitaciones) {
		habitaciones = new Habitacion[numeroHabitaciones];
		cantidadHabitaciones = 0;
	}
	
	public void agregarHabitacion(Habitacion h) {
		habitaciones[cantidadHabitaciones++] = h;
	}
	
	
}
