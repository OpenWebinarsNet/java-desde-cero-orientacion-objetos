package disenioclases;

public class Rectangulo {
	
	private final int COORD_X = 0;
	private final int COORD_Y = 1;
	
	private double[] c1, c2, c3, c4;

	public Rectangulo() {
		c1 = new double[2];
		c2 = new double[2];
		c3 = new double[2];
		c4 = new double[2];
	}
	
	
	public Rectangulo(double[] c1, double[] c2, double[] c3, double[] c4) {
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
		this.c4 = c4;
	}
	
	public Rectangulo(int base, int altura) {
		this.c1 = new double[] {0,0};
		this.c2 = new double[] {base, 0};
		this.c3 = new double[] {base, altura};
		this.c4 = new double[] {0, altura};
	}


	public double base() {
		return Math.abs(c3[COORD_X] - c4[COORD_X]);
	}

	public double altura() {
		return Math.abs(c3[COORD_Y] - c2[COORD_Y]);
	}
	



}
