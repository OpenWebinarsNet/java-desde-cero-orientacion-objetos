package simple;

public class PersonajeDeAccion implements PuedeLuchar, PuedeVolar{

	@Override
	public void saltar() {
		System.out.println("Saltando...");
	}

	@Override
	public void volar() {
		System.out.println("Volando...");
	}

	@Override
	public void luchar() {
		System.out.println("Luchando...");
	}

}
