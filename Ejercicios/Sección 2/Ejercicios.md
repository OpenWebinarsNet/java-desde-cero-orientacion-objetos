# Sección 2 - Diseño de clases

## Ejercicios resueltos en vídeo

1. Crea una aplicación de cálculos estadísticos en Java con 2 clases:
  
- `Muestra`: representará una muestra de números enteros. 
  - Como atributos tendrá el array de números enteros y una variable que indica cuántos valores hay realmente en el array (podemos tener un array de 10 posiciones, pero solamente haber introducido 3 datos).
  - Crea varios constructores:
    - Uno sin argumentos. Debe instanciar el array con 10 posiciones. El nº de posiciones por defecto debe estar almacenado en una constante llamada `DEFAULT_SIZE`.
    - Otro con un argumento entero, que será el tamaño del array.
    - Otro que reciba un array, del cual se hará una copia.
  - La clase tendrá además un método para agregar números a la muestra, y dos métodos getter, para obtener los números y la cantidad de ellos.
  
- `Estadistica`: permitirá realizar cálculos estadísticos sobre una instancia de `Muestra`. Los cálculos a realizar serán:
  - Media: el valor promedio de todos.
  - Moda: el valor que más se repite.
  
  Todos los métodos de esta clase se podrán utilizar sin crear una instancia de la misma  

Puedes encontrar el código fuente completo de este ejercicio resuelto en vídeo [aquí](../../Ejemplos/02.6_Ejercicio1/)

También lo tienes disponible a continuación:

`Muestra.java`
```java
public class Muestra {
	
	public static final int DEAFULT_SIZE = 10;
	private int[] numeros;
	private int cantidadNumeros;
	
	public Muestra() {
		numeros = new int[DEAFULT_SIZE];
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
		numeros[cantidadNumeros] = n;
		cantidadNumeros++;
	}

	public int[] getNumeros() {
		return numeros;
	}

	public int getCantidadNumeros() {
		return cantidadNumeros;
	}

}

```

`Estadistica.java`
```java
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

```

`Ejercicio01.java`
```java
public class Ejercicio01 {

	public static void main(String[] args) {
		Muestra m1 = new Muestra(new int[] { 1, 2, 2, 3, 4, 5, 6, 7, 8, 9 });

		double media = Estadistica.media(m1);
		System.out.println("La media es " + media);

		int moda = Estadistica.moda(m1);
		System.out.println("La moda es " + moda);

	}

}
```


2. Realizar algunas mejoras sobre el ejercicio 1:

- Mejorar el método `Muestra.agregarNumero(...)` de tal forma  que si al agregar un número vamos a superar el tamaño del array, aumente la capacidad de este en 10 unidades. Esta operación de recolocación se realizará mediante un método privado.
- Mejorar el método Estadistica.media de tal forma que lo vamos a sobrecargar para que haya otra versión que acepte únicamente un array de enteros, y calcule el promedio de todos ellos. Para aprovechar el código, se debe crear un tercer método, privado, que haga realmente el cálculo de la media, y usarlo en los dos métodos públicos.

Puedes encontrar el código fuente completo de este ejercicio resuelto en vídeo [aquí](../../Ejemplos/02.7_Ejercicio2/)

También lo tienes disponible a continuación:

`Muestra.java`
```java
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

```

`Estadistica.java`
```java
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

```

`Ejercicio02.java`
```java
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

```

## Otros ejercicios resueltos

3. Crea una clase `Cartera`, que servirá para manejar el dinero que se lleva encima. Esta se podrá crear a través un constructor vacío o de un constructor con un argumento, que será el dinero inicial de la cartera. Como atributo, tendrá el saldo de dinero disponible. Se deben añadir los siguientes métodos:
   - `sacarDinero(double cantidad)`: debe seguir las siguientes reglas
     - Si hay disponible, sacará todo el dinero que se ha solicitado.
     - Si no hay saldo suficiente disponible, solamente sacará el dinero disponible, e imprimirá un mensaje por consola diciendo: TU SALDO SE HA QUEDADO A 0.
     - Si el saldo al inicio de la operación es 0, debe mostrar el mensaje NO TIENES SALDO DISPONIBLE.
   - `consultarSaldo()`: debe devolver un double con el saldo disponible.
   - `meterDinero(double cantidad)`: agregará una cuantía al saldo de la cartera.

