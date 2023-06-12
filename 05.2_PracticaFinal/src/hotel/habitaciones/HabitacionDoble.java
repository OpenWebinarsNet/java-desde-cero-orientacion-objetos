package hotel.habitaciones;

import hotel.economia.Precios;

public class HabitacionDoble extends Habitacion {

	public HabitacionDoble(int numero, String descripcion) {
		super(numero, Precios.PRECIO_DOBLE, descripcion);
	}

}
