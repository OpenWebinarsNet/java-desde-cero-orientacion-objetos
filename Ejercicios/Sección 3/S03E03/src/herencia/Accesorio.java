package herencia;

public abstract class Accesorio extends Producto {
	
    protected TelefonoMovil[] telefonosCompatibles;
    private int numTelefonosCompatibles;

    public Accesorio(String nombre, double precio) {
        super(nombre, precio);
        telefonosCompatibles = new TelefonoMovil[10]; // Inicialmente se reserva espacio para 10 teléfonos
        numTelefonosCompatibles = 0;
    }
    
    public void agregarTelefonoCompatible(TelefonoMovil telefono) {
        if (numTelefonosCompatibles < telefonosCompatibles.length) {
            telefonosCompatibles[numTelefonosCompatibles] = telefono;
            numTelefonosCompatibles++;
        } else {
            System.out.println("No se pueden agregar más teléfonos compatibles");
        }
    }

    public TelefonoMovil[] getTelefonosCompatibles() {
        return telefonosCompatibles.clone();
    }

	public int getNumTelefonosCompatibles() {
		return numTelefonosCompatibles;
	}
    
    
    
    
}
