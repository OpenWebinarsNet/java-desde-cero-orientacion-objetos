
# Sección 4 - Interfaces

## Ejercicios resueltos en vídeo

1. Se necesita implementar un servicio de validación de ficheros. Todo fichero que se pueda validar deberá implementar una interfaz, llamada `Validable`, que tendrá un método cuya firma será `boolean isValid()`. La validación depende del tipo de fichero en cuestión. Solamente se podrán validar clases de tipo `Documento`, `Imagen` y `Video`.

Se tendrán 3 clases abstractas y no selladas, llamadas `Documento`, `Imagen` y `Video`. Para cada una de ellas se necesitará un constructor con argumentos y los métodos getter/setter.

- De los documentos queremos saber el tamaño en bytes.
- De las imágenes queremos saber el ancho y alto.
- De los vídeos queremos saber su duración en segundos.

Se deben crear las siguientes subclases concretas:
- `DocumentoPDF` → `Documento`
- `ImagenJPG` → `Imagen`
- `VideoMp4` → `Video` 

Aquí tenemos un diagrama UML que ilustra esta estructura.

<center><img src="./ejercicio%204.5.png" width=400 alt="Diagrama de clases UML"/></center>

- Un `DocumentoPDF` es válido si su tamaño es inferior a 1 megabyte.
- Una `ImagenJPG` será válida si su tamaño (anchoxalto) es menor a 5 megapíxeles (5 millones)
- Un `VideoMp4` será válido si su duración es menor a 5 minutos.

El servicio de validación será capaz de validar múltiples ficheros a la vez, de forma que:
- Tendrá un array de ficheros a validar, con varios constructores.
- Tendrá un método que será capaz de validar todos los ficheros. 
- Devolverá `true` si todos son válidos, `false` en otro caso.
- Tendrá un método estático que será capaz de validar un único fichero.

Implementar una clase main de prueba con algunos datos de ejemplo.

Puedes encontrar el código fuente completo de este ejercicio resuelto en vídeo [aquí](../../Ejemplos/04.6_Ejercicio1/)

También lo tienes disponible a continuación:

`Validable.java`
```java
package interfaces;


public sealed interface Validable permits Documento, Imagen, Video {
	boolean isValid();
}

```

`Documento.java`
```java
package interfaces;

public abstract non-sealed class Documento implements Validable {

	protected long size;
	

	public Documento(long size) {
		this.size = size;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

}

```

`Imagen.java`
```java
package interfaces;

public abstract non-sealed class Imagen implements Validable {
	
	protected long width;
	protected long height;

	public long getWidth() {
		return width;
	}

	public long getHeight() {
		return height;
	}

	public void setWidth(long width) {
		this.width = width;
	}

	public void setHeight(long height) {
		this.height = height;
	}

	public Imagen(long width, long height) {
		this.width = width;
		this.height = height;
	}

}

```

`Video.java`
```java
package interfaces;

public abstract non-sealed class Video implements Validable {
	
	protected int length;

	public Video(int length) {
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}

```

`DocumentoPDF.java`
```java
package interfaces;

public class DocumentoPDF extends Documento {

	public DocumentoPDF(long size) {
		super(size);
	}

	@Override
	public boolean isValid() {
		return size >= 0 && size <= 1024*1024;
	}

}

```

`ImagenJPG.java`
```java
package interfaces;

public class ImagenJPG extends Imagen {

	public ImagenJPG(long width, long height) {
		super(width, height);
		
	}

	// Imagen <= 5 Megapixels
	// 2,560×1,920 con aspect ratio 16:9
	
	@Override
	public boolean isValid() {
		return width*height <= 5_000_000;
	}

}

```

`VideoMp4.java`
```java
package interfaces;

public class VideoMp4 extends Video {

	public VideoMp4(int length) {
		super(length);
	}

	@Override
	public boolean isValid() {
		return length > 0 && length < 5*60;
	}
	

}

```

`ServicioValidacion.java`
```java
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

```

`App.java`
```java
package interfaces;

public class App {

	public static void main(String[] args) {

		Documento d1 = new DocumentoPDF(12345l);
		Documento d2 = new DocumentoPDF(12345678912343l);
		
		Imagen im = new ImagenJPG(2500, 1900);
		
		Video v = new VideoMp4(123);
		
		Validable[] arr = {d1, d2, im, v};
		
		ServicioValidacion servicioValidacion =
				new ServicioValidacion(arr);
		
		if (servicioValidacion.validarTodos())
			System.out.println("Todos los ficheros son válidos");
		else
			System.out.println("Hay algún fichero que no es válido");
		
	}

}

```

