package disenioclases;

/*
 * Crea una aplicación de cálculos estadísticos en Java con 2 clases:
 * 
 * - Muestra: representará una muestra de números enteros. Como
 * atributos tendrá el array de números enteros y una variable
 * que indica cuántos valores hay realmente en el array (podemos
 * tener un array de 10 posiciones, pero solamente haber introducido
 * 3 datos).
 * Crea varios constructores:
 *  -> Uno sin argumentos. Debe instanciar el array con 10 posiciones.
 *     El nº de posiciones por defecto debe estar almacenado en una
 *     constante llamada DEFAULT_SIZE.
 *  -> Otro con un argumento entero, que será el tamaño del array.
 *  -> Otro que reciba un array, del cual se hará una copia.
 * La clase tendrá además un método para agregar números a la muestra,
 * y dos métodos getter, para obtener los números y la cantidad de ellos.
 * 
 * - Estadistica: permitirá realizar cálculos estadísticos sobre
 * una instancia de Muestra. Los cálculos a realizar serán:
 *  -> Media: el valor promedio de todos.
 *  -> Moda: el valor que más se repite.
 * Todos los métodos de esta clase se podrán utilizar sin crear
 * una instancia de la misma  
 *     
 * 
 */
public class Ejercicio01 {

	public static void main(String[] args) {
		Muestra m1 = new Muestra(new int[] { 1, 2, 2, 3, 4, 5, 6, 7, 8, 9 });

		double media = Estadistica.media(m1);
		System.out.println("La media es " + media);

		int moda = Estadistica.moda(m1);
		System.out.println("La moda es " + moda);

	}

}
