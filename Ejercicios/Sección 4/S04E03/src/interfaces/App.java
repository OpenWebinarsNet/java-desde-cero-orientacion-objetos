package interfaces;

public class App {

	public static void main(String[] args) {
		
		
		VideoH264 v = new VideoH264("Avengers Endgame", 182*60);
		AudioMp3 a = new AudioMp3("19 Días y 500 noches - Joaquín Sabina", 277);
		ImagenJPG i = new ImagenJPG("foto vacaciones");
		FicheroPDF f = new FicheroPDF("Nomina");
		
		Reproductor r = new ReproductorMultimedia();
		
		r.cargar(v);
		r.reproducir();
		
		r.cargar(a);
		r.reproducir();
		
		r.cargar(i);
		r.reproducir();
		
		//r.cargar(f); // Error
		
		
		
		

	}

}
