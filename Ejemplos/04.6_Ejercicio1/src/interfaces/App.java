package interfaces;

public class App {

	public static void main(String[] args) {

		Documento d1 = new DocumentoPDF(12345l);
		Documento d2 = new DocumentoPDF(12345678912343l);
		
		Imagen im = new ImagenJPG(2500, 1900);
		
		Video v = new VideoMp4(123);
		
		Validable[] arr = {d1, d2, im, v};
		
		ServicioValidacion servicioValidacion =
				new ServicioValidacion(arr);
		
		if (servicioValidacion.validarTodos())
			System.out.println("Todos los ficheros son válidos");
		else
			System.out.println("Hay algún fichero que no es válido");
		
		
		
		
	}

}
