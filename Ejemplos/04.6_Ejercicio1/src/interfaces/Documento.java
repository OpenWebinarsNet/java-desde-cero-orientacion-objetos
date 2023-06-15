package interfaces;

public abstract non-sealed class Documento implements Validable {

	protected long size;
	

	public Documento(long size) {
		this.size = size;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
	
	
	
	
}
