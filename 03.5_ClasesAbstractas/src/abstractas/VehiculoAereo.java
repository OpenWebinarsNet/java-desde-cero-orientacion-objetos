package abstractas;

public abstract class VehiculoAereo extends Vehiculo {

	private int alturaMaxima;
	
	public VehiculoAereo(String marca, String modelo, int alturaMaxima) {
		super(marca, modelo);
		this.alturaMaxima = alturaMaxima;
	}

	@Override
	public void conducir() {
		System.out.println("Realmente se llama pilotar");
	}
	
	@Override
	public void mostrarInformacion() {
		super.mostrarInformacion();
		System.out.println("Altura máxima: " + this.alturaMaxima);
	}

	public abstract void despegar();
	
	public abstract void aterrizar();

}