2. En mi barrio hay una ferretería donde el dependiente es muy "apañao". Además de vender tornillos, herramientas y demás, también te hace algunas chapuzas en casa si es que tú no sabes hacerlas. Me ha pedido ayuda para implementar un pequeño sistema de facturación.

Tanto las chapuzas como los productos son elementos que comparten en común que se pueden "vender", así que vamos a crear una interfaz llamada `Vendible`, que tendrá un método con la siguiente firma: `double getPrecio()`.

Se pueden vender tanto `Producto` como `Servicio`, con las siguientes especificaciones:
- De cada `Producto` queremos saber el nombre y la categoría (ambos `String`).
- De cada `Servicio` queremos saber el nombre, el tipo y la duración en minutos.

Para calcular el precio, lo haremos de la siguiente forma:
- De cada `Producto`, almacenaremos el precio como un atributo.
- Para los `Servicio`, el precio se calculará de la siguiente forma, dependiendo del valor del atributo `tipo`:
  - Si es `"PINTURA"`, será a 0.75€ el minuto.
  - Si es `"ELECTRICIDAD"` será a 1€ el minuto.
  - Si es `"FONTANERÍA"` será a 1.25€ el minuto.
  - Si es otro, será a 1.5€ el minuto.

Para poder cobrarle a un cliente, nos pide que le hagamos una clase `Factura`, que tendrá el nombre del cliente así como un array de `Vendible`. También tendrá un método que permitirá calcular la suma total de productos y servicios facturados. 

Implementa además una clase Main con algunos datos de ejemplo.

Puedes encontrar el código fuente completo de este ejercicio resuelto en vídeo [aquí](../../Ejemplos/04.7_Ejercicio2/)

También lo tienes disponible a continuación:

`Vendible.java`
```java
public interface Vendible {
	 double getPrecio();
}
```

`Producto.java`
```java

public class Producto implements Vendible {
	 private String nombre;
	 private String categoria;
	 private double precio;

	 public Producto(String nombre, String categoria, double precio) {
	     this.nombre = nombre;
	     this.categoria = categoria;
	     this.precio = precio;
	 }

	 @Override
	 public double getPrecio() {
	     return precio;
	 }

	public String getNombre() {
		return nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	 
	 
}

```

`Servicio.java`
```java

public class Servicio implements Vendible {
	private String nombre;
	private String tipo;
	private int duracionMinutos;

	public Servicio(String nombre, String tipo, int duracionMinutos) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.duracionMinutos = duracionMinutos;
	}

	@Override
	public double getPrecio() {
		double precioMinuto = switch (tipo) {
		case "PINTURA" -> 0.75;
		case "ELECTRICIDAD" -> 1.0;
		case "FONTANERÍA" -> 1.25;
		default -> 1.5;
		};
		return precioMinuto * duracionMinutos;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public int getDuracionMinutos() {
		return duracionMinutos;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setDuracionMinutos(int duracionMinutos) {
		this.duracionMinutos = duracionMinutos;
	}
	
	

}

```

`Factura.java`
```java
package interfaces;

public class Factura {
	private String cliente;
	private Vendible[] elementos;

	public Factura(String cliente, Vendible[] elementos) {
		this.cliente = cliente;
		this.elementos = elementos;
	}

	public double calcularTotal() {
		double total = 0.0;
		for (Vendible vendible : elementos) {
			total += vendible.getPrecio();
		}
		return total;
	}

	public String getCliente() {
		return cliente;
	}

	public Vendible[] getElementos() {
		return elementos;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public void setElementos(Vendible[] elementos) {
		this.elementos = elementos;
	}

}

```

`App.java`
```java
package interfaces;

public class App {
	 public static void main(String[] args) {
	     Producto producto1 = new Producto("Tornillo", "Ferretería", 0.5);
	     Producto producto2 = new Producto("Martillo", "Herramienta", 10.0);
	     Servicio servicio1 = new Servicio("Pintura de paredes", "PINTURA", 120);
	     Servicio servicio2 = new Servicio("Reparación eléctrica", "ELECTRICIDAD", 60);

	     Vendible[] elementos = {producto1, producto2, servicio1, servicio2};

	     Factura factura = new Factura("Cliente Ejemplo", elementos);

	     double total = factura.calcularTotal();
	     System.out.println("Total de la factura: " + total + "€");
	 }

	
}


```




 
## Otros ejercicios resueltos

