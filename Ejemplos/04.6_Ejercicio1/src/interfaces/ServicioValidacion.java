package interfaces;

public class ServicioValidacion {
	
	private Validable[] validables;
	private int cantidadValidables;
	
	public ServicioValidacion() {
		validables = new Validable[10];
		cantidadValidables = 0;
	}
	
	public ServicioValidacion(int length) {
		validables = new Validable[length];
		cantidadValidables = 0;
	}
	
	public ServicioValidacion(Validable[] array) {
		validables = array.clone();
		cantidadValidables = array.length;
	}

	public boolean validarTodos() {
		boolean resultado = true;
		for(int i = 0; i < cantidadValidables; i++) {
			resultado = resultado && validables[i].isValid();
		}
		return resultado;
	}
	
	public static boolean validar(Validable v) {
		return v.isValid();
	}
}
