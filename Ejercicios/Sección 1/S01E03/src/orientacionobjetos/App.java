package orientacionobjetos;

/*
3. Se necesita implementar una clase llamada `Producto` 
que tenga los siguientes atributos: código, nombre, 
descripcion y precio. Se necesita un constructor sin 
argumentos y otro para todos los argumentos. 

Se deben implementar también los métodos getters/setters, 
`equals`, `hashCode` y `toString`. 
Se necesita además un método que devuelva una cadena 
de caracteres según el precio del producto, siguiendo 
las siguientes reglas:

- precio < 1.0€ -> GANGA
- 1.0€ <= precio < 10 -> NORMAL
- precio >= 10 -> LUJO
 */
public class App {

	public static void main(String[] args) {

		Producto p1 = new Producto(1234l, "Ordenador portátil", "Magnífico ordenador portátil para programar", 599.99);
		Producto p2 = new Producto(2345l, "Monitor 24", "Estupendo monitor para programar", 199.99);
		
		System.out.println(p1.precioLiteral());
		System.out.println(p2.precioLiteral());
		
		
	}

}
