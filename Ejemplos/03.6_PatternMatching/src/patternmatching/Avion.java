package patternmatching;

public class Avion extends VehiculoAereo {

	public Avion(String marca, String modelo, int alturaMaxima) {
		super(marca, modelo, alturaMaxima);
	}

	@Override
	public void despegar() {
		System.out.println("El avión despega de forma lineal");

	}

	@Override
	public void aterrizar() {
		System.out.println("El avión aterriza de forma lineal");
	}
	
	public void transportarPasajeros() {
		System.out.println("Estoy transportando pasajeros para llevarlos de viaje");
	}

}