3. Sea el siguiente diagrama UML:

<center><img src="./ejercicio%20s04e03.png" width=500 alt="Diagrama de clases UML"/></center>

Necesitamos implementar el reproductor multimedia de un coche, que puede reproducir ficheros de múltiples tipos, pero no de cualquiera. Como queremos que nuestro modelo sea extensible, seguiremos los siguientes pasos:

- Crearemos una interfaz, llamada `Fichero`, para modelar cualquier tipo de archivo. Esta interfaz tendrá los dos métodos abstractos del diagrama.
- Como la implementación será muy común a todos los ficheros, crearemos una clase base abstracta, llamada `FicheroAbstracto`, que tendrá como estado dos atributos: nombre y formato, y que implementará la interfaz `Fichero`.
- Por otro lado, tenemos la interfaz `Reproducible`, que extiende a `Fichero` (todo reproducible será un fichero). Esta interfaz tendrá dos métodos:  `void reproducir()` y `int getDuracion()`, que devuelve la duración en segundos.
- Vamos a crear varios tipos de ficheros:
  - `FicheroPDF`, que no tendrá más métodos que el constructor con argumentos.
  - `ImagenJPG`, `AudioMp3` y `VideoH264`, que además de extender la clase base `FicheroAbstracto` implementa Reproducible.
- Por otro lado, para que nuestro reproductor multimedia sea lo más genérico posible y así lo podamos portar de la plataforma del coche actual a otras, vamos a crear una interfaz llamada `Reproductor`, con los siguientes métodos:
  - `void cargar(Reproducible r)` que carga el fichero a reproducir.
  - `void reproducir()` que reproduce el fichero cargado
  - `default void reproducir(Reproducible r)` que reproduce el fichero que se pasa como argumento. Le daremos una implementación por defecto.
  - `void parar()` que para la reproducción actual.
- La interfaz `Reproductor` se verá implementada por la clase `ReproductorMultimedia`, que tendrá un fichero reproducible actual y aceptará un array de ficheros reproducibles (una especie de playlist).

Se deben crear todas las clases anteriores y un main de prueba.

Puedes encontrar la solución en un proyecto Java con eclipse [aquí](./S04E03/).

También lo tienes disponible a continuación.

`Fichero.java`
```java
public interface Fichero {
	
	String getNombre();
	
	String getFormato();

}

```


`FicheroAbstracto.java`
```java
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

```


`Reproducible.java`
```java
public interface Reproducible extends Fichero {
	
	void reproducir();
	
	int getDuracion();
	

}

```


`FicheroPDF.java`
```java
public class FicheroPDF extends FicheroAbstracto {

	public FicheroPDF(String nombre) {
		super(nombre, "PDF");
	}

}
```


`ImagenJPG.java`
```java
public class ImagenJPG extends FicheroAbstracto implements Reproducible {

	public ImagenJPG(String nombre) {
		super(nombre, "JPG");
	}

	@Override
	public void reproducir() {
		System.out.println("Mostrando la imagen JPG durante 7 segundos");
	}

	@Override
	public int getDuracion() {
		return 7;
	}

}
```


`AudioMp3.java`
```java
public class AudioMp3 extends FicheroAbstracto implements Reproducible {

	private int duracion;
	
	public AudioMp3(String nombre, int duracion) {
		super(nombre, "MP3");
		this.duracion = duracion;
	}

	@Override
	public void reproducir() {
		System.out.println("Reproduciendo todo el contenido del fichero");
		
	}

	@Override
	public int getDuracion() {
		return duracion;
	}

}

```


`VideoH264.java`
```java
public class VideoH264 extends FicheroAbstracto implements Reproducible {

	private int duracion;
	
	public VideoH264(String nombre, int duracion) {
		super(nombre, "H.264");
	}

	@Override
	public void reproducir() {
		System.out.println("Reproduciendo todo el contenido del vídeo");
		
	}

	@Override
	public int getDuracion() {
		return duracion;
	}
	
	

}
```


