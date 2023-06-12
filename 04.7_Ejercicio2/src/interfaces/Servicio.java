package interfaces;

public class Servicio implements Vendible {
	private String nombre;
	private String tipo;
	private int duracionMinutos;

	public Servicio(String nombre, String tipo, int duracionMinutos) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.duracionMinutos = duracionMinutos;
	}

	@Override
	public double getPrecio() {
		double precioMinuto = switch (tipo) {
		case "PINTURA" -> 0.75;
		case "ELECTRICIDAD" -> 1.0;
		case "FONTANERÍA" -> 1.25;
		default -> 1.5;
		};
		return precioMinuto * duracionMinutos;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public int getDuracionMinutos() {
		return duracionMinutos;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setDuracionMinutos(int duracionMinutos) {
		this.duracionMinutos = duracionMinutos;
	}
	
	

}
