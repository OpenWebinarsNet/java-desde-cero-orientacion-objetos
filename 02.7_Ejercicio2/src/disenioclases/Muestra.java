package disenioclases;

import java.util.Arrays;

public class Muestra {
	
	public static final int DEFAULT_SIZE = 10;
	private int[] numeros;
	private int cantidadNumeros;
	
	public Muestra() {
		numeros = new int[DEFAULT_SIZE];
		cantidadNumeros = 0;
	}
	
	public Muestra(int tam) {
		numeros = new int[tam];
		cantidadNumeros = 0;
	}
	
	public Muestra(int[] array) {
		numeros = array.clone();
		cantidadNumeros = numeros.length;
	}
	
	public void agregarNumero(int n) {
		if (cantidadNumeros == numeros.length) {
			agrandaArray();
		}
		numeros[cantidadNumeros] = n;
		cantidadNumeros++;
	}

	public int[] getNumeros() {
		return numeros;
	}

	public int getCantidadNumeros() {
		return cantidadNumeros;
	}
	
	private void agrandaArray() {
		int[] copiaNumeros = numeros.clone();
		numeros = Arrays.copyOf(copiaNumeros, copiaNumeros.length+DEFAULT_SIZE);
	}


	
	
	
	

}
