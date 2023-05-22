package interfaces;

public class App {

	public static void main(String[] args) {
		
		Recta r1 = new Recta(5);
		Cuadrado c1 = new Cuadrado(3);
		Dibujable r2 = new Recta(6);
		
		DibujadorDeFiguras.dibujaFiguras(r1);
		DibujadorDeFiguras.dibujaFiguras(c1);
		DibujadorDeFiguras.dibujaFiguras(r2);
		

	}

}
