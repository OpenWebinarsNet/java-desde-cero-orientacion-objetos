package patternmatching;

public class App {

	public static void main(String[] args) {

		
		VehiculoAereo h = new Helicoptero("Airbus","Súper Puma", 6000);
		VehiculoAereo a = new Avion("Airbus","A320", 11800);
		
		llevarGente(h);
		llevarGente(a);
		llevarGentev2(h);
		llevarGentev2(a);

	}
	
	public static void llevarGente(VehiculoAereo v) {
		
		v.mostrarInformacion();
		
		if (v instanceof Helicoptero) {
			Helicoptero h = (Helicoptero) v;
			h.realizarRescate();
			//((Helicoptero) v).realizarRescate();
		} else if (v instanceof Avion) {
			Avion a = (Avion) v;
			a.transportarPasajeros();
			//((Avion) v).transportarPasajeros();
		}	
		System.out.println();
	}
	
	public static void llevarGentev2(VehiculoAereo v) {
		
		v.mostrarInformacion();
		
		// Aquí usamos pattern matching
		if (v instanceof Helicoptero h)
			h.realizarRescate();
		else if (v instanceof Avion a)
			a.transportarPasajeros();
		
		System.out.println();
	}
	
	/*
	Disponible en versiones posteriores de Java
	 
	public static void llevarGentev3(VehiculoAereo v) {
		
		switch(v) {
			case Helicoptero h -> h.realizarRescate();
			case Avion a -> a.transportarPasajeros();
		}
		
	}
	*/
	
	
	

}
