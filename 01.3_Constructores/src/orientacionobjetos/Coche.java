package orientacionobjetos;

public class Coche {
	
	private String marca;
	private String modelo;
	private int anio;
	
	
	public Coche() {}
	
	public Coche(String marca, String modelo, int anio) {
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
	}
	
	/*public Coche(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
		this.anio = 2020;
	}*/
	
	public Coche(String marca, String modelo) {
		this(marca, modelo, 2020);
	}
	
	public Coche(String marca, int anio) {
		this.marca = marca;
		this.anio = anio;
	}
	
	public void arrancar() {
		System.out.println("El coche %s %s %d ha arrancado"
					.formatted(marca, modelo, anio));
	}
	

}