`Reproductor.java`
```java
public interface Reproductor {
	
	void cargar(Reproducible r);
	
	void reproducir();
	
	default void reproducir(Reproducible r) {
		r.reproducir();
	}
	
	void parar();
	
	

}
```


`ReproductorMultimedia.java`
```java
public class ReproductorMultimedia implements Reproductor{
	
	private Reproducible actual;
	private Reproducible[] lista;
	private int cantidadReproducibles;
	
	
	public ReproductorMultimedia() {
		cantidadReproducibles = 0;
	}
	
	public ReproductorMultimedia(Reproducible[] lista) {
		this.lista = lista;
		cantidadReproducibles = lista.length;
		actual = lista[0];
	}
	

	@Override
	public void cargar(Reproducible r) {
		actual = r;
		
	}

	@Override
	public void reproducir() {
		this.reproducir(actual);
		
	}

	@Override
	public void parar() {
		actual = null;	
	}

}

```


`App.java`
```java

public class App {

	public static void main(String[] args) {
		
		
		VideoH264 v = new VideoH264("Avengers Endgame", 182*60);
		AudioMp3 a = new AudioMp3("19 Días y 500 noches - Joaquín Sabina", 277);
		ImagenJPG i = new ImagenJPG("foto vacaciones");
		FicheroPDF f = new FicheroPDF("Nomina");
		
		Reproductor r = new ReproductorMultimedia();
		
		r.cargar(v);
		r.reproducir();
		
		r.cargar(a);
		r.reproducir();
		
		r.cargar(i);
		r.reproducir();
		
		//r.cargar(f); // Error

	}

}

```
4. Estamos pensando en implementar un sitio web en el que se puedan realizar valoraciones y comentarios sobre cualquier cosa: productos, servicios, lugares, ... Los usuarios podrán realizar valoraciones. Para ello vamos a definir la siguiente estructura de clases:
   - La interfaz `Valorable` será implementada por aquellas clases que puedan ser valoradas. Tendrá un método que devolverá la puntuación media de todas las valoraciones.
   - La clase `Usuario`, que serán quienes realicen las valoraciones.
   - La clase `Valoracion` tendrá un usuario, un valorable y una puntuación (entero del 1 al 5).
   - La clase `ValorableAbstracto` implementará la interfaz `Valorable` y tendrá un array de elementos de tipo `Valoracion`, con todas las valoraciones de dicho `ValorableAbstracto`. Proporcionará una implementación por defecto para el cálculo de la puntuación media.
   - La clase `Usuario` también tendrá un array con todas las `Valoracion`es que haya hecho el usuario.
   - Las clases `Producto`, `Negocio`  y `Ciudad` extenderán a `ValorableAbstracto` añadiendo los atributos propios que nos dicte la lógica.
   - Por último, la clase `ServicioValoracion` tendrá un método llamado `valorar` que recibirá tres argumentos:
     - Un usuario, que realiza la valoración.
     - Un `Valorable`, sobre el que emitir la valoración.
     - Una puntuación entre 1 y 5.
   - Este método tendrá que:
     - Crear el elemento de tipo `Valoracion`.
     - Almacenarlo en el array de Usuario.
     - Si el tipo de `Valorable` que se ha proporcionado como argumento es `ValorableAbstracto`, almacenarlo en el array de valoraciones del mismo.

Implementa todos los métodos que creas necesarios y además, un main de prueba.

Puedes encontrar la solución en un proyecto Java con eclipse [aquí](./S04E04/).

También lo tienes disponible a continuación.

`Valorable.java`
```java
public interface Valorable {
	
	double getPuntuacionMedia();

}
```

`Valoracion.java`
```java
public class Valoracion {
	
	private Usuario usuario;
	private Valorable valorable;
	private int puntuacion;
	
	
	public Valoracion(Usuario usuario, Valorable valorable, int puntuacion) {
		this.usuario = usuario;
		this.valorable = valorable;
		this.puntuacion = puntuacion;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Valorable getValorable() {
		return valorable;
	}


	public void setValorable(Valorable valorable) {
		this.valorable = valorable;
	}


	public int getPuntuacion() {
		return puntuacion;
	}


	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}	

}

```


