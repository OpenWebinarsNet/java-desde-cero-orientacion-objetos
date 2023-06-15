package interfaces;

public class VideoH264 extends FicheroAbstracto implements Reproducible {

	private int duracion;
	
	public VideoH264(String nombre, int duracion) {
		super(nombre, "H.264");
	}

	@Override
	public void reproducir() {
		System.out.println("Reproduciendo todo el contenido del vídeo");
		
	}

	@Override
	public int getDuracion() {
		return duracion;
	}
	
	

}