Crea además un método main que muestre el funcionamiento de esta clase.

Puedes encontrar la solución en un proyecto Java con eclipse [aquí](./S02E03/).

También lo tienes disponible a continuación.

```java
public class Cartera {
    private double saldo;

    public Cartera() {
        this.saldo = 0.0;
    }

    public Cartera(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void sacarDinero(double cantidad) {
        if (saldo == 0) {
            System.out.println("NO TIENES SALDO DISPONIBLE.");
        } else if (cantidad <= saldo) {
            saldo -= cantidad;
        } else {
            System.out.println("TU SALDO SE HA QUEDADO A 0.");
            saldo = 0;
        }
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void meterDinero(double cantidad) {
        saldo += cantidad;
    }
}
```

`Ejercicio03.java`
```java
public class Ejercicio03 {
    public static void main(String[] args) {
        Cartera miCartera = new Cartera(50.0);
        System.out.println("Mi saldo actual es: " + miCartera.consultarSaldo());
        miCartera.sacarDinero(20.0);
        System.out.println("Mi saldo actual es: " + miCartera.consultarSaldo());
        miCartera.meterDinero(10.0);
        System.out.println("Mi saldo actual es: " + miCartera.consultarSaldo());
        miCartera.sacarDinero(100.0);
        System.out.println("Mi saldo actual es: " + miCartera.consultarSaldo());
    }
}
```

