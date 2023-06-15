
# Sección 1 - Introducción a la Orientación a Objetos

## Ejercicios resueltos en vídeo

1. Se necesita crear una clase que representará a un `Alumno` de un centro educativo. De cada alumno se quiere conocer el nombre, apellidos, email, edad y teléfono.

Se necesitan diferentes constructores.
- Sin argumentos.
- Nombre, apellidos y edad.
- Todos los atributos.

Además:

* Se deben implementar los métodos getters/setters.
* Se deben implementar los métodos `equals`, `hashcode` y `toString`.
* Se debe añadir un método que nos indique si el alumno es mayor de edad (>= 18 años).

Implementa un método main donde se creen un par de objetos de tipo `Alumno` y se muestren por consola.

Puedes encontrar el código fuente completo de este ejercicio resuelto en vídeo [aquí](../../Ejemplos/01.6_Ejercicio1/)

También lo tienes disponible a continuación:


`Alumno.java`
```java
package orientacionobjetos;

import java.util.Objects;

public class Alumno {
	
	private String nombre;
	private String apellidos;
	private String email;
	private int edad;
	private String telefono;
	
	public Alumno() { }

	public Alumno(String nombre, String apellidos, String email, int edad, String telefono) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.edad = edad;
		this.telefono = telefono;
	}

	public Alumno(String nombre, String apellidos, int edad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	
	// También así
	/*public Alumno(String nombre, String apellidos, int edad) {
		this(nombre, apellidos, null, edad, null);
	}*/

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getEmail() {
		return email;
	}

	public int getEdad() {
		return edad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public boolean esMayorEdad() {
		return (edad >= 18);
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, edad, email, nombre, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(apellidos, other.apellidos) && edad == other.edad && Objects.equals(email, other.email)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", edad=" + edad
				+ ", telefono=" + telefono + "]";
	}
}
```

`App.java`
```java
package orientacionobjetos;

public class App {

	public static void main(String[] args) {
		
		Alumno a1 = new Alumno();
		a1.setNombre("Jose");
		a1.setApellidos("García López");
		a1.setEdad(14);
		a1.setEmail("jose.garcia@centroeducativo.com");
		
		System.out.println(a1);
		
		Alumno a2 = new Alumno("María", "Fernández Martín", 17);
		a2.setEmail("maria.fernandez@centroeducativo.com");
		a2.setTelefono("600123456");
		
		System.out.println(a2);
		
		System.out.println("La alumna %s %s %s mayor de edad"
				.formatted(
						a2.getNombre(), 
						a2.getApellidos(), 
						a2.esMayorEdad() ? "sí" : "no" ));

		if (a1.equals(a2))
			System.out.println("Son el mismo objeto");
		else
			System.out.println("No son el mismo objeto");
	}
}

```


2. Utilizando la clase Alumno del ejercicio 1, crea un programa en Java que tenga un array de objetos de esta clase y nos indique cuál es el alumno más joven de todos.

Puedes encontrar el código fuente completo de este ejercicio resuelto en vídeo [aquí](../../Ejemplos/01.7_Ejercicio2/)

También lo tienes disponible a continuación:



```java
package orientacionobjetos;

public class App {

	public static void main(String[] args) {
		
		var alumnos = new Alumno[5];
		
		alumnos[0] = new Alumno("José", "García López", 14);
		alumnos[1] = new Alumno("María", "Fernández Martín", 17);
		alumnos[2] = new Alumno("Raúl", "Miraflores Redondo", 11);
		alumnos[3] = new Alumno("Lucía", "Muñoz Seco", 16);
		alumnos[4] = new Alumno("Antonio", "De la Cruz Serón", 19);
		
		// Por defecto, el alumno más joven será el primero de todos.
		int posicionMasJoven = 0;
		for(int i = 1; i < alumnos.length; i++) {
			// Versión más larga.
			
			//Alumno a1 = alumnos[posicionMasJoven];
			//Alumno a2 = alumnos[i];
			//if (a1.getEdad() > a2.getEdad())
			//	posicionMasJoven = i;
			
			// Versión reducida, aunque el efecto es el mismo.
			if (alumnos[posicionMasJoven].getEdad() > alumnos[i].getEdad()) 
				posicionMasJoven = i;
		}
		
		Alumno joven = alumnos[posicionMasJoven];
		System.out.println("El alumno más joven es %s %s con %d años"
				.formatted(joven.getNombre(), joven.getApellidos(), joven.getEdad()));
		
	}
}
```

