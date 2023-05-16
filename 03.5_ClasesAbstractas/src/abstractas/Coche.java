package abstractas;

public class Coche extends Vehiculo {

	private int velocidadMaxima;
    
    public Coche(String marca, String modelo, int velocidadMaxima) {
        super(marca, modelo);
        this.velocidadMaxima = velocidadMaxima;
    }
    
    @Override
    public void conducir() {
        System.out.println("Conduciendo el coche");
    }
    
    public void mostrarVelocidadMaxima() {
        System.out.println("Velocidad máxima: " + velocidadMaxima + " km/h");
    }

}
