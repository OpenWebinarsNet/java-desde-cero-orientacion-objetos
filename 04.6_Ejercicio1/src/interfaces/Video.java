package interfaces;

public abstract non-sealed class Video implements Validable {
	
	protected int length;

	public Video(int length) {
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	

}
