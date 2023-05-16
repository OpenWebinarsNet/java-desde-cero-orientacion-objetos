package disenioclases;

public class App {

	public static void main(String[] args) {

		PintaFiguras pinta = new PintaFiguras();
		
		
		Linea l = new Linea(20);
		pinta.pintar(l);
		
		Triangulo t = new Triangulo(10);
		pinta.pintar(t);
		
		Rectangulo r = new Rectangulo(10, 5);
		pinta.pintar(r);
		
		
	}

}
