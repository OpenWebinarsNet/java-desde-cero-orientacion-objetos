package polimorfismo;

public class Triangulo extends Poligono {
	
	private int lado;
	
public Triangulo() { }
	
	public Triangulo(int lado) {
		this.lado = lado;
	}

	public int getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	}
	

	@Override
	public void pintar() {
		// Iterar sobre las filas del triángulo
		for (int i = 0; i < this.lado; i++) {

			// Imprimir espacios en blanco antes de los asteriscos			
			System.out.print(" ".repeat(this.lado - i));

			// Imprimir asteriscos para formar el triángulo
			System.out.print("* ".repeat(i));

			// Ir a la siguiente línea después de cada fila
			System.out.println();
		}
		System.out.println();

	}

}
