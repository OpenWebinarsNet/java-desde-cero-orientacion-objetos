package hotel.personas;

public class Cliente extends Huesped {
	
	private String tarjetaBancaria;

	public Cliente(String nombre, int edad, String dni, String tarjetaBancaria) {
		super(nombre, edad, dni);
		this.tarjetaBancaria = tarjetaBancaria;
	}

	public String getTarjetaBancaria() {
		return tarjetaBancaria;
	}

	public void setTarjetaBancaria(String tarjetaBancaria) {
		this.tarjetaBancaria = tarjetaBancaria;
	}
	
	

	

}
