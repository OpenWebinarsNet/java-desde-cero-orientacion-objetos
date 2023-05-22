package sealed;

public final class CocheDiesel 
	extends Coche 
	implements MotorDiesel {

	@Override
	public void aceptarAire() {
		System.out.println("Aceptando aire en el motor");
		
	}

	@Override
	public void aceptarCombustible() {
		System.out.println("Aceptando combustible en el motor");
		
	}

}
