package herencia;

import java.util.Objects;

public abstract sealed class Inmueble permits Local, InmuebleVivienda {
	
	protected int identificadorInmobiliario;
	protected String direccion;
	protected double precioVenta;
	protected double metrosCuadrados;
	
	public Inmueble() { }
	
	public Inmueble(int identificadorInmobiliario, String direccion, double precioVenta, double metrosCuadrados) {
		this.identificadorInmobiliario = identificadorInmobiliario;
		this.direccion = direccion;
		this.precioVenta = precioVenta;
		this.metrosCuadrados = metrosCuadrados;
	}

	public int getIdentificadorInmobiliario() {
		return identificadorInmobiliario;
	}

	public String getDireccion() {
		return direccion;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public double getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setIdentificadorInmobiliario(int identificadorInmobiliario) {
		this.identificadorInmobiliario = identificadorInmobiliario;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public void setMetrosCuadrados(double metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	@Override
	public int hashCode() {
		return Objects.hash(direccion, identificadorInmobiliario, metrosCuadrados, precioVenta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inmueble other = (Inmueble) obj;
		return Objects.equals(direccion, other.direccion)
				&& identificadorInmobiliario == other.identificadorInmobiliario
				&& Double.doubleToLongBits(metrosCuadrados) == Double.doubleToLongBits(other.metrosCuadrados)
				&& Double.doubleToLongBits(precioVenta) == Double.doubleToLongBits(other.precioVenta);
	}

	@Override
	public String toString() {
		return "Inmueble [identificadorInmobiliario=" + identificadorInmobiliario + ", direccion=" + direccion
				+ ", precioVenta=" + precioVenta + ", metrosCuadrados=" + metrosCuadrados + "]";
	}
	
	
	
	
	

}
