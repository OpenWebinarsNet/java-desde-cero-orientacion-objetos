package herencia;

import java.util.Objects;

public class Habitacion {
	
	private String uso;
	private double metrosCuadrados;
	private int numVentanas;
	
	public Habitacion() {}
	
	public Habitacion(String uso, double metrosCuadrados, int numVentanas) {
		super();
		this.uso = uso;
		this.metrosCuadrados = metrosCuadrados;
		this.numVentanas = numVentanas;
	}

	public String getUso() {
		return uso;
	}

	public double getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public int getNumVentanas() {
		return numVentanas;
	}

	public void setUso(String uso) {
		this.uso = uso;
	}

	public void setMetrosCuadrados(double metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public void setNumVentanas(int numVentanas) {
		this.numVentanas = numVentanas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(metrosCuadrados, numVentanas, uso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Habitacion other = (Habitacion) obj;
		return Double.doubleToLongBits(metrosCuadrados) == Double.doubleToLongBits(other.metrosCuadrados)
				&& numVentanas == other.numVentanas && Objects.equals(uso, other.uso);
	}

	@Override
	public String toString() {
		return "Habitacion [uso=" + uso + ", metrosCuadrados=" + metrosCuadrados + ", numVentanas=" + numVentanas + "]";
	}
	
	
	
	

}
