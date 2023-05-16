package disenioclases;

/*
 * Realizar algunas mejoras sobre el ejercicio 1:
 * 
 * Mejorar el método Muestra.agregarNumero(...) de tal forma 
 * que si al agregar un número vamos a superar el tamaño del 
 * array, aumente la capacidad de este en 10 unidades. 
 * Esta operación de recolocación se realizará mediante un 
 * método privado.
 * 
 * Mejorar el método Estadistica.media de tal forma que lo 
 * vamos a sobrecargar para que haya otra versión que acepte 
 * únicamente un array de enteros, y calcule el promedio de 
 * todos ellos.
 * 
 * Para aprovechar el código, se debe crear un tercer método, 
 * privado, que haga realmente el cálculo de la media, y 
 * usarlo en los dos métodos públicos.
 */
public class Ejercicio02 {

	public static void main(String[] args) {
		Muestra m1 = new Muestra(new int[] { 1, 2, 2, 3, 4, 5, 6, 7, 8, 9 });
		m1.agregarNumero(123);
		double media = Estadistica.media(m1);
		System.out.println("La media es " + media);

		int moda = Estadistica.moda(m1);
		System.out.println("La moda es " + moda);
		
		var array = new int[] {1,22,333,4444,55555};
		double mediaArray = Estadistica.media(array);
		System.out.println("La media del array es " + mediaArray);
	
	}

}
