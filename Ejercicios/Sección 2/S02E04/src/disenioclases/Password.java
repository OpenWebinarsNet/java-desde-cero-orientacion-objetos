package disenioclases;

import java.util.Random;

public class Password {
	
	private String password;
	
	public Password() {
		this.password = "";
	}
	
	public Password(String password) {
		this.password = password;
	}
	
	public int longitud() {
		return this.password.length();
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isStrong() {
		boolean tieneMayusculas = false;
		boolean tieneMinusculas = false;
		boolean tieneDigitos = false;
		boolean tieneCaracterRaro = false;
		boolean tieneLongitud = false;
				
		// Comprobamos si cumple la lontigud marcada
		
		if (password.length() >= 8 && password.length() <= 20)
			tieneLongitud = true;
		
		// Verificamos la contraseña caracter a caracter
		
		for(int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			
			if (Character.isUpperCase(c))
				tieneMayusculas = true;
			
			if (Character.isLowerCase(c))
				tieneMinusculas = true;
			
			if (Character.isDigit(c))
				tieneDigitos = true;
			
			if (c == '$' || c == '%' || c == '_' || c == '*')
				tieneCaracterRaro = true;
			
		}
			
		
		return (tieneMayusculas && tieneMinusculas 
				&& tieneDigitos && tieneCaracterRaro
				&& tieneLongitud); 
	}

	public static Password generatePassword(int longitud) {
		
		// Posibles caracteres a usar
		char[] caracteres = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '$', ';', '.', '_', '-','*', '%'};		
		
		String resultado = "";
		// Para generar números aleatorios, podemos usar la clase Random.
		for(int i = 0; i < longitud; i++) {
			int aleatorio = new Random().nextInt(caracteres.length);
			resultado += caracteres[aleatorio];
		}
		
		return new Password(resultado);
		
	}

}