`Usuario.java`
```java
public class Usuario {
	
	private String username;
	private String email;
	private Valoracion[] valoraciones;
	private int cantidadValoraciones;
	
	
	public Usuario(String username) {
		this.username = username;
		cantidadValoraciones = 0;
		valoraciones = new Valoracion[10];
	}
	
	public Usuario(String username, String email) {
		this(username);
		this.email = email;
	}
	
	public void agregarValoracion(Valoracion valoracion) {
        if (cantidadValoraciones < valoraciones.length) {
            valoraciones[cantidadValoraciones] = valoracion;
            cantidadValoraciones++;
        } else {
            System.out.println("No se pueden agregar más valoraciones");
        }
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Valoracion[] getValoraciones() {
		return valoraciones.clone();
	}

	public int getCantidadValoraciones() {
		return cantidadValoraciones;
	}	

}

```


`ValorableAbstracto.java`
```java
public class ValorableAbstracto implements Valorable {
	
	private Valoracion[] valoraciones;
	private int cantidadValoraciones;
	
	public ValorableAbstracto() {
		valoraciones = new Valoracion[10];
		cantidadValoraciones = 0;
	}
	
	public void agregarValoracion(Valoracion valoracion) {
        if (cantidadValoraciones < valoraciones.length) {
            valoraciones[cantidadValoraciones] = valoracion;
            cantidadValoraciones++;
        } else {
            System.out.println("No se pueden agregar más valoraciones");
        }
    }
	

	@Override
	public double getPuntuacionMedia() {
		double puntuacion = 0.0;
		for(int i = 0; i < cantidadValoraciones; i++)
			puntuacion += valoraciones[i].getPuntuacion();
		
		return puntuacion/cantidadValoraciones;
	}

}

```


`ServicioValoracion.java`
```java
public class ServicioValoracion {
	
	public static void valorar(Usuario usuario, Valorable valorable, int puntuacion) {
        Valoracion valoracion = new Valoracion(usuario, valorable, puntuacion);
        usuario.agregarValoracion(valoracion);
        
        if (valorable instanceof ValorableAbstracto valorableAbstracto) {
            valorableAbstracto.agregarValoracion(valoracion);
        }
    }

}

```


`Producto.java`
```java
public class Producto extends ValorableAbstracto {
	
	private String nombre, categoria;
	private double precio;
	
	
	public Producto(String nombre, String categoria, double precio) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}
}

```


`Negocio.java`
```java
public class Negocio extends ValorableAbstracto {
	
	private String nombre, ciudad;

	public Negocio(String nombre, String ciudad) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

}

```


`Ciudad.java`
```java
public class Ciudad extends ValorableAbstracto {
	
	private String nombre, pais;

	public Ciudad(String nombre, String pais) {
		super();
		this.nombre = nombre;
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	

}

```


`App.java`
```java
public class App {

	public static void main(String[] args) {
        // Crear usuarios
        Usuario usuario1 = new Usuario("Usuario1");
        Usuario usuario2 = new Usuario("Usuario2");

        // Crear productos
        Producto producto1 = new Producto("Producto1", "Categoría1", 10.99);
        Producto producto2 = new Producto("Producto2", "Categoría2", 19.99);

        // Crear negocios
        Negocio negocio1 = new Negocio("Mi tienda", "Sevilla");
        Negocio negocio2 = new Negocio("El Gran Bazar", "Madrid");
       
        // Crear una ciudad
        Ciudad ciudad1 = new Ciudad("Sevilla", "España");
        
        // Valorar productos, negocios o ciudades
        ServicioValoracion.valorar(usuario1, producto1, 4);
        ServicioValoracion.valorar(usuario2, producto2, 3);

        ServicioValoracion.valorar(usuario1, negocio1, 3);
        ServicioValoracion.valorar(usuario2, negocio2, 4);
        
        ServicioValoracion.valorar(usuario1, ciudad1, 5);
        ServicioValoracion.valorar(usuario2, ciudad1, 4);
        
        
        // Imprimir la puntuación media de los productos, negocios y ciudades
        System.out.println("Puntuación media de " + producto1.getNombre() + ": " + producto1.getPuntuacionMedia());
        System.out.println("Puntuación media de " + producto2.getNombre() + ": " + producto2.getPuntuacionMedia());
        System.out.println("Puntuación media de " + negocio1.getNombre() + ": " + negocio1.getPuntuacionMedia());
        System.out.println("Puntuación media de " + negocio2.getNombre() + ": " + negocio2.getPuntuacionMedia());
        System.out.println("Puntuación media de " + ciudad1.getNombre() + ": " + ciudad1.getPuntuacionMedia());
    }

}

```


