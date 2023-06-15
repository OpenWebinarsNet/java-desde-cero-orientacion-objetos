package disenioclases;

public class App {
	
	public static void main(String[] args) {
		
		PasoPorValor p = new PasoPorValor();
		
		int n = 7;
		p.incrementar10(n);
		System.out.println(n);
		
		var claseCualquiera = new ClaseCualquiera();
				
		System.out.println(claseCualquiera);
		p.incrementar10(claseCualquiera);
		System.out.println(claseCualquiera);
		
	}

}
