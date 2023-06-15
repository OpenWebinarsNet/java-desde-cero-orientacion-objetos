package interfaces;

public class App {

	public static void main(String[] args) {
		
		String fecha1 = FechaUtil.formateaFecha(32, 24, -36);
		
		System.out.println(fecha1);
		
		String fecha2 = FechaUtil.formateaFecha(18, 9, 1982);
		
		System.out.println(fecha2);

	}

}
