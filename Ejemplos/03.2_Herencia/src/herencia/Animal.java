package herencia;


public class Animal {
	
	//private int estatura;
	//private double peso;
	//private String raza;
	protected int estatura;
	protected double peso;
	protected String raza;
		
	public Animal(int estatura, double peso, String raza) {
		this.estatura = estatura;
		this.peso = peso;
		this.raza = raza;
	}


	public int getEstatura() {
		return estatura;
	}


	public double getPeso() {
		return peso;
	}


	public String getRaza() {
		return raza;
	}


	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}


	public void setRaza(String raza) {
		this.raza = raza;
	}


	@Override
	public String toString() {
		return "Animal [estatura=" + estatura + ", peso=" + peso + ", raza=" + raza + "]";
	}


	
	
	
	

}
