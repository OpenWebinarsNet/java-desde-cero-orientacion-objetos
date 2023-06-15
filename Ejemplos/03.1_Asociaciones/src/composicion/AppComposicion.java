package composicion;

public class AppComposicion {

	public static void main(String[] args) {
		
		Casa miCasa = new Casa();
		miCasa.agregarHabitacion(new Habitacion(1, "Dormitorio"));
		miCasa.agregarHabitacion(new Habitacion(2, "Baño"));
		miCasa.agregarHabitacion(new Habitacion(3, "Sala de estar"));
		
		
	}

}
