package disenioclases;

public class Estadistica {
	
	public static double media(Muestra m) {
		double suma = 0;
		for(int i = 0; i < m.getCantidadNumeros(); i++) {
			suma += m.getNumeros()[i];
		}
		return suma / m.getCantidadNumeros();
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
