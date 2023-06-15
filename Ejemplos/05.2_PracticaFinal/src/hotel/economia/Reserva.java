package hotel.economia;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

import hotel.habitaciones.Habitacion;
import hotel.personas.Cliente;
import hotel.personas.Huesped;

public class Reserva implements Cobrable {
	
	private LocalDate fechaInicio;
	private int numeroDias;
	private Cliente cliente;
	private Huesped[] huesped;
	private Habitacion habitacion;
	
	
	public Reserva(LocalDate fechaInicio, int numeroDias, Cliente cliente, Huesped[] huesped, Habitacion habitacion) {
		this.fechaInicio = fechaInicio;
		this.numeroDias = numeroDias;
		this.cliente = cliente;
		this.huesped = huesped;
		this.habitacion = habitacion;
	}

	
	

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}




	public int getNumeroDias() {
		return numeroDias;
	}




	public Cliente getCliente() {
		return cliente;
	}




	public Huesped[] getHuesped() {
		return huesped;
	}




	public Habitacion getHabitacion() {
		return habitacion;
	}




	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}




	public void setNumeroDias(int numeroDias) {
		this.numeroDias = numeroDias;
	}




	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}




	public void setHuesped(Huesped[] huesped) {
		this.huesped = huesped;
	}




	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}



	public LocalDate getFechaFin() {
		return fechaInicio.plusDays(numeroDias);
	}
	

	@Override
	public double getImporte() {
		return habitacion.getPrecio() * numeroDias;
	}
	




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(huesped);
		result = prime * result + Objects.hash(cliente, fechaInicio, habitacion, numeroDias);
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaInicio, other.fechaInicio)
				&& Objects.equals(habitacion, other.habitacion) && Arrays.equals(huesped, other.huesped)
				&& numeroDias == other.numeroDias;
	}




	@Override
	public String toString() {
		return "Reserva [fechaInicio=" + fechaInicio + ", numeroDias=" + numeroDias + ", cliente=" + cliente
				+ ", huesped=" + Arrays.toString(huesped) + ", habitacion=" + habitacion + "]";
	}
	
	

}
