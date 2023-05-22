package herencia;

import java.util.Objects;

public final class Local extends Inmueble {
	
	private boolean tieneSalidaHumos;

	
	public Local() { }
	
	public Local(int identificadorInmobiliario, String direccion, double precioVenta, double metrosCuadrados,
			boolean tieneSalidaHumos) {
		super(identificadorInmobiliario, direccion, precioVenta, metrosCuadrados);
		this.tieneSalidaHumos = tieneSalidaHumos;
	}

	public boolean isTieneSalidaHumos() {
		return tieneSalidaHumos;
	}

	public void setTieneSalidaHumos(boolean tieneSalidaHumos) {
		this.tieneSalidaHumos = tieneSalidaHumos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(tieneSalidaHumos);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Local other = (Local) obj;
		return tieneSalidaHumos == other.tieneSalidaHumos;
	}

	@Override
	public String toString() {
		return "Local [tieneSalidaHumos=" + tieneSalidaHumos + ", identificadorInmobiliario="
				+ identificadorInmobiliario + ", direccion=" + direccion + ", precioVenta=" + precioVenta
				+ ", metrosCuadrados=" + metrosCuadrados + "]";
	}

	
	
	
	
	
	
	

}
