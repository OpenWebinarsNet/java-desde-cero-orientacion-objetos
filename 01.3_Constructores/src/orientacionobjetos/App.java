package orientacionobjetos;

public class App {

	public static void main(String[] args) {

		Coche coche = new Coche("Ford", "Focus", 2020);
		coche.arrancar();
		
		Coche otroCoche; //null
		
		var coche2 = new Coche("Seat", "Ibiza", 2021);
		coche2.arrancar();
		
	}

}
