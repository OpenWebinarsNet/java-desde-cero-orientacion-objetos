package interfaces;

public class ReproductorMultimedia implements Reproductor{
	
	private Reproducible actual;
	private Reproducible[] lista;
	private int cantidadReproducibles;
	
	
	public ReproductorMultimedia() {
		cantidadReproducibles = 0;
	}
	
	public ReproductorMultimedia(Reproducible[] lista) {
		this.lista = lista;
		cantidadReproducibles = lista.length;
		actual = lista[0];
	}
	

	@Override
	public void cargar(Reproducible r) {
		actual = r;
		
	}

	@Override
	public void reproducir() {
		this.reproducir(actual);
		
	}

	@Override
	public void parar() {
		actual = null;	
	}

}
