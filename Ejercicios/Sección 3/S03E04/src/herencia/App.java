package herencia;

public class App {

    public static void main(String[] args) {
        // Crear un teléfono móvil
        TelefonoMovil telefono = new TelefonoMovil("iPhone 12", 999.99, 6.1, 4, 128);
        
        // Crear una carcasa compatible con el teléfono
        Carcasa carcasa = new Carcasa("Carcasa transparente", 19.99);
        carcasa.agregarTelefonoCompatible(telefono);
        
        // Crear un cargador compatible con el teléfono
        Cargador cargador = new Cargador("Cargador rápido", 29.99);
        cargador.agregarTelefonoCompatible(telefono);
        
        // Imprimir información de los productos
        imprimirInformacion(telefono);
        imprimirInformacion(carcasa);
        imprimirInformacion(cargador);
    }
    
    public static void imprimirInformacion(Producto producto) {
        System.out.println("Producto: " + producto.getNombre());
		System.out.println("Precio: %.2f€".formatted(producto.getPrecio()));
        
        if (producto instanceof TelefonoMovil telefono) {
            System.out.println("Tamaño de pantalla: " + telefono.getTamanoPantalla() + " pulgadas");
            System.out.println("RAM: " + telefono.getCantidadRam() + " GB");
            System.out.println("Almacenamiento: " + telefono.getCantidadAlmacenamiento() + " GB");
        } else if (producto instanceof Accesorio accesorio) {
            System.out.println("Tipo de accesorio: " + accesorio.getClass().getSimpleName());
            if (accesorio instanceof Carcasa carcasa) {
                System.out.println("Telefonos compatibles con la carcasa:");
                TelefonoMovil[] telefonosCarcasa = carcasa.getTelefonosCompatibles();
        		for (int i = 0; i < carcasa.getNumTelefonosCompatibles(); i++) {
        			System.out.println("- " + telefonosCarcasa[i].getNombre());
        		}
            } else if (accesorio instanceof Cargador cargador) {
                System.out.println("Telefonos compatibles con el cargador:");
                TelefonoMovil[] telefonosCargador = cargador.getTelefonosCompatibles();
        		for (int i = 0; i < cargador.getNumTelefonosCompatibles(); i++) {
        			System.out.println("- " + telefonosCargador[i].getNombre());
        		}
            }
        }
        
        System.out.println();
    }

	
	
}
