package interfaces;

public class App {

	public static void main(String[] args) {
		//Loggable logger = new ConsoleLogger();
		Loggable logger = new ConsoleInverseLogger();
		
		String msg = "Hola Mundo";
		
		logger.log(msg);
		
		String[] arr = new String[] {
				"Mensaje 1", "Mensaje 2", "Mensaje 3"
		};
		
		logger.logArray(arr);
		
	}

}