## Otros ejercicios resueltos

3. Se necesita implementar una clase llamada `Producto` que tenga los siguientes atributos: código, nombre, descripcion y precio. Se necesita un constructor sin argumentos y otro para todos los argumentos. Se deben implementar también los métodos getters/setters, `equals`, `hashCode` y `toString`. Se necesita además un método que devuelva una cadena de caracteres según el precio del producto, siguiendo las siguientes reglas:

- precio < 1.0€ -> GANGA
- 1.0€ <= precio < 10 -> NORMAL
- precio >= 10 -> LUJO

Puedes encontrar la solución en un proyecto Java con eclipse [aquí](./S01E03/).

También lo tienes disponible a continuación.

`Producto.java`
```java
package orientacionobjetos;

import java.util.Objects;

public class Producto {
	
	private long codigo;
	private String nombre;
	private String descripcion;
	private double precio;
	
	
	public Producto() { }
	
	public Producto(long codigo, String nombre, String descripcion, double precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public String precioLiteral() {
		String resultado;
		
		if (precio > 0 && precio < 1.0)
			resultado = "GANGA";
		else if (precio >= 1.0 && precio < 10)
			resultado = "NORMAL";
		else
			resultado = "LUJO";
		
		return resultado;
		
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, descripcion, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return codigo == other.codigo && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
				+ precio + "]";
	}	

}

```

`App.java`
```java
package orientacionobjetos;

public class App {

	public static void main(String[] args) {

		Producto p1 = new Producto(1234l, "Ordenador portátil", "Magnífico ordenador portátil para programar", 599.99);
		Producto p2 = new Producto(2345l, "Monitor 24", "Estupendo monitor para programar", 199.99);
		
		System.out.println(p1.precioLiteral());
		System.out.println(p2.precioLiteral());
		
		
	}

}

```

4. Para implementar un juego, necesitamos una clase `Personaje`, que tendrá los siguientes atributos: nombre, puntos de vida (un entero entre 0 y 100), puntos conseguidos (un valor entero mayor que 0) y una mochila, que será un array de String con los nombres de algunos elementos que se puede encontrar por el juego (pociones, herramientas, ...). Este array puede tener, como mucho, 10 elementos. Para manejar el array, también sería bueno tener una variable entera que nos indicara el número de pociones o herramientas que tenemos dentro del array.

Implementa un constructor sin argumentos, y otro que reciba como argumento el nombre. Ten en cuenta que cuando se instancia un `Personaje` siempre tendrá 100 puntos de vida disponibles, así como 0 puntos conseguidos.

Incluye los métodos equals, hashCode y toString. También los métodos getters, setters, salvo para los atributos de la mochila y su número de elementos, que solamente tendrán método getter.

Añade además los siguientes métodos:

- Uno que sirva para agregar una poción o herramienta al array. Si el array está completo, simplemente no la añadirá, pero mostrará un mensaje por consola, del tipo: "YA NO PUEDES CONSEGUIR MÁS ELEMENTOS PUES TU MOCHILA ESTÁ COMPLETA". Si todo va bien, devolverá el número de elementos que hay en la mochila.
- Otro método, que se llamará `recibirGolpe` que recibe un valor entero como argumento, con el número de puntos de vida que se deben restar al personaje. Debe devolver el número de puntos de vida que restan al personaje. Ten en cuenta que el valor resultante nunca debe ser menor que 0.
- Otro que sirva para buscar en el array la poción de tipo "BOTIQUIN" y usarla, y así incrementar en 10 unidades los puntos de vida. Ten en cuenta que los puntos de vida no pueden superar nunca el número 100.
Debe devolver el número de puntos de vida resultante. Si no tiene ninguna poción de tipo "BOTIQUIN", debe mostrar un mensaje como este por consola: "LO SIENTO, PERO NO TIENES NINGUNA POCIÓN DE BOTIQUÍN".

Puedes encontrar la solución en un proyecto Java con eclipse [aquí](./S01E04/).

También lo tienes disponible a continuación.

