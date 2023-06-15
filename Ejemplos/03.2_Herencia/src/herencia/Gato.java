package herencia;

public class Gato extends Animal {

	public Gato(int estatura, double peso, String raza) {
		super(estatura, peso, raza);
	}
	
	public void maullar() {
		System.out.println("Miauuuu miauuuu...");
	}

}
