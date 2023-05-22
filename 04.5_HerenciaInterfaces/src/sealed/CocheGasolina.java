package sealed;

public final class CocheGasolina extends Coche implements MotorGasolina {

	@Override
	public void aceptarAireYCombustible() {
		System.out.println("Aceptando a la vez aire y combustible en el motor");
	}

}
