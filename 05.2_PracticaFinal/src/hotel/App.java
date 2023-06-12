package hotel;

import java.time.LocalDate;

import hotel.economia.Reserva;
import hotel.gestion.Hotel;
import hotel.personas.Cliente;
import hotel.personas.Huesped;

public class App {
	
	public static void main(String[] args) {
		
		Hotel hotel = new Hotel();
		hotel.mostrarHabitaciones();
		
		Cliente c1 = new Cliente("Francisco García García", 35, "12345678A", "1234123412341234");
		Huesped h1 = new Huesped("Marta López Muñoz", 33, "23456789B");
		
		Reserva r1 = hotel.agregarReserva(c1, new Huesped[] {h1}, LocalDate.now(), 2, "DOBLE");
		
		if (r1 != null) {
			System.out.println("La reserva se ha realizado correctamente");
		}
		
		Cliente c2 = new Cliente("Carlos Almagro Martínez", 42, "98765432C", "2345234523452345");
		Huesped h2 = new Huesped("Lucía Sol Madrid", 40, "87654321D");
		Huesped h3 = new Huesped("Martina Almagro Sol", 12, "76576576E");
		
		Reserva r2 = hotel.agregarReserva(c2, new Huesped[] {h2, h3}, LocalDate.now(), 3, "SUITE");
		
		hotel.mostrarReservas();
		
		hotel.mostrarHabitaciones();

		
	}

}
