package agregacion;

public class AppAgregacion {

	public static void main(String[] args) {

		Producto p1 = new Producto("Bolígrafo", 1.25);
		Producto p2 = new Producto("Paquete 500 hojas", 3.65);
		
		CarritoCompra c = new CarritoCompra();
		c.addProducto(p1);
		c.addProducto(p2);
		
		System.out.println("Productos en el carrito de la compra");
		for(Producto p : c.getProductos()) {
			System.out.println("%s (%.2f)".formatted(p.getNombre(), p.getPrecio()));
		}
		
	}

}
