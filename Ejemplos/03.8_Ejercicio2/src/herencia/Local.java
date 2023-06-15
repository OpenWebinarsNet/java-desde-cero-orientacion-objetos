package herencia;

import java.util.Objects;

public final class Local extends Inmueble {
	
	private boolean tieneSalidaHumos;
	private double porcentajePlusvalia;

	
	public Local() { }
	
	

	public Local(int identificadorInmobiliario, String direccion, double precioBase, double metrosCuadrados,
			boolean tieneSalidaHumos, double porcentajePlusvalia) {
		super(identificadorInmobiliario, direccion, precioBase, metrosCuadrados);
		this.tieneSalidaHumos = tieneSalidaHumos;
		this.porcentajePlusvalia = porcentajePlusvalia;
	}



	public boolean isTieneSalidaHumos() {
		return tieneSalidaHumos;
	}

	public void setTieneSalidaHumos(boolean tieneSalidaHumos) {
		this.tieneSalidaHumos = tieneSalidaHumos;
	}

	public double getPorcentajePlusvalia() {
		return porcentajePlusvalia;
	}

	public void setPorcentajePlusvalia(double porcentajePlusvalia) {
		this.porcentajePlusvalia = porcentajePlusvalia;
	}

	@Override
	public double precioVentaFinal() {
		// El % está expresado entre 0 y 1
		return this.precioBase * (1 + this.porcentajePlusvalia);
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
				+ identificadorInmobiliario + ", direccion=" + direccion + ", precioVenta=" + precioBase
				+ ", metrosCuadrados=" + metrosCuadrados + "]";
	}

	
	
	
	
	
	
	

}
