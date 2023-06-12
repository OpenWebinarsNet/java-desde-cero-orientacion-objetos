package interfaces;

public sealed interface Validable permits Documento, Imagen, Video {
	
	
	boolean isValid();

}
