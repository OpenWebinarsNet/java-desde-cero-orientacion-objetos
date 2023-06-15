package interfaces;

public class Cuadrado implements Dibujable {
	
	private int lado;

	public Cuadrado(int lado) {
		this.lado = lado;
	}

	@Override
	public void dibujar() {
		for(int i = 0; i < lado; i++)
			System.out.println("*".repeat(lado));
		System.out.println();

	}

}
