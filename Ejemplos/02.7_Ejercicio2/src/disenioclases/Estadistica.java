package disenioclases;

public class Estadistica {
	
	public static double media(Muestra m) {
		return media(m.getNumeros(), m.getCantidadNumeros());
	}
	
	public static double media(int[] array) {
		return media(array, array.length);
	}
	
	private static double media(int[] array, int cantidad) {
		double suma = 0;
		for(int i = 0; i < cantidad; i++) {
			suma += array[i];
		}
		
		return suma / cantidad;
	}
	
	public static int moda(Muestra m) {
		int moda = 0;
        int maxFrecuencia = 0;
        int n = m.getCantidadNumeros();
        int[] numeros = m.getNumeros();
        
        for (int i = 0; i < n; i++) {
        	// Comparamos cada número del array con los demás
            int frecuencia = 0;
            for (int j = 0; j < n; j++) {
                if (numeros[j] == numeros[i]) {
                    frecuencia++;
                }
            }
            if (frecuencia > maxFrecuencia) {
                maxFrecuencia = frecuencia;
                moda = numeros[i];
            }
        }
        return moda;
	}

}
