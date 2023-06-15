package interfaces;

public abstract class FicheroAbstracto implements Fichero {

	protected String nombre;
	protected String formato;
	
	
	public FicheroAbstracto(String nombre, String formato) {
		this.nombre = nombre;
		this.formato = formato;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public String getFormato() {
		return formato;
	}
	
	

}
