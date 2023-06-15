package herencia;

public class TelefonoMovil extends Producto {
    private double tamanoPantalla;
    private int cantidadRam;
    private int cantidadAlmacenamiento;

    public TelefonoMovil(String nombre, double precio, double tamanoPantalla, int cantidadRam, int cantidadAlmacenamiento) {
        super(nombre, precio);
        this.tamanoPantalla = tamanoPantalla;
        this.cantidadRam = cantidadRam;
        this.cantidadAlmacenamiento = cantidadAlmacenamiento;
    }

    public double getTamanoPantalla() {
        return tamanoPantalla;
    }

    public int getCantidadRam() {
        return cantidadRam;
    }

    public int getCantidadAlmacenamiento() {
        return cantidadAlmacenamiento;
    }
}