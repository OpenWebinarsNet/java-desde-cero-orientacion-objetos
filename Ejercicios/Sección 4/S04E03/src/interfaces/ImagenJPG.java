package interfaces;

public class ImagenJPG extends FicheroAbstracto implements Reproducible {

	public ImagenJPG(String nombre) {
		super(nombre, "JPG");
	}

	@Override
	public void reproducir() {
		System.out.println("Mostrando la imagen JPG durante 7 segundos");
	}

	@Override
	public int getDuracion() {
		return 7;
	}

}
