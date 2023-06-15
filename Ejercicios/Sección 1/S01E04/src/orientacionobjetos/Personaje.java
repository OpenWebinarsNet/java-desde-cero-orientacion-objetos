package orientacionobjetos;

import java.util.Arrays;
import java.util.Objects;

public class Personaje {
	
	private String nombre;
	private int puntosVida;
	private long puntos;
	private String[] mochila;
	private int elementosEnMochila;
	
	public Personaje() {
		this.puntos = 0;
		this.puntosVida = 100;
		this.mochila = new String[10];
		this.elementosEnMochila = 0;
	}
	
	public Personaje(String nombre) {
		this();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntosVida() {
		return puntosVida;
	}

	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}

	public long getPuntos() {
		return puntos;
	}

	public void setPuntos(long puntos) {
		this.puntos = puntos;
	}

	public String[] getMochila() {
		return mochila;
	}
	
	public int getElementosEnMochila() {
		return elementosEnMochila;
	}
	
	public int addElementoToMochila(String elemento) {
		if (elementosEnMochila == 10)
			System.out.println("YA NO PUEDES CONSEGUIR MÁS ELEMENTOS PUES TU MOCHILA ESTÁ COMPLETA");
		else 
			mochila[elementosEnMochila] = elemento;
		
		return ++elementosEnMochila;
		
	}
	
	public int recibirGolpe(int puntosGolpe) {
		this.puntosVida -= puntosGolpe;
		if (this.puntosVida < 0)
			this.puntosVida = 0;
		
		return this.puntosVida;
	}
	
	// Falta reasignar el array y decrementar elementosEnMochila
	
	public int usarBotiquin() {
		boolean tieneBotiquin = false;
		if (elementosEnMochila > 0) {
			
			for(int i = 0; i < elementosEnMochila && !tieneBotiquin; i++) {
				if (mochila[i] == "BOTIQUIN") {
					tieneBotiquin = true;
					this.puntosVida += 10;
					if (this.puntosVida > 100)
						this.puntosVida = 100;
					
					// Reasignar resto de elementos del array
					mochila[i] = null;
					for(int x = i+1; x < elementosEnMochila; x++) {
						mochila[x-1] = mochila[x];
					}
					elementosEnMochila--;
					mochila[elementosEnMochila] = null;
					
				}
			}
		}
		
		if (tieneBotiquin == false)
			System.out.println("LO SIENTO, PERO NO TIENES NINGUNA POCIÓN DE BOTIQUÍN");
		
		return this.puntosVida;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(mochila);
		result = prime * result + Objects.hash(elementosEnMochila, nombre, puntos, puntosVida);
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
		Personaje other = (Personaje) obj;
		return elementosEnMochila == other.elementosEnMochila && Arrays.equals(mochila, other.mochila)
				&& Objects.equals(nombre, other.nombre) && puntos == other.puntos && puntosVida == other.puntosVida;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", puntosVida=" + puntosVida + ", puntos=" + puntos + ", mochila="
				+ Arrays.toString(mochila) + ", elementosEnMochila=" + elementosEnMochila + "]";
	}
	
	

}
