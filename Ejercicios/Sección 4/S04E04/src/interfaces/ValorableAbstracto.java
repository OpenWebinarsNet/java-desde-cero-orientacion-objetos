package interfaces;

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