`Personaje.java`
```java
package orientacionobjetos;

import java.util.Arrays;
import java.util.Objects;

public class Personaje {
	
	private String nombre;
	private int puntosVida;
	private long puntos;
	private String[] mochila;
	private int elementosEnMochila;
	
	public Personaje() {
		this.puntos = 0;
		this.puntosVida = 100;
		this.mochila = new String[10];
		this.elementosEnMochila = 0;
	}
	
	public Personaje(String nombre) {
		this();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntosVida() {
		return puntosVida;
	}

	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}

	public long getPuntos() {
		return puntos;
	}

	public void setPuntos(long puntos) {
		this.puntos = puntos;
	}

	public String[] getMochila() {
		return mochila;
	}
	
	public int getElementosEnMochila() {
		return elementosEnMochila;
	}
	
	public int addElementoToMochila(String elemento) {
		if (elementosEnMochila == 10)
			System.out.println("YA NO PUEDES CONSEGUIR MÁS ELEMENTOS PUES TU MOCHILA ESTÁ COMPLETA");
		else 
			mochila[elementosEnMochila] = elemento;
		
		return ++elementosEnMochila;
		
	}
	
	public int recibirGolpe(int puntosGolpe) {
		this.puntosVida -= puntosGolpe;
		if (this.puntosVida < 0)
			this.puntosVida = 0;
		
		return this.puntosVida;
	}
	
	// Falta reasignar el array y decrementar elementosEnMochila
	
	public int usarBotiquin() {
		boolean tieneBotiquin = false;
		if (elementosEnMochila > 0) {
			
			for(int i = 0; i < elementosEnMochila && !tieneBotiquin; i++) {
				if (mochila[i] == "BOTIQUIN") {
					tieneBotiquin = true;
					this.puntosVida += 10;
					if (this.puntosVida > 100)
						this.puntosVida = 100;
					
					// Reasignar resto de elementos del array
					mochila[i] = null;
					for(int x = i+1; x < elementosEnMochila; x++) {
						mochila[x-1] = mochila[x];
					}
					elementosEnMochila--;
					mochila[elementosEnMochila] = null;
					
				}
			}
		}
		
		if (tieneBotiquin == false)
			System.out.println("LO SIENTO, PERO NO TIENES NINGUNA POCIÓN DE BOTIQUÍN");
		
		return this.puntosVida;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(mochila);
		result = prime * result + Objects.hash(elementosEnMochila, nombre, puntos, puntosVida);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personaje other = (Personaje) obj;
		return elementosEnMochila == other.elementosEnMochila && Arrays.equals(mochila, other.mochila)
				&& Objects.equals(nombre, other.nombre) && puntos == other.puntos && puntosVida == other.puntosVida;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", puntosVida=" + puntosVida + ", puntos=" + puntos + ", mochila="
				+ Arrays.toString(mochila) + ", elementosEnMochila=" + elementosEnMochila + "]";
	}
}

```

`App.java`
```java
package orientacionobjetos;

public class App {

	public static void main(String[] args) {
		
		Personaje p1 = new Personaje("Harry Potter");
		
		p1.recibirGolpe(15);
		
		System.out.println(p1);

		p1.usarBotiquin();

		p1.addElementoToMochila("VARITA");
		p1.addElementoToMochila("BOTIQUIN");
		p1.addElementoToMochila("EXPECTO PATRONUM");

		p1.usarBotiquin();
		System.out.println(p1);

	}

}

```

## Ejercicios propuestos

5. Modifica el ejercicio 2 para incluir en el alumno un atributo que incluya todas las notas del alumno en un array de `float` (`float[]`). Añade además un método, llamado `notaMedia()` que sea capaz de devolver como un valor numérico la nota media del alumno.

6. Completa el ejercicio anterior de modo que tenga un nuevo método, llamado `notaMediaLiteral()`, que siga las siguientes reglas.

Si la nota media es alguno de los siguientes valores, debe devolver el literal correspondiente:

- 0..4 Insuficiente
- 5 Suficiente
- 6 Bien
- 7,8 Notable
- 9,10 Sobresaliente.

7. Completa los ejercicios anteriores para implementar un programa que sea capaz de mostrar los dos alumnos con la mayor nota media.
   
8. Modifica la clase `Producto` del ejercicio 3 para añadir:

- Un atributo llamado `descuento`, de tipo double, que indique el porcentaje de descuento del producto (valor entre 0 y 1; por ejemplo, 30% se almacena como 0.3).
- Un método, llamado `precioFinal`, que devuelva el precio aplicando el descuento, si es que lo tiene.



