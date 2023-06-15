package disenioclases;

public class Ejercicio04 {
	
	public static void main(String[] args) {
		Password nueva = Password.generatePassword(15);
		
		System.out.println(nueva.getPassword());
		
		System.out.println("¿La contraseña es fuerte? " + (nueva.isStrong() ? "SÍ": "NO"));
		
	}

}
