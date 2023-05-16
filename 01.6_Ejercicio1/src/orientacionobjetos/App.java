package orientacionobjetos;

public class App {

	public static void main(String[] args) {
		
		Alumno a1 = new Alumno();
		a1.setNombre("Jose");
		a1.setApellidos("García López");
		a1.setEdad(14);
		a1.setEmail("jose.garcia@centroeducativo.com");
		
		System.out.println(a1);
		
		Alumno a2 = new Alumno("María", "Fernández Martín", 17);
		a2.setEmail("maria.fernandez@centroeducativo.com");
		a2.setTelefono("600123456");
		
		System.out.println(a2);
		
		System.out.println("La alumna %s %s %s mayor de edad"
				.formatted(
						a2.getNombre(), 
						a2.getApellidos(), 
						a2.esMayorEdad() ? "sí" : "no" ));

		if (a1.equals(a2))
			System.out.println("Son el mismo objeto");
		else
			System.out.println("No son el mismo objeto");
		
		
	}

}
