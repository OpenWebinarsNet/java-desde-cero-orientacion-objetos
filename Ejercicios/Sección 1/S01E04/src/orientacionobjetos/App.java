package orientacionobjetos;

public class App {

	public static void main(String[] args) {
		
		Personaje p1 = new Personaje("Harry Potter");
		
		p1.recibirGolpe(15);
		
		System.out.println(p1);

		p1.usarBotiquin();

		p1.addElementoToMochila("VARITA");
		p1.addElementoToMochila("BOTIQUIN");
		p1.addElementoToMochila("EXPECTO PATRONUM");

		p1.usarBotiquin();
		System.out.println(p1);

		
		

	}

}
