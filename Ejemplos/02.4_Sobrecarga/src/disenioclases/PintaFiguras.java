package disenioclases;

public class PintaFiguras {

	public void pintar(Linea l) {
		System.out.println("*".repeat(l.getLongitud()));
	}

	public void pintar(Triangulo t) {
		// Iterar sobre las filas del triángulo
		for (int i = 0; i < t.getLado(); i++) {

			// Imprimir espacios en blanco antes de los asteriscos			
			System.out.print(" ".repeat(t.getLado() - i));

			// Imprimir asteriscos para formar el triángulo
			System.out.print("* ".repeat(i));

			// Ir a la siguiente línea después de cada fila
			System.out.println();
		}
		System.out.println();

	}

	public void pintar(Rectangulo r) {
		int base = (int) Math.round(r.base());
		int altura = (int) Math.round(r.altura());

		String pintura = "*";
		
		System.out.println(pintura.repeat(base));

		if (altura > 2) {
			for (int i = 0; i < altura - 2; i++) {
				System.out.print(pintura);
				if (base > 2) {
					System.out.print(" ".repeat(base - 2));
				}
				System.out.println(pintura);
			}
		}

		System.out.println(pintura.repeat(base));

	}
	

}
