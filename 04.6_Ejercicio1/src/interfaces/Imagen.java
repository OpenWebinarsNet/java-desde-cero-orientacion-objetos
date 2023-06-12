package interfaces;

public abstract non-sealed class Imagen implements Validable {
	
	protected long width;
	protected long height;
	
	
	public long getWidth() {
		return width;
	}


	public long getHeight() {
		return height;
	}


	public void setWidth(long width) {
		this.width = width;
	}


	public void setHeight(long height) {
		this.height = height;
	}


	public Imagen(long width, long height) {
		this.width = width;
		this.height = height;
	}
	
	

}
