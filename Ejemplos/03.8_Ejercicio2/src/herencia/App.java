package herencia;

public class App {

	public static void main(String[] args) {
		
		Local l1 = new Local(1, "C/ Rue del Percebe nº 1", 250000.0, 110, true, 0.07);
			
		Casa c1 = new Casa();
		c1.setIdentificadorInmobiliario(2);
		c1.setDireccion("C/ Rue del Percebe 2");
		c1.setPrecioBase(150000);
		c1.setMetrosCuadrados(70);
		c1.setNumBanios(2);
		c1.addHabitacion(new Habitacion("Dormitorio", 13, 1));
		c1.addHabitacion(new Habitacion("Dormitorio", 16, 1));
		c1.addHabitacion(new Habitacion("Salón", 18, 2));
		c1.setNumPisos(1);
		
		Apartamento ap1 = new Apartamento();
		ap1.setIdentificadorInmobiliario(3);
		ap1.setDireccion("C/ Rue del Percebe 3");
		ap1.setMetrosCuadrados(50);
		ap1.setPrecioBase(120000);
		ap1.setNumBanios(1);
		ap1.addHabitacion(new Habitacion("Dormitorio", 14, 1));
		ap1.addHabitacion(new Habitacion("Salón", 20, 2));
		
		
		imprimirInformacion(l1);
		imprimirInformacion(c1);
		imprimirInformacion(ap1);
		

	}
	
	public static void imprimirInformacion(Inmueble i) {
		
		if (i instanceof Local l) {
			System.out.println("LOCAL COMERCIAL");
			imprimirInformacionComun(i);
			System.out.println("EL LOCAL %s TIENE SALIDA DE HUMOS"
					.formatted(l.isTieneSalidaHumos() ? "SÍ" : "NO"));
		} else if (i instanceof Casa c) {
			System.out.println("CASA");
			imprimirInformacionComun(i);
			System.out.println("Nº HABITACIONES: " +  c.getNumHabitaciones());
			System.out.println("Nº PLANTAS: " + c.getNumPisos());
		} else if (i instanceof Apartamento a) {
			System.out.println("APARTAMENTO");
			imprimirInformacionComun(i);
			System.out.println("Nº HABITACIONES: " +  a.getNumHabitaciones());			
		}
		
		System.out.println();
	}

	private static void imprimirInformacionComun(Inmueble i) {
		System.out.println("DIRECCIÓN: " + i.getDireccion());
		System.out.println("TAMAÑO: %.2f m2".formatted(i.getMetrosCuadrados()));
		System.out.println("PRECIO FINAL: %.2f".formatted(i.precioVentaFinal()));
	}
}
