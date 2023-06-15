package disenioclases;

public class PasoPorValor {
	
	public void incrementar10(int x) {
		x += 10;
	}
	
	public void incrementar10(ClaseCualquiera c) {
		int valorActual = c.getNumero();
		c.setNumero(valorActual+10);
	}

}
