package abstractas;

public class App {
	
	public static void main(String[] args) {
		
		// Produce un error
		//Vehiculo v = new Vehiculo("Marca","Modelo");
		
		Coche c = new Coche("Toyota", "Corolla", 180);
		c.mostrarInformacion();
		c.mostrarVelocidadMaxima();
		c.conducir();
		
		Helicoptero h = new Helicoptero("Airbus","Súper Puma", 6000);
		h.mostrarInformacion();
		h.despegar();
		h.conducir();
		h.aterrizar();
	}

}
