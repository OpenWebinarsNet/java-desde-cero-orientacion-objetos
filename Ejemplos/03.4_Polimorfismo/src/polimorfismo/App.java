package polimorfismo;

public class App {

	public static void main(String[] args) {

		Poligono p = new Poligono();
		Triangulo t = new Triangulo(5);
		Rectangulo r = new Rectangulo(10, 5);
		
		
		PintaFiguras.pintar(p);
		PintaFiguras.pintar(t);
		PintaFiguras.pintar(r);

		// Otra sintaxis
		Poligono[] arr = new Poligono[]{p, t, r};
		
		for(Poligono poligono : arr) {
			PintaFiguras.pintar(poligono);
		}
		
	}

}
