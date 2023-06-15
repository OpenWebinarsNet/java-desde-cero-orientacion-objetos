package hotel.gestion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;

import hotel.UtilFechas;
import hotel.economia.Reserva;
import hotel.habitaciones.Habitacion;
import hotel.habitaciones.HabitacionDoble;
import hotel.habitaciones.Suite;
import hotel.personas.Cliente;
import hotel.personas.Huesped;

public class Hotel {

	private Habitacion[] habitaciones;
	private Reserva[] reservas;
	private int cantidadReservas;

	
	/*
	 * Constructor por defecto. Inicia las estructuras necesarias
	 */
	public Hotel() {
		// El hotel es pequeño y tendrá solamente 10 habitaciones
		habitaciones = new Habitacion[10];
		reservas = new Reserva[100];
		cantidadReservas = 0;
		init();
	}

	/*
	 * Método que carga las habitaciones del hotel
	 */
	private void init() {

		// Inicializar 8 habitaciones dobles
		for (int i = 0; i < 8; i++) {
			int numero = i + 1; // Número de habitación del 1 al 8
			String descripcion = "Habitación doble estándar";
			habitaciones[i] = new HabitacionDoble(numero, descripcion);
		}

		String[] nombresSuites = { "Mil y una noches", "Palacio Dorado" };

		// Inicializar 2 suites
		Random random = new Random();
		for (int i = 0; i < 2; i++) {
			int numero = 9 + i; // Número de habitación del 9 al 10
			String descripcion = "Suite de lujo";
			String nombre = "Suite " + nombresSuites[i];
			int plazas = random.nextInt(3) + 3; // Entre 3 y 5 plazas
			String serviciosExtra = "Servicio de minibar, Acceso gratuíto al spa";
			habitaciones[i + 8] = new Suite(numero, descripcion, nombre, plazas, serviciosExtra);
		}

	}

	/*
	 * Devuelve una copia de las habitaciones, por si se quieren consultar.
	 */
	public Habitacion[] getHabitaciones() {
		return habitaciones.clone();
	}

	/*
	 * Se muestran los detalles de cada habitación del hotel
	 */
	public void mostrarHabitaciones() {
		
		System.out.println("HABITACIONES DEL HOTEL");
		System.out.println("======================");
		System.out.println();

		for (Habitacion h : habitaciones) {

			String tipo = (h instanceof HabitacionDoble) ? "Habitación Doble" : "Suite";

			System.out.println("Habitación nº " + h.getNumero());
			System.out.println("Tipo: " + tipo);
			System.out.println("Precio por noche: %.2f€".formatted(h.getPrecio()));
			System.out.println("Descripción: " + h.getDescripcion());

			if (h instanceof Suite s) {
				System.out.println("Nombre: " + s.getNombre());
				System.out.println("Número de plazas: " + s.getNumeroPlazas());
				System.out.println("Servicios extra: " + s.getServiciosExtra());
			}

			String disponibilidad = (this.isHabitacionDisponible(h.getNumero(), LocalDate.now(), 1)) ? "Sí" : "No";
			System.out.println("Disponible hoy: " + disponibilidad);

			System.out.println();

		}

	}

	/*
	 * Para llamar a este método debemos haber comprobado antes que se puede hacer 
	 * la reserva en esa habitación.
	 */
	public Reserva agregarReserva(Cliente cliente, Huesped[] huespedes, LocalDate fechaInicio, int numeroDias,
			Habitacion habitacion) {
		if (cantidadReservas >= reservas.length) {
			// Ampliamos el array.
			reservas = Arrays.copyOf(reservas, cantidadReservas + 10);
		}
		Reserva r = new Reserva(fechaInicio, numeroDias, cliente, huespedes, habitacion);
		reservas[cantidadReservas++] = r;
		return r;
	}

	/*
	 * Devuelve la reserva si ha podido realizarse, null en otro caso.
	 */
	public Reserva agregarReserva(Cliente cliente, Huesped[] huespedes, LocalDate fechaInicio, int numeroDias,
			String tipoHabitacion) {

		// Buscamos si hay una habitación disponible para nosotros hoy.
		Habitacion[] disponibles = getHabitacionesDisponibles(tipoHabitacion, fechaInicio, numeroDias);
		Reserva r = null;

		if (disponibles.length > 0) {

			// Revisamos si el número de huéspedes se puede alojar.
			if (tipoHabitacion.toUpperCase() == "DOBLE")
				if (huespedes.length > 1) {
					System.out.println("No se pueden alojar más de 2 personas en una habitación doble");
					return r;
				} else {
					// Escogemos la primera habitación disponible
					r = agregarReserva(cliente, huespedes, fechaInicio, numeroDias, disponibles[0]);
				}
			else {
				// Si es SUITE, comprobamos si caben los huéspedes habitación a habitación
				for(int i = 0; i < disponibles.length && r == null; i++) {
					Suite s = (Suite) disponibles[i];
					if (s.getNumeroPlazas() >= huespedes.length + 1) { // Cliente + Huéspedes
 						r = agregarReserva(cliente, huespedes, fechaInicio, numeroDias, disponibles[i]);
					}
				}
				// La reserva no se ha hecho, puesto que no hay suites disponibles con esa capacidad
				if (r == null)
					System.out.println("Lo sentimos pero no hay ninguna suite disponible con esa capacidad");
			}

		} else {
			System.out.println("Lo sentimos, pero no hay habitaciones disponibles");
		}

		return r;
	}
	
	
	/*
	 * Se muestran todas las reservas realizadas
	 */
	public void mostrarReservas() {
		
		System.out.println("RESERVAS DEL HOTEL");
		System.out.println("==================");
		System.out.println();
		
		if (cantidadReservas == 0) {
			System.out.println("El hotel no dispone aun de reservas realizadas");
		}
		
		for(int i = 0; i < cantidadReservas; i++) {
			Reserva r = reservas[i];
			System.out.println("RESERVA");
			System.out.println("-------");
			System.out.println("Cliente: " + r.getCliente().getNombre());
			System.out.println("DNI: " + r.getCliente().getDni());
			System.out.println("Nº Huéspedes: " + (r.getHuesped().length + 1));
			System.out.println("Llegada: " + r.getFechaInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			System.out.println("Salida: " + r.getFechaFin().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			System.out.println("Nº días: " + r.getNumeroDias());
			System.out.println("Importe: " + r.getImporte());
			System.out.println();
		}
		
		System.out.println();
	}

	public boolean isHabitacionDisponible(int numero, LocalDate fecha, int numeroDias) {
		boolean disponible = true;
		int i = 0;
		while(i < cantidadReservas && disponible) {
			Reserva r = reservas[i];
			if (r.getHabitacion().getNumero() == numero)
				disponible = !UtilFechas.overlaps(r.getFechaInicio(), r.getFechaFin(), 
						fecha, fecha.plusDays(numeroDias));
			i++;
		}
		return disponible;
	}

	/*
	 * Tipo debe ser DOBLE o SUITE
	 */
	public Habitacion[] getHabitacionesDisponibles(String tipo, LocalDate fecha, int numeroDias) {
		Habitacion[] result = new Habitacion[10];
		int cantidad = 0;
		for (Habitacion h : habitaciones) {
			if (this.isHabitacionDisponible(h.getNumero(), fecha, numeroDias))
				if (tipo.toUpperCase() == "DOBLE") {
					if (h instanceof HabitacionDoble)
						result[cantidad++] = h;
				} else {
					if (h instanceof Suite)
						result[cantidad++] = h;
				}
		}
		return Arrays.copyOf(result, cantidad);
	}

}
