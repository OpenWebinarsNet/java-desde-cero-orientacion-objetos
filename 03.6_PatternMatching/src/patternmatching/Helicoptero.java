package patternmatching;

public class Helicoptero extends VehiculoAereo {

	public Helicoptero(String marca, String modelo, int alturaMaxima) {
		super(marca, modelo, alturaMaxima);
	}

	@Override
	public void despegar() {
		System.out.println("Un helicóptero que despega en vertical");
	}

	@Override
	public void aterrizar() {
		System.out.println("Un helicóptero que aterriza en vertical");

	}
	
	public void realizarRescate() {
		System.out.println("Estoy transportando pasajeros para realizar un rescate");
	}

}
