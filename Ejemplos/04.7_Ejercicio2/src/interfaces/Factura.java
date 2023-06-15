package interfaces;

public class Factura {
	private String cliente;
	private Vendible[] elementos;

	public Factura(String cliente, Vendible[] elementos) {
		this.cliente = cliente;
		this.elementos = elementos;
	}

	public double calcularTotal() {
		double total = 0.0;
		for (Vendible vendible : elementos) {
			total += vendible.getPrecio();
		}
		return total;
	}

	public String getCliente() {
		return cliente;
	}

	public Vendible[] getElementos() {
		return elementos;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public void setElementos(Vendible[] elementos) {
		this.elementos = elementos;
	}

}
