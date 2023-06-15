package herencia;

public class App {

	public static void main(String[] args) {

		Animal a = new Animal(220, 450, "Caballo");
		
		Perro p = new Perro(60, 28, "Perro Labrador");
		
		Gato g = new Gato(45, 6, "Gato Montés");
		
		System.out.println(a);
		System.out.println(p);
		System.out.println(g);
		
		p.ladrar();
		g.maullar();
		
	}

}
