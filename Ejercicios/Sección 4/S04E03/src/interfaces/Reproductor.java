package interfaces;

public interface Reproductor {
	
	void cargar(Reproducible r);
	
	void reproducir();
	
	default void reproducir(Reproducible r) {
		r.reproducir();
	}
	
	void parar();
	
	

}
