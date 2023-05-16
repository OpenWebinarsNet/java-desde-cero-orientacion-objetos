package orientacionobjetos;

import java.util.Objects;

public class Coche {
	
	private String marca;
	private String modelo;
	private int anio;
	private double velocidadActual;
	private double litrosEnDeposito;
	
	
	public Coche() {}
	
	
	
	public Coche(String marca, String modelo, int anio, double velocidadActual, double litrosEnDeposito) {
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.velocidadActual = velocidadActual;
		this.litrosEnDeposito = litrosEnDeposito;
	}
	
	public Coche(String marca, String modelo) {
		this(marca, modelo, 2020, 0, 0);
	}
	
	public Coche(String marca, int anio) {
		this(marca, null, anio, 0, 0);
	}
	
	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public int getAnio() {
		return anio;
	}

	public double getVelocidadActual() {
		return velocidadActual;
	}

	public double getLitrosEnDeposito() {
		return litrosEnDeposito;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public void setVelocidadActual(double velocidadActual) {
		this.velocidadActual = velocidadActual;
	}

	public void setLitrosEnDeposito(double litrosEnDeposito) {
		this.litrosEnDeposito = litrosEnDeposito;
	}

	public void arrancar() {
		if (this.litrosEnDeposito > 0)
			System.out.println("El coche %s %s %d ha arrancado"
					.formatted(marca, modelo, anio));
		else
			System.out.println("El coche no puede arrancar porque tiene el depósito vacío");
	}
	
	/*
	 * Incrementamos el depósito del coche con el 
	 * número indicado de litros.
	 */
	public double repostar(double cantidad) {
		this.litrosEnDeposito += cantidad;
		// this no es estrictamente obligatorio si no hay ambigüedad
		return litrosEnDeposito;  
	}

	/*
	 * Incrementamos la velocidad actual.
	 */
	public double acelerar(double incrementoVelocidad) {
		this.velocidadActual += incrementoVelocidad;
		return this.velocidadActual;
	}
	
	/*
	 * El coche viaja una serie de kilómetros
	 * Devolvemos el tiempo en segundos que ha tardado en hacer el viaje
	 * Restamos 0.07 litros por cada kilómetro recorrido.
	 */
	public double viajar(double kilometros) {
		
		// Comprobamos que el coche puede hacer el viaje
		if (kilometros * 0.07 <= litrosEnDeposito) {
			double tiempoEnHoras = kilometros / velocidadActual;
			double tiempoEnSegundos = tiempoEnHoras * 60 * 60;
			this.litrosEnDeposito -= kilometros * 0.07;
			System.out.println("Tras el viaje, el depósito ha quedado con %.2f litros"
					.formatted(this.litrosEnDeposito));
			return tiempoEnSegundos;
		} else {
			System.out.println("Para poder hacer ese viaje debes repostar");
			return 0;
		}
	}



	@Override
	public int hashCode() {
		return Objects.hash(anio, litrosEnDeposito, marca, modelo, velocidadActual);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		return anio == other.anio
				&& Double.doubleToLongBits(litrosEnDeposito) == Double.doubleToLongBits(other.litrosEnDeposito)
				&& Objects.equals(marca, other.marca) && Objects.equals(modelo, other.modelo)
				&& Double.doubleToLongBits(velocidadActual) == Double.doubleToLongBits(other.velocidadActual);
	}



	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + ", velocidadActual="
				+ velocidadActual + ", litrosEnDeposito=" + litrosEnDeposito + "]";
	}
	
	
	
	
	
}