4. Se necesita crear una clase `Password` para manejar contraseñas. Esta clase debe incluir:

    - Un método público y estático que sea capaz de generar una contraseña aleatoria. Recibirá como argumento el número de caracteres de la contraseña aleatoria a generar.
    - Las instancias de la clase incluirán:
      - Un atributo de tipo cadena de caracteres con la contraseña.
      - Un constructor vacío y otro con un argumento de tipo String.
      - Los métodos getter/setter para la contraseña.
      - Un método que devolverá la longitud de la contraseña.
      - Un método, llamado `isStrong`, que devolverá un booleano determinando si la contraseña es fuerte. Para ello, se seguirán las reglas del ejercicio 2 del bloque 5 del curso Java desde cero: Introducción, cuyo código fuente está accesible [aquí](https://github.com/lmlopezmagana/java-desde-cero-introduccion/blob/main/ejemplos/5.05_Ejercicio2/src/cadenas/Ejercicio02.java).

Implementa también una clase llamada `Ejercicio04` que ilustre el funcionamiento de `Password`.

Puedes encontrar la solución en un proyecto Java con eclipse [aquí](./S02E04/).

También lo tienes disponible a continuación.

`Password.java`
```java
import java.util.Random;

public class Password {
	
	private String password;
	
	public Password() {
		this.password = "";
	}
	
	public Password(String password) {
		this.password = password;
	}
	
	public int longitud() {
		return this.password.length();
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isStrong() {
		boolean tieneMayusculas = false;
		boolean tieneMinusculas = false;
		boolean tieneDigitos = false;
		boolean tieneCaracterRaro = false;
		boolean tieneLongitud = false;
				
		// Comprobamos si cumple la lontigud marcada
		
		if (password.length() >= 8 && password.length() <= 20)
			tieneLongitud = true;
		
		// Verificamos la contraseña caracter a caracter
		
		for(int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			
			if (Character.isUpperCase(c))
				tieneMayusculas = true;
			
			if (Character.isLowerCase(c))
				tieneMinusculas = true;
			
			if (Character.isDigit(c))
				tieneDigitos = true;
			
			if (c == '$' || c == '%' || c == '_' || c == '*')
				tieneCaracterRaro = true;
			
		}
			
		
		return (tieneMayusculas && tieneMinusculas 
				&& tieneDigitos && tieneCaracterRaro
				&& tieneLongitud); 
	}

	public static Password generatePassword(int longitud) {
		
		// Posibles caracteres a usar
		char[] caracteres = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '$', ';', '.', '_', '-','*', '%'};		
		
		String resultado = "";
		// Para generar números aleatorios, podemos usar la clase Random.
		for(int i = 0; i < longitud; i++) {
			int aleatorio = new Random().nextInt(caracteres.length);
			resultado += caracteres[aleatorio];
		}
		
		return new Password(resultado);
		
	}

}
```

`Ejercicio04.java`
```java
public class Ejercicio04 {
	
	public static void main(String[] args) {
		Password nueva = Password.generatePassword(15);
		
		System.out.println(nueva.getPassword());
		
		System.out.println("¿La contraseña es fuerte? " + (nueva.isStrong() ? "SÍ": "NO"));
		
	}

}

```

## Ejercicios propuestos

5. Escribir una clase `Reloj` que simule el comportamiento de un cronómetro digital:

- Como argumentos tendrá 3 valores enteros: hora, minutos y segundos.
- Debe incluir un constructor sin parámetros que dejará la hora a 00:00:00.
- Un método que devolverá la hora actual.
- Un método para incrementar la hora actual en 1 segundo. Se debe manejar correctamente que cuando los segundos lleguen a 60, pasen a ser 00 y se incremente un minuto, y así con los minutos y las horas. Cuando se tenga las 23:59:59, el siguiente incremento debería devolver 00:00:00.
- Un método que realizará al puesta a 0 del cronómetro.

6. Escribir una clase `Fecha` que simule el comportamiento de una fecha del calendario.

- Tendrá tres argumentos: día, mes y año.
- Debe incluir un constructor sin argumentos y otro con los 3 argumentos.
- En todo momento, las fechas deben ser válidas, y si los datos proporcionados no producen una fecha válida, se obtendrá como fecha el 01/01/2000.
- Un método que devolverá la fecha en formato dia/mes/año. Por ejemplo 18/09/2003.
- Un método `incrementar` que aceptará un número de días, y que incrementará la fecha en dicha cantidad. El estado de la fecha debe ser consistente.

> Recuerda que un año es bisiesto si es múltiplo de cuatro, no lo es de cien, o si lo es de 400.

> Recuerda que Enero, Marzo, Mayo, Julio, Agosto, Octubre y Diciembre tienen 31 días, y el resto de meses 30, salvo Febrero que tiene 28 (y en los años bisiestos 29).

7. Modificar la clase `Estadistica` del ejercicio 2 para añadir un una nueva sobrecarga del método `media` que acepte un _varargs_ de números enteros. Utiliza la implementación del método privado `media(array, int)` para realizar el cálculo.

8. Modifica la clase `Estadistica` para añadir las mismas sobrecargas del método `media` para el método `moda`.

9. Utilizando la clase `Producto` del ejercicio 3 de la sección 1, crea una clase para simular un carrito de la compra:

- Tendrá un array para poder agregar los productos que deseemos.
- Añade los constructores que estimes necesarios.
- Deberá tener un método que nos indique la cantidad de productos en el carrito.
- Tendrá un método que nos devuelva el precio total de los productos del carrito.
- Tendrá un método para añadir productos al carrito, y otro para sacar productos del carrito. Es posible que sea bueno que tengas algún método privado para reajustar el tamaño del array.

10. Utilizando como base la clase `Personaje` del ejercicio 4 de la sección 1, con las siguientes consignas:

- Modifica la clase `Personaje` para que incluya un atributo, `puntosFuerza`, que será un entero entre 1 y 10.

- Crea una clase que simule una `Batalla` entre personajes. Para ello:
   - Tendrá un método estático que recibirá dos personajes, que lucharán en la batalla.
   - Debe devolver el personaje que ha ganado, o `null` si finalmente no ha ganado ninguno.
   - Para la batalla, los  `Personaje`s se darán diferentes golpes, siguiendo estas reglas:
     - Se darán golpes hasta que uno (o los dos) se queden sin puntos de vida.
     - El golpe tendrá como puntuación un número aleatorio entre 1 y 3, multiplicado por los puntos de fuerza del `Personaje`.
     - Si uno de los `Personaje`s, durante la batalla, llega a menos de 30 puntos de vida, puede tomar alguna de sus pociones de BOTIQUIN.
     - Puedes inventarte algunas pociones más que pueda usar el personaje para incrementar la fuerza de los golpes.
    - Todas las iteraciones del bucle del método de la batalla deberían mostrar los pasos que suceden en la misma por la consola.

Crea una clase, llamada `Ejercicio10`, donde se instancien los personajes y se realice la batalla.



