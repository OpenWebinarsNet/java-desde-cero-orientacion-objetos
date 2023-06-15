package interfaces;

public class AudioMp3 extends FicheroAbstracto implements Reproducible {

	private int duracion;
	
	public AudioMp3(String nombre, int duracion) {
		super(nombre, "MP3");
		this.duracion = duracion;
	}

	@Override
	public void reproducir() {
		System.out.println("Reproduciendo todo el contenido del fichero");
		
	}

	@Override
	public int getDuracion() {
		return duracion;
	}

}
