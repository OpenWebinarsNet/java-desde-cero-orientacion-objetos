package herencia;

public class App {

	public static void main(String[] args) {
		
		Local l1 = new Local(1, "C/ Rue del Percebe nº 1", 250000.0, 110, true);
		
		System.out.println(l1);
		
		Casa c1 = new Casa();
		c1.setIdentificadorInmobiliario(2);
		c1.setDireccion("C/ Rue del Percebe 2");
		c1.setPrecioVenta(150000);
		c1.setMetrosCuadrados(70);
		c1.setNumBanios(2);
		c1.addHabitacion(new Habitacion("Dormitorio", 13, 1));
		c1.addHabitacion(new Habitacion("Dormitorio", 16, 1));
		c1.addHabitacion(new Habitacion("Salón", 18, 2));
		c1.setNumPisos(1);
		
		System.out.println(c1);
		
		

	}

}
