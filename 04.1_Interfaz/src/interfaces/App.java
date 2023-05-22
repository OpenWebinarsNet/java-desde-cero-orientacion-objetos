package interfaces;

public class App {

	public static void main(String[] args) {
		ReproductorMp3 reproductor = new ReproductorMp3();
        reproductor.reproducir();
        reproductor.pausar();
        reproductor.detener();
	}

}