## Ejercicios propuestos

5. Vamos a mejorar el ejercicio 1. Ahora mismo, al validar todos los documentos, podemos saber si todos son válidos o no, pero nos podría interesar saber cuáles son los que han fallado. Para ello, realiza los siguientes cambios en `ServicioValidacion`:

- Agrega un método que permita añadir ficheros al array de elementos a validar. Esto se debe hacer de forma consistente, de manera que si al agregar, no caben más elementos en el array, se debe copiar en uno más amplio. Además, cada vez que se agregue un fichero, se debe incrementar la variable `cantidadValidables`.
- Agrega el método inverso, que permita eliminar un fichero del array de validables. Esta eliminación se hará por posición dentro del array. El array debe quedar en estado consistente.
- A la hora de realizar la validación de todos los documentos, se almacenará un array de valores booleanos, que tendrá como tamaño `cantidadValidables`, y que almacenará `true` o `false` en función del resultado de la validación. Debes añadir un método cuya firma será `boolean[] getDetalleValidacion()`. De esta forma, si en la posición 2 del array tenemos un valor `false` es porque en la posición 2 del array `validables` tenemos un fichero no válido.
- Añade otro método, `mostrarDetalleValidacion()` que muestre por consola el detalle de validación de cada fichero. Usando _pattern matching_, debe mostrar, para cada tipo de fichero conocido, los datos que lo identifican.

6. Vamos a mejorar el ejercicio 2 ya que el ferretero de mi barrio ha visto que su negocio ha prosperado con nuestra aplicación de gestión. Para ello, quiere implementar una clase `Catalogo`, donde poder añadir tanto los productos como los servicios, que se almacenarán en un array de `Vendible`. Esta clase tendrá los típicos métodos para añadir un `Vendible` al catálogo, para borrarlo por su posición en el array y para mostrar la información del catálogo, a través de dos métodos:
	- `void mostrarInformacionIndividual(Vendible v)`: deberá mostrar la información de lo que se vende, de forma que:
    	- Si es un `Producto`, se mostrará el nombre, la categoría y el precio.
    	- Si es un `Servicio`, se mostrará el nombre, el tipo y la duración.
	- `void mostrarInformacionCatalogo()`, que mostrará la información de todos los `Vendible`s del catálogo.

Modifica el método `main` para crear un catálogo con varios `Vendible` y utiliza los métodos de la clase para mostrarlos por consola.

7. Vamos a mejorar el ejercicio 3 de la siguiente forma:

- Si te das cuenta en el diagrama, todas las clases que implementan `Reproducible` también extienden a `FicheroAbstracto` y en ellas hemos repetido algún elemento, como tener una duración almacenada (al menos en 2 de ellas es variable, y en otra constante). Crea una nueva clase abstracta, llamada `FicheroReproducibleAbstracto`, que implemente `Reproducible` y proponga una implementación por defecto para los métodos de la interfaz. Modifica las clases `ImagenJPG`,`AudioMp3` y `VideoH264` para que extiendan a `FicheroReproducibleAbstracto` y ajusta su implementación.
- En nuestro `ReproductorMultimedia` no podemos pasar al siguiente o anterior reproducible de la lista. Añade los métodos `void siguiente()` y `void anterior()` de manera que:
  - Se parece la reproducción actual.
  - Se cargue el siguiente elemento del array en `actual`
  - Se comience su reproducción.
- Ten en cuenta que la lista de reproducción es circular, es decir:
  - El siguiente al último es el primero.
  - El anterior al primero es el último.

8. Vamos a mejorar el ejercicio 4 de forma que:

- Se garantice que las valoraciones son de entre 1 y 5.
- Se gestione la posibilidad de agregar más de 10 valoraciones por producto/usuario.
- Se garantice que un mismo usuario no puede valorar más de una vez el mismo valorable.
- Además de poder valorar numéricamente, que los usuarios puedan añadir un único comentario. Para esto último, ¿dónde crees que deberíamos empezar la modificación? ¿Crees que sería bueno crear una interfaz `Comentable`?

