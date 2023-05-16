package agregacion;

import java.util.Arrays;

public class CarritoCompra {
	
	private Producto[] carrito;
	private int cantidadProductos;
	
	public CarritoCompra() {
		carrito = new Producto[25];
		cantidadProductos = 0;
	}
	
	public Producto[] getProductos() {
		return Arrays.copyOf(carrito, cantidadProductos);
	}
	
	public void addProducto(Producto p) {
		carrito[cantidadProductos++] = p;
	}
	
	public void vaciarCarrito() {
		for(int i = 0; i < cantidadProductos; i++) {
			carrito[i] = null;
		}
	}

}
