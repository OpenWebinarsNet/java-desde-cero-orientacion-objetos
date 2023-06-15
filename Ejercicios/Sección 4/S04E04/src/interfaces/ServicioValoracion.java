package interfaces;

public class ServicioValoracion {
	
	public static void valorar(Usuario usuario, Valorable valorable, int puntuacion) {
        Valoracion valoracion = new Valoracion(usuario, valorable, puntuacion);
        usuario.agregarValoracion(valoracion);
        
        if (valorable instanceof ValorableAbstracto valorableAbstracto) {
            valorableAbstracto.agregarValoracion(valoracion);
        }
    }

}
