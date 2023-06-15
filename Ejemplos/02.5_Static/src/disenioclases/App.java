package disenioclases;

public class App {

	public static void main(String[] args) {
		
		Producto p1 = new Producto("Boligrafo", 1.25);
		Producto p2 = new Producto("Cartulina", 2.30);
		
		System.out.println(Producto.getNumeroProductos());
			
		
		System.out.println(Calculadora.suma(3.2, 2.3));

	}

}
