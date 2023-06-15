package interfaces;

public class ImagenJPG extends Imagen {

	public ImagenJPG(long width, long height) {
		super(width, height);
		
	}

	// Imagen <= 5 Megapixels
	// 2,560×1,920 con aspect ratio 16:9
	
	@Override
	public boolean isValid() {
		return width*height <= 5_000_000;
	}

}
