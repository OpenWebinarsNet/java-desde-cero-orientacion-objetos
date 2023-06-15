package interfaces;

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
